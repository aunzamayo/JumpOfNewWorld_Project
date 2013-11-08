package aun.scene.level;

import java.util.ArrayList;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.util.color.Color;

import com.badlogic.gdx.physics.box2d.Body;

import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.object.GameObject;
import aun.object.Player;

public class Testmulti extends Basescene_Coregame {

	Player player1, player2 ;
	GameObject playersim1 , playersim2 ;
	public ArrayList<Player>playerlist_multi ;
	
	public Testmulti(GameJumpActivity activity) {
		super(activity);
		playerlist_multi = new ArrayList<Player>();
	}
	
    @Override
    public Scene createscene() {
    	setBackground(new Background(Color.CYAN));	
    	
    	player1 = playermanager.createPlayer(this, 1);
    	attachChild(player1);
    	player1.setPosition(150, 685);
    	playerlist_multi.add(player1);
    	
    	
    	player2 = playermanager.createPlayer(this, 1);
    	attachChild(player2);
    	player2.setPosition(300, 685);
    	playerlist_multi.add(player2);
    	
    	
    	playersim1 = playermanager.createPlayer(this, 1);
    	playersim2 = playermanager.createPlayer(this, 1);
    	playermanager.createsimmulate(playersim1,0,685);	
    	attachChild(playersim1);
    	playermanager.createsimmulate(playersim2,430,685);
    	attachChild(playersim2);
//    	this.startGame();
    	
//		 createplayersimmulate();	
		
//		 player =  playermanager.createPlayer(this ,1);
//		 player.setPosition(240,685);
//		 attachChild(player);
//		 
//		 playerlist_multi.add(player);		 
//		 
//		 
//		 player_simmulateA = createplayersimmulate(0, 685);
//		 playermanager.createsimmulate(player_simmulateA);
//		 attachChild(player_simmulateA);
//		
//		 player_simmulateB = createplayersimmulate(440, 685);
//		 playermanager.createsimmulate(player_simmulateB);
//		 attachChild(player_simmulateB);
		 
    	
    	return this ;   	
    }
    
    @Override
    public void Update() {
    	for(Player p :playerlist_multi ){
    		 p .Update();
    	}
    	for(int i = 0 ;i < activity.mserver.getmClientConnectors().size();i++){
    	      playermanager.getbodySimmulate().get(i).setActive(true);
    	      playermanager.getbodySimmulate().get(i).setLinearVelocity(0.0f, -5.0f);
    	}
    }

}
