package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;

public class PainelRepresentavel extends Painel
{
    private CellRepresentation representacao;
    private TextCellRepresentation indicacao;
    protected int valor;
    
    public PainelRepresentavel(GridPanel gridPanel, CellRepresentation representacao, TextCellRepresentation indicacao,
            int valor)
    {
        super(gridPanel);
        this.representacao = representacao;
        this.indicacao = indicacao;
        this.valor = valor;
    }

    public CellRepresentation getRepresentacao()
    {
        return representacao;
    }

    public TextCellRepresentation getIndicacao()
    {
        return indicacao;
    }
    
    public void atualizarIndicacao()
    {
        this.indicacao = new TextCellRepresentation(Integer.toString(this.valor));
    }

    public int getValor()
    {
        return valor;
    }
    
    
}
