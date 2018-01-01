package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

public class StarFactory extends ShapeFactory {
	private int x, y;
	private int a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

	public StarFactory(int x1, int y1, int x2, int y2, String color, BasicStroke s) {
		super(x1, y1, x2, y2, color, s);

	}

	public StarFactory(DrawListenerner listenerner) {
		super(listenerner);
	}

	public void draw(Graphics2D g) {
		// 画笔大小
		g.setStroke(new BasicStroke());
		// 设置画笔颜色
		color.setGraphicsColor(g);
		x = (Math.abs(getW() - getW())) / 8;
		y = (Math.abs(getH() - getW())) / 8;
		a1 = getX() + 4 * x;
		b1 = getY() + y;
		a2 = getX();
		b2 = getY() + 3 * y;
		a3 = getX() + 8 * x * 2 / 6;
		b3 = getY() + 3 * y;
		a4 = getX() + 8 * x * 4 / 6;
		b4 = getW() + 3 * y;
		a5 = getW();
		b5 = getW() + 3 * y;
		a6 = getW() + 4 * x / 2;
		b6 = getW() + 4 * y;
		a7 = getW() + 6 * x;
		b7 = getW() + 4 * y;
		a8 = getW() + 4 * x;
		b8 = getW() + 8 * y * 2 / 3;
		a9 = getW();
		b9 = getH();
		a10 = getW();
		b10 = getH();
		g.drawLine(a1, b1, a3, b3);
		g.drawLine(a1, b1, a4, b4);
		g.drawLine(a2, b2, a3, b3);
		g.drawLine(a2, b2, a6, b6);
		g.drawLine(a4, b4, a5, b5);
		g.drawLine(a5, b5, a7, b7);
		g.drawLine(a6, b6, a9, b9);
		g.drawLine(a7, b7, a10, b10);
		g.drawLine(a8, b8, a10, b10);
		g.drawLine(a8, b8, a9, b9);

	}
}
