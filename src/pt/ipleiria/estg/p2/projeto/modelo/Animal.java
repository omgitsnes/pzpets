package pt.ipleiria.estg.p2.projeto.modelo;

import java.util.Random;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Iteravel;
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
		return "Animal [tipo=" + tipo + "]";
	}

    @Override
	public void iterar(long tempo) {
	    System.out.println(this + " Será que posso cair ?");
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
    
    /**
     * Devolve um valor true com uma probabilidade de 10%
     * 
     */
    private boolean randomMovimentoExtra()
    {
        return new Random().nextInt(10) == 1 ? true : false;
    }

}