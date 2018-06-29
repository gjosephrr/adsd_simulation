package cliente;

import eduni.simjava.*;

class Cliente extends Sim_entity {
	private Sim_port outCPU1;
	private double delay;

	Cliente(String name, double delay) {
		super(name);
		this.delay = delay;
		outCPU1 = new Sim_port("OutCPU1");
		add_port(outCPU1);
	}

	public void body() {
		for (int i = 0; i < 100; i++) {
			sim_schedule(outCPU1, 0.0, 0);
			sim_trace(1, "New request from processor.");
			sim_pause(delay);
		}
	}
}
