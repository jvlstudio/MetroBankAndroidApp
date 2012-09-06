package com.javier.async;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class Home extends SherlockActivity {
	/** Called when the activity is first created. */


	/* Please visit http://www.ryangmattison.com for updates */

	public TextView securityCharacters;
	private EditText editText1;
	private EditText editText2;
	private EditText editText4;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);


 		getSupportActionBar().hide();

	}
	
	public void clickLogin1(View v)
	{ 
		
		ServerConnections connections = ServerConnections.getInstance(getApplicationContext());
		
		connections.setActivity(this);
		connections.testMetroBank(); 
		
		
	}
	
	public void clickStep2(View v)
	{ 
		
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText4 = (EditText) findViewById(R.id.editText4);
		ServerConnections connections = ServerConnections.getInstance(getApplicationContext());
		connections.Step2(editText1.getText().toString(), editText2.getText().toString(), editText4.getText().toString());
	}
	
	public Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			String message = (String.valueOf(msg.obj));
			
				setContentView(R.layout.securitychar);
				securityCharacters = (TextView ) findViewById(R.id.SecurityCharacteres);
				
				message = "Please enter characters " + message.substring(2,7) + " from your Security Number.";
				securityCharacters.setText(message);
			



		}
	};

	
}
