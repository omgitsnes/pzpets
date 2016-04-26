package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;

public class Suporte extends Representavel
{
    private Posicao posicao;
    
    /**
     * 
     * @param representacao
     * @param posicao
     */
    public Suporte(CellRepresentation representacao, Posicao posicao)
    {
        super(representacao);
        this.posicao = posicao;
    }
    
    public Posicao getPosicao()
    {
        return this.posicao;
    }
}
