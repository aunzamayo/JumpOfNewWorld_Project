package aun.manager;

import java.util.ArrayList;

import org.andengine.entity.scene.Scene;

import com.badlogic.gdx.physics.box2d.Body;

import aun.activity.GameJumpActivity;
import aun.character.Jimmy;
import aun.character.Monkey_Tarzan;
import aun.object.GameObject;
import aun.object.Jinny;
import aun.object.Player;

public class PlayerManager  {

	
	GameJumpActivity activity ;
	ArrayList<Player> playerlist ;
	
	private ArrayList<Body> bodylist ;
	private GameObject player_simmulate ; 
	public  Body b_player ;
	
	public PlayerManager(GameJumpActivity gm) {
		
		this.activity = gm ;
		playerlist = new ArrayList<Player>();
		bodylist = new ArrayList<Body>();
	   
	}
	
	public GameObject createplayer(Scene sc , int idCharacter){
		if(idCharacter == 1){
			Jinny jinny = new Jinny(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity);
			return jinny ;
		}
		return null;
	}
	
	public void createsimmulate (GameObject player_simmulate,float x,float y){
		this.player_simmulate = player_simmulate ;
		this.player_simmulate.setPosition(x, y);
		b_player = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_simmulate);
		b_player.setActive(false);	
		bodylist.add(b_player);
	}
	public ArrayList<Body> getbodySimmulate(){
		return bodylist ; 
	}
	
//	public GameObject getsimmulate(){
//		return  player_simmulate ;
//	}
//	public Body getBody(){
//		return  b_player = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_simmulate) ;
//	}
	
	public Player createPlayer (Scene sc , int id){
		
		if(id == 1){
			Player jimmy = new Jimmy(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity);
			return jimmy ;
		}else if (id == 2){
			Player monkey_tazan = new Monkey_Tarzan(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity);
			return monkey_tazan ;
		}
//		}else if (id == 3){
//			Player jimny = new Jimmy(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity);
//			return jimny ;
//		}else if (id == 4){
//			Player jimny = new Jimmy(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity);
//			return jimny ;
//		}else if (id == 5){
//			Player jimny = new Jimmy(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity);
//			return jimny ;
//		}
		return null ;
	}
	
	
	

}
