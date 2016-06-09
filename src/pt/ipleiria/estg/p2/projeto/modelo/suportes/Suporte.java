package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public abstract class Suporte
{
    private CellRepresentation representacao;
    protected Posicao posicao;
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

    public abstract boolean aceitas(Suportado suportado, Posicao posicao, Sentido s);
    
    public abstract boolean podeCair(Sentido sentido);

    public abstract void tomaLa(Suportado suportado, Posicao posicao, Sentido s);

	public void actualizarImagem() {
		getPainelPrincipal().atualizarGridPanel(this);
	}
	
	public void aMacaCaiuNoCesto()
	{
		getPainelPrincipal().decrementarNumeroDeMacasNoPainelDeMacas();
		getPainelPrincipal().decrementarNumeroDeMacasEmJogo();
	}
}
