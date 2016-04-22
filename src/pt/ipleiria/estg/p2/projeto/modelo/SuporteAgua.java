package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class SuporteAgua extends Suporte {
	private Posicao posicao;

	public SuporteAgua(Posicao posicao) {
		super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/suportes/agua.png"));

		this.posicao = posicao;

	}

	public void influenciar() {

	}

}
