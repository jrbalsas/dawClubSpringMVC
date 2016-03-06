package com.daw.club.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/*Sample DAO implementation using an ArrayList of Objects in memory*/
@Repository("medioPagoDAOList")
public class MedioPagoDAO {

    private final  ArrayList<String> medios;

    public MedioPagoDAO() {
            medios = new ArrayList<>();
            medios.add("No especificado");
            medios.add("VISA");
            medios.add("Mastercard");
            medios.add("Cuenta bancaria");            
    }
        
    public String buscaId(Integer id) {
        return medios.get(id);
    }

    public List<String> buscaTodos() {
        return medios;
    }

}
