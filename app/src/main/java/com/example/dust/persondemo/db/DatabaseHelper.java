/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.util.Log
 *  com.handlecar.hcbusinessclientgsc.model.WorkCompany
 *  com.handlecar.hcbusinessclientgsc.model.WorkOrders
 *  com.handlecar.hcbusinessclientgsc.util.StringUtils
 *  com.litesuits.orm.log.OrmLog
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.example.dust.persondemo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.handlecar.hcbusinessclientgsc.model.WorkCompany;
import com.handlecar.hcbusinessclientgsc.model.WorkOrders;
import com.handlecar.hcbusinessclientgsc.util.StringUtils;
import com.litesuits.orm.log.OrmLog;

public class DatabaseHelper
extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "handlecar.db";
    private static final int DATABASE_VERSION = 6;
    private static DatabaseHelper mdbHelper = null;

    public DatabaseHelper(Context context, String string2, SQLiteDatabase.CursorFactory cursorFactory, int n) {
        super(context, string2, cursorFactory, n);
    }

    public static DatabaseHelper getInstance(Context context, String string2, SQLiteDatabase.CursorFactory cursorFactory) {
        if (mdbHelper == null) {
            mdbHelper = new DatabaseHelper(context, string2, cursorFactory, 6);
        }
        return mdbHelper;
    }

    public void clearData() {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS car_work_info");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS company_info");
        this.onCreate(sQLiteDatabase);
    }

    public void closeDb() {
        if (mdbHelper != null) {
            mdbHelper.close();
        }
    }

    public void delWoChoseItemCount(int n, int n2) {
        this.getWritableDatabase().execSQL("update car_work_info set choseditem = choseditem - " + n + " where order_id=" + n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public WorkCompany getWorkCompanyByCompanyId(int n) {
        WorkCompany workCompany = new WorkCompany();
        if (n <= 0) {
            return workCompany;
        }
        Cursor cursor = null;
        try {
            cursor = this.getWritableDatabase().rawQuery("select * from company_info where company_id =" + n, null);
            if (cursor.moveToNext()) {
                workCompany.setCompanyId(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("company_id"))));
                workCompany.setCompanyName(cursor.getString(cursor.getColumnIndex("company_name")));
                workCompany.setCompanyAddress(cursor.getString(cursor.getColumnIndex("company_address")));
                workCompany.setCompanyTel(cursor.getString(cursor.getColumnIndex("company_tel")));
                Log.i((String)"info_out", (String)("company_name:" + workCompany.getCompanyName()));
                Log.i((String)"info_out", (String)("company_address:" + workCompany.getCompanyAddress()));
                Log.i((String)"info_out", (String)("company_tel:" + workCompany.getCompanyTel()));
            }
            if (cursor == null) return workCompany;
        }
        catch (Exception var5_4) {
            var5_4.printStackTrace();
            return workCompany;
        }
        finally {
            if (cursor == null) return workCompany;
            if (cursor.isClosed()) return workCompany;
            cursor.close();
        }
        if (cursor.isClosed()) return workCompany;
        cursor.close();
        return workCompany;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public WorkOrders getWorkOrdersByOrderid(int n) {
        WorkOrders workOrders = new WorkOrders();
        if (n <= 0) {
            return workOrders;
        }
        Cursor cursor = null;
        try {
            cursor = this.getWritableDatabase().rawQuery("select *  from car_work_info where order_id =" + n, null);
            if (cursor.moveToNext()) {
                workOrders.setMembercarid(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("memcar_id"))));
                workOrders.setMemberid(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("mem_id"))));
                workOrders.setOrderid(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("order_id"))));
                workOrders.setWorkid(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("work_id"))));
                workOrders.setCarmiles(cursor.getInt(cursor.getColumnIndex("carmiles")));
                workOrders.setMembercarmiles(cursor.getInt(cursor.getColumnIndex("memcarmiles")));
                workOrders.setCarplate(cursor.getString(cursor.getColumnIndex("carplate")));
                workOrders.setMembername(cursor.getString(cursor.getColumnIndex("memname")));
                workOrders.setCartype(cursor.getString(cursor.getColumnIndex("cartype")));
                workOrders.setVinno(cursor.getString(cursor.getColumnIndex("vin")));
                workOrders.setExpectdelivery(cursor.getString(cursor.getColumnIndex("expect_time")));
                workOrders.setRecommenditemcnt(cursor.getInt(cursor.getColumnIndex("recommit_cnt")));
                workOrders.setRemindcnt(cursor.getInt(cursor.getColumnIndex("remind_cnt")));
                workOrders.setDebtsprice(Float.valueOf((float)cursor.getFloat(cursor.getColumnIndex("debays"))));
                workOrders.setSelectitemcnt(cursor.getInt(cursor.getColumnIndex("choseditem")));
                workOrders.setCarmiles(cursor.getInt(cursor.getColumnIndex("carmiles")));
                workOrders.setMembercarmiles(cursor.getInt(cursor.getColumnIndex("memcarmiles")));
                workOrders.setSenderid(cursor.getInt(cursor.getColumnIndex("senderid")));
                workOrders.setSenderphone(cursor.getString(cursor.getColumnIndex("senderphone")));
                workOrders.setSendername(cursor.getString(cursor.getColumnIndex("sendername")));
                workOrders.setVincartype(cursor.getString(cursor.getColumnIndex("vincartype")));
                workOrders.setPkgcnt(cursor.getInt(cursor.getColumnIndex("pkgcnt")));
                workOrders.setWashitemcnt(cursor.getInt(cursor.getColumnIndex("washcar_cnt")));
                workOrders.setIsgscflg(cursor.getInt(cursor.getColumnIndex("isgscflg")));
                workOrders.setOrdercomplete(cursor.getInt(cursor.getColumnIndex("ordercomplete")));
                workOrders.setMembercaropenid(cursor.getString(cursor.getColumnIndex("membercaropenid")));
                workOrders.setMembercarid(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("membercarid"))));
                workOrders.setBusinessinfo(cursor.getString(cursor.getColumnIndex("businssinfo")));
                workOrders.setWocomment(cursor.getString(cursor.getColumnIndex("wocomment")));
            }
            if (cursor == null) return workOrders;
        }
        catch (Exception var5_4) {
            var5_4.printStackTrace();
            return workOrders;
        }
        finally {
            if (cursor == null) return workOrders;
            if (cursor.isClosed()) return workOrders;
            cursor.close();
        }
        if (cursor.isClosed()) return workOrders;
        cursor.close();
        return workOrders;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public WorkOrders getWorkOrdersByOrderid_new(int n) {
        WorkOrders workOrders = new WorkOrders();
        Cursor cursor = null;
        try {
            cursor = this.getWritableDatabase().rawQuery("select *  from car_work_info where order_id =" + n, null);
            if (!cursor.moveToNext()) return workOrders;
            workOrders.setMembercarid(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("memcar_id"))));
            workOrders.setMemberid(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("mem_id"))));
            workOrders.setOrderid(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("order_id"))));
            workOrders.setWorkid(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("work_id"))));
            workOrders.setCarmiles(cursor.getInt(cursor.getColumnIndex("carmiles")));
            workOrders.setMembercarmiles(cursor.getInt(cursor.getColumnIndex("memcarmiles")));
            workOrders.setCarplate(cursor.getString(cursor.getColumnIndex("carplate")));
            workOrders.setMembername(cursor.getString(cursor.getColumnIndex("memname")));
            workOrders.setCartype(cursor.getString(cursor.getColumnIndex("cartype")));
            workOrders.setVinno(cursor.getString(cursor.getColumnIndex("vin")));
            workOrders.setExpectdelivery(cursor.getString(cursor.getColumnIndex("expect_time")));
            workOrders.setRecommenditemcnt(cursor.getInt(cursor.getColumnIndex("recommit_cnt")));
            workOrders.setRemindcnt(cursor.getInt(cursor.getColumnIndex("remind_cnt")));
            workOrders.setDebtsprice(Float.valueOf((float)cursor.getFloat(cursor.getColumnIndex("debays"))));
            workOrders.setSelectitemcnt(cursor.getInt(cursor.getColumnIndex("choseditem")));
            workOrders.setCarmiles(cursor.getInt(cursor.getColumnIndex("carmiles")));
            workOrders.setMembercarmiles(cursor.getInt(cursor.getColumnIndex("memcarmiles")));
            workOrders.setSenderid(cursor.getInt(cursor.getColumnIndex("senderid")));
            workOrders.setSenderphone(cursor.getString(cursor.getColumnIndex("senderphone")));
            workOrders.setSendername(cursor.getString(cursor.getColumnIndex("sendername")));
            workOrders.setVincartype(cursor.getString(cursor.getColumnIndex("vincartype")));
            workOrders.setPkgcnt(cursor.getInt(cursor.getColumnIndex("pkgcnt")));
            workOrders.setWashitemcnt(cursor.getInt(cursor.getColumnIndex("washcar_cnt")));
            workOrders.setIsgscflg(cursor.getInt(cursor.getColumnIndex("isgscflg")));
            workOrders.setOrdercomplete(cursor.getInt(cursor.getColumnIndex("ordercomplete")));
            workOrders.setMembercaropenid(cursor.getString(cursor.getColumnIndex("membercaropenid")));
            workOrders.setMembercarid(Integer.valueOf((int)cursor.getInt(cursor.getColumnIndex("membercarid"))));
            workOrders.setBusinessinfo(cursor.getString(cursor.getColumnIndex("businssinfo")));
            workOrders.setWocomment(cursor.getString(cursor.getColumnIndex("wocomment")));
            return workOrders;
        }
        catch (Exception var5_4) {
            var5_4.printStackTrace();
            return workOrders;
        }
        finally {
            if (cursor == null) return workOrders;
            if (cursor.isClosed()) return workOrders;
            cursor.close();
        }
    }

    public void insert(WorkOrders workOrders) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        if (!StringUtils.isEmpty((String)workOrders.getMembercarbusinssinfo())) {
            workOrders.setBusinssinfo(workOrders.getMembercarbusinssinfo());
        }
        OrmLog.i((String)"wo.getBusinssinfo()", (String)(workOrders.getBusinssinfo() + "\u662f\u4e0d\u662f\u4e00\u5b9a\u8981\u6709"));
        Object[] arrobject = new Object[]{workOrders.getMembercarid(), workOrders.getMemberid(), workOrders.getOrderid(), workOrders.getWorkid(), workOrders.getCarplate(), workOrders.getMembername(), workOrders.getCartype(), workOrders.getVinno(), workOrders.getExpectdelivery(), workOrders.getRecommenditemcnt(), workOrders.getRemindcnt(), workOrders.getSelectitemcnt(), workOrders.getDebtsprice(), workOrders.getCarmiles(), workOrders.getMembercarmiles(), workOrders.getSenderid(), workOrders.getSendername(), workOrders.getSenderphone(), workOrders.getVincartype(), workOrders.getPkgcnt(), workOrders.getWashitemcnt(), workOrders.getIsgscflg(), workOrders.getOrdercomplete(), workOrders.getMembercaropenid(), workOrders.getMembercarid(), workOrders.getBusinssinfo(), workOrders.getWocomment()};
        sQLiteDatabase.execSQL("replace into car_work_info(memcar_id, mem_id, order_id, work_id,carplate, memname,cartype,vin,expect_time,recommit_cnt,remind_cnt,choseditem,debays,carmiles,memcarmiles,senderid,sendername,senderphone,vincartype,pkgcnt,washcar_cnt,isgscflg,ordercomplete,membercaropenid,membercarid,businssinfo,wocomment) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", arrobject);
    }

    public void insertCompany(WorkCompany workCompany) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        Object[] arrobject = new Object[]{workCompany.getCompanyId(), workCompany.getCompanyName(), workCompany.getCompanyAddress(), workCompany.getCompanyTel()};
        sQLiteDatabase.execSQL("replace into company_info(company_id, company_name, company_address, company_tel) values(?,?,?,?)", arrobject);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table car_work_info(memcar_id integer primary key,mem_id integer, order_id integer,work_id integer, carplate text,memname text,cartype text, vin text, expect_time text,recommit_cnt integer,remind_cnt integer,choseditem integer, debays float,carmiles integer,memcarmiles integer,senderid integer,sendername text,senderphone text,vincartype text,pkgcnt integer,washcar_cnt integer,isgscflg integer,ordercomplete integer,membercaropenid text,membercarid integer,businssinfo text,wocomment text)");
        sQLiteDatabase.execSQL("create table company_info(company_id integer primary key, company_name text, company_address text, company_tel text)");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        throw new SQLiteException("Can't downgrade database from version " + n + " to " + n2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS car_work_info");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS company_info");
        this.onCreate(sQLiteDatabase);
    }

    public void updateWoChoseItemCount(int n, int n2) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        Object[] arrobject = new Object[]{n, n2};
        sQLiteDatabase.execSQL("update car_work_info set choseditem = ? where order_id=?", arrobject);
    }

    public void updatedelPkgCount(int n, int n2) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        Object[] arrobject = new Object[]{n, n2};
        sQLiteDatabase.execSQL("update car_work_info set pkgcnt = pkgcnt - ? where order_id=?", arrobject);
    }

    public void updateplusPkgCount(int n, int n2) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        Object[] arrobject = new Object[]{n, n2};
        sQLiteDatabase.execSQL("update car_work_info set pkgcnt = pkgcnt + ? where order_id=?", arrobject);
    }
}

