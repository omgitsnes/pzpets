package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.PainelDecrementador;

public class PainelDeMovimentosEstrelas extends PainelDecrementador
{
    public PainelDeMovimentosEstrelas(GridPanel gridPanel, int valor)
    {
        super(gridPanel,
                new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/movimentos0Estrelas.png"),
                new TextCellRepresentation(Integer.toString(valor)),
                valor);
    }

    /**
     * Incrementa em 1 valor o numero de movimentos disponiveis.
     * Sempre que seja rebentado um animal com movimentos extras
     */
    public void incrementarValor()
    {
        this.valor++;
    }

//    private void atualizarRepresentacaoNumeroDeEstrelas(int numeroDeEstrelas)
//    {
//        this.getGridPanel().clear(0, 0);
//        switch (numeroDeEstrelas) {
//            case 0: this.getGridPanel().add(0, 0, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/movimentos0Estrelas.png"));
//                break;
//            case 1: this.getGridPanel().add(0, 0, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/movimentos1Estrelas.png"));
//                break;
//            case 2: this.getGridPanel().add(0, 0, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/movimentos2Estrelas.png"));
//                break;
//            default: this.getGridPanel().add(0, 0, new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/paineis/movimentos3Estrelas.png"));
//                break;
//        }
//    }

    @Override
    public void atualizarIndicacao()
    {
        super.atualizarIndicacao();
        //Calcular numero de Estrelas
        //atualizarRepresentacaoNumeroDeEstrelas(numeroDeEstrelas);
    }
}

