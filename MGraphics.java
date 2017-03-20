import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

class MGraphics extends JPanel {
	// -----------------------------------------------------类体部分----------------------------------------------
	private ArrayList<MPoint> points;
	private int xBase;
	private int yBase;
	private double xStart;// x zhou kai shi
	private double xEnd;// x zhou jie shu
	private double yStart;// y zhou kai shi
	private double yEnd;// y zhou jie shu
	private double xLen;// x eachLen
	private double yLen;// y eachLen

	public MGraphics() {
		points = new ArrayList<MPoint>();
		points.clear();
		xBase = 0;
		yBase = 0;
		xStart = 0.0;
		xEnd = 0.0;
		yStart = 0.0;
		yEnd = 0.0;
		xLen = 0.0;
		yLen = 0.0;

	}// con_MGraphics

	public void paintComponent(Graphics grap) {
		setupCoorder(grap);
		for (int i = 0; i < points.size(); i++) {
			grap.drawLine((int) (yBase + points.get(i).getX() * xLen), (int) (xBase - points.get(i).getY() * yLen),
					(int) (yBase + points.get(i).getX() * xLen), (int) (xBase - points.get(i).getY() * yLen));

		} // for

	}// paintComponent

	public void addPoint(double aX, double aY) {
		MPoint t = new MPoint(aX, aY);
		points.add(t);

	}// addPoint

	public void clear() {
		points.clear();
		repaint();
		System.gc();

	}// clear

	public void setCoorder(double aXStart, double aYStart, double aXEnd, double aYEnd) {
		xStart = aXStart;
		yStart = aYStart;
		xEnd = aXEnd;
		yEnd = aYEnd;

	}// setCoorder

	public void setupCoorder(Graphics grap) {
		grap.setColor(Color.white);
		grap.fillRect(0, 0, getWidth(), getHeight());

		grap.setColor(new Color(0, 128, 255));// 设置天蓝色
		grap.drawLine(800, 0, 800, 800);
		grap.drawLine(0, 0, 800, 0);
		grap.drawLine(0, 800, 800, 800);

		xLen = (800 / (xEnd - xStart));
		yLen = (800 / (yEnd - yStart));
		xBase = (int) (yEnd * yLen);
		yBase = (int) (0 - xStart * xLen);

		grap.setColor(Color.blue);

		grap.drawLine(0, xBase, 799, xBase);
		grap.drawLine(799, xBase, 787, xBase - 4);
		grap.drawLine(799, xBase, 787, xBase + 4);

		grap.drawLine(yBase, 1, yBase, 799);
		grap.drawLine(yBase, 0, yBase - 4, 12);
		grap.drawLine(yBase, 0, yBase + 4, 12);

		grap.drawString("0", yBase + 2, xBase + 12);
		grap.drawString((Math.round(xStart * 1000) / 1000.0) + "", 0, xBase + 12);
		String temp = (Math.round(xEnd * 1000) / 1000.0) + "";
		grap.drawString(temp, 799 - temp.length() * 7, xBase + 15);
		temp = (Math.round(yStart * 1000) / 1000.0) + "";
		grap.drawString(temp, yBase - 5 - temp.length() * 7, 799);
		temp = (Math.round(yEnd * 1000) / 1000.0) + "";
		grap.drawString(temp, yBase - 5 - temp.length() * 7, 12);

		double xIncr = (xEnd - xStart) / 20;
		double yIncr = (yEnd - yStart) / 20;

		for (double x = xIncr; x < xEnd - 0.5 * xIncr; x += xIncr) {
			grap.drawLine(yBase + (int) (x * xLen), xBase, yBase + (int) (x * xLen), xBase - 4);
			temp = Math.round(x * 1000) / 1000.0 + "";
			grap.drawString(temp, yBase + (int) (x * xLen) - 7 - temp.length() / 2, xBase + 12);

		} // for

		for (double x = 0 - xIncr; x > xStart + 0.5 * xIncr; x -= xIncr) {
			grap.drawLine(yBase + (int) (x * xLen), xBase, yBase + (int) (x * xLen), xBase - 4);
			temp = Math.round(x * 1000) / 1000.0 + "";
			grap.drawString(temp, yBase + (int) (x * xLen) - 9 - temp.length() / 2, xBase + 12);

		} // for

		for (double x = yIncr; x < yEnd - 0.5 * yIncr; x += yIncr) {
			grap.drawLine(yBase, xBase - (int) (x * yLen), yBase + 4, xBase - (int) (x * yLen));
			temp = Math.round(x * 1000) / 1000.0 + "";
			grap.drawString(temp, yBase - temp.length() * 7, xBase - (int) (x * yLen) + 5);

		} // for

		for (double x = 0 - yIncr; x > yStart + 0.5 * yIncr; x -= yIncr) {
			grap.drawLine(yBase, xBase - (int) (x * yLen), yBase + 4, xBase - (int) (x * yLen));
			temp = Math.round(x * 1000) / 1000.0 + "";
			grap.drawString(temp, yBase + 3 - temp.length() * 7, xBase - (int) (x * yLen) + 4);

		} // for

	}// setupCoorder

}// class_MGraphics

class MPoint {
	private double x;
	private double y;

	public MPoint(double aX, double aY) {
		x = aX;
		y = aY;

	}// con_MPoint

	public double getX() {
		return x;

	}// get

	public void setX(double aX) {
		x = aX;

	}// setX

	public double getY() {
		return y;

	}// getY

	public void setY(double aY) {
		y = aY;

	}// setY

}// class_MPoint