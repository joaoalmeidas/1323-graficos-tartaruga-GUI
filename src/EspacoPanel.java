import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;



public class EspacoPanel extends JPanel {
	
	
	private int[] comandos;
	private Tartaruga tartaruga;
	
	public EspacoPanel() {
		
		super();
		this.comandos = new int[0];
		tartaruga = new Tartaruga();
		
	}

	public EspacoPanel(int[] comandos) {
		super();
		this.comandos = comandos;
		tartaruga = new Tartaruga();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for(int i = 0; i < comandos.length; i++) {
			
			
			if(comandos[i] == 1) {
				
				tartaruga.viraCanetaParaCima();
				
			}else if(comandos[i] == 2) {
				
				tartaruga.viraCanetaParaBaixo();
				
			}else if(comandos[i] == 3) {
				
				tartaruga.viraTartarugaParaDireita();
				
			}else if(comandos[i] == 4) {
				
				tartaruga.viraTartarugaParaEsquerda();
				
			}else if(comandos[i] == 5) {
				
				final int pontoPartida[] = Arrays.copyOf(tartaruga.getPosicao(), tartaruga.getPosicao().length);	
				
				tartaruga.moveTartaruga(comandos[++i], getWidth(), getHeight());
				
				if(tartaruga.isCanetaBaixo()) {
					
					g.drawLine(pontoPartida[0], pontoPartida[1], tartaruga.getPosicao()[0], tartaruga.getPosicao()[1]);
					
				}
				
				
				
			}
			
		}
		
	}
	
	
}
