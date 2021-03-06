package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.mygdx.game.screens.SplashScreen;
import com.mygdx.game.service.SoundService;

public class TutorialClickerGame extends Game {
	
	public final static String GAME_PREFS = "pl.javadevmatt.preclicker.prefs";
	public final static String GAME_SCORE = "pl.javadevmatt.preclicker.prefs.score";
	
	public final static String GAME_NAME = "Tutorial Clicker";
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	
	private SoundService soundService;
	
	
	private boolean paused;
	
	private Preferences prefs;
	
	private int points;
	
	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}

	
	private void init() {
		prefs =  Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
		initSoundService();
		
	}

	private void initSoundService() {
		soundService = new SoundService();
		
	}


	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
	}

	public void addPoints(int pointsToAdd){
		points+= pointsToAdd;
		updateSavedScoreInPrefs();
	}
	
	public void addPoint(){
		points++;
		updateSavedScoreInPrefs();
	}
	
	public void resetGameScore() {
		points = 0;
		updateSavedScoreInPrefs();
	}

	private void updateSavedScoreInPrefs() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}
	public void addPassiveIncome() {
		// TODO implement
		System.out.println("passive income click");
	}

	/**
	 * ---------------------
	 * getters and setters
	 * 
	 */

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public int getPoints() {
		return points;
	}
	public SoundService getSoundService() {
		return soundService;
	}
	


	
}