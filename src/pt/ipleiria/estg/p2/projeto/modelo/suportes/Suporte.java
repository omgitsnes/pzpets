package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import javax.swing.plaf.ActionMapUIResource;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Cesto;
import pt.ipleiria.estg.p2.projeto.modelo.Maca;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public class Suporte
{
    private CellRepresentation representacao;
    protected Posicao posicao;
    protected Sentido sentido;
    private PainelPrincipal painelPrincipal;

    public Suporte(PainelPrincipal painelPrincipal, String representacao, Posicao posicao)
    {
        super();
        this.painelPrincipal = painelPrincipal;
        this.representacao = new SingleImageCellRepresentation(representacao);
        this.posicao = posicao;
    }

    public CellRepresentation getRepresentacao()
    {
        return representacao;
    }

    public Posicao getPosicao()
    {
        return posicao;
    }

    public PainelPrincipal getPainelPrincipal()
    {
        return painelPrincipal;
    }

	public boolean estadoDoCesto() {
		return false;
	}

    public void setRepresentacao(CellRepresentation representacao)
    {
        this.representacao = representacao;
    }

	public boolean aceitas(Suportado suportado,Posicao posicao, Sentido s) {
		if (this instanceof SuporteAr){
			if(s == Sentido.S)
				painelPrincipal.podeCairSuportado(suportado, posicao, s);
		return false;
			
		}
			
		if (this instanceof SuporteAgua) {
			if(((SuporteSuportador)this).getSuportado() == null){
			return true;
			}
			else if (((SuporteSuportador)this).getSuportado() instanceof Cesto ) {
				((Cesto)((SuporteSuportador)this).getSuportado()).aceita(suportado); 
			}
			
		} 
		if (this instanceof SuporteGelo)
		{
			if(((SuporteSuportador)this).getSuportado() == null){
				return true;
			}
		}
		return false;
	}

	public void tomaLa(Suportado suportado, Posicao posicao, Sentido s) {
		((SuporteSuportador)this).setSuportado(suportado);
		getPainelPrincipal().atualizarImagem(this);
	}

}
