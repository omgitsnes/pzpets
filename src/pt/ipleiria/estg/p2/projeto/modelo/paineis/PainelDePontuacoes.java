package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.PainelRepresentavel;

public class PainelDePontuacoes extends PainelRepresentavel
{
    /**
     * 
     * valor Representa a pontuacao e é inicialmente 0.
     * @param gridPanel
     * @param representacao
     * @param indicacao
     */
    public PainelDePontuacoes(GridPanel gridPanel)
    {
        super(gridPanel,
                new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/pontuacao.png"),
                new TextCellRepresentation(Integer.toString(0)),
                0);
    }

    /**
     * Define a nova pontuacao aplicando-lhe a diferenca
     * @param diferenca Pontuacao a incrementar
     */
    public void incrementarValor(int diferenca)
    {
        this.valor += diferenca;
    }
}