import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


//java API documentation
class Startup extends Frame implements ActionListener{

	private static int C=0;
    public AdminUI xy;
	public LoginUI cy;
	public Employee om;
	public DeliverymanUI De;
	public Startup(){
		super("Startup Window");
		 xy=new AdminUI(this);
		 cy= new LoginUI(this);
		 om= new Employee(this);
		 De=new DeliverymanUI(this);
		Button b=new Button("Admin Login");
		Button b1=new Button("Customer Login");
		Button b2= new Button("Employee Login");
		Button b3= new Button("Deliveryman Login");
		
	
     	
		add(b);add(b1);
		add(b2);add(b3);
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	
		setSize(300,400);
		setLayout(new FlowLayout());
		setVisible(true);
	}
		public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Admin Login")){
		 this.setVisible(false);
		xy.setParent(this);
		xy.setVisible(true); }
		else if (s.equals("Customer Login")){
		 this.setVisible(false);
		cy.setParent(this);
		cy.setVisible(true); }
		else if (s.equals("Employee Login")){
		 this.setVisible(false);
		om.setParent(this);
		om.setVisible(true); }
		else if (s.equals("Deliveryman Login")){
		 this.setVisible(false);
		De.setParent(this);
		De.setVisible(true); }
	

	}
	
}


