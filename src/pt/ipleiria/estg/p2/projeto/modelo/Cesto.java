package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteComSuportado;

public class Cesto extends Suportavel
{
	/* suporte, imagem, estado(cheio ou nao (altera a imagem)), tempodeEstado*/
	
    public Cesto( SuporteComSuportado suporte) {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/cesto.png"), suporte);
        // TODO Auto-generated constructor stub
    }
	
	/*public Estado verificarEstado()
	{
		
	}*/
}
