import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Client implements Runnable, WindowListener, ActionListener{
  protected String host;
  protected int port;

  public TextArea output;
  protected TextField input;
  protected TextArea temp;
  FrameWork window;
   String yourname;
  

GraphicsEnvironment e=GraphicsEnvironment.getLocalGraphicsEnvironment();

String[] colorNames={"Red","Blue","Green","Black","Orange","Yellow","Pink","Gray","DarkGray","Cyan","White"};
Color[] fontcolor={Color.red,Color.blue,Color.green,Color.black,Color.orange,Color.yellow,Color.pink,Color.gray,Color.darkGray,Color.cyan,Color.white};
private JList fontcolorList=new JList (colorNames);

  Font f=new Font("SansSerif",Font.PLAIN,16);
  Color c=new Color(0);
public Client()
{

}
  public Client (String host, int port, FrameWork window) {
    this.host = host;
    this.port = port;
    this.yourname=JOptionPane.showInputDialog("Enter Login name:");

    window.setSize(100,100);
    window.setBackground(Color.cyan);
    output = new TextArea (5,30);
    output.setEditable (false);
    temp = new TextArea (5,30);
    temp.setVisible(false);
    input = new TextField(30);
    input.setFont(f);
    input.setForeground(Color.blue);
    output.setFont(f);
    output.setForeground(Color.blue);
    input.addActionListener (this);


    GridBagConstraints constraints = new GridBagConstraints();
    window.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    window.getContentPane().setLayout(new BorderLayout(40,50));

    window.getContentPane().add (temp,BorderLayout.NORTH);
    constraints.insets =new Insets(10,10,10,10);
    window.getContentPane().add (output,BorderLayout.CENTER);
    window.getContentPane().add (input,BorderLayout.SOUTH);


window.pack();
  }


public TextArea func()
{
  return(output);
}
public Insets getInsets()
  {
  return new Insets(10,10,10,10);
  }
  protected DataInputStream dataIn;
  protected DataOutputStream dataOut;
  protected Thread listener;

  public synchronized void start () throws IOException {
    if (listener == null) {
    
      Socket socket = new Socket (host, port);
      try {
        dataIn = new DataInputStream
          (new BufferedInputStream (socket.getInputStream ()));
        dataOut = new DataOutputStream
          (new BufferedOutputStream (socket.getOutputStream ()));
          dataOut.writeUTF (yourname+" has logged on\n ");
      
      } catch (IOException ex) {
        socket.close ();

        throw ex;
      }
      listener = new Thread (this);
      listener.start ();
      window.setVisible (true);
    }
  }

  public synchronized void stop () throws IOException {
    
    if (listener != null) {
      listener.interrupt ();
       listener = null;
      dataOut.close ();
    }
  }
  public void run() {
    try {
      while (!Thread.interrupted ()) {
        String line = dataIn.readUTF ();
        

       output.append (line + "\n");
      }
    } catch (IOException ex) {
      handleIOException (ex);
    }
  }

  protected synchronized void handleIOException (IOException ex) {
    if (listener != null) {
      output.append (ex + "\n");
      input.setVisible (false);
      window.validate ();
      if (listener != Thread.currentThread ())
        listener.interrupt ();
      listener = null;
      try {
        dataOut.close ();

      } catch (IOException ignored) {
      }
    }
  }

  public void windowOpened (WindowEvent event) {
    input.requestFocus ();
  }

  public void windowClosing (WindowEvent event) {
    try {
      stop ();

    } catch (IOException ex) {
      ex.printStackTrace ();
    }
  }

  public void windowClosed (WindowEvent event) {}
  public void windowIconified (WindowEvent event) {}
  public void windowDeiconified (WindowEvent event) {}
  public void windowActivated (WindowEvent event) {}
  public void windowDeactivated (WindowEvent event) {}

  public void actionPerformed (ActionEvent event) {
    try {
      input.selectAll ();
      dataOut.writeUTF (yourname+" says:\n "+event.getActionCommand ());
      dataOut.flush ();
    } catch (IOException ex) {
      handleIOException (ex);
    }
  }
}

