/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fornecedoradecarros;

/**
 *
 * @author pronatec
 */
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Root resource (exposed at "myresource" path)
 */
// ALTERAR 
@Path("FornCarros")
public class JerseyExemploController {

    private CarroDAO carroDAO;

    public JerseyExemploController() {
        carroDAO = CarroDAO.getInstance();
    }

    @GET
    @Path("adicionar")
    public Response adicionar(@QueryParam("chassi") int chassi,
            @QueryParam("marca") String marca,
            @QueryParam("modelo") String modelo,
            @QueryParam("ano") int ano,
            @QueryParam("quilometragem") int quilometragem) {
        Carro carro = new Carro(chassi, marca, modelo, ano, quilometragem);
        this.carroDAO.adicionar(carro);
        return Response.status(Status.OK).build();

    }

    @GET
    @Path("consultarEstoque")
    @Produces(MediaType.TEXT_PLAIN)
    public Response consultarEstoque() {
        Gson gson = new Gson();
        return Response.status(Status.OK).entity(gson.toJson(carroDAO.recuperarTodos())).build();
    }

    @GET
    @Path("remover")
    public Response remover(@QueryParam("chassi") int chassi) {
        Carro carro = new Carro(chassi);
        this.carroDAO.deletar(carro);
        return Response.status(Status.OK).build();
    }

    @GET
    @Path("alterar")
    public Response alterar(@QueryParam("chassi") int chassi,
            @QueryParam("marca") String marca,
            @QueryParam("modelo") String modelo,
            @QueryParam("ano") int ano,
            @QueryParam("quilometragem") int quilometragem) {
        Carro carro = new Carro(chassi, marca, modelo, ano, quilometragem);
        this.carroDAO.alterar(carro);
        return Response.status(Status.OK).build();
    }

    @GET
    @Path("consultarCarro")
    @Produces(MediaType.TEXT_PLAIN)
    public Response consultar(@QueryParam("chassi") int chassi) {
        Gson gson = new Gson();
        return Response.status(Status.OK).entity(gson.toJson(carroDAO.recuperar(chassi))).build();
    }
}
