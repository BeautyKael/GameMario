/*
 * @Title BaseActivity.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author Zhouls
 * @date Sep 20, 2016 4:45:18 PM
 * @version 1.0
 */
package model;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import android.app.Activity;
import android.os.Bundle;

/**
 * Àà×¢ÊÍ
 * 
 * @author Zhouls
 * @date Sep 20, 2016 4:45:18 PM
 */
public class BaseActivity extends Activity {

	protected CCGLSurfaceView surfaceView;

	/**
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		surfaceView = new CCGLSurfaceView(this);
		setContentView(surfaceView);
		CCDirector.sharedDirector().attachInView(surfaceView);
		CCDirector.sharedDirector().setDisplayFPS(true);
		CCDirector.sharedDirector().setLandscape(true);
		CCDirector.sharedDirector().setScreenSize(1280, 720);
	}
}
