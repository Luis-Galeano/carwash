/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.web.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import py.com.carwash.ejb.bean.ReservasBean;
import py.com.carwash.ejb.dto.GenericResponse;
import py.com.carwash.ejb.model.ReservasRequest;

/**
 *
 * @author Luis Galeano
 */
@Path("reservas")
public class ReservasResource {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @EJB
    ReservasBean reservaBean;
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registrar")
    public GenericResponse getPrecioServicioPorVehiculo(ReservasRequest reservaRequest){
        return reservaBean.registrarReserva(reservaRequest);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse getPrecioServicioPorVehiculo(){
        return reservaBean.getReservas();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("eliminar")
    public GenericResponse eliminarReserva(@QueryParam("idReserva") Integer idReserva){
        return reservaBean.eliminarReserva(idReserva);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("verificar")
    public GenericResponse verificarReserva(@QueryParam("fecha") String fecha){
        return reservaBean.verificarDisponibilidad(fecha);
    }
}
