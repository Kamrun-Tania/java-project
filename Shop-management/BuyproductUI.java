import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;
import java.lang.*;
import javax.swing.*;
import java.sql.ResultSet;
public class BuyproductUI extends Frame implements ActionListener{
	private Frame parent;
	private CustomerUI k;
	public TextField tf[];
	private int Count=0;

public BuyproductUI(CustomerUI l) {

super("BuyproductUI");
k=l;
		Label l1=new Label("Product Name: " );
		Label l2=new Label("Customer Name :" );
		Label l3=new Label("Email :");
		Label l4=new Label("Phone :");
		Label l5=new Label("Delivery Address :");
		
		
	
		tf=new TextField[5];
		for(int i=0;i<5;i++)
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
		
		Button c=new Button("Confirm");
		c.addActionListener(this);
		c.setBounds(120,500,60,40);
		
		Button b4=new Button("Back");
		b4.setBounds(120,200,60,40);
		b4.addActionListener(this);
		
		
		
		add(l1);add(tf[0]);
		add(l2);add(tf[1]);
		add(l3);add(tf[2]);
		add(l4);add(tf[3]);
		add(l5);add(tf[4]);
		
		
		add(c);add(b4);
		
		setSize(700,600);
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
	
		 if(s.equals("Confirm")){
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
			
			String Product_Name =tf[0].getText();
			String Customer_Name=tf[1].getText();
			String Email =tf[2].getText();
			String Phone=tf[3].getText();
			String Delivery_Address=tf[4].getText();
			
			String q="insert into order_product values(NULL,'"+Product_Name +"','"+Customer_Name+"','"+Email+"','"+Phone+"','"+Delivery_Address+"')";
			da.updateDB(q);
			}
			else{
				System.out.println("you have click No ");
			}
			}
		}
		else if(s.equals("Back")){
			this.setVisible(false);
			parent.setVisible(true);
		}
	}
public void setParent(Frame f){parent=f;}
}
