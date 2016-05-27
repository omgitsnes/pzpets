package pt.ipleiria.estg.p2.projeto.modelo;

public class Posicao {
	private final int linha;
	private final int coluna;

	public Posicao(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
	}

	public Posicao() {
		this(0, 0);
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public Posicao getDelta(int deltaLinha, int deltaColuna) {
		return new Posicao(linha + deltaLinha, coluna + deltaColuna);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coluna;
		result = prime * result + linha;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Posicao other = (Posicao) obj;
		if (coluna != other.coluna) {
			return false;
		}
		if (linha != other.linha) {
			return false;
		}
		return true;
	}

	public Posicao getPosicaoDelta(Posicao delta) {
		return new Posicao(linha + delta.linha, coluna + delta.coluna);
	}

	public Posicao seguir(Sentido sentido) {
		return getPosicaoDelta(sentido.getDelta());
	}

	public Sentido getSentido(Posicao posicaoFinal) {
		final int dColuna = posicaoFinal.coluna - coluna;
		final int dLinha = posicaoFinal.linha - linha;
		return Sentido.getSentido(dLinha, dColuna);
	}

	public boolean isDentro(int numeroLinhas, int numeroColunas) {
		// TODO Auto-generated method stub
		return linha >= 0 && linha < numeroLinhas && coluna >= 0 && coluna < numeroColunas;
	}

	@Override
	public String toString() {
		return "Posicao [linha=" + linha + ", coluna=" + coluna + "]";
	}

}
