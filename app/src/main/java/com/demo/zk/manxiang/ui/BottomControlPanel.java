package com.demo.zk.manxiang.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.demo.zk.manxiang.R;


/**
 * Created by HG on 2015/10/8.
 */
//底部自定义布局
public class BottomControlPanel extends LinearLayout implements View.OnClickListener{

    private Context mContext;

    private CustomButton guangBtn;

    private CustomButton findBtn;

    private CustomButton mineBtn;

    private int mWidth;

    private BottomPanelCallback callback;

    public interface BottomPanelCallback{

       public void setPage(int page);
    }

    public BottomControlPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        guangBtn = (CustomButton)findViewById(R.id.guang);
        findBtn = (CustomButton)findViewById(R.id.find);
        mineBtn = (CustomButton)findViewById(R.id.mine);
        guangBtn.init(false, R.mipmap.browse, R.mipmap.browse_on, "逛逛");
        findBtn.init(false, R.mipmap.special, R.mipmap.special_on, "专题");
        mineBtn.init(false, R.mipmap.mine, R.mipmap.mine_on, "我的");
        guangBtn.setOnClickListener(this);
        findBtn.setOnClickListener(this);
        mineBtn.setOnClickListener(this);//user_checked_icon
    }

    @Override
    protected void onLayout(boolean changed,int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int mWidth = right-left;
        int bWidth = guangBtn.getWidth();
        int mPadding =(mWidth-3*bWidth)/4;
            LayoutParams params0 = (LayoutParams) guangBtn.getLayoutParams();
            params0.leftMargin = mPadding;
            guangBtn.setLayoutParams(params0);

            LayoutParams params1 = (LayoutParams) findBtn.getLayoutParams();
            params1.leftMargin = mPadding;
            findBtn.setLayoutParams(params1);

            LayoutParams params2 = (LayoutParams) mineBtn.getLayoutParams();
            params2.leftMargin = mPadding;
            mineBtn.setLayoutParams(params2);

    }

    //设置默认按钮（进入系统时默认显示“逛逛”按钮）
    public void defaultBtnChecked(){
        if(guangBtn.checked){
            return;
        }
        guangBtn.checked(true);
        findBtn.checked(false);
        mineBtn.checked(false);
    }

    //设置按钮（用户单击某个按钮时，将此按钮下标传过来）
    public void setBtnChecked(int index){
        if(index==0){
            if(guangBtn.checked){
                return;
            }
            guangBtn.checked(true);
            findBtn.checked(false);
            mineBtn.checked(false);
        }else if(index==1){
            if(findBtn.checked){
                return;
            }
            guangBtn.checked(false);
            findBtn.checked(true);
            mineBtn.checked(false);
        }else if(index==2){
            if(mineBtn.checked){
                return;
            }
            guangBtn.checked(false);
            findBtn.checked(false);
            mineBtn.checked(true);
        }

    }

    //该类实现了View.OnClickListener，重写点击事件的方法
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.guang){
           callback.setPage(0);
        }else if(v.getId()==R.id.find){
            callback.setPage(1);
        }else if(v.getId()==R.id.mine){
            callback.setPage(2);
        }

    }

    public void setCallback(BottomPanelCallback callback){
        this.callback = callback;
    }
}
