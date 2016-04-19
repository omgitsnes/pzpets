package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelComRepresentacao extends Representavel
{
    private GridPanel gridPanel;

    /**
     * 
     * @param gridpanel
     */
    public PainelComRepresentacao(GridPanel gridPanel, CellRepresentation representacao)
    {
        super(representacao);
        this.gridPanel = gridPanel;
    }

    public GridPanel getGridPanel()
    {
        return this.gridPanel;
    }
}
