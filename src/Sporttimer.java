import java.awt.BorderLayout;

import javax.swing.text.DefaultEditorKit.BeepAction;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextArea;
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
	private int[] tick_list;
	
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
	public JTextField text_input_east;
	public JTextArea text_area_input;
	public JLabel label_west_1;
	public JLabel label_east_1;
	public JLabel label_center_timer;
	public String[] list_1;
	public JList<String> jlist_1;
	public JPanel panel_page_end;
	public JPanel panel_center;
	public JPanel panel_east;
	public JPanel panel_west;
	public JPanel panel_north;
	public JPanel panel_south;
	public Icon icon_1;
	public ImageIcon image_icon1;
	private JComboBox<String> combo;
	private JSlider slider_1;
	
	public JButton button_pause;
	public JButton button_stop;
	public JButton button_go;
	private JButton button_get_text_list;
	
	public JOptionPane pane_reset;
	private BeepAction beep;
	
	
	public Sporttimer(){
		super("Timer-App");
		//this.add( JList<String> list1 = new JList<String>(list_1) );
		    
		//Eigene Attribute
		this.intervall = 40;
		this.ticks = 30;
		this.pause = 10;
		this.tick_list = new int[]{ticks,pause,ticks};
		
		
		//	GridLayout
		//
		//
		//setLayout(new GridLayout(2,3));
		setLayout(new BorderLayout(20, 20));
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
		
		// Button Panel mit Farbzuweiseung
		panel_page_end = new JPanel();
		panel_page_end.setBackground(Color.white);
		panel_page_end.setLayout(new FlowLayout());
		// Center Panel
		panel_center = new JPanel();
		panel_center.setBackground(Color.PINK);
		panel_center.setLayout(new FlowLayout());
		// Center Panel
		panel_east = new JPanel();
		panel_east.setBackground(Color.blue);
		panel_east.setLayout(new FlowLayout());
		// Center Panel
		panel_west = new JPanel();
		panel_west.setBackground(Color.red);
		panel_west.setLayout(new FlowLayout());
		// Center Panel
		panel_north = new JPanel();
		panel_north.setBackground(Color.GREEN);
		panel_north.setLayout(new FlowLayout());
		// Center Panel
		panel_south = new JPanel();
		panel_south.setBackground(Color.yellow);
		panel_south.setLayout(new FlowLayout());
		
		// Texteingabe
		text1 = new JTextField("Text:",5);
		text_input_east = new JTextField("Textfeld EAST:");
		text_area_input = new JTextArea(5,1);
		panel_east.add(text_area_input);
		panel_east.add(text1);
		panel_east.add(text_input_east);
		
		// Label, nehmen normal String Inhalte, ggf via Setter
		label_west_1 = new JLabel("LABEL: ");
		jlist_1 = new JList<String>();
		this.panel_west.add(label_west_1);
		label_east_1 = new JLabel("Label East: ");
		this.panel_east.add(label_east_1);
		label_center_timer = new JLabel("Beginne mit Klick auf GO!");
		this.panel_center.add(label_center_timer);
		
		// Pause Button
		button_pause = new JButton();
		button_pause.addActionListener(this);
		button_pause.setText("Play/Pause");
		button_pause.setIcon(image_icon1 = new ImageIcon("2"));
		this.panel_page_end.add(button_pause);
		// GO Button - soll TImer starten
		button_go = new JButton();
		button_go.addActionListener(this);
		button_go.setText("GO");
		this.panel_page_end.add(button_go);
		// STOP Button - Hält Timer an
		button_stop = new JButton();
		button_stop.addActionListener(this);
		button_stop.setText("STOP");
		this.panel_page_end.add(button_stop);
		
		// STOP Button - Hält Timer an
		button_get_text_list = new JButton();
		button_get_text_list.addActionListener(this);
		button_get_text_list.setText("# Get List #");
		this.panel_north.add(button_get_text_list);
		
		
		String[] list_1 = {"Bitte wählen","Ohja!", "Übung 2"}; 
		combo = new JComboBox<String>(list_1);
		this.combo.setPreferredSize(new Dimension(100,20));
		this.panel_center.add(combo);
		
		
		// Elemente in Rheinfolge zusammenfügen 
		this.add(panel_page_end, BorderLayout.PAGE_END);
		this.add(panel_center, BorderLayout.CENTER);
		this.add(panel_east, BorderLayout.EAST);
		this.add(panel_west, BorderLayout.WEST);
		this.add(panel_north, BorderLayout.NORTH);
		this.add(panel_south, BorderLayout.SOUTH);

		
		
		// Bisher unnützes Object, fehlt Container?
		b1 = new BasicArrowButton(1);
		
		//Standart Operationen fürs root_window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		this.setBackground(Color.WHITE);
		
		setBounds(1300, 530, 600, 400);
	}
		
	public void start_timer(){
		for (int i = 0; i < this.tick_list.length ; i++ ){
			System.out.println("Nächster Intervall: "+tick_list[i]);
			this.doTick(tick_list[i]);

			}
		System.out.println("Timer abgelaufen!");
		}
	

	
	public void doTick(int ticks){
		System.out.println("Sekunden verbleibend: " + ticks);
		while (ticks != 0){
			try {
				label_center_timer.setText(String.valueOf(ticks));
				doBeep();
				System.out.println("Ticks vor SLeep: " + ticks);
				Thread.sleep(1000);
				//if (this.ticks <= 3){
				//	beep = new BeepAction();
				//	this.ticks--;
				//}
				ticks--;
				System.out.println("Ticks nach SLeep: " + ticks);
				//Nicht in jedem Loop wird aktualisiert -.-"
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	public void doBeep(){
		new BeepAction();
		
	}	
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==button_pause){
			System.out.println("Hallo Welt!");
			label_west_1.setText(text1.getText());
			//jlist_1.setListData(text_area_input.getText());
			//System.exit(0);
			doBeep();
		}else if(ev.getSource()==m_item2){
			System.out.println("Bis bald!");
			System.exit(0);
		}else if(ev.getSource()==m_item1){
			System.out.println(list_1);
			//start_timer_loop();
		}else if(ev.getSource()==button_stop){
			System.exit(0);
		}else if(ev.getSource()==button_go){
			this.start_timer();
		}else if(ev.getSource()==button_get_text_list){
			this.label_west_1.setText(this.text_area_input.getText());
		}else if(ev.getSource()==button_get_text_list){
			//this.jlist_1.se(this.text_area_input.getText());
		}
		
	}	
	

	public static void main(String[] args){
	 
		new Sporttimer();
			
	}

	
}
