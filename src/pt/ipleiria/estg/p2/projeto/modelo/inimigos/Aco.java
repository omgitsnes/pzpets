package pt.ipleiria.estg.p2.projeto.modelo.inimigos;

import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Aco extends InimigoExplosivo
{

    public Aco(String representacao, SuporteSuportador<TSuportavel> suporte, int valor)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/inimigos/aco.png", 
                suporte, 
                100);
    }
    
}