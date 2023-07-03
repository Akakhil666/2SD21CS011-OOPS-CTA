import java.awt.Color;
import java.awt.GridLayout;                               //these are the imports to be included
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Oops extends JFrame implements ActionListener{              //this is a class oops which implements ActionListner
float cie;                                            //this also uses the interface 
float res;
String g;



JLabel l1=new JLabel("Grade Calculator");              //instantiation of labels
JLabel l2=new JLabel("Enter IA-1 Marks");
JLabel l3=new JLabel("Enter IA-2 Marks");
JLabel l4=new JLabel("Enter IA-3 Marks");
JLabel l5=new JLabel("Enter CTA Marks");
JLabel l6=new JLabel("Enter SEE Marks");
JLabel l8=new JLabel("TOTAL MARKS:",JLabel.RIGHT);     
JLabel l9=new JLabel("grade:",JLabel.RIGHT);
JLabel l10=new JLabel("");
JLabel l11=new JLabel("");
JLabel l12=new JLabel("invalid marks:");

JPanel p1=new JPanel();                        	        //instantiation of panels
JPanel p2=new JPanel();
JPanel p3=new JPanel();
JPanel p4=new JPanel();                             
JPanel p5=new JPanel();
JPanel p6=new JPanel();
JPanel p7=new JPanel();
JPanel p8=new JPanel();
JPanel p9=new JPanel();
JPanel p10=new JPanel();

JButton b1=new JButton("SUBMIT");                       //instantiation of buttons
JButton b2=new JButton("CHECK ELIGIBILITY");

JTextField f1 =new JTextField(10);                       //instantiation of textFields
JTextField f2 =new JTextField(10);
JTextField f3 =new JTextField(10);
JTextField f4 =new JTextField(10);
JTextField f5 =new JTextField(10);


public Oops() {
super("Students grading system");
b1.setSize(100,100);                                  //setting the size and color of 
l8.setForeground(Color.green);
l9.setForeground(Color.green);
l10.setForeground(Color.green);
l11.setForeground(Color.green);
setVisible(true);
setBounds(200,200,500,500);


p1.add(l1);                                            //adding labels to the panels

p2.add(l2);
p2.add(f1);

p3.add(l3);
p3.add(f2);

p4.add(l4);
p4.add(f3);

p5.add(l5);
p5.add(f4);

p10.add(b2);

p6.add(l6);
p6.add(f5);

p7.add(b1);                                  //adding button to the panel

p8.add(l8);
p8.add(l10);
p8.add(l9);
p8.add(l11);
p9.add(l12);

add(p1);                                   //adding the panel to the frame
add(p2);
add(p3);
add(p4);
add(p5);
add(p10);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new GridLayout(10, 0));
p8.setLayout(new GridLayout(0, 4));
b1.addActionListener(this);                    //adding the actionListener
	b2.addActionListener(this);
}

public static void main(String[] args) {
	new Oops();                                      //calling the constructor


}

public void actionPerformed(ActionEvent e) {           //overridden actionPerformed method
int ia1,ia2,ia3,cta;
if(e.getSource()==b2) {
	if(f1.getText().isEmpty()) {                    //reading the inputs of ia-1
		ia1=0;                                      //ia-2 and ia-3 and cta
	}else {
		ia1=Integer.parseInt(f1.getText());}
	if(f2.getText().isEmpty()) {
		ia2=0; 
		
	}else {
		ia2=Integer.parseInt(f2.getText());}
	if(f3.getText().isEmpty()) { 
		ia3=0;
	}else {
		ia3=Integer.parseInt(f3.getText());}
	if(f4.getText().isEmpty()) {
		cta=0;
	}else {
		cta=Integer.parseInt(f4.getText());}

	if(ia1<=ia2 && ia1<=ia3)                          //calculating the best of two ia's
		cie=ia2+ia3;
	if(ia2<=ia1 && ia2<=ia3)
		cie=ia1+ia3;
	if(ia3<=ia1 && ia3<=ia2)
		cie=ia2+ia1;

	try {
		if(ia1<0 || ia1>20 ||ia2<0 || ia2>20 ||ia3<0 || ia3>20 ||cta<0 || cta>10 ) { 
			throw new ArithmeticException();             //throwing the exception 
		}}
	catch(ArithmeticException ae) {
		JOptionPane.showMessageDialog(this, l12, "error",JOptionPane.ERROR_MESSAGE);
		return ;
	}

	cie=cie+cta;

	try {
		if(cie<20) {
			throw new ArithmeticException();
		}}
	catch(ArithmeticException ae) {
		JOptionPane.showMessageDialog(this, "STUDENT IS DETAINED FROM SEE", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		return;
	}

}
add(p6);
add(p7);
setBounds(200,200,499,499);

if(e.getSource()==b1) {
	int see;
	l11.setForeground(Color.green);

	if(f5.getText().isEmpty())see=0;
	else {
		see=Integer.parseInt(f5.getText());
	}
	add(p8);

	if(see<0 || see>100) {
		//add(p9);
		setBounds(200,200,499,499);
		JOptionPane.showMessageDialog(this, l12, "error",JOptionPane.ERROR_MESSAGE);
		l8.setText("");
		l9.setText("");
		l10.setText("");
		l11.setText("");
		return ;
	}
	if(see==38 || see==39) {                     //updating see to 40 if it is 38/39
		see=40;
	}

	if(see<38) {                                 //printing f grade if see is less than 38
		l11.setText("F");
		l11.setForeground(Color.red);
		l8.setText("");
		l10.setText("");
		return;
	}

	l8.setText("TOTAL MARKS:");
	res=(float) Math.ceil(cie+(see/2));

	String tot=Double.toString(res);

	l10.setText(tot);

	if(res<=100 && res>=90) {                       //calculating grade
		g="S";
	}
	if(res<=89 && res>=80) {
		g="A";
	}
	if(res<=79 && res>=70) {
		g="B";
	}
	if(res<=69 && res>=60) {
		g="C";
	}
	if(res<=59 && res>=50) {
		g="D";
	}
	if(res<=49 && res>=40) { 
		g="E";
	}if(res<=39 ) {
		g="F";
				l11.setForeground(Color.red);
			}

			l11.setText(g);

		}
	}
}