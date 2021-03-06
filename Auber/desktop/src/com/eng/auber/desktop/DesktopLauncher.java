package com.eng.auber.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.eng.auber.AuberGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.backgroundFPS = 60;
		config.title = "Auber";
		new LwjglApplication(new AuberGame(), config);
		config.width = 1000;
		config.height = 1000;
		config.resizable= false;
		config.fullscreen = false;
	}
}
