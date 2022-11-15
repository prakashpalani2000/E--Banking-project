import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class BankApp extends JFrame implements ActionListener
{
 JMenuBar jmb;
 JMenu mnew,mtran,mshow;
 JMenuItem iadd,iwith,idip,ichg,idis,iexit;
BorderLayout b;
public static double amt;
BankApp()
{
 super("BANK OF MONEY");
 amt=1000;
 b= new BorderLayout();
 this.setLayout(b);
 jmb=new JMenuBar();
 mnew= new JMenu("New");
 mtran=new JMenu("Transaction");
 mshow=new JMenu("Show");
 iadd=new JMenuItem("Add Customer");
 iadd.addActionListener(this);
 iexit=new JMenuItem("Exit");
 iexit.addActionListener(this);
 iwith=new JMenuItem("Withdraw");
 iwith.addActionListener(this);
 idip=new JMenuItem("Deposit" );
 idip.addActionListener(this);
 ichg=new JMenuItem("Charge Fee");
 ichg.addActionListener(this);
 idis=new JMenuItem("Display");
 idis.addActionListener(this);
 mnew.add(iadd);
 mnew.add(iexit);
 mtran.add(iwith);
 mtran.add(idip);
 mtran.add(ichg);
 mshow.add(idis);
 jmb.add(mnew);
 jmb.add(mtran);
 jmb.add(mshow);
 add(jmb,BorderLayout.NORTH);
 setSize(600,600);
 setVisible( true);
}
public void actionPerformed(ActionEvent e)
 {
 NewFrame f=new NewFrame();
 if(e.getActionCommand()=="Add Customer")
 { 
 
 f.frmNew(amt);
 }
if(e.getActionCommand()=="Exit")
 {
 setVisible(false);
 
 }
 if (e.getActionCommand()=="Display")
{
 f.frmShow(amt);
 }
 if(e.getActionCommand()=="Deposit")
 {
 amt=f.frmdep(amt);
 }
 if(e.getActionCommand()=="Withdraw")
 {amt=f.frmwith(amt);
 }
 }}
class NewFrame implements ActionListener
{ BorderLayout b;
 JLabel lname,lacct,lblbal,ldbal;
 JTextField txtname,txtacct;
 GridLayout gl;
 JButton btnok,btnsave;
 JButton btncancel;
 JFrame f1,f2;
 public static String name,acct;
 /// public static double bal;
 NewFrame()
 {
 gl=new GridLayout(6,2);
 
 lname=new JLabel("Name of the Customer");
 lacct=new JLabel("Account No");
 lblbal=new JLabel("Balance Rs.");
 ldbal=new JLabel();
 }
public void frmNew(double bal)
{
 btnsave=new JButton("Save");
 btnsave.addActionListener(this);
 btncancel=new JButton("Cancel");
 btncancel.addActionListener(this);
 f1=new JFrame("New Customer");
 f1.setLayout(gl);
 
 ldbal=new JLabel(""+bal);
 txtname=new JTextField(10);
 txtacct=new JTextField(10);
 f1.add(lname);
 f1.add(txtname);
 f1.add(lacct);
 f1.add(txtacct);
 f1.add(lblbal);
 f1.add(ldbal);
 f1.add(btnsave);
 f1.add(btncancel);
 f1.setSize(500,500);
 f1.setVisible(true);
}
public void frmShow(double bal)
{
 btnok=new JButton("Ok");
 btnok.addActionListener(this);
 f2=new JFrame("Customer Information");
 f2.setLayout(gl);
 
 JLabel ldacct=new JLabel();
 JLabel ldname=new JLabel();
 ldname.setText(name);
 ldacct.setText(acct);
 ldbal.setText(""+bal);
 f2.add(lname);
 f2.add(ldname);
 f2.add(lacct);
 f2.add(ldacct);
 f2.add(lblbal);
 f2.add(ldbal);
 f2.add(btnok);
 f2.setSize(500,500);
 f2.setVisible(true);
 f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public double frmdep(double bal)
{
 Frame frame= new Frame();
 String str = JOptionPane.showInputDialog(null, "Enter amount to be 
Deposited : ", "Deposit",1);
 double amt;
try{
 amt= Double.valueOf(str).doubleValue();
 bal= bal+amt;
 JOptionPane.showMessageDialog(frame,"New bal "+bal);
}catch(Exception e)
 {
 JOptionPane.showMessageDialog(frame,"Invalid Input!! please enter correct 
Amount");
 }
 return bal;
}
public double frmwith(double bal)
{
Frame frame= new Frame();
 String str = JOptionPane.showInputDialog( null,"Enter amount to be 
Withdraw : ", "Withdraw", 1);
 double amt;
 try{
 amt= Double.valueOf(str).doubleValue();
 bal= bal-amt;
 JOptionPane.showMessageDialog(frame,"New bal "+bal);
}
 catch(Exception e)
 {
 JOptionPane.showMessageDialog(frame,"Invalid Input!! please enter correct 
Amount");
 }
 return bal;
}
public void actionPerformed(ActionEvent e)
{JFrame frame;
 
 if (e.getActionCommand()=="Save")
 {
 name=txtname.getText();
acct=txtacct.getText();
 frame = new JFrame("Saving Record");
 try{
 if(name.equals("")||acct.equals(""))
 {
 JOptionPane.showMessageDialog(frame,"Please enter name and Account 
no of the customer");
 
 }
 else
 {
 //name=txtname.getText();
 //acct=txtacct.getText();
 JOptionPane.showMessageDialog(frame," New Customer account has been 
created");
 }
 }
 catch(Exception ex)
 {
 JOptionPane.showMessageDialog(frame," Error in saving");
 }
 f1.setVisible(false);
 }
 else if(e.getActionCommand()=="Cancel")
 {
 f1.setVisible(false);
 }
else if(e.getActionCommand()=="Ok")
 {
 f2.setVisible(false);
 } }}
public class BankAppDemoNew
{
public static void main(String a[])
{
 new BankApp();
 
}}