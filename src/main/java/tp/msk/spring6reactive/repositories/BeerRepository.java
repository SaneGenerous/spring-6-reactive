package tp.msk.spring6reactive.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import tp.msk.spring6reactive.domain.Beer;

public interface BeerRepository extends ReactiveCrudRepository<Beer, Integer> {
}
