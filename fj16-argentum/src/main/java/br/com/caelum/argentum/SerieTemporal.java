package br.com.caelum.argentum;

import java.util.List;

public class SerieTemporal {
	
	private final List<Candle> candles;

	public SerieTemporal(List<Candle> candles) {
		if(candles == null || candles.isEmpty() || candles.size() < 3)
			throw new IllegalArgumentException("lista de candles nula, vazia ou com tamanho inferior a 3");
		this.candles = candles;
	}
	
	public Candle getCandle(int i) {
		return (this.candles.get(i));
	}
	
	public int getTotal() {
		return (this.candles.size());
	}

}
