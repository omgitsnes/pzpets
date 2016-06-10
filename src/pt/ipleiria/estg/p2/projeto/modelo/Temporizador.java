package pt.ipleiria.estg.p2.projeto.modelo;

public class Temporizador
{
    private int intervalo;
    public long proximoTempo;

    public Temporizador(int intervalo)
    {
        this.intervalo = intervalo;
    }

    public void reiniciar()
    {
        proximoTempo = System.currentTimeMillis() + intervalo;
    }

    public int getMilissegundosEmFalta()
    {
        return (int) Math.max(0, proximoTempo - System.currentTimeMillis());
    }

    public int getSegundosEmFalta()
    {
        return (int) Math.ceil(getMilissegundosEmFalta() / 1000);
    }
}
