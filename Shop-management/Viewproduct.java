import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;
import java.lang.*;
import java.sql.ResultSet;
public class Viewproduct extends Frame implements ActionListener{
	private TextArea ta;
	private Frame parent;
	private CustomerUI f;
    public static int c=0;
	public Viewproduct() {}
	public Viewproduct(CustomerUI t){
		
		super("Product List");
		f=t;
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
		add(l);add(ta);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(270,400);
		setLocation(800,200);
		//setVisible(true);
		
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
				//q="select * from product";
				
				q= "select price,catagory,Product_name,availablity from product";
				rs=da.getData(q);
				
				while(rs.next()){
					String str="Price  : "+rs.getString("price")+"Catagorgy  : "+rs.getString("catagory")+"Product Name  : "+rs.getString("Product_name")+"Availablity  : "+rs.getString("availablity");
					ta.append(str+"\n");
				}
			}
			catch(Exception ex){ex.printStackTrace();}
			//ta.append("my text\n");
		}
		else if(s.equals("Exit")){
			System.out.println("e");
			System.exit(0);
			System.out.println("d");
		}
	}
	public void setParent(Frame f){parent=f;}
}