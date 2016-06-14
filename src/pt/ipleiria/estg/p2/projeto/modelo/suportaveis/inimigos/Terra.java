package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.inimigos;

import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.SuportadoPorGelo;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Terra extends SuportadoPorGelo
{

    public Terra(String representacao, SuporteSuportador suporte)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/inimigos/terra.png", suporte);
    }

}
