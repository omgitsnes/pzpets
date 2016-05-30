package pt.ipleiria.estg.p2.projeto.modelo;

public enum TipoAnimal 
{
    PEIXE("/pt/ipleiria/estg/p2/projeto/imagens/animais/peixe.png"), 
    POLVO("/pt/ipleiria/estg/p2/projeto/imagens/animais/polvo.png"), 
    RAPOSA("/pt/ipleiria/estg/p2/projeto/imagens/animais/raposa.png"), 
    SAPO("/pt/ipleiria/estg/p2/projeto/imagens/animais/sapo.png"), 
    PANDA("/pt/ipleiria/estg/p2/projeto/imagens/animais/panda.png");

    private String representacao;

    private TipoAnimal(String str) {
        representacao = str;
    }

    public String getRepresentacao(){
        return representacao;
    }
}


