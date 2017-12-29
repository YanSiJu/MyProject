package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import cn.csu.Listenerner.DrawListenerner;

public class ThreeDRectFactory extends ShapeFactory {

	public ThreeDRectFactory(int x1, int y1, int x2, int y2, String color, BasicStroke s) {
		super(x1, y1, x2, y2, color, s);

	}

	public ThreeDRectFactory(DrawListenerner listenerner) {
		super(listenerner);
	}

	@Override
	public void draw(Graphics2D g) {
		// 画笔大小
		g.setStroke(g.getStroke());
		// 设置画笔颜色
		c.setGraphicsColor(g);
		g.fill3DRect(getX1(), getY1(), getX2() - getX1(), getY2() - getY1(), true);
	}

}
