package com.example.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pessoa {

    @ApiModelProperty(value = "Identificador da pessoa")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "Nome da pessoa")
    @NonNull
    private String nome;

    @ApiModelProperty(value = "Sexo da pessoa (M ou F)")
    private String sexo;

    @ApiModelProperty(value = "Email da pessoa")
    @Email(regexp = ".*@.*\\..*", message = "Email nao esta valido")
    private String email;

    @ApiModelProperty(value = "Data de nascimento da pessoa")
    @Column(name = "data_nascimento")
    private String dataNascimento;

    @ApiModelProperty(value = "Cidade de naturalidade da pessoa")
    private String naturalidade;

    @ApiModelProperty(value = "Nacionalidade da pessoa")
    private String nacionalidade;

    @ApiModelProperty(value = "CPF da pessoa (Unico)")
    @CPF(message = "O CPF nao esta valido")
    private String cpf;

    @ApiModelProperty(value = "Data de alteracao do cadastro da pessoa")
    @Column(name = "atualizado", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Timestamp atualizado;
}