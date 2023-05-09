package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Address;
import africa.semicolon.bvasBeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasAddressRepository implements AddressRepository{
    List<Address> addressList = new ArrayList<>();

    @Override
    public Address save(Address address) {
        String id = AppUtils.generateId();
        address.setAddressId(id);
        addressList.add(address);
        return address;
    }

    @Override
    public Address findById(String id) {
        for (Address address:addressList) {
            if (address.getAddressId().equals(id)){
                return address;
            }
        }
        return null;
    }

    @Override
    public List<Address> findAll() {
        return addressList;
    }

    @Override
    public void deleteById(String id) {
        Address foundAddress = findById(id);
        if (foundAddress != null)addressList.remove(foundAddress);
    }
}
