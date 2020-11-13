package com.example.upload.helper;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

/**
 * Helper class for encoding
 */
public class EncodeHelper {

    /**
     * @param file file to calculate hash code
     * @return hash that satisfy gost 2012 requirement
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String GetHashSatisfyGost2012 (MultipartFile file) throws NoSuchAlgorithmException, IOException {

        byte[] fileContent = file.getBytes();
        //алгоритм по госту, в базовом пакете его нету, необходимо подключать сторонние библиотеки
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        byte[] hashedString = messageDigest.digest(fileContent);

        return new String(Hex.encodeHex(hashedString));
    }
}
