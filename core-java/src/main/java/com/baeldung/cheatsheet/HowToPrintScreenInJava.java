package com.baeldung.cheatsheet;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import org.junit.Test;

public class HowToPrintScreenInJava {

	public BufferedImage getScreenshot() throws AWTException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		Robot robot = new Robot();
		return robot.createScreenCapture(new Rectangle(screenSize));
	}

	@Test
	public void moveMouse() throws AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(50);
		for (int i = 0; i < 100; ++i) {
			robot.mouseMove(i, i);
		}
	}
}
