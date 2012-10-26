package br.com.caelum.argentum;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;


public class CandleFactory {
	
	public Candle constroiCandleParaData(Calendar data, List<Negocio> negocios) {
		double volume = 0;
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		double abertura = (negocios.isEmpty() ? 0 : negocios.get(0).getPreco());
		double fechamento = (negocios.isEmpty() ? 0 : negocios.get(negocios.size() - 1).getPreco());
		
		if(negocios.isEmpty())
			min = max = 0.0;
		else if(negocios.size() == 1)
			min = max = negocios.get(0).getPreco();
		
		for (Negocio negocio : negocios) {
			volume += negocio.getVolume();
			
			if(negocio.getPreco() > max) {
				max = negocio.getPreco();
			}
			
			if(negocio.getPreco() < min){
				min = negocio.getPreco();
			}
		}
		
		return (new Candle(abertura, fechamento, min, max, volume, data));
	}

	public List<Candle> constroiCandles(List<Negocio> todosNegocios) {
		List<Candle> candles = new ArrayList<Candle>();
		
		List<Negocio> negociosDoDia = new ArrayList<Negocio>();
		Calendar dataAtual = todosNegocios.get(0).getData();

		for (Negocio negocio : todosNegocios) {
			if(negocio.getData().before(dataAtual))
				throw new IllegalStateException("negocios em ordem incorreta");
			
			if (!negocio.isMesmoDia(dataAtual)) {
				criaEGuardaCandle(candles, negociosDoDia, dataAtual);
				negociosDoDia = new ArrayList<Negocio>();
				dataAtual = negocio.getData();
			}
			
			negociosDoDia.add(negocio);
		}
		
		criaEGuardaCandle(candles, negociosDoDia, dataAtual);
		
		return candles;
		
	}

	private void criaEGuardaCandle(List<Candle> candles,
			List<Negocio> negociosDoDia, Calendar dataAtual) {
		Candle candleDoDia = constroiCandleParaData(dataAtual, negociosDoDia);
		candles.add(candleDoDia);
	}

}
