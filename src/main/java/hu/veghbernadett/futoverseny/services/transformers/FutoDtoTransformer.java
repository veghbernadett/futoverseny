package hu.veghbernadett.futoverseny.services.transformers;

import hu.veghbernadett.futoverseny.domain.models.Futo;
import hu.veghbernadett.futoverseny.domain.response.FutoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FutoDtoTransformer {

    public FutoDto transform(Futo futo) {

        FutoDto result = new FutoDto();
        result.setAzonosito(futo.getAzonosito());
        result.setNev(futo.getNev());
        result.setEletkor(futo.getEletkor());
        result.setNem(futo.isNem());

        return result;

    }

    public List<FutoDto> transform(List<Futo> futok) {

        List<FutoDto> results = new ArrayList<>();

        for (Futo futo : futok) {

            results.add(transform(futo));
        }

        return results;

    }

}
