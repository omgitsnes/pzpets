package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

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
    
    public void adicionarAoGridPanel(int linha, int coluna, SingleImageCellRepresentation representacao)
    {
        gridPanel.add(linha, coluna, representacao); //TODO put vs add?
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
