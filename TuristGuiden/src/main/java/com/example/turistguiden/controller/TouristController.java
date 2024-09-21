
package com.example.turistguiden.controller;

import com.example.turistguiden.attraction.TouristAttraction;
import com.example.turistguiden.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {

    private TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public <TouristAttraction> ResponseEntity<List<TouristAttraction>> getAttractions() {
        List<TouristAttraction> getAttractions = (List<TouristAttraction>) touristService.getAttractions();
        return new ResponseEntity<>(getAttractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getDescriptionFromName(@PathVariable String name) {
        return new ResponseEntity<String>(touristService.getDescription(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addAttraction(@RequestParam String name, @RequestParam String description){
        touristService.addAttraction(name,description);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<Void> updateAttraction(@RequestParam String name, @RequestParam String description){
        touristService.updateAttraction(name, description);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteAttraction(@RequestParam String name){
        touristService.deleteAttraction(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
