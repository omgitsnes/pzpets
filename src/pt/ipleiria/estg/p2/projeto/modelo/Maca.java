package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuportadoPorGelo;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Maca extends SuportadoPorGelo
{

    public Maca(String representacao, SuporteSuportador suporte)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/maca.png",
                suporte);
    }



}
