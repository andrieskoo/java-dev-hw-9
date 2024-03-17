package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("HttpStatusChecker => " + new HttpStatusChecker().getStatusImage(200));
        new HttpStatusImageDownloader().downloadStatusImage(201);
        new HttpImageStatusCli().askStatus();
    }
}