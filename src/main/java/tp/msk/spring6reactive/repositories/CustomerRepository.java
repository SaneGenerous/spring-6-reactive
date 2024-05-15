package tp.msk.spring6reactive.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import tp.msk.spring6reactive.domain.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
