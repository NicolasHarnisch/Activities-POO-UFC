class Ebook extends ProdutoDigital{
	
	String autor;
	String editora;
	String formato_arquivo;
	double tamanho_mb;
	
	Ebook(int id_produto, String nome, String descricao, double preco_base, String autor, String editora, String formato_arquivo, double tamanho_mb) {
		super(id_produto, nome, descricao, preco_base);
		this.autor = autor;
		this.editora = editora;
		this.formato_arquivo = formato_arquivo;
		this.tamanho_mb = tamanho_mb;
	}
	
	@Override
	void exibir_detalhes() {
		super.exibir_detalhes();
		System.out.println("Autor: " + autor);
		System.out.println("Editora: " + editora);
		System.out.println("Formato: " + formato_arquivo);
		System.out.println("Tamanho: " + tamanho_mb + "MB");
	}
	
}
