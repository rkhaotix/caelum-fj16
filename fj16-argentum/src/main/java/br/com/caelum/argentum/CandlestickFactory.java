package br.com.caelum.argentum;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;


public class CandlestickFactory {
	
	public Candlestick constroiCandleParaData(Calendar data, List<Negocio> negocios) {
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
		
		return (new Candlestick(abertura, fechamento, min, max, volume, data));
	}

	public List<Candlestick> constroiCandleParaData(List<Negocio> todosNegocios) {
		List<Candlestick> candles = new ArrayList<Candlestick>();
		
		List<Negocio> negociosDoDia = new ArrayList<Negocio>();
		Calendar dataAtual = todosNegocios.get(0).getData();

		for (Negocio negocio : todosNegocios) {
			if(negocio.getData().before(dataAtual))
				throw new IllegalStateException("negocios em ordem incorreta");
			
			if (!negocio.isMesmoDia(dataAtual)) {
				Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociosDoDia);
				candles.add(candleDoDia);
				negociosDoDia = new ArrayList<Negocio>();
				dataAtual = negocio.getData();
			}
			
			negociosDoDia.add(negocio);
		}
		
		Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociosDoDia);
		candles.add(candleDoDia);
		
		return candles;
		
	}

}
