package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;

public class Suportavel extends Representavel
{
    private SuporteComSuportado suporte;
    
    /**
     * 
     * @param representacao
     * @param suporte
     */
    public Suportavel(CellRepresentation representacao, SuporteComSuportado suporte)
    {
        super(representacao);
    }
    
    public SuporteComSuportado getSuporte()
    {
        return suporte;
    }
}
