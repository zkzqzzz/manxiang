package com.demo.zk.manxiang.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.zk.manxiang.R;
import com.lidroid.xutils.ViewUtils;

/**
 * Created by HG on 2015/10/9.
 */
public class MineFragment extends BaseFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_layout,
                container, false);

        ViewUtils.inject(this, view);
        TextView mytext = (TextView) view.findViewById(R.id.my_test);
        mytext.setText("MineFragment");
        return view;
    }
}
/*

public class MineFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener, IUserInfoView, IOrderStatusView {


    private static final String TAG = "MineFragment";
    private static final String MINE_CENTER = "个人中心";
    private static final int ALL = 0;
    private static final int PAY = 1;
    private static final int CREATE = 2;
    private static final int RECEIVE = 3;
    private static final int EVALUATE = 4;

    private static final int PHOTO_REQUEST_CAMERA = 5;

    private static final int PHOTO_REQUEST_GALLERY = 6;

    private static final int PHOTO_REQUEST_CUT = 7;

    private File tempFile = null;

    private Dialog dialog = null;

    private final String PHOTO_FILE_NAME = "TEMP101.jpg";

    private Context context;
    private MineFragmentAdapter adapter;

    @ViewInject(R.id.wg_header_back)
    private ImageButton back;

    @ViewInject(R.id.tv_nick_name)
    private TextView nick_name;

    @ViewInject(R.id.wg_title_txt)
    private TextView title;

    @ViewInject(R.id.wg_right_btn)
    private ImageButton more;

    @ViewInject(R.id.ib_personal_header_icon)
    private RoundedImageView artistHeader;

    @ViewInject(R.id.ib_personal_setting)
    private ImageButton setting;

    @ViewInject(R.id.look_all)
    private TextView lookAll;

    @ViewInject(R.id.ll_pay)
    private RelativeLayout pay;

    @ViewInject(R.id.tv_pay_count)
    private TextView payCount;

    @ViewInject(R.id.ll_create)
    private RelativeLayout create;

    @ViewInject(R.id.tv_create_count)
    private TextView createCount;

    @ViewInject(R.id.ll_receive)
    private RelativeLayout receive;

    @ViewInject(R.id.tv_receive_count)
    private TextView receiveCount;

    @ViewInject(R.id.ll_evaluate)
    private RelativeLayout evaluate;

    @ViewInject(R.id.tv_evaluate_count)
    private TextView evaluateCount;

    @ViewInject(R.id.ll_refund_aftermarket)
    private RelativeLayout refund_aftermarket;

    @ViewInject(R.id.personal_GV)
    private GridView personal_GV;

    private UserInfoPresenter presenter;
    private OrderStatusPresenter statusPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ViewUtils.inject(this, view);
        view.findViewById(R.id.wg_header_back).setVisibility(View.INVISIBLE);
        initData();
        setListener();
        return view;
    }

    private void initData() {

        title.setText(MINE_CENTER);
        context = this.getContext();

        statusPresenter = new OrderStatusPresenter(this);
        statusPresenter.getOrderStatusCount(ThreadValues.getUserId(getContext()), ThreadValues.getSid(getContext()));

        presenter = new UserInfoPresenter(this);
        more.setImageResource(R.mipmap.wg_more_message_no);

        adapter = new MineFragmentAdapter(context);
        personal_GV.setAdapter(adapter);

    }

    private void setListener() {
        back.setOnClickListener(this);
        more.setOnClickListener(this);
        artistHeader.setOnClickListener(this);
        setting.setOnClickListener(this);
        lookAll.setOnClickListener(this);
        pay.setOnClickListener(this);
        create.setOnClickListener(this);
        receive.setOnClickListener(this);
        evaluate.setOnClickListener(this);
        refund_aftermarket.setOnClickListener(this);
        personal_GV.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wg_header_back:
                break;
            case R.id.wg_title_txt:
                break;
            case R.id.wg_right_btn:
                Intent message = new Intent(getContext(), MessageCenterActivity.class);
                startActivity(message);
                break;
            case R.id.ib_personal_header_icon:
                showChangeMineIcon(getContext(), R.layout.wg_layout_change_icon_dialog);
                //showDialog();
                break;
            case R.id.ib_personal_setting:
//                Intent setting = new Intent(context, LoginActivity.class);
//                startActivity(setting);
                Intent intent = new Intent(context, SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.look_all:
                Intent all = new Intent(context, ComActivity.class);
                all.putExtra("flag", ALL);
                startActivity(all);
                break;
            case R.id.ll_pay:
                Log.i(TAG, "待付款");
                Intent pay = new Intent(context, ComActivity.class);
                pay.putExtra("flag", PAY);
                startActivity(pay);
                break;
            case R.id.ll_create:
                Log.i(TAG, "待创作");
                Intent create = new Intent(context, ComActivity.class);
                create.putExtra("flag", CREATE);
                startActivity(create);
                break;
            case R.id.ll_receive:
                Log.i(TAG, "待收画");
                Intent receive = new Intent(context, ComActivity.class);
                receive.putExtra("flag", RECEIVE);
                startActivity(receive);
                break;
            case R.id.ll_evaluate:
                Log.i(TAG, "待评价");
                Intent evaluate = new Intent(context, ComActivity.class);
                evaluate.putExtra("flag", EVALUATE);
                startActivity(evaluate);
                break;
            case R.id.ll_refund_aftermarket:
                Log.i(TAG, "退款/售后");
                Intent refund = new Intent(context, RefundActivity.class);
                startActivity(refund);
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, "position:" + position);
        switch (position) {
            case MineFragmentAdapter.MINE_COLLECT:
                Log.i(TAG, "我的收藏");
                Intent collect = new Intent(getContext(), CollectionActivity.class);
                startActivity(collect);
//                Intent collect = new Intent(context, CollectActivity.class);
//                startActivity(collect);
                break;
            case MineFragmentAdapter.MINE_EXCHANGE:
                Log.i(TAG, "兑换中心");
                Intent exchange = new Intent(context, ExchangeActivity.class);
                startActivity(exchange);
                break;
            case MineFragmentAdapter.MINE_EVALUATE:
                Log.i(TAG, "我的评价");
                Intent evaluate = new Intent(context, EvaluateActivity.class);
                startActivity(evaluate);
                break;
            case MineFragmentAdapter.MINE_FEEDBACK:
                Log.i(TAG, "帮助和反馈");
                Intent feedback = new Intent(context, FeedbackActivity.class);
                startActivity(feedback);
                break;
            case MineFragmentAdapter.MINE_ARTIST:
                Log.i(TAG, "成为画家");
                Intent artist = new Intent(context, ArtistActivity.class);
                startActivity(artist);
                break;
            default:
                break;
        }
    }

    public void showChangeMineIcon(final Context context, int layoutId) {

        View view = LayoutInflater.from(context).inflate(layoutId, null);
        LinearLayout camera = (LinearLayout) view.findViewById(R.id.camera);
        LinearLayout picture = (LinearLayout) view.findViewById(R.id.picture);
        final CustomDialog dialog = new CustomDialog.Builder(context).create();
        dialog.setContentView(view);
        dialog.show();
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                camera(v);

            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                gallery(v);
            }
        });
    }

    private void gallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image*/
/*");
        startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
    }

    private void camera(View view) {
        if (OSUtils.hasSdcard()) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME)));
            startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
        }
    }

    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image*/
/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        intent.putExtra("circleCrop", true);
        // 图片格式
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);// true:不返回uri，false：返回uri
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST_GALLERY && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                crop(uri);
            }
        } else if (requestCode == PHOTO_REQUEST_CAMERA && resultCode == Activity.RESULT_OK) {
            tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME);
            crop(Uri.fromFile(tempFile));

        } else if (requestCode == PHOTO_REQUEST_CUT && resultCode == Activity.RESULT_OK) {
            handleCrop(data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void handleCrop(Intent result) {
        Bitmap bitmap = result.getParcelableExtra("data");
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
        tempFile = saveBitmap(bitmap);
//        loadingDialog.setMessage("头像上传中...");
//        loadingDialog.show();
        presenter.uploadHeader(tempFile);
    }

    File saveBitmap(Bitmap bitmap) {
        File file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
        FileOutputStream fot = null;

        try {
            fot = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fot);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != fot) {
                try {
                    fot.flush();
                    fot.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    @Override
    public void setUser(User user) {
        if (user == null)
            return;
        if (StringUtils.isNotEmpty(user.getNickname())) {
            nick_name.setText(user.getNickname());
        } else {
            nick_name.setText("匿名");
        }
        if (StringUtils.isNotEmpty(user.getImg())) {
            ImageUtils.loadImage(getContext(), StringUtils.absoluteUrl(user.getImg()), artistHeader, R.mipmap.def_header);
        }
    }

    @Override
    public void onSuccess(Object... arg) {
        if (arg == null) {
            return;
        }
        if (arg[0] instanceof Integer) {
            toast("退出成功");
            ThreadValues.clearSession(getContext());
            ApplicationManager.home(0);
            return;
        }
        if (arg[0] instanceof String) {
            if (loadingDialog.isShowing())
                loadingDialog.dismiss();
            User user = ThreadValues.getUser(getActivity());
            user.setImg((String) arg[0]);
            user.setSid(ThreadValues.getSid(getActivity()));
            presenter.updateInfo(user);
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }
    }

    @Override
    public void startTimer() {

    }

    @Override
    public void onResume() {
        super.onResume();
        setUser(ThreadValues.getUser(getContext()));
        statusPresenter.getOrderStatusCount(ThreadValues.getUserId(getContext()), ThreadValues.getSid(getContext()));

    }

    @Override
    public void setOrderStatusCount(List<OrderStatusCount> data) {
        //status:状态(10未付款 11已付款待发货(待作画) 21待下载(待收画) 31待评论 41已完成  51已取消)
        for (int i = 0; i < data.size(); i++) {
            OrderStatusCount orderStatusCount = data.get(i);
            int count = orderStatusCount.getCount();
            switch (orderStatusCount.getStatus()) {
                case OrderList.CODE_PAY:
                    if (count > 0) {
                        payCount.setVisibility(View.VISIBLE);
                        payCount.setText(String.format("%d", count));
                    } else {
                        payCount.setVisibility(View.GONE);
                    }
                    break;
                case OrderList.CODE_PIC:
                    if (count > 0) {
                        createCount.setVisibility(View.VISIBLE);
                        createCount.setText(String.format("%d", count));
                    } else {
                        createCount.setVisibility(View.GONE);
                    }
                    break;
                case OrderList.CODE_REC:
                    if (count > 0) {
                        receiveCount.setVisibility(View.VISIBLE);
                        receiveCount.setText(String.format("%d", count));
                    } else {
                        receiveCount.setVisibility(View.GONE);
                    }
                    break;
                case OrderList.CODE_EVA:
                    if (count > 0) {
                        evaluateCount.setVisibility(View.VISIBLE);
                        evaluateCount.setText(String.format("%d", count));
                    } else {
                        evaluateCount.setVisibility(View.GONE);
                    }
                    break;
                default:
                    break;
            }
        }
    }

}*/