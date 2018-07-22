package servidor;

import eduni.simjava.*;

public class ServidorConsulta extends Sim_entity {

	private Sim_port inRequest;
	private Sim_port inBD;
	private Sim_port outBD;
	private Sim_port outRede;
	private double delay;
	

	public ServidorConsulta(String name, double delay) {
		super(name);
		this.delay = delay;
		
		this.inRequest = new Sim_port("InRequest");
		this.inBD = new Sim_port("InBD");
		this.outBD = new Sim_port("OutBD");
		this.outRede = new Sim_port("OutRede");

		add_port(inRequest);
		add_port(inBD);
		add_port(outBD);
		add_port(outRede);

	}
	public void body() {
		while (Sim_system.running()) {
			Sim_event e = new Sim_event();
			sim_get_next(e);
			sim_process(delay);
			sim_completed(e);

			sim_trace(1, "Request arrived at the server.");
		}
	}
}
