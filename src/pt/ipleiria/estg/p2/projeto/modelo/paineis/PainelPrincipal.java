package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.p2.projeto.modelo.Cesto;
import pt.ipleiria.estg.p2.projeto.modelo.Maca;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Suporte;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAgua;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAr;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteGelo;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;
import pt.ipleiria.estg.p2.projeto.vista.JanelaPuzzlePets;

public class PainelPrincipal extends Painel 
{
    private Suporte[][] suportes;
    private int numeroDeMacasEmJogo;
    private int numeroDeSuportesCongelados;
    private JanelaPuzzlePets jogo;
    static final Posicao[] POSSIVEIS = {new Posicao(1,0),new Posicao(0,1), new Posicao(0,-1), new Posicao(-1,0)};
    private Posicao posicaoOrigem;

    //	private Animal animalOrigem;
    //	private Animal animalDestino;

    private Suporte suporteOrigem;
    private Suporte suporteDestino;

    private static final int CADENCIA_DE_QUEDA = 100;

    /**
     * @param gridPanel
     */
    public PainelPrincipal(GridPanel gridPanel) 
    {
        super(gridPanel);
        this.suportes = new Suporte[getNumeroDeLinhas()][getNumeroDeColunas()];
        this.numeroDeMacasEmJogo = 0; //Deve começar a 0 ou 1?
        gerarNivel();
        colocarCesto();
        colocarMacaNivel1();
    }

    private void colocarMacaNivel1() {
        System.out.println("tou ca dentro");
        Maca maca = new Maca((SuporteSuportador)suportes[0][2]);
        ((SuporteSuportador)suportes[0][2]).colocar(maca);
        Maca macaNumero2 = new Maca((SuporteSuportador)suportes[1][5]);
        ((SuporteSuportador)suportes[1][5]).colocar(macaNumero2);
        System.out.println("ainda ca tou!");
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

    private Suporte getSuporte(Posicao posicao) {
        return suportes[posicao.getLinha()][posicao.getColuna()];
    }

    public boolean isPosicaoValida(Posicao posicao) {
        return posicao.getLinha() >= 0 && posicao.getLinha() < suportes.length && 
                posicao.getColuna() >= 0 && posicao.getColuna() < suportes[0].length;
    }

    public boolean proximaPosicao(Posicao posicaoOrigem, Posicao posicaoDestino){
        for(int i=0; i < POSSIVEIS.length; i++){
            if(posicaoDestino.getLinha() == POSSIVEIS[i].getLinha()+posicaoOrigem.getLinha() &&
                    posicaoDestino.getColuna() == POSSIVEIS[i].getColuna()+posicaoOrigem.getColuna()){
                return true;
            }
        }
        return false;
    }

    public void atualizarSuporte(Posicao posicao) {
        gridPanel.clear(posicao.getLinha(), posicao.getColuna());
        gridPanel.add(posicao.getLinha(), posicao.getColuna(), 
                suportes[posicao.getLinha()][posicao.getColuna()].getRepresentacao());
        gridPanel.repaint();
    }

    private void gerarNivel()
    {
        for (int i = 0; i < getNumeroDeLinhas(); i++) {
            for (int j = 0; j < getNumeroDeColunas(); j++) {
                //Primeiras 2 linhas
                if (i < 2) {
                    Suporte s = new SuporteAgua(this, new Posicao(i, j));
                    colocar(s);
                }
                // linhas 2 e 3 
                if (i > 1 && i < 4) {
                    if (j == 0 || j == 3 || j == 7) {
                        Suporte s = new SuporteAr(this, new Posicao(i, j));
                        colocar(s);
                    } else {
                        Suporte s = new SuporteGelo(this, new Posicao(i, j));
                        colocar(s);
                    }
                }
                //todas as outras
                if (i > 3) {
                    if ((i == 4 && j == 0) || (i == 4 && j == 7)) {
                        Suporte s = new SuporteAr(this, new Posicao(i, j));
                        colocar(s);                     
                    } else {
                        Suporte s = new SuporteAgua(this, new Posicao(i, j));
                        colocar(s);
                    }
                }
                if (i == 7) {
                    Suporte s = new SuporteAgua(this, new Posicao(i, j));
                    colocar(s);
                    //TODO cestos
                }
            }       
        }
        atualizarGridPanel();
    }

    public void colocarCesto()
    {
        for (int j = 0; j < getNumeroDeColunas(); j++) {
            for (int i = getNumeroDeLinhas()-1; i>0; i--) {
                if (suportes[i][j] instanceof SuporteAgua) {
                    Cesto cesto = new Cesto((SuporteAgua)suportes[i][j]);
                    ((SuporteAgua)suportes[i][j]).colocar(cesto);
                    System.out.println("entrei");
                    break;
                }
            }
        }
    }

    public void colocar(Suporte suporte)
    {
        // adicionar a matriz de suportes
        suportes[suporte.getPosicao().getLinha()][suporte.getPosicao().getColuna()] = suporte;
        // atualiza a imagem
        atualizarImagem(suporte);
    }

    //    public void adicionarAnimalAleatorio(int linha, int coluna)
    //    {   
    //        if (((SuporteComSuportado) suportes[linha][coluna]).getSuportado() == null) {
    //            Random random = new Random();
    //            switch (random.nextInt(5)) {
    //                case 0:  ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(new Panda((SuporteComSuportado) suportes[linha][coluna]));
    //                this.getGridPanel().add(linha, coluna, ((SuporteComSuportado) suportes[linha][coluna]).getSuportado().getRepresentacao());
    //                break;
    //                case 1:  ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(new Peixe((SuporteComSuportado) suportes[linha][coluna]));
    //                this.getGridPanel().add(linha, coluna, ((SuporteComSuportado) suportes[linha][coluna]).getSuportado().getRepresentacao());
    //                break;
    //                case 2:  ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(new Polvo((SuporteComSuportado) suportes[linha][coluna]));
    //                this.getGridPanel().add(linha, coluna, ((SuporteComSuportado) suportes[linha][coluna]).getSuportado().getRepresentacao());
    //                break;
    //                case 3:  ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(new Raposa((SuporteComSuportado) suportes[linha][coluna]));
    //                this.getGridPanel().add(linha, coluna, ((SuporteComSuportado) suportes[linha][coluna]).getSuportado().getRepresentacao());
    //                break;
    //                case 4:  ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(new Sapo((SuporteComSuportado) suportes[linha][coluna]));
    //                this.getGridPanel().add(linha, coluna, ((SuporteComSuportado) suportes[linha][coluna]).getSuportado().getRepresentacao());
    //                break;
    //            }
    //            this.getGridPanel().repaint();
    //        }
    //    }


    public void iterar(long tempo) {
        for (int i =getNumeroDeLinhas()-1; i>=0; i--) {
            for (int j = 0; j < getNumeroDeColunas(); j++) {
                if (suportes[i][j] instanceof SuporteSuportador)
                    ((SuporteSuportador)suportes[i][j]).iterar(tempo);
            }
        }
    }

    public void atualizarImagem(Suporte suporte) {
        adicionarAoGridPanel(suporte.getPosicao(), suporte.getRepresentacao());
    }

    public void fazerCair(Posicao posicao) {

        if (!(suportes[posicao.getLinha() + 1][posicao.getColuna()] instanceof SuporteAr)) {
            if (((SuporteSuportador) suportes[posicao.getLinha() + 1][posicao.getColuna()]).podeReceber()) {
                ((SuporteSuportador) suportes[posicao.getLinha() + 1][posicao.getColuna()]).colocar(((SuporteSuportador) suportes[posicao.getLinha()][posicao.getColuna()]).getSuportado());
                ((SuporteSuportador) suportes[posicao.getLinha()][posicao.getColuna()]).colocar(null);

            }
        }
        if (!(suportes[posicao.getLinha() + 1][Math.max(0, posicao.getColuna() - 1)] instanceof SuporteAr)) {
            if (((SuporteSuportador) suportes[posicao.getLinha() + 1][Math.max(0, posicao.getColuna() - 1)]).podeReceber()) {
                ((SuporteSuportador) suportes[posicao.getLinha() + 1][Math.max(0, posicao.getColuna() - 1)]).colocar(((SuporteSuportador) suportes[posicao.getLinha() + 1][Math.max(0, posicao.getColuna() - 1)]).getSuportado());
            }
        }
        if (!(suportes[posicao.getLinha() + 1][Math.min(7, posicao.getColuna() + 1)] instanceof SuporteAr)) {
            if (((SuporteSuportador) suportes[posicao.getLinha() + 1][Math.min(7, posicao.getColuna() + 1)]).podeReceber()) {
                ((SuporteSuportador) suportes[posicao.getLinha() + 1][Math.min(7, posicao.getColuna() + 1)]).colocar(((SuporteSuportador) suportes[posicao.getLinha() + 1][Math.min(7, posicao.getColuna() + 1)]).getSuportado());
            }
        }
    }

    public void fazMeCair(Suportado suportado, Posicao posicao, Sentido s) {
        switch (s) {
        case S:
            ((SuporteSuportador<Suportado>) suportes[posicao.getLinha()][posicao.getColuna()]).colocar(null);
            atualizarImagem(suportes[posicao.getLinha()][posicao.getColuna()]);
            suportes[posicao.getLinha() + 1][posicao.getColuna()].tomaLa(suportado, posicao, s);
            suportado.setSuporte((SuporteSuportador) suportes[posicao.getLinha() + 1][posicao.getColuna()]);
            break;

        case SO:
            suportes[posicao.getLinha() + 1][Math.max(0, posicao.getColuna() - 1)].tomaLa(suportado, posicao, s);
            break;

        case SE:
            suportes[posicao.getLinha() + 1][Math.min(7, posicao.getColuna() + 1)].tomaLa(suportado, posicao, s);

            break;

        }
    }

    public boolean podeCair(Suportado suportado, Posicao posicao, Sentido sentido)
    {
        switch (sentido) {
            case S:
                if (suportes[posicao.getLinha() + 1][posicao.getColuna()].aceitas(suportado, posicao, sentido)) {
                    return true;
                }
                break;
            case SO:
                if (suportes[posicao.getLinha() + 1][Math.max(0, posicao.getColuna() - 1)].aceitas(suportado, posicao, sentido)) {
                    return true;
                }
                break;
            case SE:
                if (suportes[posicao.getLinha() + 1][Math.min(7, posicao.getColuna() + 1)].aceitas(suportado, posicao, sentido)) {
                    return true;
                }
                break;
        }
        return false;
    }

}

