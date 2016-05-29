package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Cesto;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public class SuporteAgua extends SuporteSuportador<Suportado>
{
    public SuporteAgua(PainelPrincipal painelPrincipal, Posicao posicao)
    {
        super(painelPrincipal, 
                "/pt/ipleiria/estg/p2/projeto/imagens/suportes/agua.png", 
                posicao);
    }

    @Override
    public boolean aceitas(Suportado suportado, Posicao posicao, Sentido s)
    {
        if (getSuportado() == null) {
          return true;
        } else {
            if (getSuportado() instanceof Cesto) {
                return ((Cesto)getSuportado()).aceitas(suportado);
            }
        }
        return false;
    }
}
