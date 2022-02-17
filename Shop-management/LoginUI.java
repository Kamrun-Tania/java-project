import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


//java API documentation
class LoginUI  extends Frame implements ActionListener{
	private Frame parent;
	private TextField tf;
	private TextField tf2;
	private static int C=0;
	public Startup stg;
	public CustomerUI u;
	public Signup reg;
	public Employee em;
	public LoginUI(Startup lg){
		super("LoginUI Window");
		stg=lg;
		reg= new Signup(this);
		u= new CustomerUI (this); 
		Label l=new Label("Email  :");
		Label l2=new Label("Password  :");
		tf=new TextField(20);
		tf2=new TextField(20);
		Button b=new Button("Login");
		Button b1=new Button("Register");
		Button b2=new Button("Back");
		
	
     	add(l);add(tf);
		add(l2);add(tf2);
		add(b);add(b1);add(b2);
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setSize(300,400);
		setLayout(new FlowLayout());
		
	}
		public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Login")){
			DataAccess da= new DataAccess();
			String q="";
			String CEmail=tf.getText();
			String CPassword= tf2.getText();
			ResultSet rs=null;
			try{
				q="select * from customer";
				rs=da.getData(q);
				
				while(rs.next()){
					
					C=0;
					String n = rs.getString("CEmail");
					String p= rs.getString("CPassword");
					if(n.equals(CEmail) && p.equals(CPassword)){
						//System.out.println("Correct Cred.");
						JOptionPane.showMessageDialog(this,"Correct Cred.");
						C++;
						//break;
						
						
							this.setVisible(false);
			                u.setParent(this);
			                u.setVisible(true);
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
		else if(s.equals("Register")){
			this.setVisible(false);
			reg.setParent(this);
			reg.setVisible(true);	
	}
	else if(s.equals("Back")){
			this.setVisible(false);
			parent.setVisible(true);
		}

	}
	public void setParent(Frame f){parent=f;}
}


