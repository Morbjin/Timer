import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.plaf.IconUIResource;
import javax.swing.plaf.basic.BasicArrowButton;

import java.sql.Time;


public class Sporttimer extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	//Object Attribute
	public int pause;
	public int countdown;
	private int intervall;
	private int ticks;
	
	// Crap Element
	public BasicArrowButton b1 ;
	
	// Gui Elemente
	public JFrame frame;
	public JMenuBar bar;
	public JMenu menu_main;
	public JMenu menu_options;
	public JMenu menu_sounds;
	public JMenuItem m_item1;
	public JMenuItem m_item2;
	public JTextField text1;
	public JLabel label1;
	public String[] list_1;
	public JList<String> jlist_1;
	public JPanel panel1;
	public Icon icon_1;
	public ImageIcon image_icon1;
	private JComboBox<String> combo;
	
	public JButton button_pause;
	public JButton button_stop;
	public JButton button_go;
	
	
	public Sporttimer(int time, int intervall){
		super("Timer-App");
		
		
		
		//this.add( JList<String> list1 = new JList<String>(list_1) );
		this.intervall = intervall;
		this.ticks = time;
		
		//	GridLayout
		//
		//
		//setLayout(new GridLayout(2,3));
		setLayout(new BorderLayout());
		JMenuBar bar = new JMenuBar();
		
		this.setJMenuBar(bar);
		
		//Hauptmenüs
		bar.add(menu_main = new JMenu("Menü"));
		bar.add(menu_options = new JMenu("Optionen"));
		bar.add(menu_sounds = new JMenu("Sounds"));
		//Hauptmenüpunkt
		menu_main.add(m_item1 = new JMenuItem("Liste"));
		m_item1.addActionListener(this);
		menu_main.add(m_item2 = new JMenuItem("Schließen"));
		m_item2.addActionListener(this);
		
		// Button Panel
		panel1 = new JPanel();
		
		// Pause Button
		button_pause = new JButton();
		button_pause.addActionListener(this);
		button_pause.setText("Play/Pause");
		button_pause.setIcon(image_icon1 = new ImageIcon("2"));
		panel1.add(button_pause);
		
		// GO Button - soll TImer starten
		button_go = new JButton();
		button_go.addActionListener(this);
		button_go.setText("GO");
		panel1.add(button_go);
		
		// STOP Button - Hält Timer an
		button_stop = new JButton();
		button_stop.addActionListener(this);
		button_stop.setText("STOP");
		panel1.add(button_stop);
		
		String[] list_1 = new String[]{"Bitte wählen","Übung 1", "Übung 2"}; 
		combo = new JComboBox<String>(list_1);
		
		
		// Elemente in Rheinfolge zusammenfügen 
		this.add(panel1, BorderLayout.PAGE_END);
		this.add(label1 = new JLabel("LABEL"), BorderLayout.CENTER);
		this.add(text1 = new JTextField("Textfeld"), BorderLayout.EAST);
		this.add(combo, BorderLayout.CENTER);
		
		// Bisher unnützes Object, fehlt Container?
		b1 = new BasicArrowButton(1);
		
		//Standart Operationen fürs root_window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setBounds(1300, 530, 600, 400);
	}
		
		
	
	public int setIntervall(){
		return this.countdown;
	}
	
	public void start_timer_loop(int intervall){
		for (int i=0;i<intervall;i--){
			try {
				this.doTick();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public int doTick(){
		this.ticks -= 1;
		if(this.ticks <= 0){
		}else{
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		System.out.println(this.ticks);
		return this.ticks;	
		
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==button_pause){
			System.out.println("Hallo Welt!");
			label1.setText(text1.getText());
			//System.exit(0);
		}else if(ev.getSource()==m_item2){
			System.out.println("Bis bald!");
			System.exit(0);
		}else if(ev.getSource()==m_item1){
			System.out.println(list_1);
		}else if(ev.getSource()==button_stop){
			System.exit(0);
		}else if(ev.getSource()==button_go){
			this.start_timer_loop(intervall);
		}
		
	}	
	

	public static void main(String[] args){
	 
		new Sporttimer(5, 2);
			
	}

	
}
