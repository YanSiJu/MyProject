package cn.csu.factory;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import cn.csu.Listenerner.DrawListenerner;

public class ImageFactory extends ShapeFactory {

	public ImageFactory(Color color, int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2, null, null);

	}

	private JPanel panel;

	public ImageFactory(DrawListenerner listenerner, JPanel panel) {
		super(listenerner);
		this.panel = panel;
	}

	@Override
	public void draw(Graphics2D g) {

		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		chooser.setSize(1000, 900);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
		// 设置文件类型
		chooser.setFileFilter(filter);
		// 打开选择器面板
		int returnVal = chooser.showOpenDialog(this.panel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println(chooser.getSelectedFile().getPath());
		}
	}

}
