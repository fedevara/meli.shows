package meli.shows.services.impl;

import meli.shows.entities.Reserva;
import meli.shows.entities.assembler.ReservaAssembler;
import meli.shows.entities.dto.ReservaDTO;
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

    @Override
    public ReservaDTO registrar(ReservaDTO reserva) {
        if(reserva != null){
            Reserva reservaOk = reservaRepository.save(ReservaAssembler.assemble(reserva));
            return ReservaAssembler.assemble(reservaOk);
        }
        return null;
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
