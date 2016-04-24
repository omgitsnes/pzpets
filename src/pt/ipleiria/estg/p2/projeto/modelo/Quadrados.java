package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;

public class Quadrados extends Representavel
{
    private Posicao posicao;

    /**
     * 
     * @param representacao
     * @param posicao
     */
    public Quadrados(CellRepresentation representacao, Posicao posicao)
    {
        super(representacao);
        this.posicao = posicao;
    }
    
    public Posicao getPosicao()
    {
        return this.posicao;
    }
}
