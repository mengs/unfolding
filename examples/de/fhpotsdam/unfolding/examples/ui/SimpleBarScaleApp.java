package de.fhpotsdam.unfolding.examples.ui;

import processing.core.PApplet;
import codeanticode.glgraphics.GLConstants;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.ui.BarScaleUI;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class SimpleBarScaleApp extends PApplet {

	UnfoldingMap map;
	BarScaleUI barScale;

	public void setup() {
		size(800, 600, GLConstants.GLGRAPHICS);
		map = new UnfoldingMap(this);
		map.zoomAndPanTo(new Location(52.5f, 13.4f), 10);
		barScale = new BarScaleUI(this, map);

		MapUtils.createDefaultEventDispatcher(this, map);
	}

	public void draw() {
		background(0);
		map.draw();

		fill(255, 100);
		noStroke();
		rect(barScale.x - 5, barScale.y - 10, 100, 20);
		barScale.draw();
	}

	public void keyPressed() {
		if (key == '+')
			map.zoomIn();
		if (key == '-')
			map.zoomOut();
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { "de.fhpotsdam.unfolding.examples.ui.SimpleBarScaleApp" });
	}

}