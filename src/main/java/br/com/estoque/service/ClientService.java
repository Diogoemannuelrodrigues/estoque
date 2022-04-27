package br.com.estoque.service;

import br.com.estoque.config.BaseService;
import br.com.estoque.exceptions.ClientNotFoundException;
import br.com.estoque.model.Client;
import br.com.estoque.model.DTO.ClientDTO;
import br.com.estoque.repository.ClienttRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientService extends BaseService {

    @Autowired
    private ClienttRepository clienttRepository;

    public Client searchClient(Integer id) {
        Optional<Client> client = clienttRepository.findById(id);
        return client.orElseThrow(() -> new ClientNotFoundException("Client {} NOT FOUND",
                client.get().getNameClient()));
    }

    public Client saveClient(ClientDTO clientDTO){
        return clienttRepository.save(getConverter().map(clientDTO, Client.class));
    }

    public void deleteClient(Integer id) {
        clienttRepository.deleteById(id);
    }

    public Client updateClient(Integer id, ClientDTO clientDTO) {
        Optional<Client> clientFound = clienttRepository.findById(id);
        if(clientFound.isPresent()){
            clientFound.get().setNameClient(clientDTO.getNameClient());
            clientFound.get().setAddress(clientDTO.getAddress());
            clientFound.get().setCpf(clientDTO.getCpf());
            log.info("{}, ", clientFound);
            return clienttRepository.save(clientFound.get());
        }
        throw new ClientNotFoundException("Client {} not found", clientFound.get().getNameClient());
    }

    public List<Client> listClients(){
        return clienttRepository.findAll();
    }

}
