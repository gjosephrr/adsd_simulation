package rede;

import eduni.simjava.*;
import eduni.simjava.Sim_stat;

public class RedeAberta extends Sim_entity {

	private Sim_port inCliente;
	private Sim_port inCliente2;
	private Sim_port inRedeFechada;
	private Sim_port outGET;
	private Sim_port outPOST;
	private double delay;
	private Sim_stat status;

	public RedeAberta(String name, double average, double variance) {
		super(name);

		status = new Sim_stat();

		this.inCliente = new Sim_port("InCliente");
		this.inCliente2 = new Sim_port("InCliente2");
		this.inRedeFechada = new Sim_port("InRedeFechada");
		this.outGET = new Sim_port("OutGET");
		this.outPOST = new Sim_port("OutPOST");

		add_port(inCliente);
		add_port(inCliente2);
		add_port(inRedeFechada);
		add_port(outGET);
		add_port(outPOST);

		status.add_measure(Sim_stat.QUEUE_LENGTH);

		set_stat(status);
	}

	public void body() {
		while (Sim_system.running()) {
			Sim_event e = new Sim_event();
			sim_get_next(e);
			sim_process(delay);
			sim_completed(e);
		}

	}
}
