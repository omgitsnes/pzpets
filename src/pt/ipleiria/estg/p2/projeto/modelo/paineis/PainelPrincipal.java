package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import java.awt.event.MouseEvent;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanelEventHandler;
import pt.ipleiria.estg.p2.projeto.modelo.Animal;
import pt.ipleiria.estg.p2.projeto.modelo.Cesto;
import pt.ipleiria.estg.p2.projeto.modelo.Maca;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.TipoAnimal;
import pt.ipleiria.estg.p2.projeto.modelo.inimigos.Inimigo;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Suporte;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAgua;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAr;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteGelo;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;
import pt.ipleiria.estg.p2.projeto.vista.JanelaPuzzlePets;

public class PainelPrincipal extends Painel implements GridPanelEventHandler
{
    private Suporte[][] suportes;
    private int numeroDeMacasEmJogo;
    private int numeroDeSuportesCongelados;
    private JanelaPuzzlePets jogo;
    private Posicao posicaoOrigem;
    private Animal animalInicio;
    private Animal animalFinal;
   
    private boolean aArrastar;
    private Suporte suporteInicio;
    private Suporte suporteFinal;

    
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
        colocarCesto();
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
	public void mousePressed(MouseEvent evt, int linha, int coluna) {
		posicaoOrigem = new Posicao(linha,coluna);
		suporteInicio = getSuporte(posicaoOrigem);
		animalInicio = (Animal) ((SuporteSuportador)suporteInicio).getSuportado();
		
		if(seEAnimal(suporteInicio)){
			aArrastar = true;
			System.out.println("� um animal");
			animalInicio = (Animal) ((SuporteSuportador)suporteInicio).getSuportado();
			System.out.println(" " + animalInicio.toString());
		}
		
	}
	

	@Override
	public void mouseReleased(MouseEvent evt, int linha, int coluna) {
		Posicao posicaoDestino = new Posicao(linha,coluna);
		suporteFinal = getSuporte(posicaoDestino);
		animalFinal = (Animal) ((SuporteSuportador)suporteFinal).getSuportado();
		setSuportado(suporteFinal,animalInicio);
		setSuportado(suporteInicio,animalFinal);
		
		if(suporteFinal instanceof SuporteAr){ 
			System.out.println("Impossivel(AR)!!");
		}else if(((SuporteSuportador)suporteFinal).getSuportado() instanceof Cesto){
			System.out.println("Impossivel(CESTO)!!");
		}else if(posicaoOrigem.getLinha() == posicaoDestino.getLinha() && posicaoOrigem.getColuna() == posicaoDestino.getColuna()){
			System.out.println("Impossivel(MESMA POSICAO)!!");
		}else if(!isPosicaoValida(posicaoDestino)){
			System.out.println("TESTE123");
		}else if(proximaPosicao(posicaoOrigem, posicaoDestino) == false){
			System.out.println("Impossivel(JOGADA IMPOSSIVEL)!!");
		}else if(((SuporteSuportador)suporteFinal).getSuportado() instanceof Inimigo){
			System.out.println("Impossivel(Inimigo)!!");
		}else if(seEAnimal(suporteFinal) && seEAnimal(suporteInicio)){
		
		atualizarSuporte(posicaoDestino);
		atualizarSuporte(posicaoOrigem);
		}
	}
	
	public boolean seEAnimal(Suporte suporte){
		if(!(suporte instanceof SuporteAr)){
			if(((SuporteSuportador)suporte).getSuportado() instanceof Animal){
				return true;
			}
			return false;
		}
		return false;
	}

	private void setSuportado(Suporte suporteOrigem, Animal animalDestino) {
		if(animalDestino == null){
			((SuporteSuportador)suportes[suporteOrigem.getPosicao().getLinha()][suporteOrigem.getPosicao().getColuna()]).setSuportado(animalDestino);
		}else{
			((SuporteSuportador)suportes[suporteOrigem.getPosicao().getLinha()][suporteOrigem.getPosicao().getColuna()]).setSuportado(animalDestino);
			suportes[suporteOrigem.getPosicao().getLinha()][suporteOrigem.getPosicao().getColuna()].getRepresentacao();
		}
	}

}

