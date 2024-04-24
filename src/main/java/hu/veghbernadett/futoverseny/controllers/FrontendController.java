package hu.veghbernadett.futoverseny.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/versenyek")
    public String listRaces() {
        return "verseny_lista";
    }

    @GetMapping("/versenyek/uj")
    public String newRace() {
        return "uj_verseny";
    }

    @GetMapping("/versenyek/{versenyAzonosito}")
    public String raceDetails() {
        return "verseny_reszletek";
    }
}
