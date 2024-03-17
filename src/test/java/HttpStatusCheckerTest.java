import org.example.HttpStatusChecker;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HttpStatusCheckerTest {

    @Test
    void getStatusImageSuccessTest() throws IOException {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        String statusImage = statusChecker.getStatusImage(201);
        assertEquals("https://http.cat/201.jpg", statusImage);
    }
    @Test
    void getStatusImageFailTest(){
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        assertThrows(FileNotFoundException.class, ()->statusChecker.getStatusImage(1));
    }
}
