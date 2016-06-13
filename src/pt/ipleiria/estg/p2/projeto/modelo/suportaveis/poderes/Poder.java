package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.poderes;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.TipoAnimal;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Poder extends Suportado<SuporteSuportador> {
	
	private TipoPoder tipo;
	
	public Poder(TipoPoder tipoPoder, SuporteSuportador suporte) {
		super(tipoPoder.getRepresentacao(), suporte);
		this.tipo = tipoPoder;
	}
	
	
	
}
