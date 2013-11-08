package aun.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import aun.activity.GameJumpActivity;
import aun.stategame.State_game.Statemenu;



public class FirstMenuIndexScene extends BaseMenuScene {
	private final int	MENU_PLAY	= 0;
	private final int	MENU_Multi	= MENU_PLAY + 1;
	private final int	MENU_HighScore	= MENU_Multi + 1;
	private final int	MENU_Shop	= MENU_HighScore + 1;
	
	
	public FirstMenuIndexScene(GameJumpActivity gm , Camera camera) {
		super(gm, camera);
		this.createScene();
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		switch (pMenuItem.getID())
		{
			case MENU_PLAY:		
				activity.stategame.setStatemenu(Statemenu.Gameworldmenu);
				activity.scenmanager.setScene(activity.scenmanager.getmenuscene().get(1));
//				activity.scenmanager.setScene(activity.level1);
				break;
			case MENU_Multi:
//        		activity.scenmanager.setScene(activity.gameworldmultiplayer);
				activity.scenmanager.setScene(activity.scenmanager.getmenuscene().get(2));
				break;
            case MENU_HighScore:
//            	activity.scenmanager.setScene(activity.scenmanager.getmenuscene().get(3));
            	activity.scenmanager.setScene(activity.scenmanager.getsceneplay().get(1));
				break;
            case MENU_Shop:
//	            activity.showdialog();
//            	activity.initClient();
            	activity.save_state = false ;
            	activity.scenmanager.setScene(activity.scenmanager.getsceneplay().get(0));
	            break;

		}
		return false;
	}

	@Override
	public Scene createScene() {
		
		final AnimatedSprite background = new AnimatedSprite(0, 0, activity.load.createResource.getTexture(0), activity.getVertexBufferObjectManager());
		
		final AnimatedSprite HeadGame = new AnimatedSprite(0 , 0, activity.load.createResource.getTexture(5), activity.getVertexBufferObjectManager());
		
		final AnimatedSprite SoundOpen = new AnimatedSprite(0 , 0, activity.load.createResource.getTexture(6), activity.getVertexBufferObjectManager());
		
		final IMenuItem Story_Bn = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_PLAY, 200, 70, activity.load.createResource.getTexture(1),
				activity.getVertexBufferObjectManager()), 1.1f, 1);
		final IMenuItem Multi_Bn = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_Multi, 200, 70, activity.load.createResource.getTexture(2),
				activity.getVertexBufferObjectManager()), 1.1f, 1);
		final IMenuItem Highscore_Bn = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_HighScore, 200, 70, activity.load.createResource.getTexture(3),
				activity.getVertexBufferObjectManager()), 1.1f, 1);
		final IMenuItem Shop_Bn = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_Shop, 200, 70, activity.load.createResource.getTexture(4),
				activity.getVertexBufferObjectManager()), 1.1f, 1);
		
		HeadGame.setPosition(activity.getCameraWidth() / 2 - HeadGame.getWidth() / 2, 10);
		
//		Story_Bn.setPosition(450 - Story_Bn.getWidth() / 2, 100);
//		Multi_Bn.setPosition(450 - Multi_Bn.getWidth() / 2, 200);
//		Highscore_Bn.setPosition(450 - Highscore_Bn.getWidth() / 2, 300);
//		Shop_Bn.setPosition(450 - Shop_Bn.getWidth() / 2, 400);
	 			
		menuscene.addMenuItem(Story_Bn);
		menuscene.addMenuItem(Multi_Bn);
		menuscene.addMenuItem(Highscore_Bn);
		menuscene.addMenuItem(Shop_Bn);	
		menuscene.buildAnimations();	
		menuscene.setBackgroundEnabled(false);
		menuscene.setOnMenuItemClickListener(this);
		setChildScene(menuscene);
		attachChild(background);
		attachChild(HeadGame);
		attachChild(SoundOpen);
		
		return this;
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
