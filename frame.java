import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class frame
{
static FrameWork window;

public static void main(String[] args)throws IOException
{

window = new FrameWork("FarmAssist");
/*JFrame frame2= new JFrame("Image Window");
JPanel panel= new JPanel();
panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
//frame2.add(panel);
JButton btn1= new JButton("Flo2");
JButton btn2= new JButton("Fire");
JButton btn3= new JButton("Rodent");
JButton btn4= new JButton("Decaught");

btn1.setPreferredSize(new Dimension(80, 80));
btn2.setPreferredSize(new Dimension(80, 80));
btn3.setPreferredSize(new Dimension(80, 80));
btn4.setPreferredSize(new Dimension(80, 80));

    panel.add(btn1);
    panel.add(btn2);
    panel.add(btn3);
    panel.add(btn4);

    frame2.setContentPane(panel);*/

Toolkit theKit = window.getToolkit();
Dimension wndSize = theKit.getScreenSize();
//frame2.setSize(200,200);
//frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setBounds(wndSize.width/4,wndSize.height/4,wndSize.width/2,wndSize.height/2);
//frame2.pack();
//frame2.setVisible(true);
window.setVisible(true);




    JFrame frame = new JFrame("FARMASSIST");
    JButton button = new JButton("Flood");
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    JButton button1= new JButton("Rodent");
    button1.setAlignmentX(Component.CENTER_ALIGNMENT);
    JButton button2 = new JButton("Fire");
    button2.setAlignmentX(Component.CENTER_ALIGNMENT);
    JButton button3= new JButton("Wild-Animals");
    button3.setAlignmentX(Component.CENTER_ALIGNMENT);
    JButton button4 = new JButton("SugarCane");
    button4.setAlignmentX(Component.CENTER_ALIGNMENT);
    JButton button5= new JButton("Wheat");
    button5.setAlignmentX(Component.CENTER_ALIGNMENT);
    JButton button6 = new JButton("Rice");
    button6.setAlignmentX(Component.CENTER_ALIGNMENT);
    JButton button7= new JButton("Ragi");
    button7.setAlignmentX(Component.CENTER_ALIGNMENT);
    //String crops="Choose the afftected crop";
    ImageIcon imgicon = new ImageIcon("water.jpeg");
    Image img= imgicon.getImage();
    Image newimg = img.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
    imgicon = new ImageIcon( newimg );
    ImageIcon imgicon1 = new ImageIcon("rodent.jpeg");
    Image img1= imgicon1.getImage();
    Image newimg1 = img1.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
    imgicon1 = new ImageIcon( newimg1 );
    ImageIcon imgicon2= new ImageIcon("Fire.jpeg");
    Image img2= imgicon2.getImage();
    Image newimg2 = img2.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
    imgicon2 = new ImageIcon( newimg2 );
    ImageIcon imgicon3= new ImageIcon("Wild-Animals.jpeg");
    Image img3= imgicon3.getImage();
    Image newimg3 = img3.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
    imgicon3 = new ImageIcon( newimg3 );

    ImageIcon imgicon4= new ImageIcon("sugercane.jpeg");
    Image img4= imgicon4.getImage();
    Image newimg4 = img4.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
    imgicon4 = new ImageIcon( newimg4 );

    ImageIcon imgicon5= new ImageIcon("wheat.jpeg");
    Image img5= imgicon5.getImage();
    Image newimg5 = img5.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
    imgicon5 = new ImageIcon( newimg5 );

    ImageIcon imgicon6= new ImageIcon("rice.jpeg");
    Image img6= imgicon6.getImage();
    Image newimg6 = img6.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
    imgicon6 = new ImageIcon( newimg6 );

    ImageIcon imgicon7= new ImageIcon("ragi.jpeg");
    Image img7= imgicon7.getImage();
    Image newimg7 = img7.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
    imgicon7 = new ImageIcon( newimg7 );

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    button.setIcon(imgicon);
    button1.setIcon(imgicon1);
    button2.setIcon(imgicon2);
    button3.setIcon(imgicon3);
    button4.setIcon(imgicon4);
    button5.setIcon(imgicon5);
    button6.setIcon(imgicon6);
    button7.setIcon(imgicon7);
    String calamity="Select the calamity";
    JLabel label1=new JLabel(calamity);
    panel.add(label1);
    panel.add(button);
    panel.add(button1);
    panel.add(button2);
    panel.add(button3);
    String crops="Choose the afftected crop";
    JLabel label = new JLabel(crops);
    panel.add(label);
    panel.add(button4);
    panel.add(button5);
    panel.add(button6);
    panel.add(button7);
    frame.add(panel, BorderLayout.NORTH);
    frame.setSize(400, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

if ((args.length != 1) || (args[0].indexOf (':') < 0))
     throw new IllegalArgumentException ("Syntax: Client <host>:<port>");

  int idx = args[0].indexOf (':');
 String host = args[0].substring (0, idx);
 int port = Integer.parseInt (args[0].substring (idx + 1));
 frame sObj = new frame();
    System.out.println(host);
    System.out.println(port); System.out.println(window);
 sObj.fun(host,port,window);



}
void  fun(String host,int port,FrameWork window) throws IOException
{
	 Client client = new Client (host, port, window);
	 client.start ();
}
}
