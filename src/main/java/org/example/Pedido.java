package org.example;

import java.util.List;

public class Pedido {

    private List<String> ordens;

    private Cliente cliente;

    private boolean emAndamento;

    public List<String> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<String> ordens) {
        this.ordens = ordens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEmAndamento() {
        return emAndamento;
    }

    public void setEmAndamento(boolean emAndamento) {
        this.emAndamento = emAndamento;
    }
}
