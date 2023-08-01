package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cliente> cadatrados = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        int ndp = 0;
        Scanner ler = new Scanner(System.in);
        int index;
        int opc = 0;

        while(opc != 8)
        {
            System.out.println("1 - Cadastrar um cliente");
            System.out.println("2 - Buscar um cliente");
            System.out.println("3 - Registrar um pedido");
            System.out.println("4 - Finalizar um pedido");
            System.out.println("5 - Imprimir todos pedidos");
            System.out.println("6 - Imprimir pedidos encerrados");
            System.out.println("7 - Imprimir pedidos em andamento");
            System.out.println("8 - Sair");
            opc = ler.nextInt();

            switch (opc){
                case 1:
                    Cliente cliente = cadastrar();
                    cadatrados.add(cliente);
                    break;

                case 2:
                    index = exibir(cadatrados);
                    if(index > -1)
                    {
                        alterarCliente(cadatrados.get(index));
                    }
                    break;

                case 3:
                    List<Pizza> pizzas = realizarPedido();
                    index = exibir(cadatrados);
                    if(index > -1)
                    {
                        pedidos.add(new Pedido(ndp, pizzas, cadatrados.get(index), true));
                    }
                    ndp += 1;
                    break;

                case 4:
                    break;

                case 5:
                    todos(pedidos);
                    break;

                case 6:
                    encerrados(pedidos);
                    break;

                case 7:
                    andamento(pedidos);
                    break;

                case 8:
                    break;

                default:
                    System.out.println("Opção invalida");
            }



        }
    }

    public static Cliente cadastrar(){

        Scanner ler = new Scanner(System.in);
        String nome;
        String rua;
        String cpf;
        int numero;
        int opc = 1;

        List<Endereco> enderecos = new ArrayList<>();
        System.out.println("Digite o nome");
        nome = ler.next();
        System.out.println("Digite o cpf");
        cpf = ler.next();
        while(opc != 2)
        {
            System.out.println("Digite a rua do endereço");
            rua = ler.next();
            System.out.println("Digite o numero do endereço");
            numero = ler.nextInt();
            enderecos.add(new Endereco(numero,rua));
            System.out.println("Adicionar mais um endereço? 1-Sim  2-Não");
            opc = ler.nextInt();
        }

        return new Cliente(nome, cpf, enderecos);
    }

    public static int exibir(List<Cliente> clientes)
    {
        String cpf;
        int i;
        boolean achou = false;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o CPF");
        cpf = ler.next();

        for(i=0;i<clientes.size();i++)
        {
            if(clientes.get(i).getCpf().equals(cpf))
            {
                System.out.println("Nome: " + clientes.get(i).getNome() + " - CPF: " + clientes.get(i).getCpf());
                for(Endereco j : clientes.get(i).getEnderecos())
                {
                    System.out.println("Numero: " + j.getNumero() + " - Rua: " + j.getRua());
                }
                achou = true;
                break;
            }
        }
        if(!achou)
        {
            System.out.println("Cliente não encontrado");
            return -1;
        }

        return i;

    }

    public static void alterarCliente(Cliente cliente)
    {
        Scanner ler = new Scanner(System.in);
        int opc, opcEd;
        String nome;
        String cpf;
        System.out.println("Deseja alterar alguma informação deste cliente? 1-Sim  2-Não");
        opc = ler.nextInt();

        if(opc == 1)
        {
            System.out.println("Digite o nome");
            nome = ler.next();
            System.out.println("Digite o cpf");
            cpf = ler.next();
            System.out.println("Deseja alterar endereços? 1-Sim  2-Não");
            opcEd = ler.nextInt();

            if(opcEd == 1)
            {
                List<Endereco> enderecosModificados = alterarEnderecos(cliente.getEnderecos());
                cliente.setEnderecos(enderecosModificados);
            }


            cliente.setNome(nome);
            cliente.setCpf(cpf);
        }
    }

    public static List<Endereco> alterarEnderecos(List<Endereco> enderecos)
    {
        Scanner ler = new Scanner(System.in);
        int opc = 0;
        int index;
        String rua;
        int numero;

        while(opc != 3)
        {
            System.out.println("1-Adicionar novo endereço");
            System.out.println("2-Remover endereço");
            System.out.println("3-Sair");
            opc = ler.nextInt();

            switch (opc){
                case 1:
                    System.out.println("Digite a rua do endereço");
                    rua = ler.next();
                    System.out.println("Digite o numero do endereço");
                    numero = ler.nextInt();
                    enderecos.add(new Endereco(numero,rua));
                    break;

                case 2:
                    for(int i = 0;i<enderecos.size();i++)
                    {
                        System.out.println((i+1) + "-" + " Rua: " + enderecos.get(i).getRua() + " - Numero: " + enderecos.get(i).getNumero());
                    }
                    System.out.println("Digite a opção do endereço que deseja remover");
                    index = ler.nextInt();
                    if( (index-1) > -1 && (index-1) < (enderecos.size()-1) )
                    {
                        enderecos.remove((index-1));
                    }
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Opção invalida");
            }
        }
        return enderecos;
    }

    public static List<Pizza> realizarPedido(){
        List<Pizza> pizzas = new ArrayList<>();
        String[] tamanhos = {"Pequena", "Media", "Grande"};
        Scanner ler = new Scanner(System.in);
        int opc;
        int sair = 1;
        while (sair != 2)
        {
            System.out.println("Escolha o tamanho da pizza");
            System.out.println("1-Pequena");
            System.out.println("2-Media");
            System.out.println("3-Grande");
            opc = ler.nextInt();

            List<String> sabores = escolherSabores();
            pizzas.add(new Pizza(tamanhos[opc-1], sabores));

            System.out.println("Montar outra pizza? 1-Sim  2-Não");
            sair = ler.nextInt();

        }

        return pizzas;
    }

    public static List<String> escolherSabores(){
        List<String> sabores = new ArrayList<>();
        String[] opcoes = {"Calabresa", "Frango", "Queijo", "Milho"};
        Scanner ler = new Scanner(System.in);
        int opc;
        int sair = 1;

        while (sair != 2)
        {
            System.out.println("Escolha o tamanho da pizza");
            System.out.println("1-Calabresa");
            System.out.println("2-Frango");
            System.out.println("3-Queijo");
            System.out.println("4-Milho");
            opc = ler.nextInt();

            sabores.add(opcoes[opc-1]);

            System.out.println("Escolher outro sabor? 1-Sim  2-Não");
            sair = ler.nextInt();
        }

        return sabores;
    }

    public static void todos(List<Pedido> pedidos)
    {
        for(Pedido i : pedidos)
        {
            System.out.println("Numero do pedido: " + i.getNumeroPedido());
            System.out.println("Cliente: " + i.getCliente().getNome());
            if(i.isEmAndamento())
            {
                System.out.println("Status: Em Andamento");
            }
            else
            {
                System.out.println("Status: Encerrado");
            }
            System.out.println("Pizzas");
            for(Pizza j : i.getOrdens())
            {
                System.out.println("Tamanho: ");
                System.out.println("Sabores: ");
                for (String y : j.getSabores())
                {
                    System.out.print(y + " ");
                }
            }

        }
    }

    public static void encerrados(List<Pedido> pedidos)
    {
        for(Pedido i : pedidos)
        {
            if(!i.isEmAndamento())
            {

                System.out.println("Numero do pedido: " + i.getNumeroPedido());
                System.out.println("Cliente: " + i.getCliente().getNome());

                System.out.println("Status: Encerrado");

                System.out.println("Pizzas");
                for(Pizza j : i.getOrdens())
                {
                    System.out.println("Tamanho: ");
                    System.out.println("Sabores: ");
                    for (String y : j.getSabores())
                    {
                        System.out.print(y + " ");
                    }
                }
            }
        }
    }

    public static void andamento(List<Pedido> pedidos)
    {
        for(Pedido i : pedidos)
        {
            if(i.isEmAndamento())
            {

                System.out.println("Numero do pedido: " + i.getNumeroPedido());
                System.out.println("Cliente: " + i.getCliente().getNome());

                System.out.println("Status: Em Andamento");

                System.out.println("Pizzas");
                for(Pizza j : i.getOrdens())
                {
                    System.out.println("Tamanho: ");
                    System.out.println("Sabores: ");
                    for (String y : j.getSabores())
                    {
                        System.out.print(y + " ");
                    }
                }
            }

        }

    }

    public static void finalizar(List<Pedido> pedidos)
    {
        Scanner ler = new Scanner(System.in);
        int index;
        andamento(pedidos);
        System.out.println("Digite o numero do pedido que deseja finalizar");
        index = ler.nextInt();
        if(index > -1 && index < pedidos.size() && pedidos.get(index).isEmAndamento())
        {
            pedidos.get(index).setEmAndamento(false);
            criaTxt(pedidos.get(index));
        }
        else
        {
            System.out.println("Pedido não existe ou já foi encerrado");
        }

    }

    public static void criaTxt(Pedido pedido)
    {

    }
    


}