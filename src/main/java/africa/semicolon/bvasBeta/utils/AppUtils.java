package africa.semicolon.bvasBeta.utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    public static final int ZERO = 0;
    public static final int NINE = BigInteger.valueOf(9).intValue();
    public static final int ONE = BigInteger.valueOf(1).intValue();
    public static final int SIXTEEN = BigInteger.valueOf(16).intValue();
    public static final int FIVE = BigInteger.valueOf(5).intValue();
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
