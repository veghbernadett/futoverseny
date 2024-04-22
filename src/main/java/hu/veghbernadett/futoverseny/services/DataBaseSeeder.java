package hu.veghbernadett.futoverseny.services;

import hu.veghbernadett.futoverseny.models.Eredmeny;
import hu.veghbernadett.futoverseny.models.Futo;
import hu.veghbernadett.futoverseny.models.Verseny;
import hu.veghbernadett.futoverseny.repositories.EredmenyRepository;
import hu.veghbernadett.futoverseny.repositories.FutoRepository;
import hu.veghbernadett.futoverseny.repositories.VersenyRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseSeeder {

    @Autowired
    private FutoRepository futoRepository;

    @Autowired
    private VersenyRepository versenyRepository;

    @Autowired
    private EredmenyRepository eredmenyRepository;

    @PostConstruct
    public void seeding(){

        Futo futo1 = new Futo();
        futo1.setNev("Kiss Elemer");
        futo1.setNem(false);
        futo1.setEletkor(33);
        futoRepository.save(futo1);

        Verseny verseny1 = new Verseny();
        verseny1.setNev("Balaton Maraton");
        verseny1.setTavolsag(50);
        versenyRepository.save(verseny1);

        Eredmeny eredmeny1 = new Eredmeny();
        eredmeny1.setIdoeredmeny(60);
        eredmeny1.setFuto(futo1);
        eredmeny1.setVerseny(verseny1);
        eredmenyRepository.save(eredmeny1);

        System.out.println("Test test");
    }

}
