package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.p2.projeto.modelo.Animal;
import pt.ipleiria.estg.p2.projeto.modelo.Cesto;
import pt.ipleiria.estg.p2.projeto.modelo.Maca;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.TipoAnimal;
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
    private Posicao posicaoOrigem;
    private Suporte suporteOrigem;
    private Suporte suporteDestino;

    
    static final Posicao[] POSSIVEIS = {new Posicao(1,0),new Posicao(0,1), new Posicao(0,-1), new Posicao(-1,0)};
    private static final int CADENCIA_DE_QUEDA = 100;

    /**
     * @param gridPanel
     */
    public PainelPrincipal(GridPanel gridPanel) 
    {
        super(gridPanel);
        this.suportes = new Suporte[getNumeroDeLinhas()][getNumeroDeColunas()];
        this.numeroDeMacasEmJogo = 0; //Deve come�ar a 0 ou 1?
        gerarNivel();
        colocarCesto();
        colocarMacaNivel1();
    }

    private void colocarMacaNivel1() {
        Maca maca = new Maca((SuporteSuportador)suportes[0][0]);
        ((SuporteSuportador)suportes[0][0]).colocar(maca);
        
        Animal a = new Animal(TipoAnimal.SAPO, (SuporteSuportador) suportes[0][1]);
        ((SuporteSuportador) suportes[0][1]).colocar(a);
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


    public void fazMeCair(Suportado suportado, Posicao posicao, Sentido sentido) {
        switch (sentido) {
        case S:
           suportes[posicao.getLinha() + 1][posicao.getColuna()].tomaLa(suportado, posicao, sentido);
            break;

        case SO:
            suportes[posicao.getLinha() + 1][posicao.getColuna() - 1].tomaLa(suportado, posicao, sentido);
            break;

        case SE:
            suportes[posicao.getLinha() + 1][posicao.getColuna() + 1].tomaLa(suportado, posicao, sentido);
            break;

        }
    }

    public boolean podeCair(Suportado suportado, Posicao posicao, Sentido sentido)
    {
    	Posicao novaPosicao=posicao.seguir(sentido);
    	if (novaPosicao.isDentro(8, 8)){
    		return suportes[novaPosicao.getLinha()][novaPosicao.getColuna()].aceitas(suportado, posicao, sentido);
    	}
    	
        return false;
    }

}

