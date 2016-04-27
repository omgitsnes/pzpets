package pt.ipleiria.estg.p2.projeto.modelo.animais;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.SuporteComSuportado;

public class Polvo extends Animal
{
	public Polvo(SuporteComSuportado suporte) 
    {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/animais/polvo.png"), suporte);        
    }
}
