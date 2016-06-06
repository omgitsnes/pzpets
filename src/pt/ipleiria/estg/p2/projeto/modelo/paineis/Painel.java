package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Suporte;

public class Painel
{
    protected GridPanel gridPanel;

    public Painel(GridPanel gridPanel)
    {
        super();
        this.gridPanel = gridPanel;
    }

    public GridPanel getGridPanel()
    {
        return gridPanel;
    }
    
    public void atualizarGridPanel(Suporte suporte)
    {
        gridPanel.put(suporte.getPosicao().getLinha(), suporte.getPosicao().getColuna(), suporte.getRepresentacao());
    }
    
    public int getNumeroDeLinhas()
    {
        return gridPanel.getNumberOfRows();
    }
    public int getNumeroDeColunas()
    {
        return gridPanel.getNumberOfColumns();
    }
}
