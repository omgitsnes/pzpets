package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Representavel;

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
