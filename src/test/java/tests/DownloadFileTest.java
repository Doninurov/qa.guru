package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Disabled
public class DownloadFileTest {

    @Test
    void downloadFile () throws Exception {
        open("https://github.com/qa-guru/niffler/blob/master/README.md");
        File download = $("a[href*='https://github.com/qa-guru/niffler/raw/master/README.md']").download();
        try (InputStream is = new FileInputStream(download)){
            byte[] bytes = is.readAllBytes();
            String fileAsString = new String( bytes, StandardCharsets.UTF_8);
            Assertions.assertTrue(fileAsString.contains("Технологии, использованные в Niffler"));
        }
    }
    @Test
    void uploadTest() throws Exception {
        open("https://tus.io/demo.html");
        $("input[type='file']").uploadFromClasspath("png-transparent-cat-animal-lovely-cat.png");
        $("#js-upload-container").shouldHave(Condition.text("The upload is complete!"));
    }


}
