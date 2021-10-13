package meli.shows.entities.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class SeccionDTO {

    private Long id;

    private BigDecimal precio;

    private List<ButacaDTO> butacas;

}
