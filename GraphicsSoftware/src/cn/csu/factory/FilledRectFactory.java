package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

public class FilledRectFactory extends ShapeFactory {

	public FilledRectFactory(DrawListenerner listenerner) {
		super(Math.min(listenerner.getX1(), listenerner.getX2()), Math.min(listenerner.getY1(), listenerner.getY2()),
				Math.abs(listenerner.getX1() - listenerner.getX2()),
				Math.abs(listenerner.getY1() - listenerner.getY2()), listenerner.getColorStr(), new BasicStroke(1));
	}

	/**
	 * 绘制图形的方法
	 * 
	 * @param g画笔对象
	 */
	@Override
	public void draw(Graphics2D g) {
		g.setStroke(getStroke());// 设置画笔的粗细
		// 设置画笔颜色
		c.setGraphicsColor(g);
		g.fillRect(getX1(), getY1(), getX2(), getY2());// 绘制矩形
	}

}
