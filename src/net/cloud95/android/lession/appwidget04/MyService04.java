package net.cloud95.android.lession.appwidget04;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

//繼承自Service的服務元件
public class MyService04 extends Service {

    private MyTimeTick04 myTimeTick;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    
        // 建立廣播接收元件物件
        if(myTimeTick == null){
        	myTimeTick = new MyTimeTick04();
        }
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 準備註冊廣播接收元件的IntentFilter物件
        // Action名稱指定為系統每一分鐘發送的廣播事件
    	IntentFilter intentFilter = new IntentFilter(Intent.ACTION_TIME_TICK);
        // 註冊廣播接收元件
    	registerReceiver(myTimeTick, intentFilter);
        return START_STICKY;
    }
    
    @Override
    public void onDestroy() {
        // 移除廣播接收元件
    	unregisterReceiver(myTimeTick);
        super.onDestroy();
    }

}
