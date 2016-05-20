package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Suportado<TSuportado extends SuporteSuportador>
{
    private TSuportado suporte;

    public Suportado(TSuportado suporte)
    {
        super();
        this.suporte = suporte;
    }

    public TSuportado getSuporte()
    {
        return suporte;
    }

    public void setSuporte(TSuportado suporte)
    {
        this.suporte = suporte;
    }
    
    
}
