import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Server extends JFrame {
static String yourname;
public Server(String title)
{

output = new TextArea (15,40);
output.setEditable (false);
output.setFont(f);
output.setForeground(Color.blue);
this.yourname="Farmer";

setTitle(title);
setJMenuBar(menuBar);
JMenu fileMenu = new JMenu("File");
JMenu helpMenu = new JMenu("Help");

fileMenu.setMnemonic('F');
helpMenu.setMnemonic('H');

addMenuItem(fileMenu,exitAction = new FileAction("Exit"));

aboutItem = new JMenuItem("About");

helpMenu.add(aboutItem);
addMenuItem(helpMenu,aboutAction = new AboutAction("About"));


menuBar.add(fileMenu);
menuBar.add(helpMenu);

enableEvents(AWTEvent.WINDOW_EVENT_MASK);

}

class AboutAction extends AbstractAction
{
JOptionPane opt;
String name;
public AboutAction(String Name)
{
this.name=Name;
}

public void actionPerformed(ActionEvent ae)
{

 {
 JOptionPane.showMessageDialog (opt,"FarmAssist\n","About FarmAssist",JOptionPane.INFORMATION_MESSAGE);
 }
}
}


protected void processWindowEvent(WindowEvent e)
{
if (e.getID() == WindowEvent.WINDOW_CLOSING)
{
dispose();
System.exit(0);
}
super.processWindowEvent(e);
}

private JMenuItem addMenuItem(JMenu menu,Action action)
{
JMenuItem item = menu.add(action);
KeyStroke keyStroke = (KeyStroke)action.getValue("j");
if(keyStroke != null)
item.setAccelerator(keyStroke);
return item;
}

private JMenuBar menuBar = new JMenuBar();

private JMenuItem aboutItem;

class FileAction extends AbstractAction
{
public FileAction(String NAME,KeyStroke keyStroke)
	{
	super(NAME);
	}
String name;

public FileAction(String name)
{
super(name);
this.name=name;
}
public void actionPerformed(ActionEvent e)
 {
 String name= (String)getValue(NAME);
 if(name.equals(exitAction.getValue(NAME)))
	{
	dispose();
	System.exit(0);
	}
 }
}

class ColorAction extends AbstractAction
{
public ColorAction(String name,Color color)
{
super(name);
this.color=color;
}
public void actionPerformed(ActionEvent e)
{
elementColor = color;
getContentPane().setBackground(color);
}
private Color color;
}

private AboutAction aboutAction;
private FileAction exitAction;
private Color elementColor;
private ColorAction redAction,yellowAction,greenAction,blueAction,magentaAction,cyanAction,blackAction,grayAction,darkGrayAction,pinkAction,orangeAction,whiteAction;

public static TextArea output;
Font f=new Font("SansSerif",Font.PLAIN,16);

public static void main (String args[]) throws IOException {

Server ServerWindow = new Server("FarmAssist: Server Window");
Toolkit theKit = ServerWindow.getToolkit();
Dimension wndSize = theKit.getScreenSize();

ServerWindow.setBounds(wndSize.width/4,wndSize.height/4,wndSize.width/2,wndSize.height/2);
ServerWindow.setVisible(true);
ServerWindow.getContentPane().add ("North", output);
ServerWindow.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));

ServerWindow.pack();

    if (args.length != 1)
      throw new IllegalArgumentException ("Syntax: Server <port>");
    int port = Integer.parseInt (args[0]);
    String logins;
    ServerSocket server = new ServerSocket (port);
    while (true) {
      Socket client = server.accept ();
      Handler handler = new Handler (client,yourname);
      handler.start ();
output.append ("\n Accepted from " + client.getInetAddress ()+"\n");

    }
}

}
