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
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;
import com.viewpagerindicator.PageIndicator;

public class QuipperTest extends SherlockFragmentActivity {

	private static final String[] CONTENT = new String[] { "ACCOUNTS", "STATEMENTS", "PAYMENT ", "BANK" };
	FragmentPagerAdapter mAdapter;

	ViewPager mPager;

	PageIndicator mIndicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.black);
		getSupportActionBar().setTitle("Quipper");
		getSupportActionBar().setSubtitle("Hot Topics");
		// getSupportActionBar().setListNavigationCallbacks(list, this);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		// getSupportActionBar().setSelectedNavigationItem(1);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		// getSupportActionBar().setSelectedNavigationItem(1);
		getSupportActionBar().setLogo(R.drawable.ic_launcherquipper);
		getSupportActionBar().setDisplayUseLogoEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add("Search").setIcon(R.drawable.ic_action_search).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		SubMenu subMenu1 = menu.addSubMenu("Action Item");
		subMenu1.add("My Topics");
		subMenu1.add("Review");
		subMenu1.add("Config");

		MenuItem subMenu1Item = subMenu1.getItem();
		subMenu1Item.setIcon(R.drawable.ic_action_options);
		subMenu1Item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		return super.onCreateOptionsMenu(menu);
	}

}
