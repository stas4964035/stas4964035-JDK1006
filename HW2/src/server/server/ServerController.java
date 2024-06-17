package server.server;

import server.client.ClientController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerController {
    private Repository repository;
    List<ClientController> clientCtrlList;
    private ServerView serverView;
    private boolean work;

    public ServerController() {
        clientCtrlList = new ArrayList<ClientController>();
        repository = new FileStorage();
    }

    public void setServerView(ServerView serverView) {
        this.serverView = serverView;
    }

    public void appendLog(String text) throws IOException {
        repository.save(text + "\n");
        serverView.showMessage(text);
    }

    public boolean connectUser(ClientController client) throws IOException {
        if (!work) {
            return false;
        }
        clientCtrlList.add(client);
        serverView.connect();
        appendLog(client.getName() + " connected!");

        return true;
    }

    public void disconnectUser(ClientController client) throws IOException {
        clientCtrlList.remove(client);
        if (client != null) {
            client.disconnectedFromServer();
            serverView.disconnected(client);
            appendLog(client.getName() + " disconnected!");
        }
    }
    public void disconnectUser(int id) throws IOException {
        disconnectUser(clientCtrlList.get(id));
    }

    public String getLog() throws IOException {
        return readLog();
    }

    private String readLog() throws IOException {
        return repository.read();
    }

    public String getHistory() {
        return null;
    }


    public void message(String s) throws IOException {
        if (!work) {
            return;
        }
        appendLog(s);
        answerAll(s);
    }

    private void answerAll(String text) {
        for (ClientController clientCtrl : clientCtrlList) {
            clientCtrl.answer(text);
        }
    }

    public boolean status() {
        return work;
    }

    public void run() throws IOException {
        if (work) {
            appendLog("Сервер уже был запущен");
        } else {
            work = true;
            appendLog("Сервер запущен!");
        }
    }

    public void stop() throws IOException {
        if (!status()) {
            appendLog("Сервер уже был остановлен");
        } else {
            work = false;
            while (!clientCtrlList.isEmpty()) {
                disconnectUser(clientCtrlList.get(clientCtrlList.size() - 1));
            }
            appendLog("Сервер остановлен!");
        }
    }
    public String[] getCtrlList(){
        String[] result = new String[clientCtrlList.size()];
        for(ClientController client : clientCtrlList){
            result[clientCtrlList.indexOf(client)] = client.getName();
        }
        return result;
    }
}
