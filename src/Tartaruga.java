import javax.swing.JPanel;

public class Tartaruga {
	
	private enum Caneta{
		
		CIMA, 
		BAIXO;
	}
	
	private enum Orientacao{
		
		DIREITA, 
		ESQUERDA,
		DESCE,
		SOBE;
		
	}
	
	private Orientacao orientacao;
	private Caneta caneta;
	private int[] posicao;
	
	
	public Tartaruga() {
		
		super();
		this.orientacao = Orientacao.DIREITA;
		this.caneta = Caneta.BAIXO;
		this.posicao = new int[2];
		posicao[0] = 1;
		posicao[0] = 1;
		
	}


	public Orientacao getOrientacao() {
		return orientacao;
	}


	public void setOrientacao(Orientacao orientacao) {
		this.orientacao = orientacao;
	}


	public Caneta getCaneta() {
		return caneta;
	}


	public void setCaneta(Caneta caneta) {
		this.caneta = caneta;
	}


	public int[] getPosicao() {
		return posicao;
	}


	public void setPosicao(int[] posicao) {
		this.posicao = posicao;
	}
	
	public void viraCanetaParaCima() {
		setCaneta(Caneta.CIMA);
	}
	
	public void viraCanetaParaBaixo() {
		setCaneta(Caneta.BAIXO);
	}
	
	public void viraTartarugaParaDireita() {
		
		if(getOrientacao() == Orientacao.DIREITA) {
			
			setOrientacao(Orientacao.DESCE);
			
		}else if(getOrientacao() == Orientacao.DESCE) {
			
			setOrientacao(Orientacao.ESQUERDA);
			
		}else if(getOrientacao() == Orientacao.ESQUERDA) {
			
			setOrientacao(Orientacao.SOBE);
			
		}else if(getOrientacao() == Orientacao.SOBE) {
			
			setOrientacao(Orientacao.DIREITA);
			
		}
		
	}
	
	public void viraTartarugaParaEsquerda() {
		
		if(getOrientacao() == Orientacao.DIREITA) {
			
			setOrientacao(Orientacao.SOBE);
			
		}else if(getOrientacao() == Orientacao.DESCE) {
			
			setOrientacao(Orientacao.DIREITA);
			
		}else if(getOrientacao() == Orientacao.ESQUERDA) {
			
			setOrientacao(Orientacao.DESCE);
			
		}else if(getOrientacao() == Orientacao.SOBE) {
			
			setOrientacao(Orientacao.ESQUERDA);
			
		}
		
	}
	
	public JPanel moveTartaruga(JPanel quadrado, int espacos) {
		
		
		if(getCaneta() == Caneta.BAIXO) {
			
			if(getOrientacao() == Orientacao.DESCE) {
				
				if(espacos + getPosicao()[1] > quadrado.getHeight()) {
					
					quadrado.getGraphics().drawLine(getPosicao()[0], getPosicao()[1], getPosicao()[0], quadrado.getHeight());
					
				}else {
					
					quadrado.getGraphics().drawLine(getPosicao()[0], getPosicao()[1], getPosicao()[0], getPosicao()[1] + espacos);
					getPosicao()[1] += espacos;
					
				}
				
			}else if(getOrientacao() == Orientacao.SOBE) {
				
				if(getPosicao()[1] - espacos < 0) {
					
					quadrado.getGraphics().drawLine(getPosicao()[0], getPosicao()[1], getPosicao()[0], 0);
					
				}else {
					
					quadrado.getGraphics().drawLine(getPosicao()[0], getPosicao()[1], getPosicao()[0], getPosicao()[1] - espacos);
					getPosicao()[1] -= espacos;
					
				}
				
			}else if(getOrientacao() == Orientacao.DIREITA) {
				
				if(getPosicao()[0] + espacos > quadrado.getWidth()) {
					
					quadrado.getGraphics().drawLine(getPosicao()[0], getPosicao()[1], quadrado.getWidth(), getPosicao()[1]);
					
				}else {
					
					quadrado.getGraphics().drawLine(getPosicao()[0], getPosicao()[1], getPosicao()[0] + espacos, getPosicao()[1]);
					getPosicao()[0] += espacos;
					
				}
				
			}else if(getOrientacao() == Orientacao.ESQUERDA) {
				
				if(getPosicao()[0] - espacos < 0) {
					
					quadrado.getGraphics().drawLine(getPosicao()[0], getPosicao()[1], 0, getPosicao()[1]);
					
				}else {
					
					quadrado.getGraphics().drawLine(getPosicao()[0], getPosicao()[1], getPosicao()[0] - espacos, getPosicao()[1]);
					getPosicao()[0] -= espacos;
					
				}
				
			}
			
			
		}else {
			
			if(getOrientacao() == Orientacao.DESCE) {
				
				if(espacos + getPosicao()[1] > quadrado.getHeight()) {
					
					getPosicao()[1] = quadrado.getHeight();
					
				}else {
					
					getPosicao()[1] += espacos; 
					
				}
				
			}else if(getOrientacao() == Orientacao.SOBE) {
				
				if(getPosicao()[1] - espacos < 0) {
					
					getPosicao()[1] = 0;
					
				}else {
					
					getPosicao()[1] -= espacos; 
					
				}
				
			}else if(getOrientacao() == Orientacao.DIREITA) {
				
				if(getPosicao()[0] + espacos > quadrado.getWidth()) {
					
					getPosicao()[0] = quadrado.getWidth();
					
				}else {
					
					getPosicao()[0] += espacos; 
					
				}
				
			}else if(getOrientacao() == Orientacao.ESQUERDA) {
				
				if(getPosicao()[0] - espacos < 0) {
					
					getPosicao()[0] = 0;
					
				}else {
					
					getPosicao()[0] -= espacos; 
					
				}
				
			}
			
		}
		
		return quadrado;
		
	}

}


