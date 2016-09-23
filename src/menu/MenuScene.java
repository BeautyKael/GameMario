/*
 * @Title MenuScene.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author Zhouls
 * @date Sep 22, 2016 6:04:07 PM
 * @version 1.0
 */
package menu;

import model.BaseScene;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemFont;
import org.cocos2d.menus.CCMenuItemSprite;
import org.cocos2d.nodes.CCSprite;

import android.util.Log;

/**
 * 主菜单场景
 * 
 * @author Zhouls
 * @date Sep 22, 2016 6:04:07 PM
 */
public class MenuScene extends BaseScene {
	public MenuScene() {
		super();
		init();
	}

	private void init() {
		// 背景
		CCLayer backLayer = CCLayer.node();
		CCSprite backSprite = CCSprite.sprite("map/map2.jpg");
		float xScale = scSize.width / backSprite.getTextureRect().size.width;
		float yScale = scSize.height / backSprite.getTextureRect().size.height;
		backSprite.setScaleX(xScale);
		backSprite.setScaleY(yScale);
		backSprite.setAnchorPoint(0, 0);
		backLayer.addChild(backSprite);
		this.addChild(backLayer, 1, 1);

		// 菜单
		CCMenu menu = CCMenu.menu();
		menu.setAnchorPoint(0, 0);
		menu.setPosition(scSize.width / 2, scSize.height * 3 / 4);
		// logo
		CCSprite logoSprite = CCSprite.sprite("ui/ui2.png");
		CCMenuItemSprite logoItem = CCMenuItemSprite.item(logoSprite);
		menu.addChild(logoItem);
		// 菜单项
		CCMenuItemFont.setFontSize(35);
		// 开始游戏
		CCMenuItemFont btnStart = CCMenuItemFont.item("Start", this,
				"startGame");
		menu.addChild(btnStart);
		// 离开游戏
		CCMenuItemFont btnQuit = CCMenuItemFont.item("Quit", this, "QuitGame");
		menu.addChild(btnQuit);

		menu.alignItemsVertically(20);
		this.addChild(menu, 2, 2);
	}

	public void startGame(Object object) {
		Log.e("cocos", "startGame!");
	}

	public void QuitGame(Object object) {
		Log.e("cocos", "QuitGame!");
	}
}