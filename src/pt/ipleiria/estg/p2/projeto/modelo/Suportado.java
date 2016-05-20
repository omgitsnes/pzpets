package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Suportado<TSuportado extends SuporteSuportador>
{
    private CellRepresentation representacao;
    private TSuportado suporte;

    public Suportado(String representacao, TSuportado suporte)
    {
        super();
        this.representacao = new SingleImageCellRepresentation(representacao);
        this.suporte = suporte;
    }

    public TSuportado getSuporte()
    {
        return suporte;
    }

    public void setSuporte(TSuportado suporte)
    {
        this.suporte = suporte;
    }
    
    
}
