package br.com.caelum.argentum;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SerieTemporalTest {

	@Test(expected=IllegalArgumentException.class)
	public void serieTemporalNaoAceitaListaCandlestickVaziaNula() {
		List<Candle> lista = new ArrayList();
		new SerieTemporal(lista);
	}

}
