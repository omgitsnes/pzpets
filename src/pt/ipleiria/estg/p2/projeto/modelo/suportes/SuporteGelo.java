package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.SuportadoPorGelo;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public class SuporteGelo extends SuporteSuportador<SuportadoPorGelo>
{
    public SuporteGelo(PainelPrincipal painelPrincipal, Posicao posicao)
    {
        super(painelPrincipal, 
                "/pt/ipleiria/estg/p2/projeto/imagens/suportes/gelo.png", 
                posicao);
    }

    @Override
    public boolean aceitas(Suportado suportado, Posicao posicao, Sentido s)
    {
        if (getSuportado() == null) {
            return true;
        }
        return false;
        
    }
}
