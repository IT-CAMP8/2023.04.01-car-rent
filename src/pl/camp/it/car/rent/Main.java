package pl.camp.it.car.rent;

import org.apache.commons.codec.digest.DigestUtils;

public class Main {
    public static void main(String[] args) {
        String password = "adminBa7gPOCX3l4Kjd6PlgbT8^%XZGRia8LI";
        String hash = DigestUtils.md5Hex(password);

        System.out.println(hash);
    }
}
