package org.nchristod.lp.simulator;

import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JTextField;

public class Thermometer extends JTextField implements Senseable{
	
	AtomicInteger temp;
	
	public Thermometer() {
		super();
//		UnicastRemoteObject.exportObject(this, 0);
		this.temp = new AtomicInteger(25);
		this.setText(temp.toString());
	}
	
	@Override
	public String getData() {
		return temp.toString();
	}
	
	public void setData(Integer data) {
		this.temp.set(data);
		this.setText(data.toString());
	}
	
//	void bind(String name) throws RemoteException, MalformedURLException {
//		Senseable stub = (Senseable) UnicastRemoteObject.exportObject(this, 0);
//		//Bind instance to the RMI registry
//		Naming.rebind("//localhost/" + name, stub);
//        
//		System.out.println("PeerServer: " + name + ", " + this + " bound in registry");
//	}
}
