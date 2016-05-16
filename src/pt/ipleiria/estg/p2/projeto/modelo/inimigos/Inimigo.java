package pt.ipleiria.estg.p2.projeto.modelo.inimigos;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Inimigo
{
    private CellRepresentation representacao;
    private SuporteSuportador<TSuportavel> suporte;


    public Inimigo(String representacao, 
            SuporteSuportador<TSuportavel> suporte)
    {
        super();
        this.representacao = new SingleImageCellRepresentation(representacao);
        this.suporte = suporte;
    }


    public CellRepresentation getRepresentacao()
    {
        return representacao;
    }


    public SuporteSuportador<TSuportavel> getSuporte()
    {
        return suporte;
    }


    public void setSuporte(SuporteSuportador<TSuportavel> suporte)
    {
        this.suporte = suporte;
    }
    
}
