public class Eletronico {

    int id_produto;
    String nome;
    String descricao;
    double preco_base;
    int estoque;
    String marca;
    String modelo;
    int voltagem;
    int garantia_meses;

    Eletronico (int id_produto, String nome, String descricao, double preco_base, int estoque, String marca, String modelo, int voltagem, int garantia_meses){
        this.id_produto = id_produto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_base = preco_base;
        this.estoque = estoque;
        this.marca = marca;
        this.modelo = modelo;
        this.voltagem = voltagem;
        this.garantia_meses = garantia_meses;
    }

    void Detalhes() {
        System.out.println("Informacoes do Eletronico\n");
        System.out.println("Id Produto: " + this.id_produto);
        System.out.println("Nome: " + this.nome);
        System.out.println("Descricao: " + this.descricao);
        System.out.println("Preco Base: " + this.preco_base);
        System.out.println("Estoque: " + this.estoque);
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Voltagem: " + this.voltagem);
        System.out.println("Garantia: " + this.garantia_meses + "\n");
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

    void calcular_preco_final(double desconto_percentual) {
        if (desconto_percentual > 0 && desconto_percentual <= 10) {

            double valor_descontado = this.preco_base * (desconto_percentual / 100);
            double novo_preco = this.preco_base - valor_descontado;
            this.preco_base = novo_preco;

            System.out.println("Desconto de " + desconto_percentual + " % aplicado");
            System.out.println("Novo valor: " + novo_preco);
            System.out.println("------------------------------");

        }else if (desconto_percentual > 10) {
            double valor_descontado = this.preco_base * (0.10);
            double novo_preco = this.preco_base - valor_descontado;
            this.preco_base = novo_preco;

            System.out.println("Desconto de " + desconto_percentual + "% com maximo de 10%");
            System.out.println("Novo valor: " + novo_preco);
            System.out.println("------------------------------");

        }         
    }
}