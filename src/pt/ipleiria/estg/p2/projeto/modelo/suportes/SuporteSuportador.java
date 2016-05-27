package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public class SuporteSuportador<TSuportado extends Suportado> extends Suporte
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
        
        getPainelPrincipal().atualizarImagem(this); 
    }

    
    public boolean podeCair(Sentido sentido) 
    {
        if(getPainelPrincipal().podeCairSuportado(suportado, posicao, Sentido.S)){
        	return true;
        }
        return false;
    }

	public void iterar(long tempo) {
		if (suportado instanceof Iteravel)
			((Iteravel)suportado).iterar(tempo);
	}
	
	@Override
	public CellRepresentation getRepresentacao() {
		if(suportado==null)
		  return super.getRepresentacao();
		
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
		getPainelPrincipal().fazMeCair(suportado, posicao, s);
		suportado = null;
	}
}
