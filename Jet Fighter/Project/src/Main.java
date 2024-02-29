import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CSE 212 Term Project - Jet Fighter Game");
        frame.setSize(960, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JMenuBar menuBar = new JMenuBar();
 
        JMenu fileMenu = new JMenu("File");
        JMenuItem registerMenuItem = new JMenuItem("Register");
        registerMenuItem.addActionListener(e -> showRegisterDialog());
        fileMenu.add(registerMenuItem);
        JMenuItem playGameMenuItem = new JMenuItem("Play Game");
        playGameMenuItem.addActionListener(e -> startGame());
        fileMenu.add(playGameMenuItem);
        JMenuItem highScoreMenuItem = new JMenuItem("High Score");
        highScoreMenuItem.addActionListener(e -> showHighScoreDialog());
        fileMenu.add(highScoreMenuItem);
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(quitMenuItem);

        // Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(e -> showAboutDialog());
        helpMenu.add(aboutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);
        frame.add(new GameFrame());
        frame.setVisible(true);
    }

    private static void showRegisterDialog() {

        JOptionPane.showMessageDialog(null, "Register ");
    }

    private static void startGame() {
       
        JOptionPane.showMessageDialog(null, "Game started.");
    }

    private static void showHighScoreDialog() {
      
        JOptionPane.showMessageDialog(null, "High Score ");
    }

    private static void showAboutDialog() {
        String name = "Ayberk";
        String surname = "Özkan";
        String schoolNumber = "20210702061";
        String email = "ayberk.ozkan@std.yeditepe.edu.tr";

        String message = "Developer Information:\n\n"
                + "Name: " + name + "\n"
                + "Surname: " + surname + "\n"
                + "School Number: " + schoolNumber + "\n"
                + "Email: " + email;

        JOptionPane.showMessageDialog(null, message, "About", JOptionPane.INFORMATION_MESSAGE);
    }
}
