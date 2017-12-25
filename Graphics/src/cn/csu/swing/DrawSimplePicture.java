package cn.csu.swing;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawSimplePicture {

	public DrawSimplePicture() {

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("my frame"); // 初始化一个窗口
		frame.setSize(500, 500); // 设置窗口大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置画图结束后的操作：退出画图程序
		frame.setVisible(true); // 显示窗口, 不然啥都不显示

		JPanel panel = new JPanel() { // 初始化一个新画布
			private static final long serialVersionUID = 1L; // 不用管，可加可不加

			@Override
			public void paint(Graphics g) { // 重写 pait 方法
				super.paint(g); // 这个要加上，但不加也能正常显示
				
				g.setColor(null); // 设置画笔颜色
				g.drawLine(80, 200, 50, 50); // 画直线
				g.setColor(Color.RED); // 设置画笔颜色
				g.fillRect(80, 60, 40, 60); // 填充一个矩形
				g.fillOval(10, 20, 30, 40);
//				g.drawOval(10, 20, 30, 20); // 画一个椭圆
			}
		};
		frame.setContentPane(panel); // 将画布添加到窗口中
	}
}
