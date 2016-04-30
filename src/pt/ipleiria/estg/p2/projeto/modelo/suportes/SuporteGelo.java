package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;

public class SuporteGelo extends SuporteComSuportado
{
    /**
     * 
     * @param representacao
     * @param posicao
     */
    public SuporteGelo(Posicao posicao)
    {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/suportes/gelo.png"), posicao);
    }
}
