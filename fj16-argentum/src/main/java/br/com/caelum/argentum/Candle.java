package br.com.caelum.argentum;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candle {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candle(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {
		
		if(minimo > maximo)
			throw new IllegalArgumentException("minimo > maximo");
		else if(volume < 0 || abertura < 0 || fechamento < 0 ||
				minimo < 0 || maximo < 0)
			throw new IllegalArgumentException("atributo negativo!");
		else if(data == null)
			throw new IllegalArgumentException("data nula!");
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}
	
	public boolean isAlta() {
		return (this.abertura < this.fechamento);
	}

	public boolean isBaixa() {
		return (this.abertura > this.fechamento);
	}
	
	@Override
	public String toString() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String strFmt = new String();
		
		strFmt = "[Abertura: " + String.valueOf(this.abertura);
		strFmt += ", Fechamento: " + String.valueOf(this.fechamento);
		strFmt += ", Mínima: " + String.valueOf(this.minimo);
		strFmt += ", Máxima: " + String.valueOf(this.maximo);
		strFmt += ", Volume: " + String.valueOf(this.volume);
		strFmt += ", Data: " + fmt.format(this.data.getTime()) + "]";
	
		return (strFmt);
	}
}
