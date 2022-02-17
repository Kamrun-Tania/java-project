import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Addproduct extends Frame implements ActionListener{
	private Frame parent;
	private int Count=0;

	private EmployeePanel empl;
	public TextField tf[];
	public Addproduct()
	{}
	    public Addproduct(EmployeePanel ek){
	    super("ADD Product");
		
		
	   empl=ek;
		
		
		Label e1=new Label("Product_name : " );
		Label e2=new Label("price: ");
		Label e3=new Label("catagory :");
		Label e4=new Label("availablity :");
		Label e5=new Label("Buy_price :");
		
	
		
		Button b3=new Button("Register");
		b3.setBounds(60,500,60,40);
		b3.addActionListener(this);
		
		
		Button b4=new Button("Back");
		b4.setBounds(120,500,60,40);
		b4.addActionListener(this);
		
		tf=new TextField[5];
		for(int i=0;i<5;i++)
		{
			tf[i]=callTextfield(i);
		}
		e1.setBounds(60,100,80,25);
		tf[0].setBounds(170,100,350,30);
		e2.setBounds(60,150,80,25);
		tf[1].setBounds(170,150,350,30);
		e3.setBounds(60,200,100,25);
		tf[2].setBounds(170,200,350,30);
		e4.setBounds(60,250,80,25);
		tf[3].setBounds(170,250,350,30);
		e5.setBounds(60,300,80,25);
		tf[4].setBounds(170,300,350,30);
		
	    add(e1);add(tf[0]);
		add(e2);add(tf[1]);
		add(e3);add(tf[2]);
		add(e4);add(tf[3]);
		add(e5);add(tf[4]);
	
		add(b3); add(b4);
		
		setSize(600,400);
		setLocation(500,300);
		setLayout(null);
		//setVisible(true);
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
			this.setVisible(false);
			parent.setVisible(true);
			for(int i=0;i<5;i++){
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
			
			String Product_name=tf[0].getText();
			String price=tf[1].getText();
			String catagory=tf[2].getText();
			String availablity=tf[3].getText();
			String Buy_price=tf[4].getText();
			
			
			String q="Insert into product values('"+price+"','"+catagory+"','"+Product_name+"','"+availablity+"',Null,'"+Buy_price+"')";
			da.updateDB(q);
			}
			else{
				System.out.println("you have click No ");
			}
			}
		}
		if(s.equals("Back")){
			this.setVisible(false);
			parent.setVisible(true);
		}
	}
	public void setParent(Frame f){parent=f;}
}
