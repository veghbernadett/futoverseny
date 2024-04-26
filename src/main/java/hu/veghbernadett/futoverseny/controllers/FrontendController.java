package hu.veghbernadett.futoverseny.controllers;
import hu.veghbernadett.futoverseny.domain.models.Eredmeny;
import hu.veghbernadett.futoverseny.domain.models.Verseny;
import hu.veghbernadett.futoverseny.repositories.VersenyRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FrontendController {

    @Autowired
    private VersenyRepository versenyRepository;

    @GetMapping("/versenyek")
    public String listRaces(Model model) {
        List<Verseny> versenyek = versenyRepository.findAll();
        model.addAttribute("versenyek", versenyek);
        return "verseny_lista";
    }

    @GetMapping("/versenyek/uj")
    public String newRace(Model model) {
        model.addAttribute("verseny", new Verseny());
        return "uj_verseny";
    }

    @PostMapping("/versenyek")
    public String createRace(@ModelAttribute Verseny verseny) {
        versenyRepository.save(verseny);
        return "redirect:/versenyek";
    }

    @GetMapping("/versenyek/{versenyAzonosito}")
    public String raceDetails(@PathVariable int versenyAzonosito, Model model) {
        Verseny verseny = versenyRepository.findById(versenyAzonosito).orElse(null);
        if (verseny != null) {
            List<Eredmeny> eredmenyek = verseny.getEredmeny();
            model.addAttribute("verseny", verseny);
            model.addAttribute("eredmenyek", eredmenyek);
        }
        return "verseny_reszletek";
    }
}
