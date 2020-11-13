package com.example.upload.services;

import com.example.upload.helper.EncodeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Service providing Upload file business logic
 */
@Service
public class UpoladFileService {

    Logger logger = LoggerFactory.getLogger(UpoladFileService.class);

    public String GetHashFromFile (MultipartFile file) throws NoSuchAlgorithmException, IOException {
        if (!file.isEmpty()) {
            try {
                String hash = EncodeHelper.GetHashSatisfyGost2012(file);
                logger.debug("hash:" + hash);
                return hash;
            } catch (Exception e) {
                logger.error("error:" + e.getMessage());
                return "Вам не удалось получить hash файла => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить потому что файл пустой.";
        }
    }
}
