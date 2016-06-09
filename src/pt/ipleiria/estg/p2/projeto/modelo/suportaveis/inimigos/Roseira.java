package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.inimigos;

import java.util.LinkedList;

import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Roseira extends InimigoComPosicao
{
    private int temporizador;
    private LinkedList<Espinho> espinhos;
    
    public Roseira(String representacao, SuporteSuportador suporte)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/inimigos/roseira.png", 
                suporte);
    }

    public int getTemporizador()
    {
        return temporizador;
    }

    public void setTemporizador(int temporizador)
    {
        this.temporizador = temporizador;
    }

    public LinkedList<Espinho> getEspinhos()
    {
        return espinhos;
    }

    public void setEspinhos(LinkedList<Espinho> espinhos)
    {
        this.espinhos = espinhos;
    }

}
