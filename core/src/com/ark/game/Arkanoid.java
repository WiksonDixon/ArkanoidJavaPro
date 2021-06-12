package com.ark.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Arkanoid extends ApplicationAdapter {
	SpriteBatch batch;
	GameEngine ge;

	@Override
	/**
	 * Metoda do tworzenia gry i SpriteBatch
	 */
	public void create () {
		batch = new SpriteBatch();
		ge = new GameEngine(batch);
	}

	/**
	 * Metoda do renderowania gry i sterowania
	 */
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		batch.begin();
		ge.drawScreen();
		ge.handleInput();
		ge.Events();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
