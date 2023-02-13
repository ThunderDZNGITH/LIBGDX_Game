package fr.thunderdzn.isometric;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player implements Entity {
	
	private Texture img;
	public Vector2 pos;
	
	public Player() {
		img = new Texture(Gdx.files.internal("Player.png"));
		pos = new Vector2(20, 48);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(img, pos.x, pos.y);
	}

	@Override
	public void update(float delta) {
		move();
	}
	
	private void move() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			pos.x -= 2;
			pos.y += 1;
		} else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			pos.x += 2;
			pos.y -= 1;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			pos.x -= 2;
			pos.y -= 1;
		} else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			pos.x += 2;
			pos.y += 1;
		}
	}
	
}
