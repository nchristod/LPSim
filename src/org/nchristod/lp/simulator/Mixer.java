package org.nchristod.lp.simulator;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JPanel;

public class Mixer extends JPanel implements ActuatorIf{
	
	AtomicBoolean status = new AtomicBoolean();
	
	public Mixer() {
		super();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((Mixer) e.getSource()).getStatus() == false) {
				((Mixer) e.getSource()).open();
				} else {
					((Mixer) e.getSource()).close();
				}
				
			}
		});
	}
	
	@Override
	public void open() {
		this.setBackground(Color.GREEN);
		status.getAndSet(true);
	}

	@Override
	public void close() {
		this.setBackground(Color.RED);
		status.getAndSet(false);
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
