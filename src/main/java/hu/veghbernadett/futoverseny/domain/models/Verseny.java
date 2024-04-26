package hu.veghbernadett.futoverseny.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Verseny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int azonosito;
    private String nev;
    private double tavolsag;
    // Egy versenyhez több eredmény is tartozhat
    @OneToMany(mappedBy = "verseny")
    private List<Eredmeny> eredmeny;

}
