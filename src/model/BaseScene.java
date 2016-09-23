/*
 * @Title BaseScene.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author Zhouls
 * @date Sep 22, 2016 6:08:18 PM
 * @version 1.0
 */
package model;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGSize;

/**
 * Àà×¢ÊÍ
 * 
 * @author Zhouls
 * @date Sep 22, 2016 6:08:18 PM
 */
public class BaseScene extends CCScene {

	protected CGSize scSize;

	public BaseScene() {
		scSize = CCDirector.sharedDirector().winSize();
	}

}
