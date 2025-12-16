class ContaBancaria {
	
	int numero;
	int agencia;
	double saldo;
	Pessoa titular;
	
	ContaBancaria(int numero, int agencia, double saldo, String nome, String cpf, int idade){
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.titular = new Pessoa(nome, cpf, idade);
	}
	
	void consultarSaldo() {
		System.out.println("Conta: " + numero + " Agencia: " + agencia + " Titular: " + titular.nome + " Saldo: " + this.saldo);
	}
	
	boolean sacar(double valor) {
		if(valor > this.saldo || valor <= 0) {
			System.out.println("Saldo Insuficiente ou Valor Invalido");
			return false;
		}else {
			this.saldo -= valor;
			return true;
		}
	}
	
	boolean depositar(double valor) {
		if(valor <= 0) {
			System.out.println("Valor Invalido");
			return false;
		}else {
			this.saldo += valor;
			return true;
		}
	}
	
	boolean transferir(ContaBancaria conta, double valor){
		if(this.sacar(valor)) {
			conta.depositar(valor);
			return true;
		}else {
			return false;
		}
	}

}
