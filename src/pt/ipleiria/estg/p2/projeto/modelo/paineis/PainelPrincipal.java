package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import java.awt.event.MouseEvent;
import java.util.Random;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanelEventHandler;
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

public class PainelPrincipal extends Painel implements GridPanelEventHandler
{
    private JanelaPuzzlePets jogo;
    private Suporte[][] suportes;
    private int numeroDeMacasEmJogo;
    private int numeroDeSuportesCongelados;
    private Posicao posicaoOrigem;
   
    private Suporte suporteInicial;

    
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
        gridPanel.setEventHandler(this);
        gerarNivel();
        colocarCestos();
        colocarMacaNivel1();
    }

    private void colocarMacaNivel1() {
        Maca maca = new Maca((SuporteSuportador)suportes[0][0]);
        ((SuporteSuportador)suportes[0][0]).colocar(maca);
        
        Animal a = new Animal(TipoAnimal.SAPO, (SuporteSuportador) suportes[1][0]);
        ((SuporteSuportador) suportes[1][0]).colocar(a);
        
        Animal b = new Animal(TipoAnimal.POLVO, (SuporteSuportador) suportes[5][0]);
        ((SuporteSuportador) suportes[5][0]).colocar(b);
        
        Animal c = new Animal(TipoAnimal.POLVO, (SuporteSuportador) suportes[4][1]);
        ((SuporteSuportador) suportes[4][1]).colocar(c);
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
    }
    
    /*
     * Adiciona os cestos a ultimo suporte agua do painel
    */
    public void colocarCestos()
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
        //atualizar a imagem
        atualizarGridPanel(suporte);
    }

    
    public void iterar(long tempo) {
        for (int i =getNumeroDeLinhas()-1; i>=0; i--) {
            for (int j = 0; j < getNumeroDeColunas(); j++) {
                if (suportes[i][j] instanceof SuporteSuportador)
                    ((SuporteSuportador)suportes[i][j]).iterar(tempo);
                    adicionarAnimalAleatorio();
            }
        }
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

	@Override
	public void mouseDragged(MouseEvent arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
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
                        trocar(suporteFinal);
                    }
                }
            }
        }
	}

    private boolean isMovivel(Suporte suporte)
    {
        if(((SuporteSuportador) suporte).getSuportado() instanceof Animal){
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
    
    private boolean gerarCombinacao(Posicao posicao)
    {
        return false;
    }
    
    private boolean combinam(Posicao posicao, Sentido sentido, int valor)
    {
        return true;
    }
    
    public void adicionarAnimalAleatorio()
    {
        for (int coluna = 0; coluna < getNumeroDeColunas(); coluna++) {
            if (suportes[0][coluna] instanceof SuporteSuportador) {
                if (((SuporteSuportador) suportes[0][coluna]).getSuportado() == null) {
                    Random random = new Random();
                    switch (random.nextInt(5)) {
                        case 0: ((SuporteSuportador) suportes[0][coluna]).colocar(new Animal(TipoAnimal.SAPO, ((SuporteSuportador) suportes[0][coluna])));
                            break;
                        case 1: ((SuporteSuportador) suportes[0][coluna]).colocar(new Animal(TipoAnimal.PANDA, ((SuporteSuportador) suportes[0][coluna])));
                            break;
                        case 2: ((SuporteSuportador) suportes[0][coluna]).colocar(new Animal(TipoAnimal.PEIXE, ((SuporteSuportador) suportes[0][coluna])));
                            break;
                        case 3: ((SuporteSuportador) suportes[0][coluna]).colocar(new Animal(TipoAnimal.POLVO, ((SuporteSuportador) suportes[0][coluna])));
                            break;
                        case 4: ((SuporteSuportador) suportes[0][coluna]).colocar(new Animal(TipoAnimal.RAPOSA, ((SuporteSuportador) suportes[0][coluna])));
                            break;
                    }
                }
            }
        }
    }
    
}

