package fr.thunderdzn.isometric;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class IsometricRenderer {

	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;
	
	private int[][] map;
	private Texture dirt;
	
	public IsometricRenderer() {
		
		dirt = new Texture(Gdx.files.internal("dirt.png"));
		map = generateMap();
		
	}
	
	public void drawGround(SpriteBatch batch) {
		for(int row = map.length - 1; row >= 0; row--) {
			for(int col = map.length - 1; col >= 0; col--) {
				float x = (col - row) * (TILE_WIDTH / 2f);
				float y = (col + row) * (TILE_HEIGHT / 4f);
				
				if(map[row][col] == 1) {
					batch.draw(dirt, x, y, TILE_WIDTH, TILE_HEIGHT);
				} else {
					
				}
			}
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.R)) {
			map = generateMap();
		}
	}
	
	private int[][] generateMap() {
		Random r = new Random();
		
		int rSize = r.nextInt(128);
		
		if(rSize < 12) {
			rSize = 12;
		}
		int[][] map = new int[rSize][rSize];
		
		for(int row = 0; row < map.length; row++) {
			for(int col = 0; col < map.length; col++) {
				int num = r.nextInt(10);
				
				if(num > 7) {
					map[row][col] = 0;
				} else {
					map[row][col] = 1;
				}
			}
		}
		
		map[0][0] = 1;
		
		return map;
	}
}
