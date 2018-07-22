package simulacao;

import cliente.*;
import database.BD;
import eduni.simjava.Sim_system;
import rede.RedeAberta;
import rede.RedeFechada;
import request.RequestGet;
import request.RequestGet2;
import request.RequestPost;
import servidor.ServidorConsulta;
import servidor.ServidorOperacional;

public class Simulacao {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Sim_system.initialise();
		
		Cliente cliente = new Cliente("Cliente", 100);
		Cliente cliente2 = new Cliente("Cliente2", 100);
		
		RedeAberta redeAberta = new RedeAberta("RedeAberta", 100, 100);
		RedeFechada redeFechada = new RedeFechada("RedeFechada", 100, 100);
		
		RequestGet getRequest = new RequestGet("GETRequest");
		RequestGet2 getRequest2 = new RequestGet2("GET2Request");
		RequestPost postRequest = new RequestPost("POSTRequest");
		
		ServidorOperacional serveroperacional = new ServidorOperacional("ServidorOperacional", 120);
		ServidorConsulta serverconsulta = new ServidorConsulta("ServidorConsulta", 120);
		BD bd = new BD("BD", 100);
		
		
		Sim_system.link_ports("Cliente", "OutRede", "RedeAberta", "InCliente");
		Sim_system.link_ports("Cliente2", "OutRede", "RedeAberta", "InCliente2");
		
		Sim_system.link_ports("RedeAberta", "OutGET", "GETRequest", "InRedeAberta");
		Sim_system.link_ports("RedeAberta", "OutPOST", "POSTRequest", "InRedeAberta");
		
		Sim_system.link_ports("GETRequest", "OutServidorOperacional", "ServidorOperacional", "InRequestGET");
		Sim_system.link_ports("POSTRequest", "OutServidorOperacional", "ServidorOperacional", "InRequestPOST");
		
		Sim_system.link_ports("ServidorOperacional", "OutBD", "BD", "InServidorOperacional");
		Sim_system.link_ports("ServidorOperacional", "OutCliente", "Cliente", "InServidorOperacional");
		Sim_system.link_ports("ServidorOperacional", "OutCliente", "Cliente2", "InServidorOperacional");
		
		
		Sim_system.link_ports("BD", "OutServidorOperacional", "ServidorOperacional", "InBD");
		Sim_system.link_ports("BD", "OutServidorConsulta", "ServidorConsulta", "InBD");
		
		Sim_system.link_ports("ServidorConsulta", "OutBD", "BD", "InServidorConsulta");
		Sim_system.link_ports("ServidorConsulta", "OutRede", "RedeFechada", "InServidorConsulta");
		
		Sim_system.link_ports("RedeFechada", "OutGET2", "GET2Request", "InRedeFechada");
		Sim_system.link_ports("RedeFechada", "OutRedeAberta", "RedeAberta", "InRedeFechada");
		
		Sim_system.link_ports("GET2Request", "OutServidorConsulta", "ServidorConsulta", "InRequest");	
		
		Sim_system.set_trace_detail(false, true, false);
		Sim_system.run();
	}
}
