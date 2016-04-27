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

	public void cair(Suporte[][] suportes, Posicao posicao, int linha, int coluna)
	{
	    //colocar no novo suporte
	    ((SuporteComSuportado) suportes[posicao.getLinha()][posicao.getColuna()]).setSuportado(((SuporteComSuportado) suportes[linha][coluna]).getSuportado());

	    //tirar do suporte antigo
	    ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(null);
	}
	
	public Posicao podeCair(Suporte[][] suportes, int linha, int coluna)
	{
		if (suportes[linha + 1][coluna].toString() != "SuporteAr" && ((SuporteComSuportado) suportes[linha + 1][coluna]).getSuportado() == null) {
		    System.out.println("pode cair para baixo!");
		    return new Posicao(linha + 1, coluna);
		}
		if (suportes[linha + 1][Math.max(coluna, coluna - 1)].toString() != "SuporteAr" && ((SuporteComSuportado) suportes[linha + 1][Math.max(coluna, coluna - 1)]).getSuportado() == null) {
		    System.out.println("pode cair para a esquerda!");
            return new Posicao(linha + 1, Math.max(coluna, coluna - 1));
		}
		if (suportes[linha + 1][Math.min(7, coluna + 1)].toString() != "SuporteAr" &&((SuporteComSuportado) suportes[linha + 1][Math.min(7, coluna + 1)]).getSuportado() == null) { //TODO valor para a largura dinamico
		    System.out.println("pode cair para a direita!");
            return new Posicao(linha + 1, Math.min(7, coluna + 1));
		}
		return null;
	}
}
