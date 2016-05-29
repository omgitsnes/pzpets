package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.p2.projeto.modelo.suportes.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuportadoPorGelo;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Maca extends SuportadoPorGelo implements Iteravel
{
	
    
    public Maca(SuporteSuportador suporte)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/maca.png",
                suporte);
    }

	@Override
	public void iterar(long tempo) {
	    System.out.println(this + " Pronta para cair!");
		if (getSuporte().podeCair(Sentido.S)) {
		    System.out.println(this + "Posso cair!");
		    getSuporte().fazMeCair(Sentido.S);
		} else {
		    System.out.println(this + " Nao pode cair!");
		}
		
	}
}
