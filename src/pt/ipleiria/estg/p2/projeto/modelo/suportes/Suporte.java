package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Suporte
{
    private CellRepresentation representacao;

    public Suporte(String representacao)
    {
        super();
        this.representacao = new SingleImageCellRepresentation(representacao);
    }   
}
