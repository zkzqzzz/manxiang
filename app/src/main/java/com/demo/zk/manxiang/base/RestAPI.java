package com.demo.zk.manxiang.base;

/**
 * Created by HG on 2015/10/22.
 */
public class RestAPI {

    public final static String API_ROOT = "http://api.manxianger.com/Api/";

    // public final static String IMG_ROOT = "http://cdn.manxianger.com/";

    public final static String IMG_ROOT = "http://cdn.manxianger.com/";

    public final static String SMS_URL = API_ROOT + "Common/sendSMS";

    public final static String REGIST_URL = API_ROOT + "User/register";

    public final static String LOGIN_URL = API_ROOT + "User/login";

    public final static String THIRD_LOGIN_URL = API_ROOT + "User/thirdLogin";

    public final static String GET_INFO_URL = API_ROOT + "User/getInfo";

    public final static String LOGOUT_URL = API_ROOT + "User/logout";

    public final static String RESET_PASSWORD_URL = API_ROOT + "User/resetPassword";

    public final static String UPDATE_INFO_URL = API_ROOT + "User/updateInfo";

    public final static String UPLOAD_IMAGE_URL = API_ROOT + "Common/uploadImage";

    public final static String UPLOAD_PASSWORD_URL = API_ROOT + "User/editPassword";

    public final static String BIND_MOBILEPHONE_URL = API_ROOT + "User/bindMobilephone";

    public final static String SERVICE_GET_CAT_URL = API_ROOT + "Service/getCat";

    public final static String SERVICE_GET_LIST_URL = API_ROOT + "Service/getList";

    public final static String SERVICE_GET_HOT_LIST_URL = API_ROOT + "Service/getHotList";

    public final static String SERVICE_PRAISE_URL = API_ROOT + "Service/praise";

    public final static String BANNER_GET_URL = API_ROOT + "Banner/getBanner";

    public final static String SERVICE_DETAIL_GET_URL = API_ROOT + "Service/getDetail";

    public final static String SERVICE_COMMENT_GET_URL = API_ROOT + "Service/getComment";

    public final static String SERVICE_COLLECT_URL = API_ROOT + "Service/collection";

    public final static String SERVICE_CANCEL_COLLECT_URL = API_ROOT + "Service/cancelCollection";

    public final static String SERVICE_GET_COLLECTION_URL = API_ROOT + "Service/getCollection";

    public final static String SECKILL_GET_URL = API_ROOT + "Seckill/getDetail";

    public final static String PLACE_ORDER_URL = API_ROOT + "Order/placeOrder";

    public final static String PREPARE_PLACE_ORDER_URL = API_ROOT + "Order/preparePlaceOrder";

    public final static String DELETE_ORDER_URL = API_ROOT + "Order/delete";

    public final static String REMIND_ORDER_URL = API_ROOT + "Order/remind";

    public final static String LIST_ORDER_URL = API_ROOT + "Order/getList";

    public final static String RUNNING_ORDER_URL = API_ROOT + "Order/getRunningList";

    public final static String FINNISHED_ORDER_URL = API_ROOT + "Order/getFinishedList";

    public final static String CONFIRM_ORDER_URL = API_ROOT + "Order/receiveConfirm";

    public final static String COMMENT_ORDER_URL = API_ROOT + "Order/comment";

    public final static String MINE_COMMENT_ORDER_URL = API_ROOT + "Order/getComment";

    public final static String COMMENT_COUNT_ORDER_URL = API_ROOT + "Order/getCommentCount";

    public final static String DETAILS_ORDER_URL = API_ROOT + "Order/getDetail";

    public final static String STATUS_ORDER_URL = API_ROOT + "Order/updateStatus";

    public final static String STATUS_ORDER_COUNT_URL = API_ROOT + "Order/getStatusCountList";

    public final static String CANCEL_ORDER_URL = API_ROOT + "Order/cancel";

    public final static String SEARCH_ORDER_URL = API_ROOT + "Order/search";

    public final static String PREPARE_REFUND_ORDER_URL = API_ROOT + "Order/prepareRefund";

    public final static String ORDER_PREPARE_REFUND_GOODS_URL = API_ROOT + "Order/prepareReturnGoods";

    public final static String ORDER_REFUND_GOODS_URL = API_ROOT + "Order/returnGoods";

    public final static String ORDER_REFUND_LIST_URL = API_ROOT + "Order/getRefundList";

    public final static String ORDER_REFUND_DETAIL_URL = API_ROOT + "Order/getRefundDetail";

    public final static String REFUND_ORDER_URL = API_ROOT + "Order/refund";

    public final static String SERVICE_KEYWORD_INFO_URL = API_ROOT + "Painter/getServiceSearchInfo";


    public final static String MESSAGE_LIST_URL = API_ROOT + "Message/getList";

    public final static String MESSAGE_DETAILS_URL = API_ROOT + "Message/getDetail";

    public final static String FACEBACK_URL = API_ROOT + "User/feedback";

    public final static String CONFIG_URL = API_ROOT + "Common/config";

    public final static String WXPAY_URL = API_ROOT + "Order/wxPayPlaceOrder";

    public final static String SHARE_IMG_URL = API_ROOT + "Share/img?url=";

    public final static String SHARE_ORDER_URL = API_ROOT + "Share/orderImg";

    /*************************************************************/

    public final static String SPECIAL_LIST_URL = API_ROOT + "Special/getList";

    public final static String SPECIAL_DETAIL_URL = API_ROOT + "Special/getDetail";

    public final static String SPECIAL_SERVICES_URL = API_ROOT + "Special/getService";

    public final static String SECKILL_TIMES_URL = API_ROOT + "Seckill/getTime";

    public final static String SECKILL_LIST_URL = API_ROOT + "Seckill/getList";

    public final static String SERVICE_CAT_URL = API_ROOT + "Service/getCat";

    public final static String BANNER_CAT_URL = API_ROOT + "Banner/getCatTag";

    public final static String SERVICE_LIST_URL = API_ROOT + "Service/getList";

    public final static String PAINTER_DETAILS_URL = API_ROOT + "Painter/getDetail";

    public final static String PAINTER_GET_COLLECTION_URL = API_ROOT + "Painter/getCollection";

    public final static String PAINTER_SEARCH_COLLECTION_URL = API_ROOT + "Painter/searchCollection";

    public final static String PAINTER_COLLECTION_URL = API_ROOT + "Painter/collection";

    public final static String PAINTER_CANCEL_COLLECTION_URL = API_ROOT + "Painter/cancelCollection";

    public final static String PAINTER_SERVICES_URL = API_ROOT + "Painter/getService";

    public final static String REGISTERPAINTE_URL = API_ROOT + "User/registerPainter";

    public final static String PAINTER_NEW_SERVICES_URL = API_ROOT + "Painter/getNewService";

    public final static String PAINTER_COMMENT_URL = API_ROOT + "Painter/getComment";

    public final static String SERVICE_SEARCH_URL = API_ROOT + "Service/search";

    public final static String SERVICE_SEARCH_INFO_URL = API_ROOT + "Service/getSearchInfo";

    public final static String PAINTER_SEARCH_URL = API_ROOT + "Painter/search";

    public static final String REDEEM_CODE_URL = API_ROOT + "RedeemCode/check";

    public static final String SPECIAL_COLLECTION_URL = API_ROOT + "Special/collection";

    public static final String SPECIAL_CANCEL_COLLECTION_URL = API_ROOT + "Special/cancelCollection";

    public static final String SPECIAL_SEARCH_COLLECTION_URL = API_ROOT + "Special/searchCollection";

    public static final String SPECIAL_COLLECTION_LIST_URL = API_ROOT + "Special/getCollection";

    public static final String SERVICE_SEARCH_COLLECTION_URL = API_ROOT + "Service/searchCollection";

    public final static String PAINTER_HOME_URL = API_ROOT + "Painter/home";

    public final static String ADDRESS_ADD = API_ROOT + "Address/add";
    public final static String ADDRESS_UPDATE = API_ROOT + "Address/update";
    public final static String ADDRESS_DELETE = API_ROOT + "Address/delete";
    public final static String ADDRESS_GETLIST = API_ROOT + "Address/getList";
    public final static String ADDRESS_GETDETAIL = API_ROOT + "Address/getDetail";
    public final static String ADDRESS_SETDEFAULT = API_ROOT + "Address/setDefault";
    public final static String REGION_URL = API_ROOT + "Common/region";

    public final static String HOT_SERVICES_URL = API_ROOT + "Service/getHotList";
    public final static String EVALUATED_URL = API_ROOT + "Order/getComment";

    public final static String SHARE_SERVICE_URL = API_ROOT + "Share/serviceDetail?service_id=";

    public final static String SHARE_SPECIAL_URL = API_ROOT + "Share/specialDetail?special_id=";

    public final static String SHARE_PAINTER_URL = API_ROOT + "Share/painterDetail?painter_id=";
}
