import exception.FileOperationException;

public class Main {
    public static void main(String[] args) {

        String filePath = "Hello.txt";
        String text = "Hello World";

        try{
            FileStreamOperations.writeToFile(filePath, text);
            String readData = FileStreamOperations.readFromFile(filePath);

            System.out.println("\nСодержимое файла: ");
            System.out.println(readData);

        } catch (FileOperationException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


