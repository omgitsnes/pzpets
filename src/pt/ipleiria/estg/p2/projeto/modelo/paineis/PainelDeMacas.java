package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.PainelComRepresentacao;

public class PainelDeMacas extends PainelComRepresentacao
{
	private int numeroDeMacasPorApanhar;
	
    /**
	 * O Painel de Macas é representado por uma imagem, contem um gridPanel e o numero de macas
	 * @param numeroDeMacasPorApanhar Inicialmente apresenta o numero de macas definido pelo objetivo
	 */
	public PainelDeMacas(GridPanel gridPanel, int numeroDeMacasPorApanhar)
	{
		super(gridPanel, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/macas.png"));
		this.numeroDeMacasPorApanhar = numeroDeMacasPorApanhar;
	}
	
	/**
	 * Decrementa em 1 valor o numero de macas por apanhar 
	 */
	public void decrementarMacasPorApanhar()
	{
		this.numeroDeMacasPorApanhar--;
	}

	public String getNumeroDeMacasPorApanhar()
	{
	    return Integer.toString(numeroDeMacasPorApanhar);
	}
}

