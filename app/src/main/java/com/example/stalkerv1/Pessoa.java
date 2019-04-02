package com.example.stalkerv1;

import android.provider.ContactsContract;

import java.util.ArrayList;


public class Pessoa {
    private String nome;
    private String emprego;
    private String dtnascimento;
    private String telefone;
    private String descricao;

    public Pessoa(String nome, String emprego, String dtnascimento, String telefone, String descricao) {
        this.nome = nome;
        this.emprego = emprego;
        this.dtnascimento = dtnascimento;
        this.telefone = telefone;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmprego() {
        return emprego;
    }

    public void setEmprego(String emprego) {
        this.emprego = emprego;
    }

    public String getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(String dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
