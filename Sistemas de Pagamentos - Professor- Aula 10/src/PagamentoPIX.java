import java.util.Date;

public class PagamentoPIX extends Pagamento{

	private String chave_pix;
	private String banco_origem;
	
	PagamentoPIX(float valor, Date data_transacao, String chave_pix, String banco_origem) {
		super(valor, data_transacao);
		this.chave_pix = chave_pix;
		this.banco_origem = banco_origem;
	}

	public String getChave_pix() {
		return chave_pix;
	}

	public void setChave_pix(String chave_pix) {
		this.chave_pix = chave_pix;
	}

	public String getBanco_origem() {
		return banco_origem;
	}

	public void setBanco_origem(String banco_origem) {
		this.banco_origem = banco_origem;
	}
	
	@Override
	public void exibirComprovante() {
		if(this.isConfirma_pagamento()) {
			System.out.println("########## Comprovante ##########");
			System.out.println("Valor: R$ " + this.getValor());
			System.out.println("Data de Transação: " + this.getData_transacao().getDay() + "/" + this.getData_transacao().getMonth() + "/" + this.getData_transacao().getYear());
			System.out.println("Chave pix: " + this.chave_pix);
			System.out.println("Banco Origem: " + this.banco_origem);
		}else {
			System.out.println("Transação ainda não processada!");
		}
	}
	
}
