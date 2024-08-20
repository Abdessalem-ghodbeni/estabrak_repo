package com.biat.biat.Services.ServiceImpl;

import com.biat.biat.Entites.Banque;
import com.biat.biat.Repository.BanqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class BanqueService {
    @Autowired
    private BanqueRepository banqueRepository;

    public List<Banque> getAllBanques() {
        return banqueRepository.findAll();
    }

    public Banque getBanqueById(Long id) {
        return banqueRepository.findById(id).orElse(null);
    }

    public Banque saveBanque(Banque banque) {
        return banqueRepository.save(banque);
    }

    public void deleteBanque(Long id) {
        banqueRepository.deleteById(id);
    }
}
