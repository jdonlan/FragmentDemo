package com.fullsail.android.fragmentdemo.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.fullsail.android.fragmentdemo.R;

public class ButtonsFragment extends Fragment implements OnClickListener {
	
	public static final String TAG = "ButtonsFragment.TAG";
	
	public static ButtonsFragment newInstance() {
		ButtonsFragment frag = new ButtonsFragment();
		return frag;
	}
	
	public interface OnButtonClickListener {
		public void displayText(String text);
	}
	
	private OnButtonClickListener mListener;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		if(activity instanceof OnButtonClickListener) {
			mListener = (OnButtonClickListener) activity;
		} else {
			throw new IllegalArgumentException("Containing activity must implement OnButtonClickListener interface");
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle _savedInstanceState) {
		View view = inflater.inflate(R.layout.buttons_fragment, container, false);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		View view = getView();

		Button button = (Button) view.findViewById(R.id.android_3_button);
		button.setOnClickListener(this);

		button = (Button) view.findViewById(R.id.android_8_button);
		button.setOnClickListener(this);

		button = (Button) view.findViewById(R.id.android_11_button);
		button.setOnClickListener(this);

		button = (Button) view.findViewById(R.id.android_14_button);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.android_3_button:
			mListener.displayText(getString(R.string.android_3_name));
			break;
		case R.id.android_8_button:
			mListener.displayText(getString(R.string.android_8_name));
			break;
		case R.id.android_11_button:
			mListener.displayText(getString(R.string.android_11_name));
			break;
		case R.id.android_14_button:
			mListener.displayText(getString(R.string.android_14_name));
			break;
		}
	}
}