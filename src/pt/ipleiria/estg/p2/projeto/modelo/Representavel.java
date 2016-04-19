package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;

public class Representavel
{
    public CellRepresentation representacao;

    public Representavel(CellRepresentation representacao)
    {
        super();
        this.representacao = representacao;
    }

    /**
     * @return CellRepresentation Representacao do objeto
     */
    public CellRepresentation getRepresentacao()
    {
        return this.representacao;
    }
}
