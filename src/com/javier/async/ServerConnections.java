package com.javier.async;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

public class ServerConnections {
	/** Called when the activity is first created. */
	Activity activity = null;

	public static final int MESSAGE_ERROR = 0x02;
	public static final int MESSAGE_SUCCESS = 0x01;

	String METRO_STEP4 = "https://corporate.metrobankonline.co.uk/servlet/BrowserServlet?method=post&user=CARCUSER&windowName=currentaccount024177145203&WS_FragmentName=currentaccount024177145203&contextRoot=&companyId=GB0010001&compScreen=COMPOSITE.SCREEN_112066707827_024177145209&command=globusCommand&skin=arc-ib&enqaction=SELECTION&requestType=OFS.ENQUIRY&enqname=MCOR.ACCT.OVERVIEW.CURRENT&routineArgs=NONE&reqTabid=&WS_replaceAll=yes&WS_parentComposite=frameone032557145200";
	String METRO_STEP3 = "https://corporate.metrobankonline.co.uk/servlet/BrowserServlet";

	String METRO_STEP2 = "https://corporate.metrobankonline.co.uk/servlet/j_security_check";
	String METRO_STEP1 = "https://corporate.metrobankonline.co.uk/modelbank/unprotected/LoginServlet";

	String METRO_STEP0 = "https://corporate.metrobankonline.co.uk";

	// ProgressDialog myProgressDialog = null;
	static AsyncHttpClient httpClient;
	private static Context context;

	String firstparameter = "";
	String secondparameter = "";
	private PersistentCookieStore myCookieStore;

	private ServerConnections(Context context) {

		ServerConnections.context = context;

		httpClient = new AsyncHttpClient();
		httpClient.setUserAgent(getUserAgent());

		myCookieStore = new PersistentCookieStore(context);
		httpClient.setCookieStore(myCookieStore);

	}

	private static ServerConnections serverConnections;

	/** A private Constructor prevents any other class from instantiating. */

	public static synchronized ServerConnections getInstance(Context context) {
		if (serverConnections == null) {
			serverConnections = new ServerConnections(context);
		}

		return serverConnections;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	private static String getUserAgent() {

		PackageInfo pinfo = null;
		try {
			pinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
		} catch (NameNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String versionName = pinfo.versionName;
		String ua = new WebView(context).getSettings().getUserAgentString();
		String finalUserAgent = "MRL (" + ua + ") MRLApp/" + versionName;
		Log.i("Javier", "Javier user agent1 " + finalUserAgent);

		return finalUserAgent;

		// mrLenderClient.addHeader("User-Agent", finalUserAgent);

	}

	public void setActivity(Activity activity) {

		this.activity = activity;

	}

	public void Step2(String one, String two, String three) {

		RequestParams params = new RequestParams();

		params.put("Password", "Dmdhsmdx4");
		params.put("Character2", three);
		params.put("Character0", one);
		params.put("Character1", two);

		System.out.println("JAVIER " + params.toString());

		httpClient.post(METRO_STEP1, params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {

				System.out.println("metrobank2 res1ponse " + response);
				// myProgressDialog.dismiss();

				String[] temp;

				/* delimiter */
				String delimiter = "\"";
				/*
				 * given string will be split by the argument delimiter
				 * provided.
				 */
				temp = response.split(delimiter);
				/* print substrings */
				for (int i = 0; i < temp.length; i++)
					System.out.println(temp[i]);

				firstparameter = temp[1];
				secondparameter = temp[3];

				System.out.println(firstparameter);
				System.out.println(secondparameter);

				Step3();

			}

			public void onFailure(Throwable error, String content) {
				System.out.println("metrobank2 e1r11ror  " + content);
				showError(content);

			}

		});
	}

	public void showError(String text) {
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

	}

	public void printCookies() {

		System.out.println("cookise " + myCookieStore.getCookies().size());

	}

	public void testMetroBank() {
		System.out.println("test metrobank");
		myCookieStore.clear();

		printCookies();

		// myProgressDialog = ProgressDialog.show(ServerConnections.this,
		// "11Please wait...", "Doing Extreme Calculations...", true);
		// new Thread() {
		// public void run() {
		// try {
		// // Do some Fake-Work
		//
		// } catch (Exception e) {
		// }
		// // Dismiss the DialRog
		//
		// }
		// }.start();

		httpClient.get(METRO_STEP0, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {
				// System.out.println("metrobank response " + response);
				// myProgressDialog.dismiss();

				RequestParams params = new RequestParams();

				params.put("UserId", "112066707827");

				httpClient.post(METRO_STEP1, params, new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						System.out.println("metrobank 1response " + response);
						// myProgressDialog.dismiss();

						Home homeActivity = (Home) activity;

						Message msg = new Message();
						msg.what = MESSAGE_ERROR;
						msg.obj = new String(getCharacters(response));
						homeActivity.handler.sendMessage(msg);

						// securityCharacters.setText(getCharacters(response));

					}

					public void onFailure(Throwable error, String content) {
						System.out.println("metrobank error  " + error + content);
						// myProgressDialog.dismiss();
						showError(content);

					}

				});

			}

			public void onFailure(Throwable error, String content) {
				System.out.println("metrobank error  " + error);
				// myProgressDialog.dismiss();
				showError(content);

			}

		});

	}

	public void Step3()

	{

		RequestParams params = new RequestParams();

		params.put("j_username", firstparameter.trim());
		params.put("j_password", secondparameter.trim());

		System.out.println(params.toString());

		httpClient.post(METRO_STEP2, params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {

				System.out.println("metrobank5 response " + response);
				// myProgressDialog.dismiss();
				Step4();
			}

			public void onFailure(Throwable error, String content) {
				System.out.println("metrobank2 e1rror  " + content);
				// myProgressDialog.dismiss();
				showError(content);

			}

		});

	}

	public void Step4()

	{

		httpClient.get(METRO_STEP3, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {

				System.out.println("metrobank5 response " + response);
				// myProgressDialog.dismiss();

				Step5();
			}

			public void onFailure(Throwable error, String content) {
				System.out.println("metrobank2 e1rror  " + content);
				// myProgressDialog.dismiss();
				showError(content);

			}

		});

	}

	public void Step5()

	{

		httpClient.get(METRO_STEP4, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {

				System.out.println("metrobank5 response " + response);
				// myProgressDialog.dismiss();

				BancoVO ban = parceaDatos(response);
				ban.datos();// imprime los 5 campos del bean

				System.out.println("VERY FIRST TIME");
				Intent myIntent = new Intent(context, MyAccountScreen.class);
				myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(myIntent);

			}

			public void onFailure(Throwable error, String content) {
				System.out.println("metrobank2 e1rror  " + content);
				// myProgressDialog.dismiss();
				showError(content);

			}

		});

	}

	public BancoVO parceaDatos(String htmlString) {
		BancoVO banco = BancoVO.getInstance();
		// indice de donde parto para hacer la busqueda
		int indiceToken = htmlString.lastIndexOf("Available Balance");
		String restante = "";
		// si lo encuentra entonces sustraer
		if (indiceToken != -1) {
			restante = htmlString.substring(indiceToken + 22);
			System.out.println("RESTANTE=" + restante);

			boolean terminado = false;
			int caso = 1;
			int indInicial = restante.indexOf("<td");
			int indFinal = restante.indexOf("</td>");
			// System.out.println("indInicial:"+indInicial+" indFinal:"+indFinal);

			while (terminado == false) {
				// sacamos la EMPRESA
				if (caso == 1) {
					String name = restante.substring(indInicial, indFinal);
					banco.setNombreEmpresa(name.substring(name.indexOf(">") + 1));
					caso++;
				} else if (caso == 2) {// Account No
					String acount = restante.substring(indInicial, indFinal);
					banco.setNumCuenta(acount.substring(acount.indexOf(">") + 1));
					caso++;

				} else if (caso == 3) {
					System.out.println("nada aki:" + restante.substring(indInicial, indFinal));
					caso++;

				} else if (caso == 4) {// Product Type
					String producto = restante.substring(indInicial, indFinal);
					banco.setTipoCuenta(producto.substring(producto.indexOf(">") + 1));
					caso++;

				} else if (caso == 5) {// Current Balance
					String current = restante.substring(indInicial, indFinal);
					banco.setSaldoActual(current.substring(current.indexOf(">") + 1));
					caso++;

				} else if (caso == 6) {// Available Balance
					String available = restante.substring(indInicial, indFinal);
					banco.setSaldoDisponible(available.substring(available.indexOf(">") + 1));

					caso++;
					terminado = true;
				}

				restante = restante.substring(indFinal + 5);

				indInicial = restante.indexOf("<td");
				indFinal = restante.indexOf("</td>");

			}

		}

		return banco;
	}

	public String getCharacters(String htmlString) {
		// indice de donde parto para hacer la busqueda
		int indiceToken = htmlString.indexOf("Please enter");
		String restante = "";

		String caracteres = "";
		// si lo encuentra entonces sustraer
		if (indiceToken != -1) {
			restante = htmlString.substring(indiceToken + 23);
//			caracteres = caracteres + restante.substring(0, 13) + "\n";
			caracteres = caracteres + restante.substring(0, 1) + ",";
			// System.out.println("char" + caracteres);
			caracteres += getCharacters(restante);
			
			

		}
		return caracteres;

	}

}
