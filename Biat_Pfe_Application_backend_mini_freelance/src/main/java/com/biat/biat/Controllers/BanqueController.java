package com.biat.biat.Controllers;

import com.biat.biat.Entites.Banque;
import com.biat.biat.Services.ServiceImpl.BanqueService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RestController
@RequestMapping("/banques")
public class BanqueController {
    @Autowired
    private BanqueService banqueService;

    // http://localhost:8089/exam/banques/retrieve-all-banques
    @GetMapping("/retrieve-all-banques")
    public List<Banque> getAllBanques() {
        return banqueService.getAllBanques();
    }

    // http://localhost:8089/exam/banques/retrieve-banques/1
    @GetMapping("/retrieve-banques/{banques-id}")
    public Banque getBanqueById(@PathVariable("banques-id") Long id) {
        return banqueService.getBanqueById(id);
    }


    // http://localhost:8089/exam/banques/add-banques
    @PostMapping("/add-banques")
    public Banque createBanque(@RequestBody Banque banque) {
        return banqueService.saveBanque(banque);
    }


    // http://localhost:8089/exam/banques/modify-banques/2
    @PutMapping("/modify-banques/{banques-id}")
    public Banque updateBanque(@PathVariable("banques-id") Long id, @RequestBody Banque banque) {
        Banque existingBanque = banqueService.getBanqueById(id);
        if (existingBanque != null) {
            // Copy properties from the incoming Banque object to the existing one
            existingBanque.setNom(banque.getNom());
            return banqueService.saveBanque(existingBanque);
        }
        return null;
    }

    // http://localhost:8089/exam/banques/remove-banques/{banques-id}
    @DeleteMapping("/remove-banques/{banques-id}")
    public void deleteBanque(@PathVariable("banques-id") Long id) {
        banqueService.deleteBanque(id);
    }
}
