package hu.veghbernadett.futoverseny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Eredmeny {

    @Id
    @GeneratedValue
    private int azonosito;
    private int idoeredmeny;
    @ManyToOne
    @JoinColumn(name="verseny_azonosito")
    private Verseny verseny;
    @ManyToOne
    @JoinColumn(name="futo_azonosito")
    private Futo futo;

}
