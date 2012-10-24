package br.com.caelum.argentum.reader;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;

import junit.framework.Assert;

import br.com.caelum.argentum.Negocio;
import br.com.caelum.argentum.reader.LeitorXML;
import com.thoughtworks.xstream.io.StreamException;

import org.junit.Test;

public class LeitorXMLTest {

	@Test
	public void carregaXMLComUmNegocioEmListaUnitaria() {
		String xmlDeTeste = 
				"<list>" +
					"<negocio>" +
						"<preco>43.5</preco>" +
						"<quantidade>1000</quantidade>" +
						"<data>" +
							"<time>1322233344455</time>" +
						"</data>" +
					"</negocio>" +
				"</list>";

		LeitorXML leitor = new LeitorXML();
		List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
		
		Assert.assertEquals(1, negocios.size());
		Assert.assertEquals(43.5, negocios.get(0).getPreco());
		Assert.assertEquals(1000, negocios.get(0).getQuantidade());
	}

	@Test
	public void carregaXMLZeroNegocio() {
		String xmlDeTeste = 	"<list>" +
				"<negocio>" +
				"<preco>43.5</preco>" +
				"<quantidade>1000</quantidade>" +
				"<data>" +
					"<time>1322233344455</time>" +
				"</data>" +
			"</negocio>" +
		"</list>";

		LeitorXML leitor = new LeitorXML();
		List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
		
		Assert.assertEquals(false, negocios.isEmpty());
	}
	
	@Test(expected=StreamException.class)
	public void carregaXMLVazio() {
		String xmlDeTeste = "";

		LeitorXML leitor = new LeitorXML();
		List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
	}
	
	@Test
	public void precoQuantidadeFaltando() {
		String xmlDeTeste =
		"<list>" +
				"<negocio>" +
				"<preco>43.5</preco>" +
				"<quantidade>1000</quantidade>" +
				"<data>" +
					"<time>1322233344455</time>" +
				"</data>" +
			"</negocio>" +
		"</list>";

		LeitorXML leitor = new LeitorXML();
		List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
		
		Assert.assertEquals(true, negocios.get(0).getPreco() > 0);
		Assert.assertEquals(true, negocios.get(0).getQuantidade() > 0);
		Assert.assertEquals(true, negocios.get(0).getData() != null);
	}


}
