package br.com.caelum.argentum.ui;

import java.util.Collections;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.caelum.argentum.Negocio;
import br.com.caelum.argentum.reader.LeitorXML;

public class EscolhedorDeXML {
	public List<Negocio> escolhe() {
		try
		{
			JFileChooser chooser = new JFileChooser("/caelum/cursos/16");
			chooser.setFileFilter(new FileNameExtensionFilter("Apenas XML","xml"));
			int retorno = chooser.showOpenDialog(null);
			
			if(retorno == JFileChooser.APPROVE_OPTION)
			{
				FileReader reader = new FileReader(chooser.getSelectedFile());
				return new LeitorXML().carrega(reader);
			}
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		return Collections.emptyList();
	}
	
	public static void main(String[] args) {
		new EscolhedorDeXML().escolhe();
	}
}
