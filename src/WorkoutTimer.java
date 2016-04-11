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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.IconUIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.border.TitledBorder;

import java.sql.Time;
import java.net.URL;

import javax.xml.xpath.*;

import org.json.*;




public class WorkoutTimer extends JFrame implements ActionListener, DocumentListener, ChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private static final String SOUND_MARIO = "sounds\\mario_02.wav"; // C:\Users\Morba\workspace\Timer\sounds\mario_02.wav
	private static final String SOUND_MARIO_SHRINK = "sounds\\mario_12_shrink.wav";
	private static final String SOUND_MARIO_GROW = "sounds\\mario_14_grow.wav";
	//Object Attribute
	private int pause;
	private int intervall;
	private  int ticks;
	private int[] tick_list;
	private String filename;
	
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
	private JSONObject json_object_1;

	public JButton button_pause;
	public JButton button_stop;
	public JButton button_go;
	private JButton button_get_text_list;
	
	public JOptionPane option_pane_erfolgreich_gesetzt;
	private BeepAction beep;
	
	
	public WorkoutTimer(){
		/**  
		 * Erzeugt Sporttimer Objekt.
		 */
		super("Timer-App");
		//this.add( JList<String> list1 = new JList<String>(list_1) );
		    
		//Eigene Attribute
		this.intervall = 1;
		this.ticks = 1;
		this.pause = 1;
		this.tick_list = new int[]{ticks,pause,ticks};
		
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
		// Center Panel
		panel_center = new JPanel(new GridLayout(0,1));
		// page_end Panel mit Farbzuweiseung
		panel_page_end = new JPanel(new FlowLayout());
		panel_page_end.setBackground(Color.white);
		// Center Panel
		panel_center_1 = new JPanel(new FlowLayout());
		panel_center_1.setBackground(Color.pink);
		panel_center_1.setBorder(new TitledBorder("panel_center_1"));
		
		panel_center_2 = new JPanel(new FlowLayout());
		panel_center_2.setBackground(Color.CYAN);
		panel_center_2.setBorder(new TitledBorder("panel_center_2"));
		
		panel_center_3 = new JPanel(new FlowLayout());
		panel_center_3.setBackground(Color.BLUE);
		panel_center_3.setBorder(new TitledBorder("panel_center_3"));
		// east Panel
		panel_east = new JPanel(new GridLayout(3,2));
		panel_east.setBackground(Color.ORANGE);
		panel_east.setBorder(new TitledBorder("GridLayout"));
		// west Panel
		panel_west = new JPanel(new GridLayout(3,2));
		panel_west.setBackground(Color.red);
		panel_west.setBorder(new TitledBorder("Grid Layout 3,2"));
		// North Panel
		panel_north = new JPanel(new FlowLayout());
		panel_north.setBackground(Color.GREEN);
		// South Panel
		panel_south = new JPanel(new FlowLayout());
		panel_south.setBackground(Color.yellow);
		
		// Texteingabe
		//text1 = new JTextField("Text:",5);
		text_input_east_1 = new JTextField("1",5);
		text_input_east_2 = new JTextField("1",5);
		text_input_east_3 = new JTextField("1",5);
		text_area_input = new JTextArea(5,10);
		text_area_input.getDocument().addDocumentListener(this);
		
		// EAST Panel aufbau
		// NoNeed für 
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
		this.panel_west.add(label_west_1 = new JLabel("Dauer: ",10));
		this.panel_west.add(label_west_4 = new JLabel(""));
		this.panel_west.add(label_west_2 = new JLabel("Anzahl: ", 10));
		this.panel_west.add(label_west_5 = new JLabel(""));
		this.panel_west.add(label_west_3 = new JLabel("Pausen: ", 10));
		this.panel_west.add(label_west_6 = new JLabel(""));
		
		this.jlist_1 = new JList<String>(list_1);
		
	

		// CENTER Panel aufbau
		label_center_timer = new JLabel("Hier sollte ein Timer ablaufen!");
		this.panel_center_2.add(label_center_timer);
		
		// Pause Button
		button_pause = new JButton("Play");
		button_pause.addActionListener(this);
		//button_pause.setIcon(image_icon1 = new ImageIcon("1"));
		this.panel_page_end.add(button_pause);
		// GO Button - soll TImer starten
		button_go = new JButton("GO");
		button_go.addActionListener(this);
		this.panel_page_end.add(button_go);
		// STOP Button - Hält Timer an
		button_stop = new JButton("STOP");
		button_stop.addActionListener(this);
		this.panel_page_end.add(button_stop);
		// STOP Button - Hält Timer an
		button_get_text_list = new JButton();
		button_get_text_list.addActionListener(this);
		button_get_text_list.setText("# Get List #");
		button_get_text_list.setPreferredSize(new Dimension(100,30));
		this.panel_north.add(button_get_text_list);
		
		// ALles was man für ne COmboBox braucht
		String[] list_1 = {"Bitte wählen","Plank", "Burpee","Mounten Climbers", "Squads"}; 
		combo = new JComboBox<String>(list_1);
		this.combo.setPreferredSize(new Dimension(100,20));
		this.panel_center_1.add(combo);
		
		this.panel_center.add(panel_center_1);
		this.panel_center.add(panel_center_2);
		//this.panel_center.add(panel_center_3);
		
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
		
		//setBounds(1300, 530, 600, 400);
	}
		
	public void start_timer(){

		System.out.println("#################\n#Timer gestartet#\n#################");

		for (int i = 0; i < this.intervall ; i++ ){
			System.out.println("#################\n#Intervall gestartet#\n#################");
			this.doTick(this.ticks);
			try {
				Thread.sleep(this.pause*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		System.out.println("Timer abgelaufen!");
	}
	
	public void doTick(int ticks){
		/**
		 * @params int ticks sind die Anzahl von sekunden inkl. sleep
		 */
		System.out.println("Sekunden verbleibend: " + ticks);
		while (ticks != 0){
			
			String strTicks;
			strTicks = String.valueOf(ticks);
			
			// Nicht funktionsfähiger update des Label pro Tick
			this.label_center_timer.setText(strTicks);
			this.label_center_timer.repaint();
			this.panel_center_2.setBackground(getForeground());
			this.panel_center.getBackground();
			
			System.out.println("Ticks vor SLeep: " + ticks);
			
			if (ticks <= 3){
				new AePlayWave(SOUND_MARIO).start();
				ticks--;
			try {		
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Ticks nach SLeep: " + ticks);
		panel_center.setBackground(Color.BLACK);	
		}
	}
	}
	
	public void set_timer(){
		/**
		 * Setzt die benötigten Werte für einen Intervall.
		 * Nutzt zuerst die User eingabe und Überschreibt danach mit Defaultwerden aus der ausgewählten Box
		 * Wird mittels Button ausgelöst
		 */
		this.ticks = Integer.parseInt(this.text_input_east_1.getText());
		System.out.println("this.ticks gesetzt auf: "+this.ticks);
		this.intervall = Integer.parseInt(this.text_input_east_2.getText());
		System.out.println("this.intervall gesetzt auf: "+this.intervall);
		this.pause = Integer.parseInt(this.text_input_east_3.getText());
		System.out.println("this.pause gesetzt auf: "+this.pause);
		// Unnötiges Array Update
		this.tick_list[0] = this.ticks;
		this.tick_list[1] = this.intervall;
		this.tick_list[2] = this.pause;
		// Ausgabe der Elemente
		for (int tick : tick_list){
			System.out.println("Inhalt von tick_list: "+tick);
		}
	}
	
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==button_pause){
			System.out.println("Hallo Welt!");
			//label_west_1.setText(text1.getText());
			//jlist_1.setListData(text_area_input.getText());
			//System.exit(0);
		}else if(ev.getSource()==m_item2){
			System.out.println("Bis bald!");
			System.exit(0);
		}else if(ev.getSource()==m_item1){
			new AePlayWave(WorkoutTimer.SOUND_MARIO);
			System.out.println(list_1);
		}else if(ev.getSource()==button_stop){
			System.out.println("Bis bald!");
			System.exit(0);
		}else if(ev.getSource()==button_go){
			this.start_timer();
		}else if(ev.getSource()==button_get_text_list){
			//Starter MainLoop
			this.set_timer();
			option_pane_erfolgreich_gesetzt.showMessageDialog(null, "Intervall erfolgreich gesetzt!");
			//Füllt this.ticks, this.intervall, this.pause
			this.label_west_4.setText(this.text_input_east_1.getText());
			this.label_west_5.setText(this.text_input_east_2.getText());
			this.label_west_6.setText(this.text_input_east_3.getText());
		}
	}	
	

	public static void main(String[] args){
	 
		new WorkoutTimer();
			
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

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
