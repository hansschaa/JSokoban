
package jsokoban;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javax.swing.ImageIcon;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;


/**
 *
 * @author patricio
 */
public class Ventana extends JFrame implements ActionListener
{
 
 private BarraMenu barra;  
 private TableroJuego tablero;
 private JPanel panelI,panelD,panelA; //Izquierda , derecha, abajo
 private JLabel puntaje,numero;

 public Ventana()
 {
      setTitle("Sokoban");
      setSize(800,600);
      this.setIconImage(new ImageIcon("images/LogoUtal.png").getImage());
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new BorderLayout());
      this.tablero = new TableroJuego();
      this.addKeyListener(tablero);
      
      
      this.puntaje = new JLabel("Puntaje: ");
      this.numero = new JLabel("");
      
      this.panelD=new JPanel();
      this.panelI=new JPanel();
      this.panelA=new JPanel();
      this.panelD.setSize(new Dimension(300,600) );
      this.panelI.setSize(new Dimension(300,600) ); 
     
      tablero.setMinimumSize(new Dimension( 400,400 ));
      
      
      this.panelA.add(this.puntaje);
      this.panelA.add(this.numero);
      
      this.barra=new BarraMenu();
      this.add(this.barra,BorderLayout.PAGE_START);
      this.add(this.panelI,BorderLayout.LINE_START);
      this.add(this.panelA,BorderLayout.PAGE_END);
      this.add(this.panelD,BorderLayout.LINE_END);
      this.add(this.tablero,BorderLayout.CENTER);
}
 
 public void setPuntaje(int puntaje)
 {
  this.numero.setText(""+puntaje);
 }

 public void musicaVentana(int a)
    {
        try
        {
            if (a == 1)
            {
                AudioPlayer.player.start(new FileInputStream("musica/nivel1.midi"));
                AudioPlayer.player.run();
            }
            else
            {
                AudioPlayer.player.stop();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
}