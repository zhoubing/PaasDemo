package com.hst.meetingdemo.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.hifly.paasdemo.R;
import com.hst.fsp.VideoProfile;

public class ProfileUtils {

    private static final String s_profile_list[] = {"340x240", "640x480", "1280x720", "1920x1080"};

    public static String getProfileRecently(int width) {
        if (width <= 320) {
            return s_profile_list[0];
        } else if (width <= 640) {
            return s_profile_list[1];
        } else if (width <= 1280) {
            return s_profile_list[2];
        } else if (width <= 1920) {
            return s_profile_list[3];
        }
        return "";
    }

    public static void showProfileDialog(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, android.support.v7.appcompat.R.style.Theme_AppCompat_Dialog);
        builder.setTitle("分辨率");
        builder.setItems(s_profile_list, onClickListener);
        AlertDialog r_dialog = builder.create();
        r_dialog.show();
    }

    public static String getProfileList(int position) {
        return s_profile_list[position];
    }

    public static VideoProfile setProfile(VideoProfile profile, int position) {
        if (position == 0) {
            profile.width = 320;
            profile.height = 240;
        } else if (position == 1) {
            profile.width = 640;
            profile.height = 480;
        } else if (position == 2) {
            profile.width = 1280;
            profile.height = 720;
        } else if (position == 3) {
            profile.width = 1920;
            profile.height = 1080;
        }
        return profile;
    }
}
