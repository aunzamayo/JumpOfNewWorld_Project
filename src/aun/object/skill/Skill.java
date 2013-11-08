package aun.object.skill;

import aun.activity.GameJumpActivity;

public class Skill {
	
	private   String [] Stateskill = {"normal","flying","shoot","safetyfly"}; 
	private  String  skill ;
//	
	public Skill(GameJumpActivity activity) {
		
		skill = Stateskill[0] ;
	}
	
	public void useSkill(int sum_id_skill){
		
		if(sum_id_skill == 1){
			
		}else if(sum_id_skill == 2){
			
		}else if(sum_id_skill == 3){
			skill = Stateskill[1] ;			
		}else if(sum_id_skill == 4){
			
		}else if(sum_id_skill == 5){
			
		}else if(sum_id_skill == 6){
			skill = Stateskill[3] ;
		}else if(sum_id_skill == 7){
			
		}else if(sum_id_skill == 8){
			
		}else if(sum_id_skill == 9){
			skill = Stateskill[2] ;
		}
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
