import org.example.HttpStatusChecker;
import org.example.HttpStatusImageDownloader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class HttpStatusImageDownloaderTest {

    @Test
    void downloadStatusImageSuccessTest() throws IOException {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        downloader.downloadStatusImage(503);
        File image = new File("download/503.jpg");
        assertTrue(image.exists());
    }

    @Test
    void downloadStatusImageFailTest(){
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        assertThrows(FileNotFoundException.class, () -> downloader.downloadStatusImage(3));
    }
}
