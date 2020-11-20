/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UsuarioDAO;
import dto.Usuario;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Carlos Chinga
 */
@Path("usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

	
	@POST
	public Usuario guardarTarjeta(Usuario usuario) {
		UsuarioDAO.agregar(usuario);
		return usuario;
	}

	@GET
	public List<Usuario> obtenerTarjetas() {
		return UsuarioDAO.listar();
	}
}
