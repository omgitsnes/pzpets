package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelDeMacas extends PainelDecrementador
{

    public PainelDeMacas(GridPanel gridPanel,
        int valor)
    {
        super(gridPanel,
            "/pt/ipleiria/estg/p2/projeto/imagens/paineis/macas.png",
            valor);
    }
}
