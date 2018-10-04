import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Handler implements Runnable {
  protected Socket socket;
 public String logins;
Server obj;

public Handler (String login)
{
this.logins=login;
}
  public Handler (Socket socket,String logins) {
    this.socket = socket;
    this.logins= logins;
  }

  protected DataInputStream dataIn;
  protected DataOutputStream dataOut;
  protected Thread listener;

  public synchronized void start () {
    if (listener == null) {
      try {
        dataIn = new DataInputStream
          (new BufferedInputStream (socket.getInputStream ()));
        dataOut = new DataOutputStream
          (new BufferedOutputStream (socket.getOutputStream ()));

        
        listener = new Thread (this);
        listener.start ();

      } catch (IOException ignored) {}

    }
  }

  public synchronized void stop () {
    if (listener != null) {
      try {
        if (listener != Thread.currentThread ())
          listener.interrupt ();
        listener = null;
        dataOut.close ();
String msg= "\n" + InetAddress.getLocalHost() + "has logged off.\n";
broadcast(msg);
obj.output.append("\n" + InetAddress.getLocalHost() + " has logged off.\n");
      } catch (IOException ignored) {
      }
    }
  }

   protected static Vector handlers = new Vector ();

  public void run () {
    try {
      handlers.addElement (this);
      while (!Thread.interrupted ()) {
        String message1 = dataIn.readUTF ();
       String message=message1;
        broadcast (message);
      }
    } catch (EOFException ignored) {
    } catch (IOException ex) {
      if (listener == Thread.currentThread ())
        ex.printStackTrace ();
    } finally {
      handlers.removeElement (this);
    }
    stop ();
  }

  protected void broadcast (String message) {
    synchronized (handlers) {
      Enumeration en = handlers.elements ();
      while (en.hasMoreElements ()) {
        Handler handler = (Handler) en.nextElement ();
        try {
          handler.dataOut.writeUTF (message);
          handler.dataOut.flush ();
        } catch (IOException ex) {
          handler.stop ();
        }
      }
    }
  }
  protected void broadcastNew (String message) {
    synchronized (handlers) {
      Enumeration en = handlers.elements ();
      while (en.hasMoreElements ()) {
        Handler handler = (Handler) en.nextElement ();
        try {
          handler.dataOut.writeUTF (message);
          handler.dataOut.flush ();
        } catch (IOException ex) {
          handler.stop ();
        }
      }
    }
  }
}
