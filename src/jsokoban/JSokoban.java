
package jsokoban;

import java.io.FileInputStream;
import javax.swing.UIManager;
import sun.audio.AudioPlayer;

public class JSokoban
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e)
        {
            
        }
        
       Ventana ventana = new Ventana();
       ventana.setVisible(true);
       ventana.musicaVentana(1);
    }
}
