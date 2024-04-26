package hu.veghbernadett.futoverseny.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FutoDto {
    private int azonosito;
    private String nev;
    private int eletkor;
    private boolean nem;

}
