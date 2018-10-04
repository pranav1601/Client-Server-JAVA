import javax.swing.*;
import java.io.*;
import java.io.Writer.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import java.lang.*;


public class FrameWork extends JFrame implements ActionListener
{
Client chatObj;
String logins="Farmer1";
String chat;
public FrameWork(String title)
{

setTitle(title);

setJMenuBar(menuBar);

JMenu fileMenu = new JMenu("File");
JMenu colorMenu = new JMenu("Color");
JMenu helpMenu = new JMenu("Help");

fileMenu.setMnemonic('F');
colorMenu.setMnemonic('C');
helpMenu.setMnemonic('H');

newAction = new FileAction("New", KeyStroke.getKeyStroke('N',Event.CTRL_MASK));
saveAction = new FileAction("Save", KeyStroke.getKeyStroke('S',Event.CTRL_MASK));
exitAction = new FileAction("Exit", KeyStroke.getKeyStroke('E',Event.CTRL_MASK));
loginAction = new FileAction("Login As", KeyStroke.getKeyStroke('L',Event.CTRL_MASK));

addMenuItem(fileMenu,loginAction);
fileMenu.addSeparator();
addMenuItem(fileMenu,newAction);
fileMenu.addSeparator();
addMenuItem(fileMenu,saveAction);
fileMenu.addSeparator();
addMenuItem(fileMenu,exitAction);
fileMenu.addSeparator();

aboutItem = new JMenuItem("About");
aboutItem.addActionListener(this);
helpMenu.add(aboutItem);

menuBar.add(fileMenu);

menuBar.add(helpMenu);

enableEvents(AWTEvent.WINDOW_EVENT_MASK);
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
KeyStroke keyStroke = (KeyStroke)action.getValue("juh");
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
public void actionPerformed(ActionEvent e)	
     {

String name= (String)getValue(NAME);

if(name.equals(newAction.getValue(NAME)))
	{

	 FrameWork window2;
	 window2 = new FrameWork("FarmAssist");
	 Toolkit theKit = window2.getToolkit();
	 Dimension wndSize = theKit.getScreenSize();

	 window2.setBounds(wndSize.width/4,wndSize.height/4,wndSize.width/2,wndSize.height/2);
window2.setVisible(true);
String newHost = JOptionPane.showInputDialog("Enter HostName:");
String newPort=JOptionPane.showInputDialog("Enter PortName:");



	}

else
if(name.equals(saveAction.getValue(NAME)))
	{
	
	String file =JOptionPane.showInputDialog("Enter FileName:");
	file=file+".txt";
	

	}
else
if(name.equals(exitAction.getValue(NAME)))
	{
	dispose();
	System.exit(0);
	}
else
if(name.equals(loginAction.getValue(NAME)))
    {
	String logins = JOptionPane.showInputDialog("Enter Login name:");
	Handler handle=new Handler(logins);
	
    }

  }
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource() == aboutItem)
{
JOptionPane.showMessageDialog (this,"FarmAssist\nCopyright","About FarmAssist",JOptionPane.INFORMATION_MESSAGE);
}
}


private FileAction newAction, saveAction, exitAction,loginAction;
private Color elementColor;
private Font font;

void FontFunc(TextArea output)
{

	Font f=new Font("SansSerif",Font.BOLD,18);
  	output.setFont(f);
}

}

class SampleFrame extends Frame
{
SampleFrame(String title)
	{
	super(title);
	MyWindowAdapter adapter = new MyWindowAdapter(this);
	addWindowListener(adapter);
	}
}

class MyWindowAdapter extends WindowAdapter
{
	SampleFrame sampleFrame;
	public MyWindowAdapter(SampleFrame sampleFrame)
	{
		this.sampleFrame = sampleFrame;
	}
	public void WindowClosing(WindowEvent we)
	{
		sampleFrame.setVisible(false);
	}
}
