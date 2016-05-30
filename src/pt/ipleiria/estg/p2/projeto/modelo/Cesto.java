package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Suporte;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAgua;


public class Cesto extends Suportado<SuporteAgua> implements Iteravel
{
    public Cesto(SuporteAgua suporte) {
        super("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/cesto.png",suporte);
    }
    
    public void iterar(long tempo){
    	
    }

	public boolean aceitas(Suportado suportado) {
		if(suportado instanceof Maca) {
		    System.out.println(this + " Aceito a Maca!");
		    return true;
		}
		return false;
	}

	public void tomaLa(Suportado suportado, Posicao posicao, Sentido s) {
		representacao = new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/cestoComMaca.png");
		getSuporte().actualizarImagem();
	}
}
