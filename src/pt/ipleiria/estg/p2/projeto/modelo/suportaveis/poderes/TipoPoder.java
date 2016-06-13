package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.poderes;

public enum TipoPoder {
	PANDACRUZ("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PANDAVERTICAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PANDAHORIZONTAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PANDAESTRELA("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PANDAARCOIRIS("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PANDAMOVIMENTOEXTRA("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png");
	
    private String representacao;

    private TipoPoder(String str) {
        representacao = str;
    }

    public String getRepresentacao(){
        return representacao;
    }
	
}
