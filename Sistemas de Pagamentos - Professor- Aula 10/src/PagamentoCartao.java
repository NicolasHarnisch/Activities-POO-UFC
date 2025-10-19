import java.util.Date;

public class PagamentoCartao extends Pagamento{
	
	private String numero_cartao;
	private String bandeira;
	private int numero_parcelas;
	private float valor_parcela;
	
	PagamentoCartao(float valor, Date data_transacao, String numero_cartao, String bandeira, int numero_parcelas) {
		super(valor, data_transacao);
		this.numero_cartao = numero_cartao;
		this.bandeira = bandeira;
		this.numero_parcelas = numero_parcelas;
	}

	public String getNumero_cartao() {
		return numero_cartao;
	}

	public void setNumero_cartao(String numero_cartao) {
		this.numero_cartao = numero_cartao;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public int getNumero_parcelas() {
		return numero_parcelas;
	}

	public void setNumero_parcelas(int numero_parcelas) {
		this.numero_parcelas = numero_parcelas;
	}
	
	@Override
	public void exibirComprovante() {
		if(this.isConfirma_pagamento()) {
			System.out.println("########## Comprovante ##########");
			System.out.println("Valor: R$ " + this.getValor());
			System.out.println("Data de Transação: " + this.getData_transacao().getDay() + "/" + this.getData_transacao().getMonth() + "/" + this.getData_transacao().getYear());
			System.out.println("Número Cartao: " + this.numero_cartao.substring(numero_cartao.length() - 4, numero_cartao.length() - 1));
			System.out.println("Bandeira: " + this.bandeira);
			System.out.println("Quantidade Parcelas: " + this.numero_parcelas);
			System.out.println("Valor parcela: " + this.valor_parcela);
		}else {
			System.out.println("Transação ainda não processada!");
		}
	}
	
	@Override
	public boolean processarPagamento() {
		if(this.isConfirma_pagamento()) {
			return false;
		}else {
			this.valor_parcela = this.getValor() / this.numero_parcelas;
			setConfirma_pagamento(true);
			return true;
		}
	}

	
	
}
