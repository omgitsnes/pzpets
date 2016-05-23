package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;

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
    
    protected void adicionarAoGridPanel(Posicao posicao, CellRepresentation representacao)
    {
        gridPanel.put(posicao.getLinha(), posicao.getColuna(), representacao);
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
