package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.Candlestick;
import br.com.caelum.argentum.CandlestickFactory;
import br.com.caelum.argentum.Negocio;

public class TestaCandlestickFactory {
	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
		
		Negocio n1 = new Negocio(40.5, 100, hoje);
		Negocio n2 = new Negocio(45.0, 100, hoje);
		Negocio n3 = new Negocio(49.8, 100, hoje);
		Negocio n4 = new Negocio(53.3, 100, hoje);
		
		List<Negocio> negocios = Arrays.asList(n4, n3, n2, n1);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		System.out.println(candle.getAbertura());
		System.out.println(candle.getFechamento());
		System.out.println(candle.getMinimo());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getVolume());
		
		System.out.println(candle.toString());
	}	
}
