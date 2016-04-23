package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelNaoRepresentavel 
{
    private GridPanel gridPanel;

	public PainelNaoRepresentavel(GridPanel gridPanel) {
        super();
        this.gridPanel = gridPanel;
    }

    public GridPanel getGridPanel()
    {
        return this.gridPanel;
    }
}
