/*
 * @Title MenuActivity.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author Zhouls
 * @date Sep 22, 2016 6:03:58 PM
 * @version 1.0
 */
package menu;

import model.BaseActivity;

import org.cocos2d.nodes.CCDirector;

import android.os.Bundle;

/**
 * Ö÷²Ëµ¥
 * 
 * @author Zhouls
 * @date Sep 22, 2016 6:03:58 PM
 */
public class MenuActivity extends BaseActivity {
	/**
	 * @see model.BaseActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		CCDirector.sharedDirector().runWithScene(new MenuScene());
	}
}
