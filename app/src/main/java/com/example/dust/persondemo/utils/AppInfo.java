package com.example.dust.persondemo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

public class AppInfo {

	public static final String TAG = "AppInfo";

	/**
	 * 获取应用程序版本号
	 * 
	 * @param context
	 * @return
	 */
	public static String getAppVersionName(Context context, String aPackName) {
		String versionName = "1.0";
		try {
			PackageManager pm = context.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(aPackName, 0);
			versionName = pi.versionName;
			if (versionName == null || versionName.length() <= 0) {
				return "1.0";
			}
		} catch (Exception e) {
			Log.e("VersionInfo", "Exception", e);
		}
		return versionName;
	}

	public static String getScreen(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		dm = context.getResources().getDisplayMetrics();
		String mScreen = dm.widthPixels + "x" + dm.heightPixels;
		return mScreen;
	}

	public static int getScreenHeight(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		dm = context.getResources().getDisplayMetrics();
		return dm.heightPixels;
	}

	public static int getScreenWidth(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		dm = context.getResources().getDisplayMetrics();
		return dm.widthPixels;
	}

	public static String getDeviceID(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String strID = tm.getDeviceId();
		if (strID == null || strID.length() == 0) {
			strID = tm.getSubscriberId();
			if (strID == null || strID.length() == 0) {
				strID = android.os.Build.DEVICE + android.os.Build.ID;
				strID = "" + strID.hashCode();
			}
		}
		// return "ZF-A-" + strID;
		return "" + strID;
	}

	public static boolean checkInternet(Context context) {
		String MSG = "checkInternet()";
		if(context != null){


			ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo info = cm.getActiveNetworkInfo();
			if (info != null && info.isConnected()) {
				return true;
			}
			return false;
		}
		else {

			Log.e(TAG, MSG + "context == null");

			return false;
		}
	}

	public static String getOperator(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getSimOperator();
	}

	public static String getSystemVersion() {
		return android.os.Build.VERSION.RELEASE;
	}

	@SuppressLint("DefaultLocale")
	public static String getPhoneBrand() {
		return android.os.Build.BRAND.toUpperCase();
	}

	public static String getPhoneModel() {
		return android.os.Build.MODEL;
	}

	public static int getNetworkType(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni == null) {
			return 0;
		}
		if (ni.getType() == ConnectivityManager.TYPE_WIFI || "WIFI".equals(ni.getTypeName()) || "wifi".equals(ni.getTypeName())) {
			return 1;
		}
		switch (ni.getSubtype()) {
		case TelephonyManager.NETWORK_TYPE_UNKNOWN:
			return 0;
		case TelephonyManager.NETWORK_TYPE_1xRTT:
		case TelephonyManager.NETWORK_TYPE_CDMA:
		case TelephonyManager.NETWORK_TYPE_EDGE:
		case TelephonyManager.NETWORK_TYPE_GPRS:
			return 2;
		case TelephonyManager.NETWORK_TYPE_HSDPA:
		case TelephonyManager.NETWORK_TYPE_HSPA:
		case TelephonyManager.NETWORK_TYPE_EVDO_0:
		case TelephonyManager.NETWORK_TYPE_EVDO_A:
		case TelephonyManager.NETWORK_TYPE_HSUPA:
		case TelephonyManager.NETWORK_TYPE_UMTS:
		case 15:// TelephonyManager.NETWORK_TYPE_EHRPD
			return 3;
		case 13:// TelephonyManager.NETWORK_TYPE_LTE:
		case 14:// TelephonyManager.NETWORK_TYPE_HSPAP
			return 4;
		}
		return 0;
	}

	/**
	 * 获取终端IP地址
	 * 
	 * @param context
	 * @return
	 */
	public static String getNetworkIP(Context context) {
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);// 获取wifi服务
		if (wifiManager.isWifiEnabled()) {// WiFi环境下获取IP地址
			WifiInfo wifiInfo = wifiManager.getConnectionInfo();
			int ipAddress = wifiInfo.getIpAddress();
			return (ipAddress & 0xFF) + "." + ((ipAddress >> 8) & 0xFF) + "." + ((ipAddress >> 16) & 0xFF) + "." + (ipAddress >> 24 & 0xFF);
		}
		if (!wifiManager.isWifiEnabled() && checkInternet(context)) {// 非WiFi环境下获取IP地址
			try {
				for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
					NetworkInterface intf = en.nextElement();
					for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
						InetAddress inetAddress = enumIpAddr.nextElement();
						if (!inetAddress.isLoopbackAddress()) {
							return inetAddress.getHostAddress().toString();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 检查手机上是否安装了指定的软件
	 * 
	 * @param context
	 * @param packageName
	 *            ：应用包名
	 * @return
	 */
	public static boolean isAvilible(Context context, String packageName) {
		// 获取packagemanager
		final PackageManager packageManager = context.getPackageManager();
		// 获取所有已安装程序的包信息
		List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
		// 用于存储所有已安装程序的包名
		List<String> packageNames = new ArrayList<String>();
		// 从pinfo中将包名字逐一取出，压入pName list中
		if (packageInfos != null) {
			for (int i = 0; i < packageInfos.size(); i++) {
				String packName = packageInfos.get(i).packageName;
				packageNames.add(packName);
			}
		}
		// 判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
		return packageNames.contains(packageName);
	}

	/**
	 * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
	 * 
	 * @return 返回状态栏高度的像素值。
	 */
	public static int getStatusBarHeight(Context context) {
		int result = 0;
		int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = context.getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}

	/** 获取手机外部可用空间大小，单位为byte */
	@SuppressWarnings("deprecation")
	public static long getExternalTotalSpace() {
		long totalSpace = -1L;
		if (isExternalStorageAvailable()) {
			try {
				String path = Environment.getExternalStorageDirectory().getPath();// 获取外部存储目录即
																					// SDCard
				StatFs stat = new StatFs(path);
				long blockSize = stat.getBlockSize();
				long totalBlocks = stat.getBlockCount();
				totalSpace = totalBlocks * blockSize;
			} catch (Exception e) {
			}
		}
		return totalSpace;
	}

	/** 获取外部存储可用空间，单位为byte */
	@SuppressWarnings("deprecation")
	public static long getExternalSpace() {
		long availableSpace = -1L;
		if (isExternalStorageAvailable()) {
			try {
				String path = Environment.getExternalStorageDirectory().getPath();
				StatFs stat = new StatFs(path);
				availableSpace = stat.getAvailableBlocks() * (long) stat.getBlockSize();
			} catch (Exception e) {


			}
		}
		return availableSpace;
	}

	/**
	 * 检测外部存储是否可用
	 * 
	 * @return
	 */
	public static boolean isExternalStorageAvailable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			// We can read and write the media
			return true;
		} else {
			// Something else is wrong. It may be one of many other states, but
			// all we need
			// to know is we can neither read nor write
			return false;
		}
	}

	/** 获取手机内部空间大小，单位为byte */
	@SuppressWarnings("deprecation")
	public static long getTotalInternalSpace() {
		long totalSpace = -1L;
		try {
			String path = Environment.getDataDirectory().getPath();
			StatFs stat = new StatFs(path);
			long blockSize = stat.getBlockSize();
			long totalBlocks = stat.getBlockCount();// 获取该区域可用的文件系统数
			totalSpace = totalBlocks * blockSize;
		} catch (Exception e) {


		}
		return totalSpace;
	}

	/** 获取手机内部可用空间大小，单位为byte */
	@SuppressWarnings("deprecation")
	public static long getAvailableInternalMemorySize() {
		long availableSpace = -1l;
		try {
			String path = Environment.getDataDirectory().getPath();// 获取 Android
																	// 数据目录
			StatFs stat = new StatFs(path);// 一个模拟linux的df命令的一个类,获得SD卡和手机内存的使用情况
			long blockSize = stat.getBlockSize();// 返回 Int ，大小，以字节为单位，一个文件系统
			long availableBlocks = stat.getAvailableBlocks();// 返回 Int
																// ，获取当前可用的存储空间
			availableSpace = availableBlocks * blockSize;
		} catch (Exception e) {


		}
		return availableSpace;
	}

	/**
	 * 判断wifi 是否可用
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public static boolean isWifiDataEnable(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (connectivityManager == null) {
			return false;
		}

		boolean isWifiDataEnable = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
		return isWifiDataEnable;
	}

	/**
	 * 根据手机的分辨率dp 转成px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
}
