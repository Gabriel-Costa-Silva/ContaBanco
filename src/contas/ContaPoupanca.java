package contas;

import cliente.Cliente;

public class ContaPoupanca extends Conta {

	public ContaPoupanca( Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato contas.Conta Poupanca ===");
		super.imprimirInfosComuns();
	}
}
