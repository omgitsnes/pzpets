package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.p2.projeto.modelo.suportes.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Animal extends Suportado implements Iteravel {

	private TipoAnimal tipo;

	public TipoAnimal getTipo() {
		return tipo;
	}

	public Animal(TipoAnimal tipo, SuporteSuportador suporte) {
		super(tipo.getRepresentacao(), suporte);
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animal [tipo=" + tipo + "]";
	}

    @Override
	public void iterar(long tempo) {
	    System.out.println(this + " Pronta para cair!");
		if (getSuporte().podeCair(Sentido.S)) {
		    System.out.println(this + "Posso cair para baixo!");
		    getSuporte().fazMeCair(Sentido.S);
		}
		    else if (getSuporte().podeCair(Sentido.SE)) {
		    		System.out.println(this + "Posso cair para a direita!");
		    		getSuporte().fazMeCair(Sentido.SE);
		    }
		    	else if (getSuporte().podeCair(Sentido.SO)) {
		    			System.out.println(this + "Posso cair para a esquerda!");
		    			getSuporte().fazMeCair(Sentido.SO);
		    	}
		
		else {
		    System.out.println(this + " Nao pode cair!");
		}
		
	}

}