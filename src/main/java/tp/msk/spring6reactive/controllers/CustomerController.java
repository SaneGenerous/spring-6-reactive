package tp.msk.spring6reactive.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tp.msk.spring6reactive.model.CustomerDTO;
import tp.msk.spring6reactive.services.CustomerService;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    public static final String CUSTOMER_PATH = "/api/v2/customer";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";
    public final CustomerService customerService;

    @DeleteMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> deleteById(@PathVariable("customerId") Integer customerId) {
        return customerService.deleteCustomerById(customerId).map(response ->
                ResponseEntity.noContent().build());
    }

    @GetMapping(CUSTOMER_PATH_ID)
    Mono<CustomerDTO> getCustomerById(@PathVariable("customerId") Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping(CUSTOMER_PATH)
    Flux<CustomerDTO> listCustomers() {
        return customerService.listCustomers();
    }

    @PatchMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> patchExistingCustomer(@PathVariable Integer customerId,
                                                     @Validated @RequestBody CustomerDTO customerDTO) {
        return customerService.patchCustomer(customerId, customerDTO)
                .map(patchedCustomer -> ResponseEntity.ok().build());
    }

    @PutMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> updateExistingCustomer(@PathVariable Integer customerId,
                                                      @Validated @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(customerId, customerDTO)
                .map(updatedCustomer -> ResponseEntity.ok().build());
    }

    @PostMapping(CUSTOMER_PATH)
    ResponseEntity<Void> createNewCustomer(@RequestBody @Validated CustomerDTO customerDTO) {
        AtomicInteger atomicInteger = new AtomicInteger();
        customerService.saveNewCustomer(customerDTO).subscribe(savedDto ->{
           atomicInteger.set(savedDto.getId());
        });
        return ResponseEntity.created(UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080" + CUSTOMER_PATH + "/" + atomicInteger.get())
                .build().toUri())
                .build();
    }

}
