package aun.scene.level;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.util.color.Color;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.ai.Bullet;
import aun.ai.BulletAI;
import aun.base_scene.Basescene_Coregame;
import aun.character.Jimmy;
import aun.loadgame.data.Loadgame;
import aun.object.GameObject;
import aun.object.Jinny;
import aun.object.Monster;
import aun.object.NormalPlatform;
import aun.object.Player;
import aun.object.Rune;
import aun.object.monster.Monster_Test3_in_Sky_village_1;
import aun.object.monster.Monster_in_Sky_village_1;
import aun.scene.BaseGameScene.STOP_STATEGAME;
import aun.stategame.State_game.Statemenu;
import aun.update.objectnetwork.UpdateServerPlayerMessage;


public class Sky_village extends Basescene_Coregame  {
	
	
	Sky_village instance ;
	public STOP_STATEGAME typestate ;
	
	public Sky_village(GameJumpActivity activity) {
		super(activity);
		instance = (Sky_village) getinstance();
		typestate = STOP_STATEGAME.LEVEL1 ;
	}
    
	
	
	@Override
	public Scene createscene() {
			
			setBackground(new Background(Color.CYAN));	
			createplayersimmulate();
			this.startGame();
//			b_player = getBodysimmulate();
			
	//		attachChild(this.drawScore());
			
			
			playplatformlistlevel();
			
		    player =  playermanager.createPlayer(this ,1);
			player.setPosition(240,685);
			attachChild(player);
			
			
	//		GameObject frog = new GameObject(activity.load.createResource.getTexture(39), activity.getVertexBufferObjectManager(), activity);
	//		frog.setPosition(10, 50);
	//		attachChild(frog);
	//		frog.animate(200);
//			super.createscene();
			return this ;
		
	}
	
	@Override
	public float gettime() {
		// TODO Auto-generated method stub
		return super.gettime();
	}
	
	
	

	@Override
	public void Update() {
		
		if(mGameRuning){
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
//		for(Bullet b : bullet.getBulletList()){
//			b.Update();	
//		}
//		for(Bullet b : bullet.getBulletList()){
//			attachChild(b);	
//		}
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
		 runemanager.createrune_Green(this);
		 
		 monstermanager.createmonster(this);
		 monstermanager.createmonstertest2(this);
		 monstermanager.createmonstertest3(this);
		 monstermanager.createmonstertest4(this);
		 monstermanager.createmonstertest5(this);
	}
	public void playplatformlistlevel(){
		addplatfromlevel();
		for(NormalPlatform n : platformslist){
			attachChild(n);
		}
		for(Rune r : runeslist){
			attachChild(r);
		}
		for(Monster m : monsterlist){
			attachChild(m);
		}
		for(Monster_Test3_in_Sky_village_1 m : specialmonsterlist ){
			attachChild(m);	
		}
		
		
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		
		switch (pMenuItem.getID())
		{
//		(Basescene_Coregame) new Sky_village(activity).createscene()
			case Button_Retry:						
				activity.scenmanager.getsceneplay().add(0,(Basescene_Coregame) new Sky_village(activity).createscene() );
//				activity.sceneplay.remove(1);
				activity.scenmanager.setScene(activity.scenmanager.getsceneplay().get(0));
				activity.highscore.addscore(score_game);
//				activity.highscore.loadpreferrence();
				realstate = state_player[0];
			

				
				break;
		}
		return false;
	}
	
	

}
