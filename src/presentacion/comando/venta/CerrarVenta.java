package presentacion.comando.venta;

import integracion.transacciones.conexion.Excepciones;

import negocio.serviciosAplicacion.FactorySA;
import negocio.venta.TransferVenta;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class CerrarVenta implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSAVenta().cerrarVenta((TransferVenta)datos));
			cr.setEvento(IDEventos.EVENTO_CERRAR_VENTA);
		}
		catch (Excepciones e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_CERRAR_VENTA);
		}
		return cr;
	}
}
