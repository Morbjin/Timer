import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.DefaultEditorKit.BeepAction;


public class BeepApplet extends Applet {
  
   public void init () {
   
     // Construct the button
     Button beep = new Button("Beep");

     // add the button to the layout
     this.add(beep);

     // specify that action events sent by this
     // button should be handled by a new BeepAction object
     beep.addActionListener(new BeepAction());
   
   }

}
