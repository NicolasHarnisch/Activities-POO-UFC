class ProdutoFisico extends Produto{
	
	int estoque;

	ProdutoFisico(int id_produto, String nome, String descricao, double preco_base, int estoque) {
		super(id_produto, nome, descricao, preco_base);
		this.estoque = estoque;
	}
	
	@Override
	void exibir_detalhes() {
		super.exibir_detalhes();
		System.out.println("Estoque: " + estoque);
	}
	
	@Override
	boolean verificar_disponibilidade() {
		if(estoque > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
