package cn.csu.swing;

import javax.swing.JButton;
import org.junit.Test;

public class Main {

		@Test
		public void colorTest() {
			JButton b = new JButton();
			b.setToolTipText("--->button");
			System.out.println(b.getToolTipText());
		}
}
