package com.biat.biat.Controllers;

import com.biat.biat.Entites.Cheque;
import com.biat.biat.Services.ServiceImpl.ChequeService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RestController
@RequestMapping("/cheques")
public class ChequeController {
    @Autowired
    private ChequeService chequeService;

    // http://localhost:8089/exam/cheques/retrieve-all-cheques
    @GetMapping("/retrieve-all-cheques")
    public List<Cheque> getAllCheques() {
        return chequeService.getAllCheques();
    }

    // http://localhost:8089/exam/cheques/retrieve-cheques/2024000001
    @GetMapping("/retrieve-cheques/{numero}")
    public Cheque getCheque(@PathVariable("numero") String numero) {
        return chequeService.getCheque(numero);
    }


    // http://localhost:8089/exam/cheques/add-cheques
    @PostMapping("/add-cheques")
    public Cheque createCheque(@RequestBody Cheque cheque) {
        cheque.setDateCreation(new Date());
        return chequeService.createCheque(cheque);
    }

    // http://localhost:8089/exam/cheques/modify-cheques/2024000002
    @PutMapping("/modify-cheques/{numero}")
    public Cheque updateCheque(@PathVariable("numero") String numero, @RequestBody Cheque cheque) {
        return chequeService.updateCheque(numero,cheque);
    }

    // http://localhost:8089/exam/cheques/remove-cheques/2024000001
    @DeleteMapping("/remove-cheques/{numero}")
    public void deleteCheque(@PathVariable("numero") String numero) {
        chequeService.deleteCheque(numero);
    }

    // http://localhost:8089/exam/cheques/non-emis
    @GetMapping("/non-emis")
    public List<Cheque> getNonEmisCheques() {
        return chequeService.getNonEmisCheques();
    }

    // http://localhost:8089/exam/cheques/emis
    @GetMapping("/emis")
    public List<Cheque> getEmisCheques() {
        return chequeService.getEmisCheques();
    }

    // http://localhost:8089/exam/cheques/search
    @GetMapping("/search")
    public List<Cheque> searchCheques(
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) Date endDate,
            @RequestParam(required = false) String numero,
            @RequestParam(required = false) String beneficiaire,
            @RequestParam(required = false) String motif) {

        if (numero != null) {
            return chequeService.findChequesByNumero(numero);
        } else if (beneficiaire != null) {
            return chequeService.findChequesByBeneficiaire(beneficiaire);
        } else if (motif != null) {
            return chequeService.findChequesByMotif(motif);
        } else if (startDate != null && endDate != null) {
            return chequeService.findChequesByDateCreationBetween(startDate, endDate);
        }
        return chequeService.getAllCheques();
    }
}
