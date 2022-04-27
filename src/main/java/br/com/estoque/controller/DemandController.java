package br.com.estoque.controller;

import br.com.estoque.model.DTO.ProductDTO;
import br.com.estoque.model.Demand;
import br.com.estoque.model.Product;
import br.com.estoque.service.DemandService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/v1/demand")
public class DemandController {

    @Autowired
    private DemandService demandService;

    @PostMapping
    public ResponseEntity<Demand> saveDemand (@RequestBody Demand demand){
        demandService.saveDemand(demand);
        return ResponseEntity.status(HttpStatus.OK).body(demand);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Demand> findDemand (@PathVariable Integer id){
        Demand demand = demandService.searchDemand(id);
        return ResponseEntity.ok().body(demand);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Demand> alterDemand (@PathVariable Integer id, @RequestBody Demand demand){
        Demand demandAlt = demandService.updateDemand(id, demand);
        return ResponseEntity.ok().body(demandAlt);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Demand> deletaDemand(@PathVariable Integer id){
        demandService.deleteDemand(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Demand> listarDemands(){
        List<Demand> demands = demandService.listDemands();
        return demands;
    }

}


