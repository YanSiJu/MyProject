package cn.csu.Listenerner;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import cn.csu.factory.ShapeFactory;
import cn.csu.factory.ThreeDRectFactory;
import cn.csu.factory.CircleFactory;
import cn.csu.factory.EraserFactory;
import cn.csu.factory.FilledRectFactory;
import cn.csu.factory.GumFactory;
import cn.csu.factory.ImageFactory;
import cn.csu.factory.LineFactory;
import cn.csu.factory.RoundRectFactory;
import cn.csu.factory.StarFactory;
import cn.csu.factory.StringFactory;

public class DrawListenerner implements ActionListener, MouseListener, MouseMotionListener {

	private String type = "Ǧ��";// ����ͼ�����ԣ������洢�û�ѡ���ͼ��
	private Color color = Color.black;// ������ɫ���ԣ������洢�û�ѡ�����ɫ
	private Graphics g;// ����Graphics������Ķ���
	private int count = 0;
	private int t2;
	private int t1;
	private int t3;
	private int t4;
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private ShapeFactory shape;// ����ͼ�ζ���
	private ShapeFactory[] shapeArray;// �����洢ͼ�ζ��������
	private int number = 0;// ��¼����������¼�Ѿ��洢��ͼ�θ�����
	@SuppressWarnings("unused")
	private JPanel panel4;
	Random r = new Random();
	public BasicStroke s1;// ���ʴ�С
	BasicStroke s = new BasicStroke();

	/**
	 * 1 ���췽��
	 * 
	 * @param g�Ǵ�DrawMain��Ĵ����ϴ��ݹ����Ļ��ʶ���
	 * @param shapeArray�Ǵ�DrawMain�ഫ�ݹ����Ĵ洢ͼ�ε��������
	 */
	public DrawListenerner(JPanel panel4, ShapeFactory[] shapeArray) {

		this.panel4 = panel4;
		this.shapeArray = shapeArray;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	/**
	 * ��дActionListener�ӿ��е�actionPerformed���󷽷���
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();// ��ȡ�¼�Դ����
		String text = button.getText();// ��ȡ��ť�ϵ�������Ϣ
		if (text == null || text.equals("")) {// �ж��Ƿ���������ɫ��ť
			color = button.getBackground();// ��ȡ��ť�ı�����ɫ
			System.out.println("color = " + color);
		} else {
			type = button.getText();// ��ȡ��ť�ϵ�������Ϣ
			System.out.println("text = " + text);
		}
	}

	/**
	 * �������¼�Դ�����Ϸ�����갴�����¶���ʱִ�д˷���
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// 2.����д�İ��¶������ͷŶ������¼����������У��ڰ��·����л�ȡ��������ֵ
		x1 = e.getX();
		y1 = e.getY();

		// if (type.equals("����")) {
		// try {
		// x1 = e.getXOnScreen();
		// y1 = e.getYOnScreen();
		// // ����һ�������˶���
		// Robot robot = new Robot();
		// // 2.����һ����������������������Ҫ��ȡ��ɫ������
		// Rectangle rec = new Rectangle(x1, y1, 1, 1);
		// BufferedImage ima = robot.createScreenCapture(rec);
		// // 3.��ȡͼƬ�ı������ص���ɫ:��ԭɫred blue green,��ȡͼƬָ�����ص���ɫ
		// int a = ima.getRGB(0, 0);
		// color = new Color(a);
		//
		// // ����ɫ���õ�������
		// } catch (AWTException ex) {
		// ex.printStackTrace();
		// }
		// }

	}

	/**
	 * �������¼�Դ�����Ϸ�����갴���ͷŶ���ʱִ�д˷���
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// ����д�İ��¶������ͷŶ������¼����������У���ȡ�ͷŵ�����ֵ��
		x2 = e.getX();
		y2 = e.getY();
		// 2.֮����ݰ��º��ͷŵ�����ֵ���Լ�ͼ�κ���ɫ��ʹ��Graphics�����ƶ�Ӧ��ͼ�Ρ�
		if (type.equals("ֱ��")) {

			// ����������ʵ����ͼ�ζ���
			shape = new LineFactory(x1, y1, x2, y2, color, new BasicStroke(1));
			// ����ͼ�εĻ�ͼ����
			shape.draw((Graphics2D) g);

			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;
			}

		} else if (type.equals("��������")) {

			if (count == 0) {
				shape = new LineFactory(x1, y1, x2, y2, color, new BasicStroke(1));
				// ����ͼ�εĻ�ͼ����
				shape.draw((Graphics2D) g);
				count++;
				t1 = x1;
				t2 = y1;
			}

			else if (count != 0) {
				shape = new LineFactory(t3, t4, x2, y2, color, new BasicStroke(1));// ������õ���ǰһ��������
				// ����ͼ�εĻ�ͼ����
				shape.draw((Graphics2D) g);
				if (e.getClickCount() == 2) {// ˫�������պ��߶Σ������µĵ�������ĵ������ӣ��պ�ͼ��
					shape = new LineFactory(t1, t2, x2, y2, color, new BasicStroke(1));
					shape.draw((Graphics2D) g);
					count = 0;
				}
				// ��¼Ŀǰ�õ��λ��
			}
			t3 = x2;
			t4 = y2;

			if (number < shapeArray.length) {
				shapeArray[number++] = shape;

			}

		} else if (type.equals("Բ�Ǿ���")) {
			shape = new RoundRectFactory(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2),
					color, new BasicStroke(), 30, 30);
			shape.draw((Graphics2D) g);

			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;
			}
		} else if (type.equals("���Բ")) {
			shape = new CircleFactory(x1, y1, x2, y2, color, s);
			shape.draw((Graphics2D) g);
			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;
			}
		} else if (type.equals("�����")) {
			shape = new StarFactory(x1, y1, x2, y2, color, s);
			shape.draw((Graphics2D) g);
			System.out.println(">>>>>>>>>" + x1 + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + y1);
			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;

			}

		}
	}

	/**
	 * ������ڴ����ϰ��°��������϶�ʱִ�д˷���
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		Graphics2D g2d = (Graphics2D) g;
		if (type.equals("Ǧ��")) {
				
			// ����������ʵ����ͼ�ζ���
			shape = new LineFactory(x1, y1, x2, y2, color, new BasicStroke(1));
			// ����ͼ�εĻ�ͼ����
			shape.draw((Graphics2D) g);

			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;
			}
			x1 = x2;
			y1 = y2;
		} else if (type.equals("ˢ��")) {

			// ����������ʵ����ͼ�ζ���
			shape = new LineFactory(x1, y1, x2, y2, color, new BasicStroke(10));
			// ����ͼ�εĻ�ͼ����
			shape.draw((Graphics2D) g);

			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;
			}
			x1 = x2;
			y1 = y2;
		} else if (type.equals("��ǹ")) {
			g2d.setColor(color);
			shape = new GumFactory(x1, y1, x2, y2, color, s);
			shape.draw((Graphics2D) g);

			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;
			}
			x1 = x2;
			y1 = y2;
		} else if (type.equals("��Ƥ")) {
			shape = new EraserFactory(x1, y1, x2, y2, color, s);
			shape.draw((Graphics2D) g);

			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;
			}

			x1 = x2;
			y1 = y2;
		} else if (type.equals("ͼƬ")) {
			shape = new ImageFactory(color, x1, y1, x2, y2);
			shape.draw((Graphics2D) g);

			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������t
				shapeArray[number++] = shape;
			}
		} else if (type.equals("������")) {
			shape = new FilledRectFactory(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2),
					color, new BasicStroke(1));
			shape.draw((Graphics2D) g);

			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;
			}
		} else if (type.equals("����")) {
			shape = new StringFactory(x1, y1, x2, y2, color, s);
			shape.draw((Graphics2D) g);

			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;
			}
		} else if (type.equals("3d����")) {// 7.3d����
			shape = new ThreeDRectFactory(x1, y1, x2, y2, color, s);
			shape.draw((Graphics2D) g);

			if (number < shapeArray.length) {
				// ��ͼ�ζ�����뵽������
				shapeArray[number++] = shape;
			}
		}

	}

	/**
	 * ������ڴ������ƶ����ʱִ�д˷���
	 */
	@Override
	public void mouseMoved(MouseEvent e) {

	}

	/**
	 * �������¼�Դ�����Ϸ��������(���º��ͷŵĶ���������ͬһ��λ����)����ʱִ�д˷���
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * ��������������¼�Դ������ʱִ�д˷���
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * �����������뿪�¼�Դ������ʱִ�д˷���
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the t1
	 */
	public int getT1() {
		return t1;
	}

	/**
	 * @return the t2
	 */
	public int getT2() {
		return t2;
	}

	/**
	 * @return the t3
	 */
	public int getT3() {
		return t3;
	}

	/**
	 * @return the t4
	 */
	public int getT4() {
		return t4;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the x1
	 */
	public int getX1() {
		return x1;
	}

	/**
	 * @return the y1
	 */
	public int getY1() {
		return y1;
	}

	/**
	 * @return the x2
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * @return the y2
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * @return the shape
	 */
	public ShapeFactory getShape() {
		return shape;
	}

	/**
	 * @return the shapeArray
	 */
	public ShapeFactory[] getShapeArray() {
		return shapeArray;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the r
	 */
	public Random getR() {
		return r;
	}

	/**
	 * @return the s1
	 */
	public BasicStroke getS1() {
		return s1;
	}

	/**
	 * @return the s
	 */
	public BasicStroke getS() {
		return s;
	}

	/**
	 * @return the g
	 */
	public Graphics getG() {
		return g;
	}
}