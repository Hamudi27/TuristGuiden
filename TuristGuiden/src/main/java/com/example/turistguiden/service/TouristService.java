package com.example.turistguiden.service;

import com.example.turistguiden.attraction.TouristAttraction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private com.example.turistguiden.repository.TouristRepository touristRepository;

    public TouristService(com.example.turistguiden.repository.TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public String getDescription(String name) {
        return touristRepository.getDescriptionFromName(name);
    }

    public void addAttraction(String name, String description) {
        touristRepository.addAttraction(name, description);
    }

    public void updateAttraction(String name, String description) {
        touristRepository.updateAttraction(name, description);
    }

    public void deleteAttraction(String name) {
        touristRepository.deleteAttraction(name);
    }

    public List<TouristAttraction> getAttractions() {
        return touristRepository.getAttractions();
    }
}