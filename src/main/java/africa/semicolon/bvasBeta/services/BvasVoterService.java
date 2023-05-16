package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.DeleteVoterResponse;
import africa.semicolon.bvasBeta.dtos.responses.VoterRegistrationResponse;
import africa.semicolon.bvasBeta.exceptions.RegistrationException;
import africa.semicolon.bvasBeta.mappers.ModelMapper;
import africa.semicolon.bvasBeta.models.Voter;
import africa.semicolon.bvasBeta.repositories.BvasVoterRepository;
import africa.semicolon.bvasBeta.repositories.VoterRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import static africa.semicolon.bvasBeta.utils.AppUtils.*;

public class BvasVoterService implements VoterService{
    private final VoterRepository voterRepository = new BvasVoterRepository();

    @Override
    public VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) throws RegistrationException {
        Voter voter = ModelMapper.map(voterRegistrationRequest);
        String vin = generateVoterIdentificationNumber();
        voter.setVoterIdentificationNumber(vin);

        Voter savedVoter = voterRepository.save(voter);

        if (savedVoter == null) throw new RegistrationException("Voter registration failed");

        VoterRegistrationResponse voterRegistrationResponse = new VoterRegistrationResponse();
        voterRegistrationResponse.setVotersIdentificationNumber(savedVoter.getVoterIdentificationNumber());
        voterRegistrationResponse.setMessage("Registration successful");

        return voterRegistrationResponse;
    }

    @Override
    public Voter getUserById(String id) {
        return voterRepository.findById(id);
    }

    @Override
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @Override
    public DeleteVoterResponse deleteById(String id) {
        voterRepository.deleteById(id);
        return DeleteVoterResponse.builder().message("Voter deleted").build();
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
//        System.out.println(uuid);
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(generateVoterIdentificationNumber());
    }
}
