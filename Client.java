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
  public JPanel opanel;
  public JButton tiger;
  public JButton elephant;
  public JButton flood;
  public JButton rodent;
  public JButton corn;
  public JButton fire;
  public JButton cattle;
  public JLabel imgtiger;
  public JLabel imgele;
  public JLabel imgflood;
  public JLabel imgrodent;
  public JLabel imgcorn;
  public JLabel imgfire;
  public JLabel imgcattle;

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
    opanel=new JPanel();
    opanel.setBackground(Color.ORANGE);
    opanel.setLayout(new GridLayout(10,2));
    window.getContentPane().add(opanel,BorderLayout.CENTER); 
    opanel.add(new JLabel(yourname));



    imgtiger=new JLabel(new ImageIcon("tiger.jpg"));
    opanel.add(imgtiger);
    tiger=new JButton("tiger");
    tiger.setIcon(new ImageIcon(this.getClass().getResource("tiger.jpg")));
    opanel.add(tiger);
    imgtiger.setVisible(false);
    tiger.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        
       Activator("tiger");

      }

    });


    imgele=new JLabel(new ImageIcon("elephant.jpg"));
    opanel.add(imgele);
    elephant=new JButton("elephant");
    elephant.setIcon(new ImageIcon(this.getClass().getResource("elephant.jpg")));
    opanel.add(elephant);
    imgele.setVisible(false);
    elephant.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        
       Activator("elephant");

      }

    });



    imgflood=new JLabel(new ImageIcon("flood.jpg"));
    opanel.add(imgflood);
    flood=new JButton("flood");
    flood.setIcon(new ImageIcon(this.getClass().getResource("flood.jpg")));
    opanel.add(flood);
    imgflood.setVisible(false);
    flood.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        
       Activator("flood");

      }

    });


    imgrodent=new JLabel(new ImageIcon("rodent.jpg"));
    opanel.add(imgrodent);
    rodent=new JButton("rodent");
    rodent.setIcon(new ImageIcon(this.getClass().getResource("rodent.jpg")));
    opanel.add(rodent);
    imgrodent.setVisible(false);
    rodent.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        
       Activator("rodent");

      }

    });



    imgcorn=new JLabel(new ImageIcon("corn.jpg"));
    opanel.add(imgcorn);
    corn=new JButton("corn");
    corn.setIcon(new ImageIcon(this.getClass().getResource("corn.jpg")));
    opanel.add(corn);
    imgcorn.setVisible(false);
    corn.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        
       Activator("corn");

      }

    });


    imgfire=new JLabel(new ImageIcon("fire.jpg"));
    opanel.add(imgfire);
    fire=new JButton("fire");
    fire.setIcon(new ImageIcon(this.getClass().getResource("fire.jpg")));
    opanel.add(fire);
    imgfire.setVisible(false);
    fire.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        
       Activator("fire");

      }

    });


    imgcattle=new JLabel(new ImageIcon("cattle.jpg"));
    opanel.add(imgcattle);
    cattle=new JButton("cattle");
    cattle.setIcon(new ImageIcon(this.getClass().getResource("cattle.jpg")));
    opanel.add(cattle);
    imgcattle.setVisible(false);
    cattle.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        
       Activator("cattle");

      }

    });







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
        //String line1[] = line.split(":");
        

        if(line.equals("tiger")){
          imgtiger.setVisible(true);
          imgele.setVisible(false);
          imgflood.setVisible(false);
          imgrodent.setVisible(false);
          imgcorn.setVisible(false);
          imgfire.setVisible(false);
          imgcattle.setVisible(true);

        }
        else if (line.equals("elephant")) {
          imgtiger.setVisible(false);
          imgele.setVisible(true);
          imgflood.setVisible(false);
          imgrodent.setVisible(false);
          imgcorn.setVisible(true);
          imgfire.setVisible(false);
          imgcattle.setVisible(false);
          
        }
        else if (line.equals("flood")) {
          imgtiger.setVisible(false);
          imgele.setVisible(false);
          imgflood.setVisible(true);
          imgrodent.setVisible(false);
          imgcorn.setVisible(false);
          imgfire.setVisible(false);
          imgcattle.setVisible(false);
          
        }
        else if (line.equals("rodent")) {
          imgtiger.setVisible(false);
          imgele.setVisible(false);
          imgflood.setVisible(false);
          imgrodent.setVisible(true);
          imgcorn.setVisible(true);
          imgfire.setVisible(false);
          imgcattle.setVisible(false);
          
        }
        else if (line.equals("corn")) {
          imgtiger.setVisible(false);
          imgele.setVisible(false);
          imgflood.setVisible(false);
          imgrodent.setVisible(false);
          imgcorn.setVisible(true);
          imgfire.setVisible(false);
          imgcattle.setVisible(false);
          
        }
        else if (line.equals("fire")) {
          imgtiger.setVisible(false);
          imgele.setVisible(false);
          imgflood.setVisible(false);
          imgrodent.setVisible(false);
          imgcorn.setVisible(false);
          imgfire.setVisible(true);
          imgcattle.setVisible(false);
          
        }

        else if (line.equals("cattle")) {
          imgtiger.setVisible(false);
          imgele.setVisible(false);
          imgflood.setVisible(false);
          imgrodent.setVisible(false);
          imgcorn.setVisible(true);
          imgfire.setVisible(false);
          imgcattle.setVisible(true);
        }


        

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
      dataOut.writeUTF (yourname+" :\n "+event.getActionCommand ());
      dataOut.flush ();
    } catch (IOException ex) {
      handleIOException (ex);
    }
  }
  public void Activator(String msg){
    try {
      input.selectAll ();
      dataOut.writeUTF (msg);
      dataOut.flush ();
    } catch (IOException ex) {
      handleIOException (ex);
    }


  }
}

