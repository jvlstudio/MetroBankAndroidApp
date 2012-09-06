package com.javier.async;

import android.app.ProgressDialog;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

public class TestasyncActivity extends SherlockActivity {
	/** Called when the activity is first created. */
	String LOGIN_URL = "http://web1.mrlender.com:78/user/login";
	String MYACCOUNT_URL = "http://web1.mrlender.com:78/MyAccount";
	final String TAG = "MrLender";

	String APPLY_URL = "http://web1.mrlender.com:78/Apply";
	String MAKEPAYMENT_NORMAL_URL = "http://web1.mrlender.com:78/MakePayment/RolloverFullPay";
	String MAKEPAYMENT_REPAYMENT_URL = "http://web1.mrlender.com:78/MakePayment/RepaymentPlan";
	String MAKEPAYMENT_DMA_URL = "http://web1.mrlender.com:78/MakePayment/DMA";
	String MAKEPAYMENT_URL = "http://web1.mrlender.com:78/MakePayment/";

	String PRINCE_TEST = "http://prince-pc:90/MyAccount/BookRollover";
	
	String METRO_STEP4= "https://corporate.metrobankonline.co.uk/servlet/BrowserServlet?method=post&user=CARCUSER&windowName=currentaccount024177145203&WS_FragmentName=currentaccount024177145203&contextRoot=&companyId=GB0010001&compScreen=COMPOSITE.SCREEN_112066707827_024177145209&command=globusCommand&skin=arc-ib&enqaction=SELECTION&requestType=OFS.ENQUIRY&enqname=MCOR.ACCT.OVERVIEW.CURRENT&routineArgs=NONE&reqTabid=&WS_replaceAll=yes&WS_parentComposite=frameone032557145200";
	String METRO_STEP3= "https://corporate.metrobankonline.co.uk/servlet/BrowserServlet";
	
	String METRO_STEP2 = "https://corporate.metrobankonline.co.uk/servlet/j_security_check";
	String METRO_STEP1 = "https://corporate.metrobankonline.co.uk/modelbank/unprotected/LoginServlet";

	String METRO_STEP0 = "https://corporate.metrobankonline.co.uk";

	ProgressDialog myProgressDialog = null;
	static PersistentCookieStore persistentCookieStore = null;
	static AsyncHttpClient httpClient;


	private EditText editText1;
	private EditText editText2;
	private EditText editText3;
	
	private TextView accountDetails;
	private TextView securityCharacters;

	String firstparameter = "";
	String secondparameter = "";

	/* Please visit http://www.ryangmattison.com for updates */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Log.i("Javier", "Finis2h");

		persistentCookieStore = new PersistentCookieStore(this);

		httpClient = new AsyncHttpClient();

		persistentCookieStore.clear();
		httpClient.setUserAgent(getUserAgent());
		httpClient.setCookieStore(persistentCookieStore);
		// httpClient.getHttpClient().getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS,
		// true);
		// httpClient.getHttpClient().getParams().setParameter(ClientPNames.HANDLE_REDIRECTS,
		// true);

		// PROXY SETTING HERE FOR FIDDLER
		// HttpHost proxy = new HttpHost("192.168.150.82", 8888);
		// httpClient.getHttpClient().getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
		// proxy);
		//
		// printCookies();
		
		getSupportActionBar().setTitle("metro");

		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText4);
		accountDetails = (TextView) findViewById(R.id.textView1);
		securityCharacters = (TextView) findViewById(R.id.textView2);
 		

	}

	public void clickSetParams(View v) {

		RequestParams params = new RequestParams();

		params.put("Password", "Dmdhsmdx4");
		params.put("Character2", editText3.getText().toString().trim());
		params.put("Character0", editText1.getText().toString().trim());
		params.put("Character1", editText2.getText().toString().trim());

		System.out.println(params.toString());

		httpClient.post(METRO_STEP1, params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {

				System.out.println("metrobank2 response " + response);
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
				
				clickGetAcc();
				

			}

			public void onFailure(Throwable error, String content) {
				System.out.println("metrobank2 e1r11ror  " + content);

			}

		});
	}


	public void printCookies() {

		System.out.println("cookise " + persistentCookieStore.getCookies().size());

	}

	public void clickButton(View view) {

		// testLogin(MYACCOUNT_URL, true);

		// princeTest();

		persistentCookieStore.clear();
		testMetroBank();
		// testFirstMakePayment();
		// Applicant.getInstance().initializeData();
		// testApplyMrLendeR();
	}

	
	public String getUserAgent() {

		PackageInfo pinfo = null;
		try {
			pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
		} catch (NameNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String versionName = pinfo.versionName;
		String ua = new WebView(this).getSettings().getUserAgentString();
		String finalUserAgent = "MRL (" + ua + ") MRLApp/" + versionName;
		Log.i(TAG, "Javier user agent " + finalUserAgent);

		return finalUserAgent;

		// mrLenderClient.addHeader("User-Agent", finalUserAgent);

	}

	

	public void testMetroBank() {

		System.out.println("test metrobank");
		printCookies();

		// RequestParams params = new RequestParams();
		//
		// // pending michael jackson
		// params.put("UserId", "112066707827");
		// params.put("Password", "4659439731649964");
		// params.put("Character0", "1");
		// params.put("Character2", "3");

		// params.put("j_username", "112066707827");

		// params.put("Password", "rebecca97058");
		myProgressDialog = ProgressDialog.show(TestasyncActivity.this, "11Please wait...", "Doing Extreme Calculations...", true);
		new Thread() {
			public void run() {
				try {
					// Do some Fake-Work

				} catch (Exception e) {
				}
				// Dismiss the DialRog

			}
		}.start();

		httpClient.get(METRO_STEP0, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {
				// System.out.println("metrobank response " + response);
				myProgressDialog.dismiss();

				RequestParams params = new RequestParams();

				// pending michael jackson
				params.put("UserId", "112066707827");
				// params.put("Password", "4659439731649964");
				// params.put("Character0", "1");
				// params.put("Character1", "2");
				// params.put("Character2", "3");

				httpClient.post(METRO_STEP1, params, new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						System.out.println("metrobank response " + response);
						// myProgressDialog.dismiss();

						securityCharacters.setText(getCharacters(response));
						
						
					}

					public void onFailure(Throwable error, String content) {
						System.out.println("metrobank error  " + error);
						myProgressDialog.dismiss();

					}

				});

			}

			public void onFailure(Throwable error, String content) {
				System.out.println("metrobank error  " + error);
				myProgressDialog.dismiss();

			}

		});

	}

	public void clickGetAcc()

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
				clickJavier();
			}

			public void onFailure(Throwable error, String content) {
				System.out.println("metrobank2 e1rror  " + content);
				myProgressDialog.dismiss();

			}

		});

		
		
		
	}
	
	
	public void clickJavier()

	{



		httpClient.get(METRO_STEP3,  new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {

				System.out.println("metrobank5 response " + response);
				// myProgressDialog.dismiss();

				clickFinal();
			}

			public void onFailure(Throwable error, String content) {
				System.out.println("metrobank2 e1rror  " + content);
				myProgressDialog.dismiss();

			}

		});

	}


	public void clickFinal()

	{



		httpClient.get(METRO_STEP4,  new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {

				System.out.println("metrobank5 response " + response);
				// myProgressDialog.dismiss();
				
				
				
				 BancoVO ban=parceaDatos(response);
			        ban.datos();//imprime los 5 campos del bean
				accountDetails.setText(ban.getDatos());
				

			}

			public void onFailure(Throwable error, String content) {
				System.out.println("metrobank2 e1rror  " + content);
				myProgressDialog.dismiss();

			}

		});

	}

	
	 public BancoVO parceaDatos(String htmlString){
	       BancoVO banco=  BancoVO.getInstance();
	       //indice de donde parto para hacer la busqueda
	       int indiceToken=htmlString.lastIndexOf("Available Balance");
	       String restante="";
	       //si lo encuentra entonces sustraer
	       if(indiceToken!= -1){
	           restante=htmlString.substring(indiceToken+22);
	           System.out.println("RESTANTE="+restante);
	           
	           boolean terminado=false;
	           int caso=1;
	           int indInicial=restante.indexOf("<td");
	           int indFinal=restante.indexOf("</td>");
	          // System.out.println("indInicial:"+indInicial+" indFinal:"+indFinal);
	           
	           while(terminado==false){
	               //sacamos la EMPRESA
	               if(caso==1){
	                   String name=restante.substring(indInicial , indFinal );
	                   banco.setNombreEmpresa(name.substring(name.indexOf(">")+1));
	                   caso++;
	               }else if(caso==2){//Account No
	                   String acount=restante.substring(indInicial , indFinal );
	                   banco.setNumCuenta(acount.substring(acount.indexOf(">")+1));
	                   caso++;
	               
	               }else if(caso==3){
	                   System.out.println("nada aki:"+restante.substring(indInicial , indFinal ));
	                    caso++;              
	               
	               }else if(caso==4){//Product Type
	                   String producto=restante.substring(indInicial , indFinal );
	                   banco.setTipoCuenta(producto.substring(producto.indexOf(">")+1));
	                   caso++;
	                
	                
	               }else if(caso==5){//Current Balance
	                   String current=restante.substring(indInicial , indFinal );
	                   banco.setSaldoActual(current.substring(current.indexOf(">")+1));
	                   caso++;
	              
	               }else if(caso==6){//Available Balance
	                   String available=restante.substring(indInicial , indFinal );
	                   banco.setSaldoDisponible(available.substring(available.indexOf(">")+1));
	                   
	                   caso++;
	                   terminado=true;
	               }
	 
	               restante=restante.substring(indFinal+5);               
	                
	               indInicial=restante.indexOf("<td");
	               indFinal=restante.indexOf("</td>");
	                                                         
	           }

	       }
	        
	       return banco;
	    }
	 
	  public String getCharacters(String htmlString){
	        //indice de donde parto para hacer la busqueda
	        int indiceToken=htmlString.indexOf("Please enter");
	        String restante="";
	        
	        String caracteres="";
	        //si lo encuentra entonces sustraer
	        if(indiceToken!= -1){
	            restante=htmlString.substring(indiceToken + 12);
	            caracteres= caracteres + restante.substring(0,13)+ "\n";
//	            System.out.println("char" + caracteres);
	            caracteres+= getCharacters(restante);
	         
	        }
			return caracteres;
	        
	        
	     }

}
