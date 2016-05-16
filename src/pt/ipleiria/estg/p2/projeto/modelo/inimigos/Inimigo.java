package pt.ipleiria.estg.p2.projeto.modelo.inimigos;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Inimigo
{
    private CellRepresentation representacao;

    public Inimigo(String representacao)
    {
        super();
        this.representacao = new SingleImageCellRepresentation(representacao);
    }

    public CellRepresentation getRepresentacao()
    {
        return representacao;
    }
    
}
