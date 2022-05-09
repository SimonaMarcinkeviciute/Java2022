package lt.codeacademy.lessons.thirthyFirst.task;
// irasyti i faila, nuskaityti vaila, apversti, ir irasyti i kita faila

import java.io.*;

public class Task1Destytojo {
    private static final String NAME_FILE = "name.txt";
    private static final String REVERSED_NAME_FILE = "reversed_name.txt";

    public static void main(String[] args) {
        Task1Destytojo task = new Task1Destytojo();

        try {
            File file = task.createFile(NAME_FILE);
            String fullName = task.readFile(file);
            if(fullName == null) {
                return;
            }

            String[] splitFullName = fullName.split(" ");
            String reverseName = task.reverseText(splitFullName[0]);
            String reversedSurname = task.reverseText(splitFullName[1]);

            File reversedFile = task.createFile(REVERSED_NAME_FILE);
            task.writeToFile(reversedFile, reverseName + " "+ reversedSurname);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String reverseText(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.reverse();

        return stringBuilder.toString();
    }

    private String readFile(File fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void writeToFile(File fileName, String text) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(text);
            bw.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createFile(String fileName) throws IOException {
        //pries nuskaitant faila reikia pasitikrinti ar toks failas egzistuoja
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
        }

        return file;
    }

}
