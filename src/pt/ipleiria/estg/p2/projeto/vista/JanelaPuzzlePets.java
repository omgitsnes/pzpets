package pt.ipleiria.estg.p2.projeto.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pt.ipleiria.estg.dei.gridpanel.JBackgroundPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Objetivo;
import pt.ipleiria.estg.p2.projeto.modelo.PainelDeMacas;
import pt.ipleiria.estg.p2.projeto.modelo.PainelDeMovimentosEstrelas;
import pt.ipleiria.estg.p2.projeto.modelo.PainelDePontuacoes;
import pt.ipleiria.estg.p2.projeto.modelo.PainelPrincipal;
import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class JanelaPuzzlePets extends JFrame
{
    private JPanel contentPane;
    private PainelDeMacas painelDeMacas;
    private PainelDeMovimentosEstrelas painelDeMovimentosEstrelas;
    private PainelDePontuacoes painelDePontuacoes;
    private PainelPrincipal painelPrincipal;
    private Objetivo objetivo;
    private Thread thread;


    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
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
    public JanelaPuzzlePets()
    {
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
        gridPanelPainelDeMacas.setToolTipText("Este \u00E9 o numero de ma\u00E7as que ainda tens de fazer chegar aos cestos");
        gridPanelPainelDeMacas.setColumnSize(100);
        panel.add(gridPanelPainelDeMacas);
        gridPanelPainelDeMacas.setPanelBackground("");
        gridPanelPainelDeMacas.setNumberOfRows(1);
        gridPanelPainelDeMacas.setNumberOfColumns(1);

        GridPanel gridPanelPainelDeMovimentosEstrelas = new GridPanel();
        gridPanelPainelDeMovimentosEstrelas.setToolTipText("Movimentos Disponiveis");
        gridPanelPainelDeMovimentosEstrelas.setColumnSize(75);
        panel.add(gridPanelPainelDeMovimentosEstrelas);
        gridPanelPainelDeMovimentosEstrelas.setPanelBackground("");
        gridPanelPainelDeMovimentosEstrelas.setNumberOfRows(1);
        gridPanelPainelDeMovimentosEstrelas.setNumberOfColumns(1);

        GridPanel gridPanelPainelDePontuacoes = new GridPanel();
        gridPanelPainelDePontuacoes.setToolTipText("Pontua\u00E7\u00E3o");
        gridPanelPainelDePontuacoes.setColumnSize(100);
        panel.add(gridPanelPainelDePontuacoes);
        gridPanelPainelDePontuacoes.setPanelBackground("");
        gridPanelPainelDePontuacoes.setNumberOfRows(1);
        gridPanelPainelDePontuacoes.setNumberOfColumns(1);

        GridPanel gridPanelPainelPrincipal = new GridPanel();
        backgroundPanel.add(gridPanelPainelPrincipal);
        gridPanelPainelPrincipal.setShowGridLines(true);
        gridPanelPainelPrincipal.setNumberOfRows(8);
        gridPanelPainelPrincipal.setNumberOfColumns(8);

        //Definir objetivo
        objetivo = new Objetivo(100, 150, 5000, 0);
        // criar paineis
        painelDeMacas = new PainelDeMacas(gridPanelPainelDeMacas, 20);
        painelDeMovimentosEstrelas = new PainelDeMovimentosEstrelas(gridPanelPainelDeMovimentosEstrelas, objetivo.getNumeroDeMovimentosMaximo());
        painelDePontuacoes = new PainelDePontuacoes(gridPanelPainelDePontuacoes);

        painelDeMacas.getGridPanel().add(0, 0, painelDeMacas.getRepresentacao());
        painelDeMacas.getGridPanel().add(0, 0, new TextCellRepresentation(Integer.toString(objetivo.getNumeroDeMacasParaApanhar())));

        painelDeMovimentosEstrelas.getGridPanel().add(0, 0, painelDeMovimentosEstrelas.getRepresentacao());
        painelDeMovimentosEstrelas.getGridPanel().add(0, 0, new TextCellRepresentation(Integer.toString(objetivo.getNumeroDeMovimentosMaximo())));

        painelDePontuacoes.getGridPanel().add(0, 0, painelDePontuacoes.getRepresentacao());
        painelDePontuacoes.getGridPanel().add(0, 0, new TextCellRepresentation(painelDePontuacoes.getPontuacaoAtual()));


        // preencher painel principal
        CellRepresentation e = new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/animais/panda.png");
        CellRepresentation s = new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/suportes/agua.png");

        for (int i = 0; i < gridPanelPainelPrincipal.getNumberOfRows(); i++) {
            for (int j = 0; j < gridPanelPainelPrincipal.getNumberOfColumns(); j++) {
                gridPanelPainelPrincipal.add(i, j, s);        
                gridPanelPainelPrincipal.add(i, j, e);                
            }
        }
        gridPanelPainelPrincipal.repaint();

        // threads
        thread = new Thread() {
            public void run() 
            {
                while (true) {
                    try {
                        System.out.println("cai!");
                        sleep(100);//TODO cadencia de queda painel principal
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
