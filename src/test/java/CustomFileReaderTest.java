import exceptions.CustomNumberException;
import org.junit.Before;
import org.junit.Test;
import utils.CustomFileReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CustomFileReaderTest {

    private static final String TEST_FILE= "C:/Users/natal/IdeaProjects/PreTaskNumbers/src/main/resources/test.txt";

    @Before
    public void clean() throws Exception {
        File f = new File(TEST_FILE);
        if (f.exists()) {
            f.delete();
        }
        f.createNewFile();
    }

    @Test
    public void testReadFile_happyPath() throws Exception {
        // given
        CustomFileReader reader = new CustomFileReader();
        String testContent = "0  adfgfadra_I    5.5";
        fillInFile(testContent);

        // when
        List<String> result = reader.readFile(TEST_FILE);

        // then
        assertThat(result).contains("0", "adfgfadra_I", "5.5");
    }

    @Test
    public void testReadFile_whenFilePathIsNull_thenThrowCustomNumberException() {
        // given
        CustomFileReader reader = new CustomFileReader();
        String filePath = null;

        // when
        Throwable thrown = catchThrowable(() -> reader.readFile(filePath));
        //then
        assertThat(thrown).isInstanceOf(CustomNumberException.class);
    }

    @Test
    public void testReadFile_whenFileNotExist_thenThrowCustomNumberException() {
        // given
        CustomFileReader reader = new CustomFileReader();
        String filePath = "notExisting.txt";

        // when
        Throwable thrown = catchThrowable(() -> reader.readFile(filePath));
        //then
        assertThat(thrown).isInstanceOf(CustomNumberException.class);
    }

    private void fillInFile(String content) throws Exception {
        File file = new File(TEST_FILE);

        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            br.write(content);
        }
    }

}
