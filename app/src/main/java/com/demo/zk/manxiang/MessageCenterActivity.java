package com.demo.zk.manxiang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.zk.manxiang.ui.PopupMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by Administrator on 2016/4/14.
 */
public class MessageCenterActivity extends BaseActivity{

    private static final String MESSAGE_CENTER = "消息中心";
    @ViewInject(R.id.wg_header_back)
    private ImageButton back;

    @ViewInject(R.id.wg_title_txt)
    private TextView title;

    @ViewInject(R.id.wg_right_btn)
    private ImageButton more;

    @ViewInject(R.id.activity)
    private LinearLayout activity;

    @ViewInject(R.id.activity_icon)
    private ImageView activityIcon;

    @ViewInject(R.id.activity_content)
    private TextView activityContent;

    @ViewInject(R.id.activity_time)
    private TextView activityTime;

    @ViewInject(R.id.helper)
    private LinearLayout helper;

    @ViewInject(R.id.helper_icon)
    private ImageView helperIcon;

    @ViewInject(R.id.helper_content)
    private TextView helperContent;

    @ViewInject(R.id.helper_time)
    private TextView helperTime;

    @ViewInject(R.id.warm)
    private LinearLayout warm;

    @ViewInject(R.id.warm_icon)
    private ImageView warmIcon;

    @ViewInject(R.id.warm_content)
    private TextView warmContent;

    @ViewInject(R.id.warm_time)
    private TextView warmTime;

    @ViewInject(R.id.call)
    private LinearLayout call;

    @ViewInject(R.id.call_icon)
    private ImageView callIcon;

    @ViewInject(R.id.call_content)
    private TextView callContent;

    @ViewInject(R.id.call_time)
    private TextView callTime;

    @ViewInject(R.id.header_layout)
    private View headerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initData();

        initEvent();
    }

    private void initView() {
        setContentView(R.layout.wg_activity_message_center);
        ViewUtils.inject(this);
        title.setText(MESSAGE_CENTER);
    }

    private void initData() {

    }

    private void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getThis(), false,true);
                popupMenu.showPopupWindow(headerLayout);
            }
        });

        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(MessageCenterActivity.this, MessageWarmActivity.class);
                startActivity(activity);
            }
        });
        helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(MessageCenterActivity.this, MessageWarmActivity.class);
                startActivity(activity);
            }
        });
/*        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(MessageCenterActivity.this, MessageActivityActivity.class);
                startActivity(activity);
            }
        });

        helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helper = new Intent(MessageCenterActivity.this, MessageActivityActivity.class);
                startActivity(helper);
            }
        });*/

        warm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent warm = new Intent(MessageCenterActivity.this, MessageWarmActivity.class);
                startActivity(warm);
            }
        });

/*        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(MessageCenterActivity.this, MessageActivityActivity.class);
                startActivity(call);
            }
        });*/
                call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(MessageCenterActivity.this, MessageWarmActivity.class);
                startActivity(call);
            }
        });
    }
}
