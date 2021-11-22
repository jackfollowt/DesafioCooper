package br.com.cooper.desafio.service.serviceImpl;

import br.com.cooper.desafio.response.BCBResponse;
import br.com.cooper.desafio.restApi.BCBApi;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BCBServiceImpl implements BCBService{

    @Inject
    @RestClient
    private BCBApi bcbApi;

    public List<BCBResponse> getDadosCotacao(String dataCotacao){

        List<BCBResponse> bcbResponseList = new ArrayList<>();
        Boolean isDiaUtil = validaDiaUtil(dataCotacao);

        if (isDiaUtil){
            BCBResponse response = bcbApi.getCotacaoDolarDia(dataCotacao);
            BCBResponse bcbResponse = bcbApi.getCotacaoDolarDia(response.getDataHoraCotacao() +1);

            bcbResponseList.add(response);
            bcbResponseList.add(bcbResponse);
        }


     return bcbResponseList;

    }

    private Boolean validaDiaUtil(String dataHoraCotacao) {

       LocalDate isDiaUtil = LocalDate.parse(dataHoraCotacao);
        DayOfWeek d = isDiaUtil.getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;

    }
}
