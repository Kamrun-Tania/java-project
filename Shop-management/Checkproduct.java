import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;
import java.lang.*;
import java.sql.ResultSet;
public class Checkproduct extends Frame implements ActionListener{
	private TextArea ta;
	private Frame parent;
	private EmployeePanel fx;
    public static int c=0;
	public Checkproduct() {}
	public Checkproduct(EmployeePanel tx){
		
		super("Product List");
		fx=tx;
		DataAccess da=new DataAccess();ResultSet rs=null;
		rs=da.getData("select * from product");
		try{
	while(rs.next()){
				c++;
			}
	}catch(Exception ex){ex.printStackTrace();}
		
	
		Label l=new Label("Data From DB");
		ta=new TextArea(5,30);
		Button b=new Button("Show");
		Button b2=new Button("Exit");
		Button b3= new Button ("Back");
		
		
		add(l);add(ta);
		add(b);add(b2);add(b3);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(270,400);
		setLocation(800,200);
		
		
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();

		System.out.println(ta.getText());
		ta.setText("");
		
		if(s.equals("Show")){
			
			try{
				DataAccess da=new DataAccess();
				ResultSet rs=null;
				String q="";
				
				q= "select * from product";
				rs=da.getData(q);
				
				while(rs.next()){
					String str="Price  : "+rs.getString("price")+"Catagorgy  : "+rs.getString("catagory")+"Product Name  : "+rs.getString("Product_name")+"Availablity  : "+rs.getString("availablity")+"Buy_Price  : "+rs.getString("Buy_Price");
					ta.append(str+"\n");
				}
			}
			catch(Exception ex){ex.printStackTrace();}
		;
		}
		else if(s.equals("Exit")){
			System.out.println("e");
			System.exit(0);
			System.out.println("d");
		}
		if(s.equals("Back")){
			this.setVisible(false);
			parent.setVisible(true);
		}
	}
	public void setParent(Frame f){parent=f;}
}