package africa.semicolon.bvasBeta.utils;

import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private static int currentId;
    private final static Map<String, String> userInformationJoinTable = new HashMap<>();


    public static String generateId(){
        currentId+=1;
        int generatedId = currentId;
        return String.valueOf(generatedId);
    }

    public static void linkUserToUserInformation(String userId, String userInformationId){
        userInformationJoinTable.put(userId, userInformationId);
    }

    public static String getUserInformationId(String userId){
        String userInformationId = userInformationJoinTable.get(userId);
        return userInformationId;
    }
}
