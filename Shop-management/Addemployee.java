import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Addemployee extends Frame implements ActionListener{
	private Frame parent;
	private int Count=0;
	private Adminpanel ap;
	public TextField tf[];
	public Addemployee()
	{}
	    public Addemployee(Adminpanel epm){
	    super("Recruit Employee");
		
		
	    ap=epm;
		
		
		Label e1=new Label("Name: " );
		Label e2=new Label("Password : ");
		Label e3=new Label("Phone :");
		Label e4=new Label("Role :");
		Label e5=new Label("Gander :");
		Label e6=new Label("Salary : ");
		
		Button b3=new Button("Register");
		b3.setBounds(60,500,60,40);
		b3.addActionListener(this);
		
		
		Button b4=new Button("Back");
		b4.setBounds(120,500,60,40);
		b4.addActionListener(this);
		
		tf=new TextField[6];
		for(int i=0;i<6;i++)
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
		e6.setBounds(60,350,80,25);
		tf[5].setBounds(170,350,350,30);
		
	    add(e1);add(tf[0]);
		add(e2);add(tf[1]);
		add(e3);add(tf[2]);
		add(e4);add(tf[3]);
		add(e5);add(tf[4]);
		add(e6);add(tf[5]);
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
			for(int i=0;i<6;i++){
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
			
			String EName=tf[0].getText();
			String EPassword=tf[1].getText();
			String EPhone=tf[2].getText();
			String role=tf[3].getText();
			String Gander=tf[4].getText();
			String salary=tf[5].getText();
			
			String q="Insert into employee values(NULL,'"+EPhone+"','"+EPassword+"','"+EName+"','"+role+"','"+salary+"','"+Gander+"')";
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
