import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class EspacoPanel extends JPanel {
	
	
	private int[] comandos;
	
	public EspacoPanel() {
		super();
		this.comandos = null;
	}

	public EspacoPanel(int[] comandos) {
		super();
		this.comandos = comandos;
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
	}
	
	
}
