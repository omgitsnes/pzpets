package pt.ipleiria.estg.p2.projeto;

public class Posicao {
    private int linha;
    private int coluna;
    
    /** Armazena uma posicao x e y
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

    public void setLinha(int linha)
    {
        this.linha = linha;
    }

    public int getColuna()
    {
        return coluna;
    }

    public void setColuna(int coluna)
    {
        this.coluna = coluna;
    }
    
}
