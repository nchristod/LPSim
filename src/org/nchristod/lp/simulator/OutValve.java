package org.nchristod.lp.simulator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OutValve extends JPanel implements ActuatorIf {
	
	private Boolean status = false;
	private Timer timer;
	private Silo silo;
	private Pipe pipe;
	
	public OutValve(Silo silo) {
		super();
		this.silo = silo;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((OutValve) e.getSource()).getStatus() == false) {
				((OutValve) e.getSource()).open();
				} else {
					((OutValve) e.getSource()).close();
				}
				
			}
		});
	}
	
	public OutValve(Silo silo, Pipe pipe) {
		super();
		this.silo = silo;
		this.pipe = pipe;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((OutValve) e.getSource()).getStatus() == false) {
				((OutValve) e.getSource()).open();
				} else {
					((OutValve) e.getSource()).close();
				}
				
			}
		});
	}
	/* (non-Javadoc)
	 * @see org.nchristod.lp.simulator.ActuatorIf#open()
	 */
	@Override
	public void open() {
		this.setBackground(Color.GREEN);
		timer = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pipe == null) {
					emptySilo();
				} else if (silo.levelCounter.get() > 0){
					pipe.counter.incrementAndGet();
					pipe.setValue(pipe.counter.get());
					emptySilo();
				}
			}

			private void emptySilo() {
				silo.levelCounter.decrementAndGet();
				silo.setValue(silo.levelCounter.get());

				if (silo.levelCounter.get() == -1) {
					System.out.println("[Warning]: Out Valve left opened!...");
				} else if (silo.levelCounter.get() == 5) {
					silo.eLevel.setData(false);
					silo.fLevel.setData(false); //
					System.out.println("eLevel set to false");
				} else if (silo.levelCounter.get() == 95) {
					silo.fLevel.setData(false);
					silo.eLevel.setData(true); //
					System.out.println("fLevel set to false");
				}
			}
		});
		timer.start();
		this.status = true;
	}
	
	/* (non-Javadoc)
	 * @see org.nchristod.lp.simulator.ActuatorIf#close()
	 */
	@Override
	public void close() {
		this.setBackground(Color.RED);
		if (timer != null) {this.timer.stop();}
		this.status = false;
	}

	/* (non-Javadoc)
	 * @see org.nchristod.lp.simulator.ActuatorIf#getStatus()
	 */
	@Override
	public Boolean getStatus() {
		return status;
	}
	
//	void bind(String name) throws RemoteException, MalformedURLException {
//		ActuatorIf stub = (ActuatorIf) UnicastRemoteObject.exportObject(this, 0);
//		//Bind instance to the RMI registry
//		Naming.rebind("//localhost/" + name, stub);
//        
//		System.out.println("PeerServer: " + name + ", " + this + " bound in registry");
//	}
}
