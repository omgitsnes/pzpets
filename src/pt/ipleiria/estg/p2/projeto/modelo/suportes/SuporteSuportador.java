package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import java.util.LinkedList;
import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.inimigos.Espinho;

public abstract class SuporteSuportador<TSuportado extends Suportado> extends Suporte
{
    private TSuportado suportado;

    /**
     * 
     * @param painelPrincipal TODO
     * @param representacao
     * @param posicao
     */
    public SuporteSuportador(PainelPrincipal painelPrincipal, String representacao, Posicao posicao)
    {
        super(painelPrincipal, representacao, posicao);
    }
    
    public TSuportado getSuportado()
    {
        return suportado;
    }
    
    public void colocar(TSuportado suportado)
    {
        this.suportado = suportado;
        this.suportado.setSuporte(this);
        getPainelPrincipal().atualizarGridPanel(this); 
    }


    public void iterar(long tempo) {
        if (suportado instanceof Iteravel)
            ((Iteravel)suportado).iterar(tempo);
    }

    @Override
    public CellRepresentation getRepresentacao() 
    {
        if(suportado == null) {
            return super.getRepresentacao();
        }
        return new OverlayCellRepresentation(super.getRepresentacao(), suportado.getRepresentacao());
    }

    public boolean podeReceber()
    {
        return this.suportado == null;
    }

    public void setSuportado(TSuportado suportado) {
        this.suportado = suportado;
    }

    public void fazMeCair(Sentido s) {
    	System.out.println(suportado + "Estou a cair!");
    	TSuportado sup=suportado;
    	suportado=null;
    	getPainelPrincipal().atualizarGridPanel(this);
        getPainelPrincipal().fazMeCair(sup, s);
    }

    @Override
    public boolean podeCair(Sentido sentido)
    {
        if (getPainelPrincipal().podeCair(suportado, sentido)) {
            System.out.println(suportado + " Podes cair !");
            return true;
        }
        return false;
    }

    @Override
    public void tomaLa(Suportado suportado, Sentido s)
    {
        this.suportado = (TSuportado) suportado;
        this.suportado.setSuporte(this);
        getPainelPrincipal().atualizarGridPanel(this);
    }

    public Posicao gerarEspinho(LinkedList<Espinho> espinhos)
    {
        return super.gerarEspinho(espinhos);
    }

    public void gerarEspinho(Posicao posicaoEspinho)
    {
        super.gerarEspinho(posicao, posicaoEspinho);
    }

	
}
