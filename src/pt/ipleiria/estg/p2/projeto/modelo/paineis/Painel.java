package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class Painel
{
    private GridPanel gridPanel;

    public Painel(GridPanel gridPanel)
    {
        super();
        this.gridPanel = gridPanel;
    }

    public GridPanel getGridPanel()
    {
        return gridPanel;
    }
}
