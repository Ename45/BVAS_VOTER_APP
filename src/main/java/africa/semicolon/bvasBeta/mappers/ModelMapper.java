package africa.semicolon.bvasBeta.mappers;

import africa.semicolon.bvasBeta.dtos.requests.CreateElectionRequest;
import africa.semicolon.bvasBeta.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.bvasBeta.models.*;

import java.time.LocalDate;
import java.util.List;

public class ModelMapper {
    public static Voter map(VoterRegistrationRequest voterRegistrationRequest){
        Address address = buildVoterAddress(voterRegistrationRequest);
        UserInformation userInformation = buildVoterOnlineUserInformation(voterRegistrationRequest);

        Voter voter = buildVoter(voterRegistrationRequest, address, userInformation);

        return voter;
    }

    public static Election map(CreateElectionRequest createElectionRequest){
        Election election = new Election();
        Category electionCategory = Category.valueOf(createElectionRequest.getElectionCategory().toUpperCase());
        election.setCategory(electionCategory);
        LocalDate electionDate = LocalDate.parse(createElectionRequest.getElectionDate());
        election.setDate(electionDate);
        List<Party> parties = getPoliticalParties(createElectionRequest.getParties());
//        election.setParties();
        return election;
    }

    private static List<Party> getPoliticalParties(List<String> parties) {
        return null;
    }


    private static Voter buildVoter(VoterRegistrationRequest voterRegistrationRequest, Address address,
                                UserInformation userInformation) {
//        Voter voter = new Voter();
//        voter.setName(voterRegistrationRequest.getName());
//        voter.setAge(voterRegistrationRequest.getAge());
//        Gender voterGender = Gender.valueOf(voterRegistrationRequest.getGender().toUpperCase());
//        voter.setGender(voterGender);
//        voter.setAddress(address);
//        voter.setUserInformation(userInformation);
//        return voter;
        Gender voterGender = Gender.valueOf(voterRegistrationRequest.getGender().toUpperCase());
        return Voter.builder()
                .address(address)
                .gender(voterGender)
                .userInformation(userInformation)
                .name(voterRegistrationRequest.getName())
                .age(voterRegistrationRequest.getAge())
                .build();
    }

    private static UserInformation buildVoterOnlineUserInformation(VoterRegistrationRequest voterRegistrationRequest) {
        UserInformation userInformation = new UserInformation();
        userInformation.setPassword(voterRegistrationRequest.getPassword());
        userInformation.setUsername(voterRegistrationRequest.getUserName());
        return userInformation;
    }

    private static Address buildVoterAddress(VoterRegistrationRequest voterRegistrationRequest) {
        Address address = new Address();
        address.setTown(voterRegistrationRequest.getTown());
        address.setState(voterRegistrationRequest.getState());
        address.setLocalGovernmentArea(voterRegistrationRequest.getLga());
        address.setStreet(voterRegistrationRequest.getStreet());
        address.setHouseNumber(voterRegistrationRequest.getHouseNumber());
        return address;
    }
}
