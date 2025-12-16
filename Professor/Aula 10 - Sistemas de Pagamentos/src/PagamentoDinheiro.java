import java.util.Date;

public class PagamentoDinheiro extends Pagamento{
	
	private float valor_recebido;
	private float troco;
	
	public PagamentoDinheiro(float valor, Date data_transacao, float valor_recebido) {
		super(valor, data_transacao);
		this.valor_recebido = valor_recebido;
	}

	public float getValor_recebido() {
		return valor_recebido;
	}

	public void setValor_recebido(float valor_recebido) {
		this.valor_recebido = valor_recebido;
	}

	public float getTroco() {
		return troco;
	}

	public void setTroco(float troco) {
		this.troco = troco;
	}
	
	@Override
	public void exibirComprovante() {
		if(this.isConfirma_pagamento()) {
			System.out.println("########## Comprovante ##########");
			System.out.println("Valor: R$ " + this.getValor());
			System.out.println("Data de Transação: " + this.getData_transacao().getDay() + "/" + this.getData_transacao().getMonth() + "/" + this.getData_transacao().getYear());
			System.out.println("Valor Recebido: R$ " + this.valor_recebido);
			System.out.println("Troco: R$ " + this.troco);
		}else {
			System.out.println("Transação ainda não processada!");
		}
	}
	
	@Override
	public boolean processarPagamento() {
		if(this.isConfirma_pagamento() || (this.valor_recebido < this.getValor())) {
			return false;
		}else {
			this.troco = this.valor_recebido - this.getValor();
			setConfirma_pagamento(true);
			return true;
		}
	}

}
