package org.nchristod.lp.simulator;

public interface ActuatorIf {

	void open();

	void close();

	Boolean getStatus();

}