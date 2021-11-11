package liejun.jinfan.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int fps_rate = 60;
    private String fps_rate_key = "user_refresh_rate";
    private int power_sounds_enabled = 1;
    private String power_sounds_enabled_key = "power_sounds_enabled";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver cr = getContentResolver();
        try {
            fps_rate = Settings.System.getInt(cr, fps_rate_key, 60);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            power_sounds_enabled = Settings.Global.getInt(cr, power_sounds_enabled_key, 1);
            Switch power_on_sounds_switch = (Switch) findViewById(R.id.power_on_sounds_switch);
//            power_on_sounds_switch;
        }catch (Exception e){
            e.printStackTrace();
        }

        try {

        }catch (Exception e){
            e.printStackTrace();
        }

        try {

        }catch (Exception e){
            e.printStackTrace();
        }

        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        log("fps_rate:"+fps_rate + ";power_sounds_enabled="+power_sounds_enabled);

    }
    public  static void log(String str){
        Log.e("Liejun", str);
    }
    private void show_success(String msg){
        Toast.makeText(getApplicationContext(), "设置成功\n"+msg, Toast.LENGTH_SHORT).show();
    }
    private void show_false(String msg){
        Toast.makeText(getApplicationContext(), "设置失败\n"+msg, Toast.LENGTH_SHORT).show();
    }
    private void show_error(String msg){
        Toast.makeText(getApplicationContext(), "小伙子你的想法有点淦凡！\n"+msg, Toast.LENGTH_SHORT).show();
    }

    public void clicked(View v){
        try {
            ContentResolver cr = getContentResolver();

            switch (v.getId()){
                case R.id.fpsBtn:
                    EditText fps_edit = (EditText) findViewById(R.id.fpsExitText);
                    fps_rate = Integer.parseInt( fps_edit.getText().toString() );
                    if (fps_rate > 0 && fps_rate < 200){
                        if(Settings.System.putInt(cr, fps_rate_key, fps_rate)){
                            show_success("");
                        }else{
                            show_false("更改失败");
                        }
                    }else{
                        show_error("0 < fps < 200");
                    }
                    break;
                case R.id.power_on_sounds_switch:
                    Switch sw = (Switch) v;
                    int state = 0;
                    if( "on" == sw.getText() ){
                        state = 1;
                        log("state is on");
                    }else{
                        log("state is off");
                    }
                    if(Settings.Global.putInt(cr, power_sounds_enabled_key, state)){
                        show_success("");
                    }else{
                        show_false("更改失败");
                    }
                    break;

            }
        }catch (Exception e){
            show_false("更改失败");
            e.printStackTrace();
        }

    }
}