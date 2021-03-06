package pt.ipleiria.estg.p2.projeto.modelo;

public class Objetivo 
{
    private int numeroDeMacasParaApanhar; 
    private int numeroDeMovimentosMaximo;
    private int pontuacaoMinima;
    private int numeroDeSuportesCongelados;

    /**
     * 
     * @param numeroDeMacasParaApanhar Numero de macas necessarias para alcancar o Objetivo 
     * @param numeroDeMovimentos Numero limite de Movimentos para alcancar o Objetivo
     * @param pontuacaoMinima Pontuacao minima necessaria para alcancar o Objetivo
     * @param numeroDesuportesCongelados Numero maximo de suportes Congelados alcancar o Objetivo
     */
    public Objetivo(int numeroDeMacasParaApanhar, int numeroDeMovimentos, int pontuacaoMinima, int numeroDesuportesCongelados)
    {
        this.numeroDeMacasParaApanhar = numeroDeMacasParaApanhar;
        this.numeroDeMovimentosMaximo = numeroDeMovimentos;
        this.pontuacaoMinima = pontuacaoMinima;
        this.numeroDeSuportesCongelados = numeroDesuportesCongelados;
    }

    /**
     * Calcula o numero de estrelas a apresentar no PainelMovimentoEstrelas
     * de acordo com as Macas, ?Movimentos?, e Pontuacao do jogo Atual e o Objetivo para o jogo
     * 
     * @param pontuacaoAtual Pontuacao atual do jogo
     * @param numeroDeMacasPorApanhar Numero de macas por apanhar
     * @return Devolve o numero de estrelas segundo o objetivo final e o alcancado 
     * TODO
     */
    public int calcularNumeroDeEstrelas(int pontuacaoAtual, int numeroDeMacasPorApanhar)
    {
        if ((numeroDeMacasParaApanhar <= (numeroDeMacasParaApanhar - numeroDeMacasPorApanhar)) && (pontuacaoMinima <= pontuacaoAtual)) {
            return 3;
        }
        if (((numeroDeMacasParaApanhar / 1.5) <= (numeroDeMacasParaApanhar - numeroDeMacasPorApanhar)) && ((pontuacaoMinima / 1.5) <= pontuacaoAtual)) {
            return 2;
        }
        if (((numeroDeMacasParaApanhar / 3) <= (numeroDeMacasParaApanhar - numeroDeMacasPorApanhar)) && ((pontuacaoMinima / 3) <= pontuacaoAtual)) {
            return 1;
        }
        return 0;
    }

    public int getNumeroDeMovimentosMaximo()
    {
        return numeroDeMovimentosMaximo;
    }

    public int getNumeroDeSuportesCongelados()
    {
        return numeroDeSuportesCongelados;
    }

    public int getNumeroDeMacasParaApanhar()
    {
        return numeroDeMacasParaApanhar;
    }

    public int getPontuacaoMinima()
    {
        return pontuacaoMinima;
    }
}
