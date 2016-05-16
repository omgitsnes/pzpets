package pt.ipleiria.estg.p2.projeto.modelo.inimigos;

import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Pedra extends InimigoExplosivo
{

    public Pedra(String representacao, SuporteSuportador<TSuportavel> suporte, int valor)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/inimigos/pedra.png", 
                suporte, 
                50);
    }

}