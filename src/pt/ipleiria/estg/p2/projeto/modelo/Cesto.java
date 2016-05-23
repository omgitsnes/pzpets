package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAgua;


public class Cesto extends Suportado<SuporteAgua> implements Iteravel
{
	/* suporte, imagem, estado(cheio ou nao (altera a imagem)), tempodeEstado*/
	
    public Cesto(SuporteAgua suporte) {
        super("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/cesto.png",suporte);
       
    }
	
	/*public Estado verificarEstado()
	{
		
	}*/
    
    public void iterar(long tempo){
    	System.out.println("estou no cesto");
    }
}
