import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
      
 
   // Instanzvariablen 
   JMenuItem reset, schliessen;
   JTextField text;
   JComboBox<String> combo;
   JCheckBox check;
   JButton button;
 
 
     // Konstruktor 
    public GUI(){ 
    	
    	setTitle("Meine GUI");
    	JMenuBar jmb = new JMenuBar();
    	setJMenuBar(jmb);
    	JMenu menu = new JMenu("Datei");
    	jmb.add(menu);
    	reset = new JMenuItem("Reset");
    	schliessen = new JMenuItem("Schliessen");
    	reset.addActionListener(this);
    	schliessen.addActionListener(this);
    	menu.add(reset);
    	menu.add(schliessen);
    	
    	setLayout(new GridLayout(3,2));
    	add(new JLabel("Name"));
    	text = new JTextField(20);
    	add(text);
    	add(new JLabel("Berechtigung"));
    	String[] array = {"Bitte wählen", "Standard", "Admin"};
    	combo = new JComboBox<String>(array);
    	add(combo);
    	check = new JCheckBox("Kunde");
    	add(check);
    	button = new JButton("speichern");
    	button.addActionListener(this);
    	add(button);
    	
    	pack();
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);

 
    }  // Konstruktor Ende  
  
 
   
    public void actionPerformed(ActionEvent e) { 
    	
    	if(e.getSource()==reset){
    		text.setText("");
    		check.setSelected(false);
    		combo.setSelectedIndex(0);
    		
    	}else if(e.getSource()==schliessen){
    		System.exit(0);
    		
    	}else if(e.getSource()==button){
    		
    		BufferedWriter f;
    		try{
    			
    			   f = new BufferedWriter(new FileWriter("info.txt"));
    			
    				f.write("Name: "+text.getText());
    				f.newLine();
    				f.write("Berechtigung: "+combo.getItemAt(combo.getSelectedIndex()));
    				f.newLine();
    				f.write("Kunde: "+check.isSelected());
    				f.newLine();
    			
    				f.close();
    	}catch(IOException ex){
			System.err.println("Fehler beim Erstellen der Datei!");
		}   
    	}
    }
    
    public static void main(String[] args){
    	new GUI();
    }
}
