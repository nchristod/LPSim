package org.nchristod.lp.simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JProgressBar;

public class Silo extends JProgressBar implements ActionListener{
	
	public LevelSensor eLevel;
	LevelSensor fLevel;
	AtomicInteger levelCounter = new AtomicInteger();
	
	Silo() {
		super();
		eLevel = new LevelSensor();
		fLevel = new LevelSensor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	

}
