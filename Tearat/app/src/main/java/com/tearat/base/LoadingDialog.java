package com.fyh.aramis.custom;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.fyh.R;


/**
 * 等待框
 * 
 * @author Aramis
 *
 */

public class LoadingDialog extends Dialog {
	private ImageView mLoading;
	private Context mContext;
	public LoadingDialog(Context context) {
		super(context, R.style.new_custom_dialog);
		this.mContext = context;
		initialize("");
	}

	public LoadingDialog(Context context, String message){
		super(context,R.style.new_custom_dialog);
		this.mContext = context;
		initialize(message);
	}
	public void initialize(String message){
		if(TextUtils.isEmpty(message)){
			message = "正在获取数据...";
		}
//		setContentView(R.layout.layout_common_outloading);
//		TextView id_tv_loadingmsg = (TextView) findViewById(R.id.loading_text);
//		mLoading = (ImageView)findViewById(R.id.loading_view);
//		id_tv_loadingmsg.setText("等等我...");
		setCancelable(true);
	}
	
	private void loadAnimation() {
		if (mLoading != null) {
			mLoading.clearAnimation();
			Animation loadAni = AnimationUtils.loadAnimation(getContext(),
					R.anim.loading);
			loadAni.setInterpolator(new LinearInterpolator());
			mLoading.startAnimation(loadAni);
		}
	}
	private void cancelLoading() {
		if (mLoading != null) {
			mLoading.clearAnimation();
		}
	}
	@Override
	public void dismiss() {
		cancelLoading();
		super.dismiss();
	}
	@Override
	public void show() {
		loadAnimation();
		super.show();
	}


	
	
}
