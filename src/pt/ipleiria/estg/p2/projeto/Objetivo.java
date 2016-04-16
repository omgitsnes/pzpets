package pt.ipleiria.estg.p2.projeto;

public class Objetivo {
    private int numeroDeMacasParaApanhar; // Numero de macas necessarias para alcancar o Objetivo 
    private int numeroDeMovimentos; // Numero limite de Movimentos para alcancar o Objetivo
    private int pontuacao; // Pontuacao minima necessaria para alcancar o Objetivo
    private int numeroDeSuportesCongelados; // Numero maximo de suportes Congelados alcancar o Objetivo

    public Objetivo(int numeroDeMacasParaApanhar, int numeroDeMovimentos, int pontuacao, int numeroDesuportesCongelados)
    {
        this.numeroDeMacasParaApanhar = numeroDeMacasParaApanhar;
        this.numeroDeMovimentos = numeroDeMovimentos;
        this.pontuacao = pontuacao;
        this.numeroDeSuportesCongelados = numeroDesuportesCongelados;
    }

    /**
     * Calcula o numero de estrelas a apresentar no PainelMovimentoEstrelas
     * de acordo com as Macas, Movimentos, e Pontuacao do jogo Atual e o Objetivo para o jogo
     * 
     * @param pontuacaoAtual Pontuacao atual do jogo
     * @param numeroDeMacasPorApanhar Numero de macas por apanhar
     * @return Devolve o numero de estrelas segundo o objetivo final e o alcancado 
     * TODO
     */
    public int calcularNumeroDeEstrelas(int pontuacaoAtual, int numeroDeMacasPorApanhar)
    {
        if ((numeroDeMacasParaApanhar <= (numeroDeMacasParaApanhar - numeroDeMacasPorApanhar)) && (pontuacao <= pontuacaoAtual)) {
            return 3;
        }
        if (((numeroDeMacasParaApanhar / 1.5) <= (numeroDeMacasParaApanhar - numeroDeMacasPorApanhar)) && ((pontuacao / 1.5) <= pontuacaoAtual)) {
            return 2;
        }
        if (((numeroDeMacasParaApanhar / 3) <= (numeroDeMacasParaApanhar - numeroDeMacasPorApanhar)) && ((pontuacao / 3) <= pontuacaoAtual)) {
            return 1;
        }
        return 0;
    }

    public int getNumeroDeMovimentos()
    {
        return numeroDeMovimentos;
    }

    public int getNumeroDeSuportesCongelados()
    {
        return numeroDeSuportesCongelados;
    }
}
