package meli.shows.entities.exception;

import lombok.Getter;
import meli.shows.entities.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "El rango de fechas ingresado no es valido")
public class RangoFechaException extends Exception {

    private final MessageDTO customMessage;

    public RangoFechaException() {
        customMessage = new MessageDTO("El rango de fechas ingresado no es valido");
    }

}
