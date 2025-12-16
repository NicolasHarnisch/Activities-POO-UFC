public class Livro {
    private String titulo;
    private String autor;
    private int quantidadeEstoque;

    public Livro(String titulo, String autor, int quantidadeEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void diminuirEstoque() {
        this.quantidadeEstoque--;
    }

    public void aumentarEstoque() {
        this.quantidadeEstoque++;
    }
}



