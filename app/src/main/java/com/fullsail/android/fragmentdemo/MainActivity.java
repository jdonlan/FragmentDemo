package com.fullsail.android.fragmentdemo;

import android.app.Activity;
import android.os.Bundle;

import com.fullsail.android.fragmentdemo.fragment.ButtonsFragment;
import com.fullsail.android.fragmentdemo.fragment.ButtonsFragment.OnButtonClickListener;
import com.fullsail.android.fragmentdemo.fragment.DisplayFragment;

public class MainActivity extends Activity implements OnButtonClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(savedInstanceState == null) {
			ButtonsFragment frag = ButtonsFragment.newInstance();
			getFragmentManager().beginTransaction()
                    .replace(R.id.container1, frag, ButtonsFragment.TAG)
                    .commit();
		}
	}

	@Override
	public void displayText(String text) {
		DisplayFragment frag = (DisplayFragment)getFragmentManager().findFragmentByTag(DisplayFragment.TAG);
		
		if(frag == null) {
			frag = DisplayFragment.newInstance(text);
			getFragmentManager().beginTransaction()
                    .replace(R.id.container2, frag, DisplayFragment.TAG)
                    .commit();
		} else {
			frag.setDisplayText(text);
		}
	}
}
