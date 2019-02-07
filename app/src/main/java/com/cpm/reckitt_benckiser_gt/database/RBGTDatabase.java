package com.cpm.reckitt_benckiser_gt.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cpm.reckitt_benckiser_gt.R;
import com.cpm.reckitt_benckiser_gt.delegates.CoverageBean;
import com.cpm.reckitt_benckiser_gt.getterSetter.AnswerChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.BrandMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.BrandMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.CategoryMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.CategoryMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.ChecklistAnswer;
import com.cpm.reckitt_benckiser_gt.getterSetter.ChecklistAnswerGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.ChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.ChecklistMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.ChecklistMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.CommonChillerDataGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.FocusProductGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.GeotaggingBeans;
import com.cpm.reckitt_benckiser_gt.getterSetter.JCPGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.JourneyPlan;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingCTU;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingCTUGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingCategoryChecklist;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingCategoryChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingCategoryDressing;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingCategoryDressingGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingFocusSku;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingFocusSkuGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingInitiativeGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingMenu;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingMenuChecklist;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingMenuChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingMenuGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingPosm;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingPosmGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingVisibilityInitiative;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingVisicooler;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingVisicoolerGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingWindChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingWindow;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingWindowChecklist;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingWindowGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MenuMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.MenuMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonCategoryReason;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonCategoryReasonGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonExecutionReason;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonExecutionReasonGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonWindowReason;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonWindowReasonGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonWorkingReason;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonWorkingReasonGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.PosmMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.PosmMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.StoreProfileGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.StoreTypeMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.StoreTypeMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.VisiColoersGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowCheckAnswerGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowChecklist;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowChecklistAnswer;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowNonReasonGetterSetter;
import com.cpm.reckitt_benckiser_gt.utilities.CommonString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RBGTDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Modelez_GT_DB2";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    Context context;

    public RBGTDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public void open() {
        try {
            db = this.getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            //jeevan
            db.execSQL(CommonString.CREATE_TABLE_COVERAGE_DATA);
            db.execSQL(CommonString.CREATE_TABLE_WINDOWS_DATA);
            db.execSQL(CommonString.CREATE_TABLE_INSERT_CHECKLIST_DATA);
            db.execSQL(CommonString.CREATE_TABLE_CATEGORY_DRESSING_DATA);
            db.execSQL(CommonString.CREATE_TABLE_INSERT_CATEGORY_DRESSING_CHECKLIST_DATA);
            db.execSQL(CommonString.CREATE_TABLE_STORE_GEOTAGGING);
            db.execSQL(CommonString.CREATE_TABLE_CATEGORY_DBSR_DATA);
            db.execSQL(CommonString.CREATE_TABLE_Journey_Plan_DBSR_Saved);

            db.execSQL(CommonString.CREATE_TABLE_STORE_PROFILE_DATA);
            //usk
            db.execSQL(CommonString.CREATE_TABLE_POSM_DEPLOYMENT);
            //   db.execSQL(CommonString.CREATE_TABLE_TABLE_VISICOOLER);
            db.execSQL(CommonString.CREATE_TABLE_TABLE_VISICOOLER_CHEKLIST);
            db.execSQL(CommonString.CREATE_TABLE_FOCUS_PRODUCT_OPENINGHEADER_DATA);
            db.execSQL(CommonString.CREATE_TABLE_FOCUS_PRODUCT_STOCK_DATA);
            db.execSQL(CommonString.CREATE_TABLE_VISICOOLER_DATA);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int createtable(String sqltext) {
        try {
            db.execSQL(sqltext);
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }


    public void deleteTableWithStoreID(String storeid) {
        db.delete(CommonString.TABLE_COVERAGE_DATA, CommonString.KEY_STORE_ID + "='" + storeid + "'", null);
        db.delete(CommonString.TABLE_WINDOWS_DATA, CommonString.KEY_STORE_ID + "='" + storeid + "'", null);
        db.delete(CommonString.TABLE_INSERT_CHECKLIST_DATA, CommonString.KEY_STORE_ID + "='" + storeid + "'", null);
        db.delete(CommonString.TABLE_CATEGORY_DRESSING_DATA, CommonString.KEY_STORE_ID + "='" + storeid + "'", null);
        db.delete(CommonString.TABLE_INSERT_CATEGORY_DRESSING_CHECKLIST_DATA, CommonString.KEY_STORE_ID + "='" + storeid + "'", null);
        //db.delete(CommonString.TABLE_Journey_Plan_DBSR_Saved, CommonString.KEY_STORE_ID + "='" + storeid + "'", null);
        db.delete(CommonString.TABLE_CATEGORY_DBSR_DATA, CommonString.KEY_STORE_ID + "='" + storeid + "'", null);
        db.delete(CommonString.TABLE_STORE_PROFILE_DATA, CommonString.KEY_STORE_ID + "='" + storeid + "'", null);
    }

    public void updateStatus(String id, String status) {
        ContentValues values = new ContentValues();
        try {
            values.put("GEO_TAG", status);
            db.update(CommonString.KEY_JOURNEY_PLAN, values, CommonString.KEY_STORE_ID + "='" + id + "'", null);
        } catch (Exception ex) {
        }
    }

    public long InsertSTOREgeotag(String storeid, double lat, double longitude, String path, String status) {
        ContentValues values = new ContentValues();
        try {
            values.put("STORE_ID", storeid);
            values.put("LATITUDE", Double.toString(lat));
            values.put("LONGITUDE", Double.toString(longitude));
            values.put("FRONT_IMAGE", path);
            values.put("GEO_TAG", status);
            values.put("STATUS", status);

            return db.insert(CommonString.TABLE_STORE_GEOTAGGING, null, values);

        } catch (Exception ex) {
            Log.d("Database Exception ", ex.toString());
            return 0;
        }
    }

    public long updateInsertedGeoTagStatus(String id, String status) {
        ContentValues values = new ContentValues();
        try {
            values.put("GEO_TAG", status);
            values.put("STATUS", status);
            return db.update(CommonString.TABLE_STORE_GEOTAGGING, values, CommonString.KEY_STORE_ID + "='" + id + "'", null);
        } catch (Exception ex) {
            return 0;
        }
    }

    public ArrayList<CoverageBean> getCoverageDataPrevious(String visitdate) {

        ArrayList<CoverageBean> list = new ArrayList<CoverageBean>();
        Cursor dbcursor = null;

        try {

            dbcursor = db.rawQuery("SELECT  * from " + CommonString.TABLE_COVERAGE_DATA + " where "
                            + CommonString.KEY_VISIT_DATE + " <> '" + visitdate + "'",
                    null);

            if (dbcursor != null) {

                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    CoverageBean sb = new CoverageBean();

                    sb.setStoreId(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_ID)));
                    sb.setUserId(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_USER_ID)));
                    sb.setVisitDate(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_VISIT_DATE)));
                    sb.setLatitude(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LATITUDE)));
                    sb.setLongitude(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LONGITUDE)));
                    sb.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IMAGE)));
                    sb.setReason(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON)));
                    sb.setReasonid(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON_ID)));
                    sb.setMID(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_ID))));
                    //sb.setCkeckout_image(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CHECKOUT_IMAGE)));

                    sb.setRemark(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_COVERAGE_REMARK)));

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exception get JCP!", e.toString());
            return list;
        }
        return list;
    }


    public ArrayList<CoverageBean> getCoverageWithStoreIDAndVisitDate_Data(String store_id, String visitdate) {

        ArrayList<CoverageBean> list = new ArrayList<CoverageBean>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * from " + CommonString.TABLE_COVERAGE_DATA + " where " + CommonString.KEY_STORE_ID + "='" + store_id + "' AND " + CommonString.KEY_VISIT_DATE + "='" + visitdate + "'", null);

            if (dbcursor != null) {

                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    CoverageBean sb = new CoverageBean();

                    sb.setStoreId(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_ID)));
                    sb.setVisitDate((((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_VISIT_DATE))))));
                    sb.setLatitude(((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LATITUDE)))));
                    sb.setLongitude(((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LONGITUDE)))));
                    sb.setImage((((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IMAGE))))));
                    sb.setReasonid((((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON_ID))))));
                    if (dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_COVERAGE_REMARK)) == null) {
                        sb.setRemark("");
                    } else {
                        sb.setRemark((((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_COVERAGE_REMARK))))));
                    }
                    sb.setReason((((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON))))));

                   /* sb.setInTime(((dbcursor.getString(dbcursor
                            .getColumnIndexOrThrow(CommonString.KEY_IN_TIME)))));
                    sb.setOutTime(((dbcursor.getString(dbcursor
                            .getColumnIndexOrThrow(CommonString.KEY_OUT_TIME)))));*/
                    sb.setMID(Integer.parseInt(((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_ID))))));
                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exception get JCP!", e.toString());
            return list;
        }
        return list;
    }

    public ArrayList<WindowNonReasonGetterSetter> getWindowNonReasonData() {
        ArrayList<WindowNonReasonGetterSetter> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("Select 0 as WReason_Id,'Select' as WReason union SELECT WReason_Id,WReason FROM Non_Window_Reason", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    WindowNonReasonGetterSetter sb = new WindowNonReasonGetterSetter();
                    sb.setWREASON_CD(dbcursor.getString(dbcursor.getColumnIndexOrThrow("WReason_Id")));
                    sb.setWREASON(dbcursor.getString(dbcursor.getColumnIndexOrThrow("WReason")));
                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception when fetching Non working!!!!!!!!!!!", e.toString());
            return list;
        }
        Log.d("Fetching non working data---------------------->Stop<-----------", "-------------------");
        return list;
    }


    public ArrayList<NonCategoryReason> getCategoryNonReasonData() {
        ArrayList<NonCategoryReason> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("Select 0 as CReason_Id,'Select' as CReason union SELECT CReason_Id,CReason FROM Non_Category_Reason", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    NonCategoryReason sb = new NonCategoryReason();
                    sb.setCReasonId(dbcursor.getInt(dbcursor.getColumnIndexOrThrow("CReason_Id")));
                    sb.setCReason(dbcursor.getString(dbcursor.getColumnIndexOrThrow("CReason")));
                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception when fetching Non working!!!!!!!!!!!", e.toString());
            return list;
        }
        Log.d("Fetching non working data---------------------->Stop<-----------", "-------------------");
        return list;
    }


    public ArrayList<WindowMaster> getWindowListData(JourneyPlan jcp) {
        Log.d("Fetchecklidata->Start<-", "-");
        ArrayList<WindowMaster> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
/*            dbcursor = db.rawQuery(" select wmap.Brand_id as Brand_id, wm.Window_id as Window_id, wm.window as window from window_master wm " +
                    "inner join Mapping_Visibility_Initiatives wmap on wm.window_id=wmap.window_id " +
                    "where state_id = " + jcp.getStateId() + " and Distributor_id = " + jcp.getDistributorId() + " and Store_Type_Id = " + jcp.getStoreTypeId() + "", null);*/

          /*  dbcursor = db.rawQuery("select wmap.Brand_id as Brand_id,bm.Brand as Brand, wm.Window_id as Window_id, wm.window as window, IFNULL(d.Existornot,'false') as EXISTORNOT, IFNULL(d.window_Image,'') as WINDOW_IMAGE,IFNULL( d.Reason_Id,'0') as REASON_ID from window_master wm inner join Mapping_Visibility_Initiatives_New wmap on wm.window_id = wmap.window_id" +
                    " inner join Brand_Master bm on wmap.Brand_Id = bm.Brand_Id left join" +
                    " (select * from WINDOWS_DATA Where Store_Id = " + jcp.getStoreId() + " and Date ='" + jcp.getVisitDate() + "') as d on wm.Window_Id = d.WINDOW_CD" +
                    "  where state_id = " + jcp.getStateId() + " and Distributor_id = " + jcp.getDistributorId() + " and Store_Type_Id = " + jcp.getStoreTypeId() + " and Classification_Id = " + jcp.getClassificationId() + "", null);*/


            dbcursor = db.rawQuery("select distinct wmap.Brand_id as Brand_id,bm.Brand as Brand, wm.Window_id as Window_id, wm.window as window,wm.Window_Image as Window_Image, IFNULL(d.Existornot,'false') as EXISTORNOT, IFNULL(d.window_Image,'') as WINDOW_IMAGE,IFNULL( d.Reason_Id,'0') as REASON_ID from window_master wm inner join Mapping_Visibility_Initiatives_New wmap on wm.window_id = wmap.window_id" +
                    " inner join Brand_Master bm on wmap.Brand_Id = bm.Brand_Id left join" +
                    " (select * from WINDOWS_DATA Where Store_Id = " + jcp.getStoreId() + " and Date ='" + jcp.getVisitDate() + "') as d on wm.Window_Id = d.WINDOW_CD and wmap.Brand_Id=d.BRAND_ID" +
                    "  where state_id = " + jcp.getStateId() + " and Distributor_id = " + jcp.getDistributorId() + " and Store_Type_Id = " + jcp.getStoreTypeId() + " and Classification_Id = " + jcp.getClassificationId() + " and Store_Category_Id = " + jcp.getStoreCategoryId() + "", null);


            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    WindowMaster ch = new WindowMaster();
                    ch.setBrand_Id(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Brand_id")));
                    ch.setBrand(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Brand")));
                    ch.setWindowId(dbcursor.getInt(dbcursor.getColumnIndexOrThrow("Window_id")));
                    ch.setWindow(dbcursor.getString(dbcursor.getColumnIndexOrThrow("window")));
                    ch.setExist(Boolean.parseBoolean(dbcursor.getString(dbcursor.getColumnIndexOrThrow("EXISTORNOT"))));
                    ch.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow("WINDOW_IMAGE")));
                    ch.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("REASON_ID"))));
                    ch.setWindow_Image_refrance(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Window_Image")));
                    list.add(ch);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exc get windows list!", e.toString());
            return list;
        }
        Log.d("Fetching check->Stop<", "-");
        return list;
    }

    public ArrayList<CategoryMaster> getCategoryDressingData(JourneyPlan jcp) {
        Log.d("Fetchecklidata->Start<-", "-");
        ArrayList<CategoryMaster> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery(" select cm.Category_Id as Category_Id, cm.Category as Category, IFNULL(d.EXISTORNOT,'false') as EXISTORNOT, IFNULL(d.CATEGORY_IMAGE,'') as CATEGORY_IMAGE,IFNULL( d.REASON_ID,'0') as REASON_ID, IFNULL(cmap.Category_Planogram_Imageurl,'') as Category_Planogram_Imageurl from Category_Master cm  " +
                    " inner join Mapping_Category_Dressing cmap on cm.Category_Id=cmap.Category_Id " +
                    " left join " +
                    " (select * from CATEGORY_DRESSING_DATA Where STORE_ID = " + jcp.getStoreId() + " and DATE ='" + jcp.getVisitDate() + "') as d on cm.Category_Id = d.CATEGORY_CD " +
                    " where state_id = " + jcp.getStateId() + " and Distributor_id = " + jcp.getDistributorId() + " and Store_Type_Id = " + jcp.getStoreTypeId() + " order by Category_Sequence", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    CategoryMaster ch = new CategoryMaster();
                    ch.setCategoryId(dbcursor.getInt(dbcursor.getColumnIndexOrThrow("Category_Id")));
                    ch.setCategory(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Category")));
                    ch.setExist(Boolean.parseBoolean(dbcursor.getString(dbcursor.getColumnIndexOrThrow("EXISTORNOT"))));
                    ch.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow("CATEGORY_IMAGE")));
                    ch.setCategoryPlanogramImageurl(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Category_Planogram_Imageurl")));
                    ch.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("REASON_ID"))));
                    list.add(ch);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exc get windows list!", e.toString());
            return list;
        }
        Log.d("Fetching check->Stop<", "-");
        return list;
    }


    public ArrayList<CategoryMaster> getCategoryDBSRData(JourneyPlan jcp) {
        Log.d("Fetchecklidata->Start<-", "-");
        ArrayList<CategoryMaster> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            /*dbcursor = db.rawQuery(" select cm.Category_Id as Category_Id, cm.Category as Category, IFNULL(d.EXISTORNOT,'false') as EXISTORNOT, IFNULL(d.CATEGORY_IMAGE,'') as CATEGORY_IMAGE,IFNULL( d.REASON_ID,'0') as REASON_ID from Category_Master cm  " +
                    " inner join Mapping_Category_Dressing cmap on cm.Category_Id=cmap.Category_Id " +
                    " left join " +
                    " (select * from CATEGORY_DRESSING_DATA Where STORE_ID = " + jcp.getStoreId() + " and DATE ='" + jcp.getVisitDate() + "') as d on cm.Category_Id = d.CATEGORY_CD " +
                    " where state_id = " + jcp.getStateId() + " and Distributor_id = " + jcp.getDistributorId() + " and Store_Type_Id = " + jcp.getStoreTypeId() + " order by Category_Sequence", null);*/


            dbcursor = db.rawQuery("Select cm.Category_Id,cm.Category,IFNULL(cs.EXISTORNOT,'false') as EXISTORNOT,IFNULL(cs.CATEGORY_IMAGE,'') as CATEGORY_IMAGE from Category_Master cm " +
                    " left join (Select * from CATEGORY_DBSR_DATA) as cs on cm.Category_Id = cs.CATEGORY_CD" +
                    " and cs.STORE_ID = " + jcp.getStoreId() + " and cs.DATE = '" + jcp.getVisitDate() + "' order by cm.Category_Sequence", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    CategoryMaster ch = new CategoryMaster();
                    ch.setCategoryId(dbcursor.getInt(dbcursor.getColumnIndexOrThrow("Category_Id")));
                    ch.setCategory(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Category")));
                    ch.setExist(Boolean.parseBoolean(dbcursor.getString(dbcursor.getColumnIndexOrThrow("EXISTORNOT"))));
                    ch.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow("CATEGORY_IMAGE")));
                    list.add(ch);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exc get windows list!", e.toString());
            return list;
        }
        Log.d("Fetching check->Stop<", "-");
        return list;
    }


    public ArrayList<ChecklistGetterSetter> getChecklistData(String window_cd, JourneyPlan journeyPlan) {
        Log.d("Fetchecklidata->Start<-", "-");
        ArrayList<ChecklistGetterSetter> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
           /* dbcursor = db.rawQuery("SELECT DISTINCT WC.Checklist_Id as CHECKLIST_CD, WC.Checklist as CHECKLIST" +
                    " FROM MAPPING_WINDOW_CHECKLIST MWC INNER JOIN WINDOW_CHECKLIST WC ON MWC.Checklist_Id = WC.Checklist_Id" +
                    " WHERE MWC.window_id ='" + window_cd + "'", null);*/

            dbcursor = db.rawQuery("SELECT DISTINCT WC.Checklist_Id as CHECKLIST_CD, WC.Checklist as CHECKLIST,d.ANSWER_CD as ANSWER_CD  FROM  MAPPING_WINDOW_CHECKLIST MWC " +
                    " INNER JOIN WINDOW_CHECKLIST WC ON MWC.Checklist_Id = WC.Checklist_Id " +
                    "  left join " +
                    "  (select * from CheckList_DATA Where STORE_ID = " + journeyPlan.getStoreId() + " and DATE ='" + journeyPlan.getVisitDate() + "') as d " +
                    "  on WC.Checklist_Id = d.CHECKLIST_CD and MWC.Window_id = d.WINDOW_CD " +
                    " WHERE MWC.window_id ='" + window_cd + "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    ChecklistGetterSetter ch = new ChecklistGetterSetter();
                    ch.setChecklist_cd(dbcursor.getString(dbcursor.getColumnIndexOrThrow("CHECKLIST_CD")));
                    ch.setChecklist(dbcursor.getString(dbcursor.getColumnIndexOrThrow("CHECKLIST")));
                    ch.setANSWER_CD(dbcursor.getString(dbcursor.getColumnIndexOrThrow("ANSWER_CD")));
                    //ch.setAnswer("");
                    list.add(ch);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exc get windows list!", e.toString());
            return list;
        }
        Log.d("Fetching check->Stop<", "-");
        return list;
    }


    public ArrayList<ChecklistGetterSetter> getCategoryDressingChecklistData(String categoryId, JourneyPlan journeyPlan) {
        Log.d("Fetchecklidata->Start<-", "-");
        ArrayList<ChecklistGetterSetter> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            /*dbcursor = db.rawQuery("SELECT DISTINCT WC.Checklist_Id as CHECKLIST_CD, WC.Checklist as CHECKLIST" +
                    " FROM Mapping_Category_Checklist MWC INNER JOIN WINDOW_CHECKLIST WC ON MWC.Checklist_Id = WC.Checklist_Id" +
                    " WHERE MWC.Category_Id ='" + categoryId + "'", null);*/

            dbcursor = db.rawQuery("SELECT DISTINCT WC.Checklist_Id as CHECKLIST_CD, WC.Checklist as CHECKLIST,d.ANSWER_CD as ANSWER_CD" +
                    " FROM Mapping_Category_Checklist MWC INNER JOIN WINDOW_CHECKLIST WC ON MWC.Checklist_Id = WC.Checklist_Id" +
                    "  left join" +
                    "  (select * from CATEGORY_DRESSING_CHECKLIST_DATA Where STORE_ID = " + journeyPlan.getStoreId() + " and DATE ='" + journeyPlan.getVisitDate() + "') as d " +
                    "  on WC.Checklist_Id = d.CHECKLIST_CD and MWC.Category_Id = d.CATEGORY_CD " +
                    " WHERE MWC.Category_Id ='" + categoryId + "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    ChecklistGetterSetter ch = new ChecklistGetterSetter();
                    ch.setChecklist_cd(dbcursor.getString(dbcursor.getColumnIndexOrThrow("CHECKLIST_CD")));
                    ch.setChecklist(dbcursor.getString(dbcursor.getColumnIndexOrThrow("CHECKLIST")));
                    ch.setANSWER_CD(dbcursor.getString(dbcursor.getColumnIndexOrThrow("ANSWER_CD")));
                    //ch.setAnswer_type(dbcursor.getString(dbcursor.getColumnIndexOrThrow("ANSWER_TYPE")));
                    ch.setAnswer("");
                    list.add(ch);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exc get windows list!", e.toString());
            return list;
        }
        Log.d("Fetching check->Stop<", "-");
        return list;
    }


    public ArrayList<AnswerChecklistGetterSetter> getChecklistAnswerData(String checklist_cd) {
        Log.d("Fetanswerdata->Start<-", "-");
        ArrayList<AnswerChecklistGetterSetter> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT DISTINCT Checklist_Id, Answer_Id, Answer FROM WINDOW_CHECKLIST_ANSWER  WHERE Checklist_Id =" + checklist_cd + "", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    AnswerChecklistGetterSetter ch = new AnswerChecklistGetterSetter();
                    ch.setChecklist_cd(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Checklist_Id")));
                    ch.setAnswer_cd(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Answer_Id")));
                    ch.setAnswer(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Answer")));
                    list.add(ch);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exc get ans list!", e.toString());
            return list;
        }
        Log.d("Fet checklist->Stop<", "-");
        return list;
    }


    public long InsertWindowsData(String username, JourneyPlan jcp, ArrayList<WindowMaster> listDataHeader, HashMap<WindowMaster, ArrayList<ChecklistGetterSetter>> listDataChild) {
        long l = 0, common_id = 0;
        db.delete(CommonString.TABLE_WINDOWS_DATA, "STORE_ID ='" + jcp.getStoreId() + "'", null);
        db.delete(CommonString.TABLE_INSERT_CHECKLIST_DATA, "STORE_ID ='" + jcp.getStoreId() + "'", null);
        ContentValues values;
        ContentValues value2 = new ContentValues();
        try {

            for (int i = 0; i < listDataHeader.size(); i++) {
                values = new ContentValues();
                values.put("DATE", jcp.getVisitDate());
                values.put(CommonString.KEY_USER_ID, username);
                values.put(CommonString.KEY_STORE_ID, jcp.getStoreId());
                values.put("WINDOW_CD", listDataHeader.get(i).getWindowId());
                values.put("BRAND_ID", listDataHeader.get(i).getBrand_Id());
                values.put("EXISTORNOT", String.valueOf(listDataHeader.get(i).isExist()));
                values.put("WINDOW_IMAGE", listDataHeader.get(i).getImage());
                values.put("WINDOW_IMAGE2", listDataHeader.get(i).getImage2());
                values.put("REASON_ID", listDataHeader.get(i).getReasonId());

                common_id = db.insert(CommonString.TABLE_WINDOWS_DATA, null, values);

                if (listDataHeader.get(i).isExist()) {
                    ArrayList<ChecklistGetterSetter> checklist = listDataChild.get(listDataHeader.get(i));
                    for (int j = 0; j < checklist.size(); j++) {
                        values = new ContentValues();
                        values.put("DATE", jcp.getVisitDate());
                        values.put(CommonString.KEY_USER_ID, username);
                        values.put(CommonString.KEY_STORE_ID, jcp.getStoreId());
                        values.put("WINDOW_CD", listDataHeader.get(i).getWindowId());
                        values.put(CommonString.KEY_COMMON_ID, String.valueOf(common_id));
                        values.put("CHECKLIST_CD", checklist.get(j).getChecklist_cd());
                        values.put("ANSWER_CD", checklist.get(j).getANSWER_CD());

                        l = db.insert(CommonString.TABLE_INSERT_CHECKLIST_DATA, null, values);
                    }
                }
            }

            if (common_id > 0) {
                return common_id;
            } else {
                return 0;
            }

        } catch (Exception ex) {
            Log.d("Database Exception while Insert Store Data ", ex.toString());
            return 0;
        }
    }

    public long InsertWindowsCheckListData(String username, JourneyPlan jcp, WindowMaster windowMaster, ArrayList<ChecklistGetterSetter> listDataChild) {
        long l = 0, common_id = 0;
        db.delete(CommonString.TABLE_WINDOWS_DATA, "STORE_ID ='" + jcp.getStoreId() + "' AND WINDOW_CD = " + windowMaster.getWindowId() + "", null);
        db.delete(CommonString.TABLE_INSERT_CHECKLIST_DATA, "STORE_ID ='" + jcp.getStoreId() + "' AND WINDOW_CD = " + windowMaster.getWindowId() + "", null);
        ContentValues values;
        ContentValues value2 = new ContentValues();
        try {


            values = new ContentValues();
            values.put("DATE", jcp.getVisitDate());
            values.put(CommonString.KEY_USER_ID, username);
            values.put(CommonString.KEY_STORE_ID, jcp.getStoreId());
            values.put("WINDOW_CD", windowMaster.getWindowId());
            values.put("BRAND_ID", windowMaster.getBrand_Id());
            values.put("EXISTORNOT", String.valueOf(windowMaster.isExist()));
            values.put("WINDOW_IMAGE", windowMaster.getImage());
            values.put("WINDOW_IMAGE2", windowMaster.getImage2());
            values.put("REASON_ID", windowMaster.getReasonId());

            common_id = db.insert(CommonString.TABLE_WINDOWS_DATA, null, values);

            if (windowMaster.isExist()) {
                ArrayList<ChecklistGetterSetter> checklist = listDataChild;
                for (int j = 0; j < checklist.size(); j++) {
                    values = new ContentValues();
                    values.put("DATE", jcp.getVisitDate());
                    values.put(CommonString.KEY_USER_ID, username);
                    values.put(CommonString.KEY_STORE_ID, jcp.getStoreId());
                    values.put("WINDOW_CD", windowMaster.getWindowId());
                    values.put(CommonString.KEY_COMMON_ID, String.valueOf(common_id));
                    values.put("CHECKLIST_CD", checklist.get(j).getChecklist_cd());
                    values.put("ANSWER_CD", checklist.get(j).getANSWER_CD());

                    l = db.insert(CommonString.TABLE_INSERT_CHECKLIST_DATA, null, values);
                }
            }

            if (common_id > 0) {
                return common_id;
            } else {
                return 0;
            }

        } catch (Exception ex) {
            Log.d("Database Exception while Insert Store Data ", ex.toString());
            return 0;
        }
    }

    public long InsertCategoryDressingData(String username, JourneyPlan jcp, ArrayList<CategoryMaster> listDataHeader, HashMap<CategoryMaster, ArrayList<ChecklistGetterSetter>> listDataChild) {
        long l = 0, common_id = 0;
        db.delete(CommonString.TABLE_CATEGORY_DRESSING_DATA, "STORE_ID ='" + jcp.getStoreId() + "'", null);
        db.delete(CommonString.TABLE_INSERT_CATEGORY_DRESSING_CHECKLIST_DATA, "STORE_ID ='" + jcp.getStoreId() + "'", null);
        ContentValues values;
        ContentValues value2 = new ContentValues();
        try {

            for (int i = 0; i < listDataHeader.size(); i++) {
                values = new ContentValues();
                values.put("DATE", jcp.getVisitDate());
                values.put(CommonString.KEY_USER_ID, username);
                values.put(CommonString.KEY_STORE_ID, jcp.getStoreId());
                values.put("CATEGORY_CD", listDataHeader.get(i).getCategoryId());
                values.put("EXISTORNOT", String.valueOf(listDataHeader.get(i).isExist()));
                values.put("CATEGORY_IMAGE", listDataHeader.get(i).getImage());
                values.put("REASON_ID", listDataHeader.get(i).getReasonId());

                common_id = db.insert(CommonString.TABLE_CATEGORY_DRESSING_DATA, null, values);

                if (listDataHeader.get(i).isExist()) {
                    ArrayList<ChecklistGetterSetter> checklist = listDataChild.get(listDataHeader.get(i));
                    for (int j = 0; j < checklist.size(); j++) {
                        values = new ContentValues();
                        values.put("DATE", jcp.getVisitDate());
                        values.put(CommonString.KEY_USER_ID, username);
                        values.put(CommonString.KEY_STORE_ID, jcp.getStoreId());
                        values.put("CATEGORY_CD", listDataHeader.get(i).getCategoryId());
                        values.put(CommonString.KEY_COMMON_ID, String.valueOf(common_id));
                        values.put("CHECKLIST_CD", checklist.get(j).getChecklist_cd());
                        values.put("ANSWER_CD", checklist.get(j).getANSWER_CD());

                        l = db.insert(CommonString.TABLE_INSERT_CATEGORY_DRESSING_CHECKLIST_DATA, null, values);
                    }
                }

            }

            if (common_id > 0) {
                return common_id;
            } else {
                return 0;
            }

        } catch (Exception ex) {
            Log.d("Database Exception while Insert Store Data ", ex.toString());
            return 0;
        }

    }


    public long InsertCategoryDBSRData(String username, JourneyPlan jcp, ArrayList<CategoryMaster> listDataHeader) {
        long l = 0, common_id = 0;
        db.delete(CommonString.TABLE_CATEGORY_DBSR_DATA, "STORE_ID ='" + jcp.getStoreId() + "'", null);
        ContentValues values;
        try {

            for (int i = 0; i < listDataHeader.size(); i++) {
                values = new ContentValues();
                values.put("DATE", jcp.getVisitDate());
                values.put(CommonString.KEY_USER_ID, username);
                values.put(CommonString.KEY_STORE_ID, jcp.getStoreId());
                values.put("CATEGORY_CD", listDataHeader.get(i).getCategoryId());
                values.put("EXISTORNOT", String.valueOf(listDataHeader.get(i).isExist()));
                values.put("CATEGORY_IMAGE", listDataHeader.get(i).getImage());

                common_id = db.insert(CommonString.TABLE_CATEGORY_DBSR_DATA, null, values);
            }

            if (common_id > 0) {
                return common_id;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            Log.d("Database Exception while Insert Store Data ", ex.toString());
            return 0;
        }

    }

    public ArrayList<CategoryMaster> getCategoryDBSRSavedData(String storeid, String visit_date) {

        ArrayList<CategoryMaster> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("select * From " + CommonString.TABLE_CATEGORY_DBSR_DATA + " where " + CommonString.KEY_STORE_ID + " = " + storeid + " and " + CommonString.KEY_DDATE + " = '" + visit_date + "'", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {

                    CategoryMaster categoryMaster = new CategoryMaster();
                    categoryMaster.setKey_Id(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IID)));
                    categoryMaster.setCategoryId(Integer.valueOf(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CATEGORY_CD))));
                    categoryMaster.setExist(Boolean.parseBoolean(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_EXISTORNOT))));
                    categoryMaster.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CATEGORY_IMAGE)));

                    list.add(categoryMaster);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception when fetching Records!!!!!!!!!!!!!!!!!!!!!", e.toString());
            return list;
        }
        return list;
    }


    public ArrayList<WindowMaster> getWindowData(String storeid, String visit_date) {

        ArrayList<WindowMaster> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("select * From " + CommonString.TABLE_WINDOWS_DATA + " where " + CommonString.KEY_STORE_ID + " = " + storeid + " and " + CommonString.KEY_DDATE + " = '" + visit_date + "'", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {

                    WindowMaster windowMaster = new WindowMaster();
                    windowMaster.setKey_Id(String.valueOf(dbcursor.getInt(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IID))));
                    windowMaster.setBrand_Id(String.valueOf(dbcursor.getInt(dbcursor.getColumnIndexOrThrow(CommonString.KEY_BRAND_ID))));
                    windowMaster.setWindowId(Integer.valueOf(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_WINDOW_CD))));
                    windowMaster.setExist(Boolean.parseBoolean(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_EXISTORNOT))));
                    windowMaster.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_WINDOW_IMAGE)));
                    windowMaster.setImage2(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_WINDOW_IMAGE2)));
                    windowMaster.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON_ID))));

                    list.add(windowMaster);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception when fetching Records!!!!!!!!!!!!!!!!!!!!!", e.toString());
            return list;
        }
        return list;
    }

    public ArrayList<ChecklistGetterSetter> getWindowCheckListData(String storeid, String visit_date, String commonId) {
        ArrayList<ChecklistGetterSetter> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("select * From " + CommonString.TABLE_INSERT_CHECKLIST_DATA + " where " + CommonString.KEY_STORE_ID + " = " + storeid + " and " + CommonString.KEY_DDATE + " = '" + visit_date + "' and " + CommonString.KEY_COMMON_ID + " = " + commonId + "", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    ChecklistGetterSetter checklistGetSet = new ChecklistGetterSetter();

                    checklistGetSet.setCOMMON_ID(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_COMMON_ID)));
                    checklistGetSet.setWINDOW_CD(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_WINDOW_CD)));
                    checklistGetSet.setCHECKLIST_CD(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CHECKLIST_CD)));
                    checklistGetSet.setANSWER_CD(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_ANSWER_CD)));

                    list.add(checklistGetSet);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception when fetching Records!!!!!!!!!!!!!!!!!!!!!", e.toString());
            return list;
        }
        return list;
    }

    public ArrayList<ChecklistGetterSetter> getCategoryDressingCheckListData(String storeid, String visit_date, String commonId) {
        ArrayList<ChecklistGetterSetter> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("select * From " + CommonString.TABLE_INSERT_CATEGORY_DRESSING_CHECKLIST_DATA + " where " + CommonString.KEY_STORE_ID + " = " + storeid + " and " + CommonString.KEY_DDATE + " = '" + visit_date + "' and " + CommonString.KEY_COMMON_ID + " = " + commonId + "", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    ChecklistGetterSetter checklistGetSet = new ChecklistGetterSetter();

                    checklistGetSet.setCOMMON_ID(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_COMMON_ID)));
                    checklistGetSet.setWINDOW_CD(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CATEGORY_CD)));
                    checklistGetSet.setCHECKLIST_CD(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CHECKLIST_CD)));
                    checklistGetSet.setANSWER_CD(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_ANSWER_CD)));

                    list.add(checklistGetSet);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception when fetching Records!!!!!!!!!!!!!!!!!!!!!", e.toString());
            return list;
        }
        return list;
    }

    public ArrayList<CategoryMaster> getCategoryDressingData(String storeid, String visit_date) {

        ArrayList<CategoryMaster> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("select * From " + CommonString.TABLE_CATEGORY_DRESSING_DATA + " where " + CommonString.KEY_STORE_ID + " = " + storeid + " and " + CommonString.KEY_DDATE + " = '" + visit_date + "'", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {

                    CategoryMaster categoryMaster = new CategoryMaster();
                    categoryMaster.setKey_Id(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IID)));
                    categoryMaster.setCategoryId(Integer.valueOf(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CATEGORY_CD))));
                    categoryMaster.setExist(Boolean.parseBoolean(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_EXISTORNOT))));
                    categoryMaster.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CATEGORY_IMAGE)));
                    categoryMaster.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON_ID))));

                    list.add(categoryMaster);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception when fetching Records!!!!!!!!!!!!!!!!!!!!!", e.toString());
            return list;
        }
        return list;
    }

    public long updateCheckoutStatus(String id, String status, String table) {
        ContentValues values = new ContentValues();
        try {
            values.put("Upload_Status", status);
            return db.update(table, values, "Store_Id " + " = '" + id + "'", null);
        } catch (Exception ex) {
            Log.e("Exception", " Journey_Plan" + ex.toString());
            return 0;
        }
    }

    public void updateStoreStatus(String storeid, String visitdate, String status) {
        try {
            ContentValues values = new ContentValues();
            values.put("Upload_Status", status);
            db.update("Journey_Plan", values, "Store_Id ='" + storeid + "' AND Visit_Date ='" + visitdate + "'", null);
        } catch (Exception e) {

        }
    }

    public long InsertCoverageData(CoverageBean data) {
        db.delete(CommonString.TABLE_COVERAGE_DATA, "STORE_ID" + "='" + data.getStoreId() + "' AND VISIT_DATE='" + data.getVisitDate() + "'", null);
        ContentValues values = new ContentValues();
        long l = 0;
        try {
            values.put(CommonString.KEY_STORE_ID, data.getStoreId());
            values.put(CommonString.KEY_USER_ID, data.getUserId());
            values.put(CommonString.KEY_VISIT_DATE, data.getVisitDate());
            values.put(CommonString.KEY_LATITUDE, data.getLatitude());
            values.put(CommonString.KEY_LONGITUDE, data.getLongitude());
            values.put(CommonString.KEY_IMAGE, data.getImage());
            values.put(CommonString.KEY_COVERAGE_REMARK, data.getRemark());
            values.put(CommonString.KEY_REASON_ID, data.getReasonid());
            values.put(CommonString.KEY_REASON, data.getReason());
            values.put(CommonString.KEY_CHECKOUT_IMAGE, data.getCkeckout_image());
            l = db.insert(CommonString.TABLE_COVERAGE_DATA, null, values);
        } catch (Exception ex) {
            Log.d("Database Exception while Insert Closes Data ", ex.toString());
        }
        return l;
    }

    public long updateStoreStatusOnLeave(String storeid, String visitdate, String status) {
        long id = 0;
        try {
            ContentValues values = new ContentValues();
            values.put("UPLOAD_STATUS", status);
            id = db.update(CommonString.TABLE_Journey_Plan, values, CommonString.KEY_STORE_ID + "='" + storeid + "' AND "
                    + CommonString.KEY_VISIT_DATE + "='" + visitdate
                    + "'", null);
            return id;
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean insertJCPData(JCPGetterSetter data) {
        db.delete("Journey_Plan", null, null);
        List<JourneyPlan> jcpList = data.getJourneyPlan();
        ContentValues values = new ContentValues();
        try {
            if (jcpList.size() == 0) {
                return false;
            }
            for (int i = 0; i < jcpList.size(); i++) {
                values.put("Store_Id", jcpList.get(i).getStoreId());
                values.put("Visit_Date", jcpList.get(i).getVisitDate());
                values.put("Distributor", jcpList.get(i).getDistributorN());
                values.put("Store_Name", jcpList.get(i).getStoreName());
                values.put("Address1", jcpList.get(i).getAddress1());
                values.put("Address2", jcpList.get(i).getAddress2());
                values.put("Landmark", jcpList.get(i).getLandmark());
                values.put("Pincode", jcpList.get(i).getPincode());
                values.put("Contact_Person", jcpList.get(i).getContactPerson());
                values.put("Contact_No", jcpList.get(i).getContactNo());
                values.put("City", jcpList.get(i).getCity());
                values.put("Store_Type", jcpList.get(i).getStoreType());
                values.put("Store_Category", jcpList.get(i).getStoreCategory());
                values.put("State_Id", jcpList.get(i).getStateId());
                values.put("Store_Type_Id", jcpList.get(i).getStoreTypeId());
                values.put("Store_Category_Id", jcpList.get(i).getStoreCategoryId());
                values.put("Reason_Id", jcpList.get(i).getReasonId());
                values.put("Upload_Status", jcpList.get(i).getUploadStatus());
                values.put("Geo_Tag", jcpList.get(i).getGeoTag());
                values.put("Distributor_Id", jcpList.get(i).getDistributorId());
                values.put("Classification_Id", jcpList.get(i).getClassificationId());
                values.put("GeoFencing", jcpList.get(i).getGeoFencing());
                values.put("Latitude", jcpList.get(i).getLatitude());
                values.put("Longitude", jcpList.get(i).getLongitude());
                values.put("Store_Code", jcpList.get(i).getStore_Code());
                values.put("Classification", jcpList.get(i).getClassification());

                long id = db.insert("Journey_Plan", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in Jcp", ex.toString());
            return false;
        }
    }

    public boolean insertJCP_DBSRData(JCPGetterSetter data) {
        db.delete("Journey_Plan_DBSR", null, null);
        List<JourneyPlan> jcpList = data.getJourneyPlan_dbsr();
        ContentValues values = new ContentValues();
        try {
            if (jcpList.size() == 0) {
                return false;
            }
            for (int i = 0; i < jcpList.size(); i++) {
                values.put("Store_Id", jcpList.get(i).getStoreId());
                values.put("Visit_Date", jcpList.get(i).getVisitDate());
                values.put("Distributor", jcpList.get(i).getDistributorN());
                values.put("Store_Name", jcpList.get(i).getStoreName());
                values.put("Address1", jcpList.get(i).getAddress1());
                values.put("Address2", jcpList.get(i).getAddress2());
                values.put("Landmark", jcpList.get(i).getLandmark());
                values.put("Pincode", jcpList.get(i).getPincode());
                values.put("Contact_Person", jcpList.get(i).getContactPerson());
                values.put("Contact_No", jcpList.get(i).getContactNo());
                values.put("City", jcpList.get(i).getCity());
                values.put("Store_Type", jcpList.get(i).getStoreType());
                values.put("Store_Category", jcpList.get(i).getStoreCategory());
                values.put("State_Id", jcpList.get(i).getStateId());
                values.put("Store_Type_Id", jcpList.get(i).getStoreTypeId());
                values.put("Store_Category_Id", jcpList.get(i).getStoreCategoryId());
                values.put("Reason_Id", jcpList.get(i).getReasonId());
                values.put("Upload_Status", jcpList.get(i).getUploadStatus());
                values.put("Geo_Tag", jcpList.get(i).getGeoTag());
                values.put("Distributor_Id", jcpList.get(i).getDistributorId());
                values.put("Weekly_Upload", jcpList.get(i).getWeeklyUpload());
                long id = db.insert("Journey_Plan_DBSR", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in Journey_Plan_DBSR", ex.toString());
            return false;
        }
    }


    public boolean insertJCP_DBSRSavedData(JourneyPlan data) {
        db.delete(CommonString.TABLE_Journey_Plan_DBSR_Saved, "Store_Id = " + data.getStoreId() + "", null);
        ContentValues values = new ContentValues();
        try {
            if (data == null) {
                return false;
            }
            values.put("Store_Id", data.getStoreId());
            values.put("Visit_Date", data.getVisitDate());
            values.put("Distributor", data.getDistributorN());
            values.put("Store_Name", data.getStoreName());
            values.put("Address1", data.getAddress1());
            values.put("Address2", data.getAddress2());
            values.put("Landmark", data.getLandmark());
            values.put("Pincode", data.getPincode());
            values.put("Contact_Person", data.getContactPerson());
            values.put("Contact_No", data.getContactNo());
            values.put("City", data.getCity());
            values.put("Store_Type", data.getStoreType());
            values.put("Store_Category", data.getStoreCategory());
            values.put("State_Id", data.getStateId());
            values.put("Store_Type_Id", data.getStoreTypeId());
            values.put("Store_Category_Id", data.getStoreCategoryId());
            values.put("Reason_Id", data.getReasonId());
            values.put("Upload_Status", data.getUploadStatus());
            values.put("Geo_Tag", data.getGeoTag());
            values.put("Distributor_Id", data.getDistributorId());
            long id = db.insert(CommonString.TABLE_Journey_Plan_DBSR_Saved, null, values);
            if (id == -1) {
                throw new Exception();
            }

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in Journey_Plan_DBSR", ex.toString());
            return false;
        }
    }

    public boolean insertBrandMasterData(BrandMasterGetterSetter BrandMastergetset) {
        db.delete("Brand_Master", null, null);
        ContentValues values = new ContentValues();
        List<BrandMaster> data = BrandMastergetset.getBrandMaster();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {

                values.put("Brand", data.get(i).getBrand());
                values.put("Brand_Id", data.get(i).getBrandId());
                values.put("Brand_Sequence", data.get(i).getBrandSequence());
                values.put("Sub_Category_Id", data.get(i).getSubcategoryId());
                values.put("Company_Id", data.get(i).getCompany_Id());

                long id = db.insert("Brand_Master", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }


    public boolean insertStoreTypeMasterData(StoreTypeMasterGetterSetter storeTypeMaster) {
        db.delete("Store_Type_Master", null, null);
        ContentValues values = new ContentValues();
        List<StoreTypeMaster> data = storeTypeMaster.getStoreTypeMaster();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {

                values.put("Store_Type", data.get(i).getStoreType());
                values.put("Store_Type_Id", data.get(i).getStoreTypeId());
                values.put("Show_Reference_Image", data.get(i).getShowReferenceImage());

                long id = db.insert("Store_Type_Master", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }


    public boolean insertNonWorkingData(NonWorkingReasonGetterSetter nonWorkingdata) {
        db.delete("Non_Working_Reason", null, null);
        ContentValues values = new ContentValues();
        List<NonWorkingReason> data = nonWorkingdata.getNonWorkingReason();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {

                values.put("Reason_Id", data.get(i).getReasonId());
                values.put("Reason", data.get(i).getReason());
                values.put("Entry_Allow", data.get(i).getEntryAllow());
                values.put("Image_Allow", data.get(i).getImageAllow());
                values.put("GPS_Mandatory", data.get(i).getGPSMandatory());

                long id = db.insert("Non_Working_Reason", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertNonCategoryReasonData(NonCategoryReasonGetterSetter nonCategorydata) {
        db.delete("Non_Category_Reason", null, null);
        ContentValues values = new ContentValues();
        List<NonCategoryReason> data = nonCategorydata.getNonCategoryReason();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {
                values.put("CReason_Id", data.get(i).getCReasonId());
                values.put("CReason", data.get(i).getCReason());
                long id = db.insert("Non_Category_Reason", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertCategoryMasterData(CategoryMasterGetterSetter CategoryMaster) {
        db.delete("Category_Master", null, null);
        ContentValues values = new ContentValues();
        List<CategoryMaster> data = CategoryMaster.getCategoryMaster();
        try {
            if (data.size() == 0) {
                return false;
            }
            for (int i = 0; i < data.size(); i++) {
                values.put("Category", data.get(i).getCategory());
                values.put("Category_Id", data.get(i).getCategoryId());
                values.put("Category_Sequence", data.get(i).getCategorySequence());
                long id = db.insert("Category_Master", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertMappingCategoryChecklistdata(MappingCategoryChecklistGetterSetter infotype) {
        db.delete("Mapping_Category_Checklist", null, null);
        ContentValues values = new ContentValues();
        List<MappingCategoryChecklist> data = infotype.getMappingCategoryChecklist();
        try {
            if (data.size() == 0) {
                return false;
            }
            for (int i = 0; i < data.size(); i++) {
                values.put("Category_Id", data.get(i).getCategoryId());
                values.put("Checklist_Id", data.get(i).getChecklistId());

                long id = db.insert("Mapping_Category_Checklist", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertWindowMasterkData(WindowMasterGetterSetter BrandMaster) {
        db.delete("Window_Master", null, null);
        ContentValues values = new ContentValues();
        List<WindowMaster> data = BrandMaster.getWindowMaster();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {

                values.put("Window_Id", data.get(i).getWindowId());
                values.put("Window", data.get(i).getWindow());
                values.put("Window_Image", data.get(i).getWindowImage());

                long id = db.insert("Window_Master", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertWindowChecklistData(WindowChecklistGetterSetter BrandMaster) {
        db.delete("Window_Checklist", null, null);
        ContentValues values = new ContentValues();
        List<WindowChecklist> data = BrandMaster.getWindowChecklist();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {

                values.put("Checklist_Id", data.get(i).getChecklistId());
                values.put("Checklist", data.get(i).getChecklist());

                long id = db.insert("Window_Checklist", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertmappingInitiativedata(MappingInitiativeGetterSetter infotype) {
        // db.delete("Mapping_Visibility_Initiatives", null, null);
        db.delete("Mapping_Visibility_Initiatives_New", null, null);

        ContentValues values = new ContentValues();
        List<MappingVisibilityInitiative> data = infotype.getMappingVisibilityInitiatives();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {
                values.put("State_Id", data.get(i).getStateId());
                values.put("Distributor_Id", data.get(i).getDistributorId());
                values.put("Store_Type_Id", data.get(i).getStoreTypeId());
                values.put("Brand_id", data.get(i).getBrandId());
                values.put("Window_Id", data.get(i).getWindowId());
                values.put("Classification_Id", data.get(i).getClassificationId());

                values.put("Store_Category_Id", data.get(i).getStoreCategoryId());

                long id = db.insert("Mapping_Visibility_Initiatives_New", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertwindowChecklistAnsdata(WindowCheckAnswerGetterSetter infotype) {
        db.delete("Window_Checklist_Answer", null, null);
        ContentValues values = new ContentValues();
        List<WindowChecklistAnswer> data = infotype.getWindowChecklistAnswer();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {
                values.put("Answer_Id", data.get(i).getAnswerId());
                values.put("Answer", data.get(i).getAnswer());
                values.put("Checklist_Id", data.get(i).getChecklistId());
                long id = db.insert("Window_Checklist_Answer", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertmappingwindowChecklistdata(MappingWindChecklistGetterSetter infotype) {
        db.delete("Mapping_Window_Checklist", null, null);
        ContentValues values = new ContentValues();
        List<MappingWindowChecklist> data = infotype.getMappingWindowChecklist();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {
                values.put("Window_Id", data.get(i).getWindowId());
                values.put("Checklist_Id", data.get(i).getChecklistId());
                long id = db.insert("Mapping_Window_Checklist", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertMappingCategoryDressingData(MappingCategoryDressingGetterSetter infotype) {
        db.delete("Mapping_Category_Dressing", null, null);
        ContentValues values = new ContentValues();
        List<MappingCategoryDressing> data = infotype.getMappingCategoryDressing();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {
                values.put("State_Id", data.get(i).getStateId());
                values.put("Distributor_Id", data.get(i).getDistributorId());
                values.put("Store_Type_Id", data.get(i).getStoreTypeId());
                values.put("Category_Id", data.get(i).getCategoryId());
                values.put("Category_Planogram_Imageurl", data.get(i).getCategoryPlanogramImageurl());
                long id = db.insert("Mapping_Category_Dressing", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertNonWindowReasonData(NonWindowReasonGetterSetter infotype) {
        db.delete("Non_Window_Reason", null, null);
        ContentValues values = new ContentValues();
        List<NonWindowReason> data = infotype.getNonWindowReason();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {
                values.put("WReason_Id", data.get(i).getWReasonId());
                values.put("WReason", data.get(i).getWReason());
                long id = db.insert("Non_Window_Reason", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean isCoverageDataFilled(String visit_date) {
        boolean filled = false;
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT * FROM COVERAGE_DATA " + "where " + CommonString.KEY_VISIT_DATE + "<>'" + visit_date + "'", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                int icount = dbcursor.getCount();
                dbcursor.close();
                if (icount > 0) {
                    filled = true;
                } else {
                    filled = false;
                }

            }

        } catch (Exception e) {
            Log.d("Exception when fetching Records!!!!!!!!!!!!!!!!!!!!!",
                    e.toString());
            return filled;
        }

        return filled;
    }

    public void deletePreviousUploadedData(String visit_date) {
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * from COVERAGE_DATA where VISIT_DATE < '" + visit_date + "'", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                int icount = dbcursor.getCount();
                dbcursor.close();
                if (icount > 0) {
                    db.delete(CommonString.TABLE_COVERAGE_DATA, null, null);
                    db.delete(CommonString.TABLE_STORE_GEOTAGGING, null, null);
                    db.delete(CommonString.TABLE_WINDOWS_DATA, null, null);
                    db.delete(CommonString.TABLE_INSERT_CHECKLIST_DATA, null, null);
                    db.delete(CommonString.TABLE_CATEGORY_DRESSING_DATA, null, null);
                    db.delete(CommonString.TABLE_INSERT_CATEGORY_DRESSING_CHECKLIST_DATA, null, null);
                    db.delete(CommonString.TABLE_STORE_PROFILE_DATA, null, null);


                }
                dbcursor.close();
            }

        } catch (Exception e) {
            Log.d("Exception when fetching Coverage Data!!!!!!!!!!!!!!!!!!!!!", e.toString());
        }
    }

    public void deletePreviousJouneyPlanDBSRData(String visit_date) {
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * from Journey_Plan_DBSR_Saved where Visit_Date <> '" + visit_date + "'", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                int icount = dbcursor.getCount();
                dbcursor.close();
                if (icount > 0) {
                    db.delete(CommonString.TABLE_Journey_Plan_DBSR_Saved, null, null);
                }
                dbcursor.close();
            }

        } catch (Exception e) {
            Log.d("Exception when fetching Coverage Data!!!!!!!!!!!!!!!!!!!!!", e.toString());
        }

    }

    public ArrayList<CoverageBean> getcoverageDataPrevious(String visitdate) {
        ArrayList<CoverageBean> list = new ArrayList<CoverageBean>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * from " +
                    CommonString.TABLE_COVERAGE_DATA + " where " + CommonString.KEY_VISIT_DATE + "<>'" + visitdate + "'", null);

            if (dbcursor != null) {

                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    CoverageBean sb = new CoverageBean();
                    sb.setStoreId(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_ID)));
                    sb.setUserId(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_USER_ID)));
                    sb.setVisitDate(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_VISIT_DATE)));
                    sb.setLatitude(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LATITUDE)));
                    sb.setLongitude(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LONGITUDE)));
                    sb.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IMAGE)));
                    sb.setReason(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON)));
                    sb.setReasonid(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON_ID)));
                    sb.setMID(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_ID))));
                    sb.setCkeckout_image(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_COVERAGE_REMARK)));

                    sb.setRemark(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_COVERAGE_REMARK)));
                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exception when fetching Coverage Data!!!!!!!!!!!!!!!!!!!!!",
                    e.toString());

        }

        return list;

    }

    public JourneyPlan getSpecificStoreDataPrevious(String date, String store_id) {
        JourneyPlan sb = new JourneyPlan();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT * from Journey_Plan  " +
                    "where Visit_Date <> '" + date + "' AND Store_Id='" + store_id + "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    sb.setStoreId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Id"))));
                    sb.setVisitDate((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Visit_Date"))));
                    sb.setStoreName(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Name")));
                    sb.setAddress1(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address1")));
                    sb.setAddress2((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address2"))));
                    sb.setLandmark(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Landmark")));
                    sb.setPincode(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Pincode")));
                    sb.setContactPerson(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_Person")));
                    sb.setContactNo(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_No")));
                    sb.setCity(dbcursor.getString(dbcursor.getColumnIndexOrThrow("City")));
                    sb.setStoreType(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type")));
                    sb.setStoreCategory(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category")));
                    sb.setStateId(dbcursor.getString(dbcursor.getColumnIndexOrThrow("State_Id")));
                    sb.setStoreTypeId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type_Id"))));
                    sb.setStoreCategoryId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category_Id"))));
                    sb.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason_Id"))));
                    sb.setUploadStatus(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Upload_Status")));
                    sb.setGeoTag(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Geo_Tag")));
                    sb.setDistributorId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor_Id"))));
                    sb.setDistributorN(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor")));
                    sb.setClassification(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Classification")));
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return sb;
            }

        } catch (Exception e) {
            Log.d("Exception get JCP!", e.toString());
            return sb;
        }

        return sb;
    }

    public ArrayList<CoverageBean> getSpecificCoverageData(String visitdate, String store_cd) {
        ArrayList<CoverageBean> list = new ArrayList<CoverageBean>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * from " + CommonString.TABLE_COVERAGE_DATA + " where " + CommonString.KEY_VISIT_DATE + "='" + visitdate + "' AND " +
                    CommonString.KEY_STORE_ID + "='" + store_cd + "'", null);

            if (dbcursor != null) {

                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    CoverageBean sb = new CoverageBean();
                    sb.setStoreId(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_ID)));
                    sb.setUserId(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_USER_ID)));
                    sb.setVisitDate(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_VISIT_DATE)));
                    sb.setLatitude(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LATITUDE)));
                    sb.setLongitude(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LONGITUDE)));
                    sb.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IMAGE)));
                    sb.setReason(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON)));
                    sb.setReasonid(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON_ID)));
                    sb.setMID(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_ID))));
                    sb.setCkeckout_image(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_COVERAGE_REMARK)));

                    sb.setRemark(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_COVERAGE_REMARK)));
                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exception when fetching Coverage Data!!!!!!!!!!!!!!!!!!!!!",
                    e.toString());

        }

        return list;

    }

    public long updateCoverageCheckoutIMG(String storeid, String visit_date, String checkout_img) {
        long l = 0;
        try {
            ContentValues values = new ContentValues();
            values.put(CommonString.KEY_CHECKOUT_IMAGE, checkout_img);
            l = db.update("COVERAGE_DATA", values, " STORE_ID ='" + storeid + "' AND VISIT_DATE ='" + visit_date + "'", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    public long updateJaurneyPlanSpecificStoreStatus(String storeid, String visit_date, String status) {
        long l = 0;
        try {
            ContentValues values = new ContentValues();
            values.put("Upload_Status", status);
            l = db.update("Journey_Plan", values, " Store_Id ='" + storeid + "' AND Visit_Date ='" + visit_date + "'", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    public ArrayList<JourneyPlan> getSpecificStoreData(String store_cd) {
        ArrayList<JourneyPlan> list = new ArrayList<JourneyPlan>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * from Journey_Plan  " + "where Store_Id ='" + store_cd + "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    JourneyPlan sb = new JourneyPlan();
                    sb.setStoreId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Id"))));
                    sb.setVisitDate((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Visit_Date"))));
                    sb.setStoreName(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Name")));
                    sb.setAddress1(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address1")));
                    sb.setAddress2((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address2"))));
                    sb.setLandmark(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Landmark")));
                    sb.setPincode(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Pincode")));
                    sb.setContactPerson(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_Person")));
                    sb.setContactNo(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_No")));
                    sb.setCity(dbcursor.getString(dbcursor.getColumnIndexOrThrow("City")));
                    sb.setStoreType(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type")));
                    sb.setStoreCategory(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category")));
                    sb.setStateId(dbcursor.getString(dbcursor.getColumnIndexOrThrow("State_Id")));
                    sb.setStoreTypeId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type_Id"))));
                    sb.setStoreCategoryId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category_Id"))));
                    sb.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason_Id"))));
                    sb.setUploadStatus(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Upload_Status")));
                    sb.setGeoTag(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Geo_Tag")));
                    sb.setDistributorId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor_Id"))));
                    sb.setDistributorN(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor")));
                    sb.setStore_Code(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Code")));

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception get JCP!", e.toString());
            return list;
        }


        return list;
    }

    public ArrayList<JourneyPlan> getSpecificStore_DBSRData(String store_cd) {
        ArrayList<JourneyPlan> list = new ArrayList<JourneyPlan>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * from Journey_Plan_DBSR  " + "where Store_Id ='" + store_cd + "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    JourneyPlan sb = new JourneyPlan();
                    sb.setStoreId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Id"))));
                    sb.setVisitDate((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Visit_Date"))));
                    sb.setStoreName(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Name")));
                    sb.setAddress1(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address1")));
                    sb.setAddress2((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address2"))));
                    sb.setLandmark(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Landmark")));
                    sb.setPincode(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Pincode")));
                    sb.setContactPerson(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_Person")));
                    sb.setContactNo(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_No")));
                    sb.setCity(dbcursor.getString(dbcursor.getColumnIndexOrThrow("City")));
                    sb.setStoreType(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type")));
                    sb.setStoreCategory(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category")));
                    sb.setStateId(dbcursor.getString(dbcursor.getColumnIndexOrThrow("State_Id")));
                    sb.setStoreTypeId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type_Id"))));
                    sb.setStoreCategoryId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category_Id"))));
                    sb.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason_Id"))));
                    sb.setUploadStatus(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Upload_Status")));
                    sb.setGeoTag(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Geo_Tag")));
                    sb.setDistributorId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor_Id"))));
                    sb.setDistributorN(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor")));

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception get JCP!", e.toString());
            return list;
        }


        return list;
    }

    public ArrayList<JourneyPlan> getSpecificStore_DBSRSavedData(String store_cd) {
        ArrayList<JourneyPlan> list = new ArrayList<JourneyPlan>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * from Journey_Plan_DBSR_Saved  " + "where Store_Id ='" + store_cd + "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    JourneyPlan sb = new JourneyPlan();
                    sb.setStoreId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Id"))));
                    sb.setVisitDate((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Visit_Date"))));
                    sb.setStoreName(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Name")));
                    sb.setAddress1(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address1")));
                    sb.setAddress2((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address2"))));
                    sb.setLandmark(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Landmark")));
                    sb.setPincode(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Pincode")));
                    sb.setContactPerson(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_Person")));
                    sb.setContactNo(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_No")));
                    sb.setCity(dbcursor.getString(dbcursor.getColumnIndexOrThrow("City")));
                    sb.setStoreType(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type")));
                    sb.setStoreCategory(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category")));
                    sb.setStateId(dbcursor.getString(dbcursor.getColumnIndexOrThrow("State_Id")));
                    sb.setStoreTypeId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type_Id"))));
                    sb.setStoreCategoryId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category_Id"))));
                    sb.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason_Id"))));
                    sb.setUploadStatus(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Upload_Status")));
                    sb.setGeoTag(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Geo_Tag")));
                    sb.setDistributorId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor_Id"))));
                    sb.setDistributorN(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor")));

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception get JCP!", e.toString());
            return list;
        }


        return list;
    }


    public ArrayList<NonWorkingReason> getNonWorkingEntryAllowData() {

        ArrayList<NonWorkingReason> list = new ArrayList<NonWorkingReason>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT * FROM Non_Working_Reason WHERE Entry_Allow=1", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    NonWorkingReason sb = new NonWorkingReason();

                    sb.setReasonId(Integer.valueOf(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason_Id"))));
                    sb.setReason(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason")));
                    sb.setEntryAllow("1".equalsIgnoreCase(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Entry_Allow"))));
                    sb.setImageAllow("1".equalsIgnoreCase(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Image_Allow"))));
                    sb.setGPSMandatory("1".equalsIgnoreCase(dbcursor.getString(dbcursor.getColumnIndexOrThrow("GPS_Mandatory"))));

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            return list;
        }
        return list;
    }

    public ArrayList<NonWorkingReason> getNonWorkingData() {
        ArrayList<NonWorkingReason> list = new ArrayList<NonWorkingReason>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT * FROM Non_Working_Reason", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    NonWorkingReason sb = new NonWorkingReason();

                    sb.setReasonId(Integer.valueOf(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason_Id"))));
                    sb.setReason(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason")));
                    sb.setEntryAllow("1".equalsIgnoreCase(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Entry_Allow"))));
                    sb.setImageAllow("1".equalsIgnoreCase(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Image_Allow"))));
                    sb.setGPSMandatory("1".equalsIgnoreCase(dbcursor.getString(dbcursor.getColumnIndexOrThrow("GPS_Mandatory"))));

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            return list;
        }
        return list;
    }


    public ArrayList<GeotaggingBeans> getinsertGeotaggingData(String storeid, String status) {
        ArrayList<GeotaggingBeans> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("Select * from " + CommonString.TABLE_STORE_GEOTAGGING + "" +
                    " where " + CommonString.KEY_STORE_ID + " ='" + storeid + "' and " + CommonString.KEY_STATUS + " = '" + status + "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    GeotaggingBeans geoTag = new GeotaggingBeans();
                    geoTag.setStoreid(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_ID)));
                    geoTag.setLatitude(Double.parseDouble(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LATITUDE))));
                    geoTag.setLongitude(Double.parseDouble(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LONGITUDE))));
                    geoTag.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow("FRONT_IMAGE")));
                    list.add(geoTag);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception Brands",
                    e.toString());
            return list;
        }
        return list;

    }

    public void deleteSpecificStoreData(String storeid) {
        db.delete(CommonString.TABLE_COVERAGE_DATA, CommonString.KEY_STORE_ID + "='" + storeid + "'", null);
        db.delete(CommonString.TABLE_STORE_GEOTAGGING, CommonString.KEY_STORE_ID + "='" + storeid + "'", null);

    }

    public ArrayList<JourneyPlan> getStoreData(String date) {
        ArrayList<JourneyPlan> list = new ArrayList<JourneyPlan>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * FROM Journey_Plan  " + "WHERE Visit_Date ='" + date + "' ORDER BY Store_Name", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    JourneyPlan sb = new JourneyPlan();
                    sb.setStoreId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Id"))));
                    sb.setVisitDate((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Visit_Date"))));
                    sb.setStoreName(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Name")));
                    sb.setAddress1(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address1")));
                    sb.setAddress2((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address2"))));
                    sb.setLandmark(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Landmark")));
                    sb.setPincode(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Pincode")));
                    sb.setContactPerson(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_Person")));
                    sb.setContactNo(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_No")));
                    sb.setCity(dbcursor.getString(dbcursor.getColumnIndexOrThrow("City")));
                    sb.setStoreType(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type")));
                    sb.setStoreCategory(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category")));
                    sb.setStateId(dbcursor.getString(dbcursor.getColumnIndexOrThrow("State_Id")));
                    sb.setStoreTypeId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type_Id"))));
                    sb.setStoreCategoryId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category_Id"))));
                    sb.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason_Id"))));
                    sb.setUploadStatus(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Upload_Status")));
                    sb.setGeoTag(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Geo_Tag")));
                    sb.setDistributorId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor_Id"))));
                    sb.setDistributorN(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor")));

                    sb.setGeoFencing(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("GeoFencing"))));
                    sb.setLatitude(dbcursor.getDouble(dbcursor.getColumnIndexOrThrow("Latitude")));
                    sb.setLongitude(dbcursor.getDouble(dbcursor.getColumnIndexOrThrow("Longitude")));
                    sb.setStore_Code(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Code")));
                    sb.setClassificationId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Classification_Id"))));
                    sb.setClassification(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Classification")));
                    if (sb.getStoreTypeId() == 1) {
                        sb.setColourCode(R.color.peachpuff);
                    } else if (sb.getStoreTypeId() == 2) {
                        sb.setColourCode(R.color.lightskyblue);
                    } else if (sb.getStoreTypeId() == 3) {
                        sb.setColourCode(R.color.gainsboro);
                    }

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception get JCP!", e.toString());
            return list;
        }


        return list;
    }

    public ArrayList<JourneyPlan> getStoreData_DBSR(String date) {
        ArrayList<JourneyPlan> list = new ArrayList<JourneyPlan>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * FROM Journey_Plan_DBSR  " + "WHERE Visit_Date ='" + date + "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    JourneyPlan sb = new JourneyPlan();
                    sb.setStoreId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Id"))));
                    sb.setVisitDate((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Visit_Date"))));
                    sb.setStoreName(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Name")));
                    sb.setAddress1(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address1")));
                    sb.setAddress2((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address2"))));
                    sb.setLandmark(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Landmark")));
                    sb.setPincode(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Pincode")));
                    sb.setContactPerson(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_Person")));
                    sb.setContactNo(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_No")));
                    sb.setCity(dbcursor.getString(dbcursor.getColumnIndexOrThrow("City")));
                    sb.setStoreType(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type")));
                    sb.setStoreCategory(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category")));
                    sb.setStateId(dbcursor.getString(dbcursor.getColumnIndexOrThrow("State_Id")));
                    sb.setStoreTypeId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type_Id"))));
                    sb.setStoreCategoryId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category_Id"))));
                    sb.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason_Id"))));
                    sb.setUploadStatus(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Upload_Status")));
                    sb.setGeoTag(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Geo_Tag")));
                    sb.setDistributorId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor_Id"))));
                    sb.setDistributorN(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor")));
                    sb.setWeeklyUpload(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Weekly_Upload")));
                    sb.setClassificationId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Classification_Id"))));
                    if (sb.getStoreTypeId() == 1) {
                        sb.setColourCode(R.color.peachpuff);
                    } else if (sb.getStoreTypeId() == 2) {
                        sb.setColourCode(R.color.lightskyblue);
                    } else if (sb.getStoreTypeId() == 3) {
                        sb.setColourCode(R.color.gainsboro);
                    }
                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception get Journey_Plan_DBSR!", e.toString());
            return list;
        }
        return list;
    }

    public ArrayList<JourneyPlan> getStoreData_DBSR_Saved(String date) {
        ArrayList<JourneyPlan> list = new ArrayList<JourneyPlan>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT  * FROM Journey_Plan_DBSR_Saved  " + "WHERE Visit_Date ='" + date + "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    JourneyPlan sb = new JourneyPlan();
                    sb.setStoreId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Id"))));
                    sb.setVisitDate((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Visit_Date"))));
                    sb.setStoreName(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Name")));
                    sb.setAddress1(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address1")));
                    sb.setAddress2((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Address2"))));
                    sb.setLandmark(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Landmark")));
                    sb.setPincode(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Pincode")));
                    sb.setContactPerson(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_Person")));
                    sb.setContactNo(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Contact_No")));
                    sb.setCity(dbcursor.getString(dbcursor.getColumnIndexOrThrow("City")));
                    sb.setStoreType(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type")));
                    sb.setStoreCategory(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category")));
                    sb.setStateId(dbcursor.getString(dbcursor.getColumnIndexOrThrow("State_Id")));
                    sb.setStoreTypeId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type_Id"))));
                    sb.setStoreCategoryId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Category_Id"))));
                    sb.setReasonId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason_Id"))));
                    sb.setUploadStatus(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Upload_Status")));
                    sb.setGeoTag(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Geo_Tag")));
                    sb.setDistributorId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor_Id"))));
                    sb.setDistributorN(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Distributor")));
                    sb.setClassificationId(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Classification_Id"))));
                    if (sb.getStoreTypeId() == 1) {
                        sb.setColourCode(R.color.peachpuff);
                    } else if (sb.getStoreTypeId() == 2) {
                        sb.setColourCode(R.color.lightskyblue);
                    } else if (sb.getStoreTypeId() == 3) {
                        sb.setColourCode(R.color.gainsboro);
                    }
                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception get Journey_Plan_DBSR!", e.toString());
            return list;
        }
        return list;
    }


    public ArrayList<CoverageBean> getCoverageData(String visitdate) {
        ArrayList<CoverageBean> list = new ArrayList<CoverageBean>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT * FROM " + CommonString.TABLE_COVERAGE_DATA + " WHERE " + CommonString.KEY_VISIT_DATE + "='" + visitdate + "'", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    CoverageBean sb = new CoverageBean();
                    sb.setStoreId(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_ID)));
                    sb.setUserId(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_USER_ID)));
                    sb.setVisitDate(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_VISIT_DATE)));
                    sb.setLatitude(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LATITUDE)));
                    sb.setLongitude(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LONGITUDE)));
                    sb.setImage(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IMAGE)));
                    sb.setReason(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON)));
                    sb.setReasonid(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON_ID)));
                    sb.setMID(Integer.parseInt(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_ID))));
                    sb.setCkeckout_image(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CHECKOUT_IMAGE)));
                    sb.setRemark(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_COVERAGE_REMARK)));
                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exception when fetching Coverage Data!!!!!!!!!!!!!!!!!!!!!",
                    e.toString());

        }

        return list;

    }


    public boolean isWindowDataFilled(int storeId, int window_cd) {
        boolean filled = false;
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT * FROM " + CommonString.TABLE_WINDOWS_DATA + " WHERE STORE_ID= '" + storeId + "' AND WINDOW_CD ='" + window_cd + "'", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                int icount = dbcursor.getInt(0);
                dbcursor.close();
                if (icount > 0) {
                    filled = true;
                } else {
                    filled = false;
                }
            }
        } catch (Exception e) {
            Log.d("Exception when fetching Records!!!!!!!!!!!!!!!!!!!!!", e.toString());
            return filled;
        }
        return filled;
    }


    public ArrayList<StoreTypeMaster> geVISITED_WITH_MASTERData() {
        ArrayList<StoreTypeMaster> list = new ArrayList<>();
        Cursor dbcursor = null;

        try {

            dbcursor = db.rawQuery("SELECT * FROM Store_Type_Master ", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    StoreTypeMaster sb = new StoreTypeMaster();

                    sb.setStoreType(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Store_Type")));
                    sb.setStoreTypeId(dbcursor.getInt(dbcursor.getColumnIndexOrThrow("Store_Type_Id")));
                    if (dbcursor.getString(dbcursor.getColumnIndexOrThrow("Show_Reference_Image")).equals(1)) {
                        sb.setShowReferenceImage(true);
                    } else {
                        sb.setShowReferenceImage(false);
                    }

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            return list;
        }

        return list;
    }

    public long insertStoreProfileData(JourneyPlan JCP, StoreProfileGetterSetter storeProfile) {
        db.delete(CommonString.TABLE_STORE_PROFILE_DATA, " STORE_ID" + "='" + JCP.getStateId() + "' AND VISIT_DATE='" + JCP.getVisitDate() + "'", null);
        ContentValues values = new ContentValues();
        long l = 0;
        try {
            db.beginTransaction();
            if (!JCP.getStoreName().isEmpty()) {
                values.put(CommonString.KEY_STORE_ID, JCP.getStoreId());
                values.put(CommonString.KEY_VISIT_DATE, JCP.getVisitDate());
                values.put(CommonString.KEY_STORE_TYPE, storeProfile.getStore_type());
                values.put(CommonString.KEY_STORE_TYPE_CD, storeProfile.getStore_type_cd());
                values.put(CommonString.KEY_STORE_NAME, JCP.getStoreName());
                values.put(CommonString.KEY_STORE_ADDRESS, JCP.getAddress1());
                values.put(CommonString.KEY_STORE_CITY, JCP.getCity());


                l = db.insert(CommonString.TABLE_STORE_PROFILE_DATA, null, values);
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        } catch (Exception ex) {
            Log.d("Database Exception", " while Insert Header Data " + ex.toString());
        }
        return l;
    }


    public StoreProfileGetterSetter getStoreProfileData(String store_cd, String visit_date) {
        StoreProfileGetterSetter sb = new StoreProfileGetterSetter();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("SELECT * FROM STORE_PROFILE_DATA WHERE STORE_ID ='" + store_cd + "' AND VISIT_DATE='" + visit_date + "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    sb.setStore_type_cd((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_TYPE_CD))));
                    sb.setStore_type(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_TYPE)));
                    sb.setStoreCd(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_ID)));
                    sb.setStore_visit_date(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_VISIT_DATE)));
                    sb.setStore_name(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_NAME)));
                    sb.setStore_addres(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_ADDRESS)));
                    sb.setStore_city(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_CITY)));

                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return sb;
            }

        } catch (Exception e) {
            Log.d("Exception get JCP!", e.toString());
            return sb;
        }

        return sb;
    }

    //-----------------------------------------------------------------
    public boolean insertMenuMasterData(MenuMasterGetterSetter menuMasterGetterSetter) {
        db.delete("Menu_Master", null, null);
        ContentValues values = new ContentValues();
        List<MenuMaster> data = menuMasterGetterSetter.getMenuMaster();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {
                values.put("Menu_Id", data.get(i).getMenuId());
                values.put("Menu_Name", data.get(i).getMenuName());
                values.put("Normal_Icon", data.get(i).getNormalIcon());
                values.put("Tick_Icon", data.get(i).getTickIcon());
                values.put("Grey_Icon", data.get(i).getGreyIcon());
                values.put("Menu_Path", data.get(i).getMenuPath());
                values.put("Menu_Sequence", data.get(i).getMenuSequence());
                long id = db.insert("Menu_Master", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    //Insert MenuMapping
    public boolean insertMappingMenuData(MappingMenuGetterSetter mappingMenuGetterSetter) {
        db.delete("Mapping_Menu", null, null);
        ContentValues values = new ContentValues();
        List<MappingMenu> data = mappingMenuGetterSetter.getMappingMenu();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {
                values.put("Store_Type_Id", data.get(i).getStoreTypeId());
                values.put("Menu_Id", data.get(i).getMenuId());

                long id = db.insert("Mapping_Menu", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    //get Menu List data for Entry Menu
    public ArrayList<MenuMaster> getMenuData(int Store_Type_Id) {
        Log.d("Fetchecklidata->Start<-", "-");
        ArrayList<MenuMaster> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {

            dbcursor = db.rawQuery("SELECT M.Menu_Id, M.Menu_Name, M.Normal_Icon, M.Tick_Icon, M.Grey_Icon, M.Menu_Path FROM Menu_Master M INNER JOIN Mapping_Menu MM ON M.Menu_Id = MM.Menu_Id WHERE MM.Store_Type_Id=" + Store_Type_Id + " ORDER BY M.Menu_Sequence", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    MenuMaster ch = new MenuMaster();
                    ch.setMenuId(dbcursor.getInt(dbcursor.getColumnIndexOrThrow("Menu_Id")));
                    ch.setMenuName(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Menu_Name")));
                    ch.setNormalIcon(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Normal_Icon")));
                    ch.setTickIcon(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Tick_Icon")));
                    ch.setGreyIcon(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Grey_Icon")));
                    ch.setMenuPath(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Menu_Path")));
                    list.add(ch);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exc get menu list!", e.toString());
            return list;
        }
        Log.d("Fetching check->Stop<", "-");
        return list;
    }


    //usk
    public boolean insertMappingPosmData(MappingPosmGetterSetter storeTypeMaster) {
        db.delete("Mapping_Posm", null, null);
        ContentValues values = new ContentValues();
        List<MappingPosm> data = storeTypeMaster.getMappingPosm();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {

                values.put("Posm_Id", data.get(i).getPosmId());
                values.put("Store_Type_Id", data.get(i).getStoreTypeId());
                values.put("State_Id", data.get(i).getStateId());
                values.put("Store_Category_Id", data.get(i).getStoreCategoryId());

                long id = db.insert("Mapping_Posm", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertPosmMasterData(PosmMasterGetterSetter storeTypeMaster) {
        db.delete("Posm_Master", null, null);
        ContentValues values = new ContentValues();
        List<PosmMaster> data = storeTypeMaster.getPosmMaster();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {

                values.put("Posm", data.get(i).getPosm());
                values.put("Posm_Id", data.get(i).getPosmId());
                values.put("Posm_Type", data.get(i).getPosmType());
                values.put("Posm_Type_Id", data.get(i).getPosmTypeId());

                long id = db.insert("Posm_Master", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertMapppingVisicoolerData(MappingVisicoolerGetterSetter storeTypeMaster) {
        db.delete("Mapping_Visicooler", null, null);
        ContentValues values = new ContentValues();
        List<MappingVisicooler> data = storeTypeMaster.getMappingVisicooler();
        try {
            if (data.size() == 0) {
                return false;
            }

            for (int i = 0; i < data.size(); i++) {

                values.put("Store_id", data.get(i).getStoreId());

                long id = db.insert("Mapping_Visicooler", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }


    public boolean insertNonPosmReseonData(NonExecutionReasonGetterSetter storeTypeMaster) {
        db.delete("Non_Execution_Reason", null, null);
        ContentValues values = new ContentValues();
        List<NonExecutionReason> data = storeTypeMaster.getNonExecutionReason();
        try {
            if (data.size() == 0) {
                return false;
            }
            for (int i = 0; i < data.size(); i++) {
                values.put("Menu_Id", data.get(i).getMenuId());
                values.put("Reason", data.get(i).getReason());
                values.put("Reason_Id", data.get(i).getReasonId());

                long id = db.insert("Non_Execution_Reason", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertMappingWindowData(MappingWindowGetterSetter storeTypeMaster) {
        db.delete("Mapping_Window", null, null);
        ContentValues values = new ContentValues();
        List<MappingWindow> data = storeTypeMaster.getMappingWindow();
        try {
            if (data.size() == 0) {
                return false;
            }
            for (int i = 0; i < data.size(); i++) {
                values.put("Brand_Id", data.get(i).getBrandId());
                values.put("State_Id", data.get(i).getStateId());
                values.put("Store_Type_Id", data.get(i).getStoreTypeId());
                values.put("Store_Category_Id", data.get(i).getStoreCategoryId());
                values.put("Window_Id", data.get(i).getWindowId());

                long id = db.insert("Mapping_Window", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }


    public boolean insertMappingCtuData(MappingCTUGetterSetter storeTypeMaster) {
        db.delete("Mapping_CTU", null, null);
        ContentValues values = new ContentValues();
        List<MappingCTU> data = storeTypeMaster.getMappingCTU();
        try {
            if (data.size() == 0) {
                return false;
            }
            for (int i = 0; i < data.size(); i++) {
                values.put("Brand_Id", data.get(i).getBrandId());
                values.put("Store_Id", data.get(i).getStoreId());

                long id = db.insert("Mapping_CTU", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertMappingFocusSkuData(MappingFocusSkuGetterSetter storeTypeMaster) {
        db.delete("Mapping_Focus_Sku", null, null);
        ContentValues values = new ContentValues();
        List<MappingFocusSku> data = storeTypeMaster.getMappingFocusSku();
        try {
            if (data.size() == 0) {
                return false;
            }
            for (int i = 0; i < data.size(); i++) {
                values.put("Sku_Id", data.get(i).getSkuId());
                values.put("State_Id", data.get(i).getStateId());
                values.put("Store_Category_Id", data.get(i).getStoreCategoryId());
                values.put("Store_Type_Id", data.get(i).getStoreTypeId());

                long id = db.insert("Mapping_Focus_Sku", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public boolean insertMappingWindowData(MappingMenuChecklistGetterSetter storeTypeMaster) {
        db.delete("Mapping_Menu_Checklist", null, null);
        ContentValues values = new ContentValues();
        List<MappingMenuChecklist> data = storeTypeMaster.getMappingMenuChecklist();
        try {
            if (data.size() == 0) {
                return false;
            }
            for (int i = 0; i < data.size(); i++) {
                values.put("Menu_Id", data.get(i).getMenuId());
                values.put("Checklist_id", data.get(i).getChecklistId());

                long id = db.insert("Mapping_Menu_Checklist", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }


    public boolean insertChecklistAnswerData(ChecklistAnswerGetterSetter storeTypeMaster) {
        db.delete("Checklist_Answer", null, null);
        ContentValues values = new ContentValues();
        List<ChecklistAnswer> data = storeTypeMaster.getChecklistAnswer();
        try {
            if (data.size() == 0) {
                return false;
            }
            for (int i = 0; i < data.size(); i++) {
                values.put("Answer", data.get(i).getAnswer());
                values.put("Answer_Id", data.get(i).getAnswerId());
                values.put("Checklist_Id", data.get(i).getChecklistId());


                long id = db.insert("Checklist_Answer", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }


    public boolean insertChecklistMasterData(ChecklistMasterGetterSetter storeTypeMaster) {
        db.delete("Checklist_Master", null, null);
        ContentValues values = new ContentValues();
        List<ChecklistMaster> data = storeTypeMaster.getChecklistMaster();
        try {
            if (data.size() == 0) {
                return false;
            }
            for (int i = 0; i < data.size(); i++) {
                values.put("Checklist_Id", data.get(i).getChecklistId());
                values.put("Checklist", data.get(i).getChecklist());

                long id = db.insert("Checklist_Master", null, values);
                if (id == -1) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public ArrayList<PosmMaster> getastockAnswerData() {
        ArrayList<PosmMaster> list = new ArrayList<>();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("Select -1 as Answer_Id, 'Select' as Answer union Select 1 as Answer_Id, 'Yes' as Answer union Select 0 as Answer_Id, 'No' as Answer", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    PosmMaster df = new PosmMaster();
                    df.setAnswerId(Integer.valueOf(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Answer_Id"))));
                    df.setAnswer(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Answer")));

                    list.add(df);
                    dbcursor.moveToNext();
                }

                dbcursor.close();
                return list;
            }
        } catch (Exception e) {

            return list;
        }

        return list;

    }


    public ArrayList<NonExecutionReason> getPOSMReason(Integer menu_id) {
        Log.d("Fetching Data", "------------------");
        Cursor dbcursor = null;
        ArrayList<NonExecutionReason> list = new ArrayList<>();
        NonExecutionReason reason1 = new NonExecutionReason();
        try {
            // reason1.setRemark(false);
            reason1.setReasonId(0);
            reason1.setReason("Select Reason");
            list.add(reason1);

            dbcursor = db.rawQuery("select * from Non_Execution_Reason where Menu_Id ='" + menu_id + "' ", null);
            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    NonExecutionReason reason = new NonExecutionReason();
                    reason.setReason(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason")));
                    reason.setReasonId(Integer.valueOf(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Reason_Id"))));
                    // reason.setRemark(Boolean.valueOf(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Remark"))));
                    list.add(reason);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception ", e.getMessage());
            return list;
        }
        return list;
    }

    public ArrayList<CommonChillerDataGetterSetter> getPOSMDeploymentSavedData(Integer storeId, String visit_date) {
        Log.d("Fetching Data", "------------------");
        Cursor dbcursor = null;
        ArrayList<CommonChillerDataGetterSetter> list = new ArrayList<>();
        try {
            dbcursor = db.rawQuery("SELECT  * from "
                    + CommonString.TABLE_POSM_DEPLOYMENT + " where "
                    + CommonString.KEY_STORE_ID + " = '" + storeId + "' and " + CommonString.KEY_VISIT_DATE + " =  '" + visit_date + "' ", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    CommonChillerDataGetterSetter psd = new CommonChillerDataGetterSetter();

                    psd.setStore_id(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_ID)));
                    psd.setVisit_date(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_VISIT_DATE)));
                    psd.setImg1(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IMAGE1)));
                    psd.setExist(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_EXIST)));
                    psd.setPosm(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_POSM)));
                    psd.setPosm_id(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_POSM_ID)));
                    psd.setReason(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON)));
                    psd.setReason_id(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON_ID)));

                    list.add(psd);
                    dbcursor.moveToNext();

                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception ", e.getMessage());
            return list;
        }
        return list;
    }

    public ArrayList<CommonChillerDataGetterSetter> getPOSMDeploymentData(JourneyPlan jcpGetset) {
        ArrayList<CommonChillerDataGetterSetter> list = new ArrayList<CommonChillerDataGetterSetter>();
        Cursor dbcursor = null;
        try {

            dbcursor = db.rawQuery(" select distinct PM.Posm,PM.Posm_Type_Id,MP.Posm_Id,MP.State_Id,MP.Store_Type_Id from Mapping_Posm MP " +
                    " inner join Posm_Master PM ON MP.Posm_Id = PM.Posm_Id  where MP.Store_Type_Id = '" + jcpGetset.getStoreTypeId() + "' " +
                    " and  MP.State_Id = '" + jcpGetset.getStateId() + "' and MP.Store_Category_Id = '" + jcpGetset.getStoreCategoryId() + "' ", null);
         /*   dbcursor = db.rawQuery( " select distinct PM.Posm,PM.Posm_Type_Id,MP.Posm_Id,MP.State_Id,MP.Store_Type_Id from Mapping_Posm MP " +
                    " inner join Posm_Master PM ON MP.Posm_Id = PM.Posm_Id  where MP.Store_Type_Id = '"+jcpGetset.getStoreTypeId()+"' " +
                    " and  MP.State_Id = '"+jcpGetset.getStateId()+"' ",null);*/

            if (dbcursor != null) {

                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    CommonChillerDataGetterSetter sb = new CommonChillerDataGetterSetter();
                    sb.setPosm_id(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Posm_Id")));
                    sb.setPosm((((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Posm"))))));
                    sb.setState_id(((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STATE_ID)))));
                    sb.setStore_type_id((((dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_TYPE_ID))))));
                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exception get JCP!", e.toString());
            return list;
        }
        return list;
    }


    public long insertPOSMDeploymentData(ArrayList<CommonChillerDataGetterSetter> deploymentData, JourneyPlan jcp) {

        db.delete(CommonString.TABLE_POSM_DEPLOYMENT, null, null);
        ContentValues values = new ContentValues();

        long id = 0;
        try {
            for (int i = 0; i < deploymentData.size(); i++) {
                values.put(CommonString.KEY_STORE_ID, jcp.getStoreId());
                values.put(CommonString.KEY_VISIT_DATE, jcp.getVisitDate());
                values.put(CommonString.KEY_EXIST, deploymentData.get(i).getExist());
                if (deploymentData.get(i).getExist().equalsIgnoreCase("1")) {
                    values.put(CommonString.KEY_IMAGE1, deploymentData.get(i).getImg1());
                    values.put(CommonString.KEY_REASON_ID, "");
                    values.put(CommonString.KEY_REASON, "");
                } else {
                    values.put(CommonString.KEY_IMAGE1, "");
                    values.put(CommonString.KEY_REASON_ID, deploymentData.get(i).getReason_id());
                    values.put(CommonString.KEY_REASON, deploymentData.get(i).getReason());
                }
                values.put(CommonString.KEY_POSM_ID, deploymentData.get(i).getPosm_id());
                values.put(CommonString.KEY_POSM, deploymentData.get(i).getPosm());

                id = db.insert(CommonString.TABLE_POSM_DEPLOYMENT, null, values);

            }

            if (id > 0) {
                return id;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            Log.d("Database Exception ", ex.toString());
            return 0;
        }
    }


    public long insertVisiCoolerData(JourneyPlan JCP, VisiColoersGetterSetter storeProfile) {
        db.delete(CommonString.TABLE_VISICOOLER, " STORE_ID" + "='" + JCP.getStateId() + "' AND VISIT_DATE='" + JCP.getVisitDate() + "'", null);
        ContentValues values = new ContentValues();
        long l = 0;
        try {
            db.beginTransaction();
            if (!JCP.getStoreName().isEmpty()) {
                values.put(CommonString.KEY_STORE_ID, JCP.getStoreId());
                values.put(CommonString.KEY_VISIT_DATE, JCP.getVisitDate());
                values.put(CommonString.KEY_PRESENT_EXIST, storeProfile.getPresent_name());
                values.put(CommonString.KEY_WORKING_EXIST, storeProfile.getWorking_name());
                values.put(CommonString.KEY_LOCATION_EXIST, storeProfile.getLocation());
                values.put(CommonString.KEY_PURITY_EXIST, storeProfile.getPurity_name());
                values.put(CommonString.KEY_PLANOGRAM_EXIST, storeProfile.getPlanogram_name());
                values.put(CommonString.KEY_IMAGE_CLOSEUP, storeProfile.getImage_close_up());
                values.put(CommonString.KEY_LONGSHOT, storeProfile.getImage_long_shot());

                l = db.insert(CommonString.TABLE_VISICOOLER, null, values);
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        } catch (Exception ex) {
            Log.d("Database Exception", " while Insert Header Data " + ex.toString());
        }
        return l;
    }

    public VisiColoersGetterSetter getVisicoolerData(JourneyPlan jcp) {
        Log.d("FetchinggetCityMasterDat", "------------------");
        VisiColoersGetterSetter sb = new VisiColoersGetterSetter();
        Cursor dbcursor = null;

        try {

            dbcursor = db.rawQuery("SELECT * FROM " + CommonString.TABLE_VISICOOLER + " WHERE " + CommonString.KEY_STORE_ID + " = " + jcp.getStoreId(), null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    sb.setPresent_name(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_PRESENT_EXIST)));
                    sb.setWorking_name(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_WORKING_EXIST)));
                    sb.setLocation(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LOCATION_EXIST)));
                    sb.setPurity_name(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_PURITY_EXIST)));
                    sb.setPlanogram_name(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_PLANOGRAM_EXIST)));
                    sb.setImage_close_up(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IMAGE_CLOSEUP)));
                    sb.setImage_long_shot(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LONGSHOT)));


                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return sb;
            }

        } catch (Exception e) {
            Log.d("Exception when fetching", e.toString());
            return sb;
        }

        Log.d("Fetching non working", "-------------------");
        return sb;
    }


    public ArrayList<FocusProductGetterSetter> getHeaderSalesData(String Region_Id, String Distributor_Id, String Category_Id) {
        Log.d("Fetching", "Storedata--------------->Start<------------");
        ArrayList<FocusProductGetterSetter> list = new ArrayList<FocusProductGetterSetter>();
        Cursor dbcursor = null;

        try {

            dbcursor = db.rawQuery("Select distinct br.Brand_Id, br.Brand from Mapping_Stock m inner join Sku_Master sk on m.Sku_Id = sk.Sku_Id " +
                    " inner join Brand_Master br on sk.Brand_Id = br.Brand_Id " +
                    " where m.Region_Id = '" + Region_Id + "' and m.Distributor_Id = '" + Distributor_Id + "' and br.Category_Id = '" + Category_Id + "'", null);


            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    FocusProductGetterSetter sb = new FocusProductGetterSetter();
                    sb.setBrand_id(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Brand_Id")));
                    sb.setBrand(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Brand")));

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exception", " when fetching Header!!!!!!!!!!! " + e.toString());
            return list;
        }
        Log.d("Fetching ", "Header stock---------------------->Stop<-----------");
        return list;
    }

    public ArrayList<FocusProductGetterSetter> getSalesStockInsertedData(String store_cd, String brand_id) {
        Log.d("Fetching", "Storedata--------------->Start<------------");
        ArrayList<FocusProductGetterSetter> list = new ArrayList<>();
        Cursor dbcursor = null;

        try {

            dbcursor = db.rawQuery("SELECT * FROM STORE_SALES_STOCK_DATA WHERE STORE_CD ='" + store_cd + "' AND BRAND_CD=" + brand_id + "", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    FocusProductGetterSetter sb = new FocusProductGetterSetter();
                    sb.setSku(dbcursor.getString(dbcursor.getColumnIndexOrThrow("SKU")));
                    sb.setSku_id(dbcursor.getString(dbcursor.getColumnIndexOrThrow("SKU_CD")));
                    sb.setStock(dbcursor.getString(dbcursor.getColumnIndexOrThrow("STOCK")));

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exception ", "when fetching opening stock!!!!!!!!!!!" + e.toString());
            return list;
        }

        Log.d("Fetching ", "opening stock---------------------->Stop<-----------");
        return list;
    }

    public ArrayList<FocusProductGetterSetter> getSalesStockchildData(String region_id, String destributor_id, String brand_id) {
        Log.d("Fetching", "Storedata--------------->Start<------------");
        ArrayList<FocusProductGetterSetter> list = new ArrayList<>();
        Cursor dbcursor = null;

        try {

            dbcursor = db.rawQuery("Select distinct sk.Sku_Id, sk.Sku from Mapping_Stock m inner join Sku_Master sk on m.Sku_Id = sk.Sku_Id " +
                    " inner join Brand_Master br on sk.Brand_Id = br.Brand_Id " +
                    " where m.Region_Id = '" + region_id + "' and m.Distributor_Id = '" + destributor_id + "' and br.Brand_Id = '" + brand_id + "'order by sk.Sku", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    FocusProductGetterSetter sb = new FocusProductGetterSetter();
                    sb.setSku_id(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Sku_Id")));
                    sb.setSku(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Sku")));

                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exception ", "when fetching opening stock!!!!!!!!!!!" + e.toString());
            return list;
        }

        Log.d("Fetching ", "opening stock---------------------->Stop<-----------");
        return list;
    }


    public void insertSalesStockData(JourneyPlan jcp,
                                     HashMap<FocusProductGetterSetter,
                                             List<FocusProductGetterSetter>> data, List<FocusProductGetterSetter> save_listDataHeader) {

        db.delete(CommonString.TABLE_INSERT_FOCUS_PRODUCT_STOCK_OPENINGHEADER_DATA, " STORE_CD='" + jcp.getStoreId() + "' AND CATEGORY_ID=" + jcp.getStoreCategoryId() + " AND VISIT_DATE=" + jcp.getVisitDate() + "", null);
        db.delete(CommonString.TABLE_STORE_FOCUS_PRODUCT_DATA, " STORE_CD='" + jcp.getStoreId() + "' AND CATEGORY_ID=" + jcp.getStoreCategoryId() + " AND VISIT_DATE=" + jcp.getVisitDate() + "", null);

        ContentValues values = new ContentValues();
        ContentValues values1 = new ContentValues();

        try {
            db.beginTransaction();
            for (int i = 0; i < save_listDataHeader.size(); i++) {
                values.put("STORE_CD", jcp.getStoreId());
                values.put("BRAND_CD", save_listDataHeader.get(i).getBrand_id());
                values.put("BRAND", save_listDataHeader.get(i).getBrand());
                values.put("CATEGORY_ID", "");
                long l = db.insert(CommonString.TABLE_INSERT_FOCUS_PRODUCT_STOCK_OPENINGHEADER_DATA, null, values);
                for (int j = 0; j < data.get(save_listDataHeader.get(i)).size(); j++) {
                    values1.put("Common_Id", (int) l);
                    values1.put("STORE_CD", jcp.getStateId());
                    values1.put("BRAND_CD", save_listDataHeader.get(i).getBrand_id());
                    values1.put("BRAND", save_listDataHeader.get(i).getBrand());
                    values1.put("CATEGORY_ID", "");
                    values1.put("SKU", data.get(save_listDataHeader.get(i)).get(j).getSku());
                    values1.put("SKU_CD", data.get(save_listDataHeader.get(i)).get(j).getSku_id());
                    if (!data.get(save_listDataHeader.get(i)).get(j).getStock().equals("")) {
                        values1.put("STOCK", Integer.parseInt(data.get(save_listDataHeader.get(i)).get(j).getStock()));
                    } else {
                        values1.put("STOCK", "0");
                    }
                    db.insert(CommonString.TABLE_STORE_FOCUS_PRODUCT_DATA, null, values1);
                }
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        } catch (Exception ex) {
            Log.d("Database Exception", " while Insert Posm Master Data " + ex.toString());
        }
    }

    public ArrayList<ChecklistAnswer> getVisicoolereason(Integer cheklist_id) {
        Log.d("Fetching Data", "------------------");
        Cursor dbcursor = null;
        ArrayList<ChecklistAnswer> list = new ArrayList<>();
        ChecklistAnswer reason1 = new ChecklistAnswer();
        try {

            reason1.setAnswerId(0);
            reason1.setAnswer("Select Reason");
            list.add(reason1);

           // dbcursor = db.rawQuery("select * from Checklist_Answer where checklist_Id = 1 ", null);
            dbcursor = db.rawQuery("select * from Checklist_Answer where checklist_Id ='" + cheklist_id + "' ", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    ChecklistAnswer reason = new ChecklistAnswer();
                    reason.setAnswer(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Answer")));
                    reason.setAnswerId(Integer.valueOf(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Answer_Id"))));
                    reason.setChecklistId(Integer.valueOf(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Checklist_Id"))));

                    list.add(reason);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception ", e.getMessage());
            return list;
        }
        return list;
    }


    public ArrayList<VisiColoersGetterSetter> getVisicoolerSavedData(Integer storeId, String visit_date) {
        Log.d("Fetching Data", "------------------");
        Cursor dbcursor = null;
        ArrayList<VisiColoersGetterSetter> list = new ArrayList<>();
        try {
            dbcursor = db.rawQuery("SELECT  * from "
                    + CommonString.TABLE_VISICOOLER_CHEKLIST + " where "
                    + CommonString.KEY_STORE_ID + " = '" + storeId + "' and " + CommonString.KEY_VISIT_DATE + " =  '" + visit_date + "' ", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    VisiColoersGetterSetter psd = new VisiColoersGetterSetter();
                    psd.setStore_id(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_STORE_ID)));
                    psd.setVisit_date(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_VISIT_DATE)));
                    psd.setCheklist_cd(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CHEKLIST_ID)));
                    psd.setCheklist(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_CHEKLIST)));
                    psd.setAnswer_cd(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_ANSWER_CD)));
                    psd.setAnswer(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_ANSWER)));

                    list.add(psd);
                    dbcursor.moveToNext();

                }
                dbcursor.close();
                return list;
            }

        } catch (Exception e) {
            Log.d("Exception ", e.getMessage());
            return list;
        }
        return list;
    }

    public ArrayList<VisiColoersGetterSetter> getVISICOOLER_Data(JourneyPlan jcpGetset,Integer menu_id) {
        ArrayList<VisiColoersGetterSetter> list = new ArrayList<VisiColoersGetterSetter>();
        Cursor dbcursor = null;
        try {

            dbcursor = db.rawQuery("select m.Checklist_Id, c.Checklist from Mapping_Menu_Checklist m inner join Checklist_Master c on m.Checklist_Id = c.Checklist_Id" +
                    " Where Menu_Id = '" + menu_id + "' ", null);


            if (dbcursor != null) {

                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    VisiColoersGetterSetter sb = new VisiColoersGetterSetter();
                    sb.setCheklist(dbcursor.getString(dbcursor.getColumnIndexOrThrow("Checklist")));
                    sb.setCheklist_cd((((dbcursor.getString(dbcursor.getColumnIndexOrThrow("Checklist_Id"))))));
                    list.add(sb);
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return list;
            }
        } catch (Exception e) {
            Log.d("Exception get JCP!", e.toString());
            return list;
        }
        return list;
    }

    public long insertNewVisiCoolerData(JourneyPlan JCP, VisiColoersGetterSetter visicoolar, ArrayList<VisiColoersGetterSetter> deploymentData) {
        db.delete(CommonString.TABLE_VISICOOLER_DATA, " STORE_ID" + "='" + JCP.getStateId() + "' AND VISIT_DATE='" + JCP.getVisitDate() + "'", null);
        db.delete(CommonString.TABLE_VISICOOLER_CHEKLIST, " STORE_ID" + "='" + JCP.getStateId() + "' AND VISIT_DATE='" + JCP.getVisitDate() + "'", null);
        ContentValues values = new ContentValues();
        ContentValues values1 = new ContentValues();
        long l = 0;
        try {
            db.beginTransaction();
            if (!JCP.getStoreName().isEmpty()) {
                values.put(CommonString.KEY_STORE_ID, JCP.getStoreId());
                values.put(CommonString.KEY_VISIT_DATE, JCP.getVisitDate());
                values.put(CommonString.KEY_PRESENT_EXIST, visicoolar.getPresent_name());
                values.put(CommonString.KEY_IMAGE_CLOSEUP, visicoolar.getImage_close_up());
                values.put(CommonString.KEY_LONGSHOT, visicoolar.getImage_long_shot());
                values.put(CommonString.KEY_REASON, visicoolar.getReason());
                values.put(CommonString.KEY_REASON_ID, visicoolar.getReason_cd());
                l = db.insert(CommonString.TABLE_VISICOOLER_DATA, null, values);

                if (1 > 0) {
                    long id = 0;
                    for (int i = 0; i < deploymentData.size(); i++) {
                        values1.put(CommonString.KEY_STORE_ID, JCP.getStoreId());
                        values1.put(CommonString.KEY_VISIT_DATE, JCP.getVisitDate());
                        values1.put(CommonString.KEY_ANSWER_CD, deploymentData.get(i).getAnswer_cd());
                        values1.put(CommonString.KEY_ANSWER, deploymentData.get(i).getAnswer());
                        values1.put(CommonString.KEY_CHEKLIST, deploymentData.get(i).getCheklist());
                        values1.put(CommonString.KEY_CHEKLIST_ID, deploymentData.get(i).getCheklist_cd());
                        id = db.insert(CommonString.TABLE_VISICOOLER_CHEKLIST, null, values1);

                    }

                    /*if (id > 0) {
                        return id;
                    } else {
                        return 0;
                    }
*/
                }

            }
            db.setTransactionSuccessful();
            db.endTransaction();
        } catch (Exception ex) {
            Log.d("Database Exception", " while Insert Header Data " + ex.toString());
        }
        return l;
    }

    public VisiColoersGetterSetter getNewVisicoolerData(JourneyPlan jcp) {
        Log.d("FetchinggetCityMasterDat", "------------------");
        VisiColoersGetterSetter sb = new VisiColoersGetterSetter();
        Cursor dbcursor = null;

        try {

            dbcursor = db.rawQuery("SELECT * FROM " + CommonString.TABLE_VISICOOLER_DATA + " WHERE " + CommonString.KEY_STORE_ID + " = " + jcp.getStoreId(), null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {
                    sb.setPresent_name(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_PRESENT_EXIST)));
                    sb.setImage_close_up(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_IMAGE_CLOSEUP)));
                    sb.setImage_long_shot(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_LONGSHOT)));
                    sb.setReason(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON)));
                    sb.setReason_cd(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_REASON_ID)));

                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return sb;
            }

        } catch (Exception e) {
            Log.d("Exception when fetching", e.toString());
            return sb;
        }

        Log.d("Fetching non working", "-------------------");
        return sb;
    }

}
