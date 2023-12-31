package com.example.validation_service.Web;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.GMonthDayType;
import com.example.validation_service.Entite.Benevole;
import com.example.validation_service.Entite.Demande;
import com.example.validation_service.Entite.Valideur;
import com.example.validation_service.Enum.demande_status;
import com.example.validation_service.Repository.ValideurRepository;
import com.example.validation_service.Service.BenevoleRestClient;
import com.example.validation_service.Service.DemandeRestClient;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@Controller
public class ValidationRestController {
    @Autowired
    private DemandeRestClient demandeRestClient;
    @Autowired
    private BenevoleRestClient benevoleRestClient;
    @Autowired
    private ValideurRepository valideurRepository;
    @GetMapping(path = "/index")
    public String index(){
        return "index";
    }
    @GetMapping(path = "/validation")
    public String validation(Model model,@RequestParam(name="id",defaultValue = "") Long id, @RequestParam(name = "status",defaultValue = "") demande_status status){
        model.addAttribute("id",id);
        Demande demande = demandeRestClient.findDemandeById(id);
        demande.setStatus(status);
        demandeRestClient.createDemande(demande);
        return "redirect:/demandes";
    }
    @GetMapping(path = "/benevoles")
    public String benevoles(Model model, @RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "size",defaultValue = "4") int size) {
        PagedModel<Benevole> pagebenevole = benevoleRestClient.findAll(PageRequest.of(page,size));
        model.addAttribute("listbenevole",pagebenevole.getContent());
        model.addAttribute("pages",new int[(int) Objects.requireNonNull(pagebenevole.getMetadata()).getTotalPages()]);
        model.addAttribute("currentPage",page);
        System.out.println(pagebenevole);
        return "benevoles";
    }
    @GetMapping(path = "/demandes")
    public String demandes(Model model, @RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "size",defaultValue = "4") int size) {
        PagedModel<Demande> pagedemandes = demandeRestClient.findAll(PageRequest.of(page,size));
        model.addAttribute("listdemandes",pagedemandes.getContent());
        model.addAttribute("pages",new int[(int) Objects.requireNonNull(pagedemandes.getMetadata()).getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "demandes";
    }
    @GetMapping(path = "/valideurs")
    public String valideur(Model model, @RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "size",defaultValue = "4") int size) {
        Page<Valideur> valideurPage = valideurRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("listvalideur",valideurPage.getContent());
        model.addAttribute("pages",new int[valideurPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "valideurs";
    }
    @GetMapping(path = "/delete")
    public String delete(Long id) {
        demandeRestClient.deleteById(id);
        return "redirect:/demandes";
    }
    @GetMapping(path = "/benevoledelete")
    public String benevoledelete(Long id) {
        benevoleRestClient.deleteById(id);
        return "redirect:/benevoles";
    }
    @GetMapping(path = "/valideurdelete")
    public String valideurdelete(Long id) {
        valideurRepository.deleteById(id);
        return "redirect:/valideurs";
    }
    @GetMapping(path="/DemandeEdit")
    public String demandesEdit(Model model,Long id) {
        model.addAttribute("id",id);
        return "demandes";
    }
    @PostMapping (path="/saveDemande")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveDemande(Model model ,Demande demande){
            demandeRestClient.createDemande(demande);
            return "index";
    }
    @PostMapping (path="/saveBenevole")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveBenevole(Model model ,Benevole benevole){
        benevoleRestClient.createBenevole(benevole);
        return "index";
    }
    @PostMapping (path="/SaveValideur")
    @Produces(MediaType.APPLICATION_JSON)
    public String SaveValideur(Valideur valideur){
        valideurRepository.save(valideur);
        return "redirect:/valideurs";
    }
}
