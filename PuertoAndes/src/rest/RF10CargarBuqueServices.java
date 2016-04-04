package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.PuertoAndesMaster;
import vos.ListaRFC1;
import vos.RFC1;

@Path("rfc1")
public class RF10CargarBuqueServices 
{
	// Servicios REST tipo GET:
		/**
		 * Atributo que usa la anotación @Context para tener el ServletContext de la conexión actual.
		 */
		@Context
		private ServletContext context;

		/**
		 * Método que retorna el path de la carpeta WEB-INF/ConnectionData en el deploy actual dentro del servidor.
		 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
		 */
		private String getPath() {
			return context.getRealPath("WEB-INF/ConnectionData");
		}
		
		
		private String doErrorMessage(Exception e){
			return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
		}
		

		/**
		 * Método que expone servicio REST usando GET que da todos los videos de la base de datos.
		 * <b>URL: </b> http://"ip o nombre de host":8080/VideoAndes/rest/videos
		 * @return Json con todos los videos de la base de datos O json con 
	     * el error que se produjo
		 */
		@GET
		@Produces({ MediaType.APPLICATION_JSON })
		public Response getRFC1() {
			PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
			ListaRFC1 rfc1s;
			try {
				rfc1s = tm.darRFC1();
			} catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(rfc1s).build();
		}
}
