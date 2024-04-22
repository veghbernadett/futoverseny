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

        Futo futo2 = new Futo();
        futo2.setNev("Nagy Janos");
        futo2.setNem(false);
        futo2.setEletkor(43);
        futoRepository.save(futo2);

        Futo futo3 = new Futo();
        futo3.setNev("Toth Zsuzsa");
        futo3.setNem(true);
        futo3.setEletkor(25);
        futoRepository.save(futo3);

        Futo futo4 = new Futo();
        futo4.setNev("Szabo Timea");
        futo4.setNem(true);
        futo4.setEletkor(51);
        futoRepository.save(futo4);

        Verseny verseny1 = new Verseny();
        verseny1.setNev("Balaton Maraton");
        verseny1.setTavolsag(50);
        versenyRepository.save(verseny1);

        Verseny verseny2 = new Verseny();
        verseny2.setNev("Budapest Maraton");
        verseny2.setTavolsag(30);
        versenyRepository.save(verseny2);

        Eredmeny eredmeny1 = new Eredmeny();
        eredmeny1.setIdoeredmeny(60);
        eredmeny1.setFuto(futo1);
        eredmeny1.setVerseny(verseny1);
        eredmenyRepository.save(eredmeny1);

        Eredmeny eredmeny2 = new Eredmeny();
        eredmeny2.setIdoeredmeny(30);
        eredmeny2.setFuto(futo2);
        eredmeny2.setVerseny(verseny1);
        eredmenyRepository.save(eredmeny2);

        Eredmeny eredmeny3 = new Eredmeny();
        eredmeny3.setIdoeredmeny(35);
        eredmeny3.setFuto(futo3);
        eredmeny3.setVerseny(verseny1);
        eredmenyRepository.save(eredmeny3);

        Eredmeny eredmeny4 = new Eredmeny();
        eredmeny4.setIdoeredmeny(25);
        eredmeny4.setFuto(futo4);
        eredmeny4.setVerseny(verseny1);
        eredmenyRepository.save(eredmeny4);

        Eredmeny eredmeny5 = new Eredmeny();
        eredmeny5.setIdoeredmeny(20);
        eredmeny5.setFuto(futo4);
        eredmeny5.setVerseny(verseny2);
        eredmenyRepository.save(eredmeny5);

        Eredmeny eredmeny6 = new Eredmeny();
        eredmeny6.setIdoeredmeny(31);
        eredmeny6.setFuto(futo3);
        eredmeny6.setVerseny(verseny2);
        eredmenyRepository.save(eredmeny6);

        System.out.println("Test test");
    }

}
