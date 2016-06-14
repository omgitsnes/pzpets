package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.inimigos;

import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.SuportadoPorGelo;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Pedra extends SuportadoPorGelo
{

    public Pedra(String representacao, SuporteSuportador suporte)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/inimigos/pedra.png", suporte);
    }

}