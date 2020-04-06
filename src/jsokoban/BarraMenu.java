/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsokoban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu.Separator;
import javax.swing.KeyStroke;

/**
 *
 * @author patricio
 */
public class BarraMenu extends JMenuBar implements ActionListener
{ 
  private JMenu archivo;
  private JMenu configuraciones;
  private JMenu ayuda;
    
  private JMenuItem nuevoJuego;
  private JMenuItem mostrarPuntajes;
  private JMenuItem salir;
  
  private JMenuItem cambiarTeclas;
  
  private JMenuItem comoJugar;
  private JMenuItem sobreSokoban;

    
    public BarraMenu()
    {
        //declaracion
        this.archivo = new JMenu("Archivo");
        this.configuraciones = new JMenu("Configuraciones");
        this.ayuda = new JMenu("Ayuda");
        this.archivo.setMnemonic('A');
        this.configuraciones.setMnemonic('C');
        this.ayuda.setMnemonic('Y');
        
        this.nuevoJuego = new JMenuItem("Nuevo Juego");
        this.nuevoJuego.setMnemonic('N');
        this.nuevoJuego.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        
        this.mostrarPuntajes = new JMenuItem("Mostrar Puntajes");
        this.mostrarPuntajes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        this.mostrarPuntajes.setMnemonic('P');
        
        this.salir = new JMenuItem("Salir");
        this.salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        this.salir.setMnemonic('S');
        
        this.cambiarTeclas = new JMenuItem("Cambiar Teclas");
        this.cambiarTeclas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        this.cambiarTeclas.setMnemonic('T');
        
        this.comoJugar = new JMenuItem("Como Jugar");
        this.sobreSokoban = new JMenuItem("Sobre JSokoban");
        
        //accion
        this.nuevoJuego.addActionListener(this);
        this.mostrarPuntajes.addActionListener(this);
        this.salir.addActionListener(this);
        
        this.cambiarTeclas.addActionListener(this);
        
        this.comoJugar.addActionListener(this);
        this.sobreSokoban.addActionListener(this);
        
        //acoplados
        this.archivo.add(this.nuevoJuego);
        this.archivo.add(this.mostrarPuntajes);
        this.archivo.add(new Separator());
        this.archivo.add(this.salir);
            
        this.configuraciones.add(cambiarTeclas);
        this.ayuda.add(comoJugar);
        this.ayuda.add(sobreSokoban);
            
        this.add(archivo);
        this.add(configuraciones);
        this.add(ayuda);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.nuevoJuego)
        {
            Ventana ventanaPrincipal=new Ventana();
            ventanaPrincipal.setVisible(true);
            ((Ventana)this.getTopLevelAncestor()).dispose();
        }
        if(e.getSource()==this.salir)
        {
            ((Ventana)this.getTopLevelAncestor()).dispose();
        }
        if(e.getSource()== this.comoJugar)
        {
              JOptionPane.showMessageDialog(this, "Debes mover las cajas por medio de las teclas configuradas "
                      + "                          \nacercando la cara con la caja al objetivo que es el agujero rojo, "
                      + "                          \npara ganar deves depositar todas las cajas en los agujeros", 
                                                   "Como Jugar", JOptionPane.PLAIN_MESSAGE);
        }
       if(e.getSource() == this.sobreSokoban)
       {
        JOptionPane.showMessageDialog(this, "\tAutores: Patricio Quezada - Hans \"Enfermo del Lepe\" Schaa "
                + "                                      \n\tJuego: Sokoban \nCreado en Julio del 2013", 
                                                          "Acerca De", JOptionPane.PLAIN_MESSAGE);   
       }
       
       if(e.getSource() == this.cambiarTeclas)
       {
            Configuracion configuracion = new Configuracion();
       }
    }
  
}
