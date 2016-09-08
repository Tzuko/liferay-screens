package com.liferay.mobile.screens.westerosemployees.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.liferay.mobile.screens.westerosemployees.R;

/**
 * @author Víctor Galán Grande
 */
public class SignUpCard extends Card implements View.OnClickListener {
	public SignUpCard(Context context) {
		super(context);
	}

	public SignUpCard(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SignUpCard(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public SignUpCard(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();

		findViewById(R.id.terms).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		goRight();
	}
}
