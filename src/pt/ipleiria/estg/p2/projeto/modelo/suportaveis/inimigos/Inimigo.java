package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.inimigos;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Inimigo extends Suportado
{
    private CellRepresentation representacao;
    protected SuporteSuportador suporte;


    public Inimigo(String representacao, 
            SuporteSuportador suporte)
    {
        super(representacao, suporte);
        this.representacao = new SingleImageCellRepresentation(representacao);
        this.suporte = suporte;
    }


    public CellRepresentation getRepresentacao()
    {
        return representacao;
    }


    public SuporteSuportador getSuporte()
    {
        return suporte;
    }


    public void setSuporte(SuporteSuportador suporte)
    {
        this.suporte = suporte;
    }
    
}
