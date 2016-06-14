package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelDePontuacoes extends PainelRepresentavel
{

    /**
     *
     * valor Representa a pontuacao e � inicialmente 0.
     *
     * @param gridPanel
     * @param representacao
     * @param indicacao
     */
    public PainelDePontuacoes(GridPanel gridPanel)
    {
        super(gridPanel,
            "/pt/ipleiria/estg/p2/projeto/imagens/paineis/pontuacao.png", 0);
    }

    /**
     * Define a nova pontuacao aplicando-lhe a diferenca
     *
     * @param diferenca Pontuacao a incrementar
     */
    public void incrementarValor(int diferenca)
    {
        this.valor += diferenca;
        atualizarIndicacao();
    }
}
