package org.nchristod.lp.simulator;

public class TestSimInteg {
	
	static LpSimulator frame;
	
	public static void main(String[] args) {
	
			frame = new LpSimulator();
			frame.setVisible(true);
			
			Thread a = new Thread( new Runnable() {
				public void run() {
					//fill
					frame.s1In.open();
					while (frame.s1.fLevel.getData() == "false") {
						// do nothing
					}
					frame.s1In.close();
					
					// request pipe
					System.out.println("s2Out is: " + frame.s2Out.getStatus());
					while (frame.s2Out.getStatus()) {
						//do nothing
					}
					
					//empty
					frame.s1Out.open();
					
					//fill
					frame.s4In.open();
					while (frame.s4.fLevel.getData() == "false") {
						// do nothing
					}
					frame.s1Out.close();
					frame.s4In.close();
					
					//heat
					frame.s4Resistor.open();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.s4Resistor.close();
					
					//request mixer
					while (frame.s3Mixer.getStatus()) {
						//wait
					}
					
					//mix
					frame.s4Mixer.open();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.s4Mixer.close();
					
					//empty
					frame.s4Out.open();
					System.out.println("A ENDED");
				}
			});
			Thread b = new Thread( new Runnable() {
				public void run() {
					//fill
					frame.s2In.open();
					while (frame.s2.fLevel.getData() == "false") {
						// do nothing
					}
					frame.s2In.close();
					
					//heat
					frame.s2Resistor.open();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.s2Resistor.close();
					
					//request pipe
					System.out.println("s1Out is: " + frame.s1Out.getStatus());
					while (frame.s1Out.getStatus()) {
						//do nothing
						System.out.println("s1Out is: " + frame.s1Out.getStatus());
					}
					
					//empty
					frame.s2Out.open();
					
					//fill
					frame.s3In.open();
					while (frame.s3.fLevel.getData() == "false") {
						// do nothing
					}
					frame.s2Out.close();
					frame.s3In.close();
					
					//request mixer
					while (frame.s4Mixer.getStatus()) {
						//wait
					}
					
					//mix
					frame.s3Mixer.open();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.s3Mixer.close();
					
					//empty
					frame.s3Out.open();
					System.out.println("B ENDED");
				}
			});
			a.start();
			b.start();
	}

}
