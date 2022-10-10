package jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;

public class TestJasypt {
    public static void main(String[] args) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword("Demo_Pwd!2020");
        standardPBEStringEncryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        standardPBEStringEncryptor.setIvGenerator(new RandomIvGenerator());
        var result = standardPBEStringEncryptor.encrypt("test");
        System.out.println(result);
        System.out.println(standardPBEStringEncryptor.decrypt("/XNKe7j7//VEeXMhGd/TsHhzuIkm1qXnAV/H7BNI5Fwq7aOuAuPNCvJImDGv/kpJ"));
    }
}
