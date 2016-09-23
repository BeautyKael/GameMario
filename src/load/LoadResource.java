/*
 * @Title LoadResouce.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author Zhouls
 * @date Sep 20, 2016 5:48:30 PM
 * @version 1.0
 */
package load;

import android.util.Log;

/**
 * 资源加载器
 * 
 * @author Zhouls
 * @date Sep 20, 2016 5:48:30 PM
 */
public class LoadResource {

	private static String TAG = "LoadResource";
	private static int per = 0;
	private static Object perLock = new Object();

	/**
	 * 资源加载初始化
	 * 
	 * @return void
	 * @author Zhouls
	 * @date Sep 20, 2016 5:58:38 PM
	 */
	public static void load() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				loadImg();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				loadSound();
			}
		}).start();
	}

	/**
	 * 加载图片资源
	 * 
	 * @return void
	 * @author Zhouls
	 * @date Sep 20, 2016 5:59:01 PM
	 */
	private static void loadImg() {
		while (per < 100) {
			synchronized (perLock) {
				Log.d(TAG, "loadImg" + per);
				per++;
				if (per > 100) {
					per = 100;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	/**
	 * 加载声音资源
	 * 
	 * @return void
	 * @author Zhouls
	 * @date Sep 20, 2016 5:59:14 PM
	 */
	private static void loadSound() {
		while (per < 100) {
			synchronized (perLock) {
				Log.d(TAG, "loadSound" + per);
				per += 2;
				if (per > 100) {
					per = 100;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	/**
	 * 获取进度值
	 * 
	 * @return
	 * @return int
	 * @author Zhouls
	 * @date Sep 20, 2016 5:59:26 PM
	 */
	public static int getPercent() {
		return per;
	}

}
