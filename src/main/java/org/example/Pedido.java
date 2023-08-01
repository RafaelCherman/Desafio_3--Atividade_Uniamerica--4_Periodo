package org.example;

import java.util.List;

public class Pedido {

    private int numeroPedido;
    private List<Pizza> ordens;

    private Cliente cliente;

    private boolean emAndamento;

    private Endereco enderecoEntrega;

    public Pedido(int numeroPedido, List<Pizza> ordens, Cliente cliente, boolean emAndamento) {
        this.numeroPedido = numeroPedido;
        this.ordens = ordens;
        this.cliente = cliente;
        this.emAndamento = emAndamento;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public List<Pizza> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Pizza> ordens) {
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

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
}
