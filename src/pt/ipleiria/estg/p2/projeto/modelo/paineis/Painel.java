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
    
    protected void adicionarAoGridPanel(Suporte suporte)
    {
        gridPanel.put(suporte.getPosicao().getLinha(), suporte.getPosicao().getColuna(), suporte.getRepresentacao());
    }
    
    public void atualizarGridPanel()
    {
        gridPanel.repaint();
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
