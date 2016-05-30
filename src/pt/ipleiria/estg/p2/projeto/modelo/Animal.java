package pt.ipleiria.estg.p2.projeto.modelo;

public class Animal extends Suportado {

	private TipoAnimal tipo;

	public TipoAnimal getTipo() {
		return tipo;
	}

	public Animal(TipoAnimal tipo) {
		super(tipo.getImagem());
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


}