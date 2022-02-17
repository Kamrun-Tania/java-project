import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


//java API documentation
class DeliverymanUI extends Frame implements ActionListener{
	private Frame parent;
	private TextField tf;
	private TextField tf2;
	private Startup dt;
	public DeliverymanPanel dp;
	private static int C=0;
	public DeliverymanUI(Startup lw){
		super("DeliverymanUI Window");
		dp= new DeliverymanPanel(this);
		dt=lw;
		Label l=new Label("Name  : ");
		Label l2=new Label("Password  :");
		tf=new TextField(20);
		tf2=new TextField(20);
		Button b=new Button("Login");
		Button b1=new Button("Back to Home");
		
	
     	add(l);add(tf);
		add(l2);add(tf2);
		add(b);add(b1);
		b.addActionListener(this);
		b1.addActionListener(this);
	
		setSize(300,400);
		setLayout(new FlowLayout());
		
	}
		public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Login")){
			DataAccess da= new DataAccess();
			String q="";
			String DName=tf.getText();
			String DPassword= tf2.getText();
			ResultSet rs=null;
			try{
				q="select * from delivery_man ";
				rs=da.getData(q);
				
				while(rs.next()){
					
					C=0;
					String n = rs.getString("DName");
					String p= rs.getString("DPassword");
					if(n.equals(DName) && p.equals(DPassword)){
						//System.out.println("Correct Cred.");
						JOptionPane.showMessageDialog(this,"Correct Cred.");
						C++;
						//break;
						
			         this.setVisible(false);
			         dp.setVisible(true);
			         dp.setParent(this);
	
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
		else if(s.equals("Back to Home")){
		this.setVisible(false);
			parent.setVisible(true);
	

	}

	
}

	public void setParent(Frame f){parent=f;}
}