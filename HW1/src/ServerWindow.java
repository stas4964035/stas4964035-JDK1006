import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ServerWindow extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private boolean serverRunning = false;

    private Loger loger = new Loger();

    private final JToggleButton switchChat;
    private final JTextArea terminal;

    private final JScrollPane terminalScroll;
    private final JPanel logPanel;


    public ServerWindow() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Server Control Window");


        switchChat = new JToggleButton(serverRunning ? "ON" : "OFF", false);
        switchChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverRunning = !serverRunning;
                switchChat.setText(serverRunning ? "ON" : "OFF");
                loger.log("Chat state: " + serverRunning);
                fillTerminal();
            }


        });

        terminal = new JTextArea(8,10);
        fillTerminal();
        logPanel = new JPanel(new GridLayout(2,1));


        terminalScroll = new JScrollPane(terminal);


        logPanel.add(switchChat, BorderLayout.NORTH);
        logPanel.add(terminalScroll);


        add(logPanel);
        setVisible(true);


    }
    private void fillTerminal(){
        clearLog();
        for(String str : loger.readAllToList()){
            terminal.append(str+"\n");
        }
    }
    public String getLastMessages(int limit){
        StringBuilder result = new StringBuilder();
        for(String str : loger.readAllToList(limit)){
            result.append(str+"\n");
        }
        return result.toString();
    }
    private void clearLog(){
        terminal.setText("");
    }
    public void sendMessage(String msg){
        loger.log(msg);
        fillTerminal();
    }
}
