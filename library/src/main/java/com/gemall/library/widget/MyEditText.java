package com.gemall.library.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

public class MyEditText extends android.support.v7.widget.AppCompatEditText {
    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }




    String lText = "";
    /*限制小数点位数*/
    public void setPayEditTextMode(final double moeny){
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                lText = s.toString();//旧数据
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



                String ss = s.toString();//新数据

                if(!TextUtils.isEmpty(s.toString())){

                    if(moeny <= 0){
                        setText("");
                        return;
                    }


                    if(ss.contains(".")){
                        String sss = ss.substring(ss.indexOf(".")+1,ss.length());
                        if(sss.length() > 2){
                            setText(lText);
                            setSelection(getText().toString().length());
                        }
                    }

                    if(Double.parseDouble(ss) > moeny){
                        setText(lText);
                        setSelection(getText().toString().length());
                    }

                }


            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }




}
