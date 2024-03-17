package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.example.Utils.*;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws IOException {
        String url = new StringBuilder(BASE_URL)
                .append(code)
                .append(EXTENSION)
                .toString();
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        int responseCode = connection.getResponseCode();
        if (responseCode == 404){
            throw new FileNotFoundException(String.format(CONSOLE_FILE_NOT_FOUND_EXCEPTION, code));
        }
        else {
            return url;
        }
    }
}
