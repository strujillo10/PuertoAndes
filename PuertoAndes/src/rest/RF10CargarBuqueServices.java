package rest;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.PuertoAndesMaster;
import vos.Administrador;
import vos.AreaAlmacenamiento;
import vos.Buque;
import vos.Carga;
import vos.ListaRFC1;
import vos.RFC1;

@Path("rf10")
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

		@POST
		@Path("/{buque}/{cargas}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateRF10(@PathParam("buque")Buque buque,@PathParam("cargas")ArrayList<Carga> cargas) 
		{
			PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
			try 
			{
				tm.cargarBuque(buque, cargas);
			} 
			catch (Exception e) 
			{
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(buque).build();
		}
}
