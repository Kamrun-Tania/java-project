import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Orderproduct extends Frame implements ActionListener{
	private TextArea ta;
	private Frame parent;
	private DeliverymanPanel dp;
	public static int c=0;
	public Orderproduct(DeliverymanPanel pz){
	super("Orderproduct List");
	dp=pz;
	DataAccess da=new DataAccess();ResultSet rs=null;
	rs=da.getData("select * from order_product");
	try{
	while(rs.next()){
				c++;
			}
	}catch(Exception ex){ex.printStackTrace();}
	Label l=new Label("Showing order_product List");
	ta=new TextArea(c,30);
	Button b=new Button("Show");
	Button b2=new Button("Exit");
	Button b3=new Button("Back");
	add(l);add(ta);
	add(b);add(b2);add(b3);
	b.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	setLayout(new FlowLayout());
	setSize(400,400);
	setLocation(800,200);
	}
	
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(ta.getText());
		ta.setText("");
		if(s.equals("Show")){
			try{
				DataAccess da=new DataAccess();ResultSet rs=null;
				rs=da.getData("select * from order_product");
				while(rs.next()){
					String str="Customer Name  : "+rs.getString("Customer_Name")+"Delivery_Address : "+rs.getString("Delivery_Address")+"Email : "+rs.getString("Email")+"Product_Name : "+rs.getString("Product_Name");
					ta.append(str+"\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
			
		}
		else if(s.equals("Exit")){
			System.exit(0);
		}
		else if(s.equals("Back")){
			this.setVisible(false);
			parent.setVisible(true);
		}
	}
	public void setParent(Frame f){parent=f;}
}