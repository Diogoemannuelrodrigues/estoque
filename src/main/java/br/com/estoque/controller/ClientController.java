package br.com.estoque.controller;

import br.com.estoque.model.Client;
import br.com.estoque.model.DTO.ClientDTO;
import br.com.estoque.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> saveClient (@RequestBody ClientDTO clientDTO){
        clientService.saveClient(clientDTO);
        return ResponseEntity.status(HttpStatus.OK).body(clientDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> findClient(@PathVariable Integer id){
        Client client = clientService.searchClient(id);
        return ResponseEntity.ok().body(client);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Client> alterClient (@PathVariable Integer id, @RequestBody ClientDTO clientDTO){
        Client clientAlt = clientService.updateClient(id, clientDTO);
        return ResponseEntity.ok().body(clientAlt);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Client> deletClient(@PathVariable Integer id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Client> listarClientes(){
        List<Client> clients = clientService.listClients();
        return clients;
    }

}
