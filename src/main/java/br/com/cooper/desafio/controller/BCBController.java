package br.com.cooper.desafio.controller;

    import br.com.cooper.desafio.response.BCBResponse;
    import br.com.cooper.desafio.service.serviceImpl.BCBService;
    import org.jboss.resteasy.annotations.jaxrs.PathParam;
    import org.springframework.http.ResponseEntity;

    import javax.inject.Inject;
    import javax.ws.rs.GET;
import javax.ws.rs.Path;
    import java.util.List;

@Path("/")
public class BCBController {

    @Inject
    private BCBService service;

    @GET
    @Path("/{dataCotacao}")
    public ResponseEntity<List<BCBResponse>> getDadosCotacao(@PathParam String dataCotacao){
        List<BCBResponse> response = service.getDadosCotacao(dataCotacao);
        return response.size() > 0 ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
}
