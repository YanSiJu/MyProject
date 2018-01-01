package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.Random;

import cn.csu.Listenerner.DrawListenerner;

public class GumFactory extends ShapeFactory {

	Random r = new Random();
	public GumFactory(int x1, int y1, int x2, int y2,String color,BasicStroke stroke) {
		super(x1, y1, x2, y2, color, stroke);
	}
	
	public GumFactory(DrawListenerner listenerner) {
		super(listenerner);
	}
	
	@Override
	public void draw(Graphics2D g){
		g.setStroke(new BasicStroke(1));
		g.setColor(g.getColor());
		g.drawLine(getW(),getH (),getW(),getH());
		for (int i = 0; i < 10; i++) {
			int p = r.nextInt(10);
			int q = r.nextInt(10); // 可以生成一个介于0(包含)到n(不包含)之间的整数
									// nextInt(10)生成的就是0~10之间的随机数，包含0和10
			g.drawLine(getW() + p, getH() + q, getW() + p, getH() + q);
		}
	}

}
