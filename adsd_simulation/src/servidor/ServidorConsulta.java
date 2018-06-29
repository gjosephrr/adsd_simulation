package servidor;

import eduni.simjava.*;

public class ServidorConsulta extends Sim_entity {

	private Sim_port inRequest;
	private Sim_port inDB;
	private Sim_port outDB;
	private Sim_port outRede;
	private double delay;
	

	public ServidorConsulta(String name, double delay) {
		super(name);
		this.delay = delay;
		
		this.inRequest = new Sim_port("InRequest");
		this.inDB = new Sim_port("InDB");
		this.outDB = new Sim_port("OutDB");
		this.outRede = new Sim_port("OutRede");

		add_port(inRequest);
		add_port(inDB);
		add_port(outDB);
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
