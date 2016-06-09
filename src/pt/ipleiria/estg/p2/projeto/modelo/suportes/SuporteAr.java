package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;
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
            System.out.println("Suporte de ar aceita que passe");
            return getPainelPrincipal().podeCair(suportado, getPosicao(), sentido);
        }
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
    public void tomaLa(Suportado suportado, Posicao posicao, Sentido s)
    {
        getPainelPrincipal().fazMeCair(suportado, getPosicao(), s);
    }
    
    
}
