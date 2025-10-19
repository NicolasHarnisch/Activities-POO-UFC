class Produto {
	
	int id_produto; 
	String nome;
	String descricao;
	double preco_base;
	
	Produto(int id_produto, String nome, String descricao, double preco_base) {
		this.id_produto = id_produto;
		this.nome = nome;
		this.descricao = descricao;
		this.preco_base = preco_base;
	}
	
	void exibir_detalhes() {
		System.out.println("id: " + id_produto);
		System.out.println("Nome: " + nome);
		System.out.println("Descricao: " + descricao);
		System.out.println("Preço Base: " + preco_base);
	}
	
	boolean verificar_disponibilidade() {
		return true;
	}
	
	double calcular_preco_final(double desconto_percentual){
		return preco_base - (desconto_percentual / 100) * preco_base;
	}
}
