package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import java.awt.Color;
import java.awt.Font;
import java.time.format.TextStyle;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;

public class PainelRepresentavel extends Painel
{
    private SingleImageCellRepresentation representacao;
    private TextCellRepresentation indicacao;
    protected int valor;
    
    public PainelRepresentavel(GridPanel gridPanel, String representacao,
            int valor)
    {
        super(gridPanel);
        this.representacao = new SingleImageCellRepresentation(representacao);
        adicionarAoGridPanel(0, 0, this.representacao);
        this.valor = valor;
        atualizarIndicacao();
        format();
    }
    
    public void atualizarIndicacao()
    {
        this.indicacao = new TextCellRepresentation(Integer.toString(this.valor));
        this.getGridPanel().add(0, 0, this.indicacao);
    }

    public int getValor()
    {
        return valor;
    }
    
    private void format()
    {
        this.indicacao.setTextColor(Color.CYAN);
        this.indicacao.setTextFont(Font.decode("Arial-18"));
    }
}
    