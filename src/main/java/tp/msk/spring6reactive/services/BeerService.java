package tp.msk.spring6reactive.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tp.msk.spring6reactive.model.BeerDTO;

public interface BeerService {
    Flux<BeerDTO> listBeers();
    Mono<BeerDTO> getBeerById(Integer beerId);
    Mono<BeerDTO> saveNewBeer(BeerDTO beerDTO);
    Mono<BeerDTO> updateBeer(Integer beerId, BeerDTO beerDTO);
    Mono<BeerDTO> patchBeer(Integer beerId, BeerDTO beerDTO);
    Mono<Void> deleteBeerById(Integer beerId);
}
