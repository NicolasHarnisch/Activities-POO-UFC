class Vestuario extends ProdutoFisico{
	
	String marca;
	String tamanho;
	String cor;
	String tecido;
	
	Vestuario(int id_produto, String nome, String descricao, double preco_base, int estoque, String marca, String tamanho, String cor, String tecido) {
		super(id_produto, nome, descricao, preco_base, estoque);
		this.marca = marca;
		this.tamanho = tamanho;
		this.cor = cor;
		this.tecido = tecido;
	}
	
	@Override
	void exibir_detalhes() {
		super.exibir_detalhes();
		System.out.println("Marca: " + marca);
		System.out.println("Tamanho: " + tamanho);
		System.out.println("Cor: " + cor);
		System.out.println("Tecido: " + tecido);
	}
	
}
