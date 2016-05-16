package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import pt.ipleiria.estg.p2.projeto.modelo.Posicao;

public class SuporteSuportador<TSuportavel> extends Suporte
{
    private TSuportavel suportado;
    
    /**
     * 
     * @param representacao
     * @param posicao
     */
    public SuporteSuportador(String representacao, Posicao posicao)
    {
        super(null, representacao, posicao);
    }

    public void setSuportado(TSuportavel suportado)
    {
        this.suportado = suportado;
    }
}
