package pt.ipleiria.estg.p2.projeto.modelo.animais;

import java.util.Random;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Suportavel;
import pt.ipleiria.estg.p2.projeto.modelo.Suporte;
import pt.ipleiria.estg.p2.projeto.modelo.SuporteAr;
import pt.ipleiria.estg.p2.projeto.modelo.SuporteComSuportado;

public class Animal extends Suportavel 
{
    private boolean movimentoExtra;

    public Animal(CellRepresentation representacao, SuporteComSuportado suporte) 
    {
        super(representacao, suporte);
        this.movimentoExtra = randomMovimentoExtra();
    }

    public void cair(Suporte[][] suportes, Posicao posicao, int linha, int coluna)
    {
        //colocar no novo suporte
        ((SuporteComSuportado) suportes[posicao.getLinha()][posicao.getColuna()]).setSuportado(((SuporteComSuportado) suportes[linha][coluna]).getSuportado());

        //tirar do suporte antigo
        ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(null);
    }

    /**
     * Procura nos suportes a SO S e SE se existe uma posicao livre
     * no caso de encontrar um suporteAr a S verifica se a posicao abaixo esta vazia
     * @param suportes
     * @param linha
     * @param coluna
     * @return
     */
    public Posicao podeCair(Suporte[][] suportes, int linha, int coluna)
    {
        //TODO CAIR QUANDO ENCONTRA GRUPOS DE SUPORTE AR
        if (suportes[linha + 1][coluna].toString() == "SuporteAr") {
            podeCair(suportes, linha + 1, coluna);
        } else {
            if (!(suportes[linha + 1][Math.max(coluna, coluna - 1)] instanceof SuporteAr) && ((SuporteComSuportado) suportes[linha + 1][coluna]).getSuportado() == null) {
                System.out.println("pode cair para baixo!");
                Posicao a = new Posicao(linha + 1, coluna);
                return a;
            }
            if (!(suportes[linha + 1][Math.max(coluna, coluna - 1)] instanceof SuporteAr) && ((SuporteComSuportado) suportes[linha + 1][Math.max(0, coluna - 1)]).getSuportado() == null) {
                System.out.println("pode cair para a esquerda!");
                return new Posicao(linha + 1, Math.max(0, coluna - 1));
            }
            if (!(suportes[linha + 1][Math.max(coluna, coluna - 1)] instanceof SuporteAr) && ((SuporteComSuportado) suportes[linha + 1][Math.min(7, coluna + 1)]).getSuportado() == null) { //TODO valor para a largura dinamico
                System.out.println("pode cair para a direita!");
                return new Posicao(linha + 1, Math.min(7, coluna + 1));
            }
        }
        return null;
    }

    /**
     * Devolve um valor true com uma probabilidade de 10%
     * 
     */
    private boolean randomMovimentoExtra()
    {
        Random r = new Random();
        return r.nextInt(9) == 1 ? true : false;
    }

    public boolean isMovimentoExtra()
    {
        return movimentoExtra;
    }
}
