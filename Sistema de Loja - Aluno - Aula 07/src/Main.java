public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro(10, "Ciencia da Computacao", "Livro focado em programacao", 30, 10, "Nicolas G. Harnisch", "UFC", 152, 40);
        
        Ebook ebook1 = new Ebook(14, "Engenharia de Software", "Focado em programação", 25, "Nicolas G. Harnisch", "UFC", "PDF", 50);
        
        Eletronico eletronico1 = new Eletronico(45, "Notebook", "Maquina para uso contidiano", 2000, 0, "Lenovo", "LOQ", 135, 12);

        Vestuario vestuario1 = new Vestuario(47, "Short", "Bom uso para a praia", 50, 79, "Adidas", "M", "Vermelho e Azul", "Linho");
        
        livro1.Detalhes();
        livro1.verificar_disponibilidade();
        livro1.calcular_preco_final(30);

        ebook1.Detalhes();
        ebook1.verificar_disponibilidade();
        ebook1.calcular_preco_final(50);

        eletronico1.Detalhes();
        eletronico1.verificar_disponibilidade();
        eletronico1.calcular_preco_final(60);

        vestuario1.Detalhes();
        vestuario1.verificar_disponibilidade();
        vestuario1.calcular_preco_final(20);
    }
    
}
