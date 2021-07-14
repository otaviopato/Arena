/** 
@autor: Otávio Pato e Paulo Nunes
@email: otaviopato2017@outlook.com e paulinhosergionunes90@gmail.com
@objetivo: O objetivo dessa classe é implementar um agente para que ele possa batalhar com os outros inimigos. 
 */

package br.uffs.cc.jarena;

public class elChapito extends Agente
{
	public elChapito(Integer x, Integer y, Integer energia) {
		super(x, y, energia);
		setDirecao(geraDirecaoAleatoria());
	}
	int guardaBaixo=0, guardaCima=0, guardaDireita=0, guardaEsquerda=0;
	boolean ganhaEnergia = false;

	public void pensa() {
		// Se não conseguimos nos mover para a direção atual, quer dizer
		// que chegamos no final do mapa ou existe algo bloqueando nosso
		// caminho.
		if(!podeMoverPara(getDirecao())) {
			// Como não conseguimos nos mover, vamos escolher uma direção
			// nova.
			setDirecao(geraDirecaoAleatoria());
		}
		
		// Se o agente conseguir se dividir (tem energia) e se o total de energia
		// do agente é maior que 1100, nos dividimos. O agente filho terá a metade
		// da nossa energia atual.
		if(podeDividir() && getEnergia() >= 1100) {
			divide();
			setDirecao(geraDirecaoAleatoria());
		}

		if(getEnergia()<=150){
			//se tem 150 de energia para() é executado para o agente sobreviver mais tempo.
			para();
		}

		if(isParado() && getEnergia() > 150 && ganhaEnergia == false){
			//se o agente parou, mas está com mais de 150 de energia ele volta a andar.
			setDirecao(geraDirecaoAleatoria());
		}
		if(getDirecao()==Agente.ESQUERDA){
			guardaEsquerda+=1;
		}
		if(getDirecao()==Agente.DIREITA){
			guardaDireita+=1;
		}
		if(getDirecao()==Agente.CIMA){
			guardaCima+=1;
		}
		if(getDirecao()==Agente.BAIXO){
			guardaBaixo+=1;
		}
		if(guardaBaixo==25 || guardaCima==25 || guardaDireita==25 || guardaEsquerda==25){
			guardaBaixo=0;
			guardaCima=0;
			guardaDireita=0;
			guardaEsquerda=0;
			setDirecao(geraDirecaoAleatoria());
		}
	}

	public void moverPara(int x, int y) {
		//Faz os agentes irem a determinada coordenada.
		if (getX() < x) {
			setDirecao(DIREITA);
		} else if (getX() > x) {
			setDirecao(ESQUERDA);
		} else if (getY() > y) {
			setDirecao(CIMA);
		} else if (getY() < y) {
			setDirecao(BAIXO);
		}
	}
	
	public void recebeuEnergia() {
		//ganhaEnergia se torna true, o agente para e envia as suas coordenadas.
		ganhaEnergia = true;
		para();
		String guardaX = Integer.toString(getX());
		String guardaY = Integer.toString(getY());
		enviaMensagem(guardaX + "," + guardaY);
		// Invocado sempre que o agente recebe energia.
	}
	
	public void tomouDano(int energiaRestanteInimigo) {
		setDirecao(geraDirecaoAleatoria());
		// Invocado quando o agente está na mesma posição que um agente inimigo
		// e eles estão batalhando (ambos tomam dano).
	}
	
	public void ganhouCombate() {
		setDirecao(geraDirecaoAleatoria());
		
		// Invocado se estamos batalhando e nosso inimigo morreu.
	}
	
	public void recebeuMensagem(String msg) {
		//Recebe as coordenadas de um agente e chama o moverPara(coordenadaX, coordenadaY)
		String[] coordenadas = msg.split(",");
		int coordenadaX = Integer.parseInt(coordenadas[0]);
		int coordenadaY = Integer.parseInt(coordenadas[1]);
		moverPara(coordenadaX, coordenadaY);
		
		// Invocado sempre que um agente aliado próximo envia uma mensagem.
	}
	
	public String getEquipe() {
		return "elChapito";
	}
}
