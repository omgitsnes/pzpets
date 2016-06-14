package pt.ipleiria.estg.p2.projeto.modelo.paineis;

import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Random;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanelEventHandler;
import pt.ipleiria.estg.p2.projeto.modelo.Combinavel;
import pt.ipleiria.estg.p2.projeto.modelo.Jogo;
import pt.ipleiria.estg.p2.projeto.modelo.Posicao;
import pt.ipleiria.estg.p2.projeto.modelo.Sentido;
import pt.ipleiria.estg.p2.projeto.modelo.TipoAnimal;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Cesto;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Maca;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Movivel;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.animais.Animal;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.inimigos.Espinho;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.inimigos.Roseira;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.poderes.Poder;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.poderes.TipoPoder;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Suporte;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAgua;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAr;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteGelo;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

public class PainelPrincipal extends Painel implements GridPanelEventHandler
{

    private Jogo jogo;
    private Suporte[][] suportes;
    private int numeroDeMacasEmJogo;
    private int numeroDeSuportesCongelados;
    private Suporte suporteInicial;
    private static final int CADENCIA_DE_QUEDA = 100;
    private LinkedList<Posicao> listaSuportadosArebentar;

    /**
     * @param gridPanel
     */
    public PainelPrincipal(GridPanel gridPanel, Jogo jogo)
    {
        super(gridPanel);
        this.suportes = new Suporte[getNumeroDeLinhas()][getNumeroDeColunas()];
        this.numeroDeMacasEmJogo = 0;
        this.jogo = jogo;
        listaSuportadosArebentar = new LinkedList<Posicao>();
        gridPanel.setEventHandler(this);
        gerarNivel();
    }

    public int getNumeroDeSuportesCongelados()
    {
        return numeroDeSuportesCongelados;
    }

    public void incrementarNumeroDeMacasEmJogo()
    {
        numeroDeMacasEmJogo++;
    }

    public void decrementarNumeroDeMacasEmJogo()
    {
        numeroDeMacasEmJogo--;
    }

    public int getCadenciaDeQueda()
    {
        return CADENCIA_DE_QUEDA;
    }

    private void gerarNivel()
    {
        for (int i = 0; i < getNumeroDeLinhas(); i++) {
            for (int j = 0; j < getNumeroDeColunas(); j++) {
                //Primeiras 2 linhas
                if (i < 2) {
                    Suporte s = new SuporteAgua(this, new Posicao(i, j));
                    colocar(s);
                }
                // linhas 2 e 3 
                if (i > 1 && i < 4) {
                    if (j == 0 || j == 3 || j == 7) {
                        Suporte s = new SuporteAr(this, new Posicao(i, j));
                        colocar(s);
                    } else {
                        Suporte s = new SuporteGelo(this, new Posicao(i, j));
                        colocar(s);
                    }
                }
                //todas as outras
                if (i > 3) {
                    if ((i == 4 && j == 0) || (i == 4 && j == 7)) {
                        Suporte s = new SuporteAgua(this, new Posicao(i, j));
                        colocar(s);
                    } else {
                        Suporte s = new SuporteAgua(this, new Posicao(i, j));
                        colocar(s);
                    }
                }
                if (i == 7) {
                    Suporte s = new SuporteAgua(this, new Posicao(i, j));
                    colocar(s);
                }
            }
        }
        gerarCestos();
    }


    /*
	 * Adiciona os cestos ao ultimo suporte agua do painel
     */
    private void gerarCestos()
    {
        for (int j = 0; j < getNumeroDeColunas(); j++) {
            for (int i = getNumeroDeLinhas() - 1; i > 0; i--) {
                if (suportes[i][j] instanceof SuporteAgua) {
                    Cesto cesto = new Cesto((SuporteAgua) suportes[i][j]);
                    ((SuporteAgua) suportes[i][j]).colocar(cesto);
                    break;
                }
            }
        }
    }

    public void colocar(Suporte suporte)
    {
        // adicionar a matriz de suportes
        suportes[suporte.getPosicao().getLinha()][suporte.getPosicao().getColuna()] = suporte;
        //atualizar a imagem
        atualizarGridPanel(suporte);
    }

    public void iterar(long tempo)
    {

        for (int i = getNumeroDeLinhas() - 1; i >= 0; i--) {
            for (int j = 0; j < getNumeroDeColunas(); j++) {
                if (suportes[i][j] instanceof SuporteSuportador) {
                    ((SuporteSuportador) suportes[i][j]).iterar(tempo);
                }
            }
        }
        adicionarAnimalAleatorio();
    }

    /**
     * Altera um Suportado para uma nova posicao previamente validada
     *
     * @param suportado
     * @param posicao
     * @param sentido
     */
    public void fazMeCair(Suportado suportado, Sentido sentido)
    {
        Posicao novaPosicao = suportado.getPosicao().seguir(sentido);
        getSuporte(novaPosicao).tomaLa(suportado, sentido);
    }

    public boolean podeCair(Suportado suportado, Sentido sentido)
    {
        Posicao novaPosicao = suportado.getPosicao().seguir(sentido);

        if (isPosicaoValida(novaPosicao)) {
            return getSuporte(novaPosicao).aceitas(suportado, sentido);
        }
        return false;
    }

    @Override
    public void mousePressed(MouseEvent evt, int linha, int coluna)
    {
        suporteInicial = suportes[linha][coluna];
        // check if movivel
        // TODO CLASSE MOVIVEIS
        if (suporteInicial instanceof SuporteSuportador) {
            if (isMovivel(suporteInicial)) {
                System.out.println(((SuporteSuportador) suporteInicial).getSuportado() + "; L:"
                    + suporteInicial.getPosicao().getLinha() + "; C:" + suporteInicial.getPosicao().getColuna());
                listaSuportadosArebentar.add(new Posicao(linha, coluna));
            } else {
                suporteInicial = null;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent evt, int linha, int coluna)
    {
        if (suporteInicial != null) {
            Suporte suporteFinal = suportes[linha][coluna];
            if (suporteFinal instanceof SuporteSuportador) {
                if (isMovivel(suporteFinal)) {
                    Sentido sentido = suporteInicial.getPosicao().getSentido(suporteFinal.getPosicao());
                    System.out.println(sentido + " -> sentido");
                    if (sentido == Sentido.N || sentido == Sentido.S || sentido == Sentido.E || sentido == Sentido.O) {
                        System.out.println(sentido.seguirSentido(suporteInicial.getPosicao()) + " =? " + suporteFinal.getPosicao());
                        if (sentido.seguirSentido(suporteInicial.getPosicao()).equals(suporteFinal.getPosicao())) {
                            trocar(suporteFinal);
                            if (geraCombinacao(suporteInicial.getPosicao()) || geraCombinacao(suporteFinal.getPosicao())) {
                                System.err.println("Combinam");
                                jogo.decrementarMovimentosDisponiveis();
                            } else {
                                System.err.println("Nao combinam");
                                trocar(suporteFinal);
                            }
                        }
                    }
                }
            }
        }
    }

    public void podeExplodir(Posicao posicao)
    {
        if (geraCombinacao(posicao)) {
            explodir(posicao);
        }

    }


	public void explodir(Posicao posicao) {

		Sentido[] sentidos = { Sentido.E, Sentido.N };
		for (Sentido sentido : sentidos) {
			listaSuportadosArebentar.clear();
			// CombinacoesEspeciais
			// Combinacoes de 4 Animais
			if ((combinam(posicao, sentido, 2) && combinam(posicao, sentido.getInverso(), 1))
					|| (combinam(posicao, sentido, 1) && combinam(posicao, sentido.getInverso(), 2))) {

				if (listaSuportadosArebentar.size() == 4) {
					if ((sentido == Sentido.N || sentido == Sentido.S)) {
						for (Posicao pos : listaSuportadosArebentar) {
							if (getSuporte(pos) instanceof SuporteGelo) {
								explodirSuporte(pos);
							}
							((SuporteSuportador) getSuporte(pos)).colocar(null);
						}
						System.out.println(" COMBINACAO 4 !!! ");
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.PANDA)) {
							Poder p = new Poder(TipoPoder.PANDAVERTICAL, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						} // EXPLOSAO DAR COR CERTA
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.POLVO)) {
							Poder p = new Poder(TipoPoder.POLVOVERTICAL, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						}
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.SAPO)) {
							Poder p = new Poder(TipoPoder.SAPOHORIZONTAL, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						}
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.PEIXE)) {
							Poder p = new Poder(TipoPoder.PEIXEHORIZONTAL, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(1))).colocar(p);
						}
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.RAPOSA)) {
							Poder p = new Poder(TipoPoder.RAPOSAHORIZONTAL, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						}

						// colocar o poder horizontal correcto(getTipoAnimal) na
						// posicaoInicial
					}
					if (sentido == Sentido.E || sentido == Sentido.O) {

						System.out.println(" COMBINACAO 4 !!! ");
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.PANDA)) {
							Poder p = new Poder(TipoPoder.PANDAVERTICAL, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						} // EXPLOSAO DAR COR CERTA
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.POLVO)) {
							Poder p = new Poder(TipoPoder.POLVOVERTICAL, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						}
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.SAPO)) {
							Poder p = new Poder(TipoPoder.SAPOVERTICAL, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						}
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.PEIXE)) {
							Poder p = new Poder(TipoPoder.PEIXEVERTICAL, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(1))).colocar(p);
						}
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.RAPOSA)) {
							Poder p = new Poder(TipoPoder.RAPOSAVERTICAL, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						}
					}
				}
			} else if ((combinam(posicao, sentido, 1) && combinam(posicao, sentido.getInverso(), 1)
					&& combinam(posicao, sentido, 2) || combinam(posicao, sentido.getInverso(), 2))) {
				if (listaSuportadosArebentar.size() > 4) {
					if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.PANDA)) {
						Poder p = new Poder(TipoPoder.PANDAESTRELA, (SuporteSuportador) getSuporte(posicao));
						((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
					} // EXPLOSAO DAR COR CERTA
					if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.POLVO)) {
						Poder p = new Poder(TipoPoder.POLVOESTRELA, (SuporteSuportador) getSuporte(posicao));
						((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
					}
					if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.SAPO)) {
						Poder p = new Poder(TipoPoder.SAPOESTRELA, (SuporteSuportador) getSuporte(posicao));
						((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
					}
					if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.PEIXE)) {
						Poder p = new Poder(TipoPoder.PEIXEESTRELA, (SuporteSuportador) getSuporte(posicao));
						((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(1))).colocar(p);
					}
					if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.RAPOSA)) {
						Poder p = new Poder(TipoPoder.RAPOSAESTRELA, (SuporteSuportador) getSuporte(posicao));
						((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
					}
				}
			} else if ((combinam(posicao, sentido, 2) && combinam(posicao, sentido.getInverso(), 2))) {
				if (listaSuportadosArebentar.size() == 4) {
					if ((sentido == Sentido.N && sentido == Sentido.S)
							|| (sentido == Sentido.E && sentido == Sentido.O)) {
						for (Posicao pos : listaSuportadosArebentar) {
							if (getSuporte(pos) instanceof SuporteGelo) {
								explodirSuporte(pos);
							}
						}
						Poder p = new Poder(TipoPoder.ARCOIRIS, (SuporteSuportador) getSuporte(posicao));
						((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(1))).colocar(p);
						((SuporteSuportador) getSuporte(posicao)).colocar(p);
					}
					if ((sentido == Sentido.N && sentido == Sentido.E) || (sentido == Sentido.N && sentido == Sentido.O)
							|| (sentido == Sentido.S && sentido == Sentido.E)
							|| (sentido == Sentido.S && sentido == Sentido.O)) {
						for (Posicao pos : listaSuportadosArebentar) {
							if (getSuporte(pos) instanceof SuporteGelo) {
								explodirSuporte(pos);
							}
							((SuporteSuportador) getSuporte(pos)).colocar(null);
						}

						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.POLVO)) {
							Poder p = new Poder(TipoPoder.POLVOCRUZ, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						}
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.SAPO)) {
							Poder p = new Poder(TipoPoder.SAPOCRUZ, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						}
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.PEIXE)) {
							Poder p = new Poder(TipoPoder.PEIXECRUZ, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(1))).colocar(p);
						}
						if (((Animal) getSuportado(posicao)).getTipo().equals(TipoAnimal.RAPOSA)) {
							Poder p = new Poder(TipoPoder.RAPOSACRUZ, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(listaSuportadosArebentar.get(0))).colocar(p);
						}
					}
				}
			} // else if()
				// Combinacoes Normais
			else if (combinam(posicao, sentido, 2) || combinam(posicao, sentido.getInverso(), 2)
					|| (combinam(posicao, sentido, 1) && combinam(posicao, sentido.getInverso(), 1))) {
				if (listaSuportadosArebentar.size() == 3) {
					for (Posicao pos : listaSuportadosArebentar) {
						if (getSuporte(pos) instanceof SuporteGelo) {
							explodirSuporte(pos);
						} else {
							((SuporteSuportador) getSuporte(pos)).colocar(null);
						}
					}
					break;
				}

				if ((combinam(posicao, sentido, 2) && combinam(posicao, sentido.getInverso(), 1))
						|| (combinam(posicao, sentido, 1) && combinam(posicao, sentido.getInverso(), 2))) {
					if (listaSuportadosArebentar.size() > 3) {
						if ((sentido == Sentido.N || sentido == Sentido.S)) {
							// colocar o poder horizontal
							// correcto(getTipoAnimal) na
							// posximaInicial
						} else if (sentido == Sentido.E || sentido == Sentido.O) {
							// colocar poder vertical getTipoAnimal ..
						}
					}
				} else if ((combinam(posicao, sentido, 1) && combinam(posicao, sentido.getInverso(), 1)
						&& combinam(posicao, sentido, 2) || combinam(posicao, sentido.getInverso(), 2))) {
					if (listaSuportadosArebentar.size() >= 4) {
						// PoderEstrela
					}
				} else if ((combinam(posicao, sentido, 2) && combinam(posicao, sentido.getInverso(), 2))) {
					if (listaSuportadosArebentar.size() >= 4) {
						if ((sentido == Sentido.N && sentido == Sentido.S)
								|| (sentido == Sentido.E && sentido == Sentido.O)) {
							Poder p = new Poder(TipoPoder.ARCOIRIS, (SuporteSuportador) getSuporte(posicao));
							((SuporteSuportador) getSuporte(posicao)).colocar(p);
						} else if ((sentido == Sentido.N && sentido == Sentido.E)
								|| (sentido == Sentido.N && sentido == Sentido.O)
								|| (sentido == Sentido.S && sentido == Sentido.E)
								|| (sentido == Sentido.S && sentido == Sentido.O)) {
							// tipo Poder CRUZ , COLOCAR O PODER NO CENTRO DA
							// EXPLOSAO DAR COR CERTA
						}
					}
				}
				// Combinacoes Normais
				else if (combinam(posicao, sentido, 2) || combinam(posicao, sentido.getInverso(), 2)
						|| (combinam(posicao, sentido, 1) && combinam(posicao, sentido.getInverso(), 1))) {
					if (listaSuportadosArebentar.size() > 2) {
						for (Posicao pos : listaSuportadosArebentar) {
							if (getSuporte(pos) instanceof SuporteGelo) {
								explodirSuporte(pos);
							} else {

								// TODO CHANGE
								jogo.incrementarPontuacao(((Animal) getSuportado(pos)).getValor());
								getSuporteSuportador(pos).colocar(null);
							}
						}
						break;
					}
				}
			}
		}

	}

    private void explodirSuporte(Posicao posicao)
    {
        suportes[posicao.getLinha()][posicao.getColuna()] = new SuporteAgua(this, posicao);

    }


    private boolean isMovivel(Suporte suporte)
    {
        if (((SuporteSuportador) suporte).getSuportado() instanceof Movivel) {
            return true;
        }
        return false;
    }

    private void trocar(Suporte suporteFinal)
    {
        Suportado suportadoAux = ((SuporteSuportador) suporteInicial).getSuportado();

        // DEBUG
        System.out.println("Trocar " + ((SuporteSuportador) suporteFinal).getSuportado() + " com " + suportadoAux);

        ((SuporteSuportador) suporteInicial).colocar(((SuporteSuportador) suporteFinal).getSuportado());
        System.out.println(
            ((SuporteSuportador) suporteInicial) + " --> " + ((SuporteSuportador) suporteFinal).getSuportado());

        ((SuporteSuportador) suporteFinal).colocar(suportadoAux);
        System.out.println(((SuporteSuportador) suporteFinal) + " --> " + suportadoAux);

        atualizarGridPanel(suporteInicial);
        atualizarGridPanel(suporteFinal);

    }

    private boolean geraCombinacao(Posicao posicao)
    {
        //TODO make getSuportado
        if (getSuporte(posicao) instanceof SuporteSuportador) {
            if (getSuportado(posicao) instanceof Combinavel) {
                Sentido[] sentidos = {Sentido.E, Sentido.S};
                for (Sentido sentido : sentidos) {
                    if (combinam(posicao, sentido, 2) || combinam(posicao, sentido.getInverso(), 2)
                        || (combinam(posicao, sentido, 1) && combinam(posicao, sentido.getInverso(), 1))) {

                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void colocar(Posicao posicao, Suportado suportado)
    {
        ((SuporteSuportador) getSuporte(posicao)).colocar(suportado);
    }

    /**
     * Verifica para um numero de posicoes sucessivas num sentido se existe
     * suportados do mesmo tipo
     *
     * @param posicao
     * @param sentido
     * @param valor
     * @return true if true.
     */
    public boolean combinam(Posicao posicao, Sentido sentido, int valor)
    {
        Suportado suportado = getSuportado(posicao);
        Suportado suportadoSentido;
        Posicao proximaPosicao = sentido.seguirSentido(posicao);
        if (isPosicaoValida(proximaPosicao)) {
            suportadoSentido = getSuportado(proximaPosicao);
        } else {
            //pesuisa em posicao invalida
            return false;
        }
        listaSuportadosArebentar.clear();

        listaSuportadosArebentar.add(posicao);
        while (valor-- > 0) {
            if (!(suportadoSentido instanceof Combinavel
                && ((Combinavel) suportadoSentido).combinaCom(suportado))) {
                listaSuportadosArebentar.clear();
                return false;
            }
            listaSuportadosArebentar.add(proximaPosicao);

            proximaPosicao = sentido.seguirSentido(proximaPosicao);
            if (isPosicaoValida(proximaPosicao)) {
                suportadoSentido = getSuportado(proximaPosicao);

            } else {
                //pesquisa em posicao invalida
                return false;
            }
        }
        if (listaSuportadosArebentar.size() >= 3) {
            for (Posicao p : listaSuportadosArebentar) {
                System.out.println(getSuportado(p) + " posicao: " + getSuporte(posicao).getPosicao());
            }
        }

        if (listaSuportadosArebentar.size() > 2) {
            System.out.println("Fim! Tamanho da lista " + listaSuportadosArebentar.size());
        }

        return true;
    }

    public void adicionarAnimalAleatorio()
    {
        for (int coluna = 0; coluna < getNumeroDeColunas(); coluna++) {
            Posicao posicao = new Posicao(0, coluna);
            if (getSuporte(posicao) instanceof SuporteSuportador) {
                if (((SuporteSuportador) suportes[0][coluna]).getSuportado() == null) {
                    if (numeroDeMacasEmJogo < 2) {
                        ((SuporteSuportador) getSuporte(posicao)).colocar(new Maca());
                        incrementarNumeroDeMacasEmJogo();
                    } else {
                        Random random = new Random();
                        switch (random.nextInt(5)) {
                            case 0:
                                colocar(posicao, new Animal(TipoAnimal.SAPO));
                                break;
                            case 1:
                                colocar(posicao, new Animal(TipoAnimal.PANDA));
                                break;
                            case 2:
                                colocar(posicao, new Animal(TipoAnimal.PEIXE));
                                break;
                            case 3:
                                colocar(posicao, new Animal(TipoAnimal.POLVO));
                                break;
                            case 4:
                                colocar(posicao, new Animal(TipoAnimal.RAPOSA));
                                break;
                        }
                    }
                }
            }
        }
    }

    public void decrementarNumeroDeMacasNoPainelDeMacas()
    {
        jogo.decrementarMacasPorApanhar();
    }

    public Posicao gerarEspinho(Posicao posicao, LinkedList<Espinho> espinhos)
    {
        // Posicoes em volta da roseira
        for (Sentido sentido : Sentido.values()) {
            Posicao novaPosicao = posicaoValidaParaGerarEspinho(posicao, sentido);
            if (novaPosicao != null) {
                return novaPosicao;
            }
        }
        // posicoes em volta dos espinhos
        for (Espinho espinho : espinhos) {
            for (Sentido sentido : Sentido.values()) {
                Posicao novaPosicao = posicaoValidaParaGerarEspinho(espinho.getSuporte().getPosicao(), sentido);
                if (novaPosicao != null) {
                    return novaPosicao;
                }
            }
        }
        return null;
    }

    /**
     * Cria e adicina um novo Espinho numa posicao previamente encontrada
     *
     * @param posicao Posicao da roseira Mae
     * @param posicaoEspinho Posicao do novo espinho
     */
    public void colocarNovoEspinho(Posicao posicao, Posicao posicaoEspinho)
    {
        SuporteSuportador s = (SuporteSuportador) getSuporte(posicaoEspinho);
        Espinho e = new Espinho(s);
        ((SuporteSuportador) s).colocar(e);
        ((Roseira) getSuportado(posicao)).adicionarEspinho(e);
    }

    private boolean isPosicaoValida(Posicao posicao)
    {
        if (posicao.isDentro(getNumeroDeLinhas(), getNumeroDeColunas())) {
            return true;
        }
        return false;
    }

    private Posicao posicaoValidaParaGerarEspinho(Posicao posicao, Sentido sentido)
    {
        Posicao proximaPosicao = sentido.seguirSentido(posicao);
        if (isPosicaoValida(proximaPosicao)) {
            if (getSuportado(proximaPosicao) instanceof Animal) {
                return proximaPosicao;
            }
        }
        return null;
    }

    private Suporte getSuporte(Posicao posicao)
    {
        return isPosicaoValida(posicao) ? suportes[posicao.getLinha()][posicao.getColuna()] : null;
    }

    public Suportado getSuportado(Posicao posicao)
    {
        Suporte suporte = suportes[posicao.getLinha()][posicao.getColuna()];
        if (suporte instanceof SuporteSuportador) {
            return ((SuporteSuportador) suporte).getSuportado();
        }
        return null;
    }
    
    private SuporteSuportador getSuporteSuportador(Posicao posicao) {
		Suporte suporte = getSuporte(posicao);
		return suporte instanceof SuporteSuportador ? (SuporteSuportador) suporte : null;
	}

    @Override
    public void mouseDragged(MouseEvent me, int i, int i1)
    {
    }

    //NOT USED 
    @Override
    public void mouseMoved(MouseEvent me, int i, int i1)
    {
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
    }

}
