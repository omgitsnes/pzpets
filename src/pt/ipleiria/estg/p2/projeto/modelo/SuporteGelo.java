package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class SuporteGelo extends Suporte
{
/* Verificar o Estado
 * Animal
 * Poder
 * Maca
 * Inimigo
 */
	
	
	public void influenciar(){
		
	}
	
	private Posicao posicao;
	
	public SuporteGelo(Posicao posicao) {
		super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/suportes/gelo.png"));
		this.posicao = posicao;
	}

	public void explodir(){
		
	}
	
	public void verificarEstado(){
		
	}
	
	public void descongelar(){
	
}

}
