package pt.ipleiria.estg.p2.projeto.modelo.inimigos;

import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class InimigoExplosivo extends Inimigo
{
    private int valor;

    public InimigoExplosivo(String representacao, 
            SuporteSuportador<TSuportavel> suporte, 
            int valor)
    {
        super(representacao, suporte);
        this.valor = valor;
    }

    public int getValor()
    {
        return valor;
    }
    
}
