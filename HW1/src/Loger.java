
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class Loger {
    private FileWriter fileWriter;
    private BufferedReader fileReader;
    private String filename;

    public Loger(String filename) throws IOException {
        this.filename = filename;
        fileWriter = new FileWriter(filename, true);
    }

    public Loger() throws IOException {
        this("log.txt");
    }

    public void log(String message) {
        try {
            fileWriter.write(LocalDateTime.now() + ":" + message + ";\n");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<String> readAllToList() {

        LinkedList<String> result = new LinkedList<>();
        String line;
        try {
            fileReader = new BufferedReader(new FileReader(filename));
            while ((line = fileReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            System.out.println("FileNotFoundException");
            throw new RuntimeException(e);
        }

        return result;
    }

    public LinkedList<String> readAllToList(int limit) {
        LinkedList<String> all = readAllToList();
        LinkedList<String> result = new LinkedList<>();
        ListIterator<String> iterator = all.listIterator();
        while (limit > 0) {
            result.add(all.pollLast());
            limit--;
        }
        result = listReverse(result);
        return result;

    }
    private LinkedList<String> listReverse(LinkedList<String> list) {
        LinkedList<String> result = new LinkedList<>(); ;

        while (list.size() > 0) {
            result.add(list.pollLast());
        }
        return result;
    }
    public String readAllToString() {
        LinkedList<String> result = readAllToList();
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s);
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return readAllToString();
    }
}
