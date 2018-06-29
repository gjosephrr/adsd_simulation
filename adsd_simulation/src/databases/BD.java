package databases;

import eduni.simjava.*;
import eduni.simjava.distributions.Sim_negexp_obj;

public class BD extends Sim_entity{
	
	  private Sim_port inOperacional;
	  private Sim_port inConsulta;
	  private Sim_port outOperacional;
	  private Sim_port outConsulta;
	  private double delay;
	  
	  
	BD(String name, double delay){
		super(name);
		
		inOperacional = new Sim_port("In");
		    add_port(inOperacional);
		    
		inConsulta = new Sim_port("InOperacional");
		    add_port(inConsulta);
		    
	    outOperacional = new Sim_port("outOperacional");
	    add_port(outOperacional);
	    
	    outConsulta = new Sim_port("OutConsulta");
	    add_port(outConsulta);
	}
	
	 public void body() {
	    while (Sim_system.running()) {
	    	
	    	 Sim_event e = new Sim_event();
	         sim_get_next(e);
	         sim_trace(1, "Disk request started" );
	         sim_process(delay);
	         sim_completed(e);	
	    }
	    
	    
	  }   
	

}
