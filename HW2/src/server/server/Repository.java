package server.server;

import java.io.IOException;

public interface Repository {
    void save(String text) throws IOException;
    String read() throws IOException;
}
