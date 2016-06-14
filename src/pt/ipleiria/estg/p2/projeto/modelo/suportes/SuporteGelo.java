package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.SuportadoPorGelo;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;
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
    public boolean aceitas(Suportado suportado, Sentido s)
    {
        if (getSuportado() == null) {
            return true;
        }
        return false;
        
    }
}
