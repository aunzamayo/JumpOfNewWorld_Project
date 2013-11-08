package aun.manager;

import java.util.ArrayList;
import java.util.Random;

import org.andengine.entity.scene.Scene;

import aun.activity.GameJumpActivity;
import aun.object.GameObject;
import aun.object.Monster;
import aun.object.monster.Monster_Test2_in_Sky_village_1;
import aun.object.monster.Monster_Test3_in_Sky_village_1;
import aun.object.monster.Monster_Test4_in_Sky_village_1;
import aun.object.monster.Monster_Test5_in_Sky_village_1;
import aun.object.monster.Monster_in_Sky_village_1;


public class MonsterManager {
	
	GameJumpActivity activity ;
	private ArrayList<Monster> monsterslist ;
	private ArrayList<Monster_Test3_in_Sky_village_1> specialmonsterslist ;
	float x ;
	
	private float x_Velocity ;
	private float y_Velocity ;
	Monster_Test3_in_Sky_village_1 monster3 ;
	
	public MonsterManager(GameJumpActivity gm) {
		this.activity = gm ;	
		monsterslist = new ArrayList<Monster>();
		specialmonsterslist  = new ArrayList<Monster_Test3_in_Sky_village_1>();
		
	}
	
	public GameObject createmonster (Scene sc){
		Random rx = new Random() ;
		x = rx.nextInt(420);
		Monster_in_Sky_village_1 monster = new Monster_in_Sky_village_1(activity.load.createResource.getTexture(36), activity.getVertexBufferObjectManager(), activity);
		monster.setPosition(0, -500);
		monsterslist.add(monster);	
		
		return monster;
	
	}
	public GameObject createmonstertest2 (Scene sc){
		Random rx = new Random() ;
		x = rx.nextInt(420);
		Monster_Test2_in_Sky_village_1 monster = new Monster_Test2_in_Sky_village_1(activity.load.createResource.getTexture(37), activity.getVertexBufferObjectManager(), activity);
		monster.setPosition(30, -200);
		monsterslist.add(monster);	
		
		return monster;
	
	}
	public GameObject createmonstertest3 (Scene sc){
		Random rx = new Random() ;
		x = rx.nextInt(420);
		monster3 = new Monster_Test3_in_Sky_village_1(activity.load.createResource.getTexture(38), activity.getVertexBufferObjectManager(), activity);
		monster3.setPosition(100, 250);
		specialmonsterslist.add(monster3);	
		
		
		return monster3;
	
	}
	public GameObject createmonstertest4 (Scene sc){
		Random rx = new Random() ;
		x = rx.nextInt(420);
		Monster_Test4_in_Sky_village_1 monster = new Monster_Test4_in_Sky_village_1(activity.load.createResource.getTexture(40), activity.getVertexBufferObjectManager(), activity);
		monster.setPosition(100, 0);
		monsterslist.add(monster);	
		
		return monster;
	
	}
	public GameObject createmonstertest5 (Scene sc){
		Random rx = new Random() ;
		x = rx.nextInt(420);
		Monster_Test5_in_Sky_village_1 monster = new Monster_Test5_in_Sky_village_1(activity.load.createResource.getTexture(41), activity.getVertexBufferObjectManager(), activity);
		monster.setPosition(10, -1000);
		monsterslist.add(monster);	
		
		return monster;
	
	}
	
	public ArrayList<Monster> getMonsterList(){
		return monsterslist;
	}
	public ArrayList<Monster_Test3_in_Sky_village_1> getspecialMonsterList(){
		return specialmonsterslist  ;
	}
	
	public void removeMonster (GameObject object){
		monsterslist.remove(object);
	}
	public void removeMonsterspecial (GameObject object){
		specialmonsterslist.remove(object);
	}
    public float getx(){
    	return (float) monster3.x ;
    }
    public float gety(){
    	return (float) monster3.y ;
    }
}
