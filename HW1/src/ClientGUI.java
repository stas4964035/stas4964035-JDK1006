import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    protected static final int WIDTH = 400;
    protected static final int HEIGHT = 300;
    protected final ServerWindow server;
    protected final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("1337");
    private final JTextField tfLogin = new JTextField("User");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btSend = new JButton("Send");

    public ClientGUI(ServerWindow server) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");
        this.server = server;

        btSend.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                server.sendMessage(tfMessage.getText());
                fillLog();
            }
        });

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btSend, BorderLayout.SOUTH);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        fillLog();
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);
        setVisible(true);

    }
    private void clearLog(){
        log.setText("");
    }
    private void fillLog(){
        clearLog();
        log.setText(server.getLastMessages(5));
    }




}
