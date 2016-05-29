package pt.ipleiria.estg.p2.projeto.modelo.suportes;

import javax.swing.plaf.ActionMapUIResource;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Cesto;
import pt.ipleiria.estg.p2.projeto.modelo.Maca;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public class Suporte
{
    private CellRepresentation representacao;
    protected Posicao posicao;
    protected Sentido sentido;
    private PainelPrincipal painelPrincipal;

    public Suporte(PainelPrincipal painelPrincipal, String representacao, Posicao posicao)
    {
        super();
        this.painelPrincipal = painelPrincipal;
        this.representacao = new SingleImageCellRepresentation(representacao);
        this.posicao = posicao;
    }

    public CellRepresentation getRepresentacao()
    {
        return representacao;
    }

    public Posicao getPosicao()
    {
        return posicao;
    }

    public PainelPrincipal getPainelPrincipal()
    {
        return painelPrincipal;
    }

    public boolean estadoDoCesto() {
        return false;
    }

    public void setRepresentacao(CellRepresentation representacao)
    {
        this.representacao = representacao;
    }

    public boolean aceitas(Suportado suportado, Posicao posicao, Sentido s) 
    {
        return false;
    }
    
    public boolean podeCair(Sentido sentido)
    {
        if (sentido != Sentido.S) {
            return false;
        }
        return true;
    }

    public void tomaLa(Suportado suportado, Posicao posicao, Sentido s) {
        
    }
}
