package pt.ipleiria.estg.p2.projeto;

public class PainelDeMacas
{
    //private Grelha grelha;
    //private Imagem imagem;
    private int numeroDeMacasPorApanhar;
    
    public PainelDeMacas(int numeroDeMacasPorApanhar)
    {
        this.numeroDeMacasPorApanhar = numeroDeMacasPorApanhar;
    }

    public void diminuirMacas()
    {
        this.numeroDeMacasPorApanhar --;
    }
}
