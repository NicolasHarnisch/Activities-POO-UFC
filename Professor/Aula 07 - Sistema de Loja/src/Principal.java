public class Principal {

	public static void main(String[] args) {
		Eletronico e1 = new Eletronico(1, "TV", "Smart TV Android", 1800, 0, "LG", "LG-1", 220, 24);
		
		e1.exibir_detalhes();
		System.out.println(e1.verificar_disponibilidade());
		System.out.println(e1.calcular_preco_final(30));
		
		Livro l1 = new Livro(2, "Algoritmos: Teoria e Pratica", "Algoritmos e Estrutura de Dados", 200, 30, "Cormen", "UFC", 500, 2800);
		l1.exibir_detalhes();
		System.out.println(l1.verificar_disponibilidade());
		System.out.println(l1.calcular_preco_final(30));
		
	}

}
