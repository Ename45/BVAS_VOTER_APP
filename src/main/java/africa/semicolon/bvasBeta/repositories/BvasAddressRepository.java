package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Address;
import africa.semicolon.bvasBeta.models.Admin;
import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.models.Voter;
import africa.semicolon.bvasBeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasAddressRepository implements AddressRepository{
    UserInformation userInformation = new UserInformation();
    List<Address> addressList = new ArrayList<>();

    public BvasAddressRepository(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

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


//    public void save(Address address) {
//        if (address.getId() != null){
//            update(address);
//        }
//        else {
//            saveNewAddress(address);
//        }
//    }
//
//    private void update(Address address) {
//        Address savedAddress = findById(address.getId());
//        int indexOfSavedAddress = addressList.indexOf(savedAddress);
//        addressList.set(indexOfSavedAddress, address);
//    }
//
//    private void saveNewAddress(Address address) {
//        String id = generateId();
//        address.setId(id);
//        addressList.add(address);
//    }
//
//    private String generateId() {
//        return String.valueOf(idCount += 1);
//    }
//
//
//    @Override
//    public Address findById(String id) {
//        for (Address address: addressList) {
//            if (address.getId().equals(id)){
//                return address;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Address> findAll() {
//        return addressList;
//    }
//
//    @Override
//    public int countAddress() {
//        return addressList.size();
//    }
//
//    @Override
//    public void deleteById(String id) {
//        Address foundAddressId = findById(id);
//        addressList.remove(foundAddressId);
//        idCount--;
//    }
}
