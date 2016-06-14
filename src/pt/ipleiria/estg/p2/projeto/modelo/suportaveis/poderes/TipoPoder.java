package pt.ipleiria.estg.p2.projeto.modelo.suportaveis.poderes;

public enum TipoPoder {
	ARCOIRIS("/pt/ipleiria/estg/p2/projeto/imagens/poderes/arcoIris.png"),
	MOVIMENTOEXTRA("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	
	PANDACRUZ("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PANDAVERTICAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PANDAHORIZONTAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PANDAESTRELA("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),

	
	SAPOCRUZ("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	SAPOVERTICAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	SAPOHORIZONTAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	SAPOESTRELA("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),

	
	POLVOCRUZ("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	POLVOVERTICAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	POLVOHORIZONTAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	POLVOESTRELA("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),

	
	RAPOSACRUZ("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	RAPOSAVERTICAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	RAPOSAHORIZONTAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	RAPOSAESTRELA("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),

	
	PEIXECRUZ("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PEIXEVERTICAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PEIXEHORIZONTAL("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png"),
	PEIXEESTRELA("/pt/ipleiria/estg/p2/projeto/imagens/poderes/pandaCruz.png");
	
			


    
	private String representacao;

    private TipoPoder(String str) {
        representacao = str;
    }

    public String getRepresentacao(){
        return representacao;
    }
	
}
