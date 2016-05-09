package pt.ipleiria.estg.p2.projeto.modelo.animais;

import java.util.Random;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Movel;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Suporte;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAr;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteComSuportado;

public class Animal extends Movel
{
    private boolean movimentoExtra;

    public Animal(CellRepresentation representacao, SuporteComSuportado suporte) 
    {
        super(representacao, suporte);
        this.movimentoExtra = randomMovimentoExtra();
    }

    /**
     * Procura nos suportes a Sul se existe uma posicao livre
     * Se a posiscao estiver livre, devolve a posicao
     * no caso de encontrar um suporteAr a S verifica se a posicao abaixo dessa esta vazia
     * @param suportes
     * @param linha
     * @param coluna
     * @return Posicao novaPosiçao ou null caso nao tenha possibilidade de cair
     */
    public Posicao podeCair(Suporte[][] suportes, int linha, int coluna)
    {
        if (suportes[linha + 1][coluna] instanceof SuporteAr) {
            return podeCair(suportes, linha + 1, coluna);
        } else {
            if (!(suportes[linha + 1][coluna] instanceof SuporteAr)) {
                if (((SuporteComSuportado) suportes[linha + 1][coluna]).getSuportado() == null) {
                    System.out.println("pode cair para baixo!");
                    return new Posicao(linha + 1, coluna);
                }
            }
            if (!(suportes[linha + 1][Math.max(0, coluna - 1)] instanceof SuporteAr)) {
                if (((SuporteComSuportado) suportes[linha + 1][Math.max(0, coluna - 1)]).getSuportado() == null) {
                    System.out.println("pode cair para a esquerda!");
                    return new Posicao(linha + 1, Math.max(0, coluna - 1));
                }
            }
            if (!(suportes[linha + 1][Math.min(7, coluna + 1)] instanceof SuporteAr)) {
                if (((SuporteComSuportado) suportes[linha + 1][Math.min(7, coluna + 1)]).getSuportado() == null) { //TODO valor para a largura dinamico
                    System.out.println("pode cair para a direita!");
                    return new Posicao(linha + 1, Math.min(7, coluna + 1));
                }
            }
        }
        return null;
    }
    
    /**
     * Muda a posicao do Suportado para a nova posicao na matriz de suportes
     * @param suportes
     * @param posicao
     * @param linha
     * @param coluna
     */
    public void cair(Suporte[][] suportes, Posicao posicao, int linha, int coluna)
    {
        //deve este metodo ser na classe suporte?
        //colocar no novo suporte
        ((SuporteComSuportado) suportes[posicao.getLinha()][posicao.getColuna()]).setSuportado(((SuporteComSuportado) suportes[linha][coluna]).getSuportado());

        //tirar do suporte antigo
        ((SuporteComSuportado) suportes[linha][coluna]).setSuportado(null);
    }
    
    public boolean isMovimentoExtra()
    {
        return movimentoExtra;
    }

    /**
     * Devolve um valor true com uma probabilidade de 10%
     * 
     */
    private boolean randomMovimentoExtra()
    {
        return new Random().nextInt(10) == 1 ? true : false;
    }
}
