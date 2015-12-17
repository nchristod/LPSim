This is a simulator for a Plant that contains sensors and actuators to control liquid flow between Silos and through a Pipe.

It's supposed to be coupled with a controller that realizes the needed control logic.

## Usage

Actuators implement the interface ActuatorIf:

```java
public interface ActuatorIf {

	void open();

	void close();

	Boolean getStatus();

}
```

Sensors implement the interface Senseable:

```java
public interface Senseable {

	String getData();

}
```
A simple usage scenario is shown at TestSimInteg.java.

### Coupling with a controller / Stubbing the boundaries

- Import the GUI and run the frame as you would.
- At your boundary objects that are supposed to talk to the real Sensors call the `get(String name)` method on the GUI frame to get the device you need. The parameter `name` expects a string consisting of "siloname" + "device". For example `get("s1In")` returns the InValve of s1. For naming details see the method implementation. 
