package com.liferay.mobile.screens.viewsets.lexicon.ddm.form.fields;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

import com.liferay.mobile.screens.viewsets.lexicon.R;
import com.liferay.mobile.screens.viewsets.lexicon.util.FormViewUtil;

public class DDMFieldCheckboxMultipleView
    extends com.liferay.mobile.screens.viewsets.defaultviews.ddm.form.fields.DDMFieldCheckboxMultipleView {

    public DDMFieldCheckboxMultipleView(Context context) {
        super(context);
    }

    public DDMFieldCheckboxMultipleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DDMFieldCheckboxMultipleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onPostValidation(boolean valid) {
        FormViewUtil.setupErrorView(valid, findViewById(R.id.error_view));
    }
}
