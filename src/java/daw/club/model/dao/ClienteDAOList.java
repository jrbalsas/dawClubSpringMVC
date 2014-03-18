package daw.club.model.dao;

import daw.club.model.Cliente;
import daw.club.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("clienteDAOList")
public class ClienteDAOList implements ClienteDAO{

    private static ArrayList<Cliente> clientes=null;
    int idCliente = 1;

    public ClienteDAOList() {
        if (clientes == null) {
            clientes = new ArrayList<>();

            clientes.add(new Cliente(idCliente++, "Paco López", "11111111A", false));
            clientes.add(new Cliente(idCliente++, "María Jiménez", "22222222B", true));
            clientes.add(new Cliente(idCliente++, "Carlos García", "33333333C", true));
        }
    }
    
    @Override
    public Cliente buscaId(Integer id) {
        Cliente encontrado=null;
        for (Cliente c: clientes) {
               if (c.getId()==id) encontrado=c;
        }
        return encontrado;
    }
    @Override
    public List<Cliente> buscaTodos() {
        return clientes;
    }

    @Override
    public boolean crea(Cliente c) {
        c.setId(idCliente++);
        clientes.add(c);
        return true;
    }
        
    @Override
    public boolean guarda(Cliente c) {
        boolean result=false;
        for (int i=0; i<clientes.size();i++) {
            if (clientes.get(i).getId()==c.getId()) {
                clientes.set(i, c);
                result=true;
            }
        }       
        return result;
    }
    
    @Override
    public boolean borra(Integer id) {
        boolean result=false;
        for (int i=0; i<clientes.size();i++) {
            if (clientes.get(i).getId()==id) {
                clientes.remove(i);
                result=true;
            }
        }       
        return result;
    }
    
    public int numClientes() {
        return clientes.size();
    }

}
