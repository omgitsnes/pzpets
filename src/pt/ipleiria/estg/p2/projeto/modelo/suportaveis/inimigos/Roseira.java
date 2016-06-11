package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.inimigos;

import java.util.LinkedList;
import pt.ipleiria.estg.p2.projeto.modelo.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Temporizador;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class Roseira extends Inimigo implements Iteravel
{

    private Temporizador temporizador;
    private LinkedList<Espinho> espinhos;

    public Roseira(SuporteSuportador suporte)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/inimigos/roseira.png",
            suporte);
        this.temporizador = new Temporizador(10000);
        this.espinhos = new LinkedList<Espinho>();
    }

    public LinkedList<Espinho> getEspinhos()
    {
        return espinhos;
    }

    @Override
    public void iterar(long tempo)
    {
        if (temporizador.getSegundosEmFalta() <= 0) {
            gerarEspinho();
            temporizador.reiniciar();
        }
    }

    private void gerarEspinho()
    {
        //Pergunta ao Painel Principal se existe alguma posicao disponivel para
        //gerar novo espinho
        
        Posicao posicaoEspinho = this.getSuporte().gerarEspinho(espinhos);
        
        if (posicaoEspinho != null) {
            System.err.println("vou gerar espinho posicao: " + posicaoEspinho);
            gerarEspinho(posicaoEspinho);
        }
    }
    
    private void gerarEspinho(Posicao posicaoEspinho)
    {
        
        this.getSuporte().gerarEspinho(posicaoEspinho);
    }
    
    public void adicionarEspinho(Espinho espinho)
    {
        espinhos.add(espinho);
    }
}
