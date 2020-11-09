package screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.eng.auber.AuberGame;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import input.processors.*;

public class GameScreen extends ScreenAdapter {
    public SpriteBatch batch;
    private int playerSpeed = 3;
    AuberGame game;
    boolean demoMode;
    Texture player;
    float x, y;
    int player_h, player_w;


    public GameScreen(AuberGame game, boolean demoMode){
        this.demoMode  = demoMode;
        this.game = game;
        this.batch = new SpriteBatch();
        this.player = new Texture("game_assets/P_temp.png");
        this.player_h = player.getHeight();
        this.player_w = player.getWidth();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(
                new GameInputProcessor()
        );
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            x += playerSpeed;
            if (x + player_w > Gdx.graphics.getWidth()) {
                x = Gdx.graphics.getWidth() - player_w;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            x -= playerSpeed;
            if (x < 0) {x = 0;}
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            y += playerSpeed;
            if (y + player_h > Gdx.graphics.getHeight()) {
                y = Gdx.graphics.getHeight() - player_h;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            y -= playerSpeed;
            if (y < 0) {y = 0;}
        }



        batch.begin();
        batch.draw(player, x, y);
        batch.end();

        batch.begin();
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            game.setScreen(new MainMenu(game));
        }
        GameKeys.update();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        player.dispose();
        batch.dispose();
    }
}
