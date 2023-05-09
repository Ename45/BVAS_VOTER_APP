package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasAddressRepositoryTest {

    Address savedAddress;
    private final AddressRepository addressRepository = new BvasAddressRepository();

    @BeforeEach
    public void setUp(){
        Address address = new Address();
        savedAddress = addressRepository.save(address);
    }

    @Test
    public void testSaveAddress(){
        assertNotNull(savedAddress);
        assertNotNull(savedAddress.getAddressId());
    }

    @Test
    public void testFindById(){
        Address foundAddress = addressRepository.findById(savedAddress.getAddressId());
        assertNotNull(foundAddress);
    }

    @Test
    public void testFindAllAddresss(){
        addressRepository.save(new Address());
        addressRepository.save(new Address());

        List<Address> addresss = addressRepository.findAll();
        assertEquals(3, addresss.size());
        assertNotNull(addresss.get(0));
        assertNotNull(addresss.get(1));
        assertNotNull(addresss.get(2));
    }

    @Test
    public void testDeleteElectionById(){
        Address savedSecondAddress = addressRepository.save(new Address());
        List<Address> addressList = addressRepository.findAll();
        assertEquals(2, addressList.size());
        addressRepository.deleteById(savedSecondAddress.getAddressId());
        addressList = addressRepository.findAll();
        assertEquals(1, addressList.size());
    }
}