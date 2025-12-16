import java.util.ArrayList;

public class EncomendaExpressa extends Encomenda implements Rastreador, Notificavel {

	private ArrayList<String> locais;

	EncomendaExpressa(int codigo, double peso, String destino, FuncionarioEntrega entregador) {
		super(codigo, peso, destino, entregador);
		locais = new ArrayList<String>();
	}

	@Override
	public void enviarNotificacao(String mensagem) {
		System.out.println("Encomenda: " + mensagem);
	}

	@Override
	public void atualizarLocalizacao(String local) {
		locais.add(local);
	}

	@Override
	public String obterHistorico() {
		String aux = "";
		for (String local : locais) {
			aux += local + "\n";
		}
		return aux;
	}

	
}
