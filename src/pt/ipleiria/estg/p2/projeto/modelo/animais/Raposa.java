package pt.ipleiria.estg.p2.projeto.modelo.animais;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteComSuportado;

public class Raposa extends Animal
{
	public Raposa(SuporteComSuportado suporte) 
    {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/animais/raposa.png"), suporte);        
    }
}
