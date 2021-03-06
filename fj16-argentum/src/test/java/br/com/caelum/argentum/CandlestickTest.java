package br.com.caelum.argentum;

import static org.junit.Assert.*;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candle(1,2,10,5,1,Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPodeTerAtributosNegativos() {
		new Candle(1,-2,10,5,1,Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPodeTerDataNula() {
		new Candle(1,2,10,5,1,null);
	}

}
