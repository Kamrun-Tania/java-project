import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;


public class DeliverymanPanel extends Frame implements ActionListener{
	private Frame parent;
    public DeliverymanUI ut;
    public Orderproduct Od;
	public DeliverymanPanel(){}
	public DeliverymanPanel(DeliverymanUI kj){
		super("DeliverymanPanel");
		ut=kj;
		Od=new Orderproduct(this);
	  
		Button b1=new Button("Order Product");
        Button b2=new Button("Logout");
		b1.setBounds(50,150,100,70);
		b2.setBounds(150,150,100,70);
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		add(b1);add(b2);
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
		
		if(s.equals("Order Product")){
			this.setVisible(false);
			Od.setVisible(true);
			Od.setParent(this);
			
		}
		
}
public void setParent(Frame f){parent=f;}
}