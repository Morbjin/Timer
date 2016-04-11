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
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.IconUIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.border.TitledBorder;

import java.sql.Time;


public class Sporttimer extends JFrame implements ActionListener, DocumentListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	//Object Attribute
	private int pause;
	private int intervall;
	private  int ticks;
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
	public JTextField text_input_east_1;
	public JTextField text_input_east_2;
	public JTextField text_input_east_3;
	public JTextArea text_area_input;
	public JLabel label_west_1;
	public JLabel label_west_2;
	public JLabel label_west_3;
	public JLabel label_west_4;
	public JLabel label_west_5;
	public JLabel label_west_6;
	public JLabel label_east_1;
	public JLabel label_east_2;
	public JLabel label_east_3;
	public JLabel label_center_timer;
	public String[] list_1;
	public JList<String> jlist_1;
	public JPanel panel_page_end;
	public JPanel panel_center;
	public JPanel panel_center_1;
	public JPanel panel_center_2;
	public JPanel panel_center_3;
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
		
		//Hauptmen�s
		bar.add(menu_main = new JMenu("Men�"));
		bar.add(menu_options = new JMenu("Optionen"));
		bar.add(menu_sounds = new JMenu("Sounds"));
		//Hauptmen�punkt
		menu_main.add(m_item1 = new JMenuItem("Liste"));
		m_item1.addActionListener(this);
		menu_main.add(m_item2 = new JMenuItem("Schlie�en"));
		m_item2.addActionListener(this);
		
		panel_center = new JPanel(new FlowLayout());
		// page_end Panel mit Farbzuweiseung
		panel_page_end = new JPanel();
		panel_page_end.setBackground(Color.white);
		panel_page_end.setLayout(new FlowLayout());
		// Center Panel
		panel_center_1 = new JPanel(new FlowLayout());
		panel_center_1.setBackground(Color.BLUE);
		panel_center_1.setBorder(new TitledBorder("FlowLayout"));
		
		panel_center_2 = new JPanel(new FlowLayout());
		panel_center_2.setBackground(Color.BLUE);
		panel_center_2.setBorder(new TitledBorder("FlowLayout"));
		
		panel_center_3 = new JPanel(new FlowLayout());
		panel_center_3.setBackground(Color.BLUE);
		panel_center_3.setBorder(new TitledBorder("FlowLayout"));
		// east Panel
		panel_east = new JPanel(new GridLayout(3,2));
		panel_east.setBackground(Color.ORANGE);
		panel_east.setBorder(new TitledBorder("GridLayout"));
		// west Panel
		panel_west = new JPanel(new GridLayout(3,2));
		panel_west.setBackground(Color.red);
		panel_west.setBorder(new TitledBorder("BorderLayout"));
		// North Panel
		panel_north = new JPanel(new FlowLayout());
		panel_north.setBackground(Color.GREEN);
		// South Panel
		panel_south = new JPanel(new FlowLayout());
		panel_south.setBackground(Color.yellow);
		
		// Texteingabe
		text1 = new JTextField("Text:",5);
		text_input_east_1 = new JTextField("2",5);
		text_input_east_2 = new JTextField("1",5);
		text_input_east_3 = new JTextField("2",5);
		text_area_input = new JTextArea(5,10);
		text_area_input.getDocument().addDocumentListener(this);
		
		// EAST Panel aufbau
		// NoNeed f�r 
		//this.panel_east.add(text_area_input, BorderLayout.CENTER);
		//this.panel_east.add(text1);
		label_east_1 = new JLabel("Intervall-Dauer: ");
		this.panel_east.add(label_east_1);
		this.panel_east.add(text_input_east_1);
		
		label_east_2 = new JLabel("Intervall-Anzahl: ");
		this.panel_east.add(label_east_2);
		this.panel_east.add(text_input_east_2);
		
		label_east_3 = new JLabel("Pause-Dauer: ");
		this.panel_east.add(label_east_3);
		this.panel_east.add(text_input_east_3);
		
		
		// WEST Panel aufbau
		this.label_west_1 = new JLabel("Dauer",10);
		this.label_west_2 = new JLabel("Anzahl", 10);
		this.label_west_3 = new JLabel("Pausen_dauer", 10);
		this.label_west_4 = new JLabel("");
		this.label_west_5 = new JLabel("");
		this.label_west_6 = new JLabel("");
		this.jlist_1 = new JList<String>(list_1);
		
		this.panel_west.add(label_west_1, BorderLayout.NORTH);
		this.panel_west.add(label_west_2, BorderLayout.CENTER);
		this.panel_west.add(label_west_3, BorderLayout.SOUTH);

		// CENTER Panel aufbau
		label_center_timer = new JLabel("Beginne mit Klick auf GO!");
		this.panel_center_1.add(label_center_timer);
		
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
		// STOP Button - H�lt Timer an
		button_stop = new JButton();
		button_stop.addActionListener(this);
		button_stop.setText("STOP");
		this.panel_page_end.add(button_stop);
		// STOP Button - H�lt Timer an
		button_get_text_list = new JButton();
		button_get_text_list.addActionListener(this);
		button_get_text_list.setText("# Get List #");
		this.panel_north.add(button_get_text_list);
		
		
		String[] list_1 = {"Bitte w�hlen","Ohja!", "�bung 2"}; 
		combo = new JComboBox<String>(list_1);
		this.combo.setPreferredSize(new Dimension(100,20));
		this.panel_center_1.add(combo);
		
		this.panel_center.add(panel_center_1);
		this.panel_center.add(panel_center_2);
		this.panel_center.add(panel_center_3);
		
		// Elemente in Rheinfolge zusammenf�gen 
		this.add(panel_page_end, BorderLayout.PAGE_END);
		this.add(panel_center, BorderLayout.CENTER);
		this.add(panel_east, BorderLayout.EAST);
		this.add(panel_west, BorderLayout.WEST);
		this.add(panel_north, BorderLayout.NORTH);
		this.add(panel_south, BorderLayout.SOUTH);

		
		
		// Bisher unn�tzes Object, fehlt Container?
		b1 = new BasicArrowButton(1);
		
		//Standart Operationen f�rs root_window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		this.setBackground(Color.WHITE);
		
		setBounds(1300, 530, 600, 400);
	}
		
	public void start_timer(){
		for (int i = 0; i < this.tick_list.length ; i++ ){
			System.out.println("N�chster Intervall: "+tick_list[i]);
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
		new Beeper();
		
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
			new Beeper();
			System.out.println(list_1);
			//start_timer_loop();
		}else if(ev.getSource()==button_stop){
			System.exit(0);
		}else if(ev.getSource()==button_go){
			this.start_timer();
		}else if(ev.getSource()==button_get_text_list){
			this.label_west_1.setText(this.text_input_east_1.getText());
			new Beeper();
			this.ticks=Integer.parseInt(this.text_input_east_1.getText());
			this.intervall=Integer.parseInt(this.text_input_east_2.getText());
			this.pause=Integer.parseInt(this.text_input_east_3.getText());
			this.label_west_2.setText(this.text_input_east_2.getText());
			this.label_west_3.setText(this.text_input_east_3.getText());
		}else if(ev.getSource()==button_get_text_list){
			//this.jlist_1.se(this.text_area_input.getText());
		}
		
	}	
	

	public static void main(String[] args){
	 
		new Sporttimer();
			
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		//e.getChange(text_area_input);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
