import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class frame
{
static FrameWork window;

public static void main(String[] args)throws IOException
{

window = new FrameWork("ChitChat Broadcast Messenger");
Toolkit theKit = window.getToolkit();
Dimension wndSize = theKit.getScreenSize();

window.setBounds(wndSize.width/4,wndSize.height/4,wndSize.width/2,wndSize.height/2);
window.setVisible(true);


if ((args.length != 1) || (args[0].indexOf (':') < 0))
     throw new IllegalArgumentException ("Syntax: Client <host>:<port>");

  int idx = args[0].indexOf (':');
 String host = args[0].substring (0, idx);
 int port = Integer.parseInt (args[0].substring (idx + 1));
 frame sObj = new frame();
 sObj.fun(host,port,window);

}
void  fun(String host,int port,FrameWork window) throws IOException
{
	 Client client = new Client (host, port, window);
    client.start ();
}
}
