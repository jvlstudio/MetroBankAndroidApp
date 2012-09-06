package com.javier.async;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class MyAccountFragment extends SherlockFragment {

	private static final String KEY_CONTENT = "TestFragment:Content";

	
	/**********DECLARES*************/
	private TextView AccName;
	private TextView AccNumber;
	private TextView AccType;
	private TextView AccBalance;
	private TextView AccAvBalance;
	/**********INITIALIZES*************/
	
	
	private String loanStatus;

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	/**
	 * 
	 * 
	 * Create a new instance of CountingFragment, providing "num" as an
	 * argument.
	 */
	static MyAccountFragment newInstance(String content) {
		MyAccountFragment fragment = new MyAccountFragment();

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			builder.append(content).append(" ");
		}
		builder.deleteCharAt(builder.length() - 1);
		fragment.mContent = builder.toString();

		return fragment;

	}

	private String mContent = "???";

	/**
	 * When creating, retrieve this instance's number from its arguments.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// mNum = getArguments() != null ? getArguments().getInt("num") : 1;
	}

	/**
	 * The Fragment's UI is just a simple text view showing its instance number.
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// View v = inflater.inflate(R.layout.fragment_pager_list, container,
		// false);

		if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
			mContent = savedInstanceState.getString(KEY_CONTENT);
		}
		
		View v = inflater.inflate(R.layout.myaccountactive, container, false);
		
		
		AccName = (TextView) v.findViewById(R.id.AccName);
		AccNumber = (TextView) v.findViewById(R.id.AccNumber);
		AccType = (TextView) v.findViewById(R.id.AccType);
		AccBalance = (TextView) v.findViewById(R.id.AccBalance);
		AccAvBalance = (TextView) v.findViewById(R.id.AccAvBalance);
		
		BancoVO banco= BancoVO.getInstance();
		System.out.println("saldo d1isponible " + BancoVO.getInstance().getSaldoDisponible());
		
		AccName.setText( banco.getNombreEmpresa());
		AccNumber.setText( banco.getNumCuenta());
		AccType.setText(banco.getTipoCuenta());
		AccBalance.setText("£"+banco.getSaldoActual());
		AccAvBalance.setText("£"+banco.getSaldoDisponible());
		
		
		
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// savedInstanceState.putString(KEY_CONTENT, mContent);

	}

}
