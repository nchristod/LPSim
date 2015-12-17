package org.nchristod.lp.simulator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JPanel;
import javax.swing.Timer;

public class InValve extends JPanel implements ActuatorIf{
	private Boolean status = false;
	private Timer timer;
	private Silo silo;
	private Pipe pipe;
	
	public InValve(Silo silo) {
		super();
		this.silo = silo;
        
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((InValve) e.getSource()).getStatus() == false) {
					((InValve) e.getSource()).open();
				} else {
					((InValve) e.getSource()).close();
				}

			}
		});
	}

//	void bind(String name) throws RemoteException, MalformedURLException {
//		ActuatorIf stub = (ActuatorIf) UnicastRemoteObject.exportObject(this, 0);
//		//Bind instance to the RMI registry
//		Naming.rebind("//localhost/" + name, stub);
//        
//		System.out.println("PeerServer: " + name + ", " + this + " bound in registry");
//	}
//	
	public InValve(Silo silo, Pipe pipe) {
		super();
		this.silo = silo;
		this.pipe = pipe;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((InValve) e.getSource()).getStatus() == false) {
					((InValve) e.getSource()).open();
				} else {
					((InValve) e.getSource()).close();
				}

			}
		});
	}
	
	
	public void open() {
		this.setBackground(Color.GREEN);
		timer = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pipe == null) {
					fillSilo();
				} else if (pipe.counter.get() > 0){
					pipe.counter.decrementAndGet();
					pipe.setValue(pipe.counter.get());
					fillSilo();
				}
			}

			private void fillSilo() {
				silo.levelCounter.incrementAndGet();
				silo.setValue(silo.levelCounter.get());
				if (silo.levelCounter.get() == 101) {
					System.out.println("[CRITICAL]: Silo Overflow...");
				} else if (silo.levelCounter.get() == 95) {
					silo.fLevel.setData(true);
					System.out.println("fLevel set to true");
				} else if (silo.levelCounter.get() == 5) {
					silo.eLevel.setData(true);
					System.out.println("eLevel set to true");
				}
			}
		});
		timer.start();
		this.status = true;
	}
	
	public void close() {
		this.setBackground(Color.RED);
		if (timer != null) { this.timer.stop(); }
		this.status = false;
	}

	public Boolean getStatus() {
		return status;
	}
	

}
