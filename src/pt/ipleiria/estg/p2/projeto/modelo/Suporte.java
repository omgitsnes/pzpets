package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;

public class Suporte extends Quadrados
{
    private Suportavel suportado;

    /**
     * 
     * @param representacao
     * @param posicao
     */
    public Suporte(CellRepresentation representacao, Posicao posicao) 
    {
        super(representacao, posicao);
    }

    public Suportavel getSuportado()
    {
        return this.suportado;
    }
    
    public void setSuportado(Suportavel suportado)
    {
        this.suportado = suportado;
    }
}
