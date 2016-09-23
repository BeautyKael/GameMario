/*
 * @Title LoadScene.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author Zhouls
 * @date Sep 20, 2016 4:51:46 PM
 * @version 1.0
 */
package load;

import model.BaseScene;

import org.cocos2d.actions.CCProgressTimer;
import org.cocos2d.actions.UpdateCallback;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCSprite;

/**
 * 加载资源
 * 
 * @author Zhouls
 * @date Sep 20, 2016 4:51:46 PM
 */
public class LoadScene extends BaseScene {

	private CCProgressTimer ccProgressTimer;

	private ILoadResListener listener;

	public LoadScene(ILoadResListener listener) {
		super();
		init();
		this.listener = listener;
	}

	private void init() {
		// 背景
		CCLayer backLayer = CCLayer.node();
		CCSprite backSprite = CCSprite.sprite("map/map1.jpg");
		float xScale = scSize.width / backSprite.getTextureRect().size.width;
		float yScale = scSize.height / backSprite.getTextureRect().size.height;
		backSprite.setScaleX(xScale);
		backSprite.setScaleY(yScale);
		backSprite.setAnchorPoint(0, 0);
		backLayer.addChild(backSprite);
		this.addChild(backLayer, 1, 1);

		// 加载资源
		LoadResource.load();
		ccProgressTimer = CCProgressTimer
				.progress("progressbar/progressbar1.png");
		ccProgressTimer
				.setType(CCProgressTimer.kCCProgressTimerTypeHorizontalBarLR);
		ccProgressTimer.setPercentage(0);
		ccProgressTimer.setAnchorPoint(0, 0);
		ccProgressTimer.setPosition(scSize.width / 3, 200);
		this.addChild(ccProgressTimer, 3, 3);
		this.schedule(new UpdateCallback() {

			@Override
			public void update(float d) {
				// TODO Auto-generated method stub
				int loadPercent = LoadResource.getPercent();
				ccProgressTimer.setPercentage(loadPercent);
				if (loadPercent >= 100 && !isInitOK) {
					isInitOK = true;
					if (null != listener) {
						listener.onLoadSuccess();
					}
				}
			}
		}, 1);
	}

	private boolean isInitOK = false;

	public interface ILoadResListener {
		public void onLoadSuccess();
	}

}
