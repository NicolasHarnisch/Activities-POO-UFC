import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {
    private final List<Livro> livros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Livro buscarLivro(String titulo) throws LivroNaoEncontradoException {
        for (Livro liv : livros) {
            if (liv.getTitulo().equalsIgnoreCase(titulo)) {
                return liv;
            }
        }
        throw new LivroNaoEncontradoException("O livro '" + titulo + "' não foi encontrado.");
    }

    public Usuario buscarUsuario(String cpf) throws UsuarioNaoEncontradoException {
        for (Usuario usu : usuarios) {
            if (usu.getCPF().equals(cpf)) {
                return usu;
            }
        }
        throw new UsuarioNaoEncontradoException("Usuário com CPF " + cpf + " não encontrado.");
    }

    public void realizarEmprestimo(String titulo, String cpf) throws LivroNaoEncontradoException, UsuarioNaoEncontradoException, EstoqueInsuficienteException, LimiteEmprestimosException {
        Livro livro = buscarLivro(titulo);
        Usuario usuario = buscarUsuario(cpf);

        if (livro.getQuantidadeEstoque() <= 0) {
            throw new EstoqueInsuficienteException("O livro '" + titulo + "' está sem estoque.");
        }

        int quantidadeEmprestada = 0;
        for (Emprestimo emp : emprestimos) {
            if (emp.getUsuario().getCPF().equals(cpf) && emp.isAtivo()) {
                quantidadeEmprestada++;
            }
        }

        if (quantidadeEmprestada >= 3) {
            throw new LimiteEmprestimosException("Limite de 3 empréstimos atingido.");
        }

        livro.diminuirEstoque();
        Emprestimo novoEmprestimo = new Emprestimo(livro, usuario);
        emprestimos.add(novoEmprestimo);
        System.out.println("Empréstimo realizado com sucesso: " + titulo + " para " + usuario.getNome());
    }

    static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        sistema.cadastrarLivro(new Livro("Java Profissional", "Nicolas", 2));
        sistema.cadastrarLivro(new Livro("Harry Potter", "Manu", 0));
        sistema.cadastrarUsuario(new Usuario("Nicolas", "123.456.789-10", 19));

        try {
            sistema.realizarEmprestimo("Java Profissional", "123.456.789-10");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            sistema.realizarEmprestimo("Livro Fantasma", "123.456.789-10");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            sistema.realizarEmprestimo("Harry Potter", "123.456.789-10");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            sistema.realizarEmprestimo("Java Profissional", "999.999.999.10");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}