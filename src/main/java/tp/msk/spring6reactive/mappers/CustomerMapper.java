package tp.msk.spring6reactive.mappers;

import org.mapstruct.Mapper;
import tp.msk.spring6reactive.domain.Customer;
import tp.msk.spring6reactive.model.CustomerDTO;

@Mapper
public interface CustomerMapper {
    Customer cutomerDTOToCustomer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDTO(Customer customer);
}
