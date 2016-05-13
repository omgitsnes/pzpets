package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Posicao;

public class SuporteInfluenciado<TSuportavel> extends Suporte
{
    private TSuportavel suportado;
    
    /**
     * 
     * @param representacao
     * @param posicao
     */
    public SuporteInfluenciado(String representacao, Posicao posicao)
    {
        super(representacao, posicao);
    }

    public void setSuportado(TSuportavel suportado)
    {
        this.suportado = suportado;
    }
}
