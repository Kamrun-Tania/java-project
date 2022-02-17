import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Userlist extends Frame implements ActionListener{
	private TextArea ta;
	private Frame parent;
	private Adminpanel add;
	public static int c=0;
	public Userlist(Adminpanel p){
	super("User List");
	add=p;
	DataAccess da=new DataAccess();ResultSet rs=null;
	rs=da.getData("select * from customer");
	try{
	while(rs.next()){
				c++;
			}
	}catch(Exception ex){ex.printStackTrace();}
	Label l=new Label("Showing Customer List");
	ta=new TextArea(c,30);
	Button b=new Button("Show");
	Button b2=new Button("Exit");
	Button b3=new Button("Back to Admin Panel");
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
				rs=da.getData("select * from customer");
				while(rs.next()){
					String str="Customer Name  : "+rs.getString("CUserName")+"Password : "+rs.getString("CPassword")+"Address : "+rs.getString("CAddress")+"Email : "+rs.getString("CEmail");
					ta.append(str+"\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
			//ta.append("my text\n");
		}
		else if(s.equals("Exit")){
			System.exit(0);
		}
		else if(s.equals("Back to Admin Panel")){
			this.setVisible(false);
			parent.setVisible(true);
		}
	}
	public void setParent(Frame f){parent=f;}
}