package pt.ipleiria.estg.p2.projeto.modelo.suportaveis;

import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.SuportadoPorGelo;
import pt.ipleiria.estg.p2.projeto.modelo.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Maca extends SuportadoPorGelo implements Iteravel
{
	
    
    public Maca(SuporteSuportador suporte)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/maca.png",suporte);
    }

	@Override
	public void iterar(long tempo) {
	    System.out.println(this + " Ser� que posso cair ?");
		if (getSuporte().podeCair(Sentido.S)) {
		    System.out.println(this + " Posso cair para baixo!");
		    getSuporte().fazMeCair(Sentido.S);
		}
		    else if (getSuporte().podeCair(Sentido.SE)) {
		    		System.out.println(this + " Posso cair para a direita!");
		    		getSuporte().fazMeCair(Sentido.SE);
		    }
		    	else if (getSuporte().podeCair(Sentido.SO)) {
		    			System.out.println(this + " Posso cair para a esquerda!");
		    			getSuporte().fazMeCair(Sentido.SO);
		    	}
		
		else {
		    System.out.println(this + " Nao posso cair!");
		}
		
	}
}
