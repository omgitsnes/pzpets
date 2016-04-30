package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;

public class SuporteAr extends Suporte
{
    /**
     * 
     * @param representacao
     * @param posicao
     */
    public SuporteAr(Posicao posicao)
    {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/suportes/Ar.png"), posicao);
    }

    @Override
    public String toString()
    {
        return "SuporteAr";
    }
}
