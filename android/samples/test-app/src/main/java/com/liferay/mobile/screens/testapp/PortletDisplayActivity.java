package com.liferay.mobile.screens.testapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.liferay.mobile.screens.portlet.PortletConfiguration;
import com.liferay.mobile.screens.portlet.PortletDisplayListener;
import com.liferay.mobile.screens.portlet.PortletDisplayScreenlet;
import com.liferay.mobile.screens.viewsets.defaultviews.portlet.cordova.CordovaLifeCycleObserver;

/**
 * @author Sarai Díaz García
 */
public class PortletDisplayActivity extends ThemeActivity implements PortletDisplayListener {

	private CordovaLifeCycleObserver observer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		observer = new CordovaLifeCycleObserver();

		setContentView(R.layout.portlet_display);

		PortletDisplayScreenlet screenlet =
			(PortletDisplayScreenlet) findViewById(R.id.portlet_display_screenlet);

		if (getIntent().getStringExtra("url") != null) {
			PortletConfiguration portletConfiguration =
				new PortletConfiguration.Builder(getIntent().getStringExtra("url")).addRawCss(
					R.raw.portletcss, "portlet.css")
					.addLocalCss("gallery.css")
					.addLocalJs("gallery.js")
					.enableCordova(observer)
					.load();

			screenlet.setPortletConfiguration(portletConfiguration);

			screenlet.setListener(this);
			screenlet.setScrollEnabled(true);
			screenlet.load();
		}
	}

	@Override
	protected void onStart() {
		super.onStart();

		observer.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();

		observer.onStop();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		observer.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
		super.onPause();

		observer.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();

		observer.onResume();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		observer.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

		observer.onConfigurationChanged(newConfig);
	}

	@Override
	public void error(Exception e, String userAction) {
		error(getString(R.string.portlet_display_error), e);
	}

	@Override
	public void onPageLoaded(String url) {
		info(getString(R.string.portlet_display_success));
	}

	@Override
	public void onScriptMessageHandler(String namespace, String body) {
		if ("gallery".equals(namespace)) {
			String[] allImgSrc = body.split(",");
			int imgSrcPosition = Integer.parseInt(allImgSrc[allImgSrc.length - 1]);

			Intent intent = new Intent(getApplicationContext(), DetailMediaGalleryActivity.class);
			intent.putExtra("allImgSrc", allImgSrc);
			intent.putExtra("imgSrcPosition", imgSrcPosition);
			startActivity(intent);
		}
	}
}
