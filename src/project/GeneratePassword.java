package project;

import java.security.SecureRandom;
import java.util.Random;

public class GeneratePassword {
	private static final Random RANDOM = new SecureRandom();
	public static String newPassword;

    GeneratePassword(){
    	newPassword = generateRandomPassword();
    }
    
    GeneratePassword(String use){}

    public static String generateRandomPassword() {
        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ0123456789!@#$%^&*()_-+";

        String pw = "";
        for (int i = 0; i < 6; i++) {
            int index = (int) (RANDOM.nextDouble() * letters.length());
            pw += letters.substring(index, index + 1);
        }
        return pw;
    }

}
