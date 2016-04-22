package pt.ipleiria.estg.p2.projeto.modelo;

import java.util.Random;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelPrincipal extends PainelNaoRepresentavel {

	private Suporte[][] suportes;
	// Grelha
	// Suportes
	// Numero De Macas em Jogo
	// Cadencia de Queda Da Maca
	// Cadencia De Queda Do Animal
	// Suporte Ar
	// Suporte Gelo
	// Suporte Agua

	public void alterarSuporte() {
		/*
		 * Quando houver alguma explosao e caso o suporte seja de gelo altera
		 * para agua
		 */

	}

	public PainelPrincipal(GridPanel gridPanel) {
		super(gridPanel);
		
		suportes = new Suporte[8][8];
		Random random = new Random();
		
		for (int i = 0; i < gridPanel.getNumberOfRows(); i++) {
			for (int j = 0; j < gridPanel.getNumberOfColumns(); j++) {
				
				if (gridPanel.getX() <= 1) {
					suportes[i][j] = new SuporteAgua(new Posicao(i, j));
					gridPanel.add(i, j, suportes[i][j].getRepresentacao());
					switch(random.nextInt(4)){
					case 0: Panda iPanda = new Panda(); 
						gridPanel.add(i, j, iPanda.getRepresentacao());
					break;
					case 1: Peixe iPeixe = new Peixe();
						gridPanel.add(i, j, iPeixe.getRepresentacao());
					break;
					case 2:Polvo iPolvo = new Polvo();
						gridPanel.add(i, j, iPolvo.getRepresentacao());
					break;
					case 3: Raposa iRaposa = new Raposa();
						gridPanel.add(i, j, iRaposa.getRepresentacao());
					break;
					case 4: Sapo iSapo = new Sapo();
						gridPanel.add(i, j, iSapo.getRepresentacao());
					break;
					}
						
				}
				if (gridPanel.getY() > 1 && gridPanel.getY() < 4) {
					if (gridPanel.getX() == 0 || gridPanel.getX() == 3 || gridPanel.getX() == 7) {
						suportes[i][j] = new SuporteAr(new Posicao(i, j));
						gridPanel.add(i, j,suportes[i][j].getRepresentacao());
						switch(random.nextInt(4)){
						case 0: Panda iPanda = new Panda(); 
							gridPanel.add(i, j, iPanda.getRepresentacao());
						break;
						case 1: Peixe iPeixe = new Peixe();
							gridPanel.add(i, j, iPeixe.getRepresentacao());
						break;
						case 2:Polvo iPolvo = new Polvo();
							gridPanel.add(i, j, iPolvo.getRepresentacao());
						break;
						case 3: Raposa iRaposa = new Raposa();
							gridPanel.add(i, j, iRaposa.getRepresentacao());
						break;
						case 4: Sapo iSapo = new Sapo();
							gridPanel.add(i, j, iSapo.getRepresentacao());
						break;
						}
							
					}
					suportes[i][j] = new SuporteGelo(new Posicao(i, j));
					gridPanel.add(i, j, suportes[i][j].getRepresentacao());
					switch(random.nextInt(4)){
					case 0: Panda iPanda = new Panda(); 
						gridPanel.add(i, j, iPanda.getRepresentacao());
					break;
					case 1: Peixe iPeixe = new Peixe();
						gridPanel.add(i, j, iPeixe.getRepresentacao());
					break;
					case 2:Polvo iPolvo = new Polvo();
						gridPanel.add(i, j, iPolvo.getRepresentacao());
					break;
					case 3: Raposa iRaposa = new Raposa();
						gridPanel.add(i, j, iRaposa.getRepresentacao());
					break;
					case 4: Sapo iSapo = new Sapo();
						gridPanel.add(i, j, iSapo.getRepresentacao());
					break;
					}
						
				}

				if (gridPanel.getY() > 3) {
					if ((gridPanel.getY() == 4 && gridPanel.getX() == 0)
							|| (gridPanel.getY() == 4 && gridPanel.getX() == 7)) {
						suportes[i][j] = new SuporteGelo(new Posicao(i, j));
						gridPanel.add(i, j, suportes[i][j].getRepresentacao());
						switch(random.nextInt(4)){
						case 0: Panda iPanda = new Panda(); 
							gridPanel.add(i, j, iPanda.getRepresentacao());
						break;
						case 1: Peixe iPeixe = new Peixe();
							gridPanel.add(i, j, iPeixe.getRepresentacao());
						break;
						case 2:Polvo iPolvo = new Polvo();
							gridPanel.add(i, j, iPolvo.getRepresentacao());
						break;
						case 3: Raposa iRaposa = new Raposa();
							gridPanel.add(i, j, iRaposa.getRepresentacao());
						break;
						case 4: Sapo iSapo = new Sapo();
							gridPanel.add(i, j, iSapo.getRepresentacao());
						break;
						}
							
					}
					suportes[i][j] = new SuporteAgua(new Posicao(i, j));
					gridPanel.add(i, j, suportes[i][j].getRepresentacao());
					switch(random.nextInt(4)){
					case 0: Panda iPanda = new Panda(); 
						gridPanel.add(i, j, iPanda.getRepresentacao());
					break;
					case 1: Peixe iPeixe = new Peixe();
						gridPanel.add(i, j, iPeixe.getRepresentacao());
					break;
					case 2:Polvo iPolvo = new Polvo();
						gridPanel.add(i, j, iPolvo.getRepresentacao());
					break;
					case 3: Raposa iRaposa = new Raposa();
						gridPanel.add(i, j, iRaposa.getRepresentacao());
					break;
					case 4: Sapo iSapo = new Sapo();
						gridPanel.add(i, j, iSapo.getRepresentacao());
					break;
					}
					
						
				}		
				}
				}	
	}

	public int getNumeroDeMacasEmJogo()

	{
		/* devolve o numero de macas em jogo */
		return 0;
	}

	public void incrementarNumeroDeMacasEmJogo() {
		/* Serve para que caiam macas caso nao exceda o maximo de duas */
	}

	public void decrementarNumeroDeMacasEmJogo() {
		/* Quando a maca entra no cesto , decrementa o numero de macas */
	}

	public void trocar() {
		/*
		 * Quando trocamos de posicao um animal com outro, este metodo vai
		 * verificar se e' possivel executar essa troca, se for mantem, se nao,
		 * volta a trocar
		 */

	}

	public void trocarPosicoes() {

	}

	public void iterar() {

	}

}
