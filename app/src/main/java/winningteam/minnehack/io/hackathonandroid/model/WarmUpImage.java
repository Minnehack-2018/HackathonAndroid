package winningteam.minnehack.io.hackathonandroid.model;

import android.content.Context;

public class WarmUpImage {
    private String mFilename;

    public WarmUpImage(String mFilename) {
        this.mFilename = mFilename;
    }

    public int getResourceId(Context mContext) {
        return mContext.getResources().getIdentifier(mFilename, "drawable", mContext.getPackageName());
    }
}
