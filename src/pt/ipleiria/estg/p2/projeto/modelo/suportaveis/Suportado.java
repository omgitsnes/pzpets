package pt.ipleiria.estg.p2.projeto.modelo.suportaveis;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Suporte;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Suportado<TSuporte extends SuporteSuportador>
{

    protected CellRepresentation representacao;
    private TSuporte suporte;

    public Suportado(String representacao, TSuporte suporte)
    {
        super();
        this.representacao = new SingleImageCellRepresentation(representacao);
        this.suporte = suporte;
    }

    public TSuporte getSuporte()
    {
        return suporte;
    }

    public CellRepresentation getRepresentacao()
    {
        return representacao;
    }

    public void setSuporte(TSuporte suporte)
    {
        this.suporte = suporte;
    }

	public Posicao getPosicao() {
		// TODO Auto-generated method stub
		return suporte.getPosicao();
	}

}
