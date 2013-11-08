package aun.network;



import org.andengine.extension.multiplayer.protocol.client.connector.ServerConnector;
import org.andengine.extension.multiplayer.protocol.client.connector.SocketConnectionServerConnector.ISocketConnectionServerConnectorListener;
import org.andengine.extension.multiplayer.protocol.shared.SocketConnection;




import android.widget.Toast;
import aun.activity.GameJumpActivity;

public class ServerConnectorListener implements ISocketConnectionServerConnectorListener {

	GameJumpActivity activity ;
	
	public ServerConnectorListener(GameJumpActivity gm) {
		this.activity = gm ;
	}

	private void toast(final String pMessage) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(activity, pMessage, Toast.LENGTH_SHORT).show();
			}
		});
	}	
	@Override
	public void onStarted(final ServerConnector<SocketConnection> pServerConnector) {
		this.toast("CLIENT: Connected to server.");
	}

	@Override
	public void onTerminated(final ServerConnector<SocketConnection> pServerConnector) {
		this.toast("CLIENT: Disconnected from Server.");
		activity.finish();
	}
	
	
	
	

}
