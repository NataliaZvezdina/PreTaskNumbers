package utils;

import exceptions.CustomNumberException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomFileReader {

    private static final Logger logger = Logger.getLogger(CustomFileReader.class);
    private static final String DELIMITER = "\\s+";

    public List<String> readFile(String pathFile) throws CustomNumberException {
        if (pathFile == null) {
            logger.error("No path file input");
            throw new CustomNumberException("No path file input");
        }

        File file = new File(pathFile);

        if (!file.exists()) {
            logger.error("File by pathname: " + pathFile + " doesn't exist");
            throw new CustomNumberException("File by pathname: " + pathFile + " doesn't exist");
        }

        File fileName = file.getAbsoluteFile();

        List<String> allStringNumbers = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;

            logger.info("Start reading file: " + fileName);
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] stringNumbers = line.split(DELIMITER);
                    allStringNumbers.addAll(Arrays.asList(stringNumbers));
                }
            }
        } catch (IOException e) {
            logger.error("Error while reading file " + fileName);
            throw new CustomNumberException("Error while working with stream", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error("Error while closing stream");
                    throw new CustomNumberException("Error while closing stream", e);
                }
            }
        }

        logger.info("Finish reading file: " + fileName);
        return allStringNumbers;
    }
}
