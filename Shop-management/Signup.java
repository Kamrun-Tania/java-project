import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Signup extends Frame implements ActionListener{
	private Frame parent;
	private int Count=0;
	private LoginUI log;
	public TextField tf[];
	public Signup()
	{}
	    public Signup(LoginUI l){
	    super("SignupUI");
		
		
	    log=l;
		
		
		Label l1=new Label("User Name: " );
		Label l2=new Label("Address :");
		Label l3=new Label("Age : ");
		Label l4=new Label("Email :");
		Label l5=new Label("Gander :");
        Label l6=new Label("Password : ");
        Label l7=new Label("Phone :");
	
		
		Button b3=new Button("Register");
	    Button b4=new Button("Back");
	
		
		tf=new TextField[7];
		for(int i=0;i<7;i++)
		{
			tf[i]=callTextfield(i);
		}
		
	   
		
		
		l1.setBounds(60,100,80,25);
		tf[0].setBounds(170,100,350,30);
		l2.setBounds(60,150,80,25);
		tf[1].setBounds(170,150,350,30);
		l3.setBounds(60,200,100,25);
		tf[2].setBounds(170,200,350,30);
		l4.setBounds(60,250,80,25);
		tf[3].setBounds(170,250,350,30);
		l5.setBounds(60,300,80,25);
		tf[4].setBounds(170,300,350,30);
		l6.setBounds(60,350,80,25);
		tf[5].setBounds(170,350,350,30);
		l7.setBounds(60,400,80,25);
		tf[6].setBounds(170,400,350,30);
		b3.setBounds(60,500,60,40);
		b3.addActionListener(this);
		b4.setBounds(120,500,60,40);
		b4.addActionListener(this);
		 
		add(l1);add(tf[0]);
		add(l2);add(tf[1]);
		add(l3);add(tf[2]);
		add(l4);add(tf[3]);
		add(l5);add(tf[4]);
		add(l6);add(tf[5]);
		add(l7);add(tf[6]);
		add(b3); add(b4);
		
		
		setSize(600,400);
		setLocation(500,300);
		setLayout(null);
		
	}
	public TextField callTextfield(int i){
		TextField lf= new TextField(20);
		return lf;
		
	}
	
	
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
		if(s.equals("Back")){
			this.setVisible(false);
			parent.setVisible(true);
		}
		else if(s.equals("Register")){
			for(int i=0;i<7;i++){
				if(tf[i].getText().length()==0){
					Count++;
				}
				


				
			}
			if(Count>0){
				JOptionPane.showMessageDialog(this,"You Must Type","Warning",2);
				Count=0;
			}
			
			else{
				int choice = JOptionPane.showConfirmDialog(this,"Do you want to confirm this program","Confirm",JOptionPane.YES_NO_OPTION);
				
				if (choice== JOptionPane.YES_OPTION){
			System.out.println("Successful");
			DataAccess da=new DataAccess();
			
			String CUserName=tf[0].getText();
			String CAddress=tf[1].getText();
			String CAge=tf[2].getText();
			String CEmail=tf[3].getText();
			String CGander=tf[4].getText();
			String CPassword=tf[5].getText();
			String CMobileNumer=tf[6].getText();
			String q="insert into customer values(NULL,'"+CUserName+"','"+CPassword+"','"+CMobileNumer+"','"+CEmail+"','"+CAge+"','"+CGander+"','"+CAddress+"')";
			da.updateDB(q);
			}
			else{
				System.out.println("you have click No ");
			}
			}
		}
	}
	public void setParent(Frame f){parent=f;}
}
