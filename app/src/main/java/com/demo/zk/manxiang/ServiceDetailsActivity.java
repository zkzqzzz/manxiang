package com.demo.zk.manxiang;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.demo.zk.manxiang.adapter.ServiceDetailsViewPagerAdapter;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.ServiceDetail;
import com.demo.zk.manxiang.domain.Status;
import com.demo.zk.manxiang.presenter.ServiceDetailPresenter;
import com.demo.zk.manxiang.presenter.SharePresenter;
import com.demo.zk.manxiang.ui.BannerSlideShowView;
import com.demo.zk.manxiang.ui.CategoryCheckBoxGroupParams;
import com.demo.zk.manxiang.ui.CategoryCheckBoxGroupService;
import com.demo.zk.manxiang.ui.CustomDialog;
import com.demo.zk.manxiang.ui.CustomViewPager;
import com.demo.zk.manxiang.ui.McoyProductContentPage;
import com.demo.zk.manxiang.ui.McoyProductDetailInfoPage;
import com.demo.zk.manxiang.ui.McoySnapPageLayout;
import com.demo.zk.manxiang.ui.PopupMenu;
import com.demo.zk.manxiang.ui.ServiceParamRadioGroup;
import com.demo.zk.manxiang.ui.ServiceRadioGroup;
import com.demo.zk.manxiang.utils.ImageUtils;
import com.demo.zk.manxiang.utils.MeasureViewUtil;
import com.demo.zk.manxiang.utils.OSUtils;
import com.demo.zk.manxiang.utils.StringUtils;
import com.demo.zk.manxiang.utils.ThreadValues;
import com.demo.zk.manxiang.view.IServiceDetailView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by houg on 2016/5/14.
 */
@ContentView(R.layout.activity_service_details)
public class ServiceDetailsActivity extends BaseActivity implements IServiceDetailView, View.OnClickListener {

    @ViewInject(R.id.wg_header_back)
    private ImageButton back;

    @ViewInject(R.id.wg_title_txt)
    private TextView title;

    @ViewInject(R.id.wg_collect_btn)
    private ImageButton collectbtn;

    @ViewInject(R.id.painter_servcie_header)
    private View headerLayout;

    @ViewInject(R.id.wg_right_btn)
    private ImageButton more;

    @ViewInject(R.id.tv_special_detail_entry_shop)
    private TextView entryShop;

    @ViewInject(R.id.tv_special_detail_click_collection)
    private TextView collectTv;

    @ViewInject(R.id.bt_special_buy_now)
    private Button buy;

    private RadioGroup radioTabs;

    private CustomViewPager viewPager;

    private long service_id;

    @ViewInject(R.id.flipLayout)
    private McoySnapPageLayout mcoySnapPageLayout;

    private ServiceDetailPresenter presenter;

    private McoyProductContentPage bottomPage = null;
    private McoyProductDetailInfoPage topPage = null;

    private PopupMenu popupMenu;

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.wg_header_back:
                finish();
                break;
            case R.id.wg_collect_btn:
                presenter.getCollectionResult(ThreadValues.getUserId(this), ThreadValues.getSid(this), service_id, detail.getIs_collection() == 1 ? 0 : 1);
                break;
            case R.id.wg_right_btn:
                popupMenu = new PopupMenu(this, true, false);
                popupMenu.setCallback(new PopupMenu.PopupMenuCallback() {
                    @Override
                    public void share() {
                        SharePresenter sharePresenter = new SharePresenter(getThis(),
                                StringUtils.absoluteUrl(detail.getImgs().get(0).getImg()), detail.getService().getName(),
                                "画家" + detail.getPainter().getNickname() + "创作", RestAPI.SHARE_SERVICE_URL + detail.getService().getService_id());
                        sharePresenter.showDialog();
                    }
                });
                popupMenu.showPopupWindow(headerLayout);
                break;
            case R.id.iv_special_detail_star:
                presenter.getPraiseResult(ThreadValues.getUserId(this), ThreadValues.getSid(this), service_id, detail.getIs_praise() == 1 ? 0 : 1);
                break;
            case R.id.tv_special_detail_entry_shop:
                Intent pIntent = new Intent(this, PainterActivity.class);
                pIntent.putExtra("painter_id", detail.getPainter().getPainter_id());
                startActivity(pIntent);
                break;
            case R.id.tv_special_detail_click_collection:
                presenter.getCollectionResult(ThreadValues.getUserId(this), ThreadValues.getSid(this), service_id, detail.getIs_collection() == 1 ? 0 : 1);
                break;
            case R.id.ll_special_detail_seller_layout:
                Intent pIntent2 = new Intent(this, PainterActivity.class);
                pIntent2.putExtra("painter_id", detail.getPainter().getPainter_id());
                startActivity(pIntent2);
                break;
            case R.id.ll_special_detail_select_way:
                dialog.show();
                break;
            case R.id.bt_special_buy_now:
                if (selectedParamValue == null) {
                    toast("请选择服务规格");
                    return;
                }
                if (StringUtils.isNotEmpty(ThreadValues.getSid(this))) {
                    Intent confirm = new Intent(this, SpecialConfirmActivity.class);
                    confirm.putExtra("service_id", service_id);
                    confirm.putExtra("param_id", selectedParamValue.getParam_id());
                    confirm.putExtra("paint_type", paint_type);
                    this.startActivity(confirm);
                } else {
                    onError(RespCode.NULL_SID_CODE, "账号未登录");
                }
                break;
            default:
                break;
        }
    }


    public class TopViewHolder {
        @ViewInject(R.id.slide_view)
        public BannerSlideShowView<ServiceDetail.Images> slideShowView;

        @ViewInject(R.id.tv_special_detail_name)
        public TextView serviceName;
        @ViewInject(R.id.tv_special_detail_current_cost)
        public TextView currentCost;
        @ViewInject(R.id.tv_special_detail_original_cost_1)
        public TextView originalCost;
        @ViewInject(R.id.tv_special_detail_discount)
        public TextView discount;
        @ViewInject(R.id.tv_special_detail_delivery_cost)
        public TextView deliveryCost;
        @ViewInject(R.id.tv_special_detail_sales)
        public TextView sales;

        @ViewInject(R.id.iv_special_detail_star)
        public ImageView star;

        @ViewInject(R.id.service_numbers)
        public TextView numbers;

        @ViewInject(R.id.tv_special_detail_work_time)
        public TextView workTime;

        @ViewInject(R.id.iv_special_detail_seller_icon)
        public RoundedImageView sellerIcon;

        @ViewInject(R.id.iv_special_detail_seller_name)
        public TextView sellerName;

        @ViewInject(R.id.ll_special_detail_select_way)
        public LinearLayout selectWay;

        @ViewInject(R.id.selected_content)
        public TextView selectedContent;

        @ViewInject(R.id.miaos_show)
        public TextView miaos_show;

        @ViewInject(R.id.ll_special_detail_seller_layout)
        public LinearLayout painterLayout;

    }

    private TopViewHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        title.setText("服务详情");
        service_id = getIntent().getLongExtra("service_id", 0);
        View topView = getLayoutInflater().inflate(
                R.layout.mcoy_produt_detail_layout, null);
        topPage = new McoyProductDetailInfoPage(this, topView);
        View bottomView = getLayoutInflater().inflate(
                R.layout.mcoy_product_content_page, null);
        bottomPage = new McoyProductContentPage(this,
                bottomView);

        mcoySnapPageLayout.setSnapPages(topPage, bottomPage);
        holder = new TopViewHolder();
        ViewUtils.inject(holder, topView);
        radioTabs = (RadioGroup) bottomView.findViewById(R.id.painter_service_tabs);
        viewPager = (CustomViewPager) bottomView.findViewById(R.id.painter_service_pager);
        presenter = new ServiceDetailPresenter(this);
        if (TextUtils.isEmpty(ThreadValues.getSid(this))) {
            presenter.getDetail(service_id);
        } else {
            presenter.getDetail(ThreadValues.getUserId(this), ThreadValues.getSid(this), service_id);
        }
        hud.show();
    }

    private ServiceDetail detail;

    @Override
    public void setServiceDetail(ServiceDetail data) {
        hud.dismiss();
        this.detail = data;
        //服务基本信息
        holder.serviceName.setText(data.getService().getName());
        holder.workTime.setText(String.format("创作周期：%s天", data.getService().getPaint_time()));
        holder.originalCost.setText(String.format("￥%s", data.getService().getPrice()));
        holder.originalCost.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.currentCost.setText(data.getService().getIs_discount() == 1 ? data.getService().getDiscount_price() : data.getService().getPrice());
        holder.sales.setText(String.format("销量：%d件", data.getService().getSold_count()));

        holder.numbers.setText(String.format("%d", data.getService().getPraise_count()));

        //轮播图图片
        holder.slideShowView.initData(data.getImgs(), new BannerSlideShowView.BannerCallback<ServiceDetail.Images>() {
            @Override
            public void initImage(ServiceDetail.Images image, ImageView view) {
                ImageUtils.loadImage(getApplicationContext(), image.getImg(), view);
            }

            @Override
            public void onClick(ServiceDetail.Images image) {

            }
        });
        ViewGroup.LayoutParams layoutParams = holder.slideShowView.getLayoutParams();
        layoutParams.height = OSUtils.getScreenWidth();
        holder.slideShowView.setLayoutParams(layoutParams);

        holder.sellerName.setText(data.getPainter().getNickname());
        ImageUtils.loadImage(this, data.getPainter().getImg(), holder.sellerIcon);

        String coupon_name = data.getCoupon_name();
        if (data.getIs_coupon() == 1) {
            holder.discount.setVisibility(View.VISIBLE);
            holder.discount.setText(String.format("优惠：%s", coupon_name));
        } else {
            holder.discount.setVisibility(View.GONE);
        }

        if (data.getIs_collection() == 1) {
            collectTv.setText("已收藏");
            collectbtn.setImageResource(R.mipmap.tabbar_home_checked);
        } else {
            collectTv.setText("收藏");
            collectbtn.setImageResource(R.mipmap.tabbar_home);
        }

        if (data.getIs_praise() == 1) {
            holder.star.setImageResource(R.mipmap.wg_special_detail_star_has);
        } else {
            holder.star.setImageResource(R.mipmap.wg_specail_detail_star_no);
        }

        initDialog(data);

        final ServiceDetailsViewPagerAdapter viewPagerAdapter
                = new ServiceDetailsViewPagerAdapter(getSupportFragmentManager(), this, service_id, data.getPainter().getPainter_id(), data.getService().getContent_url());
        viewPager.setAdapter(viewPagerAdapter);

        back.setOnClickListener(this);
        collectbtn.setOnClickListener(this);
        more.setOnClickListener(this);
        entryShop.setOnClickListener(this);
        collectTv.setOnClickListener(this);
        buy.setOnClickListener(this);
        holder.painterLayout.setOnClickListener(this);
        holder.selectWay.setOnClickListener(this);
        holder.star.setOnClickListener(this);

        radioTabs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.desc_radio) {
                    viewPager.setCurrentItem(0);
                } else if (checkedId == R.id.comment_radio) {
                    viewPager.setCurrentItem(1);
                }
            }
        });
    }

    private CustomDialog dialog;
    private ImageView dialogImage;
    private TextView dialogCost;
    private TextView dialogSelectInfo;
    private TextView dialogPaperSize;
    private ImageButton dialogClose;
    private CategoryCheckBoxGroupService groupDrawMethod;
    private CategoryCheckBoxGroupParams groupPaperCate;
    private Button dialogOk;

    private ServiceRadioGroup serviceRadioGroup;

    private ServiceParamRadioGroup paramRadioGroup;

    private int paint_type;

    ServiceDetail.ServiceParam.Params selectedParamValue;

    private void initDialog(ServiceDetail serviceDetail) {
        View selectView = LayoutInflater.from(this).inflate(R.layout.wg_special_detai_page_select, null);
        dialogImage = (ImageView) selectView.findViewById(R.id.service_img);
        if (serviceDetail.getImgs() != null && serviceDetail.getImgs().size() > 0) {
            ImageUtils.loadImage(this, serviceDetail.getImgs().get(0).getImg(), dialogImage);
        }
        dialogCost = (TextView) selectView.findViewById(R.id.tv_cost);
        dialogSelectInfo = (TextView) selectView.findViewById(R.id.tv_discount_select);
        dialogPaperSize = (TextView) selectView.findViewById(R.id.tv_paper_size);
        dialogClose = (ImageButton) selectView.findViewById(R.id.ib_close);
        serviceRadioGroup = (ServiceRadioGroup) selectView.findViewById(R.id.serviceRadioGroup);
        paramRadioGroup = (ServiceParamRadioGroup) selectView.findViewById(R.id.paramRadioGroup);
        dialogOk = (Button) selectView.findViewById(R.id.bt_buy_now);
        dialog = new CustomDialog.Builder(this).create();
        dialog.setContentView(selectView);
        int[] params = MeasureViewUtil.measureParams(selectView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        serviceRadioGroup.init(serviceDetail.getService_param(), new ServiceRadioGroup.RadioGroupCallback() {
            @Override
            public void onCheckedChenge() {
                ServiceDetail.ServiceParam serviceParam = serviceRadioGroup.get();
                dialogSelectInfo.setText(serviceParam.getPaint_type_name());
                if (serviceParam != null) {
                    paramRadioGroup.init(serviceParam.getParams(), new ServiceParamRadioGroup.RadioGroupCallback() {
                        @Override
                        public void onCheckedChenge() {
                            ServiceDetail.ServiceParam.Params paramValue = paramRadioGroup.get();
                            if (paramValue != null) {
                                dialogCost.setText("￥: " + (paramValue.getIs_discount() == 1 ? paramValue.getDiscount_price() : paramValue.getPrice()));
                                dialogPaperSize.setText(paramValue.getParam_name());
                            }
                        }
                    });
                    paramRadioGroup.setCheckedIndex(0);
                }
            }
        });
        serviceRadioGroup.setCheckedIndex(0);

        dialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceDetail.ServiceParam serviceParam = serviceRadioGroup.get();
                paint_type = serviceParam.getPaint_type();
                selectedParamValue = paramRadioGroup.get();
                holder.selectedContent.setText(dialogSelectInfo.getText() + " " + dialogPaperSize.getText());
                holder.originalCost.setText(String.format("￥%s", selectedParamValue.getPrice()));
                holder.currentCost.setText((selectedParamValue.getIs_discount() == 1 ? selectedParamValue.getDiscount_price() : selectedParamValue.getPrice()) + "");
                holder.deliveryCost.setText("快递: " + selectedParamValue.getPostage() + "元");
                if (selectedParamValue.getIs_seckill() == 1) {
                    holder.miaos_show.setVisibility(View.VISIBLE);
                } else {
                    holder.miaos_show.setVisibility(View.GONE);
                }
                dialog.dismiss();
            }
        });

        dialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    @Override
    public void setCollectionResult(Status data) {
        detail.setIs_collection(data.getStatus());
        if (detail.getIs_collection() == 1) {
            collectTv.setText("已收藏");
            collectbtn.setImageResource(R.mipmap.tabbar_home_checked);
        } else {
            collectTv.setText("收藏");
            collectbtn.setImageResource(R.mipmap.tabbar_home);
        }
    }

    @Override
    public void setPraiseResult(Status data) {
        detail.setIs_praise(data.getStatus());
        if (detail.getIs_praise() == 1) {
            detail.getService().setPraise_count(detail.getService().getPraise_count() + 1);
            holder.star.setImageResource(R.mipmap.wg_special_detail_star_has);
        } else {
            detail.getService().setPraise_count(detail.getService().getPraise_count() - 1);
            holder.star.setImageResource(R.mipmap.wg_specail_detail_star_no);
        }
        holder.numbers.setText(String.valueOf(detail.getService().getPraise_count()));
    }


}
