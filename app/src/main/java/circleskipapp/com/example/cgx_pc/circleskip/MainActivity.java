package circleskipapp.com.example.cgx_pc.circleskip;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import CustomView.CircleSkip;

public class MainActivity extends AppCompatActivity {

    private CircleSkip ck;
    private float x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ck = (CircleSkip) findViewById(R.id.ck);
        //this is a customview named circleSkip
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <=360 ; i++) {
                    x = i;
                    ck.post(new Runnable() {
                        @Override
                        public void run() {
                            ck.setX(x);
                        }
                    });
                    // 3000/360~=8.3333333……,so i obtain 8 as sleeptime;
                    SystemClock.sleep(8);
                }
            }
        }).start();

        //act if user click ck,excute startAcitvity
        ck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"startAcitivty",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
