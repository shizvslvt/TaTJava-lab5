package com.example.tatjavalab5.serivce;

import com.example.tatjavalab5.data.Estate;
import com.example.tatjavalab5.repository.EstateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstateService {
    private final EstateRepository estateRepository;

    public List<Estate> getAllEstates() {
        return estateRepository.findAll();
    }

    public List<Estate> getAllEstatesBySellerId(Long sellerId) {
        return estateRepository.findAllBySellerId(sellerId);
    }

    public List<Estate> getAllEstatesByRealtorId(Long realtorId) {
        return estateRepository.findAllByRealtorId(realtorId);
    }

}
