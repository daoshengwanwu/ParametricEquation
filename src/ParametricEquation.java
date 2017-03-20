/**
 * @author 白浩然
 * 程序名：参数方程图像绘制工具
 * 版本：1.1
 */


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;

public class ParametricEquation {
	public static void main(String[] args) {// 程序入口
		ParametricEquation pte = new ParametricEquation();
		pte.go();
		Socket s = null;
		java.net.ServerSocket ss = null;
	}// main

	private GUI gui;
	private MGraphics grap;
	private String oldXExpression;
	private String oldYExpression;
	private double oldTStart;
	private double oldTEnd;

	public ParametricEquation() {
		gui = new GUI();
		grap = new MGraphics();

	}// con_ParametricEquation

	public void go() {
		DrawListener DL = new DrawListener();
		ClearListener CL = new ClearListener();
		CoorderListener CDL = new CoorderListener();
		ResetListener RL = new ResetListener();

		gui.setupGUI();
		gui.getPanelById("mainPanel").add(grap);

		gui.getButtonById("draw").addMouseListener(DL);
		gui.getButtonById("clear").addMouseListener(CL);
		gui.getButtonById("coorder").addMouseListener(CDL);
		gui.getButtonById("reset").addMouseListener(RL);

		grap.setBounds(0, 0, 801, 801);
		grap.setCoorder(-5, -5, 5, 5);
		grap.repaint();

	}// go

	class DrawListener implements MouseListener {// 内部类， 绘制按钮监听者

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			String xParametricInput = gui.getLabelById("xParametricInput").getInput();
			String yParametricInput = gui.getLabelById("yParametricInput").getInput();
			double tStart = Calculator.calculate(gui.getLabelById("tStart").getInput());
			double tEnd = Calculator.calculate(gui.getLabelById("tEnd").getInput());
			if (oldXExpression != null && oldYExpression != null && oldXExpression.equals(xParametricInput)
					&& oldYExpression.equals(yParametricInput) && oldTStart == tStart && oldTEnd == tEnd) {
				return;

			} // if
			oldXExpression = xParametricInput;
			oldYExpression = yParametricInput;
			oldTStart = tStart;
			oldTEnd = tEnd;


			double xStart = Calculator.calculate(gui.getLabelById("xStart").getInput());
			double xEnd = Calculator.calculate(gui.getLabelById("xEnd").getInput());			
			double yStart = Calculator.calculate(gui.getLabelById("yStart").getInput());
			double yEnd = Calculator.calculate(gui.getLabelById("yEnd").getInput());
			grap.setCoorder(xStart, yStart, xEnd, yEnd);
			xParametricInput = xParametricInput.replaceAll("tan", "A").replaceAll("sqrt", "B").replaceAll("t", "z").replaceAll("A", "tan").replaceAll("B", "sqrt");
			yParametricInput = yParametricInput.replaceAll("tan", "A").replaceAll("sqrt", "B").replaceAll("t", "z").replaceAll("A", "tan").replaceAll("B", "sqrt");

			String temp;
			double dTemp;
			double incr = (tEnd - tStart) / 800 / 32;
			for (double t = tStart; t <= tEnd; t += incr) {
				temp = xParametricInput.replaceAll("z", "(" + t + ")");
				dTemp = Calculator.calculate(temp);
				temp = yParametricInput.replaceAll("z", "(" + t + ")");
				grap.addPoint(dTemp, Calculator.calculate(temp));

			} // for
			grap.repaint();
			System.gc();

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	class ClearListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			grap.clear();
			oldXExpression = null;
			oldYExpression = null;

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	class CoorderListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			double xStart = Calculator.calculate(gui.getLabelById("xStart").getInput());
			double xEnd = Calculator.calculate(gui.getLabelById("xEnd").getInput());
			double yStart = Calculator.calculate(gui.getLabelById("yStart").getInput());
			double yEnd = Calculator.calculate(gui.getLabelById("yEnd").getInput());
			oldXExpression = null;
			oldYExpression = null;
			grap.setCoorder(xStart, yStart, xEnd, yEnd);
			grap.repaint();
			

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	class ResetListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			MLabel input = gui.getLabelById("xParametricInput");
			input.setText(" x = ");
			input.setInput("");
			input.setShow("");

			input = gui.getLabelById("yParametricInput");
			input.setText(" y = ");
			input.setInput("");
			input.setShow("");

			input = gui.getLabelById("tStart");
			input.setText("-5");
			input.setInput("-5");
			input.setShow("-5");

			input = gui.getLabelById("tEnd");
			input.setText("5");
			input.setInput("5");
			input.setShow("5");

			input = gui.getLabelById("xStart");
			input.setText("-5");
			input.setInput("-5");
			input.setShow("-5");

			input = gui.getLabelById("xEnd");
			input.setText("5");
			input.setInput("5");
			input.setShow("5");

			input = gui.getLabelById("yStart");
			input.setText("-5");
			input.setInput("-5");
			input.setShow("-5");

			input = gui.getLabelById("yEnd");
			input.setText("5");
			input.setInput("5");
			input.setShow("5");
			
			oldXExpression = null;
			oldYExpression = null;

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}// class_ParametricEquation