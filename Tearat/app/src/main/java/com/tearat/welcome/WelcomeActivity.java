package com.fyh.guide.welcome;

import android.widget.ImageView;

import com.fyh.R;
import com.fyh.aramis.crash.CrashUtil;
import com.fyh.base.BaseActivity;
import com.fyh.guide.guide.GuideActivity;
import com.fyh.utils.Constant;
import com.fyh.utils.ScreenUtils;

/**
 * Durian
 * 2017-2017/2/17
 */

public class WelcomeActivity extends BaseActivity {
    private ImageView img;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
        Constant.width = ScreenUtils.getScreenWidth(this);
        Constant.hight = ScreenUtils.getScreenHeight(this);
        bar.hide();
        img = getId(R.id.img_welcome);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                intentJump(getCurrentActivity(), GuideActivity.class, null);
                getCurrentActivity().finish();
            }
        }).start();

        new CrashUtil().postCrash(this);

//        try {
//            String crashAESKey = QEncodeUtil.aesEncrypt("crashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKey", "fyhnslm!@#$1");
//            Log.e("=============", "crashAESKey:" + crashAESKey);
//            String crashAESKey1 = NslmCryptoUtils.encrypt("crashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKeycrashAESKey");
//            Log.e("=============", "crashAESKey1:" + crashAESKey1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void setOnclick() {

    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }


    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
