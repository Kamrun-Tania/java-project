import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.sql.*;
import java.sql.SQLException;
import java.sql.ResultSet;


public class EmployeePanel extends Frame implements ActionListener{
	private Frame parent;
	 public static int c=0;
    public Addproduct pro;
	public Employeelist el;
	public Checkproduct ck;
	public Viewproduct v;
	private Employee E;
	public Deleteproduct Dip;
	public EmployeePanel(){}
	public EmployeePanel(Employee ye){

		Dip=new Deleteproduct(this);
		pro=new Addproduct(this);
		ck=new Checkproduct(this);
		Button b1=new Button("Product List");
		Button b2=new Button("Add Product");
		Button b3=new Button("Delete product");
	    Button b5=new Button("Logout");
		b1.setBounds(50,150,100,70);
		b2.setBounds(150,150,100,70);
		b3.setBounds(250,150,100,70);
		//b4.setBounds(350,150,100,70);
		b5.setBounds(450,150,100,70);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		//b4.addActionListener(this);
		b5.addActionListener(this);
		
		add(b1);add(b2);add(b3);//add(b4);
		add(b5);
		setSize(600,400);
		setLocation(600,400);
		setLayout(null);
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
	       if(s.equals("Logout")){
			this.setVisible(false);
			parent.setVisible(true);
		}
		
		else if(s.equals("Add Product")){
				this.setVisible(false);
				pro.setParent(this);
				pro.setVisible(true);
		}
			else if(s.equals("Delete product")){
				this.setVisible(false);
				Dip.setParent(this);
				Dip.setVisible(true);
		}
		else if(s.equals("Product List")){
				this.setVisible(false);
				ck.setParent(this);
				ck.setVisible(true);
		}
		
		
	}
	
public void setParent(Frame f){parent=f;}	
}

