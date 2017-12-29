package com.letsgotoperfection.errorview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author hossam.
 *         By default it's invisible view if you want to make it visiable use attribute
 *         visibility = VISIBLE
 *         or it's equivalent java method
 */

public class ErrorView extends LinearLayout {
    String TAG = "ErrorView";
    private String errorText1, errorText2;
    private @ColorInt
    int errorTextColor1, errorTextColor2, errorIconColor;
    @DrawableRes
    int errorIconId;
    private TextView textView1, textView2;

    public ErrorView(@NonNull Context context) {
        super(context);
    }

    public ErrorView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ErrorView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) return;
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ErrorView, 0, 0);
        errorText1 = a.getString(R.styleable.ErrorView_Text1);
        errorText2 = a.getString(R.styleable.ErrorView_Text2);
        errorTextColor1 = a.getColor(R.styleable.ErrorView_TextColor1,
                getResources().getColor(R.color.errorTextColor1def));
        errorTextColor2 = a.getColor(R.styleable.ErrorView_TextColor2,
                getResources().getColor(R.color.errorTextColor2def));
        errorIconColor = a.getColor(R.styleable.ErrorView_IconColor,
                getResources().getColor(R.color.errorImageIconDefaultTint));
        errorIconId = a.getResourceId(R.styleable.ErrorView_Icon, R.drawable.ic_error_default_icon);

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.error_view, this, true);
        }

        RelativeLayout relativeLayout = (RelativeLayout) getChildAt(0);
        LinearLayout linearLayout = (LinearLayout) relativeLayout.getChildAt(0);

        textView1 = (TextView) linearLayout.getChildAt(1);
        if (errorText1 != null && !errorText1.isEmpty()) {
            textView1.setText(errorText1);
        }
        textView1.setTextColor(errorTextColor1);

        textView2 = (TextView) linearLayout.getChildAt(2);
        if (errorText2 != null && !errorText2.isEmpty()) {
            textView2.setText(errorText2);
        }

        textView2.setTextColor(errorTextColor2);

        ImageView mImage = (ImageView) linearLayout.getChildAt(0);

        mImage.setImageResource(errorIconId);
        mImage.setColorFilter(errorIconColor, android.graphics.PorterDuff.Mode.SRC_IN);

        a.recycle();
    }
}
