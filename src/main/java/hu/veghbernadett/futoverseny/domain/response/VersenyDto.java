package hu.veghbernadett.futoverseny.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VersenyDto {

    private int azonosito;
    private String nev;
    private double tavolsag;
    private List<FutoDto> futok;

}
