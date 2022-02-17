import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AdminUI extends Frame implements ActionListener{
	private Frame parent;
	private Startup st;
	public TextField tf;
	public TextField tf2;
	public Adminpanel px;
	private static int C=0;

	public AdminUI (Startup kl){
		super("AdminUI");
		st=kl;
		px=new Adminpanel(this);
		Label l=new Label("User Name");
		Label l2=new Label("Password");
		tf=new TextField(20);
		tf2=new TextField(20);
		
		Button b=new Button("Login");
		l.setBounds(30,50,80,25);
		tf.setBounds(120,50,200,30);
		l2.setBounds(30,125,80,25);
		tf2.setBounds(120,125,200,30);
		b.setBounds(160,170,60,40);
		b.addActionListener(this);
		Button b4=new Button("Back");
		b4.setBounds(120,500,60,40);
		b4.addActionListener(this);
		add(l);add(tf);
		add(l2);add(tf2);
		add(b); add(b4);
		setSize(500,400);
		setLocation(500,400);
		setLayout(null);
		//setVisible(false);
		
		setSize(300,400);
		setLayout(new FlowLayout());
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Login")){
			DataAccess da= new DataAccess();
			String q="";
			String AUsername=tf.getText();
			String APassword= tf2.getText();
			ResultSet rs=null;
			try{
				q="select * from admin";
				rs=da.getData(q);
				while(rs.next()){
					

					String n = rs.getString("AUsername");
					String p= rs.getString("APassword");
					if(n.equals(AUsername) && p.equals(APassword)){
			JOptionPane.showMessageDialog(this,"Succesfully login");
			
						   this.setVisible(false);
			                px.setParent(this);
			                px.setVisible(true);
				}
							
							else{
								JOptionPane.showMessageDialog(this,"Wrong Username or Password");
							}
							
			
			
			}
		}
			catch(Exception ex){
				ex.printStackTrace();
			}
		} 
		
		else if(s.equals("Back")){
			this.setVisible(false);
			parent.setVisible(true);
		}
	
	}
public void setParent(Frame f){parent=f;}
	}
