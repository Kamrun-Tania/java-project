import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerUI extends Frame implements ActionListener{
	private Frame parent;
	private int Count=0;
	private LoginUI L;
	public Viewproduct v;
	public BuyproductUI k;
	public CustomerChangepass cck;
	private static int C=0;
	public CustomerUI() {}
	
 	public CustomerUI(LoginUI p){
		
		
		super("Customer UI");
		L=p;
		cck= new CustomerChangepass(this);
		v=new Viewproduct(this);
		k= new BuyproductUI(this);
		
		Button c=new Button("Product list");
		Button g=new Button("Buy product");
		Button mob=new Button ("Change Password");
	    Button d=new Button("Cancel");
		
		c.addActionListener(this);
		g.addActionListener(this);
		mob.addActionListener(this);
		d.addActionListener(this);
	
		
		
		
		add(c);
		add(d);
		add(mob);
		add(g);
		
		
		
		
		setSize(300,400);
		setLayout(new FlowLayout());
	
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Product list")){
			this.setVisible(false);
			v.setParent(this);
			v.setVisible(true);
			
		} 
		
		
		else if(s.equals("Buy product"))
		{
			this.setVisible(false);
			k.setParent(this);
			k.setVisible(true);
		}


          else if(s.equals("Cancel")){
			System.exit(0);}
	
		else if(s.equals("Change Password"))
		{
			this.setVisible(false);
			cck.setParent(this);
			cck.setVisible(true);
		}


	}

public void setParent(Frame f){parent=f;}

}