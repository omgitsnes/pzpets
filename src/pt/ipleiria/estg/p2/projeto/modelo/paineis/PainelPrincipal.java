package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import java.util.Random;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.p2.projeto.modelo.Cesto;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
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

public class PainelPrincipal extends Painel 
{
    private Suporte[][] suportes;
    private int numeroDeMacasEmJogo;
    private int numeroDeSuportesCongelados;

    private static final int CADENCIA_DE_QUEDA = 100;
    /**
     * O Painel Principal é con
     * @param gridPanel
     */
    public PainelPrincipal(GridPanel gridPanel) 
    {
        super(gridPanel);
        this.suportes = new Suporte[gridPanel.getNumberOfRows()][gridPanel.getNumberOfColumns()];
        this.numeroDeMacasEmJogo = 0; //Deve começar a 0 ou 1?
        gerarNivel();
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
        return CADENCIA_DE_QUEDA;
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

    /**
     * Instancia e adiciona a matriz de suportes os suportes de um nivel
     * 
     * 
     * @param gridPanel
     * @param suportes
     */
    private void gerarNivel()
    {
        for (int i = 0; i < getGridPanel().getNumberOfRows(); i++) {
            for (int j = 0; j < getGridPanel().getNumberOfColumns(); j++) {
                //Primeiras 2 linhas
                if (i < 2) {
                    suportes[i][j] = new SuporteAgua(new Posicao(i, j));
                    getGridPanel().add(i, j, suportes[i][j].getRepresentacao());
                }
                // linhas 2 e 3 
                if (i > 1 && i < 4) {
                    if (j == 0 || j == 3 || j == 7) {
                        suportes[i][j] = new SuporteAr(new Posicao(i, j));
                        getGridPanel().add(i, j, suportes[i][j].getRepresentacao());
                    } else {
                        suportes[i][j] = new SuporteGelo(new Posicao(i, j));
                        getGridPanel().add(i, j, suportes[i][j].getRepresentacao());
                    }
                }
                //todas asa outras
                if (i > 3) {
                    if ((i == 4 && j == 0) || (i == 4 && j == 7)) {
                        suportes[i][j] = new SuporteAr(new Posicao(i, j));
                        getGridPanel().add(i, j, suportes[i][j].getRepresentacao());
                    } else {
                        suportes[i][j] = new SuporteAgua(new Posicao(i, j));
                        getGridPanel().add(i, j, suportes[i][j].getRepresentacao());
                    }
                }
                //TODO ceseto no ultimo suporte agua
                if (i == 7) {
                    suportes[i][j] = new SuporteAgua(new Posicao(i, j));
                    getGridPanel().add(i, j, suportes[i][j].getRepresentacao());
                    ((SuporteComSuportado) suportes[i][j]).setSuportado(new Cesto((SuporteComSuportado) suportes[i][j]));
                    this.getGridPanel().add(i, j, ((SuporteComSuportado) suportes[i][j]).getSuportado().getRepresentacao());
                }
            }       
        }
        preencherNovoNivel(); //TODO metodo preencher
        getGridPanel().repaint();
    }

    public void adicionarAnimalAleatorio(int linha, int coluna)
    {   
        if (((SuporteComSuportado) suportes[linha][coluna]).getSuportado() == null) {
            Random random = new Random();
            switch (random.nextInt(5)) {
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

    /**
     * Garante uma maca em uma coluna aleatoria da primeira linha.
     * Preenche os Restantes suportes com Inimigos e Animais
     */
    private void preencherNovoNivel()
    {
        //TODO ADD 1 Maca na primeira linha 
        //        int r = new Random().nextInt(getGridPanel().getNumberOfColumns());
        //        suportes[0][r] = new Maca();
        //        getGridPanel().add(0, r., );
        //        for (int coluna = 0; coluna < getGridPanel().getNumberOfColumns(); coluna++) {
        //            adicionarAnimalAleatorio(0, coluna);                            
        //        }
    }
}
