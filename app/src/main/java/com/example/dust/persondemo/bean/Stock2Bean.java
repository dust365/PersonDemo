package com.example.dust.persondemo.bean;

import java.util.List;

/**
 * Created by dust on 2018/3/13.
 */

public class Stock2Bean {

    //type==1  标题     0是商品
    private int type=0;

    /**
     * 等于1  才有这个 titleName
     */
    private String titleName;
    private int  goodNumber;


    private String goods_id;
    private String goods_commonid;
    private String goods_name;
    private String goods_jingle;
    private String store_id;
    private String store_name;
    private String gc_id;
    private String gc_id_1;
    private String gc_id_2;
    private String gc_id_3;
    private String classify1;
    private String classify2;
    private String classify3;
    private String brand_id;
    private String brand_name;
    private String factory_brand_id;
    private String goods_price;
    private String goods_promotion_price;
    private String goods_promotion_type;
    private String goods_marketprice;
    private String goods_vipprice;
    private String goods_costprice;
    private String goods_4sprice;
    private String goods_serial;
    private String goods_factory_serial;
    private String goods_factory_tno;
    private String goods_factory_oe;
    private String goods_factory_tzzz;
    private String goods_from;
    private String goods_place;
    private String goods_storage_alarm;
    private String goods_click;
    private String goods_salenum;
    private String goods_collect;
    private String goods_spec;
    private String goods_storage;
    private String goods_image;
    private String goods_state;
    private String goods_verify;
    private String goods_addtime;
    private String goods_edittime;
    private String areaid_1;
    private String areaid_2;
    private String color_id;
    private String transport_id;
    private String goods_freight;
    private String transport_type;
    private String goods_vat;
    private String goods_commend;
    private String goods_stcids;
    private String evaluation_good_star;
    private String evaluation_count;
    private String is_virtual;
    private String virtual_indate;
    private String virtual_limit;
    private String virtual_invalid_refund;
    private String is_fcode;
    private String is_appoint;
    private String is_presell;
    private String have_gift;
    private String is_own_shop;
    private String is_gift;
    private String is_orderby;
    private String ddt_goods_id;
    private String is_mobile_buy;
    private String industry_price;
    private String spec;
    private String goodname2;
    private String unit;
    private String model_name;
    private String procurement;
    private String pack;
    private String shelf_life;
    private String remark;
    private String csmc;
    private String platform_id;
    private String uqi_goods_id;
    private String come_from;
    private String goods_isshow;
    private String is_overstocked;
    private String overstocked_tel;
    private String overstocked_discount;
    private String carModel;
    private String carModelTid;
    private String package_spec;
    private String classify_fullname;
    private String goods_type;
    private List<String> goods_tag;
    private String goods_image_url;
    private String goods_from_msg;
    private int if_order;
    private int start_num;
    private String goods_storage_falg;

    public Stock2Bean(int type, String titleName) {
        this.type = type;
        this.titleName = titleName;
    }
    public Stock2Bean(int type, String goods_name,String goods_price) {
        this.type = type;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
    }

    public int getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(int goodNumber) {
        this.goodNumber = goodNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_commonid() {
        return goods_commonid;
    }

    public void setGoods_commonid(String goods_commonid) {
        this.goods_commonid = goods_commonid;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_jingle() {
        return goods_jingle;
    }

    public void setGoods_jingle(String goods_jingle) {
        this.goods_jingle = goods_jingle;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getGc_id() {
        return gc_id;
    }

    public void setGc_id(String gc_id) {
        this.gc_id = gc_id;
    }

    public String getGc_id_1() {
        return gc_id_1;
    }

    public void setGc_id_1(String gc_id_1) {
        this.gc_id_1 = gc_id_1;
    }

    public String getGc_id_2() {
        return gc_id_2;
    }

    public void setGc_id_2(String gc_id_2) {
        this.gc_id_2 = gc_id_2;
    }

    public String getGc_id_3() {
        return gc_id_3;
    }

    public void setGc_id_3(String gc_id_3) {
        this.gc_id_3 = gc_id_3;
    }

    public String getClassify1() {
        return classify1;
    }

    public void setClassify1(String classify1) {
        this.classify1 = classify1;
    }

    public String getClassify2() {
        return classify2;
    }

    public void setClassify2(String classify2) {
        this.classify2 = classify2;
    }

    public String getClassify3() {
        return classify3;
    }

    public void setClassify3(String classify3) {
        this.classify3 = classify3;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getFactory_brand_id() {
        return factory_brand_id;
    }

    public void setFactory_brand_id(String factory_brand_id) {
        this.factory_brand_id = factory_brand_id;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_promotion_price() {
        return goods_promotion_price;
    }

    public void setGoods_promotion_price(String goods_promotion_price) {
        this.goods_promotion_price = goods_promotion_price;
    }

    public String getGoods_promotion_type() {
        return goods_promotion_type;
    }

    public void setGoods_promotion_type(String goods_promotion_type) {
        this.goods_promotion_type = goods_promotion_type;
    }

    public String getGoods_marketprice() {
        return goods_marketprice;
    }

    public void setGoods_marketprice(String goods_marketprice) {
        this.goods_marketprice = goods_marketprice;
    }

    public String getGoods_vipprice() {
        return goods_vipprice;
    }

    public void setGoods_vipprice(String goods_vipprice) {
        this.goods_vipprice = goods_vipprice;
    }

    public String getGoods_costprice() {
        return goods_costprice;
    }

    public void setGoods_costprice(String goods_costprice) {
        this.goods_costprice = goods_costprice;
    }

    public String getGoods_4sprice() {
        return goods_4sprice;
    }

    public void setGoods_4sprice(String goods_4sprice) {
        this.goods_4sprice = goods_4sprice;
    }

    public String getGoods_serial() {
        return goods_serial;
    }

    public void setGoods_serial(String goods_serial) {
        this.goods_serial = goods_serial;
    }

    public String getGoods_factory_serial() {
        return goods_factory_serial;
    }

    public void setGoods_factory_serial(String goods_factory_serial) {
        this.goods_factory_serial = goods_factory_serial;
    }

    public String getGoods_factory_tno() {
        return goods_factory_tno;
    }

    public void setGoods_factory_tno(String goods_factory_tno) {
        this.goods_factory_tno = goods_factory_tno;
    }

    public String getGoods_factory_oe() {
        return goods_factory_oe;
    }

    public void setGoods_factory_oe(String goods_factory_oe) {
        this.goods_factory_oe = goods_factory_oe;
    }

    public String getGoods_factory_tzzz() {
        return goods_factory_tzzz;
    }

    public void setGoods_factory_tzzz(String goods_factory_tzzz) {
        this.goods_factory_tzzz = goods_factory_tzzz;
    }

    public String getGoods_from() {
        return goods_from;
    }

    public void setGoods_from(String goods_from) {
        this.goods_from = goods_from;
    }

    public String getGoods_place() {
        return goods_place;
    }

    public void setGoods_place(String goods_place) {
        this.goods_place = goods_place;
    }

    public String getGoods_storage_alarm() {
        return goods_storage_alarm;
    }

    public void setGoods_storage_alarm(String goods_storage_alarm) {
        this.goods_storage_alarm = goods_storage_alarm;
    }

    public String getGoods_click() {
        return goods_click;
    }

    public void setGoods_click(String goods_click) {
        this.goods_click = goods_click;
    }

    public String getGoods_salenum() {
        return goods_salenum;
    }

    public void setGoods_salenum(String goods_salenum) {
        this.goods_salenum = goods_salenum;
    }

    public String getGoods_collect() {
        return goods_collect;
    }

    public void setGoods_collect(String goods_collect) {
        this.goods_collect = goods_collect;
    }

    public String getGoods_spec() {
        return goods_spec;
    }

    public void setGoods_spec(String goods_spec) {
        this.goods_spec = goods_spec;
    }

    public String getGoods_storage() {
        return goods_storage;
    }

    public void setGoods_storage(String goods_storage) {
        this.goods_storage = goods_storage;
    }

    public String getGoods_image() {
        return goods_image;
    }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }

    public String getGoods_state() {
        return goods_state;
    }

    public void setGoods_state(String goods_state) {
        this.goods_state = goods_state;
    }

    public String getGoods_verify() {
        return goods_verify;
    }

    public void setGoods_verify(String goods_verify) {
        this.goods_verify = goods_verify;
    }

    public String getGoods_addtime() {
        return goods_addtime;
    }

    public void setGoods_addtime(String goods_addtime) {
        this.goods_addtime = goods_addtime;
    }

    public String getGoods_edittime() {
        return goods_edittime;
    }

    public void setGoods_edittime(String goods_edittime) {
        this.goods_edittime = goods_edittime;
    }

    public String getAreaid_1() {
        return areaid_1;
    }

    public void setAreaid_1(String areaid_1) {
        this.areaid_1 = areaid_1;
    }

    public String getAreaid_2() {
        return areaid_2;
    }

    public void setAreaid_2(String areaid_2) {
        this.areaid_2 = areaid_2;
    }

    public String getColor_id() {
        return color_id;
    }

    public void setColor_id(String color_id) {
        this.color_id = color_id;
    }

    public String getTransport_id() {
        return transport_id;
    }

    public void setTransport_id(String transport_id) {
        this.transport_id = transport_id;
    }

    public String getGoods_freight() {
        return goods_freight;
    }

    public void setGoods_freight(String goods_freight) {
        this.goods_freight = goods_freight;
    }

    public String getTransport_type() {
        return transport_type;
    }

    public void setTransport_type(String transport_type) {
        this.transport_type = transport_type;
    }

    public String getGoods_vat() {
        return goods_vat;
    }

    public void setGoods_vat(String goods_vat) {
        this.goods_vat = goods_vat;
    }

    public String getGoods_commend() {
        return goods_commend;
    }

    public void setGoods_commend(String goods_commend) {
        this.goods_commend = goods_commend;
    }

    public String getGoods_stcids() {
        return goods_stcids;
    }

    public void setGoods_stcids(String goods_stcids) {
        this.goods_stcids = goods_stcids;
    }

    public String getEvaluation_good_star() {
        return evaluation_good_star;
    }

    public void setEvaluation_good_star(String evaluation_good_star) {
        this.evaluation_good_star = evaluation_good_star;
    }

    public String getEvaluation_count() {
        return evaluation_count;
    }

    public void setEvaluation_count(String evaluation_count) {
        this.evaluation_count = evaluation_count;
    }

    public String getIs_virtual() {
        return is_virtual;
    }

    public void setIs_virtual(String is_virtual) {
        this.is_virtual = is_virtual;
    }

    public String getVirtual_indate() {
        return virtual_indate;
    }

    public void setVirtual_indate(String virtual_indate) {
        this.virtual_indate = virtual_indate;
    }

    public String getVirtual_limit() {
        return virtual_limit;
    }

    public void setVirtual_limit(String virtual_limit) {
        this.virtual_limit = virtual_limit;
    }

    public String getVirtual_invalid_refund() {
        return virtual_invalid_refund;
    }

    public void setVirtual_invalid_refund(String virtual_invalid_refund) {
        this.virtual_invalid_refund = virtual_invalid_refund;
    }

    public String getIs_fcode() {
        return is_fcode;
    }

    public void setIs_fcode(String is_fcode) {
        this.is_fcode = is_fcode;
    }

    public String getIs_appoint() {
        return is_appoint;
    }

    public void setIs_appoint(String is_appoint) {
        this.is_appoint = is_appoint;
    }

    public String getIs_presell() {
        return is_presell;
    }

    public void setIs_presell(String is_presell) {
        this.is_presell = is_presell;
    }

    public String getHave_gift() {
        return have_gift;
    }

    public void setHave_gift(String have_gift) {
        this.have_gift = have_gift;
    }

    public String getIs_own_shop() {
        return is_own_shop;
    }

    public void setIs_own_shop(String is_own_shop) {
        this.is_own_shop = is_own_shop;
    }

    public String getIs_gift() {
        return is_gift;
    }

    public void setIs_gift(String is_gift) {
        this.is_gift = is_gift;
    }

    public String getIs_orderby() {
        return is_orderby;
    }

    public void setIs_orderby(String is_orderby) {
        this.is_orderby = is_orderby;
    }

    public String getDdt_goods_id() {
        return ddt_goods_id;
    }

    public void setDdt_goods_id(String ddt_goods_id) {
        this.ddt_goods_id = ddt_goods_id;
    }

    public String getIs_mobile_buy() {
        return is_mobile_buy;
    }

    public void setIs_mobile_buy(String is_mobile_buy) {
        this.is_mobile_buy = is_mobile_buy;
    }

    public String getIndustry_price() {
        return industry_price;
    }

    public void setIndustry_price(String industry_price) {
        this.industry_price = industry_price;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getGoodname2() {
        return goodname2;
    }

    public void setGoodname2(String goodname2) {
        this.goodname2 = goodname2;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getProcurement() {
        return procurement;
    }

    public void setProcurement(String procurement) {
        this.procurement = procurement;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getShelf_life() {
        return shelf_life;
    }

    public void setShelf_life(String shelf_life) {
        this.shelf_life = shelf_life;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCsmc() {
        return csmc;
    }

    public void setCsmc(String csmc) {
        this.csmc = csmc;
    }

    public String getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(String platform_id) {
        this.platform_id = platform_id;
    }

    public String getUqi_goods_id() {
        return uqi_goods_id;
    }

    public void setUqi_goods_id(String uqi_goods_id) {
        this.uqi_goods_id = uqi_goods_id;
    }

    public String getCome_from() {
        return come_from;
    }

    public void setCome_from(String come_from) {
        this.come_from = come_from;
    }

    public String getGoods_isshow() {
        return goods_isshow;
    }

    public void setGoods_isshow(String goods_isshow) {
        this.goods_isshow = goods_isshow;
    }

    public String getIs_overstocked() {
        return is_overstocked;
    }

    public void setIs_overstocked(String is_overstocked) {
        this.is_overstocked = is_overstocked;
    }

    public String getOverstocked_tel() {
        return overstocked_tel;
    }

    public void setOverstocked_tel(String overstocked_tel) {
        this.overstocked_tel = overstocked_tel;
    }

    public String getOverstocked_discount() {
        return overstocked_discount;
    }

    public void setOverstocked_discount(String overstocked_discount) {
        this.overstocked_discount = overstocked_discount;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarModelTid() {
        return carModelTid;
    }

    public void setCarModelTid(String carModelTid) {
        this.carModelTid = carModelTid;
    }

    public String getPackage_spec() {
        return package_spec;
    }

    public void setPackage_spec(String package_spec) {
        this.package_spec = package_spec;
    }

    public String getClassify_fullname() {
        return classify_fullname;
    }

    public void setClassify_fullname(String classify_fullname) {
        this.classify_fullname = classify_fullname;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public List<String> getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(List<String> goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getGoods_image_url() {
        return goods_image_url;
    }

    public void setGoods_image_url(String goods_image_url) {
        this.goods_image_url = goods_image_url;
    }

    public String getGoods_from_msg() {
        return goods_from_msg;
    }

    public void setGoods_from_msg(String goods_from_msg) {
        this.goods_from_msg = goods_from_msg;
    }

    public int getIf_order() {
        return if_order;
    }

    public void setIf_order(int if_order) {
        this.if_order = if_order;
    }

    public int getStart_num() {
        return start_num;
    }

    public void setStart_num(int start_num) {
        this.start_num = start_num;
    }

    public String getGoods_storage_falg() {
        return goods_storage_falg;
    }

    public void setGoods_storage_falg(String goods_storage_falg) {
        this.goods_storage_falg = goods_storage_falg;
    }


}
