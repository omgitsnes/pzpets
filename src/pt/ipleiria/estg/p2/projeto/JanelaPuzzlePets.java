package pt.ipleiria.estg.p2.projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class JanelaPuzzlePets extends JFrame
{
    private JPanel contentPane;
    
    private JLabel lblPainelMacas;
    private JLabel lblPainelEstrelas;
    private JLabel lblPainelPontuacao;
    private JLabel lblPainelPrincipal; // TODO DELETE
    
    /**
     * Create the frame.
     */
    public JanelaPuzzlePets()
    {
        
        setTitle("PuzzlePets");
        
        
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 624);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        contentPane.add(panel, BorderLayout.NORTH);
        
        lblPainelMacas = new JLabel("");
        lblPainelMacas.setIcon(new ImageIcon(JanelaPuzzlePets.class.getResource("/pt/ipleiria/estg/p2/projeto/img/PainelMaca.PNG")));
        panel.add(lblPainelMacas);
        
        lblPainelEstrelas = new JLabel("");
        lblPainelEstrelas.setIcon(new ImageIcon(JanelaPuzzlePets.class.getResource("/pt/ipleiria/estg/p2/projeto/img/PainelEstrelas.PNG")));
        panel.add(lblPainelEstrelas);
        
        lblPainelPontuacao = new JLabel("");
        lblPainelPontuacao.setHorizontalTextPosition(SwingConstants.CENTER);
        lblPainelPontuacao.setIcon(new ImageIcon(JanelaPuzzlePets.class.getResource("/pt/ipleiria/estg/p2/projeto/img/PainelPontuacao.PNG")));
        panel.add(lblPainelPontuacao);
        
        lblPainelPrincipal = new JLabel("");
        lblPainelPrincipal.setBackground(Color.WHITE);
        lblPainelPrincipal.setVerticalAlignment(SwingConstants.TOP);
        lblPainelPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        lblPainelPrincipal.setIcon(new ImageIcon(JanelaPuzzlePets.class.getResource("/pt/ipleiria/estg/p2/projeto/img/PainelPrincipal.PNG")));
        contentPane.add(lblPainelPrincipal, BorderLayout.CENTER);
    }
    
    public void alterarPontuacao(long pontuacao)
    {
        lblPainelPontuacao.setText(Long.toString(pontuacao));
    }
    
    public void alterarNivel(int nivel)
    {
        
    }
    
    public void alterarMacas(int macas)
    {
        
    }
    
    

}
