package com.test.json;

import android.content.Context;
import android.widget.Toast;

public class CommonMethods {

	public static void displayToast(String message, Context context) {

		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, message, duration);
		toast.show();

	}
}
