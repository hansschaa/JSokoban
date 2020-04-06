
package jsokoban;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TableroJuego extends JPanel implements KeyListener,ActionListener
{
   private ImageIcon muro;
   private ImageIcon sokoban;
   private ImageIcon piso; 
   private ImageIcon cajas;
   private ImageIcon personaje;
   private ImageIcon megamansobre;
   private ImageIcon cajasobre;
   private ImageIcon hoyos;
   private ImageIcon cuadro;
   private MotorJuego motorJuego;
   private int nivel;
   private int arriba,abajo,derecha,izquierda;
   private int nivelSig,nivelAnt;
   
   
   
  public TableroJuego()
  {
   this.nivel=1;
   
   this.setBackground(Color.BLACK);
   this.motorJuego = new MotorJuego();
   this.piso= new ImageIcon(new ImageIcon("images/camino.png").getImage());
   this.sokoban= new ImageIcon(new ImageIcon("images/sokoban.png").getImage());
   this.hoyos=new ImageIcon(new ImageIcon("images/oyo.png").getImage());
   this.muro = new ImageIcon(new ImageIcon("images/muro.png").getImage());
   this.cajas = new ImageIcon(new ImageIcon("images/caja.png").getImage());
   this.megamansobre = new ImageIcon(new ImageIcon("images/a.png").getImage());
   this.personaje = new ImageIcon(new ImageIcon("images/megaman.png").getImage());
   this.cajasobre = new ImageIcon(new ImageIcon("images/cajaagujero.png").getImage());
   this.cuadro = new ImageIcon(new ImageIcon("images/cuadro.png").getImage());
   this.arriba=KeyEvent.VK_W;
   this.abajo=KeyEvent.VK_S;
   this.derecha=KeyEvent.VK_D;
   this.izquierda=KeyEvent.VK_A;
   this.nivelSig=KeyEvent.VK_P;
   this.nivelAnt=KeyEvent.VK_O;
   
   this.addKeyListener(this);
   
  }
  @Override
    public void paint(Graphics g) 
    {
        super.paint(g);
        g.drawImage(this.cuadro.getImage(),210 , 360 , 320, 270, this);
        g.drawImage(this.sokoban.getImage(),2 , 5 , 320, 270, this);
        for(int j = 0; j<13; j++)
        {
            for(int i = 0; i<11; i++)
            {
                if(this.motorJuego.getTablero()[i][j]== 1)
                {
                    g.drawImage(this.muro.getImage(), (j * 25) + 320 + (j*8), (i * 23) + 20 + (i*8), 32, 32, this);
                }
                if (this.motorJuego.getTablero() [i] [j] == 3)
                {
                   g.drawImage(this.cajas.getImage(), (j * 25) + 320 + (j*8), (i * 23) + 20 + (i*8), 32, 32, this);
                }
                if (this.motorJuego.getTablero() [i][j] == 4)
                {
                 g.drawImage(this.hoyos.getImage(), (j * 25) + 320 + (j*8), (i * 23) + 20 + (i*8), 32, 32, this);   
                }
                 if (this.motorJuego.getTablero() [i][j] == 5)
                {
                 g.drawImage(this.personaje.getImage(), (j * 25) + 320 + (j*8), (i * 23) + 20 + (i*8), 32, 32, this);
                }
                  if (this.motorJuego.getTablero() [i][j] == 7)
                {
                 g.drawImage(this.megamansobre.getImage(), (j * 25) + 320 + (j*8), (i * 23) + 20 + (i*8), 32, 32, this);
                }
                   if (this.motorJuego.getTablero() [i][j] == 6)
                {
                 g.drawImage(this.cajasobre.getImage(), (j * 25) + 320 + (j*8), (i * 23) + 20 + (i*8), 32, 32, this);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == this.arriba)
        {
          this.motorJuego.movJugadorArriba();
          ((Ventana)this.getTopLevelAncestor()).setPuntaje(this.getPasos());
          this.repaint();  
        }
        else if(e.getKeyCode() == this.abajo)
        {
          ((Ventana)this.getTopLevelAncestor()).setPuntaje(this.getPasos());
          this.motorJuego.movJugadorAbajo();
          this.repaint();  
        }
        else if (e.getKeyCode() == this.derecha)
        {
           ((Ventana)this.getTopLevelAncestor()).setPuntaje(this.getPasos());
           this.motorJuego.movJugadorDerecha();
          this.repaint();   
        }
        else if (e.getKeyCode() == this.izquierda)
        {
         ((Ventana)this.getTopLevelAncestor()).setPuntaje(this.getPasos());   
         this.motorJuego.movJugadorIzquierda();
          this.repaint();      
        }
        else if (e.getKeyCode() == this.nivelSig)
        {
            if(this.nivel + 1 <=10 )
            {
            this.nivel+=1;
            this.motorJuego.configuracionNivel(this.nivel);
            this.repaint();
            }
        }
         else if (e.getKeyCode() == this.nivelAnt)
         {
             if(this.nivel-1>=1 )
            {
            this.nivel-=1;
            this.motorJuego.configuracionNivel(this.nivel);
            this.repaint();
            }
         }
         else if (e.getKeyCode() == KeyEvent.VK_R)
         {
            this.motorJuego.configuracionNivel(this.nivel);
            this.repaint();
         }
        if(this.motorJuego.revisarMatriz() == true)
        {
            this.nivel+=1;
            this.motorJuego.configuracionNivel(this.nivel);
            this.repaint();
        }
    }
    
    public int getPasos()
    {
        return this.motorJuego.getPasos();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
    
}
//1=pared
//2=camino
//3= cajas
//4= hoyos
//5 = personaje
//6 = cajas en oyos
//0 = nada
