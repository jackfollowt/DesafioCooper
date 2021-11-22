package br.com.cooper.desafio.service.serviceImpl;

import br.com.cooper.desafio.response.BCBResponse;

import java.util.List;

public interface BCBService {

    List<BCBResponse> getDadosCotacao(String dataCotacao);
}
