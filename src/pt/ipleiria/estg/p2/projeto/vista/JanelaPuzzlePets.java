package pt.ipleiria.estg.p2.projeto.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import pt.ipleiria.estg.dei.gridpanel.JBackgroundPanel;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Objetivo;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelDeMacas;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelDeMovimentosEstrelas;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelDePontuacoes;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;

@SuppressWarnings("serial")
public class JanelaPuzzlePets extends JFrame {
	private JPanel contentPane;

	private Thread thread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPuzzlePets frame = new JanelaPuzzlePets();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaPuzzlePets() {
		initComponents();
		// threads

	}

	private void initComponents() {
		setTitle("PuzzlePets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JBackgroundPanel backgroundPanel = new JBackgroundPanel();
		backgroundPanel.setBackgroundImage("/pt/ipleiria/estg/p2/projeto/imagens/fundos/fundo0.png");
		backgroundPanel.setLayout(new BorderLayout(0, 0));
		contentPane.add(backgroundPanel);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		backgroundPanel.add(panel, BorderLayout.NORTH);

		GridPanel gridPanelPainelDeMacas = new GridPanel();
		gridPanelPainelDeMacas
				.setToolTipText("Este \u00E9 o numero de ma\u00E7as que ainda tens de fazer chegar aos cestos");
		gridPanelPainelDeMacas.setColumnSize(100);
		panel.add(gridPanelPainelDeMacas);
		gridPanelPainelDeMacas.setNumberOfRows(1);
		gridPanelPainelDeMacas.setNumberOfColumns(1);

		GridPanel gridPanelPainelDeMovimentosEstrelas = new GridPanel();
		gridPanelPainelDeMovimentosEstrelas.setToolTipText("Movimentos Disponiveis");
		gridPanelPainelDeMovimentosEstrelas.setColumnSize(75);
		panel.add(gridPanelPainelDeMovimentosEstrelas);
		gridPanelPainelDeMovimentosEstrelas.setNumberOfRows(1);
		gridPanelPainelDeMovimentosEstrelas.setNumberOfColumns(1);

		GridPanel gridPanelPainelDePontuacoes = new GridPanel();
		gridPanelPainelDePontuacoes.setToolTipText("Pontua\u00E7\u00E3o");
		gridPanelPainelDePontuacoes.setColumnSize(100);
		panel.add(gridPanelPainelDePontuacoes);
		gridPanelPainelDePontuacoes.setNumberOfRows(1);
		gridPanelPainelDePontuacoes.setNumberOfColumns(1);

		GridPanel gridPanelPainelPrincipal = new GridPanel();
		backgroundPanel.add(gridPanelPainelPrincipal);
		gridPanelPainelPrincipal.setShowGridLines(true);
		gridPanelPainelPrincipal.setNumberOfRows(8);
		gridPanelPainelPrincipal.setNumberOfColumns(8);

		final Jogo jogo = new Jogo(gridPanelPainelDeMacas, gridPanelPainelDeMovimentosEstrelas, gridPanelPainelDePontuacoes,
				gridPanelPainelPrincipal);

		final Runnable iterar = new Runnable() {
			@Override
			public void run() {
				jogo.iterar(System.currentTimeMillis());
				repaint();
			}
		};

		thread = new Thread() {
			public void run() {
				while (true) {
					try {
						try {
						    sleep(1000);
							SwingUtilities.invokeAndWait(iterar);
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();

	}

}
