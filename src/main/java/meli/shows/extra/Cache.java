package meli.shows.extra;

import meli.shows.controllers.request.AdvanceSearchRequest;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.entities.dto.ShowDTO;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Cache {

    private static Date updateTime;
    private final Map<Long, ShowDTO> showMap = new HashMap<>();
    private final Map<Long, FuncionDTO> funcionMap = new HashMap<>();
    private final Map<AdvanceSearchRequest, List<ShowDTO>> advanceSearchRequest = createRequestMap(100);

    private static Cache instance;

    public static Cache getInstance() {

        if (instance == null) {
            instance = new Cache();
        }
        return instance;

    }

    private Cache() {

    }

    public boolean isDataValid() {

        if (updateTime == null) {
            updateTime = new Date();
            return false;
        } else {

            long diffInMillies = Math.abs(updateTime.getTime() - (new Date()).getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            return diff < 1;
        }

    }

    /**
     * Map usado como cache de Request de Busqueda avanzada de Shows
     *
     * @param maxEntries tamaño maximo del mapa
     * @return mapa creado
     */
    public static <K, V> Map<K, V> createRequestMap(final int maxEntries) {
        return new LinkedHashMap<K, V>(maxEntries * 10 / 7, 0.7f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxEntries;
            }
        };
    }

    public void addShow(ShowDTO showDTO) {
        showMap.put(showDTO.getId(), showDTO);
    }

    public List<ShowDTO> getAllShows() {
        return new ArrayList<>(showMap.values());
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

    public List<ShowDTO> getAdvancedAll(AdvanceSearchRequest request) {
        return advanceSearchRequest.get(request);
    }

    public void addRequest(AdvanceSearchRequest request, List<ShowDTO> listDto) {
        advanceSearchRequest.put(request, listDto);
    }

}