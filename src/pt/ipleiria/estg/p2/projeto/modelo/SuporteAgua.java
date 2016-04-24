package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class SuporteAgua extends Suporte 
{
    /**
     * 
     * @param representacao
     * @param posicao
     */
    public SuporteAgua(CellRepresentation representacao, Posicao posicao)
    {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/suportes/Agua.png"), posicao);
    }
}
