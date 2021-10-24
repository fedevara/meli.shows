package meli.shows.repository.impl;

import meli.shows.controllers.request.AdvanceSearchRequest;
import meli.shows.entities.Show;
import meli.shows.repository.ShowCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class ShowCustomRepositoryImpl implements ShowCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Show> findAdvancedAll(AdvanceSearchRequest request) {

        StringBuilder sb = new StringBuilder("SELECT S FROM Show S");

        filterJoin(request, sb);

        filterQuery(request.getNombre(), request.getCategoria(), request.getFechaInicio(), request.getFechaFin(), request.getPrecioMinimo(), request.getPrecioMaximo(), sb);

        orderResult(request.getOrden(), request.getDireccion(), sb);

        TypedQuery<Show> query = entityManager.createQuery(sb.toString(), Show.class);

        return (query.getResultList()).stream().distinct().collect(Collectors.toList());
    }

    /**
     *
     * @param request
     * @param sb
     */
    private void filterJoin(AdvanceSearchRequest request, StringBuilder sb) {

        if (request.getFechaFin() != null || request.getFechaInicio() != null || request.getOrden() != null && request.getOrden().equals("fecha")) {
            sb.append(" INNER JOIN Funcion F");
            sb.append(" ON F.show = S.id");
        }

        if (request.getPrecioMinimo() != null || request.getPrecioMaximo() != null || request.getOrden() != null && request.getOrden().equals("precio")) {
            sb.append(" INNER JOIN Seccion SE");
            sb.append(" ON SE.show = S.id");
        }

    }

    /**
     * Agrega los filtros de la consulta
     *
     * @param nombre       nombre del Show
     * @param categoria    nombre de la categoria del Show
     * @param fechaInicio  fecha desde la cual se buscan las Funciones de los Shows
     * @param fechaFin     fecha hasta la cual se buscan las funciones de los Shows
     * @param precioMinimo precio minimo de la Butaca
     * @param precioMaximo precio maximo de la Butaca
     * @param sb           la query
     */
    private void filterQuery(String nombre, String categoria, String fechaInicio, String fechaFin, Double precioMinimo, Double precioMaximo, StringBuilder sb) {

        boolean queryFiltered = filterShow(nombre, categoria, sb);

        queryFiltered = filterFuncion(fechaInicio, fechaFin, queryFiltered, sb);

        filterSeccion(precioMinimo, precioMaximo, queryFiltered, sb);

    }

    /**
     * Agrega las condiciones del show: nombre y categoria
     *
     * @param nombre    nombre del Show
     * @param categoria nombre de la categoria del Show
     * @param sb        la query
     * @return true si se aplico algun filtro, false si no se aplico ningun filtro
     */
    private boolean filterShow(String nombre, String categoria, StringBuilder sb) {
        boolean queryFiltered = false;
        if (isValidField(nombre)) {
            sb.append(" WHERE UPPER(S.nombre) LIKE UPPER('%").append(nombre).append("%')");
            queryFiltered = true;
        }
        if (isValidField(categoria)) {
            queryFiltered = isQueryFiltered(queryFiltered, sb);
            sb.append(" UPPER(S.categoria) LIKE UPPER('%").append(categoria).append("%')");
        }
        return queryFiltered;
    }

    /**
     * Agrega las condiciones de la funcion: intervalo de fechas
     *
     * @param fechaInicio   fecha desde la cual se buscan las Funciones de los Shows
     * @param fechaFin      fecha hasta la cual se buscan las funciones de los Shows
     * @param queryFiltered indica si ya se aplico algun filtro
     * @param sb            la query
     * @return true si se aplico algun filtro, false si no se aplico ningun filtro
     */
    private boolean filterFuncion(String fechaInicio, String fechaFin, boolean queryFiltered, StringBuilder sb) {
        if (isValidField(fechaInicio)) {
            queryFiltered = isQueryFiltered(queryFiltered, sb);
            sb.append(" TO_DATE(F.diaHorario, 'YYYY-MM-DD') >= TO_DATE('").append(fechaInicio).append("', 'YYYY-MM-DD')");
        }
        if (isValidField(fechaFin)) {
            queryFiltered = isQueryFiltered(queryFiltered, sb);
            sb.append(" TO_DATE(F.diaHorario, 'YYYY-MM-DD') <= TO_DATE('").append(fechaFin).append("', 'YYYY-MM-DD')");
        }
        return queryFiltered;
    }

    /**
     * Agrega las condiciones de las Butacas: intervalo de precios
     *
     * @param precioMinimo  precio minimo de la Butaca
     * @param precioMaximo  precio maximo de la Butaca
     * @param queryFiltered indica si ya se aplico algun filtro
     * @param sb            la query
     */
    private void filterSeccion(Double precioMinimo, Double precioMaximo, boolean queryFiltered, StringBuilder sb) {
        if (precioMinimo != null) {
            queryFiltered = isQueryFiltered(queryFiltered, sb);
            sb.append(" SE.precio >= ").append(precioMinimo.toString());
        }
        if (precioMaximo != null) {
            isQueryFiltered(queryFiltered, sb);
            sb.append(" SE.precio <= ").append(precioMaximo.toString());
        }
    }

    /**
     * Aplica order by a la consulta
     *
     * @param orden     Columna por la cual se aplicara el orden.
     *                  Posibles valores: nombre, categoria, precio, fecha
     * @param direccion 0 si es Ascendente, 1 si es Descendente
     * @param sb        la query
     */
    private void orderResult(String orden, String direccion, StringBuilder sb) {

        if (("0").equals(direccion) || ("1").equals(direccion)) {

            if (isValidField(orden)) {
                if (orden.equals("nombre") || orden.equals("categoria")) {
                    sb.append(" ORDER BY S.").append(orden);
                }
                if (orden.equals("precio")) {
                    sb.append(" ORDER BY SE.").append(orden);
                }
                if (orden.equals("fecha")) {
                    sb.append(" ORDER BY F.diaHorario");
                }
                if (direccion.equals("0")) {
                    sb.append(" ASC");
                } else {
                    sb.append(" DESC");
                }
            }
        }
    }

    /**
     * Indica si ya se ha aplicado algun filtro a la consulta.
     * La primera vez que una columna cumpla el criterio de filtrado se aplicara el 'where' a la consulta y se devolvera true.
     * Luego de la primer consulta se aplica 'and' y se devuelve true
     *
     * @param queryFiltered true si se aplico algun filtro, false si no se aplico ningun filtro
     * @param sb            la query
     * @return estado del filtro
     */
    private boolean isQueryFiltered(boolean queryFiltered, StringBuilder sb) {
        if (queryFiltered) {
            sb.append(" AND");
        } else {
            sb.append(" WHERE");
        }
        return true;
    }

    /**
     * Comprueba que la columna seleccionada sea valida
     *
     * @param field columna a comprobar
     * @return true si es valido, false si no es valido
     */
    private boolean isValidField(String field) {
        return field != null && !"".equals(field);
    }

}