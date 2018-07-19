package request;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_stat;
import eduni.simjava.Sim_system;

public class RequestGet2 extends Sim_entity{

	private Sim_port inRedeFechada;
	private Sim_port outServidorConsulta;
	private double delay;
	private Sim_stat status;

	public RequestGet2(String name) {
		super(name);

		status = new Sim_stat();

		this.inRedeFechada = new Sim_port("InRedeFechada");
		this.outServidorConsulta = new Sim_port("OutServidorComsulta");

		add_port(inRedeFechada);
		add_port(outServidorConsulta);
		
	}

	public void body() {
		while (Sim_system.running()) {
			Sim_event e = new Sim_event();
			sim_get_next(e);
			sim_process(delay);
			sim_completed(e);

			sim_trace(1, "going to the server.");
			sim_schedule(outServidorConsulta, 0.0, 1);
		}
	}
}