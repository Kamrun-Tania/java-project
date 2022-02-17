import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;


public class Adminpanel extends Frame implements ActionListener{
	private Frame parent;
	private AdminUI a;
    public Userlist user;
	public Employeelist el;
	public Addemployee z;
	public AddDeliveryman dtp;
	public DeleteEmployee dte;
	public ChangeEmployeepass cep;
	public Adminpanel(){}
	public Adminpanel(AdminUI g){
		super("Admin Panel");
		a=g;
		user=new Userlist(this);
	    el=new Employeelist(this);
		z= new Addemployee(this);
		dtp=new AddDeliveryman(this);
		dte= new DeleteEmployee(this);
		cep= new ChangeEmployeepass(this);
		Button b1=new Button("User List");
		Button b2=new Button("Employee List");
		Button b3=new Button("AddEmployee");
		Button b4=new Button("Add Delivery Man");
	    Button b5=new Button("Logout");
		Button b6=new Button("Delete Employee");
		Button b7=new Button("Password Change Employee");
		b1.setBounds(50,150,100,70);
		b2.setBounds(150,150,100,70);
		b3.setBounds(250,150,100,70);
		b4.setBounds(350,150,100,70);
		b5.setBounds(450,150,100,70);
		b6.setBounds(550,150,100,70);
		b7.setBounds(650,200,150,80);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
		add(b1);add(b2);add(b3);add(b4);
		add(b5);add(b6);add(b7);
		setSize(800,400);
		setLocation(800,400);
		setLayout(null);
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
		if(s.equals("Logout")){
			this.setVisible(false);
			parent.setVisible(true);
		}
		
		if(s.equals("Employee List")){
			this.setVisible(false);
			el.setVisible(true);
			el.setParent(this);
			
		}
		if(s.equals("User List")){
			this.setVisible(false);
			user.setVisible(true);
			user.setParent(this);
			
		}
			else if(s.equals("AddEmployee")){
			this.setVisible(false);
			z.setParent(this);
			z.setVisible(true);
	}
	else if(s.equals("Add Delivery Man")){
			this.setVisible(false);
			dtp.setParent(this);
			dtp.setVisible(true);
	
}
	else if(s.equals("Delete Employee")){
			this.setVisible(false);
			dte.setParent(this);
			dte.setVisible(true);
	
}
else if(s.equals("Password Change Employee")){
			this.setVisible(false);
			cep.setParent(this);
			cep.setVisible(true);
	
}
	}
public void setParent(Frame f){parent=f;}
}