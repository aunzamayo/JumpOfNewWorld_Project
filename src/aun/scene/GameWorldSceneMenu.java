package aun.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import android.view.MotionEvent;
import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.loadgame.data.Loadgame;
import aun.object.GameObject;
import aun.stategame.State_game.Statemenu;


public class GameWorldSceneMenu extends BaseMenuScene  {

    private final int Bt_character = 0 ; 
    IMenuItem BT ;
    
    GameObject Textbox ;
    GameObject Popuplevel1 ;
    GameObject Exit ;
    GameObject Ok ;
    GameObject Left ;
    GameObject Right ;
	
    public GameWorldSceneMenu(GameJumpActivity gm, Camera camera) {
		super(gm, camera);
		this.createScene();
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		switch (pMenuItem.getID()) {
		case Bt_character :
			Popuplevel1.setVisible(true);
			Ok.setVisible(true);
			Exit.setVisible(true);
			BT.setVisible(true);
			break;

		
		}	

		return false;
	}

	@Override
	public Scene createScene() {
		
		final GameObject ShowLevel1 = Showpopup1();
	    final Text text = ShowText();

	    Popuplevel1 = new GameObject(activity.load.createResource.getTexture(22),activity.getVertexBufferObjectManager(), activity);
		Popuplevel1.setPosition((activity.getCameraWidth()/2) - Popuplevel1.getWidth()/2,(activity.getCamaraHeight()/2)-Popuplevel1.getHeight()/2);	
		Popuplevel1.setVisible(false);
		
		 Ok = new GameObject(activity.load.createResource.getTexture(24),activity.getVertexBufferObjectManager(), activity){
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				
//				activity.stategame.setStatemenu(Statemenu.Gameplay);
//				activity.initClient();
//				activity.scenmanager.setScene(activity.scenmanager.getscene().get(0));
				activity.sceneplay.add(0, (Basescene_Coregame) new Loadgame(activity).createscene());
//				activity.sceneplay.remove(1);
				activity.save_state = true ;
				activity.scenmanager.setScene(activity.sceneplay.get(0));
				
				
				
				return true;
			}
		};
		Ok.setPosition((activity.getCameraWidth()/2) - Ok.getWidth()/2, 445);			
		Ok.setVisible(false);
		 
		Textbox = new GameObject(activity.load.createResource.getTexture(25),activity.getVertexBufferObjectManager(), activity);
		Textbox.setPosition((activity.getCameraWidth()/2) - Textbox.getWidth()/2,(activity.getCamaraHeight()/2)-Textbox.getHeight()/2);	
		Textbox.setScale(1.15f);
		Textbox.setVisible(false);
		
		
		final GameObject Level = new GameObject(activity.load.createResource.getTexture(26),activity.getVertexBufferObjectManager(), activity);
		Level.setPosition(20,220);	
		Level.setVisible(false);
		
		final GameObject Quest = new GameObject(activity.load.createResource.getTexture(27),activity.getVertexBufferObjectManager(), activity);
		Quest.setPosition(130,220);	
		Quest.setVisible(false);
		
		
		Exit = new GameObject(activity.load.createResource.getTexture(23),activity.getVertexBufferObjectManager(), activity){
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				Popuplevel1.setVisible(false);
				setVisible(false);
				Ok.setVisible(false);
				Textbox.setVisible(false);
				Level.setVisible(false);
				Quest.setVisible(false);
				ShowLevel1.setVisible(false);
				text.setVisible(false);
				return true;
			}
		};
		Exit.setPosition(394,202);			
		Exit.setVisible(false);  
		Exit.setScale(0.5f);
		
	
		
		final GameObject bg = new GameObject(activity.load.createResource.getTexture(18),activity.getVertexBufferObjectManager(), activity);
		attachChild(bg);
		
		final GameObject Level1_Bn = new GameObject(activity.load.createResource.getTexture(10),activity.getVertexBufferObjectManager(), activity){
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				Popuplevel1.setVisible(true);
				Exit.setVisible(true);
				Ok.setVisible(true);
				Textbox.setVisible(true);
				Level.setVisible(true);
				Quest.setVisible(true);
				ShowLevel1.setVisible(true);
				text.setVisible(true);
				return true;
			}
		};
		Level1_Bn.setPosition(68,575);
		Level1_Bn.setScale(1.4f);
		Level1_Bn.animate(500);
		attachChild(Level1_Bn);
		
		final GameObject Level2_Bn = new GameObject(activity.load.createResource.getTexture(11),activity.getVertexBufferObjectManager(), activity);
		Level2_Bn.setColor(Color.BLACK);
		Level2_Bn.setPosition(233,535);
		Level2_Bn.setScale(1.4f);
		Level2_Bn.animate(500);
		attachChild(Level2_Bn);
		
		final GameObject Level3_Bn = new GameObject(activity.load.createResource.getTexture(12),activity.getVertexBufferObjectManager(), activity);
		Level3_Bn.setColor(Color.BLACK);
		Level3_Bn.setPosition(320,400);
		Level3_Bn.setScale(1.4f);
		Level3_Bn.animate(500);
		attachChild(Level3_Bn);
		
		final GameObject Level4_Bn = new GameObject(activity.load.createResource.getTexture(13),activity.getVertexBufferObjectManager(), activity);
		Level4_Bn.setColor(Color.BLACK);
		Level4_Bn.setPosition(350,250);
		Level4_Bn.setScale(1.4f);
		Level4_Bn.animate(500);
		attachChild(Level4_Bn);
		
		final GameObject Level5_Bn = new GameObject(activity.load.createResource.getTexture(14),activity.getVertexBufferObjectManager(), activity);
		Level5_Bn.setColor(Color.BLACK);
		Level5_Bn.setPosition(208,195);
		Level5_Bn.setScale(1.4f);
		Level5_Bn.animate(500);
		attachChild(Level5_Bn);
		
		final GameObject Level6_Bn = new GameObject(activity.load.createResource.getTexture(15),activity.getVertexBufferObjectManager(), activity);
		Level6_Bn.setColor(Color.BLACK);
		Level6_Bn.setPosition(105,90);
		Level6_Bn.setScale(1.4f);
		Level6_Bn.animate(500);
		attachChild(Level6_Bn);
		
		final GameObject Level7_Bn = new GameObject(activity.load.createResource.getTexture(16),activity.getVertexBufferObjectManager(), activity);
		Level7_Bn.setColor(Color.BLACK);
		Level7_Bn.setPosition(298,20);
		Level7_Bn.setScale(1.4f);
		Level7_Bn.animate(500);
		attachChild(Level7_Bn);
		
		final GameObject gem = new GameObject(activity.load.createResource.getTexture(17),activity.getVertexBufferObjectManager(), activity);
		gem.setPosition(-100,200);
		gem.setScale(0.4f);
		attachChild(gem);
		
		registerTouchArea(Exit);
		registerTouchArea(Level1_Bn);
		registerTouchArea(Ok);
		setTouchAreaBindingOnActionDownEnabled(true);
		
		final IMenuItem BT_Character = new ScaleMenuItemDecorator(new SpriteMenuItem(Bt_character,64,32, activity.load.createResource.getTexture(37),activity.getVertexBufferObjectManager()), 2.6f, 2.5f);	
		menuscene.addMenuItem(BT_Character);
		menuscene.buildAnimations();	
		menuscene.setBackgroundEnabled(false);
		menuscene.setOnMenuItemClickListener(this);
		BT_Character.setPosition(380, 650);
//		BT_Character.setScale(2.5f);
		setChildScene(menuscene);
//		BT_Character.setVisible(false);
		Left = new GameObject(activity.load.createResource.getTexture(43),activity.getVertexBufferObjectManager(), activity){
			 
			 public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
//					if(pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN){
//						
//					}
				 
					return true;
			}
			 
		 };
		 Right = new GameObject(activity.load.createResource.getTexture(42),activity.getVertexBufferObjectManager(), activity){
			 public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
					if(pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN){
						
					}
				 
					return true;
			}
		 };
		 Left.setPosition(15, 50);
		 Right.setPosition(20, 105);
		 registerTouchArea(Left);
		 registerTouchArea(Right);
		 
		
		attachChild(Popuplevel1);
		attachChild(Exit);
		attachChild(Ok);
		attachChild(Textbox);
		attachChild(Left);
//	    attachChild.(Right);
		attachChild(Level);
		attachChild(Quest);
		attachChild(ShowLevel1);
	    attachChild(text);

//		createplayer();
	    
		return this;
	}
	public void createplayer(){
		BT = new ScaleMenuItemDecorator(new SpriteMenuItem(Bt_character, 128, 128, activity.load.createResource.getTexture(44),
				activity.getVertexBufferObjectManager()), 1.1f, 1);
		BT.setPosition(200, 200);
		BT.setVisible(false);
	}
	
	public GameObject Showpopup1(){
		final GameObject Level1_Bn = new GameObject(activity.load.createResource.getTexture(10),activity.getVertexBufferObjectManager(), activity);
		Level1_Bn.setPosition(40,300);
		Level1_Bn.setScale(1.4f);
		Level1_Bn.setVisible(false);
		return Level1_Bn ;
	}
	public Text ShowText(){
		final Text titleText = new Text(0, 0,activity.load.getFont(), "This is a \nsky village", new TextOptions(HorizontalAlign.LEFT), activity.getVertexBufferObjectManager());
		titleText.setPosition(((activity.getCameraWidth() - titleText.getWidth()) * 0.5f) + 30, (activity.getCamaraHeight() - titleText.getHeight()) * 0.5f);
		titleText.setScale(0.5f);
		titleText.setColor(Color.BLACK);
		titleText.setVisible(false);
		return titleText ;
	} 
	

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Scene getScene() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScene(Scene sc) {
		// TODO Auto-generated method stub
		
	}
	

}
