package hu.veghbernadett.futoverseny.services.transformers;

import hu.veghbernadett.futoverseny.domain.models.Verseny;
import hu.veghbernadett.futoverseny.domain.response.VersenyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersenyDtoTransformer {

    @Autowired
    private FutoDtoTransformer futoDtoTransformer;

    public VersenyDto transform(Verseny verseny){

        VersenyDto result = new VersenyDto();
        result.setAzonosito(verseny.getAzonosito());
        result.setNev(verseny.getNev());
        result.setTavolsag(verseny.getTavolsag());
        //result.setFutok(futoDtoTransformer.transform(verseny.));
        return result;
    }

}
