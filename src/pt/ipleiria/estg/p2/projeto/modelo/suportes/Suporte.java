package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;

public class Suporte
{
    private CellRepresentation representacao;
    private Posicao posicao;

    public Suporte(String representacao, Posicao posicao)
    {
        super();
        this.representacao = new SingleImageCellRepresentation(representacao);
        this.posicao = posicao;
    }   
}
