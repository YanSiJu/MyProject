package cn.csu.Listenerner.test;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;

import cn.csu.Listenerner.DrawListenerner;

public class SaveTest {

	@Test
	public void testSaveImgFrame() {
		// fail("Not yet implemented");
		new DrawListenerner(null, null, null).saveImgFrame();

	}

	public static void main(String[] args) {
		new DrawListenerner(new JPanel(), null, new JFrame()).saveImgFrame();
	}

}
