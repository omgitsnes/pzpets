package pt.ipleiria.estg.p2.projeto.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pt.ipleiria.estg.dei.gridpanel.JBackgroundPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class JanelaPuzzlePets extends JFrame
{

    private JPanel contentPane;

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
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JBackgroundPanel backgroundPanel = new JBackgroundPanel();
        backgroundPanel.setBackgroundImage("/pt/ipleiria/estg/p2/projeto/imagens/fundos/fundo0.png");
        contentPane.add(backgroundPanel, BorderLayout.CENTER);
        backgroundPanel.setLayout(new BorderLayout(0, 0));
        
        GridPanel gridPanel = new GridPanel();
        gridPanel.setShowGridLines(true);
        gridPanel.setNumberOfRows(8);
        gridPanel.setNumberOfColumns(8);
        backgroundPanel.add(gridPanel, BorderLayout.CENTER);
    }

}
