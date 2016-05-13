package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;

public class Suporte
{
    private SingleImageCellRepresentation representacao;
    private Posicao posicao;

    public Suporte(String representacao, Posicao posicao)
    {
        super();
        this.representacao = new SingleImageCellRepresentation(representacao);
        this.posicao = posicao;
    }

    public SingleImageCellRepresentation getRepresentacao()
    {
        return representacao;
    }

    public Posicao getPosicao()
    {
        return posicao;
    }
}
