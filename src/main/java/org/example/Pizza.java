package org.example;

import java.util.List;

public class Pizza {

    private String tamanho;

    private List<String> sabores;

    public Pizza(String tamanho, List<String> sabores) {
        this.tamanho = tamanho;
        this.sabores = sabores;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public List<String> getSabores() {
        return sabores;
    }

    public void setSabores(List<String> sabores) {
        this.sabores = sabores;
    }
}
