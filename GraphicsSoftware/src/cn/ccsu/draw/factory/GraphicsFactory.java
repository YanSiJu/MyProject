package cn.ccsu.draw.factory;

import java.awt.Color;

import javax.swing.JFrame;

public abstract class GraphicsFactory {

	protected JFrame frame;

	public GraphicsFactory() {
		frame = new JFrame();
	}

	public GraphicsFactory(JFrame frame) {
		this.frame = frame;
	}

	public abstract void draw(Color c);
}
