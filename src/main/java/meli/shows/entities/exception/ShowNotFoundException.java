package meli.shows.entities.exception;

import lombok.Getter;
import meli.shows.entities.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ShowNotFoundException extends Exception {

    private final MessageDTO customMessage;

    public ShowNotFoundException() {
        customMessage = new MessageDTO("El show que esta buscando no es correcto");
    }

}
