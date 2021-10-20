package meli.shows.entities.exception;

import lombok.Getter;
import meli.shows.entities.dto.MessageDTO;

@Getter
public class ReservaAlreadyExistException extends Exception {
    private MessageDTO customMessage;

    public ReservaAlreadyExistException() {
        customMessage = new MessageDTO("La butaca seleccionada ya no se encuentra disponible para la funcion");
    }

}
