import exception.FileOperationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileStreamOperations {

    public static void writeToFile(String filePath, String text) throws FileOperationException {
        Path path = Paths.get(filePath);

        try {
            Files.writeString(path, text, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Данные успешно записаны в файл: " + filePath);
        } catch (IOException e) {
            throw new FileOperationException("Ошибка при записи в файл: " + filePath, e);
        }
    }

    public static String readFromFile(String filePath) throws FileOperationException {
        Path path = Paths.get(filePath);
        try {
            String content = Files.readString(path);
            System.out.println("Данные успешно прочитаны из файла: " + filePath);
            return content;
        } catch (IOException e) {
            throw new FileOperationException("Ошибка при чтении файла: " + filePath, e);
        }
    }
}


