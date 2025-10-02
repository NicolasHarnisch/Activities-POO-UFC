public class Ebook {
    
    int id_produto;
    String nome;
    String descricao;
    float preco_base;
    String autor;
    String editora;
    String formato_arquivo; // (ex: PDF, EPUB)
    float tamanho_mb;

    Ebook (int id_produto, String nome, String descricao, float preco_base, String autor, String editora, String formato_arquivo, float tamanho_mb){
        this.id_produto = id_produto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_base = preco_base;
        this.autor = autor;
        this.editora = editora;
        this.formato_arquivo = formato_arquivo;
        this.tamanho_mb = tamanho_mb; 
        
    }

    void Detalhes() {
        System.out.println("Informações do Ebook\n");
        System.out.println("Id Produto: " + this.id_produto);
        System.out.println("Nome: " + this.nome);
        System.out.println("Descricao: " + this.descricao);
        System.out.println("Preco Base: " + this.preco_base);
        System.out.println("Autor: " + this.autor);
        System.out.println("Editora: " + this.editora);
        System.out.println("Formato do Arquivo: " + this.formato_arquivo);
        System.out.println("Tamanho em MB: " + this.tamanho_mb + "\n");
    }

    void verificar_disponibilidade(){
        boolean disponibilidade = true;
        System.out.println("Disponivel no estoque? " + disponibilidade);
    }

    boolean calcular_preco_final(float desconto_percentual) {
        if (desconto_percentual > 0) {

            float valor_descontado = this.preco_base * (desconto_percentual / 100);
            float novo_preco = this.preco_base - valor_descontado;
            this.preco_base = novo_preco;

            System.out.println("Desconto de " + desconto_percentual + " % aplicado");
            System.out.println("Novo valor: " + novo_preco);
            System.out.println("------------------------------");

            return true;
        }else {
            System.out.println("O desconto solicitado (" + desconto_percentual + "%) é menor que 0%");
            System.out.println("------------------------------");

            return false;
        }
    }

}