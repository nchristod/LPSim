package org.nchristod.lp.simulator;

//import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;

public class LpSimulator extends JFrame {

	private JPanel contentPane;
	Silo s1;
	Silo s2;
	Silo s3;
	Silo s4;
	Pipe pipe;
	InValve s1In;
	OutValve s1Out;
	LevelSensor s1fLevel;
	InValve s2In;
	Thermometer s2Thermometer;
	Thermometer s4Thermometer;
	Mixer s4Mixer;
	InValve s4In;
	OutValve s4Out;
	Resistor s4Resistor;
	InValve s3In;
	OutValve s3Out;
	Mixer s3Mixer;
	OutValve s2Out;
	Resistor s2Resistor;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LpSimulator frame = new LpSimulator();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//        System.out.println("RMI server started");
//
//        try { //special exception handler for registry creation
//            LocateRegistry.createRegistry(1099); 
//            System.out.println("java RMI registry created.");
//        } catch (RemoteException e) {
//            //do nothing, error means registry already exists
//            System.out.println("java RMI registry already exists.");
//        }
//    
//	}

	/**
	 * Create the frame.
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	public LpSimulator() {
		setTitle("YAS");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		s1 = new Silo();
//		s1.eLevel.bind("s1eLevel");
//		s1.fLevel.bind("s1fLevel");
		s1.setOrientation(SwingConstants.VERTICAL);
		s1.setBounds(62, 37, 84, 132);
		contentPane.add(s1);
		
		s2 = new HeatingSilo();
//		s2.eLevel.bind("s2eLevel");
//		s2.fLevel.bind("s2fLevel");
		s2.setOrientation(SwingConstants.VERTICAL);
		s2.setBounds(189, 37, 84, 132);
		contentPane.add(s2);
		
		s3 = new MixingSilo();
//		s3.eLevel.bind("s3eLevel");
//		s3.fLevel.bind("s3fLevel");
		s3.setOrientation(SwingConstants.VERTICAL);
		s3.setBounds(62, 268, 84, 132);
		contentPane.add(s3);
		
		s4 = new HeatingMixingSilo();
//		s4.eLevel.bind("s4eLevel");
//		s4.fLevel.bind("s4fLevel");
		s4.setOrientation(SwingConstants.VERTICAL);
		s4.setBounds(189, 268, 84, 132);
		contentPane.add(s4);
		
		pipe = new Pipe();
		pipe.setToolTipText("Pipe");
		pipe.setBounds(98, 210, 148, 14);
		contentPane.add(pipe);
		
		s4In = new InValve(s4, pipe);
//		s4In.bind("s4In");
		s4In.setBackground(Color.RED);
		s4In.setBounds(229, 260, 10, 10);
		contentPane.add(s4In);
		
		s4Out = new OutValve(s4);
//		s4Out.bind("s4Out");
		s4Out.setBackground(Color.RED);
		s4Out.setBounds(229, 398, 10, 10);
		contentPane.add(s4Out);
		
		s4Thermometer = new Thermometer();
		s4Thermometer.setToolTipText("thermometer");
//		s4Thermometer.bind("s4Thermometer");
		s4Thermometer.setEditable(false);
		s4Thermometer.setColumns(10);
		s4Thermometer.setBounds(285, 260, 33, 25);
		contentPane.add(s4Thermometer);
		
		s4Resistor = new Resistor(s4Thermometer);
//		s4Resistor.bind("s4Resistor");
		s4Resistor.setToolTipText("resistor");
		s4Resistor.setBackground(Color.RED);
		s4Resistor.setBounds(275, 268, 10, 10);
		contentPane.add(s4Resistor);
		
		s4Mixer = new Mixer();
//		s4Mixer.bind("s4Mixer");
		s4Mixer.setToolTipText("mixer");
		s4Mixer.setBackground(Color.RED);
		s4Mixer.setBounds(275, 304, 10, 10);
		contentPane.add(s4Mixer);
		
		s3In = new InValve(s3, pipe);
//		s3In.bind("s3In");
		s3In.setToolTipText("inValve");
		s3In.setBackground(Color.RED);
		s3In.setBounds(98, 260, 10, 10);
		contentPane.add(s3In);
		
		s3Out = new OutValve(s3);
//		s3Out.bind("s3Out");
		s3Out.setToolTipText("OutValve");
		s3Out.setBackground(Color.RED);
		s3Out.setBounds(98, 398, 10, 10);
		contentPane.add(s3Out);
		
		s3Mixer = new Mixer();
//		s3Mixer.bind("s3Mixer");
		s3Mixer.setToolTipText("mixer");
		s3Mixer.setBackground(Color.RED);
		s3Mixer.setBounds(50, 304, 10, 10);
		contentPane.add(s3Mixer);
		
		s2In = new InValve(s2);
//		s2In.bind("s2In");
		s2In.setBackground(Color.RED);
		s2In.setBounds(229, 29, 10, 10);
		contentPane.add(s2In);
		
		s2Out = new OutValve(s2, pipe);
//		s2Out.bind("s2Out");
		s2Out.setBackground(Color.RED);
		s2Out.setBounds(229, 167, 10, 10);
		contentPane.add(s2Out);
		
		s2Thermometer = new Thermometer();
		s2Thermometer.setToolTipText("thermometer");
//		s2Thermometer.bind("s2Thermometer");
		s2Thermometer.setEditable(false);
		s2Thermometer.setBounds(285, 29, 33, 25);
		contentPane.add(s2Thermometer);
		s2Thermometer.setColumns(10);
		
		s2Resistor = new Resistor(s2Thermometer);
//		s2Resistor.bind("s2Resistor");
		s2Resistor.setToolTipText("resistor");
		s2Resistor.setBackground(Color.RED);
		s2Resistor.setBounds(275, 37, 10, 10);
		contentPane.add(s2Resistor);
		
		s1In = new InValve(s1);
//		s1In.bind("s1In");
		s1In.setToolTipText("inValve");
		s1In.setBackground(Color.RED);
		s1In.setBounds(98, 29, 10, 10);
		contentPane.add(s1In);
		
		s1Out = new OutValve(s1, pipe);
//		s1Out.bind("s1Out");
		s1Out.setToolTipText("OutValve");
		s1Out.setBackground(Color.RED);
		s1Out.setBounds(98, 167, 10, 10);
		contentPane.add(s1Out);
		
		JLabel lblS = new JLabel("S1");
		lblS.setBounds(62, 10, 17, 15);
		contentPane.add(lblS);
		
		JLabel lblS_1 = new JLabel("S2");
		lblS_1.setBounds(189, 10, 17, 15);
		contentPane.add(lblS_1);
		
		JLabel lblS_2 = new JLabel("S3");
		lblS_2.setBounds(62, 241, 17, 15);
		contentPane.add(lblS_2);
		
		JLabel lblS_3 = new JLabel("S4");
		lblS_3.setBounds(189, 244, 17, 15);
		contentPane.add(lblS_3);
	}

	public Object get(String name) {
		switch (name) {
		case "s1eLevel":
			return s1.eLevel;
			
		case "s1fLevel":
			return s1.fLevel;
			
		case "s1In":
			return s1In;
			
		case "s1Out":
			return s1Out;
			
		case "s2eLevel":
			return s2.eLevel;
			
		case "s2fLevel":
			return s2.fLevel;
			
		case "s2In":
			return s2In;
		
		case "s2Out":
			return s2Out;
			
		case "s2Thermometer":
			return s2Thermometer;
			
		case "s2Resistor":
			return s2Resistor;
			
		case "s3eLevel":
			return s3.eLevel;
			
		case "s3fLevel":
			return s3.fLevel;
			
		case "s3In":
			return s3In;
			
		case "s3Out":
			return s3Out;
			
		case "s3Mixer":
			return s3Mixer;
			
		case "s4eLevel":
			return s4.eLevel;
			
		case "s4fLevel":
			return s4.fLevel;
			
		case "s4In":
			return s4In;
			
		case "s4Out":
			return s4Out;
			
		case "s4Resistor":
			return s4Resistor;
			
		case "s4Thermometer":
			return s4Thermometer;
		
		case "s4Mixer":
			return s4Mixer;

		default:
			System.out.println("No such device");
			return null;
		}
	}
	
}
