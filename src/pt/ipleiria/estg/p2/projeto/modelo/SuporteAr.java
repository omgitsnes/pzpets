package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class SuporteAr extends Suporte {

	private Posicao posicao;

	public SuporteAr(Posicao posicao) {
		super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/suportes/ar.png"));
		this.posicao = posicao;
	}

}
