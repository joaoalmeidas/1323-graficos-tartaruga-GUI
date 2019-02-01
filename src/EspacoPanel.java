import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Arrays;

import javax.swing.JPanel;




public class EspacoPanel extends JPanel {
	
	
	private int[] comandos;
	private Tartaruga tartaruga;
	

	public EspacoPanel(int[] comandos) {
		super();
		this.comandos = comandos;
		tartaruga = new Tartaruga();
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		

		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g; 
		
		tartaruga.voltaEstadoInicial();
		
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
					
					//g.drawLine(pontoPartida[0], pontoPartida[1], tartaruga.getPosicao()[0], tartaruga.getPosicao()[1]);
					g2d.draw(new Line2D.Double(pontoPartida[0], pontoPartida[1], tartaruga.getPosicao()[0], tartaruga.getPosicao()[1]));
				}
				
				
			}

		}
	

		
		
	}
	
	public String retornaStringPosicao() {
		
		
		return String.format("(%d, %d)", tartaruga.getPosicao()[0], tartaruga.getPosicao()[1]);
		
	}
	
	public String retornaStringCaneta() {
		
		return String.format("%s", tartaruga.getCaneta());
		
	}
	
	public String retornaStringOrientaacao() {
		
		return String.format("%s", tartaruga.getOrientacao());
		
	}

	public Tartaruga getTartaruga() {
		return tartaruga;
	}

	public void setTartaruga(Tartaruga tartaruga) {
		this.tartaruga = tartaruga;
	}

	public int[] getComandos() {
		return comandos;
	}

	public void setComandos(int[] comandos) {
		this.comandos = comandos;
	}
	
	
	
	
	
}
