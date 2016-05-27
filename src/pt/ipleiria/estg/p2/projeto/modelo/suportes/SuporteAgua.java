package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
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
    
}
