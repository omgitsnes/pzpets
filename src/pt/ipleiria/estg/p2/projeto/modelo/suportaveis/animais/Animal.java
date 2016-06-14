package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.animais;

import java.util.Random;
import pt.ipleiria.estg.p2.projeto.modelo.Combinavel;
import pt.ipleiria.estg.p2.projeto.modelo.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.TipoAnimal;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Animal extends Combinavel implements Iteravel {

	private TipoAnimal tipo;
    private boolean movimentoExtra;

	public TipoAnimal getTipo() {
		return tipo;
	}

	public Animal(TipoAnimal tipo, SuporteSuportador suporte) {
		super(tipo.getRepresentacao(), suporte);
		this.tipo = tipo;
        this.movimentoExtra = randomMovimentoExtra();
	}

	@Override
	public String toString() {
		return "[" + tipo + "]";
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
    
    /**
     * Devolve um valor true com uma probabilidade de 10%
     * 
     */
    private boolean randomMovimentoExtra()
    {
        return new Random().nextInt(10) == 1 ? true : false;
    }

}