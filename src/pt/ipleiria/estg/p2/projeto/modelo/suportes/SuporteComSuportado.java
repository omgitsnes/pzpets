package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Suportavel;

public class SuporteComSuportado extends Suporte
{
    private Suportavel suportado;

    /**
     * 
     * @param representacao
     * @param posicao
     */
    public SuporteComSuportado(CellRepresentation representacao, Posicao posicao) 
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
