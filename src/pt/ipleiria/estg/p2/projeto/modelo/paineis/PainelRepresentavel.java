package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;

public class PainelRepresentavel extends Painel
{
    private CellRepresentation representacao;
    private TextCellRepresentation indicacao;
    protected int valor;
    
    public PainelRepresentavel(GridPanel gridPanel, String representacao,
            int valor)
    {
        super(gridPanel);
        this.representacao = new SingleImageCellRepresentation(representacao);
        this.valor = valor;
        atualizarIndicacao();
    }
    
    public void atualizarIndicacao()
    {
        this.indicacao = new TextCellRepresentation(Integer.toString(this.valor));
        this.getGridPanel().add(0, 0, this.indicacao);
        this.getGridPanel().add(0, 0, this.representacao);
    }

    public int getValor()
    {
        return valor;
    }
}
