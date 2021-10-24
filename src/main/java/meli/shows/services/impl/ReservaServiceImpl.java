package meli.shows.services.impl;

import lombok.NonNull;
import meli.shows.entities.Reserva;
import meli.shows.entities.assembler.ReservaAssembler;
import meli.shows.entities.dto.ReservaDTO;
import meli.shows.entities.exception.ReservaAlreadyExistException;
import meli.shows.repository.ReservaRepository;
import meli.shows.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    // TODO crear una reserva ok, crear una reserva que ya este reservada y dar error,
    @Override
    public ReservaDTO registrar(@NonNull ReservaDTO nuevaReserva) throws ReservaAlreadyExistException {

        long butacaId = nuevaReserva.getButaca().getId();
        long funcionId = nuevaReserva.getFuncion().getId();

        Optional<Reserva> reservaOptional = reservaRepository.selectByButacaAndFuncion(butacaId, funcionId);

        Reserva reservaOk;
        if (reservaOptional.isEmpty()) {
            reservaOk = reservaRepository.save(ReservaAssembler.assemble(nuevaReserva));
            return ReservaAssembler.assemble(reservaOk);
        }

        if (nuevaReserva.getDocumento().equals(reservaOptional.get().getDocumento())) {
            return ReservaAssembler.assemble(reservaOptional.get());
        }

        throw new ReservaAlreadyExistException();
    }

    @Override
    public List<ReservaDTO> getAll() {

        List<ReservaDTO> reservaResponse = new ArrayList<>();

        for (Reserva reserva : reservaRepository.findAll()) {
            reservaResponse.add(ReservaAssembler.assemble(reserva));
        }

        return reservaResponse;

    }

    @Override
    public Optional<Reserva> getById(Long id) {
        return reservaRepository.findById(id);
    }
}
