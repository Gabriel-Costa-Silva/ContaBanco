package banco;

import contas.Conta;

import java.util.List;

public class Banco {
	private final String NOME_BANCO_PADRAO = "BANCO PANCO";

	private String nome;
	private List<Conta> contas;


	public Banco CriaBanco(List<Conta> contasACadastrar){
		return new Banco(NOME_BANCO_PADRAO, contasACadastrar);

	}
	public Banco( String nome, List<Conta> contasACadastrar )
	{
		setNome(nome);
		setContas( contasACadastrar );
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public Conta findConta(String numeroConta){
		for(Conta conta: getContas() ){
			if(conta.getNumero()==Integer.parseInt(  numeroConta))
				return conta;
		}
		return null;
	}

}
