package br.com.caelum.argentum;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;

public class NegocioTest {

	@Test
	public void dataDoNegocioEhImutavel() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negocio n = new Negocio(10, 5, c);
		
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegocioComDataNula() {
		new Negocio(10, 5, null);
	}
	
	@Test
	public void mesmoMilissegundoEhDoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negocio negocio = new Negocio(40.0, 100, agora);
		Assert.assertTrue(negocio.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void mesmoDiaHorasDiferentesEhDoMesmoDia() {
		Calendar manha = new GregorianCalendar(2012, 10, 24, 8, 30);
		Calendar tarde = new GregorianCalendar(2012, 10, 24, 17, 30);
		
		Negocio negocio = new Negocio(40.0, 100, manha);
		Assert.assertTrue(negocio.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
		Calendar manha = new GregorianCalendar(2012, 10, 24, 8, 30);
		Calendar tarde = new GregorianCalendar(2012, 11, 24, 17, 30);
		
		Negocio negocio = new Negocio(40.0, 100, manha);
		Assert.assertFalse(negocio.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
		Calendar manha = new GregorianCalendar(2012, 10, 24, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 24, 17, 30);
		
		Negocio negocio = new Negocio(40.0, 100, manha);
		Assert.assertFalse(negocio.isMesmoDia(tarde));
	}
	
}
