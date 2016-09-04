package com.demo.zk.manxiang;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.ImageAddress;
import com.demo.zk.manxiang.domain.PlaceOrder;
import com.demo.zk.manxiang.domain.PreparePlaceOrder;
import com.demo.zk.manxiang.domain.UserAddress;
import com.demo.zk.manxiang.presenter.PreparePlaceOrderPresenter;
import com.demo.zk.manxiang.ui.CustomDialog;
import com.demo.zk.manxiang.ui.MXDialog;
import com.demo.zk.manxiang.utils.CacheUtils;
import com.demo.zk.manxiang.utils.ImageUtils;
import com.demo.zk.manxiang.utils.OSUtils;
import com.demo.zk.manxiang.utils.StringUtils;
import com.demo.zk.manxiang.utils.ThreadValues;
import com.demo.zk.manxiang.utils.UIUtils;
import com.demo.zk.manxiang.view.IPreparePlaceOrderView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;


/**
 * Created by WG on 2016/4/6.
 */
public class SpecialConfirmActivity extends BaseActivity implements View.OnClickListener, IPreparePlaceOrderView {

    private static final String CONFIRM_FORM = "确认订单";

    @ViewInject(R.id.wg_header_back)
    private ImageButton back;

    @ViewInject(R.id.wg_title_txt)
    private TextView title;

    @ViewInject(R.id.address_layout_add)
    private LinearLayout addressLayoutAdd;

    @ViewInject(R.id.add_address)
    private Button addAddress;

    @ViewInject(R.id.address_layout)
    private LinearLayout addressLayout;

    @ViewInject(R.id.address_name_no)
    private TextView userName;

    @ViewInject(R.id.address_phone_no)
    private TextView userPhone;

    @ViewInject(R.id.tv_user_address)
    private TextView userAddress;

    @ViewInject(R.id.iv_upload_image_1)
    private ImageView uploadImage1;

    @ViewInject(R.id.iv_upload_image_2)
    private ImageView uploadImage2;

    @ViewInject(R.id.iv_upload_image_3)
    private ImageView uploadImage3;

    @ViewInject(R.id.ib_add_image)
    private ImageButton addImage;

    @ViewInject(R.id.et_user_message)
    private EditText userMessage;

    @ViewInject(R.id.ll_seller_and_goods_info)
    private LinearLayout sellerAndGoodsInfo;

    @ViewInject(R.id.rl_painter)
    private RelativeLayout painterInfo;

    @ViewInject(R.id.painter_img)
    private RoundedImageView painterIcon;

    @ViewInject(R.id.painter_name)
    private TextView painterName;

    @ViewInject(R.id.service_img)
    private ImageView serviceImage;

    @ViewInject(R.id.service_img)
    private ImageView serviceIamge;

    @ViewInject(R.id.service_name)
    private TextView serviceContent;

    @ViewInject(R.id.service_params)
    private TextView serviceStyle;

    @ViewInject(R.id.service_time)
    private TextView serviceDeliveryTime;

    @ViewInject(R.id.tv_pay_price)
    private TextView servicePrice;

    @ViewInject(R.id.rl_delivery_layout)
    private RelativeLayout deliveryLayout;

    @ViewInject(R.id.service_postage_name)
    private TextView deliveryWay;

    @ViewInject(R.id.service_postage)
    private TextView deliveryCost;

    @ViewInject(R.id.coupon_liner)
    private ImageView liner;

    @ViewInject(R.id.rl_discount_layout)
    private RelativeLayout discountLayout;

    @ViewInject(R.id.coupon_name)
    private TextView discountWay;

    @ViewInject(R.id.coupon_price)
    private TextView discountCost;

    @ViewInject(R.id.tv_total_price)
    private TextView totalPrice;

    @ViewInject(R.id.bt_buy_now)
    private Button buy;


    private long service_id;
    private long param_id;
    private int paint_type;
    private long painter_id;
    private PreparePlaceOrderPresenter presenter;

    private Dialog dialog;
    private File tempFile;
    private String addressImage1;
    private String addressImage2;
    private String addressImage3;
    private static final int PICTURE_ONE = 1;
    private static final int PICTURE_TWO = 2;
    private static final int PICTURE_THREE = 3;
    private static final int REQUEST_ADDRESS_CODE = 4;
    private static final int PHOTO_REQUEST_CAMERA = 5;
    private static final int PHOTO_REQUEST_GALLERY = 6;

    private static final int REQUEST_NEW_ADDRESS_CODE = 8;
    private final String PHOTO_FILE_NAME = "mx1001.jpg";
    private Bitmap bitmap;
    private int currentUploadImageNumber;
    private int currentUploadImageIndex = PICTURE_ONE;
    private HashSet<Integer> imageIndex;
    private long addressId = -1;
    private boolean noAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initData();

        initEvent();
    }

    private void initView() {
        setContentView(R.layout.wg_activity_special_buy);
        ViewUtils.inject(this);
        title.setText(CONFIRM_FORM);
    }

    private void initData() {

        if (TextUtils.isEmpty(ThreadValues.getSid(getApplicationContext()))) {
            ThreadValues.getUser(this);
        }

        imageIndex = new HashSet<>();

        service_id = getIntent().getLongExtra("service_id", 0);
        param_id = getIntent().getLongExtra("param_id", 0);
        paint_type = getIntent().getIntExtra("paint_type", 0);
        presenter = new PreparePlaceOrderPresenter(this);

        //测试
        presenter.getPreparePlaceOrder(ThreadValues.getUserId(getApplicationContext()), ThreadValues.getSid(getApplicationContext()), service_id, param_id);
        presenter.getDefaultAddress(ThreadValues.getUserId(getApplicationContext()), ThreadValues.getSid(getApplicationContext()));

    }

    private void initEvent() {
        back.setOnClickListener(this);
        addAddress.setOnClickListener(this);
        addressLayout.setOnClickListener(this);
        addImage.setOnClickListener(this);
        painterInfo.setOnClickListener(this);
        serviceImage.setOnClickListener(this);
        buy.setOnClickListener(this);
        uploadImage1.setOnClickListener(this);
        uploadImage2.setOnClickListener(this);
        uploadImage3.setOnClickListener(this);
    }

    @Override
    public void onError(int code, String message){
        if(hud.isShowing()){
            hud.dismiss();
        }
        if(code== RespCode.IVALID_SESSION_CODE||code== RespCode.OVERDUE_SESSION_CODE||code== RespCode.NULL_SID_CODE){
            ThreadValues.clearSession(this);
            UIUtils.toast(this, "账号未登录");
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wg_header_back:
                finish();
                break;
            case R.id.add_address:
                //Intent newAddress = new Intent(SpecialConfirmActivity.this, MineRegionActivity.class);
                Intent newAddress = new Intent(SpecialConfirmActivity.this, LoginActivity.class);
                newAddress.putExtra("new_address", REQUEST_NEW_ADDRESS_CODE);
                startActivityForResult(newAddress, REQUEST_NEW_ADDRESS_CODE);
                break;
            case R.id.address_layout:
                //Intent addAddress = new Intent(SpecialConfirmActivity.this, PersonAddressActivity.class);
                Intent addAddress = new Intent(SpecialConfirmActivity.this, LoginActivity.class);
                addAddress.putExtra("get_address", REQUEST_ADDRESS_CODE);
                startActivityForResult(addAddress, REQUEST_ADDRESS_CODE);
                break;
            case R.id.ib_add_image:
                showChangeMineIcon(this, R.layout.wg_layout_change_icon_dialog);
                break;
            case R.id.iv_upload_image_1:
                showDeleteDialog(PICTURE_ONE);
                break;
            case R.id.iv_upload_image_2:
                showDeleteDialog(PICTURE_TWO);
                break;
            case R.id.iv_upload_image_3:
                showDeleteDialog(PICTURE_THREE);
                break;
            case R.id.rl_painter:
                Intent painter = new Intent(SpecialConfirmActivity.this, PainterActivity.class);
                painter.putExtra("painter_id", painter_id);
                startActivity(painter);
                break;
            case R.id.service_img:
                Intent service = new Intent(SpecialConfirmActivity.this, ServiceDetailsActivity.class);
                service.putExtra("service_id", service_id);
                startActivity(service);
                break;
            case R.id.bt_buy_now:

                //上传图片地址
                String imageSet = getUploadImageSet();
                if (TextUtils.isEmpty(imageSet)) {
                    Toast.makeText(SpecialConfirmActivity.this, "请上传1-3张图片！", Toast.LENGTH_SHORT).show();
                    break;
                }
                //用户留言
                String user_message = userMessage.getText().toString();
                //订单来源(1表示Android)
                int source = 1;
                //测试
                presenter.getPlaceOrder(ThreadValues.getUserId(getApplicationContext()), ThreadValues.getSid(getApplicationContext()),
                        service_id, param_id, imageSet, user_message, source, addressId, 0, null);
                hud.show();
                break;
            default:
                break;
        }
    }

    private String getUploadImageSet() {
        StringBuilder imageAddressSet = new StringBuilder();
        if (!TextUtils.isEmpty(addressImage1)) {

            imageAddressSet.append(addressImage1);

            if (!TextUtils.isEmpty(addressImage2)) {

                imageAddressSet.append("|");
                imageAddressSet.append(addressImage2);

                if (!TextUtils.isEmpty(addressImage3)) {

                    imageAddressSet.append("|");
                    imageAddressSet.append(addressImage3);
                }

            } else {

                if (!TextUtils.isEmpty(addressImage3)) {

                    imageAddressSet.append("|");
                    imageAddressSet.append(addressImage3);
                }
            }
        } else {

            if (!TextUtils.isEmpty(addressImage2)) {

                imageAddressSet.append(addressImage2);

                if (!TextUtils.isEmpty(addressImage3)) {
                    imageAddressSet.append(addressImage3);
                }

            } else {
                if (!TextUtils.isEmpty(addressImage3)) {
                    imageAddressSet.append("|");
                    imageAddressSet.append(addressImage3);
                }
            }
        }
        return imageAddressSet.toString();
    }

    //提示对话框
    private void showDeleteDialog(final int index) {
        MXDialog mxDialog = new  MXDialog.Builder(this).setMessage("确定移除该图片吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //业务逻辑待实现
                        switch (index) {
                            case PICTURE_ONE:
                                currentUploadImageIndex = PICTURE_ONE;
                                imageIndex.remove(currentUploadImageIndex);
                                uploadImage1.setVisibility(View.GONE);
                                addressImage1 = null;
                                break;
                            case PICTURE_TWO:
                                currentUploadImageIndex = PICTURE_TWO;
                                imageIndex.remove(currentUploadImageIndex);
                                uploadImage2.setVisibility(View.GONE);
                                addressImage2 = null;
                                break;
                            case PICTURE_THREE:
                                currentUploadImageIndex = PICTURE_THREE;
                                imageIndex.remove(currentUploadImageIndex);
                                uploadImage3.setVisibility(View.GONE);
                                addressImage3 = null;
                                break;
                            default:
                                break;
                        }
                        currentUploadImageNumber--;
                        addImage.setVisibility(View.VISIBLE);
                    }
                }).create();
        mxDialog.show();
    }

    //提示对话框
    private void setAddressDialog() {
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        dialog = builder.setMessage("还没有添加收货地址!")
                .setTitle("添加收货地址")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("添加", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //业务逻辑待实现
                        //Intent addAddress = new Intent(SpecialConfirmActivity.this, PersonAddressActivity.class);
                        Intent addAddress = new Intent(SpecialConfirmActivity.this, LoginActivity.class);
                        addAddress.putExtra("get_address", REQUEST_ADDRESS_CODE);
                        startActivityForResult(addAddress, REQUEST_ADDRESS_CODE);
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

    private void addNewAddress() {
        noAddress = true;
        addressLayoutAdd.setVisibility(View.VISIBLE);
        addressLayout.setVisibility(View.GONE);

    }

    @Override
    public void setPreparePlaceOrder(PreparePlaceOrder data) {

        painter_id = data.getPainter().getPainter_id();

        PreparePlaceOrder.Param param = data.getService_param();
        paint_type = param.getPaint_type();

        //不同点
        if (paint_type == 1) {
            //手工绘图
            float postage = param.getPostage();
            deliveryCost.setText(String.format("快递%s元", postage));
        } else {
            //电脑绘图
            liner.setVisibility(View.GONE);
            deliveryLayout.setVisibility(View.GONE);
        }

        //相同点
        String param_name = param.getParam_name();
        serviceStyle.setText(param_name);
        float showPrice = getShowPrice(param);
        servicePrice.setText(String.format("￥：%s", showPrice));

        //优惠
        PreparePlaceOrder.Coupon coupon = data.getCoupon();
        int is_coupon = coupon.getIs_coupon();
        if (is_coupon == 1) {
            //优惠
            String coupon_name = coupon.getCoupon_name();
            discountWay.setText(coupon_name);
            float reduce_money = coupon.getReduce_money();
            discountCost.setText(String.format("-%s元", reduce_money));
        } else {
            //不优惠
            liner.setVisibility(View.GONE);
            discountLayout.setVisibility(View.GONE);
        }

        //画家信息
        PreparePlaceOrder.Painter painter = data.getPainter();
        ImageUtils.loadImage(this, painter.getImg(), painterIcon);
        painterName.setText(painter.getNickname());

        //服务信息
        PreparePlaceOrder.Service service = data.getService();
        ImageUtils.loadImage(this, service.getImg(), serviceIamge);
        serviceContent.setText(service.getName());
        serviceDeliveryTime.setText(String.format("发货时间：创作%s天后发货", service.getPaint_time()));

        float total_money = data.getTotal_money();
        totalPrice.setText(String.format("￥%s", total_money));

        String img = CacheUtils.getString(this,"photo");
        if(StringUtils.isNotEmpty(img)){
            initImg(img);
        }
    }

    @Override
    public void setPlaceOrder(PlaceOrder data) {
        hud.dismiss();
        CacheUtils.clearString(this,"photo");
        //Intent payWay = new Intent(SpecialConfirmActivity.this, PayWayActivity.class);
        Intent payWay = new Intent(SpecialConfirmActivity.this, LoginActivity.class);
        payWay.putExtra("order", data);
        startActivity(payWay);
        finish();
    }

    @Override
    public void setUploadImage(ImageAddress data) {
        hud.dismiss();
        if(tempFile!=null&&tempFile.exists()){
            tempFile.delete();
        }
        File file = new File(outFilePath);
        if(file!=null&&file.exists()){
            file.delete();
        }
        initImg(data.getImg());
    }

    private void initImg(String img){
        currentUploadImageNumber++;
        switch (currentUploadImageIndex) {
            case PICTURE_ONE:
                addressImage1 = img;
                uploadImage1.setVisibility(View.VISIBLE);
                ImageUtils.loadImage(this, StringUtils.absoluteUrl(img), uploadImage1);
                break;
            case PICTURE_TWO:
                addressImage2 = img;
                uploadImage2.setVisibility(View.VISIBLE);
                ImageUtils.loadImage(this, StringUtils.absoluteUrl(img), uploadImage2);
                break;
            case PICTURE_THREE:
                addressImage3 = img;
                uploadImage3.setVisibility(View.VISIBLE);
                ImageUtils.loadImage(this, StringUtils.absoluteUrl(img), uploadImage3);
                break;
            default:
                break;
        }

        imageIndex.add(currentUploadImageIndex);
        while (true) {
            currentUploadImageIndex++;
            if (!imageIndex.contains(currentUploadImageIndex)) {
                break;
            }
        }

        if (currentUploadImageNumber == PICTURE_THREE) {
            addImage.setVisibility(View.GONE);
        }
    }

    @Override
    public void setDefaultAddress(List<UserAddress> data) {

        int size = data.size();
        if (size == 0) {
//            setAddressDialog();
            addNewAddress();
            return;
        }

        //获取默认地址
        for (int i = 0; i < size; i++) {
            if (data.get(i).getIs_default().equals("1")) {
                UserAddress address = data.get(i);
                setTextViewAddress(address);
            }
        }
        //没有默认地址获取第一个地址
        setTextViewAddress(data.get(0));

        if (addressId == -1) {
//            setAddressDialog();
            addNewAddress();
        }
    }


    @Override
    public void setAddress(UserAddress data) {
        if (noAddress) {
            noAddress = false;
            addressLayout.setVisibility(View.VISIBLE);
            addressLayoutAdd.setVisibility(View.GONE);
        }
        setTextViewAddress(data);
    }


    private void setTextViewAddress(UserAddress address) {

        userName.setText(String.format("收件人：%s", address.getConsignee()));
        userPhone.setText(address.getMobilephone());
        addressId = address.getAddress_id();

        String postcode = address.getPostcode();
        if (TextUtils.isEmpty(postcode)) {
            postcode = "000000";
        }

        if (paint_type == 2) {
            userAddress.setText("电脑绘图，无需物流。");
        } else {
            if (address.getCity().equals(address.getProvince())) {
                userAddress.setText(String.format("收货地址：%s市%s%s%s  邮编：%s",
                        address.getCity(), address.getCounty(), address.getStreet(),
                        address.getDetail(), postcode));
            } else {
                if (address.getCity().equals("false")) {
                    userAddress.setText(String.format("收货地址:%s市%s%s%s  邮编：%s",
                            address.getProvince(), address.getCounty(),
                            address.getStreet(), address.getDetail(), postcode));
                } else {
                    userAddress.setText(String.format("收货地址：%s省%s市%s%s%s  邮编：%s",
                            address.getProvince(), address.getCity(), address.getCounty(),
                            address.getStreet(), address.getDetail(), postcode));
                }
            }
        }
    }



    private String outFilePath;

    private  String mPicturePath = null;

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PHOTO_REQUEST_GALLERY && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                mPicturePath = getPicturePath(uri);
                String folderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
                outFilePath = folderPath + System.currentTimeMillis() + ".jpg";
                PGEditSDK.instance().startEdit(this, PGEditActivity.class,mPicturePath, outFilePath);
            }
        } else if (requestCode == PHOTO_REQUEST_CAMERA && resultCode == Activity.RESULT_OK) {
            tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME);
            String folderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
            outFilePath = folderPath + System.currentTimeMillis() + ".jpg";
            mPicturePath = tempFile.getAbsolutePath();
            PGEditSDK.instance().startEdit(this, PGEditActivity.class,mPicturePath  , outFilePath);
        } else if (requestCode == PGEditSDK.PG_EDIT_SDK_REQUEST_CODE
                && resultCode == Activity.RESULT_OK) {
            PGEditResult editResult = PGEditSDK.instance().handleEditResult(data);
            String resultPhotoPath = editResult.getReturnPhotoPath();
            presenter.getUploadImage(new File(resultPhotoPath));
            hud.show();
        } else if (requestCode == PGEditSDK.PG_EDIT_SDK_REQUEST_CODE
                && resultCode == PGEditSDK.PG_EDIT_SDK_RESULT_CODE_CANCEL) {
           //用户取消编辑
        }else if (requestCode == PGEditSDK.PG_EDIT_SDK_REQUEST_CODE
                && resultCode == PGEditSDK.PG_EDIT_SDK_RESULT_CODE_NOT_CHANGED) {
           // 照片没有修改
            if(StringUtils.isNotEmpty(mPicturePath )) {
                presenter.getUploadImage(new File(mPicturePath ));
                hud.show();
            }
        } else if (requestCode == REQUEST_ADDRESS_CODE && resultCode == REQUEST_ADDRESS_CODE) {
            if (data.hasExtra("address_id")) {
                long address_id = data.getLongExtra("address_id", -1);
                if (address_id != -1) {
                    //测试
                    addressId = address_id;
                    presenter.getAddress(ThreadValues.getUserId(getApplicationContext()), ThreadValues.getSid(getApplicationContext()), address_id);
                }
            }
        } else if (requestCode == REQUEST_NEW_ADDRESS_CODE && resultCode == REQUEST_NEW_ADDRESS_CODE) {
            if (data.hasExtra("address_id")) {
                long address_id = data.getLongExtra("address_id", -1);
                if (address_id != -1) {
                    //测试
                    addressId = address_id;
                    presenter.getAddress(ThreadValues.getUserId(getApplicationContext()), ThreadValues.getSid(getApplicationContext()), address_id);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/

    private String getPicturePath(Uri uri) {
        String mPicturePath = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = this.managedQuery(uri, proj, null, null, null);
        if(cursor==null){
            mPicturePath = uri.getPath();
        }else {
            int actual_image_column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            mPicturePath = cursor.getString(actual_image_column_index);
        }
        return mPicturePath;
    }



    private float getShowPrice(PreparePlaceOrder.Param param) {
        float price = param.getPrice();
        if (param.getIs_seckill() == 1) {
            price = param.getSeckill_price();
        }

        if (param.getIs_discount() == 1) {
            price = param.getDiscount_price();
        }
        return price;
    }

    public void showChangeMineIcon(Context context, int layoutId) {

        View view = LayoutInflater.from(context).inflate(layoutId, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText("上传图片");
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
        intent.setType("image/*");
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


}
