package aun.network;

import org.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.andengine.extension.multiplayer.protocol.server.connector.SocketConnectionClientConnector.ISocketConnectionClientConnectorListener;
import org.andengine.extension.multiplayer.protocol.shared.SocketConnection;



import android.widget.Toast;
import aun.activity.GameJumpActivity;

public class ClientConnectorListener implements ISocketConnectionClientConnectorListener {
	GameJumpActivity activity ;
	String a ;
	public ClientConnectorListener(GameJumpActivity gm) {
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
	public void onStarted(final ClientConnector<SocketConnection> pClientConnector) {
		this.toast("SERVER: Client connected: " + pClientConnector.getConnection().getSocket().getInetAddress().getHostAddress());
		a = pClientConnector.getConnection().getSocket().getInetAddress().getHostAddress() ;
	}

	@Override
	public void onTerminated(final ClientConnector<SocketConnection> pClientConnector) {
		this.toast("SERVER: Client disconnected: " + pClientConnector.getConnection().getSocket().getInetAddress().getHostAddress());
	}
	public final String getClientConnector (){
		return a;
	}

}
