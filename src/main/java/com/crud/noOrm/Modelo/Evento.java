package com.crud.noOrm.Modelo;

import java.time.LocalDate;

public class Evento {
    
    private Long id;
    private String nome;
    private LocalDate data;

    public Evento() {
    }

    public Evento(Long id, String nome, LocalDate data) {
        this.id = id;
        this.nome = nome;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
