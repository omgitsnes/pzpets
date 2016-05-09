package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.PainelDecrementador;

public class PainelDeMacas extends PainelDecrementador
{
    public PainelDeMacas(GridPanel gridPanel,
            int valor)
    {
        super(gridPanel,
                new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/macas.png"),
                new TextCellRepresentation(Integer.toString(valor)),
                valor);
    }
}

