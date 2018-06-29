package servidor;

import eduni.simjava.*;

public class ServidorOperacional extends Sim_entity {

	private Sim_port inRequestGET;
	private Sim_port inRequestPOST;
	private Sim_port inDB;
	private Sim_port outDB;
	private Sim_port outCliente;
	private double delay;

	public ServidorOperacional(String name, double delay) {
		super(name);
		this.delay = delay;
		
		this.inRequestGET = new Sim_port("InRequestGET");
		this.inRequestPOST = new Sim_port("InRequestPOST");
		this.inDB = new Sim_port("InDB");
		this.outDB = new Sim_port("OutDB");
		this.outCliente = new Sim_port("OutCliente");

		add_port(inRequestGET);
		add_port(inRequestPOST);
		add_port(inDB);
		add_port(outDB);
		add_port(outCliente);

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
