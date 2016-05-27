package pt.ipleiria.estg.p2.projeto.modelo;


public enum Sentido {
	SO(1, -1), S(1, 0), SE(1, 1), NO(-1, -1), N(-1, 0), NE(-1, 1), E(0, 1), O(0, -1);

	private Posicao delta;

	private Sentido(int linha, int coluna) {
		delta = new Posicao(linha, coluna);
	}

	public Posicao getDelta() {
		return delta;
	}

	public Posicao seguirSentido(Posicao inicial) {
		return inicial.getPosicaoDelta(delta);
	}

	private static int sinal(int valor) {
		return valor < 0 ? -1 : valor > 0 ? 1 : 0;
	}

	public static Sentido getSentido(int dLinha, int dColuna) {
		final Posicao paux = new Posicao(sinal(dLinha), sinal(dColuna));
		for (final Sentido s : values()) {
			if (s.delta.equals(paux)) {
				return s;
			}
		}
		return null;
	}

	public boolean isOrtogonal() {
		return this == N || this == S || this == E || this == O;
	}

	public boolean isHorizontal() {
		return this == E || this == O;
	}

	public Sentido getInverso() {
		return getSentido(-delta.getLinha(), -delta.getColuna());
	}

	public Sentido getOrtogonal() {
		return getSentido(delta.getColuna(), delta.getLinha());
	}

	public int getLinha() {
		return delta.getLinha();
	}

	public int getColuna() {
		return delta.getColuna();
	}
}
