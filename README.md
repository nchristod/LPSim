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

