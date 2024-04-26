package meetcircle1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class MeetCircle1 extends JFrame {
    private JTextArea chatArea;
    private String contactName;
    
    public MeetCircle1() {
        setTitle("MeetCircle - Video Conferencing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        
        // Set background color to black
        getContentPane().setBackground(Color.BLACK);

        // Create panels for different sections
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10)); // Align right
        JPanel leftPanel = new JPanel(new GridLayout(10, 1)); // Panel for profile, search, and security

        // Add components to top panel
        JLabel titleLabel = new JLabel("Welcome to MeetCircle", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Roman", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE); // Set text color to white
        topPanel.setBackground(Color.BLACK); // Set background color to black
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Add components to center panel
        JTextArea chatArea = new JTextArea(20, 40);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatArea.setForeground(Color.WHITE); // Set text color to white
        chatArea.setBackground(Color.WHITE); // Set background color to WHITE
        centerPanel.setBackground(Color.BLACK); // Set background color to black
        centerPanel.add(chatScrollPane, BorderLayout.CENTER);
        
        // Add components to bottom panel
        JButton chatButton = new JButton("Chat");
        JButton callButton = new JButton("Call");
        JButton videoCallButton = new JButton("Video Call");

        // Set text color to white for buttons
        chatButton.setForeground(Color.WHITE);
        callButton.setForeground(Color.WHITE);
        videoCallButton.setForeground(Color.WHITE);

        // Set background color to black for buttons
        chatButton.setBackground(Color.BLACK);
        callButton.setBackground(Color.BLACK);
        videoCallButton.setBackground(Color.BLACK);

        // Add action listeners for chat, call, and video call buttons
        chatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openChatFrame();
            }
        });

        callButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCallFrame();
            }
        });

        videoCallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openVideoCallFrame();
            }
        });

        bottomPanel.add(chatButton);
        bottomPanel.add(callButton);
        bottomPanel.add(videoCallButton);

        // Add buttons to left panel
        JButton profileButton = new JButton("Profile");
        JButton generalButton = new JButton("General");
        JButton notificationButton = new JButton("Notification");
        JButton securityButton = new JButton("Security");
        JButton aboutButton = new JButton("About");
        JButton logoutButton = new JButton("Logout");

        // Set text color to BLACK for buttons
        profileButton.setForeground(Color.BLACK);
        generalButton.setForeground(Color.BLACK);
        notificationButton.setForeground(Color.BLACK);
        securityButton.setForeground(Color.BLACK);
        aboutButton.setForeground(Color.BLACK);
        logoutButton.setForeground(Color.BLACK);


        // Set background color to WHITE for buttons
        profileButton.setBackground(Color.WHITE);
        generalButton.setBackground(Color.WHITE);
        notificationButton.setBackground(Color.WHITE);
        securityButton.setBackground(Color.WHITE);
        aboutButton.setBackground(Color.WHITE);
        logoutButton.setBackground(Color.WHITE);

        leftPanel.add(profileButton);
        leftPanel.add(generalButton);
        leftPanel.add(notificationButton);
        leftPanel.add(securityButton);
        leftPanel.add(aboutButton);
        leftPanel.add(logoutButton);


        // Add panels to content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        getContentPane().add(leftPanel, BorderLayout.WEST);

        // Add window listener for window closing event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Perform any cleanup operations here
                // For example, close network connections, save data, etc.
                System.exit(0); // Exit the application when the window is closed
            }
        });

        setVisible(true); // Make the frame visible
    }
    
    private void openChatFrame() {
        // Create new frame for chat
        JFrame chatFrame = new JFrame("Chat");
        chatFrame.setSize(400, 300);
        chatFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chatFrame.setLocationRelativeTo(this); // Center the frame relative to MeetCircle

        // Set background color to blue
        chatFrame.getContentPane().setBackground(Color.WHITE);

        // Placeholder components for chat frame
        JTextArea chatHistoryTextArea = new JTextArea(10, 30);
        JScrollPane chatHistoryScrollPane = new JScrollPane(chatHistoryTextArea);

        JPanel contactsPanel = new JPanel(new GridLayout(0, 1));
        contactsPanel.setBorder(BorderFactory.createTitledBorder("Contacts"));
        contactsPanel.setBackground(Color.WHITE); // Set background color 

        // Placeholder contacts
        String[] contacts = {"Friend 1", "Friend 2", "Friend 3", "Friend 4", "Friend 5", "Friend 6", "Friend 7", "Friend 8"};
        for (String contact : contacts) {
            JButton contactButton = new JButton(contact);
            contactButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    openChatWithContact(contact);
                }
            });
            contactButton.setForeground(Color.WHITE); // Set text color to white
            contactButton.setBackground(Color.BLACK); // Set background color to black
            contactsPanel.add(contactButton);
        }

        // Add components to chat frame
        chatFrame.getContentPane().setLayout(new BorderLayout());
        chatFrame.getContentPane().add(chatHistoryScrollPane, BorderLayout.CENTER);
        chatFrame.getContentPane().add(contactsPanel, BorderLayout.EAST);

        chatFrame.setVisible(true);
    }

    private void openCallFrame() {
        // Create new frame for call
        JFrame callFrame = new JFrame("Call");
        callFrame.setSize(400, 300);
        callFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        callFrame.setLocationRelativeTo(this); // Center the frame relative to MeetMeFrame

        // Set background color to blue
        callFrame.getContentPane().setBackground(Color.BLACK);

        // Placeholder components for call frame
        JTextArea callHistoryTextArea = new JTextArea(10, 30);
        JScrollPane callHistoryScrollPane = new JScrollPane(callHistoryTextArea);

        JPanel contactsPanel = new JPanel(new GridLayout(0, 1));
        contactsPanel.setBorder(BorderFactory.createTitledBorder("Contacts"));
        contactsPanel.setBackground(Color.WHITE); // Set background color to blue

        // Placeholder contacts
        String[] contacts = {"Friend 1", "Friend 2", "Friend 3", "Friend 4", "Friend 5", "Friend 6", "Friend 7", "Friend 8"};
        for (String contact : contacts) {
            JButton contactButton = new JButton(contact);
            contactButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    openCallWithContact(contact);
                }
            });
            contactButton.setForeground(Color.WHITE); // Set text color to white
            contactButton.setBackground(Color.BLACK); // Set background color to blue
            contactsPanel.add(contactButton);
        }

        // Add components to call frame
        callFrame.getContentPane().setLayout(new BorderLayout());
        callFrame.getContentPane().add(callHistoryScrollPane, BorderLayout.CENTER);
        callFrame.getContentPane().add(contactsPanel, BorderLayout.EAST);

        callFrame.setVisible(true);
    }

    private void openVideoCallFrame() {
        // Create new frame for video call
        JFrame videoCallFrame = new JFrame("Video Call");
        videoCallFrame.setSize(400, 300);
        videoCallFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        videoCallFrame.setLocationRelativeTo(this); // Center the frame relative to MeetMeFrame

        // Set background color to blue
        videoCallFrame.getContentPane().setBackground(Color.BLACK);

        // Placeholder components for video call frame
        JTextArea videoCallHistoryTextArea = new JTextArea(10, 30);
        JScrollPane videoCallHistoryScrollPane = new JScrollPane(videoCallHistoryTextArea);

        JPanel contactsPanel = new JPanel(new GridLayout(0, 1));
        contactsPanel.setBorder(BorderFactory.createTitledBorder("Contacts"));
        contactsPanel.setBackground(Color.WHITE); // Set background color to blue

        // Placeholder contacts
        String[] contacts = {"Friend 1", "Friend 2", "Friend 3", "Friend 4", "Friend 5", "Friend 6", "Friend 7", "Friend 8"};
        for (String contact : contacts) {
            JButton contactButton = new JButton(contact);
            contactButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    openVideoCallWithContact(contact);
                }
            });
            contactButton.setForeground(Color.WHITE); // Set text color to white
            contactButton.setBackground(Color.BLACK); // Set background color to blue
            contactsPanel.add(contactButton);
        }

        // Add components to video call frame
        videoCallFrame.getContentPane().setLayout(new BorderLayout());
        videoCallFrame.getContentPane().add(videoCallHistoryScrollPane, BorderLayout.CENTER);
        videoCallFrame.getContentPane().add(contactsPanel, BorderLayout.EAST);

        videoCallFrame.setVisible(true);
    }

    private void openChatWithContact(String contact) {
        // Create new frame for chatting with the selected contact
        JFrame chatWithContactFrame = new JFrame("Chat with " + contact);
        chatWithContactFrame.setSize(400, 300);
        chatWithContactFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chatWithContactFrame.setLocationRelativeTo(this); // Center the frame relative to MeetMeFrame

        // Set background color to blUe
        chatWithContactFrame.getContentPane().setBackground(Color.WHITE);

        // Placeholder components for chat with contact frame
        JTextArea chatHistoryTextArea = new JTextArea(10, 30);
        JScrollPane chatHistoryScrollPane = new JScrollPane(chatHistoryTextArea);
        JTextField messageField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        JPanel messagePanel = new JPanel();
        messagePanel.add(messageField);
        messagePanel.add(sendButton);

        // Set text color to white
        chatHistoryTextArea.setForeground(Color.BLACK);
        messageField.setForeground(Color.BLACK);
        sendButton.setForeground(Color.WHITE);

        // Set background color to blue
        chatHistoryTextArea.setBackground(Color.WHITE);
        messageField.setBackground(Color.WHITE);
        messagePanel.setBackground(Color.BLACK);
        sendButton.setBackground(Color.BLACK);

        // Add components to chat with contact frame
        chatWithContactFrame.getContentPane().setLayout(new BorderLayout());
        chatWithContactFrame.getContentPane().add(chatHistoryScrollPane, BorderLayout.CENTER);
        chatWithContactFrame.getContentPane().add(messagePanel, BorderLayout.SOUTH);

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                // Placeholder: Send message to the selected contact
                JOptionPane.showMessageDialog(chatWithContactFrame, "Sending message: " + message);
                // Placeholder: Update chat history
                chatHistoryTextArea.append("You: " + message + "\n");
                // Clear message field after sending
                messageField.setText("");
            }
        });

        chatWithContactFrame.setVisible(true);
    }

    private void openCallWithContact(String contact) {
        // Placeholder action for call with contact
        JOptionPane.showMessageDialog(MeetCircle1.this, "Calling " + contact);
    }

    private void openVideoCallWithContact(String contact) {
        // Placeholder action for video call with contact
        JOptionPane.showMessageDialog(MeetCircle1.this, "Video Calling " + contact);
    }
    
     public MeetCircle1(String userName) {
         
         this();
        // Initialize the MeetCircle1 frame with the logged-in user's details
        // You can add components and logic based on the logged-in user
        JOptionPane.showMessageDialog(null, "Welcome, " + userName + "!");
        // Example: setTitle("Welcome, " + userName);
        // Example: add(new JLabel("Hello, " + userName));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               // new MeetCircle1().setVisible(true); // Create and show the frame
               // Create and show the frame
               String username = "Username"; // Provide username here
               MeetCircle1 meetCircle = new MeetCircle1(username);
               MeetCircle1 server = new MeetCircle1();
               meetCircle.setVisible(true);
               meetCircle.startServer();
              // server.setVisible(true);

               // Start the server
              // server.startServer();
            } 
        });
    }


private void startServer() {
    int portNumber = 9999;

    try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
        System.out.println("Server started. Waiting for clients...");

        // Accept client connections
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            // Start a new thread to handle client communication
            Thread clientThread = new Thread(new ClientHandler(clientSocket));
            clientThread.start();
        }
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
}

static class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.err.println("Error setting up client socket: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                // Echo back to the client
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.err.println("Error handling client input: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}

public void startClient() {
    try {
        // Connect to the server
        Socket socket = new Socket("localhost", 9999);

        // Perform any client-side operations here
        // For example, sending/receiving data to/from the server

        // Close the socket when done
        socket.close();
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
        }

    }
}
