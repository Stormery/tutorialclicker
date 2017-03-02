package com.mygdx.game.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundService {

	private Sound moneySound;
	private Sound jump;
	private Sound book;
	private Sound pick;
	private Music music;

	public SoundService() {
		init();
	}

	private void init() {
		moneySound = Gdx.audio.newSound(Gdx.files.internal("sound/money1.mp3"));
		jump = Gdx.audio.newSound(Gdx.files.internal("sound/jump.wav"));
		book = Gdx.audio.newSound(Gdx.files.internal("sound/book.wav"));
		pick = Gdx.audio.newSound(Gdx.files.internal("sound/pick.mp3"));
		music = Gdx.audio.newMusic(Gdx.files.internal("sound/music.mp3"));
	}

	public void playMoneySound() {
		moneySound.play();
	}
	public void startPlayingMusic(boolean looped){	
		music.setVolume(0.15f);
		music.play();
		music.setLooping(looped);
	}

	public void playJumpSound() {
		jump.play(0.5f);
		
	}

	public void playBookSound() {
		book.play();		
	}

	public void playPickSound() {
		pick.play();		
	}
}
