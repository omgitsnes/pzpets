package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Random;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanelEventHandler;
import pt.ipleiria.estg.p2.projeto.modelo.Combinavel;
import pt.ipleiria.estg.p2.projeto.modelo.Jogo;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.TipoAnimal;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Cesto;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Maca;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.animais.Animal;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.inimigos.Espinho;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.inimigos.Roseira;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Suporte;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAgua;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAr;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteGelo;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class PainelPrincipal extends Painel implements GridPanelEventHandler
{

    private Jogo jogo;
    private Suporte[][] suportes;
    private int numeroDeMacasEmJogo;
    private int numeroDeSuportesCongelados;
    private Suporte suporteInicial;
    private static final int CADENCIA_DE_QUEDA = 100;

    /**
     * @param gridPanel
     */
    public PainelPrincipal(GridPanel gridPanel, Jogo jogo)
    {
        super(gridPanel);
        this.suportes = new Suporte[getNumeroDeLinhas()][getNumeroDeColunas()];
        this.numeroDeMacasEmJogo = 0;
        this.jogo = jogo;
        gridPanel.setEventHandler(this);
        gerarNivel();
        gerarCestos();
    }

    public int getNumeroDeSuportesCongelados()
    {
        return numeroDeSuportesCongelados;
    }

    public void incrementarNumeroDeMacasEmJogo()
    {
        numeroDeMacasEmJogo++;
    }

    public void decrementarNumeroDeMacasEmJogo()
    {
        numeroDeMacasEmJogo--;
    }

    public int getCadenciaDeQueda()
    {
        return CADENCIA_DE_QUEDA;
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

        //Adicionar inimigos
        Roseira r = new Roseira((SuporteSuportador) suportes[0][0]);
        ((SuporteSuportador) suportes[0][0]).colocar(r);

    }

    /*
     * Adiciona os cestos ao ultimo suporte agua do painel
     */
    private void gerarCestos()
    {
        for (int j = 0; j < getNumeroDeColunas(); j++) {
            for (int i = getNumeroDeLinhas() - 1; i > 0; i--) {
                if (suportes[i][j] instanceof SuporteAgua) {
                    Cesto cesto = new Cesto((SuporteAgua) suportes[i][j]);
                    ((SuporteAgua) suportes[i][j]).colocar(cesto);
                    break;
                }
            }
        }
    }

    public void colocar(Suporte suporte)
    {
        // adicionar a matriz de suportes
        suportes[suporte.getPosicao().getLinha()][suporte.getPosicao().getColuna()] = suporte;
        //atualizar a imagem
        atualizarGridPanel(suporte);
    }

    public void iterar(long tempo)
    {
        for (int i = getNumeroDeLinhas() - 1; i >= 0; i--) {
            for (int j = 0; j < getNumeroDeColunas(); j++) {
                if (suportes[i][j] instanceof SuporteSuportador) {
                    ((SuporteSuportador) suportes[i][j]).iterar(tempo);
                }
            }
        }
        adicionarAnimalAleatorio();
    }

    /**
     * Altera um Suportado para uma nova posicao previamente validada
     *
     * @param suportado
     * @param posicao
     * @param sentido
     */
    public void fazMeCair(Suportado suportado, Posicao posicao, Sentido sentido)
    {
        Posicao novaPosicao = posicao.seguir(sentido);
        suportes[novaPosicao.getLinha()][novaPosicao.getColuna()].tomaLa(suportado, posicao, sentido);
    }

    public boolean podeCair(Suportado suportado, Posicao posicao, Sentido sentido)
    {
        Posicao novaPosicao = posicao.seguir(sentido);
        if (isPosicaoValida(novaPosicao)) {
            return suportes[novaPosicao.getLinha()][novaPosicao.getColuna()].aceitas(suportado, posicao, sentido);
        }

        return false;
    }

    @Override
    public void mousePressed(MouseEvent evt, int linha, int coluna)
    {
        suporteInicial = suportes[linha][coluna];
        //check if movivel
        //TODO CLASSE MOVIVEIS
        if (suporteInicial instanceof SuporteSuportador) {
            if (isMovivel(suporteInicial)) {
                System.out.println(((SuporteSuportador) suporteInicial).getSuportado() + "; L:" + suporteInicial.getPosicao().getLinha() + "; C:" + suporteInicial.getPosicao().getColuna());
            } else {
                suporteInicial = null;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent evt, int linha, int coluna)
    {
        if (suporteInicial != null) {
            Suporte suporteFinal = suportes[linha][coluna];
            if (suporteFinal instanceof SuporteSuportador) {
                if (isMovivel(suporteFinal)) {
                    System.out.println(((SuporteSuportador) suporteFinal).getSuportado() + "; L:" + suporteFinal.getPosicao().getLinha() + "; C:" + suporteFinal.getPosicao().getColuna());
                    Sentido sentido = suporteInicial.getPosicao().getSentido(suporteFinal.getPosicao());
                    System.out.println(sentido + " -> sentido");
                    if (sentido == Sentido.N || sentido == Sentido.S || sentido == Sentido.E || sentido == Sentido.O) {

                        System.out.println(sentido.seguirSentido(suporteInicial.getPosicao()) + " =? " + suporteFinal.getPosicao());

                        if (sentido.seguirSentido(suporteInicial.getPosicao()).equals(suporteFinal.getPosicao())) {
                            trocar(suporteFinal);
                            if (geraCombinacao(suporteInicial.getPosicao()) || geraCombinacao(suporteFinal.getPosicao())) {
                                System.err.println("Combinam");
                                //combinar;
                                jogo.decrementarMovimentosDisponiveis();
                            } else {
                                System.err.println("Nai«o combinam");
                                trocar(suporteFinal);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isMovivel(Suporte suporte)
    {
        if (((SuporteSuportador) suporte).getSuportado() instanceof Combinavel) {
            return true;
        }
        return false;
    }

    private void trocar(Suporte suporteFinal)
    {
        Suportado suportadoAux = ((SuporteSuportador) suporteInicial).getSuportado();

//DEBUG
        System.out.println("Trocar " + ((SuporteSuportador) suporteFinal).getSuportado() + " com " + suportadoAux);

        ((SuporteSuportador) suporteInicial).colocar(((SuporteSuportador) suporteFinal).getSuportado());
        System.out.println(((SuporteSuportador) suporteInicial) + " --> " + ((SuporteSuportador) suporteFinal).getSuportado());

        ((SuporteSuportador) suporteFinal).colocar(suportadoAux);
        System.out.println(((SuporteSuportador) suporteFinal) + " --> " + suportadoAux);

        atualizarGridPanel(suporteInicial);
        atualizarGridPanel(suporteFinal);

    }

    private boolean geraCombinacao(Posicao posicao)
    {
        //TODO make getSuportado
        if (getSuporte(posicao) instanceof SuporteSuportador) {
            Suportado suportado = getSuportado(posicao);
            if (suportado instanceof Combinavel) {
                Sentido[] sentidos = {Sentido.E, Sentido.S};
                for (Sentido sentido : sentidos) {
                    if (combinam(posicao, sentido, 2) || combinam(posicao, sentido.getInverso(), 2) || ((combinam(posicao, sentido, 1) && combinam(posicao, sentido.getInverso(), 1)))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Verifica para um numero de posicoes sucessivas num sentido se existe
     * suportados do mesmo tipo
     *
     * @param posicao
     * @param sentido
     * @param valor
     * @return true if true.
     */
    private boolean combinam(Posicao posicao, Sentido sentido, int valor)
    {
        Suportado suportado = getSuportado(posicao);
        Suportado suportadoSentido;
        Posicao proximaPosicao = sentido.seguirSentido(posicao);
        if (isPosicaoValida(proximaPosicao)) {
            suportadoSentido = getSuportado(sentido.seguirSentido(posicao));
        } else {
            System.err.println("Posicao Invalida" + proximaPosicao);
            return false;
        }
        while (valor-- > 0) {
            if (!(suportadoSentido instanceof Combinavel
                && ((Combinavel) suportadoSentido).combinaCom(suportado))) {
                return false;
            }
            proximaPosicao = sentido.seguirSentido(suportadoSentido.getSuporte().getPosicao());
            if (isPosicaoValida(proximaPosicao)) {
                suportadoSentido = getSuportado(proximaPosicao);
            } else {
                System.err.println("Pesuisa em Posicao Invalida" + proximaPosicao);
                return false;
            }
        }
        return true;
    }

    public void adicionarAnimalAleatorio()
    {
        for (int coluna = 0; coluna < getNumeroDeColunas(); coluna++) {
            if (suportes[0][coluna] instanceof SuporteSuportador) {
                if (((SuporteSuportador) suportes[0][coluna]).getSuportado() == null) {
                    if (numeroDeMacasEmJogo < 2) {
                        Maca maca = new Maca((SuporteSuportador) suportes[0][coluna]);
                        ((SuporteSuportador) suportes[0][coluna]).colocar(maca);
                        incrementarNumeroDeMacasEmJogo();
                    } else {

                        Random random = new Random();
                        switch (random.nextInt(5)) {
                            case 0:
                                ((SuporteSuportador) suportes[0][coluna]).colocar(new Animal(TipoAnimal.SAPO, ((SuporteSuportador) suportes[0][coluna])));
                                break;
                            case 1:
                                ((SuporteSuportador) suportes[0][coluna]).colocar(new Animal(TipoAnimal.PANDA, ((SuporteSuportador) suportes[0][coluna])));
                                break;
                            case 2:
                                ((SuporteSuportador) suportes[0][coluna]).colocar(new Animal(TipoAnimal.PEIXE, ((SuporteSuportador) suportes[0][coluna])));
                                break;
                            case 3:
                                ((SuporteSuportador) suportes[0][coluna]).colocar(new Animal(TipoAnimal.POLVO, ((SuporteSuportador) suportes[0][coluna])));
                                break;
                            case 4:
                                ((SuporteSuportador) suportes[0][coluna]).colocar(new Animal(TipoAnimal.RAPOSA, ((SuporteSuportador) suportes[0][coluna])));
                                break;
                        }
                    }
                }
            }
        }
    }

    public void decrementarNumeroDeMacasNoPainelDeMacas()
    {
        jogo.decrementarMacasPorApanhar();
    }

    public Suportado getSuportado(Posicao posicao)
    {
        Suporte suporte = suportes[posicao.getLinha()][posicao.getColuna()];
        if (suporte instanceof SuporteSuportador) {
            return ((SuporteSuportador) suporte).getSuportado();
        }
        return null;
    }

    public Posicao gerarEspinho(Posicao posicao, LinkedList<Espinho> espinhos)
    {
        //Posicoes em volta da roseira
        for (Sentido sentido : Sentido.values()) {
            Posicao novaPosicao = posicaoValidaParaGerarEspinho(posicao, sentido);
            if (novaPosicao != null) {
                return novaPosicao;
            }
        }
        //posicoes em volta dos espinhos
        for (Espinho espinho : espinhos) {
            System.err.println("Tentar gerar espinho por espinho");
            for (Sentido sentido : Sentido.values()) {
                Posicao novaPosicao = posicaoValidaParaGerarEspinho(espinho.getSuporte().getPosicao(), sentido);
                if (novaPosicao != null) {
                    return novaPosicao;
                }
            }
        }
        return null;
    }

    /**
     * Cria e adicina um novo Espinho numa posicao previamente encontrada
     *
     * @param posicao Posicao da roseira Mae
     * @param posicaoEspinho Posicao do novo espinho
     */
    public void colocarNovoEspinho(Posicao posicao, Posicao posicaoEspinho)
    {
        SuporteSuportador s = (SuporteSuportador) getSuporte(posicaoEspinho);
        Espinho e = new Espinho(s);
        ((SuporteSuportador) s).colocar(e);
        ((Roseira) getSuportado(posicao)).adicionarEspinho(e);
    }

    private boolean isPosicaoValida(Posicao posicao)
    {
        if (posicao.isDentro(getNumeroDeLinhas(), getNumeroDeColunas())) {
            return true;
        }
        return false;
    }

    private Posicao posicaoValidaParaGerarEspinho(Posicao posicao, Sentido sentido)
    {
        Posicao proximaPosicao = sentido.seguirSentido(posicao);
        if (isPosicaoValida(proximaPosicao)) {
            if (getSuportado(proximaPosicao) instanceof Animal) {
                return proximaPosicao;
            }
        }
        return null;
    }

    public Suporte getSuporte(Posicao posicao)
    {
        return suportes[posicao.getLinha()][posicao.getColuna()];
    }

    @Override
    public void mouseDragged(MouseEvent me, int i, int i1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me, int i, int i1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
