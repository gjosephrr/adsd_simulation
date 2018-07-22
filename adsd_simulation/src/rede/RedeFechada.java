package rede;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_stat;
import eduni.simjava.Sim_system;

public class RedeFechada extends Sim_entity{
	
	private Sim_port inBD;
	private Sim_port inConsulta;
	private Sim_port outRedeAberta;
	private Sim_port outGET2;
	private double delay;
	private Sim_stat status;
	
	public RedeFechada(String name, double average, double variance) {
		super(name);

		status = new Sim_stat();

		this.inBD = new Sim_port("InBD");
		this.outRedeAberta = new Sim_port("OutRedeAberta");
		this.outGET2 = new Sim_port("OutGET2");

		inConsulta = new Sim_port("InServidorConsulta");
		add_port(inConsulta);

		add_port(inBD);
		add_port(outRedeAberta);
		add_port(outGET2);

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
