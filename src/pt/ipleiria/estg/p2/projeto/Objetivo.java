package pt.ipleiria.estg.p2.projeto;

public class Objetivo {
    private int numeroDeMacasParaApanhar; // Numero de macas necessarias para alcancar o Objetivo 
    private int numeroDeMovimentos; // Numero limite de Movimentos para alcancar o Objetivo
    private int pontuacao; // Pontuacao minima necessaria para alcancar o Objetivo
    private int suportesCongelados; // Numero maximo de suportes Congelados alcancar o Objetivo

    public Objetivo(int numeroDeMacasParaApanhar, int numeroDeMovimentos, int pontuacao, int suportesCongelados)
    {
        this.numeroDeMacasParaApanhar = numeroDeMacasParaApanhar;
        this.numeroDeMovimentos = numeroDeMovimentos;
        this.pontuacao = pontuacao;
        this.suportesCongelados = suportesCongelados;
    }
    /**
     * Calcula o numero de estrelas a apresentar no PainelMovimentoEstrelas
     * de acordo com as Macas, Movimentos, e Pontuacao do jogo Atual e o Objetivo para o jogo
     * 
     * @param pontuacaoAtual Pontuacao atual do jogo
     * @param numeroDeMacasPorApanhar Numero de macas por apanhar
     * TODO
     */
    public int calcularNumeroDeEstrelas(int pontuacaoAtual, int numeroDeMacasPorApanhar)
    {
        if (numeroDeMacasParaApanhar <= (numeroDeMacasParaApanhar - numeroDeMacasPorApanhar)) {
            return 3;
        }
        if ((numeroDeMacasParaApanhar / 1.5) <= (numeroDeMacasParaApanhar - numeroDeMacasPorApanhar)) {
            return 2;
        }
        if ((numeroDeMacasParaApanhar / 3) <= (numeroDeMacasParaApanhar - numeroDeMacasPorApanhar)) {
            return 1;
        }
        return 0;
    }
}
