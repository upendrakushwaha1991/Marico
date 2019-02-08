package com.cpm.reckitt_benckiser_gt;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cpm.reckitt_benckiser_gt.Get_IMEI_number.ImeiNumberClass;
import com.cpm.reckitt_benckiser_gt.autoupdate.AutoUpdateActivity;
import com.cpm.reckitt_benckiser_gt.getterSetter.GsonGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.NoticeBoardGetterSetter;
import com.cpm.reckitt_benckiser_gt.upload.Retrofit_method.UploadImageWithRetrofit;
import com.cpm.reckitt_benckiser_gt.utilities.AlertandMessages;
import com.cpm.reckitt_benckiser_gt.utilities.CommonString;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.fabric.sdk.android.Fabric;


public class LoginActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private TextView tv_version;
    private String app_ver;
    private static int counter = 1;
    private SharedPreferences preferences = null;
    private SharedPreferences.Editor editor = null;
    private double lat = 0.0;
    private double lon = 0.0;
    // UI references.
    private AutoCompleteTextView museridView;
    private EditText mPasswordView;
    private Context context;
    private String userid;
    private String password;
    private FirebaseAnalytics mFirebaseAnalytics;
    private int versionCode;
    private String[] imeiNumbers;
    private int i = 0;
    private static final int PERMISSIONS_REQUEST_READ_PHONE_STATE = 999;
    private Button museridSignInButton;
    private ImeiNumberClass imei;
    private String manufacturer;
    private String model;
    LocationManager locationManager;
    private String os_version;
    boolean enabled;

    GoogleApiClient mGoogleApiClient;
    private static int UPDATE_INTERVAL = 200; // 5 sec
    private static int FATEST_INTERVAL = 100; // 1 sec
    private static int DISPLACEMENT = 1; // 10 meters
    private static final int REQUEST_LOCATION = 1;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    private Location mLastLocation;
    private LocationRequest mLocationRequest;

    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 10;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 11;
    private static final int MY_PERMISSIONS_REQUEST_STORAGE_READ = 12;
    private static final int MY_PERMISSIONS_REQUEST_STORAGE_WRITE = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        declaration();
        Fabric.with(context, new Crashlytics());
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
      /*  mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });*/

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_PHONE_STATE},
                    PERMISSIONS_REQUEST_READ_PHONE_STATE);
        } else {
            imeiNumbers = imei.getDeviceImei();
        }
        getDeviceName();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_PHONE_STATE
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            imeiNumbers = imei.getDeviceImei();
        }

        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        if (checkPlayServices()) {
            // Building the GoogleApi client
            buildGoogleApiClient();

            createLocationRequest();
        }

        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();

        }
        checkgpsEnableDevice();
    }

    private void attemptLogin() {
        // Reset errors.
        museridView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        userid = museridView.getText().toString().trim();
        password = mPasswordView.getText().toString().trim();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }
        // Check for a valid userid address.
        if (TextUtils.isEmpty(userid)) {
            museridView.setError(getString(R.string.error_field_required));
            focusView = museridView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else if (!isuseridValid(userid)) {
            Snackbar.make(museridView, getString(R.string.error_incorrect_username), Snackbar.LENGTH_SHORT).show();
        } else if (!isPasswordValid(password)) {
            Snackbar.make(museridView, getString(R.string.error_incorrect_password), Snackbar.LENGTH_SHORT).show();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            new AuthenticateTask().execute();
        }
    }

    private boolean isuseridValid(String userid) {
        //TODO: Replace this with your own logic
        boolean flag = true;
        String u_id = preferences.getString(CommonString.KEY_USERNAME, "");
        if (!u_id.equals("") && !userid.equalsIgnoreCase(u_id)) {
            flag = false;
        }
        return flag;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        boolean flag = true;
        String pw = preferences.getString(CommonString.KEY_PASSWORD, "");
        if (!pw.equals("") && !password.equals(pw)) {
            flag = false;
        }
        return flag;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */

    private class AuthenticateTask extends AsyncTask<Void, Void, String> {
        private ProgressDialog dialog = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(context);
            dialog.setTitle("Login");
            dialog.setMessage("Authenticating....");
            dialog.setCancelable(false);
            if (!dialog.isShowing()) {
                dialog.show();
            }
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Userid", userid.toLowerCase());
                jsonObject.put("Password", password);
                jsonObject.put("Intime", getCurrentTime());
                jsonObject.put("Latitude", lat);
                jsonObject.put("Longitude", lon);
                jsonObject.put("Appversion", app_ver);
                jsonObject.put("Attmode", "0");
                jsonObject.put("Networkstatus", "0");
                jsonObject.put("Manufacturer", manufacturer);
                jsonObject.put("ModelNumber", model);
                jsonObject.put("OSVersion", os_version);

                if (imeiNumbers.length > 0) {
                    jsonObject.put("IMEINumber1", imeiNumbers[0]);
                    if (imeiNumbers.length > 1) {
                        jsonObject.put("IMEINumber2", imeiNumbers[1]);
                    } else {
                        jsonObject.put("IMEINumber2", "0");
                    }
                } else {
                    jsonObject.put("IMEINumber1", "0");
                    jsonObject.put("IMEINumber2", "0");
                }

                String jsonString2 = jsonObject.toString();
                UploadImageWithRetrofit upload = new UploadImageWithRetrofit(context);
                String result_str = upload.downloadDataUniversal(jsonString2, CommonString.LOGIN_SERVICE);

                JSONObject jsonObject_notice = new JSONObject();
                jsonObject_notice.put("Downloadtype", "Notice_Board");
                jsonObject_notice.put("Username", userid.toLowerCase());
                UploadImageWithRetrofit upload2 = new UploadImageWithRetrofit(context);
                String result_notice = upload2.downloadDataUniversal(jsonObject_notice.toString(), CommonString.DOWNLOAD_ALL_SERVICE);

                if (result_str.equalsIgnoreCase(CommonString.MESSAGE_SOCKETEXCEPTION)) {
                    throw new IOException();
                } else if (result_str.equalsIgnoreCase(CommonString.KEY_FAILURE)) {
                    throw new Exception();
                } else {

                    Gson gson = new Gson();
                    GsonGetterSetter userObject = gson.fromJson(result_str, GsonGetterSetter.class);
                    NoticeBoardGetterSetter noticeObject = gson.fromJson(result_notice, NoticeBoardGetterSetter.class);

                    // PUT IN PREFERENCES
                    editor.putString(CommonString.KEY_NOTICE_BOARD, noticeObject.getNoticeBoard().get(0).getNOTICEBOARD());
                    editor.putString(CommonString.KEY_QUIZ_URL, noticeObject.getNoticeBoard().get(0).getQUIZURL());
                    editor.putString(CommonString.KEY_USERNAME, userid.toLowerCase());
                    editor.putString(CommonString.KEY_PASSWORD, password);
                    editor.putString(CommonString.KEY_RIGHTNAME, String.valueOf(userObject.getResult().get(0).getRightname()));
                    editor.putString(CommonString.KEY_VERSION, String.valueOf(userObject.getResult().get(0).getAppVersion()));
                    editor.putString(CommonString.KEY_PATH, userObject.getResult().get(0).getAppPath());
                    //userObject.getResult().get(0).setCurrentdate("06/21/2018");
                    editor.putString(CommonString.KEY_DATE, userObject.getResult().get(0).getCurrentdate());
                    editor.putString(CommonString.KEY_NOTICE_BOARD_LINK, userObject.getResult().get(0).getNotice());
                    Date initDate = new SimpleDateFormat("MM/dd/yyyy").parse(userObject.getResult().get(0).getCurrentdate());
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                    String parsedDate = formatter.format(initDate);
                    editor.putString(CommonString.KEY_YYYYMMDD_DATE, parsedDate);
                    //date is changed for previous day data
                    //editor.putString(CommonString.KEY_DATE, "04/25/2017");
                    editor.commit();

                    Bundle bundle = new Bundle();
                    bundle.putString(FirebaseAnalytics.Param.ITEM_ID, userid.toLowerCase());
                    bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, CommonString.KEY_LOGIN_DATA);
                    bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Data");
                    mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                    Crashlytics.setUserIdentifier(userid.toLowerCase());

                    return CommonString.KEY_SUCCESS;

                }


            } catch (MalformedURLException e) {

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_EXCEPTION, false);
                    }
                });

            } catch (IOException e) {

                counter++;
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                   /*     if (counter < 3) {
                            new AuthenticateTask().execute();
                        } else {
                            showAlert(CommonString.MESSAGE_SOCKETEXCEPTION);
                            counter = 1;
                        }*/
                        AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_SOCKETEXCEPTION, false);
                    }
                });
            } catch (Exception e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_CHANGED, false);
                    }
                });
            }
            return "";

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dialog.dismiss();
            if (result.equals(CommonString.KEY_SUCCESS)) {
                if (preferences.getString(CommonString.KEY_VERSION, "").equals(Integer.toString(versionCode))) {
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // if app version code does not match with live apk version code then update will be called.
                    Intent intent = new Intent(context, AutoUpdateActivity.class);
                    intent.putExtra(CommonString.KEY_PATH, preferences.getString(CommonString.KEY_PATH, ""));
                    startActivity(intent);
                    finish();
                }
            }
        }
    }

    public void getDeviceName() {
        manufacturer = Build.MANUFACTURER;
        model = Build.MODEL;
        os_version = android.os.Build.VERSION.RELEASE;
    }


    private String getCurrentTime() {
        Calendar m_cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(m_cal.getTime());
    }

    private void declaration() {
        context = this;
        tv_version = (TextView) findViewById(R.id.tv_version_code);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
        museridView = (AutoCompleteTextView) findViewById(R.id.userid);
        mPasswordView = (EditText) findViewById(R.id.password);
        /*museridView.setText("test");
        mPasswordView.setText("rb@123%");*/
        museridSignInButton = (Button) findViewById(R.id.user_login_button);
        museridSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkNetIsAvailable()) {

                    checkAppPermission(Manifest.permission.CAMERA, MY_PERMISSIONS_REQUEST_CAMERA);

                    //attemptLogin();
                } else {
                    AlertandMessages.showAlert((Activity) context, CommonString.MESSAGE_INTERNET_NOT_AVALABLE, false);
                }
            }
        });
        try {
            app_ver = String.valueOf(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);

        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        tv_version.setText("Version - " + app_ver + "");
        imei = new ImeiNumberClass(context);
    }

    private boolean checkNetIsAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.notsuppoted)
                        , Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }
        return true;
    }

    protected synchronized void buildGoogleApiClient() {
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FATEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setSmallestDisplacement(DISPLACEMENT);
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        // Toast.makeText(this,  " WORKS_lat_lon " + latLng, Toast.LENGTH_LONG).show();
        //  updateLocation(latLng);
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    protected void startLocationUpdates() {

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (mGoogleApiClient != null) {
                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
                // Toast.makeText(getApplicationContext(), "startLocation - Lat" + lat + "Long" + lon, Toast.LENGTH_LONG).show();
            }
        }

    }

    public static int distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        int dist = (int) (earthRadius * c);

        return dist;
    }

    @Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (mLastLocation != null) {
                lat = mLastLocation.getLatitude();
                lon = mLastLocation.getLongitude();
                //  Toast.makeText(getApplicationContext(), "onconnected lat-" + lat + " Long-" + lon, Toast.LENGTH_SHORT).show();
            }
            startLocationUpdates();
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    private boolean checkgpsEnableDevice() {
        boolean flag = true;
        if (!hasGPSDevice(context)) {
            Toast.makeText(context, "Gps not Supported",Toast.LENGTH_SHORT).show();
        }
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER) && hasGPSDevice(context)) {
            enableLoc();
            flag = false;
        } else if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER) && hasGPSDevice(context)) {
            flag = true;
        }
        return flag;
    }

    private boolean hasGPSDevice(Context context) {
        final LocationManager mgr = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (mgr == null)
            return false;
        final List<String> providers = mgr.getAllProviders();
        if (providers == null)
            return false;
        return providers.contains(LocationManager.GPS_PROVIDER);
    }

    private void enableLoc() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(30 * 1000);
        locationRequest.setFastestInterval(5 * 1000);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);
        if (mGoogleApiClient != null) {
            PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
            result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
                @Override
                public void onResult(LocationSettingsResult result) {
                    final Status status = result.getStatus();
                    switch (status.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            try {
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
                                status.startResolutionForResult((Activity) context, REQUEST_LOCATION);
                            } catch (IntentSender.SendIntentException e) {
                                // Ignore the error.
                            }
                            break;
                    }
                }
            });
        }
    }

    void checkAppPermission(String permission, int requestCode) {

        boolean permission_flag = false;
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(LoginActivity.this,
                permission)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(LoginActivity.this,
                    permission)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                showOnPermissiondenied(Manifest.permission.CAMERA, MY_PERMISSIONS_REQUEST_CAMERA, 1);
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(LoginActivity.this,
                        new String[]{permission},
                        requestCode);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            if (requestCode == MY_PERMISSIONS_REQUEST_CAMERA) {
                checkAppPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, MY_PERMISSIONS_REQUEST_STORAGE_WRITE);
            } else if (requestCode == MY_PERMISSIONS_REQUEST_STORAGE_WRITE) {
                checkAppPermission(Manifest.permission.READ_EXTERNAL_STORAGE, MY_PERMISSIONS_REQUEST_STORAGE_READ);
            } else if (requestCode == MY_PERMISSIONS_REQUEST_STORAGE_READ) {
                checkAppPermission(Manifest.permission.ACCESS_FINE_LOCATION, MY_PERMISSIONS_REQUEST_LOCATION);
            } else {

                // Create a Folder for Images

                File file = new File(Environment.getExternalStorageDirectory(), ".GSK_MT_ORANGE_IMAGES");
                if (!file.isDirectory()) {
                    file.mkdir();
                }
                File file_planogram = new File(Environment.getExternalStorageDirectory(), "GSK_MT_ORANGE_Planogram_Images");
                if (!file_planogram.isDirectory()) {
                    file_planogram.mkdir();
                }

                attemptLogin();
            }

        }
    }

    void showOnPermissiondenied(final String permissionsRequired, final int request_code, final int check) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Need Multiple Permissions");
        builder.setMessage("This app needs Camera, Storage and Location permissions.");
        builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                if (check == 0) {
                    checkAppPermission(permissionsRequired, request_code);
                } else {
                    ActivityCompat.requestPermissions(LoginActivity.this,
                            new String[]{permissionsRequired},
                            request_code);
                }

            }
        });
       /* builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });*/
        builder.show();
    }
}

