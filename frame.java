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
JFrame frame2= new JFrame("Image Window");
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

    frame2.setContentPane(panel);

Toolkit theKit = window.getToolkit();
Dimension wndSize = theKit.getScreenSize();
frame2.setSize(200,200);
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setBounds(wndSize.width/4,wndSize.height/4,wndSize.width/2,wndSize.height/2);
frame2.pack();
frame2.setVisible(true);
window.setVisible(true);


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
