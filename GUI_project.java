/**
*Text genereted by Simple GUI Extension for BlueJ
*/
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;


public class GUI_project extends JFrame {

    private JMenuBar menuBar;
    private JButton[][] board = new JButton[7][7];
   

    //Constructor 
    public GUI_project(){

        setTitle("GUI_project");
        setSize(500,400);
        //menu generate method
        generateMenu();
        setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(192,192,192));

        for(int i = 0; i<=6; i++)
        {
            for(int j = 0; j<=6; j++)
            {
                board[i][j] = new JButton();
                board[i][j].setBounds((47 + 20 * i),(26 + 20 * j),20,20);
                board[i][j].setBackground(new Color(192,192,192));
                board[i][j].setForeground(new Color(0,0,0));
                board[i][j].setEnabled(true);
                board[i][j].setFont(new Font("sansserif",0,12));
                board[i][j].setText("");
                board[i][j].setVisible(true);
                board[i][j].addMouseListener(new MouseAdapter() {
                   public void mouseClicked(MouseEvent evt) {
                       board[0][0].setBackground(new Color(255,255,255));
                       contentPane.add(board[0][0]);
                       clicked(evt);
                   }
                });
                //adding components to contentPane panel
                contentPane.add(board[i][j]);
            }
        }
        

        //adding panel to JFrame and seting of window position and close operation
        getContentPane().add(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    //Method mouseClicked for buttons
    private void clicked (MouseEvent evt) {
            //TODO
            System.out.println("Helloworld");
            setBackground(new Color(0,192,192));
    }

    //method for generate menu
    public void generateMenu(){
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open   ");
        JMenuItem save = new JMenuItem("Save   ");
        JMenuItem exit = new JMenuItem("Exit   ");
        JMenuItem preferences = new JMenuItem("Preferences   ");
        JMenuItem about = new JMenuItem("About   ");


        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        tools.add(preferences);
        help.add(about);

        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(help);
    }



     public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI_project();
            }
        });
    }

}