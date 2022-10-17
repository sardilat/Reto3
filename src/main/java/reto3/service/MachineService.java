package reto3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.model.Machine;
import reto3.repository.MachineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll(){
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int id){
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine machine){
        if(machine.getId()==null){
            return machineRepository.save(machine);
        }else{
            Optional<Machine> machineEncontrado = getMachine(machine.getId());
            if(machineEncontrado.isEmpty()){
                return machineRepository.save(machine);
            }else {
                return machine;
            }
        }

    }

    public Machine update(Machine machine){
        if (machine.getId()!=null){
            Optional<Machine> machineEncontrado = getMachine(machine.getId());
            if(!machineEncontrado.isEmpty()){
                if (machine.getName()!= null){
                    machineEncontrado.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    machineEncontrado.get().setBrand(machine.getBrand());
                }
                if (machine.getYear()!=null){
                    machineEncontrado.get().setYear(machine.getYear());
                }
                if (machine.getDescription()!=null) {
                    machineEncontrado.get().setDescription(machine.getDescription());
                }
                if (machine.getCategory()!=null) {
                    machineEncontrado.get().setCategory(machine.getCategory());
                }
                return machineRepository.save(machineEncontrado.get());
            }

        }
        return machine;
    }


    public boolean delete(int id){
        Boolean respuesta = getMachine(id).map(elemento ->{
            machineRepository.delete(elemento);
            return  true;
        }).orElse(false);

        return respuesta;
    }
}
