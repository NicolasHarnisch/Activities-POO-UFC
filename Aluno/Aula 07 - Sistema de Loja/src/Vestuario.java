public class Vestuario{
    int id_produto;
    String nome;
    String descricao;
    float preco_base;
    int estoque;
    String marca;
    String tamanho;
    String cor;
    String tecido;

    Vestuario (int id_produto, String nome, String descricao, float preco_base, int estoque, String marca, String tamanho, String cor, String tecido){
        this.id_produto = id_produto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_base = preco_base;
        this.estoque = estoque;
        this.marca = marca;
        this.tamanho = tamanho; // (ex: P, M, G)
        this.cor = cor;
        this.tecido = tecido;       
    }

    void Detalhes() {
        System.out.println("Informacoes do Vestuario\n");
        System.out.println("Id Produto: " + this.id_produto);
        System.out.println("Nome: " + this.nome);
        System.out.println("Descricao: " + this.descricao);
        System.out.println("Preco Base: " + this.preco_base);
        System.out.println("Estoque: " + this.estoque);
        System.out.println("Marca: " + this.marca);
        System.out.println("Tamanho: " + this.tamanho);
        System.out.println("Cor: " + this.cor);
        System.out.println("Tecido: " + this.tecido + "\n");
        
    }

    void verificar_disponibilidade() {
        if (this.estoque > 0){
            boolean disponibilidade = true;
            System.out.println("Disponivel no estoque? " + disponibilidade);
        }else {
            boolean disponibilidade = false;
            System.out.println("Disponivel no estoque? " + disponibilidade);
        }
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