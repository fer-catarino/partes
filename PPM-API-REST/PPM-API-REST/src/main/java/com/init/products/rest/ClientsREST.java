package com.init.products.rest;

import java.util.List;
import java.util.Optional;
import com.init.products.dao.ClientsDAO;
import com.init.products.entitys.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clients")
public class ClientsREST {

    @Autowired
    private ClientsDAO clientsDAO;

    @GetMapping
    public ResponseEntity<List<Clients>> getClients(){
        List<Clients> clients = clientsDAO.findAll();
        return ResponseEntity.ok(clients);
    }

    @RequestMapping(value="{clientsId}")// /clients/{clientsId} -> /clients/1
    public ResponseEntity<Clients> getClientsById(@PathVariable("membersId") Long clientsId){
        Optional<Clients> optionalClients= clientsDAO.findById(clientsId);
        if(optionalClients.isPresent()){
            return ResponseEntity.ok(optionalClients.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //Insertar a la base de datos
    @PostMapping // /clients (POST)
    public ResponseEntity<Clients> createClients(@RequestBody Clients clients){
        Clients newClients = clientsDAO.save(clients);
        return ResponseEntity.ok(newClients);
    }

    @DeleteMapping(value="{clientsId}") // /clients(DELETE)
    public ResponseEntity<Void> deleteClients(@PathVariable("clientsId") Long clientsId){
        clientsDAO.deleteById(clientsId);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Clients> updateClients(@RequestBody Clients clients){
        Optional<Clients> optionalClients= clientsDAO.findById(clients.getId());
        if(optionalClients.isPresent()) {
            Clients updateClients = optionalClients.get();
            updateClients.setName(clients.getName());
            clientsDAO.save(updateClients);
            return ResponseEntity.ok(updateClients);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}