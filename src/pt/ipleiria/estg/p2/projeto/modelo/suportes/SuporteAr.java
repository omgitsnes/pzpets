package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public class SuporteAr extends Suporte
{

    public SuporteAr(PainelPrincipal painelPrincipal, Posicao posicao)
    {
        super(painelPrincipal,
                "/pt/ipleiria/estg/p2/projeto/imagens/suportes/ar.png",
                posicao);
    }

    @Override
    public boolean aceitas(Suportado suportado, Posicao posicao, Sentido sentido)
    {
        if (sentido == Sentido.S) {
            getPainelPrincipal().podeCair(suportado, posicao, sentido);
        }
        return false;
    }
}
