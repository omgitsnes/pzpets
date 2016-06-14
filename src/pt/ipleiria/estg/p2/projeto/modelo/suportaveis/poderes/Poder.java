package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.poderes;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Combinavel;
import pt.ipleiria.estg.p2.projeto.modelo.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.TipoAnimal;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Poder extends Combinavel implements Iteravel 	 {
	
	private TipoPoder tipo;
	
	public Poder(TipoPoder tipoPoder, SuporteSuportador suporte) {
		super(tipoPoder.getRepresentacao(), suporte);
		this.tipo = tipoPoder;
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
        else{
        	getSuporte().deixaMeExplodir();
        }
		
	}
	
	
	
}
