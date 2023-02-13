package fr.thunderdzn.isometric;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Gui implements Disposable {
	
	public Stage stage;
	private Viewport viewport;
	private Texture GUI_TEXTURE;
	
	public int LIFE;
	public int GUARD;
	public int EAT;
	public int WATER;
	
	private Label lifeLabel;
	
	public Gui(SpriteBatch batch) {
		
		LIFE = 20;
		GUARD = 0;
		EAT = 10;
		WATER = 10;
		
		viewport = new FitViewport(GameScreen.WIDTH, GameScreen.HEIGHT, new OrthographicCamera());
		stage = new Stage(viewport, batch);
		
		Table table1 = new Table();
		table1.setFillParent(true);
		Table table2 = new Table();
		table2.left();
		table2.top();
		table2.setFillParent(true);
		
		GUI_TEXTURE = new Texture(Gdx.files.internal("gui.png"));
		
		Image gui = new Image(GUI_TEXTURE);
		
		lifeLabel = new Label("LIFE : "+LIFE, new Label.LabelStyle(new BitmapFont(), Color.RED));
	
		
		table1.add(gui).setActorBounds(0, 0, 1280, 720);;
		table2.add(lifeLabel).padLeft(10).padTop(600);
		
		
		stage.addActor(table1);
		stage.addActor(table2);
		
	}
	
	public void update(float delta) {
		
	}

	@Override
	public void dispose() {
		stage.dispose();
	}
}
