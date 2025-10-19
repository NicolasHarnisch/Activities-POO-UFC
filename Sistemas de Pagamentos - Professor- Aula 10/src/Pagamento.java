import java.util.Date;

public class Pagamento {
	
	private float valor;
	private Date data_transacao;
	private boolean confirma_pagamento;
	
	Pagamento(float valor, Date data_transacao) {
		this.valor = valor;
		this.data_transacao = data_transacao;
		this.confirma_pagamento = false;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getData_transacao() {
		return data_transacao;
	}

	public void setData_transacao(Date data_transacao) {
		this.data_transacao = data_transacao;
	}

	protected boolean isConfirma_pagamento() {
		return confirma_pagamento;
	}

	protected void setConfirma_pagamento(boolean confirma_pagamento) {
		this.confirma_pagamento = confirma_pagamento;
	}

	
	public boolean processarPagamento() {
		if(this.confirma_pagamento) {
			return false;
		}else {
			this.confirma_pagamento = true;
			return true;
		}
	}
	
	public void exibirComprovante() {
		if(this.confirma_pagamento) {
			System.out.println("########## Comprovante ##########");
			System.out.println("Valor: R$ " + this.valor);
			System.out.println("Data de Transação: " + this.data_transacao.getDay() + "/" + this.data_transacao.getMonth() + "/" + this.data_transacao.getYear());
		}else {
			System.out.println("Transação ainda não processada!");
		}
	}
	
	
}
