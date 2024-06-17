package server.server;

import server.client.ClientController;

import java.io.IOException;

public interface ServerView {
    void showMessage(String msg);
    void disconnect() throws IOException;
    void connect();

    void disconnected(ClientController client);
}
