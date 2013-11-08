package aun.manager;

import aun.activity.GameJumpActivity;
import aun.object.skill.Skill;

public class Skillmanager {
	
	GameJumpActivity activity ;
	public Skill serchskill ;
	public   String [] Stateskill = {"normal","flying"}; 
	public  String  skill ;
	
	public Skillmanager (GameJumpActivity activity){
		this.activity = activity ;
		skill = Stateskill[0] ;
		serchskill = new Skill(activity);
		
	}
	
	public String getSkill(){
		return skill ;
	}
	
	public void setSkill(String stateSkill){
		skill = stateSkill ;
	}
    
	public String [] getstateSkill(){
		return Stateskill ;
	}

}
