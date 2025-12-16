class Livro extends ProdutoFisico{
	
	String autor;
	String editora;
	int numero_paginas;
	double peso_gramas;
	
	Livro(int id_produto, String nome, String descricao, double preco_base, int estoque, String autor, String editora, int numero_paginas, double peso_gramas) {
		super(id_produto, nome, descricao, preco_base, estoque);
		this.autor = autor;
		this.editora = editora;
		this.numero_paginas = numero_paginas;
		this.peso_gramas = peso_gramas;
	}
	
	@Override
	void exibir_detalhes() {
		super.exibir_detalhes();
		System.out.println("Autor: " + autor);
		System.out.println("Editora: " + editora);
		System.out.println("Numero Paginas: " + numero_paginas);
		System.out.println("Peso: " + peso_gramas + "g");
	}
}
