package pt.ipleiria.estg.p2.projeto.modelo.suportaveis;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Temporizador;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAgua;

public class Cesto extends Suportado<SuporteAgua> implements Iteravel
{

    private Temporizador temporizador;
    private boolean cheio;

    public Cesto(SuporteAgua suporte)
    {
        super("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/cesto.png", suporte);
        temporizador = new Temporizador(10000);
    }

    /**
     * A cada iteracao verifica o estado e enquanto estiver cheio vrtifiva se o
     * temporizador chegou a 0. Caso se verifique altera o valor do atributo
     * cheio.
     *
     * @param tempo
     */
    public void iterar(long tempo)
    {
        if (cheio) {
            if (temporizador.getSegundosEmFalta() == 0) {
                alterarEstado();
                alterarRepresentacao();
            }
        }
    }

    public boolean aceitas(Suportado suportado)
    {
        if (suportado instanceof Maca) {
            System.out.println(this + " Aceito a Maca!");
            return true;
        }
        return false;
    }

    /**
     * Altera a representacao e inicia/reinicia o temporizador
     * Pede para decrementar o numero de macas em jogo e o numero de macas no painel
     * 
     * 
     * @param suportado
     * @param posicao
     * @param s
     */
    public void tomaLa(Suportado suportado, Posicao posicao, Sentido s)
    {
        cheio = true;
        alterarRepresentacao();
        temporizador.reiniciar();
        getSuporte().aMacaCaiuNoCesto();
    }

    private void alterarEstado()
    {
        cheio = (cheio != true);
    }

    private void alterarRepresentacao()
    {
        if (cheio) {
            representacao = new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/cestoComMaca.png");
        } else {
            representacao = new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/cesto.png");
        }
        getSuporte().actualizarImagem();
    }
}
