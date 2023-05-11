package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.VoterRegistrationResponse;
import africa.semicolon.bvasBeta.models.Address;
import africa.semicolon.bvasBeta.models.Gender;
import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.models.Voter;
import africa.semicolon.bvasBeta.repositories.BvasVoterRepository;
import africa.semicolon.bvasBeta.repositories.VoterRepository;
import africa.semicolon.bvasBeta.utils.AppUtils.*;

import java.math.BigInteger;
import java.util.UUID;

import static africa.semicolon.bvasBeta.utils.AppUtils.*;

public class BvasVoterService implements VoterService{
    @Override
    public VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) {
        Voter voter = new Voter();
        voter.setAge(voterRegistrationRequest.getAge());
        Gender voterGender = Gender.valueOf(voterRegistrationRequest.getGender());
        voter.setGender(voterGender);
        voter.setName(voterRegistrationRequest.getName());
        Address address = new Address();
        address.setTown(voterRegistrationRequest.getTown());
        address.setState(voterRegistrationRequest.getState());
        address.setLocalGovernmentArea(voterRegistrationRequest.getLga());
        address.setStreet(voterRegistrationRequest.getStreet());
        address.setHouseNumber(voterRegistrationRequest.getHouseNumber());
        voter.setAddress(address);
        UserInformation userInformation = new UserInformation();
        userInformation.setPassword(voterRegistrationRequest.getPassword());
        userInformation.setUsername(voterRegistrationRequest.getUserName());
        voter.setUserInformation(userInformation);

        VoterRepository voterRepository = new BvasVoterRepository();
        voterRepository.save(voter);

        VoterRegistrationResponse voterRegistrationResponse = new VoterRegistrationResponse();
        voterRegistrationResponse.setVotersIdentificationNumber(generateVoterIdentificationNumber());
        voterRegistrationResponse.setMessage("Registration successful");



        return voterRegistrationResponse;
    }

    public static String generateVoterIdentificationNumber(){
        String uuid = generateUUID();
        String validUUID = strippingInvalidCharactersFrom(uuid);

        return buildVoterIdentificationNumberFrom(validUUID);
    }

    private static String buildVoterIdentificationNumberFrom(String validUUID) {
        String result1 = "";
        int count = 1;
        for (int i = 0; i < validUUID.length(); i++) {
            if (count%FIVE == ZERO) {
                result1 += " ";
                i--;
            }
            else result1+= validUUID.charAt(i);
            count++;
        }
        int endIndex = result1.length() - SIXTEEN;
        return result1.substring(ZERO, endIndex);
    }

    private static String strippingInvalidCharactersFrom(String randomUUID) {
        String result = "";
        for (int i = ZERO; i < randomUUID.length(); i++) {
                if (randomUUID.charAt(i) == '-') {
                    continue;
                }
            result += randomUUID.charAt(i);
        }
        return result;
    }

    private static String generateUUID() {
        String uuid = "";
        int codePointforA = BigInteger.valueOf(97).intValue();
        int codePointForZ = BigInteger.valueOf(122).intValue();
        for (int i = codePointforA; i <= codePointForZ; i++) {
            uuid+=i;
        }
        for (int i = ZERO; i <= NINE; i++) {
            uuid+=i;
        }

        uuid = UUID.nameUUIDFromBytes(uuid.getBytes()).toString().toUpperCase();
        System.out.println(uuid);
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(generateVoterIdentificationNumber());
    }
}
