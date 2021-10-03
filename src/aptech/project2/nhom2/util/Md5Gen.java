package aptech.project2.nhom2.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5Gen {
    public static String getMD5(String pw) {
        String hashedPW = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(pw.getBytes());
            BigInteger n = new BigInteger(1, messageDigest);
            hashedPW = n.toString(16);
            while (hashedPW.length() < 32) {
                hashedPW = "0" + hashedPW;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hashedPW;
    }
}
