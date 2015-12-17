package org.nchristod.lp.simulator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Resistor extends JPanel implements ActuatorIf {
	
	Timer timer;
	AtomicBoolean status = new AtomicBoolean();
	private Thermometer thermometer;
	
	public Resistor(Thermometer therm) {
		super();
		this.thermometer = therm;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((Resistor) e.getSource()).getStatus() == false) {
				((Resistor) e.getSource()).open();
				} else {
					((Resistor) e.getSource()).close();
				}
				
			}
		});
	}
	
	@Override
	public void open() {
		try {
			timer.stop();
		} catch (NullPointerException e1) {
			System.out.println("No timer running..");
		}
		this.setBackground(Color.GREEN);
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thermometer.temp.incrementAndGet();
				thermometer.setText(thermometer.getData());
			}
		});
		timer.start();
		status.getAndSet(true);
	}

	@Override
	public void close() {
		this.setBackground(Color.RED);
		status.getAndSet(false);
		timer.stop();
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (thermometer.temp.get() <= 25) {
					timer.stop();
				} else {
					thermometer.temp.decrementAndGet();
					thermometer.setText(thermometer.getData());
				}
				
			}
			
		});
		timer.start();
	}

	@Override
	public Boolean getStatus() {
		return status.get();
	}
	
//	void bind(String name) throws RemoteException, MalformedURLException {
//		ActuatorIf stub = (ActuatorIf) UnicastRemoteObject.exportObject(this, 0);
//		//Bind instance to the RMI registry
//		Naming.rebind("//localhost/" + name, stub);
//        
//		System.out.println("PeerServer: " + name + ", " + this + " bound in registry");
//	}
}
