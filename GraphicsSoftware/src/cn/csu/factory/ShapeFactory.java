package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.Optional;

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
		Optional<String> op = Optional.ofNullable(color);
		try {
			Class<?> clazz = Class.forName("cn.csu.bridge." + op.orElse("Black"));
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
	 * 绘制图形的方法
	 * 
	 * @param g画笔对象
	 */
	public abstract void draw(Graphics2D g);

	protected int getX1() {
		return x1;
	}

	protected int getY1() {
		return y1;
	}

	protected  int getX2() {
		return x2;
	}

	protected int getY2() {
		return y2;
	}

	protected BasicStroke getStroke() {
		return stroke;
	}

	protected void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

}
