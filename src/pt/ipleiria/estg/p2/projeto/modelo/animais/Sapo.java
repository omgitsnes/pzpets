package pt.ipleiria.estg.p2.projeto.modelo.animais;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteComSuportado;

public class Sapo extends Animal
{
	public Sapo(SuporteComSuportado suporte) 
    {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/animais/sapo.png"), suporte);        
    }
}
