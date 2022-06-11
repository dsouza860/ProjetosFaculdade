package banco;

import java.util.Scanner;

public class Cliente {
	Scanner ler = new Scanner(System.in);
	private String nome;
	private int numeroConta;
	private double saldo;
	private double limite;
	private static int auxConta;
	
	public Cliente(String nome) {
		this.nome = nome;
		this.saldo = 0;
		this.limite = 0;
		this.numeroConta = gerarNumeroConta();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public int getAuxConta() {
		return auxConta;
	}
	public void setAuxConta(int auxConta) {
		this.auxConta = auxConta;
	}
	public void exibirDados() {
		System.out.println("\nConta: " + getNumeroConta());
		System.out.println("Nome: " + getNome());
		System.out.println("Saldo: " + getSaldo());
		if(getSaldo() > 0) {
			System.out.println("Saldo Positivo");
		}else if(getSaldo() < 0) {
			System.out.println("Saldo Negativo");
		}else {
			System.out.println("Status: Normal");
		}
		System.out.println("Limite: " + verificarLimite(getSaldo()));
	}
	public void sacar() {
		double valor;
		do {
			System.out.print("\nQuanto deseja Sacar: ");
			valor = ler.nextDouble();
			if(valor <= 0) {
				System.out.println("\nSaldo Insuficiente\n");
			}
		}while(valor <= 0);
		
		if(valor <= getSaldo()) {
			setSaldo(getSaldo() - valor);
			System.out.println("\nSaldo realizado com sucesso");
		}else {
			System.out.println("\nvalor invalido\n");
		}
	}
	public void depositar() {
		double valor;
		do {
			System.out.print("\nQuanto deseja Depositar: ");
			valor = ler.nextDouble();
			if(valor <= 0) {
				System.out.println("\nNão permitido depositar valor negativo\n");
			}
		}while(valor <= 0);
		
		setSaldo(getSaldo() + valor);
		verificarLimite(getLimite());
		System.out.println("\nDeposito Realizado com sucesso");
	}
	private double verificarLimite(double saldoAtualizado) {
		if(getSaldo() <= 2000) {
			return saldoAtualizado * 0.3;
		}else if(getSaldo() <= 5000) {
			return saldoAtualizado * 0.5;
		}else {
			return saldoAtualizado * 0.7;
		}
	}
	private static int gerarNumeroConta() {
		return ++auxConta;  
	}
}
