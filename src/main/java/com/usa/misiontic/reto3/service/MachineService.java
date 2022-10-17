package com.usa.misiontic.reto3.service;


import com.usa.misiontic.reto3.entities.Machine;
import com.usa.misiontic.reto3.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Machine save(Machine m){
        if(m.getId()==null){
            return machineRepository.save(m);
        }else{
            Optional<Machine> e = machineRepository.getMachine(m.getId());
            if(e.isPresent()){
                return m;
            }else{
                return machineRepository.save(m);
            }
        }
    }
    public Machine update(Machine m){
        if(m.getId()!=null){
            Optional<Machine> q = machineRepository.getMachine(m.getId());
            if(q.isPresent()){
                if(m.getName()!=null){
                    q.get().setName(m.getName());
                }
                if(m.getDescription()!=null){
                    q.get().setDescription(m.getDescription());
                }
                if(m.getBrand()!=null){
                    q.get().setBrand(m.getBrand());
                }
                if(m.getYear()!=null){
                    q.get().setYear(m.getYear());
                }
                if(m.getCategory()!=null){
                    q.get().setCategory(m.getCategory());
                }
                machineRepository.save(q.get());
                return q.get();
            }else{
                return m;
            }
        }else{
            return m;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Machine>m= machineRepository.getMachine(id);
        if(m.isPresent()){
            machineRepository.delete(m.get());
            flag=true;
        }
        return flag;

    }


}
