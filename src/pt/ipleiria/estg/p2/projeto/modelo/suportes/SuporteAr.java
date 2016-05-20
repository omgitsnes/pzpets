package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public class SuporteAr extends Suporte
{

    public SuporteAr(PainelPrincipal painelPrincipal, String representacao, Posicao posicao)
    {
        super(painelPrincipal,
                "/pt/ipleiria/estg/p2/projeto/imagens/suportes/ar.png",
                posicao);
    }

}
