import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class DeleteEmployee extends Frame implements ActionListener{
	private Frame parent;
	private int Count=0;
	private Adminpanel dap;
	public TextField tf[];
	public DeleteEmployee()
	{}
	    public DeleteEmployee(Adminpanel dpm){
	    super("Delete Employee");
		
		
	    dap=dpm;
		
		
		Label e1=new Label("E_id: " );

		
		Button b3=new Button("Delete");
		b3.setBounds(60,200,60,40);
		b3.addActionListener(this);
		
		
		Button b4=new Button("Back");
		b4.setBounds(120,200,60,40);
		b4.addActionListener(this);
		
		tf=new TextField[1];
		for(int i=0;i<1;i++)
		{
			tf[i]=callTextfield(i);
		}
		e1.setBounds(60,100,80,25);
		tf[0].setBounds(170,100,350,30);

		
	    add(e1);add(tf[0]);
		add(b4);add(b3);
		
		
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
		else if(s.equals("Delete")){
			this.setVisible(false);
			parent.setVisible(true);
			for(int i=0;i<1;i++){
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
			
			String E_id=tf[0].getText();
			
		String q="DELETE FROM employee WHERE employee.E_id =('"+E_id+"')";
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
