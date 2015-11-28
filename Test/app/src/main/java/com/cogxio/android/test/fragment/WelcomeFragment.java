package com.cogxio.android.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.cogxio.android.test.R;

/**
 * Created by Abhishek on 28/11/15.
 */
public class WelcomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View welcomeView = inflater.inflate(R.layout.fragment_welcome,container,false);
        showAnimation(welcomeView);

        return welcomeView;
    }

    private void showAnimation(View sourceView){

        final int DURATION = 1500;
        Animation slideInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.abc_slide_in_top);
        slideInAnimation.setDuration(DURATION);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.abc_grow_fade_in_from_bottom);
        fadeInAnimation.setDuration(DURATION);

        ImageView welcomeIv = (ImageView) sourceView.findViewById(R.id.welcome_iv);
        TextView welcomeQuoteTv = (TextView) sourceView.findViewById(R.id.welcome_quote_tv);
        welcomeIv.startAnimation(slideInAnimation);
        welcomeQuoteTv.startAnimation(fadeInAnimation);
    }
}
