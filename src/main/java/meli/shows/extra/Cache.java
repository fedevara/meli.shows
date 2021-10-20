package meli.shows.extra;

import meli.shows.entities.Funcion;
import meli.shows.entities.assembler.FuncionAssembler;
import meli.shows.entities.assembler.ShowAssembler;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.entities.dto.ShowDTO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Cache {

    private static Date updateTime;
    private Map<Long, ShowDTO> showMap = new HashMap<>();
    private Map<Long, FuncionDTO> funcionMap = new HashMap<>();

    private static Cache instance;

    public static Cache getInstance() {

        if (instance==null) {
            instance=new Cache();
        }
        return instance;

    }

    private Cache(){

    }

    public boolean isDataValid() {

        if (updateTime==null){
            updateTime = new Date();
            return false;
        }else{

            long diffInMillies = Math.abs(updateTime.getTime() - (new Date()).getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            return diff < 1;
        }

    }

    public void addShow(ShowDTO showDTO) {
        showMap.put(showDTO.getId(), showDTO);
    }

    public List<ShowDTO> getAllShows() {
        return showMap.values().stream().collect(Collectors.toList());
    }

    public FuncionDTO getFuncion(Long idFuncion) {
        return funcionMap.get(idFuncion);
    }

    public ShowDTO getShow(Long idShow) {
        return showMap.get(idShow);
    }

    public void addFuncion(FuncionDTO funcion) {
        funcionMap.put(funcion.getId(), funcion);
    }
}