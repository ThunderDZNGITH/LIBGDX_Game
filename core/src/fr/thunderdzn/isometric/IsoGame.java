package fr.thunderdzn.isometric;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class IsoGame extends Game {
	
	private SpriteBatch batch;
	private GameScreen gScreen;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		gScreen = new GameScreen(batch);
		setScreen(gScreen);
	}

	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		super.dispose();
	}
}
