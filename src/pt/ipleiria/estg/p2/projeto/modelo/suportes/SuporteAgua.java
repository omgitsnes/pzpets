package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;

public class SuporteAgua extends SuporteComSuportado 
{
    /**
     * 
     * @param representacao
     * @param posicao
     */
    public SuporteAgua(Posicao posicao)
    {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/suportes/Agua.png"), posicao);
    }

    @Override
    public String toString()
    {
        return "SuporteAgua";
    }
}
