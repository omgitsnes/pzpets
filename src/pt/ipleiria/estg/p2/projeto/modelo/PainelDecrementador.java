package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;

public class PainelDecrementador extends PainelRepresentavel
{
    public PainelDecrementador(GridPanel gridPanel, CellRepresentation representacao, TextCellRepresentation indicacao,
            int valor)
    {
        super(gridPanel, representacao, indicacao, valor);
    }

    public void decrementarValor()
    {
        this.valor--;
    }
}
