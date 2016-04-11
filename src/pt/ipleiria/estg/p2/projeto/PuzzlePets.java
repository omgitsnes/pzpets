package pt.ipleiria.estg.p2.projeto;

import java.awt.EventQueue;

import javax.swing.JLabel;

public class PuzzlePets 
{

    private long pontuacao;
    private int macas;
    private int nivel;
    
    public static void main(String[] args)
    {
       
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try {
                    JanelaPuzzlePets janela = new JanelaPuzzlePets();
                    janela.setVisible(true);
                        janela.alterarPontuacao(8765);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
    }

}
