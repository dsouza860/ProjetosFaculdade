package banco;

import java.util.Scanner;

public class NovoCliente {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in); 
		String nome;
		System.out.print("Cliente: ");
		nome = ler.nextLine();
		Cliente novo = new Cliente(nome);
		novo.exibirDados();
		novo.depositar();
		novo.exibirDados();
		novo.sacar();
		novo.exibirDados();
	}
}
