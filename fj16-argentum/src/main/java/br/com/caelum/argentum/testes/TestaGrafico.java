package br.com.caelum.argentum.testes;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

import br.com.caelum.argentum.SerieTemporal;
import br.com.caelum.argentum.grafico.GeradorDeGrafico;
import br.com.caelum.argentum.indicadores.GeradorDeSerie;
import br.com.caelum.argentum.indicadores.IndicadorAbertura;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.IndicadorMaximo;
import br.com.caelum.argentum.indicadores.MediaMovelPonderada;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;

public class TestaGrafico {
	public static void main (String[] args) throws IOException {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1,2,3,4,5,6,7,
												8,8,9,9,4,3,2,1,2,2,4,5,6,7,
												8,9,10,11,10,6,3,2,6,7,8,9);
		
		GeradorDeGrafico g = new GeradorDeGrafico(serie, 3, 32);
		g.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento()));
		g.plotaIndicador(new MediaMovelPonderada(new IndicadorFechamento()));
		g.plotaIndicador(new IndicadorFechamento());
		g.plotaIndicador(new IndicadorMaximo());
		g.plotaIndicador(new IndicadorAbertura());
		g.salva(new FileOutputStream("grafico.png"));
		
		JFrame frame = new JFrame("Minha janela");
		frame.add(g.getPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

}
