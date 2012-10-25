package br.com.caelum.argentum.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import napkin.NapkinLookAndFeel;

public class ArgentumUI {
	private JFrame janela;
	private JPanel painelPrincipal;
	
	public static void main(String[] args) {
	    new ArgentumUI().montaTela();
	}
	
	private void montaTela() {
		preparaJanela();
		preparaPainelPrincipal();
		preparaBotaoCarregar();
		preparaBotaoSair();
		mostraJanela();
	}

	private void preparaJanela() {
		janela = new JFrame("Argentum");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

	private void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);		
	}

	private void preparaBotaoCarregar() {
		JButton botaoCarregar = new JButton("Carregar XML");
		botaoCarregar.setMnemonic('c');
		
		botaoCarregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EscolhedorDeXML().escolhe();
			}
		});
		painelPrincipal.add(botaoCarregar);		
	}

	private void preparaBotaoSair() {
		JButton botaoSair = new JButton("Sair");
		botaoSair.setMnemonic('s');

		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		painelPrincipal.add(botaoSair);
	}

	private void mostraJanela() {
	    /* try {
	        UIManager.setLookAndFeel(new NapkinLookAndFeel());
	        SwingUtilities.updateComponentTreeUI(janela);
	    } 
	    catch (Exception e) { 
	    	
	    } */

		
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);
	}
}
