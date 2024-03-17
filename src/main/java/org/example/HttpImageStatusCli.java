package org.example;

import java.io.IOException;
import java.util.Scanner;

import static org.example.Utils.*;

public class HttpImageStatusCli {
    void askStatus() {
        try (
                Scanner input = new Scanner(System.in)) {
            System.out.println(CONSOLE_ENTER_CODE);
            while (!input.hasNextInt()){
                System.out.println(String.format(CONSOLE_INVALID_NUMER));
                input.next();
            }
            int inputCode = input.nextInt();
            try {
                new HttpStatusImageDownloader().downloadStatusImage(inputCode);
                System.out.println(String.format(CONSOLE_IMAGE_DOWNLOADED, inputCode));
            } catch (IOException e) {
                System.out.println(String.format(CONSOLE_IMAGE_NOT_FOUND, inputCode));
            }

        }

    }
}
