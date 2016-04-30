package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.PainelComRepresentacao;

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
     * 
     * Altera o numero de estrelas e representacao do painel para corresponder 
     * a esse numero atraves de um outro metodo.
     * @param numeroDeEstrelas Novo numero de estrelas
     */
    public void setNumeroDeEstrelas(int numeroDeEstrelas)
    {
        this.numeroDeEstrelasGanhas = numeroDeEstrelas;
        atualizarRepresentacaoNumeroDeEstrelas(this.numeroDeEstrelasGanhas);
    }

    private void atualizarRepresentacaoNumeroDeEstrelas(int numeroDeEstrelas)
    {
        this.getGridPanel().clear(0, 0);
        switch (numeroDeEstrelas) {
            case 0: this.getGridPanel().add(0, 0, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/movimentos0Estrelas.png"));
                break;
            case 1: this.getGridPanel().add(0, 0, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/movimentos1Estrelas.png"));
                break;
            case 2: this.getGridPanel().add(0, 0, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/movimentos2Estrelas.png"));
                break;
            default: this.getGridPanel().add(0, 0, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/movimentos3Estrelas.png"));
                break;
        }
    }

    public int getNumeroDeEstrelasGanhas()
    {
        return numeroDeEstrelasGanhas;
    }
}

