package aun.network;

import java.io.IOException;
import java.net.Socket;

import org.andengine.entity.scene.Scene;
import org.andengine.extension.multiplayer.protocol.adt.message.server.IServerMessage;
import org.andengine.extension.multiplayer.protocol.client.IServerMessageHandler;
import org.andengine.extension.multiplayer.protocol.client.connector.ServerConnector;
import org.andengine.extension.multiplayer.protocol.client.connector.SocketConnectionServerConnector.ISocketConnectionServerConnectorListener;
import org.andengine.extension.multiplayer.protocol.shared.SocketConnection;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.loadgame.data.Loadgame;
import aun.message.MessageConstance;
import aun.scene.Level1;
import aun.scene.Scene_Battle_Client;
import aun.scene.level.Sky_village;
import aun.scene.level.Testmulti;
import aun.update.objectnetwork.PlayerClassRoom;
import aun.update.objectnetwork.SetPaddleIDServerMessage;
import aun.update.objectnetwork.UpdatePlayerServerTest;
import aun.update.objectnetwork.UpdateServerPlayerMessage;


public class ServerAndClient extends ServerConnector<SocketConnection> implements MessageConstance {
		
	GameJumpActivity activity ;
//	Testmulti t = (Testmulti)activity.scenmanager.getsceneplay().get(1) ;
	
	
	
	public ServerAndClient (final String pServerIP, 
			final ISocketConnectionServerConnectorListener pSocketConnectionServerConnectorListener,
			final GameJumpActivity gm) throws IOException {
		super(new SocketConnection(new Socket(pServerIP, SERVER_PORT )), pSocketConnectionServerConnectorListener);
	  
		
		
		this.activity = gm ;
		this.registerServerMessage(FLAG_Gravity, UpdateServerPlayerMessage.class, new IServerMessageHandler<SocketConnection>() {
			@Override
			public void onHandleMessage(final ServerConnector<SocketConnection> pServerConnector, final IServerMessage pServerMessage) throws IOException {
				final UpdateServerPlayerMessage updateServerPlayerMessage = (UpdateServerPlayerMessage) pServerMessage;
//				scm.sceneForrest.setplayerposition(updateServerPlayerMessage.mX, updateServerPlayerMessage.mY);
//				activity.level1.b_player.setLinearVelocity(0.0f, -1);
//				Level1  level1 = (Level1) activity.scenmanager.getscene().get(0);
//				level1.player.setPosition(level1.player.getX() ,updateServerPlayerMessage.mY);
				
//				
//				if(activity.save_state == false ){
//					Sky_village p = (Sky_village) activity.scenmanager.getsceneplay().get(0);
//					p.player.setPosition(p.player.getX(), updateServerPlayerMessage.mY);
//				}else{
//				Loadgame load = (Loadgame) activity.scenmanager.getsceneplay().get(0);
//				load.player.setPosition(load.player.getX(), updateServerPlayerMessage.mY);
//				}
				for(int i = 0 ;i < activity.mserver.getmClientConnectors().size();i++){
					Testmulti t = (Testmulti)activity.scenmanager.getsceneplay().get(1) ;
					
//					t.playerlist_multi.get(i).Controlx();
					t.playerlist_multi.get(i).setY(updateServerPlayerMessage.mY);
					
//					Sky_village p = (Sky_village) activity.scenmanager.getsceneplay().get(0);
//					p.player.setPosition(p.player.getX(), updateServerPlayerMessage.mY);
				}
			}
		});
		
		this.registerServerMessage(FLAG_Jump, UpdateServerPlayerMessage.class, new IServerMessageHandler<SocketConnection>() {
			@Override
			public void onHandleMessage(final ServerConnector<SocketConnection> pServerConnector, final IServerMessage pServerMessage) throws IOException {			
//				activity.level1.b_player.setLinearVelocity(activity.level1.b_player.getPosition().x, -15f);
				
			}
		});
		this.registerServerMessage(FLAG_PlayerID, PlayerClassRoom.class, new IServerMessageHandler<SocketConnection>() {
			@Override
			public void onHandleMessage(final ServerConnector<SocketConnection> pServerConnector, final IServerMessage pServerMessage) throws IOException {			
				final PlayerClassRoom classroom = (PlayerClassRoom) pServerMessage; 
				Scene_Battle_Client  scene_battle = (Scene_Battle_Client) activity.scenmanager.getmenuscene().get(5);			
				scene_battle.character_server.setPosition(classroom.mX, classroom.mY);
//				activity.roombattle_Client.ip_server.setText("Ip" + " " + classroom.Ip_Server);
//				activity.roombattle_Client.ip_server.setText("Ip" + " " + classroom.Ip_Server);
				
				
				 
			}
		});
		this.registerServerMessage(FLAG_PlayerID_1, UpdatePlayerServerTest.class, new IServerMessageHandler<SocketConnection>() {
			@Override
			public void onHandleMessage(final ServerConnector<SocketConnection> pServerConnector, final IServerMessage pServerMessage) throws IOException {			
//				activity.level1.b_player.setLinearVelocity(activity.level1.b_player.getPosition().x, -15f);
				UpdatePlayerServerTest u = (UpdatePlayerServerTest) pServerMessage ;
				Scene_Battle_Client  scene_battle = (Scene_Battle_Client) activity.scenmanager.getmenuscene().get(5);
				scene_battle.character.setPosition(u.mX, u.mY) ;
			}
		});
		
	}

}
