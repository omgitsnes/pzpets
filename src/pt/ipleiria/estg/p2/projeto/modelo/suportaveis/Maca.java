package pt.ipleiria.estg.p2.projeto.modelo.suportaveis;

import pt.ipleiria.estg.p2.projeto.modelo.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;

public class Maca extends SuportadoPorGelo implements Iteravel
{
	
    
    public Maca()
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/maca.png", null);
    }

	@Override
	public void iterar(long tempo) {
		if (getSuporte().podeCair(Sentido.S)) {
		    getSuporte().fazMeCair(Sentido.S);
		}
        else if (getSuporte().podeCair(Sentido.SE)) {
            getSuporte().fazMeCair(Sentido.SE);
        }
        else if (getSuporte().podeCair(Sentido.SO)) {
            getSuporte().fazMeCair(Sentido.SO);
        }
	}
}
