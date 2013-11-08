package aun.loadgame.data;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.object.Monster;
import aun.object.NormalPlatform;
import aun.object.Rune;
import aun.object.monster.Monster_Test3_in_Sky_village_1;
import aun.scene.level.Sky_village;

public class Loadgame extends Basescene_Coregame {
	
	boolean mGameRuning = false ;
	
	public Loadgame(GameJumpActivity activity) {
		super(activity);
		
	}
		
	@Override
	public Scene createscene() {
		setBackground(new Background(Color.CYAN));	
		createplayersimmulate();
		score.setText("Score"+ " " + activity.savegame.scoresave);
//		b_player = getBodysimmulate();
		this.startGame();		
		
		playplatformlistlevel();
		
	    
//		player.setPosition(activity.savegame.position_x,activity.savegame.position_y);
		
	
		b_player.setTransform(10/PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT, activity.savegame.position_y/PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT, 0);
		
		
		player =  playermanager.createPlayer(this ,1);
		float y = (b_player.getPosition().y*PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT)- (player.getWidth()/2) ;
		player.setPosition(activity.savegame.position_x, y);		
		attachChild(player);
		
		
		return this ;
	}
	@Override
	public void startGame() {
		final Text 	titleText = new Text(0, 0,activity.load.getFont(), "Go!", new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
		titleText.setPosition((activity.getCameraWidth() - titleText.getWidth()) * 0.5f, (activity.getCamaraHeight() - titleText.getHeight()) * 0.5f);
		titleText.setScale(0.0f);
		titleText.setColor(Color.RED);
		titleText.registerEntityModifier(new ScaleModifier(2, 0.0f, 2.0f));
		attachChild(titleText);	
		registerUpdateHandler(new TimerHandler(3.0f, new ITimerCallback() {
			@Override
			public void onTimePassed(final TimerHandler pTimerHandler) {
			    unregisterUpdateHandler(pTimerHandler);
				detachChild(titleText);
				b_player.setActive(true);
				mGameRuning = true ;
			}
		}));
	}
	
	public void addplatfromlevel(){
		 platformmanager.createnormalplatform(this);
		 platformmanager.createnormalplatform(this);
		 platformmanager.createnormalplatform(this);	
		 platformmanager.createnormalplatform(this);
		 platformmanager.createnormalplatform(this);
		 platformmanager.createnormalplatform(this);
//		 runemanager.createrune(this);
		 runemanager.createrune_Red(this);
		 runemanager.createrune_Blue(this);
		 monstermanager.createmonster(this);
		 monstermanager.createmonstertest2(this);
		 monstermanager.createmonstertest3(this);
		 monstermanager.createmonstertest4(this);
		 monstermanager.createmonstertest5(this);
	}
	public void playplatformlistlevel(){
		addplatfromlevel();
		for(int i = 0 ;i<platformslist.size();i++){
			attachChild(platformslist.get(i));
			platformslist.get(i).setPosition(activity.savegame.n_position_x[i], activity.savegame.n_position_y[i]);
		}
		for(int i = 0 ;i<runeslist.size();i++){
			attachChild(runeslist.get(i));
			runeslist.get(i).setPosition(activity.savegame.r_position_x[i], activity.savegame.r_position_y[i]);
		}
		for(int i = 0 ;i<monsterlist.size();i++){
			attachChild(monsterlist.get(i));
			monsterlist.get(i).setPosition(activity.savegame.m_position_x[i], activity.savegame.m_position_y[i]);
		}
		for(int i = 0 ;i<specialmonsterlist.size();i++ ){
			attachChild(specialmonsterlist.get(i));	
			specialmonsterlist.get(i).setPosition(activity.savegame.sm_position_x[i], activity.savegame.sm_position_y[i]);
		}
		
		
	}
	@Override
	public void Update() {
		
		
	  if(mGameRuning == true){
		player.Update();
		for(NormalPlatform n : platformslist){
			n.Update();	
		}
		for(Rune r :runeslist ){
			r.Update();			
		}
		for(Monster m : monsterlist ){
			m.Update();	
		}
		for(Monster_Test3_in_Sky_village_1 m : specialmonsterlist ){
			m.Update();	
		}
	  }
//		super.Update();
	}
	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		
		switch (pMenuItem.getID())
		{
			case Button_Retry:						
				activity.sceneplay.add(0, (Basescene_Coregame) new Sky_village(activity).createscene());
				activity.sceneplay.remove(1);
				activity.scenmanager.setScene(activity.sceneplay.get(0));
				activity.highscore.addscore(score_game);
				activity.highscore.loadpreferrence();
				realstate = state_player[0];
				activity.save_state = false ;
				activity.highscore.addscore(score_game+activity.savegame.scoresave);
				break;
		}
		return false;
	}
}
