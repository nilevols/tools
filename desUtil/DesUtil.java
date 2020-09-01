import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * DES加解密工具类
 */
public class DesUtil {

    /**
     * 通用加密key
     */
    private static final String GENERAL_KEY = "1scp2gy3zn4";

    /**
     * 加密算法 - DES
     */
    private static final String ALGORITHM = "DES";

    public static void main(String[] args) throws Exception {
        System.out.println(encode("123456", GENERAL_KEY));
        System.out.println(decode("ibQFkXrK6jk=", GENERAL_KEY));
    }

    /**
     * 加密
     *
     * @param data 需要加密的数据
     * @param key  密码
     * @return 加密后的字符串
     * @throws Exception 异常
     */
    public static String encode(String data, String key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
        SecretKey sk = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(dks);
        SecureRandom sr = new SecureRandom();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, sk, sr);
        return new BASE64Encoder().encode(cipher.doFinal(data.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * 解密
     *
     * @param enc DES加密后的密文
     * @param key 密码
     * @return DES解密后的字符串
     * @throws Exception 异常
     */
    public static String decode(String enc, String key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
        SecretKey sk = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(dks);
        SecureRandom sr = new SecureRandom();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, sk, sr);
        return new String(cipher.doFinal(new BASE64Decoder().decodeBuffer(enc)), StandardCharsets.UTF_8);
    }
}
