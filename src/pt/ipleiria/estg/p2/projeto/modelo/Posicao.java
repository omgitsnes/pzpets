package pt.ipleiria.estg.p2.projeto.modelo;

public class Posicao {
    private int linha;
    private int coluna;

    /** 
     * Armazena uma posicao com uma linha e uma coluna
     * 
     * @param linha Numero de linha
     * @param coluna Numero de coluna
     * 
     */    
    public Posicao(int linha, int coluna)
    {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha()
    {
        return linha;
    }

    public int getColuna()
    {
        return coluna;
    }
}
