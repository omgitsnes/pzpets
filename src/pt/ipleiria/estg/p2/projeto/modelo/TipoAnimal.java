package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public enum TipoAnimal {
		
		PEIXE("/imagens/animais/peixe.png"), 
		POLVO("/imagens/animais/polvo.png"), 
		RAPOSA("/imagens/animais/raposa.png"), 
		SAPO("/imagens/animais/sapo.png"), 
		PANDA("/imagens/animais/panda.png");
		
		private SingleImageCellRepresentation imagem;

		private TipoAnimal(String str) {
			imagem = new SingleImageCellRepresentation(str);
		}
		
		public SingleImageCellRepresentation getImagem(){
			return imagem;
		}
	};


