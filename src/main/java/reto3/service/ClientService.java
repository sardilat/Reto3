package reto3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.model.Client;
import reto3.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> clienteEncontrado = getClient(client.getIdClient());
            if(clienteEncontrado.isEmpty()){
                return clientRepository.save(client);
            }else {
                return client;
            }
        }

    }

    public Client update(Client client){
        if (client.getIdClient()!=null){
            Optional<Client> clienteEncontrado = getClient(client.getIdClient());
            if(!clienteEncontrado.isEmpty()){
                if(client.getName()!= null){
                    clienteEncontrado.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    clienteEncontrado.get().setAge(client.getAge());
                }
                if (client.getPassword()!=null){
                    clienteEncontrado.get().setPassword(client.getPassword());
                }
                return clientRepository.save(clienteEncontrado.get());
                }
        }
        return client;
    }


    public boolean delete(int id){
        Boolean respuesta = getClient(id).map(elemento ->{
            clientRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
