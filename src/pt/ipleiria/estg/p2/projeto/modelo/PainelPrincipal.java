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

    public PainelPrincipal(GridPanel gridPanel) 
    {
        super(gridPanel);
        suportes = new Suporte[8][8];

        gerarNivel(gridPanel, suportes);
        
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
    
    private void gerarNivel(GridPanel gridPanel, Suporte[][] suportes)
    {
        for (int i = 0; i < gridPanel.getNumberOfRows(); i++) {
            for (int j = 0; j < gridPanel.getNumberOfColumns(); j++) {

                //Primeiras 2 linhas
                if (i < 2) {
                    suportes[i][j] = new SuporteAgua(new Posicao(i, j));
                    gridPanel.add(i, j, suportes[i][j].getRepresentacao());
                    adicionarAnimalAleatorio(gridPanel, i, j);
                }
                // linhas 2 e 3 
                if (i > 1 && i < 4) {
                    if (j == 0 || j == 3 || j == 7) {
                        suportes[i][j] = new SuporteAr(new Posicao(i, j));
                        gridPanel.add(i, j,suportes[i][j].getRepresentacao());
                    } else {
                        suportes[i][j] = new SuporteGelo(new Posicao(i, j));
                        gridPanel.add(i, j, suportes[i][j].getRepresentacao());
                        adicionarAnimalAleatorio(gridPanel, i, j);
                    }
                }
                //todas asa outras
                if (i > 3) {
                    if ((i == 4 && j == 0)
                            || (i == 4 && j == 7)) {
                        suportes[i][j] = new SuporteAr(new Posicao(i, j));
                        gridPanel.add(i, j, suportes[i][j].getRepresentacao());
                    } else {
                        suportes[i][j] = new SuporteAgua(new Posicao(i, j));
                        gridPanel.add(i, j, suportes[i][j].getRepresentacao());
                        adicionarAnimalAleatorio(gridPanel, i, j);
                    }
                }
            }       
        }
    }
    
    private void adicionarAnimalAleatorio(GridPanel gridPanel, int linha, int coluna)
    {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0: Panda iPanda = new Panda(); 
                gridPanel.add(linha, coluna, iPanda.getRepresentacao());
                break;
            case 1: Peixe iPeixe = new Peixe();
                gridPanel.add(linha, coluna, iPeixe.getRepresentacao());
                break;
            case 2:Polvo iPolvo = new Polvo();
                gridPanel.add(linha, coluna, iPolvo.getRepresentacao());
                break;
            case 3: Raposa iRaposa = new Raposa();
                gridPanel.add(linha, coluna, iRaposa.getRepresentacao());
                break;
            case 4: Sapo iSapo = new Sapo();
                gridPanel.add(linha, coluna, iSapo.getRepresentacao());
                break;
        }
    }

}
