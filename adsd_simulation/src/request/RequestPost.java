package request;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_stat;
import eduni.simjava.Sim_system;

public class RequestPost extends Sim_entity{

	private Sim_port inRedeAberta;
	private Sim_port outServidorOperacional;
	private double delay;
	private Sim_stat status;

	public RequestPost(String name) {
		super(name);

		status = new Sim_stat();

		this.inRedeAberta = new Sim_port("InRedeAberta");
		this.outServidorOperacional = new Sim_port("OutServidorOperacional");

		add_port(inRedeAberta);
		add_port(outServidorOperacional);
		
	}

	public void body() {
		while (Sim_system.running()) {
			Sim_event e = new Sim_event();
			sim_get_next(e);
			sim_process(delay);
			sim_completed(e);

			sim_trace(1, "going to the server.");
			sim_schedule(outServidorOperacional, 0.0, 1);
		}
	}
}