package pt.ipleiria.estg.p2.projeto.modelo;

import java.util.Random;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.p2.projeto.modelo.animais.Animal;
import pt.ipleiria.estg.p2.projeto.modelo.animais.Panda;
import pt.ipleiria.estg.p2.projeto.modelo.animais.Peixe;
import pt.ipleiria.estg.p2.projeto.modelo.animais.Polvo;
import pt.ipleiria.estg.p2.projeto.modelo.animais.Raposa;
import pt.ipleiria.estg.p2.projeto.modelo.animais.Sapo;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Suporte;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAgua;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAr;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteComSuportado;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteGelo;

public class PainelPrincipal extends PainelNaoRepresentavel {

    private Suporte[][] suportes;
    private Suportavel[][] suportaveis;//TODO Delete
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
        this.cadenciaDeQueda = 10;
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

    }

    public void trocarPosicoes() {

    }
    
    /**
     * Percorre a matriz de suportes
     * Sempre que um suporte nao Ar, com suportavel que cai
     */
    public void cair(int linha, int coluna) 
    {

                if (suportes[linha][coluna] instanceof SuporteComSuportado && ((SuporteComSuportado) suportes[linha][coluna]).getSuportado() != null) {
                    Posicao a = ((Animal) ((SuporteComSuportado) suportes[linha][coluna]).getSuportado()).podeCair(suportes, linha, coluna);
                    if (a != null) {
                        ((Animal) ((SuporteComSuportado) suportes[linha][coluna]).getSuportado()).cair(suportes, a, linha, coluna);
                        this.getGridPanel().remove(linha, coluna, ((SuporteComSuportado) suportes[a.getLinha()][a.getColuna()]).getSuportado().getRepresentacao());
                        this.getGridPanel().add(a.getLinha(), a.getColuna(), ((SuporteComSuportado) suportes[a.getLinha()][a.getColuna()]).getSuportado().getRepresentacao());
                        this.getGridPanel().repaint();
                    }
                }

//TODO
//
//        if (suportes[linha][coluna] != null){
//            if (suportes[linha][coluna].toString() != "SuporteAr"){
//                if(((SuporteComSuportado) suportes[linha][coluna]).getSuportado() != null) {
//                    Suportavel s = ((SuporteComSuportado) suportes[linha][coluna]).getSuportado();
//
//                    Posicao posicaoACair = ((Animal) s).podeCair(suportes, linha, coluna);
//                    System.out.println(posicaoACair);
//
//                    if (posicaoACair != null) {
//                        System.out.println("Posicao a cair: linha: " + posicaoACair.getLinha() + " Coluna: " + posicaoACair.getColuna());
//                        ((Animal) ((SuporteComSuportado) suportes[linha][coluna]).getSuportado()).cair(suportes, posicaoACair, linha, coluna);
//                        //atualizar o gridpanel
//                        this.getGridPanel().remove(linha, coluna, ((SuporteComSuportado) suportes[posicaoACair.getLinha()][posicaoACair.getColuna()]).getSuportado().getRepresentacao());
//                        this.getGridPanel().add(posicaoACair.getLinha(), posicaoACair.getColuna(), ((SuporteComSuportado) suportes[posicaoACair.getLinha()][posicaoACair.getColuna()]).getSuportado().getRepresentacao());
//                        this.getGridPanel().repaint();
//                    }
//                }
//            }
//        }
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
                        gridPanel.add(i, j, suportes[i][j].getRepresentacao());
                    } else {
                        suportes[i][j] = new SuporteGelo(new Posicao(i, j));
                        gridPanel.add(i, j, suportes[i][j].getRepresentacao());
                    }
                }
                //todas asa outras
                if (i > 3) {
                    if ((i == 4 && j == 0) || (i == 4 && j == 7)) {
                        suportes[i][j] = new SuporteAr(new Posicao(i, j));
                        gridPanel.add(i, j, suportes[i][j].getRepresentacao());
                    } else {
                        suportes[i][j] = new SuporteAgua(new Posicao(i, j));
                        gridPanel.add(i, j, suportes[i][j].getRepresentacao());
                    }
                }
            }       
        }
        getGridPanel().repaint();
    }
    
    public void adicionarAnimalAleatorio(int linha, int coluna)
    {   
        Random random = new Random();
        switch (random.nextInt(4)) {
        case 0:  ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(new Panda((SuporteComSuportado) suportes[linha][coluna]));
        this.getGridPanel().add(linha, coluna, ((SuporteComSuportado) suportes[linha][coluna]).getSuportado().getRepresentacao());
        break;
        case 1:  ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(new Peixe((SuporteComSuportado) suportes[linha][coluna]));
        this.getGridPanel().add(linha, coluna, ((SuporteComSuportado) suportes[linha][coluna]).getSuportado().getRepresentacao());
        break;
        case 2:  ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(new Polvo((SuporteComSuportado) suportes[linha][coluna]));
        this.getGridPanel().add(linha, coluna, ((SuporteComSuportado) suportes[linha][coluna]).getSuportado().getRepresentacao());
        break;
        case 3:  ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(new Raposa((SuporteComSuportado) suportes[linha][coluna]));
        this.getGridPanel().add(linha, coluna, ((SuporteComSuportado) suportes[linha][coluna]).getSuportado().getRepresentacao());
        break;
        case 4:  ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(new Sapo((SuporteComSuportado) suportes[linha][coluna]));
        this.getGridPanel().add(linha, coluna, ((SuporteComSuportado) suportes[linha][coluna]).getSuportado().getRepresentacao());
        break;
        }
        this.getGridPanel().repaint();
    }

    public Suporte[][] getSuportes()
    {
        return suportes;
    }
}
