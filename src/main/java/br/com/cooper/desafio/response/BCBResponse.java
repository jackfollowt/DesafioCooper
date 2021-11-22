package br.com.cooper.desafio.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BCBResponse {

    private BigDecimal cotacaoCompra;

    private BigDecimal cotacaoVenda;

    private String dataHoraCotacao;
}
