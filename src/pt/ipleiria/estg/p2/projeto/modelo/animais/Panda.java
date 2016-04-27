package pt.ipleiria.estg.p2.projeto.modelo.animais;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.SuporteComSuportado;

public class Panda extends Animal
{
    public Panda(SuporteComSuportado suporte) 
    {
        super(new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/animais/panda.png"), suporte);		
    }
}
