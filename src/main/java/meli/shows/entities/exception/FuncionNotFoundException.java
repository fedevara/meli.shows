package meli.shows.entities.exception;

import lombok.Getter;
import meli.shows.entities.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FuncionNotFoundException extends Exception {

    private final MessageDTO customMessage;

    public FuncionNotFoundException() {
        customMessage = new MessageDTO("La funcion que esta buscando no es correcta");
    }

}
