package br.com.cooper.desafio.restApi;

import br.com.cooper.desafio.response.BCBResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey="BCBEndpoint")
public interface BCBApi {

    @GET
    @Path("/{dataCotacao}&$top=100&$format=json")
    @Produces(MediaType.APPLICATION_JSON)
    BCBResponse getCotacaoDolarDia(@QueryParam("dataCotacao") String dataCotacao);
}
