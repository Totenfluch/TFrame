package me.Totenfluch.CoreClasses;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CalculatorWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public static boolean CalculatorWindowActive = false;
	private JTextField Number1;
	private JTextField Number2;
	private JButton StartCalculating1;
	private JTextField output1;
	private JLabel lNumber1;
	private JLabel loperator;
	private JLabel lNumber2;
	@SuppressWarnings("rawtypes")
	private JComboBox operatorbox;


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CalculatorWindow(){
		super("Simple Calculator");
		
		setSize(350, 200);
		setVisible(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		setLayout(new FlowLayout());
		output1 = new JTextField(30);
		output1.setEditable(false);
		add(output1);
		Number1 = new JTextField(10);
		add(Number1);
		String[] option = { "+", "-", "*", "/"};
		operatorbox = new JComboBox(option);
		add(operatorbox);
		Number2 = new JTextField(10);
		add(Number2);
		lNumber1 = new JLabel("First Number");
		add(lNumber1);
		loperator = new JLabel("       math operator");
		add(loperator);
		lNumber2 = new JLabel("Secound Number");
		add(lNumber2);
		StartCalculating1 = new JButton("Calculate");
		add(StartCalculating1);

		thehandler handler = new thehandler();
		Number1.addActionListener(handler);
		Number1.addActionListener(handler);
		StartCalculating1.addActionListener(handler);
		operatorbox.addActionListener(handler);

	}

	private class thehandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == StartCalculating1){
				String sNumber1 = Number1.getText();
				String sNumber2 = Number2.getText();
				double iNumber1 = Integer.parseInt(sNumber1);
				double iNumber2 = Integer.parseInt(sNumber2);

				if(operatorbox.getSelectedItem().equals("+")){
					double result = iNumber1 + iNumber2;
					String ssoutput = String.valueOf(result);
					output1.setText(ssoutput);
				}else if(operatorbox.getSelectedItem().equals("-")){
					double result = iNumber1 - iNumber2;
					String ssoutput = String.valueOf(result);
					output1.setText(ssoutput);
				}else if(operatorbox.getSelectedItem().equals("*")){
					double result = iNumber1 * iNumber2;
					String ssoutput = String.valueOf(result);
					output1.setText(ssoutput);
				}else if(operatorbox.getSelectedItem().equals("/")){
					double result = iNumber1 / iNumber2;
					String ssoutput = String.valueOf(result);
					output1.setText(ssoutput);
				}else{
					output1.setText("INVALID Operator/First Number/Secoundary Number");
				}
			}

		}
	}		
}