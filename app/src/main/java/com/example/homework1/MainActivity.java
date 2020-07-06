package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private EditText userPassworld;
    private EditText userPassworldAgain;
    private RadioButton userNan;
    private RadioButton userNv;
    private RadioButton userZhong;
    private TextView userLocate;
    private ArrayAdapter<String> adapterShen;
    private Spinner userSheng;
    private Button userSubmit;
    private List<String> list_sheng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化
        userName = (EditText) findViewById(R.id.user_name);
        userPassworld = (EditText) findViewById(R.id.user_password);
        userPassworldAgain = (EditText) findViewById(R.id.user_passwordagain);
        userNan = (RadioButton) findViewById(R.id.nan);
        userNv = (RadioButton) findViewById(R.id.nv);
        userZhong = (RadioButton) findViewById(R.id.zhong);
        userSheng = (Spinner) findViewById(R.id.user_sheng);
        userSubmit = (Button) findViewById(R.id.user_submmit);
        userLocate = (TextView) findViewById(R.id.userlocate);

        //设置数据源
        list_sheng = new ArrayList<String>();
        list_sheng.add("");
        list_sheng.add("浙江");list_sheng.add("上海");list_sheng.add("北京");
        list_sheng.add("苏州");list_sheng.add("福建");

        adapterShen=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list_sheng);
        adapterShen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSheng.setAdapter(adapterShen);
        userSheng.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cityName=adapterShen.getItem(position);
                userLocate.setText(cityName);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //点击按钮
        userSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempName = userName.getText().toString().trim();
                String tempPassworld = userPassworld.getText().toString().trim();
                String tempPassworldAgain = userPassworldAgain.getText().toString().trim();
                String tempCity = userLocate.getText().toString().trim();
                if (tempName.isEmpty()){
                    Toast toast = Toast.makeText(MainActivity.this, "请输入用户名", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Log.w("用户名","用户名输入为空");
                    return;
                }
                else if(tempPassworld.isEmpty()){
                    Toast toast = Toast.makeText(MainActivity.this,"请输入密码", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Log.w("密码","密码输入为空");
                    return;
                }
                else if(!tempPassworld.equals(tempPassworldAgain)){
                    Toast toast = Toast.makeText(MainActivity.this,"密码输入不一致", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Log.w("密码","密码输入不一致");
                    return;
                }
                else if(!(userNan.isChecked() || userNv.isChecked() || userZhong.isChecked())){
                    Toast toast = Toast.makeText(MainActivity.this,"请选择性别", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Log.w("性别","未输入性别");
                    return;
                }
                else if(tempCity.equals("")){
                    Toast toast = Toast.makeText(MainActivity.this, "请选择所在的省份",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Log.w("省份","未选择所在省份");
                    return;
                }
                //信息验证成功
                Toast toast = Toast.makeText(MainActivity.this, "恭喜，注册成功~", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Log.i("finish","注册成功");
            }
        });


    }
}
