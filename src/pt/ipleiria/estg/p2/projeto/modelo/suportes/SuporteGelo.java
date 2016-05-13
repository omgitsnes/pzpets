package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Posicao;

public class SuporteGelo extends SuporteInfluenciado<TSuportavelPorGelo>
{
    public SuporteGelo(Posicao posicao)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/suportes/gelo.png", posicao);
    }
}
