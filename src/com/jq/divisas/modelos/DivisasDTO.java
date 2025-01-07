package com.jq.divisas.modelos;

//Record de API Exchange-Rate
public record DivisasDTO(String base_code, String target_code, double conversion_rate, double conversion_result) {
}
