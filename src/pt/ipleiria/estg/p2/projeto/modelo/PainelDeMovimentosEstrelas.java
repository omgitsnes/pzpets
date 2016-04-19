package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class PainelDeMovimentosEstrelas extends PainelComRepresentacao
{
    private int numeroDeMovimentosDisponiveis;
    private int numeroDeEstrelasGanhas;
    /**
     * O Painel é representado por 3 possiveis imagens, contem um gridPanel o numero de movimentos
     * e o numero de estrelas.
     * O numero de estrelas inicia a 0
     * @param gridPanel
     * @param numeroDeMovimentosDisponiveis inicialmente é igual ao objetivo
     */
    public PainelDeMovimentosEstrelas(GridPanel gridPanel, int numeroDeMovimentosDisponiveis)
    {
        super(gridPanel, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/movimentos0Estrelas.png"));
        this.numeroDeMovimentosDisponiveis = numeroDeMovimentosDisponiveis;
        this.numeroDeEstrelasGanhas = 0;
    }

    /**
     * Decrementa em 1 valor o numero de movimentos disponiveis.
     */
    public void decrementarNumeroDeMovimentosDisponiveis() 
    {
        this.numeroDeMovimentosDisponiveis--;
    }

    /**
     * Incrementa em 1 valor o numero de movimentos disponiveis.
     * Sempre que seja rebentado um animal com movimentos extras
     */
    public void incrementarNumeroDeMovimentosDisponiveis()
    {
        this.numeroDeMovimentosDisponiveis++;
    }

    /**
     * TODO - só incrementar?
     * Altera o numero de estrelas e representacao do painel para corresponder 
     * a esse numero atraves de um outro metodo.
     * @param numeroDeEstrelas Novo numero de estrelas
     */
    public void setNumeroDeEstrelas(int numeroDeEstrelas)
    {
        this.numeroDeEstrelasGanhas = numeroDeEstrelas;
    }
}

