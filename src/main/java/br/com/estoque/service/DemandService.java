package br.com.estoque.service;

import br.com.estoque.config.BaseService;
import br.com.estoque.exceptions.ProductNotFoundException;
import br.com.estoque.model.Demand;
import br.com.estoque.repository.DemandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DemandService extends BaseService {

    @Autowired
    private DemandRepository demandRepository;

    public Demand searchDemand(Integer idProduct) {
        Optional<Demand> demand = demandRepository.findById(idProduct);
        return demand.orElse(null);
    }

    public Demand saveDemand(Demand demand){
        return demandRepository.save(demand);
    }

    public void deleteDemand(Integer idProd) {
        demandRepository.deleteById(idProd);
    }

    public Demand updateDemand(Integer id, Demand demand) {
        Optional<Demand> demandFound = demandRepository.findById(id);
        if(demandFound.isPresent()){
            demandFound.get().setClient(demand.getClient());
            demandFound.get().setProducts(demand.getProducts());
            demandFound.get().setShopping(demand.getShopping());
            demandFound.get().setBudget(demand.isBudget());
            log.info("{}, ", demandFound);
            return demandRepository.save(demandFound.get());
        }
        throw new ProductNotFoundException("Product not found");
    }

    public List<Demand> listDemands(){
        return demandRepository.findAll();
    }

}
