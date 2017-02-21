package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.TutorialClickerGame;
import com.mygdx.game.entities.Player;
import com.mygdx.game.ui.IClickCallback;
import com.mygdx.game.ui.PlayerButton;
import com.mygdx.game.ui.ResetScoreButton;
import com.mygdx.game.ui.ScoreLabel;

public class GameplayScreen extends AbstractScreen{
	
	private Image bgImage;
	private Player player;
	private PlayerButton playerButton;
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;

	public GameplayScreen(TutorialClickerGame game) {
		super(game);
	}
	
	@Override	
	protected void init() {
		initBg();
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initScoreLabel();
	}
	
	private void initBg() {
		bgImage = new Image(new Texture("bg.png"));
		stage.addActor(bgImage);
	}

	private void initResetScoreButton() {
		resetScoreButton = new ResetScoreButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				game.resetGameScore();
			}
		});
		
		stage.addActor(resetScoreButton);
		
	}

	private void initScoreLabel() {
		scoreLabel = new ScoreLabel();
		stage.addActor(scoreLabel);
	}

	private void initPlayerButton() {
		playerButton = new PlayerButton(new IClickCallback() {
			@Override
			public void onClick() {
				player.reactOnClick();
				game.addPoint();
			}
		});
		
		stage.addActor(playerButton);
	}

	private void initPlayer() {
		player = new Player();
		stage.addActor(player);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		update();
	/*
	 * jesli jest stage. trzeba otworzy od nowa jeszcze jeden spritebatch dla 
	 * draw jesli jest inny sposob rysowania
	 * najpierw background pozniej scena
	 * EDIT: Ale lepiej dodac do sceny
	 */		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act();
	}


	

}
