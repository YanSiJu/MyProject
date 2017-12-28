package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class LineFactory extends ShapeFactory {

	public LineFactory(int x1, int y1, int x2, int y2, Color color, BasicStroke stroke) {
		super(x1, y1, x2, y2, color, stroke);
	}

	/**
	 * ����ͼ�εķ���
	 * 
	 * @param g���ʶ���
	 */
	@Override
	public void draw(Graphics2D g) {
		g.setStroke(getStroke());// ���û��ʵĴ�ϸ
		g.setColor(getColor());// ���û��ʵ���ɫ
		g.drawLine(getX1(), getY1(), getX2(), getY2());// ����ֱ��
	}

}