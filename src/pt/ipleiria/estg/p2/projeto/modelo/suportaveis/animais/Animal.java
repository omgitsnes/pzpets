package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.animais;

import java.util.Random;
import pt.ipleiria.estg.p2.projeto.modelo.Combinavel;
import pt.ipleiria.estg.p2.projeto.modelo.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Temporizador;
import pt.ipleiria.estg.p2.projeto.modelo.TipoAnimal;

public class Animal extends Combinavel implements Iteravel
{

    private TipoAnimal tipo;
    private boolean movimentoExtra;
    private int valor;
    private Temporizador temporizador;

    public TipoAnimal getTipo()
    {
        return tipo;
    }

    public Animal(TipoAnimal tipo)
    {
        super(tipo.getRepresentacao(), null);
        this.tipo = tipo;
        this.movimentoExtra = randomMovimentoExtra();
        this.valor = 25;
        this.temporizador = new Temporizador(250);
    }

    @Override
    public String toString()
    {
        return "[" + tipo + "]";
    }

    @Override
    public void iterar(long tempo)
    {
        Sentido[] sentidos = {Sentido.S, Sentido.SE, Sentido.SO};
        if (temporizador.getSegundosEmFalta() <= 0) {
            temporizador.reiniciar();
            for (Sentido sentido : sentidos) {
                if (getSuporte().podeCair(sentido)) {
                    getSuporte().fazMeCair(sentido);
                    break;
                }
            }
            getSuporte().deixaMeExplodir();
        }
    }

    /**
     * Devolve um valor true com uma probabilidade de 10%
     *
     */
    private boolean randomMovimentoExtra()
    {
        return new Random().nextInt(10) == 1 ? true : false;
    }

    public int getValor()
    {
        return valor;
    }

}
