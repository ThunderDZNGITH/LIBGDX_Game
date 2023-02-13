package fr.thunderdzn.isometric;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import fr.thunderdzn.isometric.IsoGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Isometric");
		config.setWindowSizeLimits(GameScreen.WIDTH, GameScreen.HEIGHT, GameScreen.WIDTH, GameScreen.HEIGHT);
		new Lwjgl3Application(new IsoGame(), config);
	}
}
