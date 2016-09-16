package com.everton.raulgil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // para receber a opção do operador
        char opcao;

        // String para exibir o menu de opções ao operador
        String menu = "\nC - Adicionar um calouro\n" +
                "J - Adicionar um jurado\n" +
                "P - Cadastrar Apresentação\n" +
                "L - Listar Calouros\n" +
                "M - Média Geral do Programa\n" +
                "V - Mostrar vencedores\n" +
                "S - Sair\n";

        // Objeto para entrada de dados
        InputStreamReader leitorTeclado = new InputStreamReader(System.in);
        BufferedReader entrada = new BufferedReader(leitorTeclado);

        ShowDeCalouros s = new ShowDeCalouros();

        while(true) {
            try {
                System.out.println("\n## PROGRAMA RAUL GIL - Show de Calouros ##");
                System.out.println(menu);                               // exibir menu
                System.out.print("selecione uma opção:");
                opcao = entrada.readLine()
                        .toUpperCase().trim().charAt(0);               // ler opção digitada

                if(opcao == 'C') {
                    // cadastrar calouro
                    Calouro c = new Calouro();
                    System.out.println("Dados do Calouro: ");

                    System.out.print("Nome: ");
                    c.setNome(entrada.readLine());

                    System.out.print("\nCPF: ");
                    c.setCpf(entrada.readLine());

                    s.addCalouro(c);

                } else if(opcao == 'J') {
                    // cadastrar jurado
                    Jurado j = new Jurado();
                    System.out.println("Dados do Jurado: ");

                    System.out.print("Nome: ");
                    j.setNome(entrada.readLine());

                    System.out.print("Data de Nascimento [dd/mm/yyyy]: ");
                    j.setDataNasc(LocalDate.parse(entrada.readLine()));

                    s.addJurado(j);

                } else if(opcao == 'P') {
                    // cadastrar apresentação para o calouro

                } else if(opcao == 'L') {
                    // listar calouros

                } else if(opcao == 'M') {
                    // media geral do programa
                } else if(opcao == 'V') {
                    // vencedores
                } else if(opcao == 'S') {
                    // sair do programa
                    System.out.println("That's all folks!!!");
                    break;
                } else {
                    System.out.println("Opção inválida!");
                }

            } catch (IOException err) {
                System.out.println(err.getMessage());
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        } // loop infinito

    }
}
