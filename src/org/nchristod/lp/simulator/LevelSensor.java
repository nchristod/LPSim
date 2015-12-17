package org.nchristod.lp.simulator;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JTextField;

public class LevelSensor extends JTextField implements Senseable {
	
	AtomicBoolean data = new AtomicBoolean(false);
	
	public LevelSensor() {
		super();
	}
	
	@Override
	public String getData() {
		return data.toString();
	}
	
	public void setData(Boolean data) {
		this.data.getAndSet(data);
	}
	
//	void bind(String name) throws RemoteException, MalformedURLException {
//		Senseable stub = (Senseable) UnicastRemoteObject.exportObject(this, 0);
//		//Bind instance to the RMI registry
//		Naming.rebind("//localhost/" + name, stub);
//        
//		System.out.println("PeerServer: " + name + ", " + this + " bound in registry");
//	}

}
