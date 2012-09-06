/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.javier.async;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitleProvider;

public class MyAccountScreen extends SherlockFragmentActivity {

	private static final String[] CONTENT = new String[] { "ACCOUNTS", "STATEMENTS", "PAYMENT ", "BANK" };
	FragmentPagerAdapter mAdapter;

	ViewPager mPager;

	PageIndicator mIndicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// This has to be called before setContentView and you must use the
		// class in android.support.v4.view and NOT android.view
		// requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.fragment_pager);

		// mAdapter = new MyAdapter(getSupportFragmentManager());

		mAdapter = new GoogleMusicAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		mIndicator = (TabPageIndicator) findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);

		getExtras();

		getSupportActionBar().setTitle("MetroBank");
		getSupportActionBar().setSubtitle("My Account");
		// getSupportActionBar().setListNavigationCallbacks(list, this);

	}

	public void getExtras() {

	}

	class GoogleMusicAdapter extends FragmentPagerAdapter implements TitleProvider {
		public GoogleMusicAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		public Fragment getItem(int position) {

			return MyAccountFragment.newInstance(MyAccountScreen.CONTENT[position % MyAccountScreen.CONTENT.length]);
		}

		public int getCount() {
			return MyAccountScreen.CONTENT.length;
		}

		public String getTitle(int position) {
			return MyAccountScreen.CONTENT[position % MyAccountScreen.CONTENT.length].toUpperCase();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// menu = CommonMethods.createActionBarItems(menu);

		// menu.add("Logout").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

		return super.onCreateOptionsMenu(menu);
	}

}
