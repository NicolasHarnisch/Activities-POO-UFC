class Eletronico extends ProdutoFisico{
	
	String marca;
	String modelo;
	double voltagem;
	int garantia_meses;
	
	Eletronico(int id_produto, String nome, String descricao, double preco_base, int estoque, String marca, String modelo, double voltagem, int garantia_meses) {
		super(id_produto, nome, descricao, preco_base, estoque);
		this.marca = marca;
		this.modelo = modelo;
		this.voltagem = voltagem;
		this.garantia_meses = garantia_meses;
	}
	
	@Override
	void exibir_detalhes() {
		super.exibir_detalhes();
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Voltagem: " + voltagem + "V");
		System.out.println("Garantia: " + garantia_meses + " meses");
	}
	
	@Override
	double calcular_preco_final(double desconto_percentual){
		if(desconto_percentual > 10) {
			desconto_percentual = 10;
		}
		return preco_base - (desconto_percentual / 100) * preco_base;
	}
	
}




