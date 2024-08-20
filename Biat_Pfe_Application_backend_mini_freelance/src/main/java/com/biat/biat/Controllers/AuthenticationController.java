package com.biat.biat.Controllers;

import com.biat.biat.Entites.*;
import com.biat.biat.Services.IServices.IAuthenticationServices;
import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

import java.util.Date;
import java.util.HashMap;


@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  public static String uploadDirectory = System.getProperty("user.dir") + "/uploadUser";

  private final IAuthenticationServices authenticationServices;

  @PostMapping("/registerAgent")
  public ResponseEntity<Agent> registerAgent(@RequestParam("nom") String nom,
                                             @RequestParam("prenom") String prenom,
                                             @RequestParam("email") String email,
                                             @RequestParam("password") String password,
                                             @RequestParam("numeroTelephone") String numeroTelephone,
                                             @RequestParam("cin") Long cin,
                                             @RequestParam("dateNaissance") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateNaissance
                                           ) throws IOException {
    Agent agent = new Agent();
    agent.setNom(nom);
    agent.setPrenom(prenom);
    agent.setEmail(email);
    agent.setPassword(password);
    agent.setCin(cin);
    agent.setNumeroTelephone(numeroTelephone);
    agent.setDateNaissance(dateNaissance);
    agent.setRole(Role.AGENT);
    Agent savedAgent = authenticationServices.RegisterAgent(agent);
    return ResponseEntity.ok(savedAgent);
  }



  @PostMapping("/login")
  public AuthenticationResponse login(@RequestBody User user) {
      return authenticationServices.login(user.getEmail(), user.getPassword());
  }

  @PostMapping("/refreshToken")
  public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshToken) {
      return authenticationServices.refreshToken(refreshToken);
  }

  @PostMapping("/forgetpassword")
  public HashMap<String,String> forgetPassword(@RequestBody String email){
        return authenticationServices.forgetPassword(email);
  }

    @PostMapping("/resetPassword/{passwordResetToken}")
    public HashMap<String,String> resetPassword(@PathVariable String passwordResetToken, String newPassword){
        return authenticationServices.resetPassword(passwordResetToken, newPassword);
    }

    @PostMapping("/registerClient")
    public ResponseEntity<Caissier> registerCaissier(@RequestParam("nom") String nom,
                                               @RequestParam("prenom") String prenom,
                                               @RequestParam("email") String email,
                                               @RequestParam("password") String password,
                                               @RequestParam("numeroTelephone") String numeroTelephone, @RequestParam("cin") Long cin,
                                               @RequestParam("dateNaissance") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateNaissance,
                                                 @RequestParam("adresse") String adresse
                                               ) throws IOException {
      Caissier client = new Caissier();
      client.setNom(nom);
      client.setPrenom(prenom);
      client.setEmail(email);
      client.setPassword(password);

      client.setNumeroTelephone(numeroTelephone);

      client.setRole(Role.CAISSIER);

      client.setAdresse(adresse);

      Caissier savedClient = authenticationServices.addClient(client);
      return ResponseEntity.ok(savedClient);
    }
}
