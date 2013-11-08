package aun.stategame;

public class State_game {
	
	
	public Statemenu state  ;
	
	public State_game (){
		state  = Statemenu.Gameplay ;
	}
	
	public enum Statemenu {
		Menuindex,Gameworldmenu
		 , Gameplay
	}
    
	public void setStatemenu(Statemenu state){
		this.state = state ; 
	}
	public Statemenu getStatemenu(){
		return state ;
	}


}


