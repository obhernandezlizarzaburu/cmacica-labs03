package pe.cmacica.labs.lab03.service;

import pe.cmacica.labs.lab03.dominio.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listar();
    Cliente getCliente(int id);
    int eliminar(int id);
    int update(Cliente cliente);
}
