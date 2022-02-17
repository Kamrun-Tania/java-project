import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class Employee extends Frame implements ActionListener{
	private Frame parent;
	private Startup pt;
	public TextField tf;
	public TextField tf2;
	public int C=0;
	public EmployeePanel ep;

	public Employee(Startup sl){
		super("Employee Login");
		pt=sl;
		ep= new EmployeePanel(this);
		Label l10=new Label("Name");
		Label l2=new Label("Password");
		tf=new TextField(20);
		tf2=new TextField(20);
		Button b1=new Button("Login");
		Button b2=new Button("Back");
		add(l10);add(tf);
		add(l2);add(tf2);
		add(b1);add(b2);
		l10.setBounds(30,100,80,25);
		tf.setBounds(120,100,200,30);
		l2.setBounds(30,150,80,25);
		tf2.setBounds(120,150,200,30);
		b1.setBounds(120,220,60,40);
		b2.setBounds(180,220,80,40);
		setSize(600,500);
		setLocation(600,300);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
	
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Login")){
			DataAccess da= new DataAccess();
			String q="";
			String EName=tf.getText();
			String EPassword= tf2.getText();
			ResultSet rs=null;
			try{
				q="select * from employee";
				rs=da.getData(q);
				//System.out.println(rs);
				while(rs.next()){
					C=0;
					String n = rs.getString("EName");
					String p= rs.getString("EPassword");
					if(n.equals(EName) && p.equals(EPassword)){
					
						JOptionPane.showMessageDialog(this,"Correct Cred.");
						C++;
						this.setVisible(false);
			                ep.setParent(this);
			                ep.setVisible(true);
				}
							
							
			
			}
			if(C==0){
								JOptionPane.showMessageDialog(this,"Wrong Username or Password");
							}
		}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
if(s.equals("Back")){
			this.setVisible(false);
			parent.setVisible(true);
		}		
			
	}
	public void setParent(Frame f){parent=f;}
	}
	
