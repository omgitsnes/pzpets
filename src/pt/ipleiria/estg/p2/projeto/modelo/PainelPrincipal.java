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

    public int getNumeroDeMacasEmJogo()
    {
        return numeroDeMacasEmJogo;
    }

    public int getNumeroDeSuportesCongelados()
    {
        return numeroDeSuportesCongelados;
    }

    public void incrementarNumeroDeMacasEmJogo() 
    {
        if (numeroDeMacasEmJogo < 2)
            numeroDeMacasEmJogo++;
    }

    public void decrementarNumeroDeMacasEmJogo() 
    {
        if (numeroDeMacasEmJogo > 0)
            numeroDeMacasEmJogo--;
    }

    public int getCadenciaDeQueda()
    {
        return cadenciaDeQueda;
    }

    /**
     * Percorre a matriz de suportes
     * Sempre que um suporte nao Ar, com suportavel que cai
     */
    public void cair(int linha, int coluna) 
    {
        //TODO ATUALIZAR O SUPORTE DO ANIMAL
        if (suportes[linha][coluna] instanceof SuporteComSuportado && ((SuporteComSuportado) suportes[linha][coluna]).getSuportado() != null) {
            Posicao novaPosicao = ((Animal) ((SuporteComSuportado) suportes[linha][coluna]).getSuportado()).podeCair(suportes, linha, coluna);
            if (novaPosicao != null) {
                ((Animal) ((SuporteComSuportado) suportes[linha][coluna]).getSuportado()).cair(suportes, novaPosicao, linha, coluna);
                this.getGridPanel().remove(linha, coluna, ((SuporteComSuportado) suportes[novaPosicao.getLinha()][novaPosicao.getColuna()]).getSuportado().getRepresentacao());
                this.getGridPanel().add(novaPosicao.getLinha(), novaPosicao.getColuna(), ((SuporteComSuportado) suportes[novaPosicao.getLinha()][novaPosicao.getColuna()]).getSuportado().getRepresentacao());
                this.getGridPanel().repaint();
            }
        }
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
        if (((SuporteComSuportado) suportes[linha][coluna]).getSuportado() == null) {
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
    }
}
