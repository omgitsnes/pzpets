package pt.ipleiria.estg.p2.projeto.modelo;

import java.util.Random;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelPrincipal extends PainelNaoRepresentavel {

    private Suporte[][] suportes;
    private Suportavel[][] suportaveis;
    private int cadenciaDeQueda;
    private int numeroDeMacasEmJogo;
    private int numeroDeSuportesCongelados;
    
    /**
     * O Painel Principal é con
     * @param gridPanel
     */
    public PainelPrincipal(GridPanel gridPanel) 
    {
        super(gridPanel);
        this.suportes = new Suporte[gridPanel.getNumberOfColumns()][gridPanel.getNumberOfRows()];
        this.suportaveis = new Suportavel[gridPanel.getNumberOfColumns()][gridPanel.getNumberOfRows()];
        this.cadenciaDeQueda = 100;
        this.numeroDeMacasEmJogo = 0;
        gerarNivel(gridPanel, suportes);
    }
    
    public void alterarSuporte() {
        /*
         * Quando houver alguma explosao e caso o suporte seja de gelo altera
         * para agua
         */

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
    
    public int getCadenciaDeQueda()
    {
        return cadenciaDeQueda;
    }

    private void gerarNivel(GridPanel gridPanel, Suporte[][] suportes)
    {
        for (int i = 0; i < gridPanel.getNumberOfRows(); i++) {
            for (int j = 0; j < gridPanel.getNumberOfColumns(); j++) {
                //Primeiras 2 linhas
                if (i < 2) {
                    suportes[i][j] = new SuporteAgua(new Posicao(i, j));
                    gridPanel.add(i, j, suportes[i][j].getRepresentacao());
                }
                // linhas 2 e 3 
                if (i > 1 && i < 4) {
                    if (j == 0 || j == 3 || j == 7) {
                        suportes[i][j] = new SuporteAr(new Posicao(i, j));
                        gridPanel.add(i, j,suportes[i][j].getRepresentacao());
                    } else {
                        suportes[i][j] = new SuporteGelo(new Posicao(i, j));
                        gridPanel.add(i, j, suportes[i][j].getRepresentacao());
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
                    }
                }
            }       
        }
        gridPanel.repaint();
    }
    
    public void adicionarAnimalAleatorio(int linha, int coluna)
    {   
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0: suportaveis[linha][coluna] = new Panda(suportes[linha][coluna]);
                this.getGridPanel().add(linha, coluna, suportaveis[linha][coluna].getRepresentacao());
                break;
            case 1: suportaveis[linha][coluna] = new Peixe(suportes[linha][coluna]);
                this.getGridPanel().add(linha, coluna, suportaveis[linha][coluna].getRepresentacao());
                break;
            case 2: suportaveis[linha][coluna] = new Polvo(suportes[linha][coluna]);
                this.getGridPanel().add(linha, coluna, suportaveis[linha][coluna].getRepresentacao());
                break;
            case 3: suportaveis[linha][coluna] = new Raposa(suportes[linha][coluna]);
                this.getGridPanel().add(linha, coluna, suportaveis[linha][coluna].getRepresentacao());
                break;
            case 4: suportaveis[linha][coluna] = new Sapo(suportes[linha][coluna]);
                this.getGridPanel().add(linha, coluna, suportaveis[linha][coluna].getRepresentacao());
                break;
        }
    }

    public SuporteComSuportado[][] getSuportes()
    {
        return suportes;
    }

    public Suportavel hasSuportavel(int linha, int coluna)
    {
        if (suportaveis[linha][coluna] != null) {
            return suportaveis[linha][coluna];
        }
        return null;
    }

}
