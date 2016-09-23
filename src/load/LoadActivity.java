/*
 * @Title LoadActivity.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author Zhouls
 * @date Sep 20, 2016 4:35:27 PM
 * @version 1.0
 */
package load;

import java.lang.ref.WeakReference;

import load.LoadScene.ILoadResListener;
import menu.MenuActivity;
import model.BaseActivity;

import org.cocos2d.nodes.CCDirector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * º”‘ÿΩÁ√Ê
 * 
 * @author Zhouls
 * @date Sep 20, 2016 4:35:27 PM
 */
public class LoadActivity extends BaseActivity {
	/**
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LoadScene loadScene = new LoadScene(new LoadResListener(this));
		CCDirector.sharedDirector().runWithScene(loadScene);
	}

	private class LoadResListener implements ILoadResListener {
		WeakReference<Activity> wReference;

		public LoadResListener(Activity activity) {
			wReference = new WeakReference<Activity>(activity);
		}

		/**
		 * @see load.LoadScene.ILoadResListener#onLoadSuccess()
		 */
		@Override
		public void onLoadSuccess() {
			// TODO Auto-generated method stub
			if (null != wReference && null != wReference.get()) {
				Activity activity = wReference.get();
				Intent intent = new Intent();
				intent.setClass(activity, MenuActivity.class);
				activity.startActivity(intent);
				activity.finish();
			}
		}
	}
}
