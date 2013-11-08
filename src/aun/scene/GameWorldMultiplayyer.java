package aun.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.TextMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ColorMenuItemDecorator;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import android.opengl.GLES20;
import aun.activity.GameJumpActivity;
import aun.object.GameObject;
import aun.stategame.State_game.Statemenu;

public class GameWorldMultiplayyer extends BaseMenuScene {
	
	protected static final int Menu_Create = 0;
	protected static final int Menu_Join = Menu_Create + 1 ;
	public GameWorldMultiplayyer(GameJumpActivity gm, Camera camera) {
		super(gm, camera);
		this.createScene();
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		switch (pMenuItem.getID())
		{
			case  Menu_Create:
				activity.initClient();
            	activity.scenmanager.setScene(activity.scenmanager.getmenuscene().get(5));
				break;
            case  Menu_Join:
	            activity.showdialog();
	            break;
		}
		return false;
	}

	@Override
	public Scene createScene() {

		final GameObject ShowLevel1 = Showpopup1();
	    final Text text = ShowText();

		final GameObject Popuplevel1 = new GameObject(activity.load.createResource.getTexture(22),activity.getVertexBufferObjectManager(), activity);
		Popuplevel1.setPosition((activity.getCameraWidth()/2) - Popuplevel1.getWidth()/2,(activity.getCamaraHeight()/2)-Popuplevel1.getHeight()/2);	
		Popuplevel1.setVisible(false);
		
		
		final GameObject Textbox = new GameObject(activity.load.createResource.getTexture(25),activity.getVertexBufferObjectManager(), activity);
		Textbox.setPosition((activity.getCameraWidth()/2) - Textbox.getWidth()/2,(activity.getCamaraHeight()/2)-Textbox.getHeight()/2);	
		Textbox.setScale(1.15f);
		Textbox.setVisible(false);
		
		
		final GameObject Level = new GameObject(activity.load.createResource.getTexture(26),activity.getVertexBufferObjectManager(), activity);
		Level.setPosition(20,220);	
		Level.setVisible(false);
		
		final IMenuItem Join = new ColorMenuItemDecorator(new TextMenuItem(Menu_Join,activity.load.getFont(), "JOIN", activity.getVertexBufferObjectManager()),Color.RED , Color.BLACK);
		Join.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
		menuscene.addMenuItem(Join);  		
		Join.setScale(0.75f);
			
    	 final IMenuItem Create = new ColorMenuItemDecorator(new TextMenuItem(Menu_Create,activity.load.getFont(), "Create", activity.getVertexBufferObjectManager()),Color.RED , Color.BLACK);
		 Create.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
		 menuscene.addMenuItem(Create);  		 
		 Create.setScale(0.75f);
		    	    
		
		
		final GameObject Exit = new GameObject(activity.load.createResource.getTexture(23),activity.getVertexBufferObjectManager(), activity){
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				Popuplevel1.setVisible(false);
				setVisible(false);
				Textbox.setVisible(false);
				Level.setVisible(false);
				ShowLevel1.setVisible(false);
				text.setVisible(false);
				Join.setVisible(false);
				Create.setVisible(false);
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
				Textbox.setVisible(true);
				Level.setVisible(true);
				ShowLevel1.setVisible(true);
				text.setVisible(true);
				Join.setVisible(true);
				Create.setVisible(true);
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
		setTouchAreaBindingOnActionDownEnabled(true);
        
		attachChild(Popuplevel1);
		attachChild(Exit);
		attachChild(Textbox);
		attachChild(Level);
		attachChild(ShowLevel1);
	    attachChild(text);
		 
		 menuscene.buildAnimations();
		 menuscene.setBackgroundEnabled(false);
		 menuscene.setOnMenuItemClickListener(this);
		 Join.setPosition(250,445);
		 Create.setPosition(50,445);
		 Join.setVisible(false);
		 Create.setVisible(false);
		 setChildScene(menuscene);
		
		return this;
	}
	
	public GameObject Showpopup1(){
		final GameObject Level1_Bn = new GameObject(activity.load.createResource.getTexture(10),activity.getVertexBufferObjectManager(), activity);
		Level1_Bn.setPosition(40,300);
		Level1_Bn.setScale(1.4f);
		Level1_Bn.setVisible(false);
		return Level1_Bn ;
	}
	public Text ShowText(){
		final Text titleText = new Text(0, 0,activity.load.getFont(), "This is a \nsky village", new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
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
