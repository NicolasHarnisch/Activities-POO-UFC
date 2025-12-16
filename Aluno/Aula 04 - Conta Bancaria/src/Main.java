public class Main {

	public static void main(String[] args) {
		ContaBancaria conta1 = new ContaBancaria(123, 10, 0, "José Robertty", "123.456.789-00", 27);
		ContaBancaria conta2 = new ContaBancaria(121, 10, 100, "Mikael", "234.567.123-75", 19);
		
		conta1.consultarSaldo();
		conta1.depositar(300);
		conta1.consultarSaldo();
		conta1.sacar(123.50);	
		conta1.consultarSaldo();
		conta1.sacar(300);
		conta1.sacar(-10);
		conta1.transferir(conta2, 100);
		conta1.consultarSaldo();
		conta2.consultarSaldo();
	}

}
