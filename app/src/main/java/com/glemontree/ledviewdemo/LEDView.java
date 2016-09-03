package com.glemontree.ledviewdemo;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Administrator on 2016/9/3.
 */
public class LEDView extends LinearLayout {
    private TextView timeView;
    private TextView bgView;
    private static final String DATE_FORMAT = "%02d:%02d:%02d";
    private static final int REFRESH_DELAY = 500;
    public LEDView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public LEDView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LEDView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.ledview, this);
        timeView = (TextView) view.findViewById(R.id.ledview_clock_time);
        bgView = (TextView) view.findViewById(R.id.ledview_clock_bg);
    }

    private final Handler mHandler = new Handler();

    private final Runnable mTimeRefresher = new Runnable() {
        @Override
        public void run() {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            final Date d = new Date();
            calendar.setTime(d);
            timeView.setText(String.format(DATE_FORMAT, calendar.get(Calendar.HOUR),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)));
            mHandler.postDelayed(this, REFRESH_DELAY);
        }
    };

    public void start() {
        mHandler.post(mTimeRefresher);
    }

    public void stop() {
       mHandler.removeCallbacks(mTimeRefresher);
    }
}
