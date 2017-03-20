import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.util.ArrayList;

public class GUI {
	// ----------------------------------------���岿��---------------------------------------
	ArrayList<MFrame> frames;
	ArrayList<MPanel> panels;
	ArrayList<MButton> buttons;
	ArrayList<MLabel> labels;

	public GUI() {
		frames = new ArrayList<MFrame>();
		panels = new ArrayList<MPanel>();
		buttons = new ArrayList<MButton>();
		labels = new ArrayList<MLabel>();

	}// con_GUI

	public MFrame getFrameById(String aId) {
		for (MFrame t : frames) {
			if (t.getId() == aId) {
				return t;
			} // if
		} // for

		return null;
	}// getFrameById

	public MButton getButtonById(String aId) {
		for (MButton t : buttons) {
			if (t.getId() == aId) {
				return t;
			} // if
		} // for

		return null;
	}// getButtonById

	public MPanel getPanelById(String aId) {
		for (MPanel t : panels) {
			if (t.getId() == aId) {
				return t;
			} // if
		} // for

		return null;
	}// getPanelById

	public MLabel getLabelById(String aId) {
		for (MLabel t : labels) {
			if (t.getId() == aId) {
				return t;
			} // if
		} // for

		return null;
	}// getLabelById

	public void setupGUI() {// GUI��������
		MFrame tFrame = null;
		MButton tButton = null;
		MPanel tPanel = null;
		MLabel tLabel = null;

		// ����������, id = mainFrame, �ڲ�ʵ�ʿ��ô�С�� ��� = ��ܿ�� - 6�� �߶� = ��ܸ߶� - 35
		tFrame = new MFrame();
		tFrame.setId("mainFrame");
		frames.add(tFrame);
		tFrame.setTitle("��������ͼ����ƹ���_v1.1_By:�׺�Ȼ_���䣺Bai_Haoran@outlook.com");
		tFrame.setSize(1207, 836);
		tFrame.setResizable(false);
		tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tFrame.setVisible(true);

		// ���������, id = mainPanel
		tPanel = new MPanel();
		tPanel.setId("mainPanel");
		panels.add(tPanel);
		tPanel.setLayout(null);
		tPanel.setBackground(new Color(230, 230, 230));
		getFrameById("mainFrame").getContentPane().add(BorderLayout.CENTER, tPanel);

		// ���������������, id = textPanel
		tPanel = new MPanel();
		tPanel.setId("textPanel");
		panels.add(tPanel);
		tPanel.setLayout(null);
		tPanel.setBackground(new Color(242, 242, 242));
		tPanel.setBounds(801, 0, 400, 174);
		getPanelById("mainPanel").add(tPanel);

		// ˵����ǩ
		Font font = new Font("MicrosoftUighur", Font.ITALIC, 16);
		JLabel label = new MLabel();
		label.setBounds(0, 10, 400, 16);
		label.setText("  �������̣�(ѡ��һ����Ŀ���ٽ�������)");
		label.setFont(font);
		getPanelById("textPanel").add(label);

		// ------------------------------------------------���������Ĳ���--------------------------------------------------
		INBListener inbListener = new INBListener();
		font = new Font("MicrosoftUighur", Font.BOLD, 24);
		// ����x�Ĳ�������������Ա�ǩ���棩��id = xParametricInput�� �����߶ȣ�77
		tLabel = new MLabel();
		tLabel.setId("xParametricInput");
		tLabel.setMaxPx(336);
		labels.add(tLabel);
		tLabel.setOpaque(true);
		tLabel.setBackground(new Color(218, 218, 218));
		tLabel.setBounds(0, 30, 400, 48);
		tLabel.setText(" x = ");
		tLabel.setFont(font);
		tLabel.addMouseListener(inbListener);
		inbListener.setLabel(tLabel);
		getPanelById("textPanel").add(tLabel);

		// ����y�Ĳ�������������Ա�ǩ���棩��id = yParametricInput
		tLabel = new MLabel();
		tLabel.setId("yParametricInput");
		tLabel.setMaxPx(336);
		labels.add(tLabel);
		tLabel.setOpaque(true);
		tLabel.setBackground(new Color(242, 242, 242));
		tLabel.setBounds(0, 78, 400, 48);
		tLabel.setText(" y = ");
		tLabel.setFont(font);
		tLabel.addMouseListener(inbListener);
		getPanelById("textPanel").add(tLabel);

		// ����t��ʼ��Χ������Ա�ǩ���棩��id = tStart
		tLabel = new MLabel();
		tLabel.setId("tStart");
		tLabel.setMaxPx(150);
		labels.add(tLabel);
		tLabel.setOpaque(true);
		tLabel.setBackground(new Color(242, 242, 242));
		tLabel.setBounds(40, 126, 150, 48);
		tLabel.setText("-5");
		tLabel.setInput("-5");
		tLabel.setShow("-5");
		tLabel.setFont(font);
		tLabel.addMouseListener(inbListener);
		getPanelById("textPanel").add(tLabel);

		// ����t������Χ������Ա�ǩ���棩��id = tEnd
		tLabel = new MLabel();
		tLabel.setId("tEnd");
		tLabel.setMaxPx(150);
		labels.add(tLabel);
		tLabel.setOpaque(true);
		tLabel.setBackground(new Color(242, 242, 242));
		tLabel.setBounds(207, 126, 150, 48);
		tLabel.setText("5");
		tLabel.setInput("5");
		tLabel.setShow("5");
		tLabel.setFont(font);
		tLabel.addMouseListener(inbListener);
		getPanelById("textPanel").add(tLabel);

		// ����x�Ὺʼ��Χ������Ա�ǩ���棩��id = tStart
		tLabel = new MLabel();
		tLabel.setId("xStart");
		tLabel.setMaxPx(150);
		labels.add(tLabel);
		tLabel.setOpaque(true);
		tLabel.setBackground(new Color(230, 230, 230));
		tLabel.setBounds(841, 590, 150, 48);
		tLabel.setText("-5");
		tLabel.setInput("-5");
		tLabel.setShow("-5");
		tLabel.setFont(font);
		tLabel.addMouseListener(inbListener);
		getPanelById("mainPanel").add(tLabel);

		// ����x�������Χ������Ա�ǩ���棩��id = tEnd
		tLabel = new MLabel();
		tLabel.setId("xEnd");
		tLabel.setMaxPx(150);
		labels.add(tLabel);
		tLabel.setOpaque(true);
		tLabel.setBackground(new Color(230, 230, 230));
		tLabel.setBounds(1008, 590, 150, 48);
		tLabel.setText("5");
		tLabel.setInput("5");
		tLabel.setShow("5");
		tLabel.setFont(font);
		tLabel.addMouseListener(inbListener);
		getPanelById("mainPanel").add(tLabel);

		// ����y�Ὺʼ��Χ������Ա�ǩ���棩��id = tStart
		tLabel = new MLabel();
		tLabel.setId("yStart");
		tLabel.setMaxPx(150);
		labels.add(tLabel);
		tLabel.setOpaque(true);
		tLabel.setBackground(new Color(230, 230, 230));
		tLabel.setBounds(841, 638, 150, 48);
		tLabel.setText("-5");
		tLabel.setInput("-5");
		tLabel.setShow("-5");
		tLabel.setFont(font);
		tLabel.addMouseListener(inbListener);
		getPanelById("mainPanel").add(tLabel);

		// ����y�������Χ������Ա�ǩ���棩��id = tEnd
		tLabel = new MLabel();
		tLabel.setId("yEnd");
		tLabel.setMaxPx(150);
		labels.add(tLabel);
		tLabel.setOpaque(true);
		tLabel.setBackground(new Color(230, 230, 230));
		tLabel.setBounds(1008, 638, 150, 48);
		tLabel.setText("5");
		tLabel.setInput("5");
		tLabel.setShow("5");
		tLabel.setFont(font);
		tLabel.addMouseListener(inbListener);
		getPanelById("mainPanel").add(tLabel);
		// ------------------------------------------------���������Ĳ���--------------------------------------------------

		// -----------------------------------------------������˵����ǩ����-------------------------------------------------
		// t�����һ��˵�����
		font = new Font("MicrosoftUighur", Font.BOLD, 16);
		label = new JLabel();
		label.setText("  t :��");
		label.setBounds(0, 126, 40, 48);
		label.setFont(font);
		getPanelById("textPanel").add(label);

		// t���붺���������
		label = new JLabel();
		label.setText("��");
		label.setBounds(190, 126, 17, 48);
		label.setFont(font);
		getPanelById("textPanel").add(label);

		// t��������������
		label = new JLabel();
		label.setText("��");
		label.setBounds(357, 126, 17, 48);
		label.setFont(font);
		getPanelById("textPanel").add(label);

		// x�Ὺʼ�������
		label = new JLabel();
		label.setText("  x:��");
		label.setBounds(801, 590, 40, 48);
		label.setFont(font);
		getPanelById("mainPanel").add(label);

		// x�ᶺ���������
		label = new JLabel();
		label.setText("��");
		label.setBounds(991, 590, 17, 48);
		label.setFont(font);
		getPanelById("mainPanel").add(label);

		// x������������
		label = new JLabel();
		label.setText("��");
		label.setBounds(1158, 590, 17, 48);
		label.setFont(font);
		getPanelById("mainPanel").add(label);

		// y�Ὺʼ�������
		label = new JLabel();
		label.setText("  y:��");
		label.setBounds(801, 638, 40, 48);
		label.setFont(font);
		getPanelById("mainPanel").add(label);

		// y�ᶺ���������
		label = new JLabel();
		label.setText("��");
		label.setBounds(991, 638, 17, 48);
		label.setFont(font);
		getPanelById("mainPanel").add(label);

		// y������������
		label = new JLabel();
		label.setText("��");
		label.setBounds(1158, 638, 17, 48);
		label.setFont(font);
		getPanelById("mainPanel").add(label);
		// -----------------------------------------------������˵����ǩ����--------------------------------------------------

		// -------------------------------------------------��ť���ò���-----------------------------------------------------
		font = new Font("MicrosoftUighur", Font.BOLD, 24);
		Color color = new Color(242, 242, 242);
		BtnListenerLow lowBtnListener = new BtnListenerLow(); // ǳ��ɫ��ť������
		// ǳ��ɫ��ť�ķ���
		for (int i = 0; i < 10; i++) {
			tButton = new MButton(color);
			tButton.setBounds(801 + (i % 5) * 80, 176 + (i / 5) * 50, 80, 60);
			buttons.add(tButton);
			getPanelById("mainPanel").add(tButton);
			tButton.setText("");
			tButton.addMouseListener(inbListener);
			tButton.addMouseListener(lowBtnListener);

			tButton.setFont(font);

		} // for

		BtnListenerHigh highBtnListener = new BtnListenerHigh(); // ����ɫ��ť������
		color = new Color(230, 230, 230);
		// ����ɫ��ť�ķ���
		for (int i = 0; i < 25; i++) {
			tButton = new MButton(color);
			tButton.setBounds(801 + (i % 5) * 80, 288 + (i / 5) * 60, 80, 60);
			buttons.add(tButton);
			getPanelById("mainPanel").add(tButton);
			tButton.setText("");
			tButton.addMouseListener(inbListener);
			tButton.addMouseListener(highBtnListener);

			tButton.setFont(font);

		} // for

		font = new Font("MicrosoftUighur", Font.ITALIC, 18);
		for (int i = 0; i < 4; i++) {
			tButton = new MButton(color);
			tButton.setBounds(801 + (i % 2) * 200, 686 + (i / 2) * 58, 200, 58);
			buttons.add(tButton);
			getPanelById("mainPanel").add(tButton);
			tButton.setText("");
			tButton.addMouseListener(highBtnListener);
			tButton.setFont(font);

		} // for

		font = new Font("MicrosoftUighur", Font.ITALIC, 17);
		buttons.get(13).setFont(font);
		buttons.get(14).setFont(font);
		buttons.get(25).setFont(font);

		buttons.get(0).setText("|");
		buttons.get(1).setText("^");
		buttons.get(2).setText("sin");
		buttons.get(3).setText("cos");
		buttons.get(4).setText("tan");

		buttons.get(5).setText("sqrt");
		buttons.get(6).setText("log");
		buttons.get(7).setText("_");
		buttons.get(8).setText("~");
		buttons.get(9).setText("%");

		buttons.get(10).setText("ln");
		buttons.get(11).setText("lg");
		buttons.get(12).setText("t");
		buttons.get(13).setText("���");
		buttons.get(14).setText("ɾ��");

		buttons.get(15).setText("pi");
		buttons.get(16).setText("7");
		buttons.get(17).setText("8");
		buttons.get(18).setText("9");
		buttons.get(19).setText("+");

		buttons.get(20).setText("e");
		buttons.get(21).setText("4");
		buttons.get(22).setText("5");
		buttons.get(23).setText("6");
		buttons.get(24).setText("-");

		buttons.get(25).setText("�׳�");
		buttons.get(26).setText("1");
		buttons.get(27).setText("2");
		buttons.get(28).setText("3");
		buttons.get(29).setText("*");

		buttons.get(30).setText("(");
		buttons.get(31).setText(")");
		buttons.get(32).setText("0");
		buttons.get(33).setText(".");
		buttons.get(34).setText("/");

		buttons.get(35).setText("���ƺ���ͼ��");
		buttons.get(35).setId("draw");
		buttons.get(36).setText("��պ���ͼ��");
		buttons.get(36).setId("clear");
		buttons.get(37).setText("����������ϵ");
		buttons.get(37).setId("coorder");
		buttons.get(38).setText("������������");
		buttons.get(38).setId("reset");
		// -------------------------------------------------��ť���ò���-----------------------------------------------------

		System.gc();

	}// setupGUI

}// class_GUI

class BtnListenerHigh implements MouseListener { // ����ɫ��ť��������

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		((MButton) arg0.getSource()).setBackground(new Color(218, 218, 218));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (!((MButton) arg0.getSource()).getBackground().equals((new Color(190, 190, 190)))) {
			((MButton) arg0.getSource()).setBackground(new Color(230, 230, 230));

		} // if
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		((MButton) arg0.getSource()).setBackground(new Color(190, 190, 190));
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getX() >= 0 && arg0.getY() >= 0 && arg0.getX() <= ((MButton) arg0.getSource()).getWidth()
				&& arg0.getY() <= ((MButton) arg0.getSource()).getHeight()) {
			((MButton) arg0.getSource()).setBackground(new Color(218, 218, 218));
		} else {
			((MButton) arg0.getSource()).setBackground(new Color(230, 230, 230));
		} // if
	}

}// BtnListenerHigh

class BtnListenerLow implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		((MButton) arg0.getSource()).setBackground(new Color(230, 230, 230));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (!((MButton) arg0.getSource()).getBackground().equals((new Color(190, 190, 190)))) {
			((MButton) arg0.getSource()).setBackground(new Color(242, 242, 242));

		} // if
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		((MButton) arg0.getSource()).setBackground(new Color(190, 190, 190));
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getX() >= 0 && arg0.getY() >= 0 && arg0.getX() <= ((MButton) arg0.getSource()).getWidth()
				&& arg0.getY() <= ((MButton) arg0.getSource()).getHeight()) {
			((MButton) arg0.getSource()).setBackground(new Color(230, 230, 230));
		} else {
			((MButton) arg0.getSource()).setBackground(new Color(242, 242, 242));
		} // if
	}

}// BtnListenerLow

class INBListener implements MouseListener {
	MLabel label = null;

	public void setLabel(MLabel aLabel) {
		label = aLabel;
	}// setLabel

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() instanceof MLabel) {
			String temp = ((MLabel) arg0.getSource()).getId();
			if (!(temp.equals("xStart") || temp.equals("xEnd") || temp.equals("yStart") || temp.equals("yEnd"))) {
				if (label != (MLabel) arg0.getSource()) {
					((MLabel) (arg0.getSource())).setBackground(new Color(230, 230, 230));
				} // if
			} else {
				if (label != (MLabel) arg0.getSource()) {
					((MLabel) (arg0.getSource())).setBackground(new Color(218, 218, 218));
				} // if
			}

		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() instanceof MLabel) {
			String temp = ((MLabel) arg0.getSource()).getId();
			if (!(temp.equals("xStart") || temp.equals("xEnd") || temp.equals("yStart") || temp.equals("yEnd"))) {
				if ((MLabel) arg0.getSource() != label) {
					((MLabel) arg0.getSource()).setBackground(new Color(242, 242, 242));
				} // if
			} else {
				if ((MLabel) arg0.getSource() != label) {
					((MLabel) arg0.getSource()).setBackground(new Color(230, 230, 230));
				} // if
			}

		} // if
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() instanceof MLabel) {
			if (label != null) {
				String temp = label.getId();
				if (!(temp.equals("xStart") || temp.equals("xEnd") || temp.equals("yStart") || temp.equals("yEnd"))) {
					label.setBackground(new Color(242, 242, 242));
				} else {
					label.setBackground(new Color(230, 230, 230));
				}
			} // if

			label = (MLabel) arg0.getSource();
			label.setBackground(new Color(190, 190, 190));
		} else {
			String temp = ((MButton) arg0.getSource()).getText();
			FontMetrics fm = label.getFontMetrics(label.getFont());

			if (temp.equals("ɾ��")) {
				temp = label.getInput();

				if (temp.equals("")) {
					return;
				} // if

				label.setInput(temp.substring(0, temp.length() - 1));
				temp = label.getShow();
				temp = temp.substring(0, temp.length() - 1);

				if (label.getInput().length() - temp.length() > 0) {
					char shouldAdd = label.getInput().charAt(label.getInput().length() - temp.length() - 1);
					if (fm.stringWidth(temp + shouldAdd) <= label.getMaxPx()) {
						temp = shouldAdd + temp;
					} // if
				} // if

				label.setShow(temp);
			} else if (((MButton) arg0.getSource()).getText().equals("���")) {
				label.setInput("");
				label.setShow("");
			} else {
				if (temp.equals("ƽ��")) {
					temp = "^2";
				} else if (temp.equals("�׳�")) {
					temp = "!";
				} // if

				label.setInput(label.getInput() + temp);
				label.setShow(label.getShow() + temp);

				while (fm.stringWidth(label.getShow()) > label.getMaxPx()) {
					temp = label.getShow();
					label.setShow(temp.substring(1, temp.length()));
				} // while
			} // if

			temp = label.getId();
			if (temp.equals("xParametricInput")) {
				label.setText(" x = " + label.getShow());
			} else if (temp.equals("yParametricInput")) {
				label.setText(" y = " + label.getShow());
			} else {
				label.setText(label.getShow());
			} // if
		} // if
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() instanceof MLabel) {
			if (label != (MLabel) arg0.getSource()) {
				String temp = ((MLabel) arg0.getSource()).getId();
				if (!(temp.equals("xStart") || temp.equals("xEnd") || temp.equals("yStart") || temp.equals("yEnd"))) {
					((MLabel) arg0.getSource()).setBackground(new Color(230, 230, 230));// ����ʱ��230
				} else {
					((MLabel) arg0.getSource()).setBackground(new Color(218, 218, 218));
				} // if
			} else {
				String temp = ((MLabel) arg0.getSource()).getId();
				if (!(temp.equals("xStart") || temp.equals("xEnd") || temp.equals("yStart") || temp.equals("yEnd"))) {
					((MLabel) arg0.getSource()).setBackground(new Color(218, 218, 218));
				} else {
					((MLabel) arg0.getSource()).setBackground(new Color(202, 202, 202));
				} // if
			} // if
		} // if
	}

}// class_INBListener

class MPanel extends JPanel {
	private String id;

	public MPanel() {
		setLayout(null);

	}// con_MPanel

	public void setId(String aId) {
		id = aId;

	}// setId

	public String getId() {
		return id;

	}// getId

}// class_MPanel

class MFrame extends JFrame {
	private String id;

	public void setId(String aId) {
		id = aId;

	}// setId

	public String getId() {
		return id;

	}// getId

}// MFrame

class MButton extends JLabel {
	private String id;

	// 242�������ɫ��230�ſ�ʱ����ɫ�� 218����ʱ����ɫ��202����ʱ����ɫ
	public MButton(Color aBackground) {
		setOpaque(true);
		setHorizontalAlignment(SwingConstants.CENTER);
		setBackground(aBackground);

	}// con_MButton

	public void setId(String aId) {
		id = aId;

	}// setId

	public String getId() {
		return id;

	}// getId

}// class_Mbutton

class MLabel extends JLabel {
	private String id = "";
	private String input = "";
	private String show = "";
	private int maxPx = 0;

	public void setInput(String aInput) {
		input = aInput;

	}// setInput

	public void setMaxPx(int aMaxPx) {
		maxPx = aMaxPx;

	}// setMaxPx

	public int getMaxPx() {
		return maxPx;

	}// getMaxPx

	public String getInput() {
		return input;

	}// getInput

	public void setId(String aId) {
		id = aId;

	}// setId

	public String getId() {
		return id;

	}// getId

	public String getShow() {
		return show;

	}// getShow

	public void setShow(String aShow) {
		show = aShow;
	}// setShow

}// class_JLabel