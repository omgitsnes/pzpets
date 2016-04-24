package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;

public class Suportavel extends Representavel
{
    private Suporte suporte;
    
    /**
     * 
     * @param representacao
     * @param suporte
     */
    public Suportavel(CellRepresentation representacao, Suporte suporte)
    {
        super(representacao);
    }
    
    public Suporte getSuporte()
    {
        return suporte;
    }
}
