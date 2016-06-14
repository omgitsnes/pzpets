package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;

public class SuporteAr extends Suporte
{

    public SuporteAr(PainelPrincipal painelPrincipal, Posicao posicao)
    {
        super(painelPrincipal,
                "/pt/ipleiria/estg/p2/projeto/imagens/suportes/ar.png",
                posicao);
    }
    
    @Override
    public boolean aceitas(Suportado suportado, Sentido sentido)
    {
//        if (sentido == Sentido.S) {
//           return getPainelPrincipal().podeCair(suportado, sentido);
//        }
        return false;
    }

    @Override
    public boolean podeCair(Sentido sentido)
    {
        if (sentido == Sentido.S) {
            return true;
        }
        return false;
    }

    @Override
    public void tomaLa(Suportado suportado, Sentido s)
    {
        getPainelPrincipal().fazMeCair(suportado, s);
    }   
    
}
