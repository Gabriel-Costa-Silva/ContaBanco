package contas;

import cliente.Cliente;

public class ContaCorrente extends Conta {

	public ContaCorrente( Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato contas.Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}
