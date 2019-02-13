package com.cpm.reckitt_benckiser_gt.utilities;

import android.os.Environment;

/**
 * Created by yadavendras on 19-12-2016.
 */

public class CommonString {

    // webservice constants
    // preferenec keys
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_RIGHTNAME = "rightname";
    public static final String KEY_DATE = "date";
    public static final String KEY_DDATE = "DATE";
    public static final String KEY_YYYYMMDD_DATE = "yyyymmddDate";
    public static final String KEY_STOREVISITED_STATUS = "STOREVISITED_STATUS";
    public static final String KEY_NOTICE_BOARD = "NOTICE_BOARD";
    public static final String KEY_QUIZ_URL = "QUIZ_URL";
    public static final String KEY_PATH = "path";
    public static final String KEY_VERSION = "APP_VERSION";
    public static final String KEY_LOGIN_DATA = "login_data";
    public static final String KEY_CHECKOUT_IMAGE = "CHECKOUT_IMAGE";
    public static final String KEY_NOTICE_BOARD_LINK = "NOTICE_BOARD_LINK";
    public static final String KEY_STORE_ID = "STORE_ID";
    public static final String KEY_CATEGORY_CD = "CATEGORY_CD";
    public static final String KEY_CATEGORY_IMAGE = "CATEGORY_IMAGE";
    public static final String KEY_BRAND_GROUP_CD = "BRAND_GROUP_CD";
    public static final String KEY_BRAND_GROUP = "BRAND_GROUP";
    public static final String KEY_VISIT_DATE = "VISIT_DATE";
    public static final String KEY_BRAND_GROUP_ID = "BRAND_GROUP_ID";
    public static final String KEY_USER_ID = "USER_ID";
    public static final String KEY_STORE_IN_TIME = "STORE_IN_TIME";
    public static final String KEY_IN_TIME = "IN_TIME";
    public static final String KEY_OUT_TIME = "OUT_TIME";
    public static final String KEY_LATITUDE = "LATITUDE";
    public static final String KEY_LONGITUDE = "LONGITUDE";
    public static final String KEY_REASON_ID = "REASON_ID";
    public static final String KEY_SUB_REASON_ID = "SUB_REASON_ID";
    public static final String KEY_REASON = "REASON";
    public static final String KEY_COVERAGE_REMARK = "REMARK";
    public static final String KEY_FLAG_Devaition = "FLAG_Devaition";
    public static final String KEY_IMAGE = "IMAGE";
    public static final String KEY_ID = "Id";
    public static final String KEY_IID = "KEY_ID";
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_WINDOW_OBJECT = "WINDOW_OBJECT";
    public static final String TAG_BRAND_OBJECT = "BRAND_OBJECT";
    public static final String TAG_CHECKLIST_OBJECT = "CHECKLIST_OBJECT";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DOWNLOAD_INDEX = "download_Index";

    //KEYS RELATED TO T2P COMPLIANCE

    public static final String KEY_COMMON_ID = "COMMON_ID";
    public static final String KEY_CHECKLIST_ID = "CHECKLIST_ID";
    public static final String KEY_STOCK = "STOCK";
    public static final String KEY_BRAND_ID = "BRAND_ID";
    public static final String KEY_SKU_ID = "SKU_ID";
    public static final String KEY_SKUNAME = "SKUNAME";
    public static final String KEY_CORE_SKU = "Core_Sku";
    public static final String KEY_FOCUS = "Focus";
    public static final String KEY_DOM1 = "DOM1";
    public static final String KEY_DOM2 = "DOM2";
    public static final String KEY_DOM3 = "DOM3";
    public static final String is_competitor = "IS_COMPETITOR";
    public static final String competitor = "competitor";
    public static final String SKU = "Sku";
    public static final String SKU_ID = "Sku_Id";
    public static final String KEY_SKUFACEUP = "SKUFACEUP";
    public static final String KEY_CATEGORY_ID = "CATEGORY_ID";
    public static final String KEY_IMAGE_ID = "IMAGE_ID";
    public static final String KEY_SKU_STOCK = "SKU_STOCK";
    public static final String KEY_CATEGORY = "CATEGORY";
    public static final String KEY_HORLICKS_RANGE = "HORLICKS_RANGE";
    public static final String KEY_BOOST_RANGE = "BOOST_RANGE";
    public static final String KEY_GSK = "GSK";
    public static final String KEY_CATEGORY_HEADER = "CATEGORY_HEADER";
    public static final String KEY_SHELF_STRIP = "SHELF_STRIP";
    public static final String KEY_IMAGE1 = "IMAGE1";
    public static final String KEY_IMAGE2 = "IMAGE2";
    public static final String KEY_IMAGE3 = "IMAGE3";
    public static final String KEY_BRAND_CD = "Brand_Cd";
    public static final String TABLE_INSERT_MYPOSM_DATA = "TABLE_INSERT_MYPOSM_DATA";
    public static final String KEY_BRAND = "Brand";
    public static final String KEY_TRADE_AREA_CD = "TRADE_AREA_CD";
    public static final String KEY_DISPLAY_CD = "DISPLAY_CD";
    public static final String DISPLAY_TYPE = "DISPLAY_TYPE";
    public static final String KEY_LOCATION = "LOCATION";
    public static final String KEY_LOCATION_CD = "LOCATION_CD";
    public static final String KEY_TOTALSTOCK = "TOTALSTOCK";
    public static final String KEY_VARIANT = "VARIANT";
    public static final String PROMOTION_CD = "PROMOTION_CD";
    public static final String KEY_GRAMMAGE = "GRAMMAGE";
    public static final String KEY_DESCRIPTION = "DESCRIPTION";
    public static final String KEY_POSM_CD = "POSM_CD";
    //  public static final String KEY_POSM = "POSM";
    public static final String KEY_QUANTITY = "Quantity";
    public static final String KEY_QUANTITY2 = "Quantity2";
    public static final String KEY_QUANTITY3 = "Quantity3";
    public static final String KEY_RUNNING = "RUNNING";
    public static final String KEY_PROMOTYPE = "PROMOTYPE";
    public static final String KEY_PROMOTYPE_CD = "PROMOTYPE_CD";
    public static final String STORE_ADDRESS = "STORE_ADDRESS";
    public static final String STORE_NAME = "STORE_NAME";
    public static final String CITY_ID = "CITY_ID";
    public static final String TIER_ID = "TIER_ID";
    public static final String TRADE_AREA_ID = "TRADE_AREA_ID";
    public static final String DISPLAY_TYPE_ID = "DISPLAY_TYPE_ID";
    public static final String CLASSIFICATION_ID = "CLASSIFICATION_ID";
    public static final String TYPE_ID = "TYPE_ID";
    public static final String TYPE = "TYPE";
    public static final String DISTRIBUTOR_ID = "DISTRIBUTOR_ID";
    public static final String STORE_CATEGORY_ID = "STORE_CATEGORY_ID";
    public static final String BACKWALL_IMG = "BACKWALL_IMG";
    public static final String SHELF_ONE = "SHELF_ONE";
    public static final String DEALER_BOARD_IMG = "DEALER_BOARD_IMG";
    public static final String IN_TIME = "IN_TIME";
    public static final String OUT_TIME = "OUT_TIME";
    public static final String SHELF_TWO = "SHELF_TWO";
    public static final String KEY_UPLOADSTATUS = "UPLOADSTATUS";
    public static final String KEY_JOURNEY_PLAN = "JOURNEY_PLAN";
    public static final String TABLE_Journey_Plan = "Journey_Plan";
    public static final String TABLE_Journey_Plan_DBSR = "Journey_Plan_DBSR";
    public static final String TABLE_Journey_Plan_DBSR_Saved = "Journey_Plan_DBSR_Saved";
    public static final String TABLE_Deviation_Journey_Plan = "Deviation_Journey_Plan";
    public static final String KEY_MID = "MID";
    public static final String KEY_BAY_ID = "BAY_ID";
    public static final String TABLE_INSERT_PRIMARYBAY_SKUDATA = "PRIMARYBAY_SKUDATA";
    public static final String TABLE_PRIMARY_BAY_IMAGE = "PRIMARYBAY_IMAGE";
    public static final String TABLE_PRIMARY_BAY_CATEGORY_IMAGE = "PRIMARYBAY_CATEGORY_IMAGE";
    public static final String CREATE_TABLE_Journey_Plan_DBSR_Saved = "Create Table If Not Exists Journey_Plan_DBSR_Saved(Store_Id Integer, Visit_Date Text, Distributor Text, Store_Name text, Address1 Text, Address2 text, Landmark text, Pincode text, Contact_Person text, Contact_No text, City Text, Store_Type Text, Store_Category Text, State_Id Integer, Store_Type_Id integer, Store_Category_Id integer, Reason_Id Integer, Upload_Status Text, Geo_Tag Text, Distributor_Id Integer)";


    public static final String KEY_P = "P";
    public static final String KEY_D = "D";
    public static final String KEY_U = "U";
    public static final String KEY_C = "C";
    public static final String KEY_Y = "Y";
    public static final String KEY_N = "N";
    public static final String STORE_STATUS_LEAVE = "L";
    public static final String KEY_VALID = "Valid";
    public static final String KEY_CHECK_IN = "I";
    // webservice constants

    public static final String KEY_SUCCESS = "Success";
    public static final String KEY_FAILURE = "Failure";

    public static final int LOGIN_SERVICE = 1;
    public static final int DOWNLOAD_ALL_SERVICE = 2;
    public static final int COVERAGE_DETAIL = 3;
    public static final int UPLOADJCPDetail = 4;
    public static final int UPLOADJsonDetail = 5;
    public static final int COVERAGEStatusDetail = 6;
    public static final int CHECKOUTDetail = 7;
    public static final int DELETE_COVERAGE = 8;
    public static final int COVERAGE_NONWORKING = 9;
    public static final int COVERAGE_DETAIL_CLIENT = 10;
    public static final int CHECKOUTDetail_CLIENT = 11;
    public static final int CHANGE_PASSWORD_SERVICE = 12;
    public static final String KEY_CHCECKLIST_DATA = "CheckList_Data";
    public static final String KEY_BRAND_DATA = "Brand_Data";

    public static String URL = "http://mgt.parinaam.in/Webservice/Mondlezeservice.svc/";
    public static String URL3 = "http://mgt.parinaam.in/webservice/Imageupload.asmx/";
    public static String URLGORIMAG = "http://mgt.parinaam.in/webservice/Imageupload.asmx/";

    public static final String BACKUP_FILE_PATH = Environment.getExternalStorageDirectory() + "/Mondelez_GT_Backup/";
    //Alert Messages
    public static final String MESSAGE_SERVER_ERROR = "Server Error.Please Access After Some Time";
    public static final String MESSAGE_CHANGED = "Invalid UserId Or Password";

    public static final String MESSAGE_INTERNET_NOT_AVALABLE = "No Internet Connection.Please Check Your Network Connection";
    public static final String MESSAGE_EXCEPTION = "Problem Occured : Report The Problem To Parinaam ";
    public static final String MESSAGE_ERROR_IN_EXECUTING = " Error in executing :";
    public static final String MESSAGE_SOCKETEXCEPTION = "Network Communication Failure. Please Check Your Network Connection";
    public static final String MESSAGE_NO_RESPONSE_SERVER = "Server Not Responding.Please try again.";
    public static final String MESSAGE_XmlPull = "Problem Occured xml pull: Report The Problem To Parinaam";
    public static final String MESSAGE_INVALID_JSON = "Problem Occured while parsing Json : invalid json data";
    public static final String MESSAGE_NUMBER_FORMATE_EXEP = "Invailid Mid";

    public static final String TABLE_STORE_GEOTAGGING = "STORE_GEOTAGGING";
    public static final String TABLE_COVERAGE_DATA = "COVERAGE_DATA";
    public static final String TABLE_COMPETITION = "COMPETITION";
    public static final String TABLE_COMPETITION_EXIST = "COMPETITION_EXIST";
    public static final String KEY_PROMOTION = "PROMOTION";
    public static final String KEY_POSM = "POSM";
    public static final String TABLE_TOUCHPOINTS = "TOUCHPOINTS";
    public static final String TABLE_PROMOTION = "PROMOTION";
    public static final String TABLE_PROMOTION_EXIST = "PROMOTION_EXIST";
    public static final String TABLE_SECONDARY_DISPLAY = "SECONDARY_DISPLAY";
    public static final String TABLE_SECONDARY_DISPLAY_EXIST = "SECONDARY_DISPLAY_EXIST";
    public static final String TABLE_PRIMARY_BAY = "PRIMARY_BAY";
    public static final String TABLE_PRIMARY_BAY_RANGE = "PRIMARY_BAY_RANGE";
    public static final String TABLE_BACKWALL_IMG = "BACKWALL_IMG";
    public static final String KEY_ISEXIST = "ISEXIST";


    public static final String TABLE_STORE_KYC_DETAILS = "Store_KYC_Detail";
    public static final String TABLE_STORE_KYC_SAVED_DATA = "STORE_KYC_SAVED_DATA";
    public static final String TABLE_TOPUP_DATA = "TOPUP";
    public static final String KEY_BACKWALL_IMAGE = "BACKWALL_IMAGE";
    public static final String KEY_TOPUPSTORE_ID = "TOPUPSTORE_ID";
    public static final String KEY_STORE_NAME = "STORE_NAME";
    public static final String TAG_FROM = "FROM";
    public static final String TAG_FROM_PJP = "from_pjp";
    public static final String TAG_FROM_JCP = "from_jcp";
    public static final int TAG_FROM_PREVIOUS = 0;
    public static final int TAG_FROM_CURRENT = 1;
    public static final String TAG_FROM_TOPUP = "from_topUp";
    public static final String TAG_FROM_MYPOSM = "from_myPosm";
    public static final String TAG_FROM_STORE = "from_Store";
    public static final String TAG_FROM_NONWORKING = "from_NonWorking";
    public static final String KEY_DISTRIBUTOR_CD = "Distributor_Cd";
    public static final String TABLE_VISITOR_LOGIN = "TABLE_VISITOR_LOGIN";
    public static final String KEY_DESIGNATION = "DESIGNATION";
    public static final String KEY_EMP_CODE = "EMP_CODE";
    public static final String KEY_IN_TIME_IMAGE = "IN_TIME_IMAGE";
    public static final String KEY_OUT_TIME_IMAGE = "OUT_TIME_IMAGE";
    public static final String KEY_EMP_CD = "EMP_CD";
    public static final String KEY_NAME = "NAME";

    //UPENDRA START CODE
    public static final String TABLE_POSM = "DR_POSMM";
    public static final String TABLE_INSERT_POSM_NEW = "POSM_NEW";
    public static final String TABLE_PRIMARY_DISPLAY = "DR_PRIMARY_STOCK";
    public static final String TABLE_SECONDARY_WINDOW_STOCK = "DR_SECONDARY_WINDOW_STOCK";
    public static final String TABLE_PRIMARY_DISPLAY_IMAGE = "DR_PRIMARY_IMAGE";
    public static final String TABLE_SECONDARY_WINDOW = "DR_SECONDARY_WINDOW";
    public static final String TABLE_SECONDARY_WINDOW_COMPLIANCE = "DR_SECONDARY_WINDOW_COMPLIANCE";
    public static final String KEY_FACEUP = "FACEUP";
    public static final String KEY_LAST_MONTH = "LAST_MONTH";
    public static final String KEY_LAST_YEAR = "LAST_YEAR";
    public static final String KEY_MORE_THEN = "MORE_THEN";
    public static final String KEY_UNCHECK = "KEY_UNCHECK";
    public static final String KEY_LOCATION_TYPE = "LOCATION_TYPE";
    public static final String KEY_LOCATION_TYPE_ID = "LOCATION_TYPE_ID";
    public static final String KEY_LENGTH = "LENGTH";
    public static final String KEY_WIDTH = "WIDTH";
    public static final String KEY_WINDOW_ID = "WINDOW_ID";
    public static final String KEY_EXISTORNOT = "EXISTORNOT";
    public static final String KEY_WINDOW_IMAGE = "WINDOW_IMAGE";
    public static final String KEY_WINDOW_IMAGE2 = "WINDOW_IMAGE2";
    public static final String KEY_WINDOW_CD = "WINDOW_CD";
    public static final String KEY_CHECKLIST_CD = "CHECKLIST_CD";
    public static final String KEY_WINDOW_EXIST = "WINDOW_EXIST";
    public static final String KEY_STATUS = "STATUS";
    public static final String KEY_POSM_ID = "POSM_ID";
    public static final String KEY_QTY = "QTY";
    public static final String KEY_TYPE = "TYPE";

    public static final String CREATE_TABLE_COVERAGE_DATA = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_COVERAGE_DATA
            + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_LATITUDE + " VARCHAR,"
            + KEY_LONGITUDE + " VARCHAR,"
            + KEY_IMAGE + " VARCHAR,"
            + KEY_CHECKOUT_IMAGE + " VARCHAR,"
            + KEY_REASON_ID + " INTEGER,"
            + KEY_COVERAGE_REMARK + " VARCHAR,"
            + KEY_REASON + " VARCHAR)";


    //File Path
    public static final String FILE_PATH = Environment.getExternalStorageDirectory() + "/.RB_GT_Images/";
    public static final String FOLDER_NAME_WITH_PATH = Environment.getExternalStorageDirectory() + "/.RB_GT_Images";
    public static final String FOLDER_NAME_IMAGE = ".RB_GT_Images";
    public static final String OLD_FILE_PATH = Environment.getExternalStorageDirectory() + "/GSK_GT_MER_Images/";
    public static final String FILE_PATH_Downloaded = Environment.getExternalStorageDirectory() + "/Mondelez_GT_Downloaded_Img/";

    public static final String KEY_STORE_LAYOUT = "LAYOUT";
    public static final String KEY_STORE_SIZE = "SIZE";

    public static final String TABLE_STORE_DATA = "STORE_DATA";
    public static final String KEY_PERSON_NAME = "Name";
    public static final String KEY_CONTACT_NUMBER = "Number";
    public static final String KEY_ADDRESS1 = "ADDRESS_LINE1";
    public static final String KEY_ADDRESS2 = "ADDRESS_LINE2";
    public static final String KEY_LANDMARK = "LANDMARK";
    public static final String KEY_PINCODE = "PINCODE";
    public static final String KEY_AVAILABILITY = "QUANTITY";
    public static final String KEY_KYC_ID = "KYC_ID";
    public static final String KEY_KYC = "KYC";
    public static final String KEY_GST_NO = "GST_NO";
    public static final String KEY_GST_IMAGE = "GST_IMAGE";
    public static final String KEY_PAN_NO = "PAN_NO";
    public static final String ONBACK_ALERT_MESSAGE = "Unsaved data will be lost - Do you want to continue?";
    public static final String KEY_YES_NO_ANSWER = "YES_NO_ANSWER";
    public static final String KEY_ANSWER_CD = "ANSWER_CD";
    public static final int CAPTURE_MEDIA = 131;
    public static final int GRID_CAMERA_REQUEST_CODE = 1;
    public static final String TABLE_WINDOWS_DATA = "WINDOWS_DATA";
    public static final String CREATE_TABLE_WINDOWS_DATA = "CREATE TABLE IF NOT EXISTS "
            + TABLE_WINDOWS_DATA
            + "("
            + "KEY_ID"
            + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + "DATE"
            + " VARCHAR,"
            + "USER_ID"
            + " VARCHAR,"
            + "STORE_ID"
            + " VARCHAR,"
            + "BRAND_ID"
            + " INTEGER,"
            + "WINDOW_CD"
            + " INTEGER,"
            + "EXISTORNOT"
            + " VARCHAR,"
            + "WINDOW_IMAGE"
            + " VARCHAR,"
            + "WINDOW_IMAGE2"
            + " VARCHAR,"
            + "REASON_ID"
            + " VARCHAR)";

    public static final String TABLE_INSERT_CHECKLIST_DATA = "CheckList_DATA";
    public static final String CREATE_TABLE_INSERT_CHECKLIST_DATA = "CREATE TABLE IF NOT EXISTS "
            + TABLE_INSERT_CHECKLIST_DATA
            + "("
            + "KEY_ID"
            + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + "DATE"
            + " VARCHAR,"
            + "WINDOW_CD"
            + " VARCHAR,"
            + "COMMON_ID"
            + " VARCHAR,"
            + "CHECKLIST_CD"
            + " VARCHAR,"
            + "ANSWER_CD"
            + " VARCHAR,"
            + "USER_ID"
            + " VARCHAR,"
            + KEY_STORE_ID + " VARCHAR)";


    public static final String TABLE_CATEGORY_DRESSING_DATA = "CATEGORY_DRESSING_DATA";
    public static final String CREATE_TABLE_CATEGORY_DRESSING_DATA = "CREATE TABLE IF NOT EXISTS "
            + TABLE_CATEGORY_DRESSING_DATA
            + "("
            + "KEY_ID"
            + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + "DATE"
            + " VARCHAR,"
            + "USER_ID"
            + " VARCHAR,"
            + "STORE_ID"
            + " VARCHAR,"
            + "CATEGORY_CD"
            + " INTEGER,"
            + "EXISTORNOT"
            + " VARCHAR,"
            + "CATEGORY_IMAGE"
            + " VARCHAR,"
            + "REASON_ID"
            + " VARCHAR)";


    public static final String TABLE_INSERT_CATEGORY_DRESSING_CHECKLIST_DATA = "CATEGORY_DRESSING_CHECKLIST_DATA";
    public static final String CREATE_TABLE_INSERT_CATEGORY_DRESSING_CHECKLIST_DATA = "CREATE TABLE IF NOT EXISTS "
            + TABLE_INSERT_CATEGORY_DRESSING_CHECKLIST_DATA
            + "("
            + "KEY_ID"
            + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + "DATE"
            + " VARCHAR,"
            + "CATEGORY_CD"
            + " VARCHAR,"
            + "COMMON_ID"
            + " VARCHAR,"
            + "CHECKLIST_CD"
            + " VARCHAR,"
            + "ANSWER_CD"
            + " VARCHAR,"
            + "USER_ID"
            + " VARCHAR,"
            + KEY_STORE_ID + " VARCHAR)";

    public static final String CREATE_TABLE_STORE_GEOTAGGING = "CREATE TABLE IF NOT EXISTS "
            + TABLE_STORE_GEOTAGGING
            + " ("
            + "KEY_ID"
            + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + "STORE_ID"
            + " INTEGER,"
            + "LATITUDE"
            + " VARCHAR,"
            + "LONGITUDE"
            + " VARCHAR,"
            + "GEO_TAG"
            + " VARCHAR,"
            + "STATUS"
            + " VARCHAR,"
            + "FRONT_IMAGE" + " VARCHAR)";


    public static final String TABLE_CATEGORY_DBSR_DATA = "CATEGORY_DBSR_DATA";
    public static final String CREATE_TABLE_CATEGORY_DBSR_DATA = "CREATE TABLE IF NOT EXISTS "
            + TABLE_CATEGORY_DBSR_DATA
            + "("
            + "KEY_ID"
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "DATE"
            + " VARCHAR,"
            + "USER_ID"
            + " VARCHAR,"
            + "STORE_ID"
            + " VARCHAR,"
            + "CATEGORY_CD"
            + " INTEGER,"
            + "EXISTORNOT"
            + " VARCHAR,"
            + "CATEGORY_IMAGE"
            + " VARCHAR)";

    public static final String KEY_STORE_TYPE = "STORE_TYPE";
    public static final String KEY_STORE_TYPE_CD = "STORE_TYPE_CD";
    public static final String KEY_STORE_ADDRESS = "STORE_ADDRESS";
    public static final String KEY_STORE_CITY = "STORE_CITY";

    public static final String TABLE_STORE_PROFILE_DATA = "STORE_PROFILE_DATA";
    public static final String CREATE_TABLE_STORE_PROFILE_DATA = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_STORE_PROFILE_DATA + " (" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT ," + KEY_STORE_ID
            + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_STORE_TYPE_CD + " INTEGER,"
            + KEY_STORE_ADDRESS + " VARCHAR,"
            + KEY_STORE_CITY + " VARCHAR,"
            + KEY_STORE_NAME + " VARCHAR,"
            + KEY_STORE_TYPE + " VARCHAR)";


    ///usk
    public static final String KEY_EXIST = "Exist";
    public static final String TABLE_POSM_DEPLOYMENT = "POSM_Deployment";
    public static final String KEY_STATE_ID = "State_Id";
    public static final String KEY_DISTRIBUTOR_ID = "Distributor_Id";
    public static final String KEY_STORE_TYPE_ID = "Store_Type_Id";
    public static final String KEY_IMAGE_CLOSEUP = "IMAGE_CLOSEUP";
    public static final String KEY_IMAGE_LONGSHOT = "LONGSHOT";
    public static final String KEY_LONGSHOT = "LONGSHOT";
    public static final String KEY_ANSWER = "ANSWER";

    public static final String CREATE_TABLE_POSM_DEPLOYMENT = "CREATE TABLE  IF NOT EXISTS " + TABLE_POSM_DEPLOYMENT
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_EXIST + " VARCHAR,"
            + KEY_POSM_ID + " VARCHAR,"
            + KEY_POSM + " VARCHAR,"
            + KEY_REASON_ID + " VARCHAR,"
            + KEY_REASON + " VARCHAR,"
            + KEY_IMAGE1 + " VARCHAR)";


    public static final String KEY_PRESENT_EXIST = "PRESENT_EXIST";
    public static final String KEY_WORKING_EXIST = "WORKING_EXIST";
    public static final String KEY_LOCATION_EXIST = "LOCATION_EXIST";
    public static final String KEY_PURITY_EXIST = "PURITY_EXIST";
    public static final String KEY_PLANOGRAM_EXIST = "PLANOGRAM_EXIST";
    public static final String KEY_CHEKLIST_ID = "CHEKLIST_ID";
    public static final String KEY_CHEKLIST = "CHEKLIST";

    public static final String TABLE_VISICOOLER = "DR_VISICOOLER";
    public static final String CREATE_TABLE_TABLE_VISICOOLER = "CREATE TABLE  IF NOT EXISTS " + TABLE_VISICOOLER
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_PRESENT_EXIST + " VARCHAR,"
            + KEY_WORKING_EXIST + " VARCHAR,"
            + KEY_LOCATION_EXIST + " VARCHAR,"
            + KEY_PURITY_EXIST + " VARCHAR,"
            + KEY_PLANOGRAM_EXIST + " VARCHAR,"
            + KEY_IMAGE_CLOSEUP + " VARCHAR,"
            + KEY_IMAGE_LONGSHOT + " VARCHAR)";


    public static final String TABLE_VISICOOLER_CHEKLIST = "DR_VISICOOLER_CHEKLIST";
    public static final String CREATE_TABLE_TABLE_VISICOOLER_CHEKLIST = "CREATE TABLE  IF NOT EXISTS " + TABLE_VISICOOLER_CHEKLIST
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_CHEKLIST_ID + " INTEGER,"
            + KEY_CHEKLIST + " VARCHAR,"
            + KEY_ANSWER_CD + " INTEGER,"
            + KEY_ANSWER + " VARCHAR)";


    public static final String TABLE_INSERT_FOCUS_PRODUCT_STOCK_OPENINGHEADER_DATA = "FOCUS_PRODUCT_OPENINGHEADER_DATA";
    public static final String CREATE_TABLE_FOCUS_PRODUCT_OPENINGHEADER_DATA = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_INSERT_FOCUS_PRODUCT_STOCK_OPENINGHEADER_DATA + " (" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT ," + KEY_STORE_ID
            + " INTEGER, "
            + "BRAND_CD" + " INTEGER,"
            + KEY_VISIT_DATE + " VARCHAR,"
            + "COMMONID" + " INTEGER,"
            + "BRAND" + " VARCHAR)";


    public static final String TABLE_STORE_FOCUS_PRODUCT_DATA = "FOCUS_PRODUCT_STOCK_DATA";
    public static final String CREATE_TABLE_FOCUS_PRODUCT_STOCK_DATA = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_STORE_FOCUS_PRODUCT_DATA + " (" + "Common_Id"
            + " INTEGER  ," + KEY_STORE_ID
            + " INTEGER, "
            + "BRAND_CD" + " INTEGER, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + "SKU" + " VARCHAR, "
            + "COMMONID" + " INTEGER,"
            + "SKU_CD" + " INTEGER, "
            + "STOCK" + " INTEGER, "
            + "BRAND" + " VARCHAR)";


    public static final String KEY_MENU_ID = "MENU_ID";
    public static final String TABLE_VISICOOLER_DATA = "DR_VISICOOLER_DATA";
    public static final String CREATE_TABLE_VISICOOLER_DATA = "CREATE TABLE  IF NOT EXISTS " + TABLE_VISICOOLER_DATA
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_PRESENT_EXIST + " VARCHAR,"
            + KEY_REASON + " VARCHAR,"
            + KEY_REASON_ID + " VARCHAR,"
            + KEY_IMAGE_CLOSEUP + " VARCHAR,"
            + KEY_IMAGE_LONGSHOT + " VARCHAR)";

//-------YSY--------

    public static final String TABLE_WINDOW_HEADER = "WINDOW_HEADER";
    public static final String TABLE_WINDOW_BRAND_LIST = "WINDOW_BRAND_LIST";
    public static final String TABLE_WINDOW_CHECK_LIST = "WINDOW_CHECK_LIST";
    public static final String TABLE_BRAND_CHECK_LIST = "BRAND_CHECK_LIST";
    public static final String TABLE_CTU_BRAND_HEADER = "CTU_BRAND_HEADER";
    public static final String TABLE_CTU_BRAND_CHECK_LIST = "CTU_BRAND_CHECK_LIST";
    public static final String TABLE_SECONDARY_VISIBILITY_HEADER = "SECONDARY_VISIBILITY_HEADER";
    public static final String TABLE_SECONDARY_VISIBILITY_CHECK_LIST = "CTU_BRAND_CHECK_LIST";

    public static final String KEY_WINDOW = "WINDOW";
    public static final String KEY_CHECKLIST = "CHECKLIST";
    public static final String KEY_DISPLAY_ID = "DISPLAY_ID";
    public static final String KEY_DISPLAY = "DISPLAY";
    public static final String CREATE_TABLE_WINDOW = "CREATE TABLE  IF NOT EXISTS " + TABLE_WINDOW_HEADER
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_EXIST + " INTEGER,"
            + KEY_WINDOW_ID + " INTEGER,"
            + KEY_WINDOW + " VARCHAR,"
            + KEY_REASON_ID + " INTEGER,"
            + KEY_IMAGE_LONGSHOT + " VARCHAR,"
            + KEY_IMAGE_CLOSEUP + " VARCHAR)";

    public static final String CREATE_TABLE_WINDOW_BRAND_LIST = "CREATE TABLE  IF NOT EXISTS " + TABLE_WINDOW_BRAND_LIST
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_COMMON_ID + " INTEGER,"
            + KEY_BRAND_ID + " INTEGER,"
            + KEY_BRAND + " VARCHAR,"
            + KEY_STOCK + " INTEGER)";

    public static final String CREATE_TABLE_WINDOW_CHECK_LIST = "CREATE TABLE  IF NOT EXISTS " + TABLE_WINDOW_CHECK_LIST
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_COMMON_ID + " INTEGER,"
            + KEY_CHECKLIST_ID + " INTEGER,"
            + KEY_ANSWER_CD + " INTEGER,"
            + KEY_CHECKLIST + " VARCHAR)";


   public static final String CREATE_TABLE_BRAND_CHECK_LIST = "CREATE TABLE  IF NOT EXISTS " + TABLE_BRAND_CHECK_LIST
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_COMMON_ID + " INTEGER,"
            + KEY_CHECKLIST_ID + " INTEGER,"
            + KEY_ANSWER_CD + " INTEGER,"
            + KEY_CHECKLIST + " VARCHAR)";

    public static final String CREATE_TABLE_CTU_BRAND_HEADER = "CREATE TABLE  IF NOT EXISTS " + TABLE_CTU_BRAND_HEADER
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_EXIST + " INTEGER,"
            + KEY_BRAND_ID + " INTEGER,"
            + KEY_BRAND + " VARCHAR,"
            + KEY_REASON_ID + " INTEGER,"
            + KEY_IMAGE_LONGSHOT + " VARCHAR,"
            + KEY_IMAGE_CLOSEUP + " VARCHAR)";

    public static final String CREATE_TABLE_CTU_BRAND_CHECK_LIST = "CREATE TABLE  IF NOT EXISTS " + TABLE_CTU_BRAND_CHECK_LIST
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_COMMON_ID + " INTEGER,"
            + KEY_CHECKLIST_ID + " INTEGER,"
            + KEY_ANSWER_CD + " INTEGER,"
            + KEY_CHECKLIST + " VARCHAR)";

    public static final String CREATE_TABLE_SECONDARY_VISIBILITY_HEADER = "CREATE TABLE  IF NOT EXISTS " + TABLE_SECONDARY_VISIBILITY_HEADER
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_EXIST + " INTEGER,"
            + KEY_DISPLAY_ID + " INTEGER,"
            + KEY_DISPLAY+ " VARCHAR,"
            + KEY_REASON_ID + " INTEGER,"
            + KEY_STOCK + " INTEGER,"
            + KEY_IMAGE_LONGSHOT + " VARCHAR,"
            + KEY_IMAGE_CLOSEUP + " VARCHAR)";

    public static final String CREATE_TABLE_SECONDARY_VISIBILITY_CHECK_LIST = "CREATE TABLE  IF NOT EXISTS " + TABLE_SECONDARY_VISIBILITY_CHECK_LIST
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_COMMON_ID + " INTEGER,"
            + KEY_CHECKLIST_ID + " INTEGER,"
            + KEY_ANSWER_CD + " INTEGER,"
            + KEY_CHECKLIST + " VARCHAR)";

   public static final String TABLE_MONKEUSUN_DATA = "DR_MONKEUSUN_DATA";
    public static final String CREATE_TABLE_MONKEUSUN_DATA = "CREATE TABLE  IF NOT EXISTS " + TABLE_MONKEUSUN_DATA
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_PRESENT_EXIST + " VARCHAR,"
            + KEY_REASON + " VARCHAR,"
            + KEY_REASON_ID+ " VARCHAR,"
            + KEY_IMAGE_CLOSEUP + " VARCHAR,"
            + KEY_LONGSHOT + " VARCHAR)";


    public static final String TABLE_MONKEUSUN_CHEKLIST = "DR_MONKEUSUN_CHEKLIST";
    public static final String CREATE_TABLE_MONKEUSUN_CHEKLIST_CHEKLIST = "CREATE TABLE  IF NOT EXISTS " + TABLE_MONKEUSUN_CHEKLIST
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_CHEKLIST_ID + " INTEGER,"
            + KEY_CHEKLIST + " VARCHAR,"
            + KEY_ANSWER_CD + " INTEGER,"
            + KEY_ANSWER + " VARCHAR)";


    public static final String TABLE_BACKOF_STORE_HEADER_DATA = "DR_BACKOF_STORE_HEADER_DATA";
    public static final String CREATE_TABLE_BACKOF_STORE_HEADER_DATA = "CREATE TABLE  IF NOT EXISTS " + TABLE_BACKOF_STORE_HEADER_DATA
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_PRESENT_EXIST + " VARCHAR,"
            + KEY_IMAGE_CLOSEUP + " VARCHAR,"
            + KEY_LONGSHOT + " VARCHAR)";


    public static final String TABLE_HEADER_BACK_OF_STORE = "DR_HEADER_BACK_OF_STORE";
    public static final String CREATE_HEADER_BACK_OF_STORE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_HEADER_BACK_OF_STORE
                    + " ("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
                    + KEY_VISIT_DATE + " VARCHAR,"
                    + KEY_BRAND_CD + " INTEGER,"
                    + KEY_BRAND + " VARCHAR,"
                    + KEY_STOCK + " VARCHAR)";

    public static final String TABLE_CHILD_BACK_OF_STORE_DATA = "DR_CHILD_BACK_OF_STORE_DATA";
    public static final String CREATE_TABLE_SHARE_OF_SHELF_FACING_DATA =
            "CREATE TABLE IF NOT EXISTS " + TABLE_CHILD_BACK_OF_STORE_DATA
                    + " ("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
                    + KEY_VISIT_DATE + " VARCHAR,"
                    + KEY_BRAND_CD + " INTEGER,"
                    + KEY_BRAND + " VARCHAR,"
                    + KEY_REASON_ID + " INTEGER,"
                    + KEY_REASON + " VARCHAR,"
                    + KEY_COMMON_ID + " INTEGER,"
                    + KEY_CHECKLIST_ID + " INTEGER,"
                    + KEY_CHEKLIST + " VARCHAR)";


    public static final String TABLE_JAR_DATA = "DR_JAR_DATA";
    public static final String CREATE_TABLE_TABLE_JAR_DATA_DATA = "CREATE TABLE  IF NOT EXISTS " + TABLE_JAR_DATA
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_PRESENT_EXIST + " VARCHAR,"
            + KEY_REASON + " VARCHAR,"
            + KEY_REASON_ID+ " VARCHAR,"
            + KEY_IMAGE_CLOSEUP + " VARCHAR,"
            + KEY_LONGSHOT + " VARCHAR)";

    public static final String TABLE_JAR_CHEKLIST = "DR_JAR_CHEKLIST";
    public static final String CREATE_TABLE_JAR_CHEKLIST_CHEKLIST = "CREATE TABLE  IF NOT EXISTS " + TABLE_JAR_CHEKLIST
            + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_CHEKLIST_ID + " INTEGER,"
            + KEY_CHEKLIST + " VARCHAR,"
            + KEY_ANSWER_CD + " INTEGER,"
            + KEY_ANSWER + " VARCHAR)";

    //-------------------------------------Neeraj--------------------------

    public static final String TABLE_FEEDBACK_QUESTIONS_DATA = "Feedback_Questions_Data";
    public static final String TABLE_SOS_CHECKLIST_QUESTIONS_DATA = "SOS_Feedback_Questions_Data";
    public static final String TABLE_SOS_HEADER_DATA = "SOS_Header_Data";
    public static final String TABLE_SOS_CHILD_DATA = "SOS_Child_Data";
    public static final String KEY_QUESTION_ID = "Question_Id";
    public static final String KEY_QUESTION = "Question";
    public static final String KEY_CORRECT_ANSWER_ID = "Correct_Answer_Id";
    public static final String KEY_CATEGORY_FACING = "Category_Facing";
    public static final String KEY_BRAND_FACING = "Brand_Facing";

    public static final String CREATE_TABLE_SOS_CHECKLIST_QUESTIONS_DATA = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_SOS_CHECKLIST_QUESTIONS_DATA
            + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_MENU_ID + " VARCHAR,"
            + KEY_QUESTION_ID + " VARCHAR,"
            + KEY_BRAND_ID + " VARCHAR,"
            + KEY_COMMON_ID + " VARCHAR,"
            + KEY_CATEGORY_ID + " VARCHAR,"
            + KEY_QUESTION + " VARCHAR,"
            + KEY_CORRECT_ANSWER_ID + " VARCHAR)";


    public static final String CREATE_TABLE_SOS_HEADER_DATA = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_SOS_HEADER_DATA
            + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_MENU_ID + " VARCHAR,"
            + KEY_CATEGORY + " VARCHAR,"
            + KEY_CATEGORY_FACING + " VARCHAR,"
            + KEY_CATEGORY_IMAGE + " VARCHAR,"
            + KEY_CATEGORY_ID + " VARCHAR)";



    public static final String CREATE_TABLE_SOS_CHILD_DATA = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_SOS_CHILD_DATA
            + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_MENU_ID + " VARCHAR,"
            + KEY_COMMON_ID + " VARCHAR,"
            + KEY_BRAND_FACING + " VARCHAR,"
            + KEY_BRAND_ID + " VARCHAR,"
            + KEY_CATEGORY_ID + " VARCHAR,"
            + KEY_BRAND + " VARCHAR)";



    public static final String CREATE_TABLE_FEEDBACK_QUESTIONS_DATA = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_FEEDBACK_QUESTIONS_DATA
            + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + KEY_STORE_ID + " INTEGER,USER_ID VARCHAR, "
            + KEY_VISIT_DATE + " VARCHAR,"
            + KEY_MENU_ID + " VARCHAR,"
            + KEY_QUESTION_ID + " VARCHAR,"
            + KEY_QUESTION + " VARCHAR,"
            + KEY_CORRECT_ANSWER_ID + " VARCHAR)";


    //Change Password service
    public static final String METHOD_UPDATE_PASSWORD = "Update_Password";
    public static final String SOAP_ACTION_UPDATE_PASSWORD = "http://tempuri.org/"
            + METHOD_UPDATE_PASSWORD;

    public static String IS_PASSWORD_CHECK = "IS_PASSWORD_CHECK";
    public static String MPIN = "MPIN";

    public static final String KEY_ANSWER_ID = "Answer_Id";
    public static final String KEY_CATEGORY_DATA = "Category_Data";

    public static final String KEY_IS_QUIZ_DONE = "is_quiz_done";
    public static final String KEY_QUESTION_CD = "question_cd";

}
