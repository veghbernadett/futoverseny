package hu.veghbernadett.futoverseny.domain.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Futo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int azonosito;
    private String nev;
    private int eletkor;
    //  True = 'no' False = 'ferfi'
    private boolean nem;
    // Egy futóhoz több eredmény is tartozhat
    @OneToMany(mappedBy = "futo")
    private List<Eredmeny> eredmeny;


}
