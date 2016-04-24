package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class SuporteGelo extends Suporte
{
    /**
     * 
     * @param representacao
     * @param posicao
     */
    public SuporteGelo(CellRepresentation representacao, Posicao posicao)
    {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/suportes/gelo.png"), posicao);
    }
}
