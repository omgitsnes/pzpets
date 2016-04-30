package pt.ipleiria.estg.p2.projeto.modelo.animais;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteComSuportado;

public class Peixe extends Animal
{
	public Peixe(SuporteComSuportado suporte) 
    {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/animais/peixe.png"), suporte);        
    }
}
