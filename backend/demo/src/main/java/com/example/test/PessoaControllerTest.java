package com.example.test;

import com.example.model.Pessoa;
import com.example.test.AbstractTest;
import com.example.utils.Utils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PessoaControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getAllPessoas() throws Exception {
        String uri = "/pessoas";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Pessoa[] pessoasList = super.mapFromJson(content, Pessoa[].class);
        assertTrue(pessoasList.length > 0);
    }

    @Test
    public void getPessoasByName() throws Exception {
        String name = "Leonardo";
        String uri = "/pessoas/findByName/" + name;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Pessoa[] pessoasList = super.mapFromJson(content, Pessoa[].class);
        assertTrue(pessoasList.length > 0);
    }

    @Test
    public void createPessoa() throws Exception {
        String uri = "/pessoas";
        Pessoa pessoa = new Pessoa();
        pessoa.setId(11);
        pessoa.setNome("Geovane Ferreira Melo");
        pessoa.setCpf(Utils.geraCPF());
        pessoa.setEmail("geovane_ferreira_melo@gmail.com");
        pessoa.setSexo("M");
        pessoa.setDataNascimento(LocalDate.now().toString());
        pessoa.setNaturalidade("Florianopolis");
        pessoa.setNacionalidade("Brasileiro");
        String inputJson = super.mapToJson(pessoa);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

    @Test
    public void updatePessoa() throws Exception {
        String uri = "/pessoas/2";
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Liandra Borges");
        pessoa.setCpf("345.128.020-53");
        pessoa.setSexo("F");
        pessoa.setEmail("liandra_borges@gmail.com");
        pessoa.setDataNascimento(LocalDate.now().toString());
        pessoa.setNacionalidade("Brasileira");
        pessoa.setNaturalidade("Curitiba");
        String inputJson = super.mapToJson(pessoa);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void deletePessoa() throws Exception {
        String uri = "/pessoas/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}