package pt.ipleiria.estg.p2.projeto.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pt.ipleiria.estg.dei.gridpanel.JBackgroundPanel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.Objetivo;
import pt.ipleiria.estg.p2.projeto.modelo.PainelDeMacas;
import pt.ipleiria.estg.p2.projeto.modelo.PainelDeMovimentosEstrelas;
import pt.ipleiria.estg.p2.projeto.modelo.PainelDePontuacoes;
import pt.ipleiria.estg.p2.projeto.modelo.PainelPrincipal;
import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class JanelaPuzzlePets extends JFrame
{
    private JPanel contentPane;
    private PainelDeMacas painelDeMacas;
    private PainelDeMovimentosEstrelas painelDeMovimentosEstrelas;
    private PainelDePontuacoes painelDePontuacoes;
    private PainelPrincipal painelPrincipal;
    private Objetivo objetivo;


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
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JBackgroundPanel backgroundPanel = new JBackgroundPanel();
        backgroundPanel.setBackgroundImage("/pt/ipleiria/estg/p2/projeto/imagens/fundos/fundo0.png");
        backgroundPanel.setLayout(new BorderLayout(0, 0));

        GridPanel gridPanelPaineis = new GridPanel();
        gridPanelPaineis.setColumnSize(75);
        gridPanelPaineis.setPanelBackground("");
        gridPanelPaineis.setNumberOfRows(1);
        gridPanelPaineis.setNumberOfColumns(3);
        backgroundPanel.add(gridPanelPaineis, BorderLayout.NORTH);
        contentPane.add(backgroundPanel);

        GridPanel gridPanelPainelPrincipal = new GridPanel();
        backgroundPanel.add(gridPanelPainelPrincipal, BorderLayout.CENTER);
        gridPanelPainelPrincipal.setShowGridLines(true);
        gridPanelPainelPrincipal.setNumberOfRows(8);
        gridPanelPainelPrincipal.setNumberOfColumns(8);

        painelDeMacas = new PainelDeMacas(gridPanelPaineis, 20);
        painelDeMacas.getGridPanel().add(0, 0, painelDeMacas.getRepresentacao());
        
        
        CellRepresentation e = new SingleImageCellRepresentation("/pt/ipleiria/estg/p2/projeto/imagens/animais/panda.png");

        for (int i = 0; i < gridPanelPainelPrincipal.getNumberOfRows(); i++) {
            for (int j = 0; j < gridPanelPainelPrincipal.getNumberOfColumns(); j++) {
                gridPanelPainelPrincipal.add(i, j, e);        
            }
        }

        gridPanelPainelPrincipal.repaint();


    }

}
