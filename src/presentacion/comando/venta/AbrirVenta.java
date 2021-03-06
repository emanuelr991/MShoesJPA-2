package presentacion.comando.venta;

import integracion.transacciones.conexion.Excepciones;

import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class AbrirVenta implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSAVenta().abrirVenta((Integer)datos));
			cr.setEvento(IDEventos.EVENTO_ABRIR_VENTA);
		}
		catch (Excepciones e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_ABRIR_VENTA);
		}
		return cr;
	}
}
