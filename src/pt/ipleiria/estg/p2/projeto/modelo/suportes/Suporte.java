package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Maca;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public class Suporte
{
    private CellRepresentation representacao;
    private Posicao posicao;
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

    public void podeCair() 
    {
        painelPrincipal.fazerCair(posicao);
    }

	public boolean estadoDoCesto() {
		return false;
	}
}
