package umg.paginasweb.recetas.ws;

import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

public class RecetasWSEndPoint extends AbstractMarshallingPayloadEndpoint {

	public RecetasWSEndPoint(Marshaller marshaller) {
		super(marshaller);
	}

	protected Object invokeInternal(Object sm) throws Exception {
		Sumandos sumandos = new Sumandos();
		Resultado resultado = new Resultado();

		sumandos = (Sumandos) sm;

		resultado.setResultado(sumandos.getSumando1() + sumandos.getSumando2());

		return resultado;
	}

}
