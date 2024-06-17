package server.server;

import server.client.ClientController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ServerGUI extends JFrame implements ServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;


    JButton btnStart, btnStop, btnKick;
    JTextArea log;
    JList clients;

    ServerController serverController;

    public ServerGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }

    public void setServerController(ServerController serverController) {
        this.serverController = serverController;
    }

    private void createPanel() {
        JPanel topPanel = new JPanel(new GridLayout(1,2));

        log = new JTextArea();
        clients = new JList();
        clients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        clients.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        topPanel.add(log);
        topPanel.add(clients);

        add(topPanel);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnKick = new JButton("Kick");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    serverController.run();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    serverController.stop();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnKick.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    disconnect();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        panel.add(btnKick);
        return panel;
    }
    public void disconnected(ClientController client){
        clients.setListData(serverController.getCtrlList());
    }


    @Override
    public void showMessage(String msg) {
        log.append(msg + "\n");
    }

    @Override
    public void disconnect() throws IOException {
        int id = clients.getSelectedIndex();
        if (id != -1) {
            serverController.disconnectUser(id);
        }
    }

    @Override
    public void connect() {
        clients.setListData(serverController.getCtrlList());
    }
}
