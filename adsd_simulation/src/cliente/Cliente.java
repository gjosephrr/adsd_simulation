package cliente;

import eduni.simjava.*;

public class Cliente extends Sim_entity {
	private Sim_port inServidorOperacional;
	private Sim_port outRede;
	private double delay;

	public Cliente(String name, double delay) {
		super(name);
		this.delay = delay;
		inServidorOperacional = new Sim_port("InServidorOperacional");
		outRede = new Sim_port("OutRede");
		add_port(outRede);
		add_port(inServidorOperacional);
	}

	public void body() {
		for (int i = 0; i < 100; i++) {
			sim_schedule(outRede, 0.0, 0);
			sim_trace(1, "New request from processor.");
			sim_pause(delay);
		}
	}
}
