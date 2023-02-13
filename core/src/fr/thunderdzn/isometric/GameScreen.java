package fr.thunderdzn.isometric;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	
	public static final int WIDTH = 320 * 4;
	public static final int HEIGHT = 180 * 4;
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private IsometricRenderer renderer;
	private Player player;
	private Gui gui;
	
	public GameScreen(SpriteBatch batch) {
		this.batch = batch;
	}
	
	@Override
	public void show() {
		camera = new OrthographicCamera(WIDTH, HEIGHT);
		camera.position.set(WIDTH / 2 - 500, HEIGHT / 2, 10);
		
		renderer = new IsometricRenderer();
		player = new Player();
		gui = new Gui(batch);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		
		handleInput();
		player.update(delta);
		
		camera.position.x = player.pos.x;
		camera.position.y = player.pos.y;
		camera.update();

		
		batch.begin();
		
		renderer.drawGround(batch);
		player.render(batch);
		batch.end();
		
        batch.setProjectionMatrix(gui.stage.getCamera().combined);
        gui.stage.draw();
	}
	
	private void handleInput() {
		
		if(Gdx.input.isKeyPressed(Input.Keys.NUMPAD_ADD)) {
			camera.zoom -= 0.002f;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.NUMPAD_SUBTRACT)) {
			camera.zoom += 0.002f;
		}
		
	}
	
	@Override
	public void dispose() {
		
	}
}
