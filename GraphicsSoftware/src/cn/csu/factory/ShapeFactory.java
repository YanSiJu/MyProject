package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import cn.csu.Listenerner.DrawListenerner;
import cn.csu.bridge.IColor;

public abstract class ShapeFactory {

	private int x1, y1, x2, y2;
	private String color;
	private BasicStroke stroke;
	protected IColor c;

	/**
	 * @return the color
	 */
	protected IColor getColor() {
		return c;
	}

	private void setG() {
		try {
			Class<?> clazz = Class.forName("cn.csu.bridge.IColor" + color);
			c = (IColor) clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public ShapeFactory(DrawListenerner listenerner) {
		this.x1 = listenerner.getX1();
		this.y1 = listenerner.getY1();
		this.x2 = listenerner.getX2();
		this.y2 = listenerner.getY2();
		this.color = listenerner.getColorStr();
		setG();
	}

	public ShapeFactory(int x1, int y1, int x2, int y2, String colorStr, BasicStroke stroke) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.stroke = stroke;
		this.color = colorStr;
		setG();
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(IColor color) {
		this.c = color;
	}

	/**
	 * 绘制图形的方法
	 * 
	 * @param g画笔对象
	 */
	public abstract void draw(Graphics2D g);

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public BasicStroke getStroke() {
		return stroke;
	}

	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

	/**
	 * @return the colorStr
	 */
	public String getColorStr() {
		return color;
	}

}
