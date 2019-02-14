package com.cpm.reckitt_benckiser_gt.upload.Retrofit_method;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import com.cpm.reckitt_benckiser_gt.database.MondelezDatabase;
import com.cpm.reckitt_benckiser_gt.delegates.CoverageBean;
import com.cpm.reckitt_benckiser_gt.getterSetter.BrandMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.BackofStoreGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.BrandMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.CategoryMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.CategoryMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.ChecklistAnswerGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.ChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.ChecklistMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.ChecklistMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.DisplayMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.CommonChillerDataGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.DisplayMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.FocusProductGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.GeotaggingBeans;
import com.cpm.reckitt_benckiser_gt.getterSetter.JCPGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.JarGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.JourneyPlan;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingBackOfStoreGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingCTUGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingCategoryChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingFocusSkuGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingInitiativeGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingMenuChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingMenuGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingMonkeysunStoreGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingPosmGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingSecondaryVisibilityGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingShareOfShelfGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingVisicoolerGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingWindChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MenuMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingWindowGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MenuMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonCategoryReasonGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonExecutionReasonGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonWindowReasonGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.NonWorkingReasonGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.PosmMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.ReferenceVariablesForDownloadActivity;
import com.cpm.reckitt_benckiser_gt.getterSetter.SkuMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.StoreProfileGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.StoreTypeMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.SubCategoryMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.TableStructure;
import com.cpm.reckitt_benckiser_gt.getterSetter.TableStructureGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.VisiColoersGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowCheckAnswerGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowChecklistGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.WindowMasterGetterSetter;
import com.cpm.reckitt_benckiser_gt.upload.Retrofit_method.upload.ToStringConverterFactory;
import com.cpm.reckitt_benckiser_gt.utilities.AlertandMessages;
import com.cpm.reckitt_benckiser_gt.utilities.CommonString;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by deepakp on 5/22/2017.
 */

public class UploadImageWithRetrofit extends ReferenceVariablesForDownloadActivity {

    boolean isvalid;
    RequestBody body1;
    private Retrofit adapter;
    Context context;
    public int totalFiles = 0;
    public static int uploadedFiles = 0;
    public int listSize = 0;
    int status = 0;
    MondelezDatabase db;
    ProgressDialog pd;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String _UserId, date, app_ver, rightname;
    String[] jj;
    boolean statusUpdated = true;
    int from;

    public UploadImageWithRetrofit(Context context) {
        this.context = context;
    }

    public UploadImageWithRetrofit(Context context, String progessTitle, String progressStr, MondelezDatabase db) {
        this.context = context;
        this.db = db;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        _UserId = preferences.getString(CommonString.KEY_USERNAME, "");
        date = preferences.getString(CommonString.KEY_DATE, "");
        pd = new ProgressDialog(this.context);
        pd.setTitle(progessTitle);
        pd.setMessage(progressStr);
        pd.setCancelable(false);
        if (pd != null && (!pd.isShowing())) {
            pd.show();
        }
    }

    public UploadImageWithRetrofit(Context context, MondelezDatabase db, ProgressDialog pd, int from) {
        this.context = context;
        this.db = db;
        this.pd = pd;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        this.from = from;
        _UserId = preferences.getString(CommonString.KEY_USERNAME, "");
        date = preferences.getString(CommonString.KEY_DATE, null);
        rightname = preferences.getString(CommonString.KEY_RIGHTNAME, null);
        try {
            app_ver = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        db.open();
    }

    public String downloadDataUniversal(final String jsonString, int type) {
        try {
            status = 0;
            isvalid = false;
            final String[] data_global = {""};
            RequestBody jsonData = RequestBody.create(MediaType.parse("application/json"), jsonString);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .build();

            adapter = new Retrofit.Builder()
                    .baseUrl(CommonString.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
            PostApi api = adapter.create(PostApi.class);
            Call<ResponseBody> call = null;
            if (type == CommonString.LOGIN_SERVICE) {
                call = api.getLogindetail(jsonData);
            } else if (type == CommonString.DOWNLOAD_ALL_SERVICE) {
                call = api.getDownloadAll(jsonData);
            } else if (type == CommonString.COVERAGE_DETAIL) {
                call = api.getCoverageDetail(jsonData);
            } else if (type == CommonString.COVERAGE_DETAIL_CLIENT) {
                call = api.getCoverageDetailClient(jsonData);
            } else if (type == CommonString.UPLOADJCPDetail) {
                call = api.getUploadJCPDetail(jsonData);
            } else if (type == CommonString.UPLOADJsonDetail) {
                call = api.getUploadJsonDetail(jsonData);
            } else if (type == CommonString.COVERAGEStatusDetail) {
                call = api.getCoverageStatusDetail(jsonData);
            } else if (type == CommonString.CHECKOUTDetail) {
                call = api.getCheckout(jsonData);
            } else if (type == CommonString.CHECKOUTDetail_CLIENT) {
                call = api.getCheckoutClient(jsonData);
            } else if (type == CommonString.DELETE_COVERAGE) {
                call = api.deleteCoverageData(jsonData);
            } else if (type == CommonString.COVERAGE_NONWORKING) {
                call = api.setCoverageNonWorkingData(jsonData);
            } else if (type == CommonString.CHANGE_PASSWORD_SERVICE) {
                call = api.setNewPassword(jsonData);
            }


            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    ResponseBody responseBody = response.body();
                    String data = null;
                    if (responseBody != null && response.isSuccessful()) {
                        try {
                            data = response.body().string();
                            if (data.equalsIgnoreCase("")) {
                                data_global[0] = "";
                                isvalid = true;
                                status = 1;
                            } else {
                                data = data.substring(1, data.length() - 1).replace("\\", "");
                                data_global[0] = data;
                                isvalid = true;
                                status = 1;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            isvalid = true;
                            status = -2;
                        }
                    } else {
                        isvalid = true;
                        status = -1;
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    isvalid = true;
                    if (t instanceof SocketTimeoutException) {
                        status = 3;
                    } else if (t instanceof IOException) {
                        status = 3;
                    } else {
                        status = 3;
                    }

                }
            });

            while (isvalid == false) {
                synchronized (this) {
                    this.wait(25);
                }
            }
            if (isvalid) {
                synchronized (this) {
                    this.notify();
                }
            }
            if (status == 1) {
                return data_global[0];
            } else if (status == 2) {
                return CommonString.MESSAGE_NO_RESPONSE_SERVER;
            } else if (status == 3) {
                return CommonString.MESSAGE_SOCKETEXCEPTION;
            } else if (status == -2) {
                return CommonString.MESSAGE_INVALID_JSON;
            } else {
                return CommonString.KEY_FAILURE;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonString.KEY_FAILURE;
        }
    }


    public File saveBitmapToFileSmaller(File file) {
        File file2 = file;
        try {
            int inWidth = 0;
            int inHeight = 0;

            InputStream in = new FileInputStream(file2);
            // decode image size (decode metadata only, not the whole image)
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(in, null, options);
            in.close();
            in = null;

            // save width and height
            inWidth = options.outWidth;
            inHeight = options.outHeight;

            // decode full image pre-resized
            in = new FileInputStream(file2);
            options = new BitmapFactory.Options();
            // calc rought re-size (this is no exact resize)
            options.inSampleSize = Math.max(inWidth / 800, inHeight / 500);
            // decode full image
            Bitmap roughBitmap = BitmapFactory.decodeStream(in, null, options);

            // calc exact destination size
            Matrix m = new Matrix();
            RectF inRect = new RectF(0, 0, roughBitmap.getWidth(), roughBitmap.getHeight());
            RectF outRect = new RectF(0, 0, 800, 500);
            m.setRectToRect(inRect, outRect, Matrix.ScaleToFit.CENTER);
            float[] values = new float[9];
            m.getValues(values);
            // resize bitmap
            Bitmap resizedBitmap = Bitmap.createScaledBitmap(roughBitmap, (int) (roughBitmap.getWidth() * values[0]), (int) (roughBitmap.getHeight() * values[4]), true);
            // save image
            FileOutputStream out = new FileOutputStream(file2);
            resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);

        } catch (Exception e) {
            Log.e("Image", e.toString(), e);
            return file;
        }
        return file2;
    }


    public void UploadImageRecursive(final Context context) {
        try {
            String filename = null, foldername = null;
            int totalfiles = 0;
            File f = new File(CommonString.FILE_PATH);
            File file[] = f.listFiles();
            if (file.length > 0) {
                filename = "";
                totalfiles = f.listFiles().length;
                for (int i = 0; i < file.length; i++) {
                    if (new File(CommonString.FILE_PATH + file[i].getName()).exists()) {
                        if (file[i].getName().contains("_StoreImg-")) {
                            foldername = "CoverageImages";
                        } else if (file[i].getName().contains("_NONWORKING-")) {
                            foldername = "CoverageImages";
                        } else if (file[i].getName().contains("_GeoTag-")) {
                            foldername = "GeoTagImages";
                        } else if (file[i].getName().contains("_BACK_OF_STORE_CLOSEUPIMG_") || file[i].getName().contains("_BACK_OF_STORE_LONGSHOTIMG_")) {
                            foldername = "BackOfStoreImages";
                        } else if (file[i].getName().contains("_JAR_CLOSEUPIMG_") || file[i].getName().contains("_JAR_LONGSHOTIMG_")) {
                            foldername = "JarImages";
                        } else if (file[i].getName().contains("_MONKEY_SUN_CLOSEUPIMG_") || file[i].getName().contains("_MONKEY_SUN_LONGSHOTIMG_")) {
                            foldername = "MonkeysumImages";
                        } else if (file[i].getName().contains("_POSMIMG")) {
                            foldername = "PosmImages";
                        } else if (file[i].getName().contains("_VISI_COOLER_CLOSEUPIMG_") || file[i].getName().contains("_VISI_COOLER_LONGSHOTIMG_")) {
                            foldername = "VisicoolerImages";
                        } else if (file[i].getName().contains("_Window-") || file[i].getName().contains("_WINDOW_withGrid")) {
                            foldername = "WindowImages";
                        } else if (file[i].getName().contains("_Cat_Dressing-")) {
                            foldername = "DressingImage";
                        } else if (file[i].getName().contains("_Cat_dbsr-")) {
                            foldername = "DBSRCategoryImages";
                        } else if (file[i].getName().contains("_SOS_IMAGE-")) {
                            foldername = "SOSImages";
                        } else {

                            foldername = "BulkImages";
                        }
                        filename = file[i].getName();
                    }
                    break;
                }


                status = 0;
                File originalFile = new File(CommonString.FILE_PATH + filename);
                final File finalFile = saveBitmapToFileSmaller(originalFile);
                String date;
                if (false) {
                    date = getParsedDate(filename);
                } else {
                    date = this.date;
                }
                isvalid = false;

                OkHttpClient.Builder b = new OkHttpClient.Builder();
                b.connectTimeout(20, TimeUnit.SECONDS);
                b.readTimeout(20, TimeUnit.SECONDS);
                b.writeTimeout(20, TimeUnit.SECONDS);
                OkHttpClient client = b.build();
                pd.setMessage("uploading images (" + uploadedFiles + "/" + totalFiles + ")");
                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), finalFile);
                //com.squareup.okhttp3.RequestBody requestFile = com.squareup.okhttp.RequestBody.create(com.squareup.okhttp.MediaType.parse("application/octet-stream"), finalFile);
                // MultipartBody.Part body = MultipartBody.Part.createFormData("file", filename, requestFile);
                // MultipartBody.Part body = MultipartBody.Part.createFormData("file", filename, requestFile).createFormData("Foldername", foldername);
                //  RequestBody name = RequestBody.create(MediaType.parse("application/octet-stream"), "upload_test");
                // add another part within the multipart request
                body1 = new MultipartBody.Builder()
                        .setType(MediaType.parse("multipart/form-data"))
                        .addFormDataPart("file", finalFile.getName(), requestFile)
                        .addFormDataPart("Foldername", foldername)
                        .addFormDataPart("Path", date)
                        .build();

                /*body1 = new MultipartBuilder()
                        .type(MultipartBuilder.FORM)
                        .addFormDataPart("file", finalFile.getName(), requestFile)
                        .addFormDataPart("FolderName", foldername)
                        .build();*/
                adapter = new Retrofit.Builder()
                        .baseUrl(CommonString.URL3)
                        .addConverterFactory(new ToStringConverterFactory())
                        .client(client)
                        .build();

                PostApi api = adapter.create(PostApi.class);
                Call<String> observable = api.getUploadImage(body1);
                observable.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful() && response.body().contains("Success")) {
                            finalFile.delete();
                            uploadedFiles++;
                            status = 1;
                        } else {
                            status = 0;
                        }
                        if (status == 0) {
                            pd.dismiss();
                            if (!((Activity) context).isFinishing()) {
                                AlertandMessages.showAlert((Activity) context, "Image not uploaded." + "\n" + uploadedFiles + " images uploaded out of " + totalFiles, true);
                            }
                        } else {
                            UploadImageRecursive(context);
                        }

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        if (t instanceof IOException || t instanceof SocketTimeoutException || t instanceof SocketException) {
                            status = -1;
                            //uploadedFiles = 0;
                            pd.dismiss();
                            // AlertandMessages.showAlert((Activity) context, "Network Error in upload", false);
                            if (!((Activity) context).isFinishing()) {
                                AlertandMessages.showAlert((Activity) context, "Network Error in upload." + "\n" + uploadedFiles + " images uploaded out of " + totalFiles, true);
                            } else {

                            }
                        }

                    }
                });

            } else {
                if (totalFiles == uploadedFiles) {
                    //region Coverage upload status Data
                    new StatusUpload(this.date).execute();
                    //endregion
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String getParsedDate(String filename) {
        String testfilename = filename;
        testfilename = testfilename.substring(testfilename.indexOf("-") + 1);
        testfilename = testfilename.substring(0, testfilename.indexOf("-"));
        return testfilename;
    }

    public void UploadImageFileJsonList(final Context context, final String coverageDate) {
        try {
            String filename = null, foldername = null;
            int totalfiles = 0;
            String jsonString;
            File f = new File(CommonString.FILE_PATH);
            File file[] = f.listFiles();
            JSONObject list = new JSONObject();
            filename = "";
            totalfiles = f.listFiles().length;
            if (totalfiles == 0) {
                list.put("[ 0 ]", "no files");
            } else {
                for (int i = 0; i < file.length; i++) {
                    list.put("[" + i + "]", file[i].getName());
                }
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("MID", "0");
            jsonObject.put("Keys", "FileList");
            jsonObject.put("JsonData", list.toString());
            jsonObject.put("UserId", _UserId);
            jsonString = jsonObject.toString();
            status = 0;
            isvalid = false;

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .build();

            RequestBody jsonData = RequestBody.create(MediaType.parse("application/json"), jsonString);
            adapter = new Retrofit.Builder().baseUrl(CommonString.URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            PostApi api = adapter.create(PostApi.class);
            Call<JSONObject> observable = api.getUploadJsonDetailForFileList(jsonData);
            observable.enqueue(new Callback<JSONObject>() {
                @Override
                public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                    uploadImage(coverageDate);
                    if (response.isSuccessful() && response.message().equalsIgnoreCase("OK")) {
                        isvalid = true;
                        status = 1;
                    } else {
                        isvalid = true;
                        status = 0;
                    }
                }

                @Override
                public void onFailure(Call<JSONObject> call, Throwable t) {
                    isvalid = true;
                    uploadImage(coverageDate);
                    // Toast.makeText(context, finalFile.getName() + " not uploaded", Toast.LENGTH_SHORT).show();
                    if (t instanceof IOException || t instanceof SocketTimeoutException || t instanceof SocketException) {
                        status = -1;
                        // AlertandMessages.showAlert((Activity) context, "Error in FileList upload", false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadDataWithoutWait(final ArrayList<String> keyList, final int keyIndex, final ArrayList<CoverageBean> coverageList, final int coverageIndex) {

        try {
            status = 0;
            isvalid = false;
            final String[] data_global = {""};
            String jsonString = "";
            int type = 0;

            JSONObject jsonObject, jsonObject1, jsonObject2,jsonObject3,jsonObject4;

            //region Creating json data
            switch (keyList.get(keyIndex)) {
                case "CoverageDetail_latest":
                    //region Coverage Data
                    db.open();
                    jsonObject = new JSONObject();
                    jsonObject.put("StoreId", coverageList.get(coverageIndex).getStoreId());
                    jsonObject.put("VisitDate", coverageList.get(coverageIndex).getVisitDate());
                    jsonObject.put("Latitude", coverageList.get(coverageIndex).getLatitude());
                    jsonObject.put("Longitude", coverageList.get(coverageIndex).getLongitude());
                    jsonObject.put("ReasonId", coverageList.get(coverageIndex).getReasonid());
                    jsonObject.put("SubReasonId", "0");
                    jsonObject.put("Remark", "");
                    jsonObject.put("ImageName", coverageList.get(coverageIndex).getImage());
                    jsonObject.put("AppVersion", app_ver);
                    jsonObject.put("UploadStatus", CommonString.KEY_P);
                    jsonObject.put("Checkout_Image", coverageList.get(coverageIndex).getCkeckout_image());
                    jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());

                    jsonString = jsonObject.toString();
                    type = CommonString.COVERAGE_DETAIL;
                    //endregion
                    break;

                case "Store_Profile":
                    //region Coverage Data
                    db.open();
                    StoreProfileGetterSetter storePGT = db.getStoreProfileData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    if (storePGT.getStore_type_cd() != null && !storePGT.getStore_type_cd().equals("")) {
                        JSONArray storeDetail = new JSONArray();
                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());
                        jsonObject.put("Store_Type_cd", storePGT.getStore_type_cd());
                        jsonObject.put("Store_Name", storePGT.getStore_name());
                        jsonObject.put("Visit_date", storePGT.getStore_visit_date());
                        jsonObject.put("Address", storePGT.getStore_addres());
                        jsonObject.put("City", storePGT.getStore_city());
                        storeDetail.put(jsonObject);
                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "STORE_PROFILE_DATA");
                        jsonObject.put("JsonData", storeDetail.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());
                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;

                case "FeedBack_Data":
                    //region Coverage Data
                    db.open();
                    ArrayList<ChecklistMaster> checklistQuestions = db.getSavedFeedBackData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    if (checklistQuestions.size() > 0) {
                        JSONArray feedBackArray = new JSONArray();
                        for (int i = 0; i < checklistQuestions.size(); i++) {
                            jsonObject = new JSONObject();
                            jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                            jsonObject.put("User_Id", _UserId);
                            jsonObject.put(CommonString.KEY_STORE_ID, checklistQuestions.get(i).getStore_Id());
                            jsonObject.put(CommonString.KEY_CHECKLIST_ID, checklistQuestions.get(i).getChecklistId());
                            jsonObject.put(CommonString.KEY_ANSWER_ID, checklistQuestions.get(i).getCorrectAnswer_Id());
                            feedBackArray.put(jsonObject);
                        }

                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "FeedBack_Data");
                        jsonObject.put("JsonData", feedBackArray.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());

                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }

                    //endregion
                    break;


                // StoreProfileGetterSetter storePGT;/
                case "Window_Data":
                    //region Window_Data
                    db.open();
                    String presentValue = "";
                    ArrayList<WindowMaster> windowMasterList = db.getWindowInsertedData(Integer.parseInt(coverageList.get(coverageIndex).getStoreId()), coverageList.get(coverageIndex).getVisitDate());
                    if (windowMasterList.size() > 0) {
                        JSONArray windowArray = new JSONArray();
                        for (int j = 0; j < windowMasterList.size(); j++) {

                            //Window Checklist
                            JSONArray checklistArray = new JSONArray();
                            ArrayList<BrandMaster> brandList = windowMasterList.get(j).getBrandList();
                            JSONArray brandArray = new JSONArray();
                            JSONArray brandCheckListArray = new JSONArray();

                            if (windowMasterList.get(j).getAnswered_id() == 1) {
                                ArrayList<ChecklistMaster> windowCheckListData = db.getWindowCheckListInsertedData(windowMasterList.get(j).getKey_Id());
                                if (windowCheckListData.size() > 0) {
                                    for (int k = 0; k < windowCheckListData.size(); k++) {
                                        JSONObject obj = new JSONObject();
                                        obj.put(CommonString.KEY_COMMON_ID, windowMasterList.get(j).getKey_Id());
                                        obj.put("Window_Cd", windowMasterList.get(j).getWindowId());
                                        obj.put("Checklist_Id", windowCheckListData.get(k).getChecklistId());
                                        obj.put("Checklist_Answer", windowCheckListData.get(k).getAnswered_cd());
                                        checklistArray.put(obj);

                                    }
                                }

                                //Brand List
                                for (int b = 0; b < brandList.size(); b++) {
                                    JSONObject brandObj = new JSONObject();
                                    brandObj.put(CommonString.KEY_COMMON_ID, windowMasterList.get(j).getKey_Id());
                                    brandObj.put("Window_Cd", windowMasterList.get(j).getWindowId());
                                    brandObj.put(CommonString.KEY_BRAND_ID, brandList.get(b).getBrandId());
                                    brandObj.put(CommonString.KEY_QUANTITY, brandList.get(b).getQuantity());
                                    brandObj.put("Brand_Common_Id", brandList.get(b).getKey_Id());

                                    ArrayList<ChecklistMaster> brandCheckList = windowMasterList.get(j).getHashMapListChildData().get(brandList.get(b));

                                    //JSONArray brandCheckListArray = new JSONArray();

                                    for (int ch = 0; ch < brandCheckList.size(); ch++) {
                                        JSONObject brandChecklistObj = new JSONObject();
                                        brandObj.put("Window_Cd", windowMasterList.get(j).getWindowId());
                                        brandChecklistObj.put("Brand_Common_Id", brandList.get(b).getKey_Id());
                                        brandChecklistObj.put(CommonString.KEY_BRAND_ID, brandList.get(b).getBrandId());
                                        brandChecklistObj.put("Checklist_Id", brandCheckList.get(ch).getChecklistId());
                                        brandChecklistObj.put("Checklist_Answer", brandCheckList.get(ch).getAnswered_cd());
                                        brandCheckListArray.put(brandChecklistObj);
                                    }
                                    //brandObj.put("Brand_CheckList", brandCheckListArray);
                                    brandArray.put(brandObj);
                                }
                            }


                            JSONObject obj = new JSONObject();
                            obj.put("MID", coverageList.get(coverageIndex).getMID());
                            obj.put("UserId", coverageList.get(coverageIndex).getUserId());
                            obj.put(CommonString.KEY_COMMON_ID, windowMasterList.get(j).getKey_Id());
                            obj.put("Window_Cd", windowMasterList.get(j).getWindowId());
                            obj.put("Window_Exist", windowMasterList.get(j).getAnswered_id());
                            obj.put("Window_Img_CloseUp", windowMasterList.get(j).getImg_close_up());
                            obj.put("Window_Img_LongShot", windowMasterList.get(j).getImg_long_shot());
                            obj.put("Reason_Cd", windowMasterList.get(j).getNonExecutionReasonId());
                            if (windowMasterList.get(j).getAnswered_id() == 1) {
                                obj.put("Window_CheckList", checklistArray);
                                obj.put("Brand_Data", brandArray);
                                obj.put("Brand_Data", brandCheckListArray);
                            } else {
                                obj.put("Window_CheckList", "");
                                obj.put("Brand_Data", "");
                                obj.put("Brand_Data", "");
                            }
                            windowArray.put(obj);

                        }

                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "Window_Data");
                        jsonObject.put("JsonData", windowArray.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());

                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;


                case "SOS_Data":
                    //region Coverage Data
                    db.open();

                    List<CategoryMaster> listDataHeader = db.getSavedSOSHeaderData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());

                    if (listDataHeader.size() > 0) {
                        JSONArray headerArray = new JSONArray();
                        JSONArray childArray = new JSONArray();
                        JSONArray questionArray = new JSONArray();
                        jsonObject3 = new JSONObject();
                        for (int i = 0; i < listDataHeader.size(); i++) {
                            jsonObject = new JSONObject();
                            jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                            jsonObject.put("User_Id", _UserId);
                            jsonObject.put(CommonString.KEY_STORE_ID, listDataHeader.get(i).getStore_id());
                            jsonObject.put(CommonString.KEY_CATEGORY_ID, listDataHeader.get(i).getCategoryId());
                            jsonObject.put(CommonString.KEY_CATEGORY_FACING, listDataHeader.get(i).getCategory_Facing());
                            jsonObject.put(CommonString.KEY_CATEGORY_IMAGE, listDataHeader.get(i).getCategory_Image());

                            ArrayList<CategoryMaster> brandData = db.getSavedSOSInsertedChildData(listDataHeader.get(i).getCategoryId(), coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());

                            if(brandData.size() >0) {

                                for (int j = 0; j < brandData.size(); j++) {
                                    jsonObject1 = new JSONObject();
                                    jsonObject1.put("MID", coverageList.get(coverageIndex).getMID());
                                    jsonObject1.put("User_Id", _UserId);
                                    jsonObject1.put(CommonString.KEY_CATEGORY_ID, brandData.get(j).getCategoryId());
                                    jsonObject1.put(CommonString.KEY_BRAND_ID, brandData.get(j).getBrand_Id());
                                    jsonObject1.put(CommonString.KEY_BRAND_FACING, brandData.get(j).getBrand_Facing());


                                    if(brandData.get(j).getChecklistQuestions().size() >0){

                                        for (int k = 0; k < brandData.get(j).getChecklistQuestions().size(); k++) {
                                            jsonObject2 = new JSONObject();
                                            jsonObject2.put("MID", coverageList.get(coverageIndex).getMID());
                                            jsonObject2.put("User_Id", _UserId);
                                            jsonObject2.put(CommonString.KEY_CATEGORY_ID, brandData.get(j).getChecklistQuestions().get(k).getCategory_Id());
                                            jsonObject2.put(CommonString.KEY_BRAND_ID, brandData.get(j).getChecklistQuestions().get(k).getBrand_Id());
                                            jsonObject2.put(CommonString.KEY_CHECKLIST_ID, brandData.get(j).getChecklistQuestions().get(k).getChecklistId());
                                            jsonObject2.put(CommonString.KEY_ANSWER_ID, brandData.get(j).getChecklistQuestions().get(k).getCorrectAnswer_Id());
                                            questionArray.put(jsonObject2);
                                        }
                                    }

                                    childArray.put(jsonObject1);
                                }
                            }

                            headerArray.put(jsonObject);
                        }
                        jsonObject3.put(CommonString.KEY_CATEGORY_DATA, headerArray);
                        jsonObject3.put(CommonString.KEY_BRAND_DATA,childArray);
                        jsonObject3.put(CommonString.KEY_CHCECKLIST_DATA,questionArray);

                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "SOS_Data");
                        jsonObject.put("JsonData", jsonObject3.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());

                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }

                    //endregion
                    break;


                case "Category_Dressing_data":
                    //region Category_Dressing_data
                    db.open();
                    String presentCategoryValue = "";
                    ArrayList<CategoryMaster> categoryMasterList = db.getCategoryDressingData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    if (categoryMasterList.size() > 0) {
                        JSONArray compArray = new JSONArray();
                        for (int j = 0; j < categoryMasterList.size(); j++) {
                            JSONArray checklistArray = new JSONArray();
                            if (categoryMasterList.get(j).isExist()) {
                                presentCategoryValue = "1";
                            } else {
                                presentCategoryValue = "0";
                            }
                            if (presentCategoryValue.equals("1")) {
                                ArrayList<ChecklistGetterSetter> categoryCheckListData = db.getCategoryDressingCheckListData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate(), categoryMasterList.get(j).getKey_Id());
                                if (categoryCheckListData.size() > 0) {
                                    for (int k = 0; k < categoryCheckListData.size(); k++) {
                                        JSONObject obj = new JSONObject();
                                        obj.put("Key_Id", categoryCheckListData.get(k).getCOMMON_ID());
                                        obj.put("Category_Id", categoryCheckListData.get(k).getWINDOW_CD());
                                        obj.put("Checklist_Id", categoryCheckListData.get(k).getCHECKLIST_CD());
                                        obj.put("Checklist_Answer", categoryCheckListData.get(k).getANSWER_CD());
                                        checklistArray.put(obj);

                                    }
                                }
                            }

                            JSONObject obj = new JSONObject();
                            obj.put("MID", coverageList.get(coverageIndex).getMID());
                            obj.put("UserId", coverageList.get(coverageIndex).getUserId());
                            obj.put("Key_Id", categoryMasterList.get(j).getKey_Id());
                            obj.put("Category_Id", categoryMasterList.get(j).getCategoryId());
                            obj.put("Category_Exist", presentCategoryValue);
                            obj.put("Category_Img", categoryMasterList.get(j).getImage());
                            obj.put("Reason_Cd", categoryMasterList.get(j).getReasonId());
                            if (presentCategoryValue.equals("1")) {
                                obj.put("CHECKLIST", checklistArray);
                            } else {
                                obj.put("CHECKLIST", "");
                            }
                            compArray.put(obj);
                        }

                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "Category_Dressing_Data");
                        jsonObject.put("JsonData", compArray.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());

                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;
                case "Category_DBSR_data":
                    //region Category_DBSR_data
                    db.open();
                    ArrayList<CategoryMaster> categoryDbsrList = db.getCategoryDBSRSavedData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    if (categoryDbsrList.size() > 0) {
                        JSONArray compArray = new JSONArray();
                        for (int j = 0; j < categoryDbsrList.size(); j++) {
                            if (categoryDbsrList.get(j).isExist()) {
                                presentCategoryValue = "1";
                            } else {
                                presentCategoryValue = "0";
                            }

                            JSONObject obj = new JSONObject();
                            obj.put("MID", coverageList.get(coverageIndex).getMID());
                            obj.put("UserId", coverageList.get(coverageIndex).getUserId());
                            obj.put("Key_Id", categoryDbsrList.get(j).getKey_Id());
                            obj.put("Category_Id", categoryDbsrList.get(j).getCategoryId());
                            obj.put("Category_Exist", presentCategoryValue);
                            obj.put("Category_Img", categoryDbsrList.get(j).getImage());
                            compArray.put(obj);
                        }

                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "Category_DBSR_data");
                        jsonObject.put("JsonData", compArray.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());

                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;
                case "GeoTag":
                    //region GeoTag
                    ArrayList<GeotaggingBeans> geotaglist = db.getinsertGeotaggingData(coverageList.get(coverageIndex).getStoreId(), "N");
                    if (geotaglist.size() > 0) {
                        JSONArray topUpArray = new JSONArray();
                        for (int j = 0; j < geotaglist.size(); j++) {
                            JSONObject obj = new JSONObject();
                            obj.put(CommonString.KEY_STORE_ID, geotaglist.get(j).getStoreid());
                            obj.put(CommonString.KEY_VISIT_DATE, coverageList.get(coverageIndex).getVisitDate());
                            obj.put(CommonString.KEY_LATITUDE, geotaglist.get(j).getLatitude());
                            obj.put(CommonString.KEY_LONGITUDE, geotaglist.get(j).getLongitude());
                            obj.put("FRONT_IMAGE", geotaglist.get(j).getImage());
                            topUpArray.put(obj);
                        }

                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "GeoTag");
                        jsonObject.put("JsonData", topUpArray.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());

                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;

                case "Focus_Product":
                    db.open();
                    //String jsonString = null;
                    ArrayList<FocusProductGetterSetter> salesEntry = db.getFocusProductUploadData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    if (salesEntry.size() > 0) {
                        JSONArray promoArray = new JSONArray();
                        for (int j = 0; j < salesEntry.size(); j++) {
                            JSONObject obj = new JSONObject();
                            obj.put("MID", coverageList.get(coverageIndex).getMID());
                            obj.put("UserId", coverageList.get(coverageIndex).getUserId());
                            obj.put("SKU_CD", salesEntry.get(j).getSku_id());
                            obj.put("STOCK", salesEntry.get(j).getStock());

                            promoArray.put(obj);
                        }

                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "FOCUS_PRODUCT_DATA");
                        jsonObject.put("JsonData", promoArray.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());
                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;

                case "Visicooler":
                    db.open();
                    ArrayList<VisiColoersGetterSetter> visiColoerHeader = db.getVisicoolerUploadData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    JSONArray promoArray = new JSONArray();
                    if (visiColoerHeader.size() > 0) {
                        promoArray = new JSONArray();
                        for (int j = 0; j < visiColoerHeader.size(); j++) {
                            JSONObject obj = new JSONObject();
                            obj.put("MID", coverageList.get(coverageIndex).getMID());
                            obj.put("UserId", coverageList.get(coverageIndex).getUserId());
                            obj.put("CHEKLIST_ID", visiColoerHeader.get(j).getCheklist_cd());
                            obj.put("ANSWER_ID", visiColoerHeader.get(j).getAnswer_cd());
                            obj.put("STORE_ID", visiColoerHeader.get(j).getStore_id());
                            promoArray.put(obj);
                        }
                    }
                    VisiColoersGetterSetter visicooler = db.getVisicoolerHeaderUploadData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());

                    if (visicooler.getPresent_name() != null && !visicooler.getPresent_name().equals("")) {
                        JSONArray storeDetail = new JSONArray();
                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());
                        jsonObject.put("present", visicooler.getPresent_name());
                        jsonObject.put("Reason_cd", visicooler.getReason_cd());
                        jsonObject.put("long_shot_image", visicooler.getImage_long_shot());
                        jsonObject.put("close_ip_image", visicooler.getImage_close_up());
                        jsonObject.put("STORE_ID", visicooler.getStore_id());
                        if (visicooler.getPresent_name().equalsIgnoreCase("1")) {
                            jsonObject.put("CHEKLIST_DATA", promoArray);

                        } else {
                            jsonObject.put("CHEKLIST_DATA", "");

                        }

                        storeDetail.put(jsonObject);
                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "VISICOOLER_DATA");
                        jsonObject.put("JsonData", storeDetail.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());
                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;

                case "MonkeySun":
                    db.open();
                    ArrayList<VisiColoersGetterSetter> moky_sun = db.getMonkeysunUploadData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    JSONArray monkysunArray = new JSONArray();
                    if (moky_sun.size() > 0) {
                        monkysunArray = new JSONArray();
                        for (int j = 0; j < moky_sun.size(); j++) {
                            JSONObject obj = new JSONObject();
                            obj.put("MID", coverageList.get(coverageIndex).getMID());
                            obj.put("UserId", coverageList.get(coverageIndex).getUserId());
                            obj.put("CHEKLIST_CD", moky_sun.get(j).getCheklist_cd());
                            obj.put("ANSWER_ID", moky_sun.get(j).getAnswer_cd());
                            obj.put("STORE_ID", moky_sun.get(j).getStore_id());
                            monkysunArray.put(obj);
                        }
                    }
                    VisiColoersGetterSetter monky_sun_header = db.getMonkyHeaderUploadData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());

                    if (monky_sun_header.getPresent_name() != null && !monky_sun_header.getPresent_name().equals("")) {
                        JSONArray storeDetail = new JSONArray();
                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());
                        jsonObject.put("present", monky_sun_header.getPresent_name());
                        jsonObject.put("Reason_cd", monky_sun_header.getReason_cd());
                        jsonObject.put("long_shot_image", monky_sun_header.getImage_long_shot());
                        jsonObject.put("close_ip_image", monky_sun_header.getImage_close_up());
                        jsonObject.put("STORE_ID", monky_sun_header.getStore_id());
                        if (monky_sun_header.getPresent_name().equalsIgnoreCase("1")) {
                            jsonObject.put("CHEKLIST_DATA", monkysunArray);

                        } else {
                            jsonObject.put("CHEKLIST_DATA", "");

                        }
                        storeDetail.put(jsonObject);
                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "MONKEY_SUN_DATA");
                        jsonObject.put("JsonData", storeDetail.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());
                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;

                case "jar":
                    db.open();
                    ArrayList<JarGetterSetter> jor_ = db.getJorChildUploadData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    JSONArray jorArray = new JSONArray();
                    if (jor_.size() > 0) {
                        jorArray = new JSONArray();
                        for (int j = 0; j < jor_.size(); j++) {
                            JSONObject obj = new JSONObject();
                            obj.put("MID", coverageList.get(coverageIndex).getMID());
                            obj.put("UserId", coverageList.get(coverageIndex).getUserId());
                            obj.put("CHEKLIST_CD", (jor_.get(j).getCheklist_cd()));
                            obj.put("ANSWER_ID", jor_.get(j).getAnswer_cd());
                            obj.put("STORE_ID", jor_.get(j).getStore_id());
                            jorArray.put(obj);
                        }
                    }
                    JarGetterSetter jor_header = db.getJorHeaderUploadData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());

                    if (jor_header.getPresent_name() != null && !jor_header.getPresent_name().equals("")) {
                        JSONArray storeDetail = new JSONArray();
                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());
                        jsonObject.put("present", jor_header.getPresent_name());
                        jsonObject.put("long_shot_image", jor_header.getImage_long_shot());
                        jsonObject.put("close_ip_image", jor_header.getImage_close_up());
                        jsonObject.put("STORE_ID", jor_header.getStore_id());
                        if (jor_header.getPresent_name().equalsIgnoreCase("1")) {
                            jsonObject.put("CHEKLIST_DATA", jorArray);

                        } else {
                            jsonObject.put("CHEKLIST_DATA", "");

                        }

                        storeDetail.put(jsonObject);
                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "JAR_DATA");
                        jsonObject.put("JsonData", storeDetail.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());
                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;

                case "POSM":

                    db.open();
                    ArrayList<CommonChillerDataGetterSetter> posmData = db.getPOSMDeploymentSavedData(Integer.valueOf(coverageList.get(coverageIndex).getStoreId()), coverageList.get(coverageIndex).getVisitDate());
                    if (posmData.size() > 0) {
                        JSONArray posmDetails = new JSONArray();
                        for (int i = 0; i < posmData.size(); i++) {
                            jsonObject = new JSONObject();
                            jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                            jsonObject.put("User_Id", _UserId);
                            jsonObject.put("STORE_ID", posmData.get(i).getStore_id());
                            jsonObject.put(CommonString.KEY_EXIST, posmData.get(i).getExist());
                            jsonObject.put(CommonString.KEY_IMAGE, posmData.get(i).getImg1());
                            jsonObject.put(CommonString.KEY_POSM_ID, posmData.get(i).getPosm_id());
                            if (posmData.get(i).getReason_id().equalsIgnoreCase("")) {
                                jsonObject.put(CommonString.KEY_REASON_ID, "0");
                            } else {
                                jsonObject.put(CommonString.KEY_REASON_ID, posmData.get(i).getReason_id());
                            }
                            jsonObject.put(CommonString.KEY_VISIT_DATE, posmData.get(i).getVisit_date());
                            posmDetails.put(jsonObject);
                        }

                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "POSM_DATA");
                        jsonObject.put("JsonData", posmDetails.toString());
                        jsonObject.put("UserId", _UserId);

                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;

                    }
                    break;
                case "BACK_OF_STORE_DATA":

                    db.open();
                    BackofStoreGetterSetter backof_office = db.getBackofStoreUploadImgData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    JSONArray topheaderArray = new JSONArray();
                    JSONArray headerArray = new JSONArray();
                    JSONArray childArray = new JSONArray();
                    if (backof_office.getPresent_name() != null && !backof_office.getPresent_name().equals("")) {
                        if (backof_office.getPresent_name().equalsIgnoreCase("1")) {
                            ArrayList<BackofStoreGetterSetter> listDataHeader1 = db.getHeaderBackOfStoreUploadData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                            if (listDataHeader1.size() > 0) {
                                for (int i = 0; i < listDataHeader1.size(); i++) {
                                    jsonObject = new JSONObject();
                                    jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                                    jsonObject.put("UserId", _UserId);
                                    jsonObject.put("BRAND_ID", listDataHeader1.get(i).getBrand_id());
                                    jsonObject.put("STOCK", listDataHeader1.get(i).getStock());
                                    jsonObject.put("KEY_Id", listDataHeader1.get(i).getKey_id());


                                    ArrayList<BackofStoreGetterSetter> brandData = db.getBackOfStoreChildUploadData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate(), listDataHeader1.get(i).getKey_id());
                                        for (int j = 0; j < brandData.size(); j++) {
                                            jsonObject1 = new JSONObject();
                                            jsonObject1.put("MID", coverageList.get(coverageIndex).getMID());
                                            jsonObject1.put("UserId", _UserId);
                                            jsonObject1.put("ANSWER_ID", brandData.get(j).getReasonId());
                                            jsonObject1.put("CHEKLIST_ID", brandData.get(j).getChecklist_id());
                                            jsonObject1.put("BRAND_ID", listDataHeader1.get(i).getBrand_id());
                                            jsonObject1.put("KEY_Id", brandData.get(j).getCommon_id());

                                            childArray.put(jsonObject1);
                                        }

                                        headerArray.put(jsonObject);
                                }

                                jsonObject3 = new JSONObject();
                                jsonObject3.put("MID", coverageList.get(coverageIndex).getMID());
                                jsonObject3.put("UserId", coverageList.get(coverageIndex).getUserId());
                                jsonObject3.put("present", backof_office.getPresent_name());
                                jsonObject3.put("long_shot_image", backof_office.getImage_long_shot());
                                jsonObject3.put("close_ip_image", backof_office.getImage_close_up());
                                jsonObject3.put("STORE_ID", backof_office.getStore_id());

                                jsonObject4 = new JSONObject();
                                jsonObject4.put("BACK_OF_STORE_DETAILS",jsonObject3);
                                jsonObject4.put("BRAND_DATA", headerArray);
                                jsonObject4.put("CHEKLIST_DATA",childArray);

                                jsonObject = new JSONObject();
                                jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                                jsonObject.put("Keys", "BACK_OF_STORE_DATA");
                                jsonObject.put("JsonData", jsonObject4.toString());
                                jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());

                                jsonString = jsonObject.toString();
                                type = CommonString.UPLOADJsonDetail;
                            }

                        } else {
                            jsonObject = new JSONObject();
                            jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                            jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());
                            jsonObject.put("present", backof_office.getPresent_name());
                            jsonObject.put("long_shot_image", backof_office.getImage_long_shot());
                            jsonObject.put("close_ip_image", backof_office.getImage_close_up());
                            jsonObject.put("STORE_ID", backof_office.getStore_id());
                            jsonObject.put("BRAND_DATA", "");
                            jsonObject.put("CHEKLIST_DATA", "");

                            jsonObject4 = new JSONObject();
                            jsonObject4.put("BACK_OF_STORE_DETAILS",jsonObject);
                            jsonObject = new JSONObject();
                            jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                            jsonObject.put("Keys", "BACK_OF_STORE_DATA");
                            jsonObject.put("JsonData", jsonObject4.toString());
                            jsonObject.put("UserId", _UserId);

                            jsonString = jsonObject.toString();
                            type = CommonString.UPLOADJsonDetail;
                        }
                    }

                    break;

                case "CTU_Data":
                    //region CTU_Data
                    db.open();

                    ArrayList<BrandMaster> brandList = db.getCTUInsertedData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    if (brandList.size() > 0) {
                        JSONArray compArray = new JSONArray();
                        for (int j = 0; j < brandList.size(); j++) {

                            //Brand Checklist
                            JSONArray checklistArray = new JSONArray();

                            if (brandList.get(j).getAnswered_id() == 1) {

                                ArrayList<ChecklistMaster> brandListCheckListData = db.getCTUCheckListInsertedData(brandList.get(j));
                                if (brandListCheckListData.size() > 0) {
                                    for (int k = 0; k < brandListCheckListData.size(); k++) {
                                        JSONObject obj = new JSONObject();
                                        obj.put(CommonString.KEY_COMMON_ID, brandList.get(j).getKey_Id());
                                        obj.put(CommonString.KEY_BRAND_ID, brandList.get(j).getBrandId());
                                        obj.put("Checklist_Id", brandListCheckListData.get(k).getChecklistId());
                                        obj.put("Checklist_Answer", brandListCheckListData.get(k).getAnswered_cd());
                                        checklistArray.put(obj);

                                    }
                                }
                            }

                            JSONObject obj = new JSONObject();
                            obj.put("MID", coverageList.get(coverageIndex).getMID());
                            obj.put("UserId", coverageList.get(coverageIndex).getUserId());
                            obj.put(CommonString.KEY_COMMON_ID, brandList.get(j).getKey_Id());
                            obj.put(CommonString.KEY_BRAND_ID, brandList.get(j).getBrandId());
                            obj.put("Brand_Exist", brandList.get(j).getAnswered_id());
                            obj.put("Brand_Img_CloseUp", brandList.get(j).getImg_close_up());
                            obj.put("Brand_Img_LongShot", brandList.get(j).getImg_long_shot());
                            obj.put("Reason_Cd", brandList.get(j).getNonExecutionReasonId());
                            if (brandList.get(j).getAnswered_id() == 1) {
                                obj.put("Brand_CheckList", checklistArray);
                            } else {
                                obj.put("Brand_CheckList", "");
                            }
                            compArray.put(obj);

                        }

                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "CTU_Data");
                        jsonObject.put("JsonData", compArray.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());

                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;

                case "Secondary_Visibility_Data":
                    //region Display_Data
                    db.open();

                    ArrayList<DisplayMaster> displayList = db.getSecondaryVisibilityInsertedData(coverageList.get(coverageIndex).getStoreId(), coverageList.get(coverageIndex).getVisitDate());
                    if (displayList.size() > 0) {
                        JSONArray compArray = new JSONArray();
                        for (int j = 0; j < displayList.size(); j++) {

                            //Display Checklist
                            JSONArray checklistArray = new JSONArray();

                            if (displayList.get(j).getAnswered_id() == 1) {

                                ArrayList<ChecklistMaster> displayListCheckListData = db.getSecondaryVisibilityCheckListInsertedData(displayList.get(j));
                                if (displayListCheckListData.size() > 0) {
                                    for (int k = 0; k < displayListCheckListData.size(); k++) {
                                        JSONObject obj = new JSONObject();
                                        obj.put(CommonString.KEY_COMMON_ID, displayList.get(j).getKey_Id());
                                        obj.put(CommonString.KEY_DISPLAY_ID, displayList.get(j).getDisplayId());
                                        obj.put("Checklist_Id", displayListCheckListData.get(k).getChecklistId());
                                        obj.put("Checklist_Answer", displayListCheckListData.get(k).getAnswered_cd());
                                        checklistArray.put(obj);

                                    }
                                }
                            }

                            JSONObject obj = new JSONObject();
                            obj.put("MID", coverageList.get(coverageIndex).getMID());
                            obj.put("UserId", coverageList.get(coverageIndex).getUserId());
                            obj.put(CommonString.KEY_COMMON_ID, displayList.get(j).getKey_Id());
                            obj.put(CommonString.KEY_DISPLAY_ID, displayList.get(j).getDisplayId());
                            obj.put("Display_Exist", displayList.get(j).getAnswered_id());
                            obj.put("Display_Img_One", displayList.get(j).getImg_close_up());
                            obj.put("Display_Img_Two", displayList.get(j).getImg_long_shot());
                            obj.put("Display_Stock", displayList.get(j).getQuantity());

                            if (displayList.get(j).getAnswered_id() == 1) {
                                obj.put("Display_CheckList", checklistArray);
                            } else {
                                obj.put("Display_CheckList", "");
                            }
                            compArray.put(obj);

                        }

                        jsonObject = new JSONObject();
                        jsonObject.put("MID", coverageList.get(coverageIndex).getMID());
                        jsonObject.put("Keys", "Secondary_Visibility_Data");
                        jsonObject.put("JsonData", compArray.toString());
                        jsonObject.put("UserId", coverageList.get(coverageIndex).getUserId());

                        jsonString = jsonObject.toString();
                        type = CommonString.UPLOADJsonDetail;
                    }
                    //endregion
                    break;
            }
            //endregion

            final int[] finalJsonIndex = {keyIndex};
            final String finalKeyName = keyList.get(keyIndex);

            if (jsonString != null && !jsonString.equalsIgnoreCase("")) {

                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .readTimeout(20, TimeUnit.SECONDS)
                        .writeTimeout(20, TimeUnit.SECONDS)
                        .connectTimeout(20, TimeUnit.SECONDS)
                        .build();

                pd.setMessage("Uploading (" + keyIndex + "/" + keyList.size() + ") \n" + keyList.get(keyIndex) + "\n Store uploading " + (coverageIndex + 1) + "/" + coverageList.size());
                RequestBody jsonData = RequestBody.create(MediaType.parse("application/json"), jsonString);
                adapter = new Retrofit.Builder().baseUrl(CommonString.URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
                PostApi api = adapter.create(PostApi.class);
                Call<ResponseBody> call = null;

                if (type == CommonString.COVERAGE_DETAIL) {
                    call = api.getCoverageDetail(jsonData);
                } else if (type == CommonString.UPLOADJsonDetail) {
                    call = api.getUploadJsonDetail(jsonData);
                }


                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        ResponseBody responseBody = response.body();
                        String data = null;
                        if (responseBody != null && response.isSuccessful()) {
                            try {
                                data = response.body().string();
                                if (data.equalsIgnoreCase("")) {
                                    data_global[0] = "";
                                    AlertandMessages.showAlert((Activity) context, "Invalid Data : problem occured at " + keyList.get(keyIndex), true);
                                } else {
                                    data = data.substring(1, data.length() - 1).replace("\\", "");
                                    data_global[0] = data;

                                    if (finalKeyName.equalsIgnoreCase("CoverageDetail_latest")) {
                                        try {
                                            coverageList.get(coverageIndex).setMID(Integer.parseInt(data_global[0]));
                                        } catch (NumberFormatException ex) {
                                            AlertandMessages.showAlert((Activity) context, "Error in Uploading Data at " + finalKeyName, true);
                                        }
                                    } else if (data_global[0].contains(CommonString.KEY_SUCCESS)) {

                                        if (finalKeyName.equalsIgnoreCase("GeoTag")) {
                                            db.open();
                                            db.updateInsertedGeoTagStatus(coverageList.get(coverageIndex).getStoreId(), CommonString.KEY_Y);
                                            db.updateStatus(coverageList.get(coverageIndex).getStoreId(), CommonString.KEY_Y);
                                        }
                                    } else {
                                        AlertandMessages.showAlert((Activity) context, "Error in Uploading Data at " + finalKeyName + " : " + data_global[0], true);
                                    }


                                    finalJsonIndex[0]++;
                                    if (finalJsonIndex[0] != keyList.size()) {
                                        uploadDataWithoutWait(keyList, finalJsonIndex[0], coverageList, coverageIndex);
                                    } else {
                                        pd.setMessage("updating status :" + coverageIndex);
                                        //uploading status D for current store from coverageList
                                        updateStatus(coverageList, coverageIndex, CommonString.KEY_D);
                                    }
                                }

                            } catch (Exception e) {
                                pd.dismiss();
                                AlertandMessages.showAlert((Activity) context, "Error in Uploading Data at " + finalKeyName, true);
                            }
                        } else {
                            pd.dismiss();
                            AlertandMessages.showAlert((Activity) context, "Error in Uploading Data at " + finalKeyName, true);

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        isvalid = true;
                        pd.dismiss();
                        if (t instanceof SocketTimeoutException) {
                            AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                        } else if (t instanceof IOException) {
                            AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                        } else if (t instanceof SocketException) {
                            AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                        } else {
                            AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                        }

                    }
                });

            } else {
                finalJsonIndex[0]++;
                if (finalJsonIndex[0] != keyList.size()) {
                    uploadDataWithoutWait(keyList, finalJsonIndex[0], coverageList, coverageIndex);
                } else {
                    pd.setMessage("updating status :" + coverageIndex);
                    //uploading status D for current store from coverageList
                    updateStatus(coverageList, coverageIndex, CommonString.KEY_D);

                }
            }
        } catch (Exception ex) {
            pd.dismiss();
            AlertandMessages.showAlert((Activity) context, "Error in Uploading status at coverage :" + coverageIndex, true);

        }

    }

    void updateStatus(final ArrayList<CoverageBean> coverageList, final int coverageIndex, String status) {
        if (coverageList.get(coverageIndex) != null) {
            try {
                final int[] tempcoverageIndex = {coverageIndex};
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("StoreId", coverageList.get(coverageIndex).getStoreId());
                jsonObject.put("VisitDate", coverageList.get(coverageIndex).getVisitDate());
                jsonObject.put("UserId", _UserId);
                jsonObject.put("Status", status);

                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .readTimeout(20, TimeUnit.SECONDS)
                        .writeTimeout(20, TimeUnit.SECONDS)
                        .connectTimeout(20, TimeUnit.SECONDS)
                        .build();

                RequestBody jsonData = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
                adapter = new Retrofit.Builder().baseUrl(CommonString.URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
                PostApi api = adapter.create(PostApi.class);
                Call<ResponseBody> call = null;

                call = api.getCoverageStatusDetail(jsonData);

                pd.setMessage("Uploading store status " + (coverageIndex + 1) + "/" + coverageList.size());
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        ResponseBody responseBody = response.body();
                        String data = null;
                        if (responseBody != null && response.isSuccessful()) {
                            try {
                                data = response.body().string();
                                if (data.equalsIgnoreCase("")) {
                                    pd.dismiss();
                                    AlertandMessages.showAlert((Activity) context, "Error in Uploading status at coverage :" + coverageIndex, true);
                                } else {
                                    data = data.substring(1, data.length() - 1).replace("\\", "");
                                    if (data.contains("1")) {
                                        db.open();
                                        db.updateCheckoutStatus(coverageList.get(tempcoverageIndex[0]).getStoreId(), CommonString.KEY_D, CommonString.TABLE_Journey_Plan);
                                        db.updateCheckoutStatus(coverageList.get(tempcoverageIndex[0]).getStoreId(), CommonString.KEY_D, CommonString.TABLE_Journey_Plan_DBSR_Saved);
                                        tempcoverageIndex[0]++;
                                        if (tempcoverageIndex[0] != coverageList.size()) {
                                            //updateStatus(coverageList, tempcoverageIndex[0], CommonString.KEY_D);
                                            uploadDataUsingCoverageRecursive(coverageList, tempcoverageIndex[0]);
                                        } else {
                                            pd.setMessage("uploading images");
                                            String coverageDate = null;
                                            if (coverageList.size() > 0) {
                                                coverageDate = coverageList.get(0).getVisitDate();
                                            } else {
                                                coverageDate = date;
                                            }
                                            //UploadImageFileJsonList(context, coverageDate);
                                            uploadImage(coverageDate);
                                        }

                                    } else {
                                        pd.dismiss();
                                        AlertandMessages.showAlert((Activity) context, "Error in Uploading status at coverage :" + coverageIndex, true);
                                    }
                                }
                                // jsonStringList.remove(finalJsonIndex);
                                // KeyNames.remove(finalJsonIndex);
                            } catch (Exception e) {
                                pd.dismiss();
                                AlertandMessages.showAlert((Activity) context, "Error in Uploading status at coverage :" + coverageIndex, true);
                            }
                        } else {
                            pd.dismiss();
                            AlertandMessages.showAlert((Activity) context, "Error in Uploading status at coverage :" + coverageIndex, true);

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        isvalid = true;
                        pd.dismiss();
                        if (t instanceof SocketTimeoutException) {
                            AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                        } else if (t instanceof IOException) {
                            AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                        } else if (t instanceof SocketException) {
                            AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                        } else {
                            AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                        }

                    }
                });

            } catch (JSONException ex) {

            }
        }

    }

    public void uploadDataUsingCoverageRecursive(ArrayList<CoverageBean> coverageList, int coverageIndex) {
        try {
            ArrayList<String> keyList = new ArrayList<>();
            keyList.clear();
            String store_id = coverageList.get(coverageIndex).getStoreId();
            String status = null;
            pd.setMessage("Uploading store " + (coverageIndex + 1) + "/" + coverageList.size());
            db.open();

            ArrayList<JourneyPlan> journeyPlans = db.getSpecificStoreData(store_id);
            if (journeyPlans.size() > 0) {
                status = journeyPlans.get(0).getUploadStatus();
            } else {
                ArrayList<JourneyPlan> journeyPlans_DBSR = db.getSpecificStore_DBSRSavedData(store_id);
                if (journeyPlans_DBSR.size() > 0) {
                    status = journeyPlans_DBSR.get(0).getUploadStatus();
                } else {
                    status = null;
                }
            }

            if (status != null && !status.equalsIgnoreCase(CommonString.KEY_D) && !coverageList.get(coverageIndex).getReasonid().equalsIgnoreCase("11")) {
                keyList.add("CoverageDetail_latest");

                /*keyList.add("Store_Profile");
                keyList.add("Category_Dressing_data");
                keyList.add("Category_DBSR_data");
                */
                keyList.add("GeoTag");

                keyList.add("Window_Data");
                keyList.add("CTU_Data");
                keyList.add("Secondary_Visibility_Data");
                keyList.add("Focus_Product");
                keyList.add("Visicooler");
                keyList.add("MonkeySun");
                keyList.add("jar");
                keyList.add("POSM_Deployment");
                keyList.add("POSM");
                keyList.add("BACK_OF_STORE_DATA");
                keyList.add("SOS_Data");
                keyList.add("Store_Profile");


            }

            if (keyList.size() > 0) {
                UploadImageWithRetrofit upload = new UploadImageWithRetrofit(context, db, pd, from);
                upload.uploadDataWithoutWait(keyList, 0, coverageList, coverageIndex);
            } else {

                if (++coverageIndex != coverageList.size()) {
                    uploadDataUsingCoverageRecursive(coverageList, coverageIndex);
                } else {
                    String coverageDate = null;
                    if (coverageList.size() > 0) {
                        coverageDate = coverageList.get(0).getVisitDate();
                    } else {
                        coverageDate = date;
                    }
                    //UploadImageFileJsonList(context, coverageDate);
                    uploadImage(coverageDate);
                }
            }
            //endregion
        } catch (Exception e) {
            e.printStackTrace();
            pd.dismiss();
            AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_SOCKETEXCEPTION, true);
        }

    }

    void uploadImage(String coverageDate) {

        File f = new File(CommonString.FILE_PATH);
        File file[] = f.listFiles();
        if (file.length > 0) {
            uploadedFiles = 0;
            totalFiles = file.length;
            UploadImageRecursive(context);
        } else {
            uploadedFiles = 0;
            totalFiles = file.length;
            new StatusUpload(coverageDate).execute();
        }
    }

    //region StatusUpload
    class StatusUpload extends AsyncTask<String, String, String> {
        String coverageDate;

        StatusUpload(String coverageDate) {
            this.coverageDate = coverageDate;
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                db = new MondelezDatabase(context);
                db.open();
                ArrayList<JourneyPlan> storeList = db.getStoreData(coverageDate);
                if (storeList.size() == 0) {
                    storeList = db.getStoreData_DBSR_Saved(coverageDate);
                }
                for (int i = 0; i < storeList.size(); i++) {
                    if (storeList.get(i).getUploadStatus().equalsIgnoreCase(CommonString.KEY_D)) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("StoreId", storeList.get(i).getStoreId());
                        jsonObject.put("VisitDate", coverageDate);
                        jsonObject.put("UserId", _UserId);
                        jsonObject.put("Status", CommonString.KEY_U);

                        UploadImageWithRetrofit upload = new UploadImageWithRetrofit(context);
                        String jsonString2 = jsonObject.toString();
                        String result = upload.downloadDataUniversal(jsonString2, CommonString.COVERAGEStatusDetail);

                        if (result.equalsIgnoreCase(CommonString.MESSAGE_NO_RESPONSE_SERVER)) {
                            statusUpdated = false;
                            throw new SocketTimeoutException();
                        } else if (result.equalsIgnoreCase(CommonString.MESSAGE_SOCKETEXCEPTION)) {
                            statusUpdated = false;
                            throw new IOException();
                        } else if (result.equalsIgnoreCase(CommonString.MESSAGE_INVALID_JSON)) {
                            statusUpdated = false;
                            throw new JsonSyntaxException("Coverage Status Detail");
                        } else if (result.equalsIgnoreCase(CommonString.KEY_FAILURE)) {
                            statusUpdated = false;
                            throw new Exception();
                        } else {
                            statusUpdated = true;
                            if (db.updateCheckoutStatus(String.valueOf(storeList.get(i).getStoreId()), CommonString.KEY_U, CommonString.TABLE_Journey_Plan) > 0) {
                                db.deleteTableWithStoreID(String.valueOf(storeList.get(i).getStoreId()));
                                //AlertandMessages.show
                                // Alert((Activity) context, "All Image Uploaded Successfully", false);
                            }

                            if (db.updateCheckoutStatus(String.valueOf(storeList.get(i).getStoreId()), CommonString.KEY_U, CommonString.TABLE_Journey_Plan_DBSR_Saved) > 0) {
                                db.deleteTableWithStoreID(String.valueOf(storeList.get(i).getStoreId()));
                                //AlertandMessages.show
                                // Alert((Activity) context, "All Image Uploaded Successfully", false);
                            }
                        }
                    }
                }

            } catch (SocketTimeoutException e) {
                e.printStackTrace();
                AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_SOCKETEXCEPTION, true);
            } catch (IOException e) {
                e.printStackTrace();
                AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_SOCKETEXCEPTION, true);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INVALID_JSON, true);
            } catch (Exception e) {
                e.printStackTrace();

            }
            if (statusUpdated) {
                return CommonString.KEY_SUCCESS;
            } else {
                return CommonString.KEY_FAILURE;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pd.dismiss();
            if (s.equalsIgnoreCase(CommonString.KEY_SUCCESS)) {
                if (totalFiles == uploadedFiles && statusUpdated) {
                    AlertandMessages.showAlert((Activity) context, "All images uploaded Successfully", true);
                } else if (totalFiles == uploadedFiles && !statusUpdated) {
                    AlertandMessages.showAlert((Activity) context, "All images uploaded Successfully, but status not updated", true);
                } else {
                    AlertandMessages.showAlert((Activity) context, "Some images not uploaded", true);
                }
            }
        }
    }
    //endregion

    //region DownloadImageTask
    class DownloadImageTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            try {
                downloadImages();
                return CommonString.KEY_SUCCESS;
            } catch (FileNotFoundException ex) {
                return CommonString.KEY_FAILURE;
            } catch (IOException ex) {
                return CommonString.KEY_FAILURE;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s.equalsIgnoreCase(CommonString.KEY_SUCCESS)) {
                pd.dismiss();
                AlertandMessages.showAlert((Activity) context, "All data downloaded Successfully", true);
            } else {
                pd.dismiss();
                AlertandMessages.showAlert((Activity) context, "Error in downloading", true);
            }

        }

    }
    //endregion

    //region downloadImages
    void downloadImages() throws IOException {
        //Menu Image Download
        if (menuMasterGetterSetter != null) {

            List<MenuMaster> menu_master_list = menuMasterGetterSetter.getMenuMaster();

            for (int i = 0; i < menu_master_list.size(); i++) {

                String normal_img = menu_master_list.get(i).getNormalIcon();
                String path = menu_master_list.get(i).getMenuPath();

                downloadImageWithname(normal_img, path);

                String done_image = menu_master_list.get(i).getTickIcon();

                downloadImageWithname(done_image, path);

                String greyIcon = menu_master_list.get(i).getGreyIcon();

                downloadImageWithname(greyIcon, path);

            }

        }
        //endregion

    }
    //endregion

    void downloadImageWithname(String image_name, String path) throws IOException {

        if (!new File(CommonString.FILE_PATH_Downloaded
                + image_name).exists()) {
            if (image_name != null && !image_name.equalsIgnoreCase("NA")
                    && !image_name.equalsIgnoreCase("")) {
                URL url = new URL(path + image_name);
                HttpURLConnection c = (HttpURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.getResponseCode();
                c.setConnectTimeout(20000);
                c.connect();

                if (c.getResponseCode() == 200) {
                    int length = c.getContentLength();
                    String size = new DecimalFormat("##.##")
                            .format((double) ((double) length / 1024))
                            + " KB";

                    File file = new File(CommonString.FILE_PATH_Downloaded);
                    file.mkdirs();
                    if (!size.equalsIgnoreCase("0 KB")) {

                        jj = image_name.split("\\/");
                        image_name = jj[jj.length - 1];
                        File outputFile = new File(file, image_name);
                        FileOutputStream fos = null;
                        fos = new FileOutputStream(outputFile);
                        InputStream is1 = (InputStream) c.getInputStream();
                        int bytes = 0;
                        byte[] buffer = new byte[1024];
                        int len1 = 0;

                        while ((len1 = is1.read(buffer)) != -1) {
                            bytes = (bytes + len1);
                            // data.value = (int) ((double) (((double)
                            // bytes) / length) * 100);
                            fos.write(buffer, 0, len1);
                        }

                        fos.close();
                        is1.close();

                    }
                } else {
                    c.disconnect();
                }
            }
        }

    }


    String createTable(TableStructureGetterSetter tableGetSet) {
        List<TableStructure> tableList = tableGetSet.getTableStructure();
        for (int i = 0; i < tableList.size(); i++) {
            String table = tableList.get(i).getSqlText();
            if (db.createtable(table) == 0) {
                return table;
            }
        }
        return CommonString.KEY_SUCCESS;
    }

    //region downloadDataUniversalWithoutWait
    public void downloadDataUniversalWithoutWait(final ArrayList<String> jsonStringList, final ArrayList<String> KeyNames, int downloadindex, int type) {
        status = 0;
        isvalid = false;
        final String[] data_global = {""};
        String jsonString = "", KeyName = "";
        int jsonIndex = 0;

        if (jsonStringList.size() > 0) {

            jsonString = jsonStringList.get(downloadindex);
            KeyName = KeyNames.get(downloadindex);
            jsonIndex = downloadindex;

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .build();

            pd.setMessage("Downloading (" + downloadindex + "/" + listSize + ") \n" + KeyName + "");
            RequestBody jsonData = RequestBody.create(MediaType.parse("application/json"), jsonString);
            adapter = new Retrofit.Builder().baseUrl(CommonString.URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            PostApi api = adapter.create(PostApi.class);
            Call<ResponseBody> call = null;

            if (type == CommonString.LOGIN_SERVICE) {
                call = api.getLogindetail(jsonData);
            } else if (type == CommonString.DOWNLOAD_ALL_SERVICE) {
                call = api.getDownloadAll(jsonData);
            } else if (type == CommonString.COVERAGE_DETAIL) {
                call = api.getCoverageDetail(jsonData);
            } else if (type == CommonString.UPLOADJCPDetail) {
                call = api.getUploadJCPDetail(jsonData);
            } else if (type == CommonString.UPLOADJsonDetail) {
                call = api.getUploadJsonDetail(jsonData);
            } else if (type == CommonString.COVERAGEStatusDetail) {
                call = api.getCoverageStatusDetail(jsonData);
            } else if (type == CommonString.CHECKOUTDetail) {
                call = api.getCheckout(jsonData);
            } else if (type == CommonString.DELETE_COVERAGE) {
                call = api.deleteCoverageData(jsonData);
            }

            final int[] finalJsonIndex = {jsonIndex};
            final String finalKeyName = KeyName;
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    ResponseBody responseBody = response.body();
                    String data = null;
                    if (responseBody != null && response.isSuccessful()) {
                        try {
                            data = response.body().string();
                            if (data.equalsIgnoreCase("")) {
                                data_global[0] = "";

                            } else {
                                data = data.substring(1, data.length() - 1).replace("\\", "");
                                data_global[0] = data;
                                if (finalKeyName.equalsIgnoreCase("Table_Structure")) {
                                    editor.putInt(CommonString.KEY_DOWNLOAD_INDEX, finalJsonIndex[0]);
                                    editor.apply();
                                    tableStructureObj = new Gson().fromJson(data, TableStructureGetterSetter.class);
                                    String isAllTableCreated = createTable(tableStructureObj);
                                    if (isAllTableCreated != CommonString.KEY_SUCCESS) {
                                        pd.dismiss();
                                        AlertandMessages.showAlert((Activity) context, isAllTableCreated + " not created", true);
                                    }
                                } else {
                                    editor.putInt(CommonString.KEY_DOWNLOAD_INDEX, finalJsonIndex[0]);
                                    editor.apply();
                                    //region Description
                                    switch (finalKeyName) {
                                        case "Journey_Plan":
                                            if (!data.contains("No Data")) {
                                                jcpObject = new Gson().fromJson(data, JCPGetterSetter.class);
                                                if (jcpObject != null && !db.insertJCPData(jcpObject)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "JCP data data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        case "Menu_Master":
                                            if (!data.contains("No Data")) {
                                                menuMasterGetterSetter = new Gson().fromJson(data, MenuMasterGetterSetter.class);
                                                if (menuMasterGetterSetter != null && !db.insertMenuMasterData(menuMasterGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Menu Master data not saved");
                                                }
                                            } else {
                                                if (rightname != null && !rightname.equalsIgnoreCase("DBSR")) {
                                                    // throw new java.lang.Exception();
                                                }
                                            }
                                            break;
                                        case "Mapping_Menu":
                                            if (!data.contains("No Data")) {
                                                mappingMenuGetterSetter = new Gson().fromJson(data, MappingMenuGetterSetter.class);
                                                if (mappingMenuGetterSetter != null && !db.insertMappingMenuData(mappingMenuGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping Menu data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        case "Window_Master":
                                            if (!data.contains("No Data")) {
                                                windowMaster = new Gson().fromJson(data, WindowMasterGetterSetter.class);
                                                if (windowMaster != null && !db.insertWindowMasterkData(windowMaster)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Window Master data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;

                                        case "Window_Checklist":
                                            if (!data.contains("No Data")) {
                                                windowChecklist = new Gson().fromJson(data, WindowChecklistGetterSetter.class);
                                                if (windowChecklist != null && !db.insertWindowChecklistData(windowChecklist)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Window Checklist data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        case "Window_Checklist_Answer":
                                            if (!data.contains("No Data")) {
                                                windcheckanser = new Gson().fromJson(data, WindowCheckAnswerGetterSetter.class);
                                                if (windcheckanser != null && !db.insertwindowChecklistAnsdata(windcheckanser)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Window check Answer data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;


                                        case "Mapping_Window_Checklist":
                                            if (!data.contains("No Data")) {
                                                mappingWindChecklist = new Gson().fromJson(data, MappingWindChecklistGetterSetter.class);
                                                if (mappingWindChecklist != null && !db.insertmappingwindowChecklistdata(mappingWindChecklist)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping Window checklist data not saved");
                                                }
                                            } else {
                                                if (rightname != null && !rightname.equalsIgnoreCase("DBSR")) {
                                                    //  throw new java.lang.Exception();
                                                }

                                            }
                                            break;
                                        case "Non_Working_Reason":
                                            if (!data.contains("No Data")) {
                                                nonWorkingObj = new Gson().fromJson(data, NonWorkingReasonGetterSetter.class);
                                                if (nonWorkingObj != null && !db.insertNonWorkingData(nonWorkingObj)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Non Working Reason data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        //case "Mapping_Visibility_Initiatives":
                                        case "Mapping_Visibility_Initiatives_New":
                                            if (!data.contains("No Data")) {
                                                mappingInitiative = new Gson().fromJson(data, MappingInitiativeGetterSetter.class);
                                                if (mappingInitiative != null && !db.insertmappingInitiativedata(mappingInitiative)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping Initiative data not saved");
                                                }
                                            } else {
                                                if (rightname != null && !rightname.equalsIgnoreCase("DBSR")) {
                                                    //  throw new java.lang.Exception();
                                                }
                                            }
                                            break;

                                        case "Non_Window_Reason":
                                            if (!data.contains("No Data")) {
                                                nonWindowReasonGetterSetter = new Gson().fromJson(data, NonWindowReasonGetterSetter.class);
                                                if (nonWindowReasonGetterSetter != null && !db.insertNonWindowReasonData(nonWindowReasonGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Non Window data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        case "Category_Master":
                                            if (!data.contains("No Data")) {
                                                categoryMasterObject = new Gson().fromJson(data, CategoryMasterGetterSetter.class);
                                                if (categoryMasterObject != null && !db.insertCategoryMasterData(categoryMasterObject)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Category Master data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        case "Mapping_Category_Checklist":
                                            if (!data.contains("No Data")) {
                                                mappingCategoryChecklistGetterSetter = new Gson().fromJson(data, MappingCategoryChecklistGetterSetter.class);
                                                if (mappingCategoryChecklistGetterSetter != null && !db.insertMappingCategoryChecklistdata(mappingCategoryChecklistGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping Category Checklist data not saved");
                                                }
                                            } else {
                                                if (rightname != null && !rightname.equalsIgnoreCase("DBSR")) {
                                                    //  throw new java.lang.Exception();
                                                }
                                            }
                                            break;
                                        case "Non_Category_Reason":
                                            if (!data.contains("No Data")) {
                                                nonCategoryReasonGetterSetter = new Gson().fromJson(data, NonCategoryReasonGetterSetter.class);
                                                if (nonCategoryReasonGetterSetter != null && !db.insertNonCategoryReasonData(nonCategoryReasonGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Non Category Reason not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        case "Brand_Master":
                                            if (!data.contains("No Data")) {
                                                brandMasterObject = new Gson().fromJson(data, BrandMasterGetterSetter.class);
                                                if (brandMasterObject != null && !db.insertBrandMasterData(brandMasterObject)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Brand Master data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        case "Store_Type_Master":
                                            if (!data.contains("No Data")) {
                                                storeTypeMasterGetterSetter = new Gson().fromJson(data, StoreTypeMasterGetterSetter.class);
                                                if (storeTypeMasterGetterSetter != null && !db.insertStoreTypeMasterData(storeTypeMasterGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Store Type Master data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;

                                        case "Mapping_Posm":
                                            if (!data.contains("No Data")) {
                                                mappingPosmGetterSetter = new Gson().fromJson(data, MappingPosmGetterSetter.class);
                                                if (mappingPosmGetterSetter != null && !db.insertMappingPosmData(mappingPosmGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping Posm data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;

                                        case "Posm_Master":
                                            if (!data.contains("No Data")) {
                                                posmMasterGetterSetter = new Gson().fromJson(data, PosmMasterGetterSetter.class);
                                                if (posmMasterGetterSetter != null && !db.insertPosmMasterData(posmMasterGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Posm Master data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;

                                        case "Mapping_Visicooler":
                                            if (!data.contains("No Data")) {
                                                mappingVisicoolerGetterSetter = new Gson().fromJson(data, MappingVisicoolerGetterSetter.class);
                                                if (mappingVisicoolerGetterSetter != null && !db.insertMapppingVisicoolerData(mappingVisicoolerGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping Visicooler data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;


                                        //case "Non_Posm_Reason":
                                        case "Non_Execution_Reason":
                                            if (!data.contains("No Data")) {
                                                nonExecutionReasonGetterSetter = new Gson().fromJson(data, NonExecutionReasonGetterSetter.class);
                                                if (nonExecutionReasonGetterSetter != null && !db.insertNonPosmReseonData(nonExecutionReasonGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Non_Execution_Reason data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;

                                        case "Mapping_Window":
                                            if (!data.contains("No Data")) {
                                                mappingWindowGetterSetter = new Gson().fromJson(data, MappingWindowGetterSetter.class);
                                                if (mappingWindowGetterSetter != null && !db.insertMappingWindowData(mappingWindowGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping_Window data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;

                                        case "Checklist_Master":
                                            if (!data.contains("No Data")) {
                                                checklistMasterGetterSetter = new Gson().fromJson(data, ChecklistMasterGetterSetter.class);
                                                if (checklistMasterGetterSetter != null && !db.insertChecklistMasterData(checklistMasterGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Checklist_Master data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;


                                        case "Checklist_Answer":
                                            if (!data.contains("No Data")) {
                                                checklistAnswerGetterSetter = new Gson().fromJson(data, ChecklistAnswerGetterSetter.class);
                                                if (checklistAnswerGetterSetter != null && !db.insertChecklistAnswerData(checklistAnswerGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Checklist_Answer data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;

                                        case "Mapping_Menu_Checklist":
                                            if (!data.contains("No Data")) {
                                                mappingMenuChecklistGetterSetter = new Gson().fromJson(data, MappingMenuChecklistGetterSetter.class);
                                                if (mappingMenuChecklistGetterSetter != null && !db.insertMappingWindowData(mappingMenuChecklistGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping_Menu_Checklist data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        case "Mapping_CTU":
                                            if (!data.contains("No Data")) {
                                                mappingCTUGetterSetter = new Gson().fromJson(data, MappingCTUGetterSetter.class);
                                                if (mappingCTUGetterSetter != null && !db.insertMappingCtuData(mappingCTUGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping_Menu_Checklist data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        case "Mapping_Focus_Sku":
                                            if (!data.contains("No Data")) {
                                                mappingFocusSkuGetterSetter = new Gson().fromJson(data, MappingFocusSkuGetterSetter.class);
                                                if (mappingFocusSkuGetterSetter != null && !db.insertMappingFocusSkuData(mappingFocusSkuGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping Focus Sku data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;


                                        case "Mapping_Secondary_Visibility":
                                            if (!data.contains("No Data")) {
                                                mappingSecondaryVisibilityGetterSetter = new Gson().fromJson(data, MappingSecondaryVisibilityGetterSetter.class);
                                                if (mappingSecondaryVisibilityGetterSetter != null && !db.insertMappingSecondaryVisibilityData(mappingSecondaryVisibilityGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping Secondary Visibility data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;

                                        case "Sku_Master":
                                            if (!data.contains("No Data")) {
                                                skuMasterGetterSetter = new Gson().fromJson(data, SkuMasterGetterSetter.class);
                                                if (skuMasterGetterSetter != null && !db.insertSkuMasterData(skuMasterGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Sku Master data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;

                                        case "mapping_Back_Of_Store":
                                            if (!data.contains("No Data")) {
                                                mappingBackOfStoreGetterSetter = new Gson().fromJson(data, MappingBackOfStoreGetterSetter.class);
                                                if (mappingBackOfStoreGetterSetter != null && !db.insertMappingBackofData(mappingBackOfStoreGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "mapping Back Of Store data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                        case "Mapping_Monkeysun":
                                            if (!data.contains("No Data")) {
                                                mappingMonkeysunStoreGetterSetter = new Gson().fromJson(data, MappingMonkeysunStoreGetterSetter.class);
                                                if (mappingMonkeysunStoreGetterSetter != null && !db.insertMappingMonkySunData(mappingMonkeysunStoreGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Mapping Monkeysun data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;


                                        case "Display_Master":
                                            if (!data.contains("No Data")) {
                                                displayMasterGetterSetter = new Gson().fromJson(data, DisplayMasterGetterSetter.class);
                                                if (displayMasterGetterSetter != null && !db.insertDisplayMasterData(displayMasterGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Display Master data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;


                                        case "Sub_Category_Master":
                                            if (!data.contains("No Data")) {
                                                subCategoryMasterGetterSetter = new Gson().fromJson(data, SubCategoryMasterGetterSetter.class);
                                                if (subCategoryMasterGetterSetter != null && !db.insertSubCategoryMaster(subCategoryMasterGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Sub_Category_Master data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;

                                        case "mapping_Share_Of_Shelf":
                                            if (!data.contains("No Data")) {
                                                mappingShareOfShelfGetterSetter = new Gson().fromJson(data, MappingShareOfShelfGetterSetter.class);
                                                if (mappingShareOfShelfGetterSetter != null && !db.insertShareOfShelfMaster(mappingShareOfShelfGetterSetter)) {
                                                    pd.dismiss();
                                                    AlertandMessages.showSnackbarMsg(context, "Sub_Category_Master data not saved");
                                                }
                                            } else {
                                                throw new java.lang.Exception();
                                            }
                                            break;
                                    }
                                    //endregion

                                }
                            }
                            // jsonStringList.remove(finalJsonIndex);
                            // KeyNames.remove(finalJsonIndex);
                            finalJsonIndex[0]++;
                            if (finalJsonIndex[0] != KeyNames.size()) {
                                editor.putInt(CommonString.KEY_DOWNLOAD_INDEX, finalJsonIndex[0]);
                                editor.apply();
                                downloadDataUniversalWithoutWait(jsonStringList, KeyNames, finalJsonIndex[0], CommonString.DOWNLOAD_ALL_SERVICE);
                            } else {
                                editor.putInt(CommonString.KEY_DOWNLOAD_INDEX, 0);
                                editor.apply();
                                pd.dismiss();
                                //AlertandMessages.showAlert((Activity) context, "All data downloaded Successfully", true);
                                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
                                builder.setCancelable(false);
                                builder.setMessage("All data downloaded Successfully").setCancelable(false)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.dismiss();
                                            }

                                        });

                                android.support.v7.app.AlertDialog alert = builder.create();
                                alert.show();
                                //downloadImages();
                                pd.setMessage("Downloading Images");
                                new DownloadImageTask().execute();
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                            editor.putInt(CommonString.KEY_DOWNLOAD_INDEX, finalJsonIndex[0]);
                            editor.apply();
                            pd.dismiss();
                            AlertandMessages.showAlert((Activity) context, "Error in downloading Data at " + finalKeyName, true);
                        }
                    } else {
                        editor.putInt(CommonString.KEY_DOWNLOAD_INDEX, finalJsonIndex[0]);
                        editor.apply();
                        pd.dismiss();
                        AlertandMessages.showAlert((Activity) context, "Error in downloading Data at " + finalKeyName, true);

                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    isvalid = true;
                    pd.dismiss();
                    if (t instanceof SocketTimeoutException) {
                        AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                    } else if (t instanceof IOException) {
                        AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                    } else if (t instanceof SocketException) {
                        AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                    } else {
                        AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, true);
                    }

                }
            });

        } else {
            editor.putInt(CommonString.KEY_DOWNLOAD_INDEX, 0);
            editor.apply();
            // pd.dismiss();
            // AlertandMessages.showAlert((Activity) context, "All data downloaded Successfully", true);
            //pd.setMessage("Downloading Images");
            //new DownloadImageTask().execute();
        }

    }
    //endregion

}
