package pe.cmacica.labs.lab03.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.cmacica.labs.lab03.dominio.Cliente;
import pe.cmacica.labs.lab03.service.ClienteService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public HttpEntity<List<Cliente>> listar()
    {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{id}")
    public HttpEntity<Cliente> listar(@PathVariable("id") int id)
    {
        if(id==5)
        {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(clienteService.getCliente(id));
    }

    private static  final Logger LOGGER= LoggerFactory.getLogger(ClienteController.class);
    @PostMapping
    public HttpEntity<String> guardar(@RequestBody Cliente cliente) {

        LOGGER.debug("{}", cliente.getId());
        LOGGER.debug(cliente.getNombres());

        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public HttpEntity<String> Actualizar(@PathVariable("id") int id,@RequestBody Cliente cliente) {

        LOGGER.debug("UPDATE");

        if(id==0)
        {
            return ResponseEntity.badRequest().build();
        }

        if(StringUtils.isBlank(cliente.getNombres()))
        {
            return ResponseEntity.badRequest().build();
        }


        LOGGER.debug("{}", cliente.getId());
        LOGGER.debug(cliente.getNombres());

        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<String> Eliminar(@PathVariable("id") int id) {

        LOGGER.debug("DELETE");
        if(id==0)
        {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.accepted().build();
    }

}
