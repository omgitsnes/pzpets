package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public class SuporteGelo extends SuporteSuportador<SuportadoPorGelo>
{
    public SuporteGelo(PainelPrincipal painelPrincipal, Posicao posicao)
    {
        super(painelPrincipal, 
                "/pt/ipleiria/estg/p2/projeto/imagens/suportes/gelo.png", 
                posicao);
    }
}
