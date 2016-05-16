package pt.ipleiria.estg.p2.projeto.modelo.inimigos;

import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Terra extends InimigoExplosivo
{

    public Terra(String representacao, 
            SuporteSuportador<TSuportavel> suporte, 
            int valor)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/inimigos/terra.png", 
                suporte, 
                30);
    }

}
