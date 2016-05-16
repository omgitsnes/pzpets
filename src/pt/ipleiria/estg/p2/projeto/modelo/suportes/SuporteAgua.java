package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Posicao;

public class SuporteAgua extends SuporteSuportador<TSuportavelPorAgua>
{
    public SuporteAgua(Posicao posicao)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/suportes/agua.png", posicao);
    }
}
