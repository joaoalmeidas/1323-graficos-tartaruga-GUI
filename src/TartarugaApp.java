
public class TartarugaApp {
	
	//private enum Orientacao{SOBE, DIREITA, ESQUERDA, DESCE};
	//private enum Caneta{CIMA, BAIXO};

	public static void main(String[] args) {
		
		int[][] chao = new int[20][20];
		int[] comandos = {2, 5, 20, 3, 5, 4, 3, 5, 4, 3, 5, 4, 1, 6, 9};
		//{2, 5, 4, 3, 5, 4, 3, 5, 4, 3, 5, 4, 1, 6, 9};
		int[] posicao = {0, 0};
		
		String orientacao;
		orientacao = "direita";
		String caneta;
		caneta = "baixo";
		
		for(int i = 0; i < chao.length; i++){
			for(int j = 0; j < chao[0].length; j++){
				chao[i][j] = 0;
			}
		}
		
		for(int i = 0; i < comandos.length; i++){
			if(comandos[i] != 9){
				
				if(comandos[i] == 1){
					caneta = viraCaneta(caneta, comandos[i]);
					
				}else if(comandos[i] == 2){
					caneta = viraCaneta(caneta, comandos[i]);
					
				}else if(comandos[i] == 3){
					orientacao = mudaPosicao(orientacao, comandos[i]);
					
				}else if(comandos[i] == 4){
					orientacao = mudaPosicao(orientacao, comandos[i]);
					
				}else if(comandos[i] == 5){
					movimentaTartaruga(chao, caneta, orientacao, posicao, comandos[i+1]);
					i++;
					
				}else if(comandos[i] == 6){
					exibeChao(chao);
					
				}
				
			}
		}
		
		
	}
	
	public static void exibeChao(int[][] chao){
		for(int i = 0; i < chao.length; i++){
			for(int j = 0; j < chao[0].length; j++){
				if(chao[i][j] == 1){
					System.out.printf(" * ");
				}else{
					System.out.printf("   ");
				}	
;			}
			System.out.println();
		}
	}
	
	public static String mudaPosicao(String orientacao, int virada){
		if(orientacao.equals("desce")){
			if(virada == 3){
				orientacao = "esquerda";
			}else if(virada == 4){
				orientacao = "direita";
			}
		}
		else if(orientacao.equals("sobe")){
			if(virada == 3){
				orientacao = "direita";
			}else if(virada == 4){
				orientacao = "esquerda";
			}
		}
		else if(orientacao.equals("direita")){
			if(virada == 3){
				orientacao = "desce";
			}else if(virada == 4){
				orientacao = "sobe";
			}
		}else if(orientacao.equals("esquerda")){
			if(virada == 3){
				orientacao = "sobe";
			}else if(virada == 4){
				orientacao = "desce";
			}
		}
		
		return orientacao;
		
	}
	
	public static String viraCaneta(String caneta, int posicao){
		if(posicao == 1){
			caneta = "cima";
		}else if(posicao == 2){
			caneta = "baixo";
		}
		return caneta;
	}
	
	public static void movimentaTartaruga(int[][] chao, String caneta, String orientacao, int[] posicao, int espacos){
		int posFinal = 0;
		int espacoMaximo = 0;
		
		
		
		if(caneta.equals("baixo")){
			if(orientacao.equals("desce")){
				for(int i = 0; i < espacos; i++){	
					chao[posicao[0] + i][posicao[1]] = 1;
					posFinal = posicao[0] + i;
				}
				posicao[0] = posFinal;
			}
			else if(orientacao.equals("sobe")){
				for(int i = 0; i < espacos; i++){
					chao[posicao[0] - i][posicao[1]] = 1;
					posFinal = posicao[0] - i;
				}
				posicao[0] = posFinal;
			}
			else if(orientacao.equals("direita")){
				for(int i = 0; i < espacos; i++){
					chao[posicao[0]][posicao[1] + i] = 1;
					posFinal = posicao[1] + i;	
				}
				posicao[1] = posFinal;
			}
			else if(orientacao.equals("esquerda")){
				for(int i = 0; i < espacos; i++){

					chao[posicao[0]][posicao[1] - i] = 1;
					posFinal = posicao[1] - i;
					
				}
				posicao[1] = posFinal;
			}
			
			
		}else if( caneta.equals("cima")){
			
			if(orientacao.equals("desce")){

				posicao[0] += espacos - 1;
			}
			else if(orientacao.equals("sobe")){

				posicao[0] -= espacos - 1;
			}
			else if(orientacao.equals("direita")){

				posicao[1] += espacos - 1;
			}
			else if(orientacao.equals("esquerda")){

				posicao[1] -= espacos - 1;
			}
		}
	}

}
