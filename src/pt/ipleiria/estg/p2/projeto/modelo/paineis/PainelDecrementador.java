package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelDecrementador extends PainelRepresentavel
{
    public PainelDecrementador(GridPanel gridPanel, String representacao,
            int valor)
    {
        super(gridPanel, representacao, valor);
    }

    public void decrementarValor()
    {
        this.valor--;
        atualizarIndicacao();
    }
}
