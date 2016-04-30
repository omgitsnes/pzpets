package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.PainelComRepresentacao;

public class PainelDePontuacoes extends PainelComRepresentacao 
{
    public int pontuacaoAtual;

    /**
     * 
     * @param pontuacaoAtual Inicialmente é 0
     */
    public PainelDePontuacoes(GridPanel gridPanel)
    {
        super(gridPanel, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/pontuacao.png"));
        this.pontuacaoAtual = 0;
    }
    /**
     * Define a nova pontuacao aplicando-lhe a diferenca
     * @param diferenca Pontuacao a incrementar
     */
    public void incrementarPontuacaoAtual(int diferenca)
    {
        this.pontuacaoAtual += diferenca;
    }
    
    public String getPontuacaoAtual()
    {
        return Integer.toString(pontuacaoAtual);
    }

}