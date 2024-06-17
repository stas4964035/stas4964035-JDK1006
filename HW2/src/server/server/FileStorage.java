package server.server;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileStorage implements Repository{
    private static final String FILE_PATH = "HW2/src/server/log.txt";

    @Override
    public void save(String text) throws IOException {

        FileWriter fileWriter = new FileWriter(FILE_PATH, true);
        fileWriter.write(text);
        fileWriter.flush();
        fileWriter.close();
    }

    @Override
    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(FILE_PATH)));
    }
}
