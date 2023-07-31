import banco.Banco;
import cliente.Cliente;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.IConta;

import java.util.Scanner;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		//cadastramento de um banco e algumas contas
		Cliente alberto = new Cliente("Alberto","12345","12345");
		Cliente renata = new Cliente("Renata","12345","54321");
		Cliente gabriel = new Cliente("Gabriel","12345","00000");

		Banco banco = null;
		List<Conta> contasACadastrar = null;

		contasACadastrar.add( new ContaCorrente(alberto));
		contasACadastrar.add( new ContaCorrente(renata));
		contasACadastrar.add(  new ContaPoupanca(gabriel));

		banco  = banco.CriaBanco(contasACadastrar);

		//simulação de terminal bancario
		Scanner terminal = new Scanner( System.in );
		System.out.println("Simulando um terminal bancário");
		System.out.println("Digite o nome de usuário : " );
		String nome = terminal.nextLine();
		System.out.println("Digite a senha : " );
		String senha =terminal.nextLine();
		for(Conta contaProcurada : banco.getContas() ){
			if(contaProcurada.getCliente().getNome().equalsIgnoreCase( nome ) && contaProcurada.getCliente().getSenha().equals( senha )){
				Conta contaEncontrada = contaProcurada;
				System.out.printf("Bem vindo &s ",contaEncontrada.getCliente().getNome()  );
				realizarOperacoes(contaEncontrada,terminal,banco);
			}
		}
		System.out.printf("Obrigado da %s por utilizar nossos serviços", banco.getNome() );

	}
	public static void realizarOperacoes(Conta conta,Scanner terminal,Banco banco){
		int opcao;
		do
		{
			System.out.printf( "Selecione uma opcao : \n 1- sacar \n 2- depositar \n 3- transferir \n 4- imprimir extrato \n 0- sair" );
			opcao = terminal.nextInt( );
			switch( opcao)
			{
				case (1):
					System.out.println("Digite a quantidade que deseja sacar");
					conta.sacar( terminal.nextFloat() );
					break;
				case(2):
					System.out.println("Digite a quantidade que deseja depositar");
					conta.depositar( terminal.nextFloat() );
					break;
				case(3):
					System.out.println("Digite a quantidade que deseja transferir");

					float transferencia =  terminal.nextFloat();

					System.out.println("Digite a conta que deseja transferir");
					String contaParaBuscar = terminal.nextLine();
					Conta contaParaTransferir = banco.findConta( contaParaBuscar );
					if(contaParaTransferir!= null)
						conta.transferir( transferencia,contaParaTransferir );
					break;
				case(4):
					conta.imprimirExtrato();

					break;
				default:
					System.out.println("Opcao inválida");
					opcao = 0;
					break;
			}

		} while(opcao != 0);
		System.out.println("Operacoes Encerradas" );

	}


}
