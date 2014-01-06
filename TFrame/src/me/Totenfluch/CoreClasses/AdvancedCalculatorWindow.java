package me.Totenfluch.CoreClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AdvancedCalculatorWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public static boolean AdvancedCalculatorWindowActive = false;
	private String input = "";
	private JTextField Number;
	private JButton MathPlus;
	private JButton MathMinus;
	private JButton Mathtimes;
	private JButton Mathdivide;
	private JButton MathWurzel;
	private JButton MathPercent;
	private JButton Mathcos;
	private JButton Mathsin;
	private JButton Mathtan;
	private JButton Mathxupx;
	private JButton Math1dividedx;
	private JButton closebracket;
	private JButton Clear;
	private JButton ZERO;
	private JButton ONE;
	private JButton TWO;
	private JButton THREE;
	private JButton FOUR;
	private JButton FIVE;
	private JButton SIX;
	private JButton SEVEN;
	private JButton AIGHT;
	private JButton NINE;
	private JButton Calculate;
	private JButton ans;
	private int Stage = 1;
	private boolean Stage1done = false;
	private boolean Stage2done = false;
	private boolean Stage3done = false;
	private double result = 0;


	public AdvancedCalculatorWindow(){
		super("Advaned Calculator");

		setSize(350, 200);
		setVisible(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setLayout(new BorderLayout());
		JLabel background=new JLabel(ResourceLoader.Iconload("/Dragon.jpg"));
		background.setSize(400, 300);
		add(background);
		background.setLayout(new FlowLayout());

		Number = new JTextField(20);
		Number.setForeground(Color.magenta);
		Number.setFont(new Font("Serif", Font.BOLD, 20));
		Number.setEditable(false);
		background.add(Number);


		MathPlus = new JButton("+");
		background.add(MathPlus);

		MathMinus = new JButton("-");
		background.add(MathMinus);

		Mathtimes = new JButton("*");
		background.add(Mathtimes);

		Mathdivide = new JButton("/");
		background.add(Mathdivide);

		MathWurzel = new JButton("√");
		background.add(MathWurzel);

		MathPercent = new JButton("%");
		background.add(MathPercent);

		Mathcos = new JButton("cos");
		background.add(Mathcos);

		Mathsin = new JButton("sin");
		background.add(Mathsin);

		Mathtan = new JButton("tan");
		background.add(Mathtan);

		Mathxupx = new JButton("x UP x");
		background.add(Mathxupx);

		Math1dividedx = new JButton("x / 1");
		background.add(Math1dividedx);

		Clear = new JButton("Clear");
		background.add(Clear);

		closebracket = new JButton(")");
		background.add(closebracket);

		ZERO = new JButton("0");
		background.add(ZERO);

		ONE = new JButton("1");
		background.add(ONE);

		TWO = new JButton("2");
		background.add(TWO);

		THREE = new JButton("3");
		background.add(THREE);

		FOUR = new JButton("4");
		background.add(FOUR);

		FIVE = new JButton("5");
		background.add(FIVE);

		SIX = new JButton("6");
		background.add(SIX);

		SEVEN = new JButton("7");
		background.add(SEVEN);

		AIGHT = new JButton("8");
		background.add(AIGHT);

		NINE = new JButton("9");
		background.add(NINE);

		ans = new JButton("ANS");
		background.add(ans);

		Calculate = new JButton("Calculate");
		background.add(Calculate);

		thehandler handler = new thehandler();
		Clear.addActionListener(handler);
		ZERO.addActionListener(handler);
		ONE.addActionListener(handler);
		TWO.addActionListener(handler);
		THREE.addActionListener(handler);
		FOUR.addActionListener(handler);
		FIVE.addActionListener(handler);
		SIX.addActionListener(handler);
		SEVEN.addActionListener(handler);
		AIGHT.addActionListener(handler);
		NINE.addActionListener(handler);
		MathPlus.addActionListener(handler);
		MathMinus.addActionListener(handler);
		Mathcos.addActionListener(handler);
		Mathsin.addActionListener(handler);
		Mathtan.addActionListener(handler);
		Mathtimes.addActionListener(handler);
		Mathdivide.addActionListener(handler);
		MathWurzel.addActionListener(handler);
		MathPercent.addActionListener(handler);
		Math1dividedx.addActionListener(handler);
		Mathxupx.addActionListener(handler);
		Calculate.addActionListener(handler);
		ans.addActionListener(handler);
	}

	private class thehandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {

			if(input.equals("")){
				Stage = 1;
			}
			if(Stage == 1 || Stage == 3){
				if(event.getSource() == ZERO){
					input = input + "0";
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}
				if(event.getSource() == ONE){
					input = input + "1";
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}
				if(event.getSource() == TWO){
					input = input + "2";
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}
				if(event.getSource() == THREE){
					input = input + "3";
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}
				if(event.getSource() == FOUR){
					input = input + "4";
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}
				if(event.getSource() == FIVE){
					input = input + "5";
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}
				if(event.getSource() == SIX){
					input = input + "6";
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}
				if(event.getSource() == SEVEN){
					input = input + "7";
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}
				if(event.getSource() == AIGHT){
					input = input + "8";
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}
				if(event.getSource() == NINE){
					input = input + "9";
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}

				if(event.getSource() == ans){
					input = input + result;
					Stage1done = true;
					if(Stage2done == true){
						Stage3done = true;
					}
				}
			}

			if(event.getSource() == Clear){
				input = "";
				Stage1done = false;
				Stage2done = false;
				Stage3done = false;
				Stage = 1;
			}

			if(Stage1done == true && Stage2done == false){
				if(event.getSource() == MathPlus){
					input = input + "+";
					Stage2done = true;
				}
				if(event.getSource() == MathMinus){
					input = input + "-";
					Stage2done = true;
				}
				if(event.getSource() == Mathtimes){
					input = input + "*";
					Stage2done = true;
				}
				if(event.getSource() == Mathdivide){
					input = input + "/";
					Stage2done = true;
				}
				if(event.getSource() == MathWurzel){
					input = input + "√";
					Stage2done = true;
				}			
				if(event.getSource() == Mathsin){
					input = input + "sin(";
					Stage2done = true;
				}
				if(event.getSource() == Mathcos){
					input = input + "cos(";
					Stage2done = true;
				}
				if(event.getSource() == Mathtan){
					input = input + "tan(";
					Stage2done = true;
				}
				if(event.getSource() == closebracket){
					input = input + ")";
					Stage2done = true;
				}
				if(event.getSource() == Mathxupx){
					input = input + "^";
					Stage2done = true;
				}
			}



			// instacalc

			if(event.getSource() == Calculate && Stage3done == true){
				if(input.contains("+")){
					String[] calcme = input.split("\\+");
					result = Double.valueOf(calcme[0]) + Double.valueOf(calcme[1]);
					input = String.valueOf(result);

				}else if(input.contains("-")){
					String[] calcme = input.split("\\-");
					result = Double.valueOf(calcme[0]) - Double.valueOf(calcme[1]);
					input = String.valueOf(result);

				}else if(input.contains("*")){
					String[] calcme = input.split("\\*");
					result = Double.valueOf(calcme[0]) * Double.valueOf(calcme[1]);
					input = String.valueOf(result);

				}else if(input.contains("/")){
					String[] calcme = input.split("\\/");
					result = Double.valueOf(calcme[0]) / Double.valueOf(calcme[1]);
					input = String.valueOf(result);

				}else if(input.contains("^")){
					String[] calcme = input.split("\\^");
					result = Math.pow(Double.valueOf(calcme[0]), Double.valueOf(calcme[1]));
					input = String.valueOf(result);

				}


				Stage2done = false;
				Stage3done = false;
			}

			Number.setText(input);
		}
	}
}