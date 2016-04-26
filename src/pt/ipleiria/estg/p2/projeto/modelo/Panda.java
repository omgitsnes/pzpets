package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Panda extends PotencialMovimentoExtra
{
/* Imagem Panda*/

	public Panda(SuporteComSuportado suporte) 
	{
		super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/animais/panda.png"), suporte);		
	}

	public void explodir()
	{
		
	}
	
	public void combinar()
	{
		
	}

	public void cair()
	{
	
	}
	public void podeCair(Suporte[][] suportes, int linha, int coluna)
	{
		if (((SuporteComSuportado) suportes[linha + 1][coluna]).getSuportado() == null) {
		    System.out.println("pode cair!");
		} else {
		    System.out.println("nao pode cair!");
		}
		
	}
}
