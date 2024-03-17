package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.example.Utils.*;

public class HttpStatusImageDownloader {
    Logger logger = LogManager.getLogger(HttpStatusImageDownloader.class);
    public void downloadStatusImage(int code) throws IOException {
        String url =new HttpStatusChecker().getStatusImage(code);

        try(InputStream inputStream = new URL(url).openStream()){
            String filePath = new StringBuilder(PATH_TO_SAVE_FILE)
                    .append(code)
                    .append(EXTENSION)
                    .toString();
            if (!new File(filePath).exists()){
                Files.copy(inputStream, Paths.get(filePath));
                logger.info(LOG_FILE_WAS_CREATED, code);
            }
            else {
                Files.copy(inputStream, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
                logger.info(LOG_FILE_WAS_REPLACED, code);
            }
        }

    }
}
