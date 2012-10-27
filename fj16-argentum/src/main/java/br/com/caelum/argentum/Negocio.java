package br.com.caelum.argentum;

import java.util.Calendar;

import br.com.caelum.argentum.ui.Coluna;

public final class Negocio {
	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negocio(double preco, int quantidade, Calendar data) {
		
		if(data==null)
			throw new IllegalArgumentException("data == null");
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	@Coluna(nome="Preço",posicao=0, formato="R$ %,#.2f")
	public double getPreco() {
		return preco;
	}

	@Coluna(nome="Quantidade",posicao=1)
	public int getQuantidade() {
		return quantidade;
	}

	@Coluna(nome="Data",posicao=2, formato="%1$td/%1$tm/%1$tY")
	public Calendar getData() {
		return (Calendar) this.data.clone();
	}
	
	@Coluna(nome="Volume",posicao=3, formato="%,#.2f")
	public double getVolume() {
		return (preco * quantidade);
	}

	public boolean isMesmoDia(Calendar outraData) {
		return (this.data.get(Calendar.DATE) == outraData.get(Calendar.DATE) &&
			    this.data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH) && 
			    this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR) );
	}
}
