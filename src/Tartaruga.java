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
	
	public void moveTartaruga(int espacos) {
		
		if(getOrientacao() == Orientacao.DESCE) {
			
			getPosicao()[1] += espacos; 

		}else if(getOrientacao() == Orientacao.SOBE) {
				
			getPosicao()[1] -= espacos; 

		}else if(getOrientacao() == Orientacao.DIREITA) {
							
			getPosicao()[0] += espacos; 
				
		}else if(getOrientacao() == Orientacao.ESQUERDA) {
			
			getPosicao()[0] -= espacos; 
			
		}
		
	}

}


