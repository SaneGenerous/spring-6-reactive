package tp.msk.spring6reactive.mappers;


import org.mapstruct.Mapper;
import tp.msk.spring6reactive.domain.Beer;
import tp.msk.spring6reactive.model.BeerDTO;

@Mapper
public interface BeerMapper {
    Beer beerDTOToBeer(BeerDTO beerDTO);
    BeerDTO beerToBeerDTO(Beer beer);
}
