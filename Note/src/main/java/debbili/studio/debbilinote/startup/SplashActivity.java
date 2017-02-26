package debbili.studio.debbilinote.startup;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import debbili.studio.debbilinote.MainActivity;
import debbili.studio.debbilinote.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        LinearLayout ll_splash = (LinearLayout) findViewById(R.id.ll_splash);
        ll_splash.setBackground(getDrawable(R.drawable.splash_img));
        mHandler.sendEmptyMessageDelayed(0, 3000);
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
