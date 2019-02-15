package com.cpm.reckitt_benckiser_gt.dailyEntry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/*import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;*/
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cpm.reckitt_benckiser_gt.AutoLoginActivity;
import com.cpm.reckitt_benckiser_gt.R;
import com.cpm.reckitt_benckiser_gt.database.MondelezDatabase;
import com.cpm.reckitt_benckiser_gt.getterSetter.BackofStoreGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.CategoryMaster;
import com.cpm.reckitt_benckiser_gt.getterSetter.CommonChillerDataGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.FocusProductGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.JourneyPlan;
import com.cpm.reckitt_benckiser_gt.getterSetter.MappingMenuChecklist;
import com.cpm.reckitt_benckiser_gt.getterSetter.MenuGetterSetter;
import com.cpm.reckitt_benckiser_gt.getterSetter.MenuMaster;
import com.cpm.reckitt_benckiser_gt.utilities.CommonString;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EntryMenuActivity extends AppCompatActivity {

    MondelezDatabase database;
    Context context;
    JourneyPlan journeyPlan;
    String visit_date = "";
    List<MenuGetterSetter> data = new ArrayList<>();
    RecyclerView recyclerView;
    ValueAdapter adapter;
    TextView txt_label;
    SharedPreferences preferences;
    List<MenuMaster> menu_list = new ArrayList<>();
    List<FocusProductGetterSetter> listDataHeader;
    List<BackofStoreGetterSetter> listDataHeaderBackofStore;
    private ArrayList<CommonChillerDataGetterSetter> posmDeploymentData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_menu);
        declaration();
        if (getIntent().getSerializableExtra(CommonString.TAG_OBJECT) != null
                && getIntent().getSerializableExtra(CommonString.TAG_FROM) != null) {
            journeyPlan = (JourneyPlan) getIntent().getSerializableExtra(CommonString.TAG_OBJECT);
            getSupportActionBar().setTitle("");
            txt_label.setText("Entry Menu" + " - " + visit_date);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        menu_list = database.getMenuData(journeyPlan.getStoreTypeId(), journeyPlan.getStoreCategoryId());

        adapter = new ValueAdapter(context, menu_list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

        if (chekDataforCheckout(journeyPlan)){

            Runnable progressRunnable = new Runnable() {

                @Override
                public void run() {
                    finish();
                }
            };

            Handler pdCanceller = new Handler();
            pdCanceller.postDelayed(progressRunnable, 1000);

        }
    }


    public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.MyViewHolder> {
        private LayoutInflater inflator;
        List<MenuMaster> data;

        public ValueAdapter(Context context, List<MenuMaster> data) {
            inflator = LayoutInflater.from(context);
            this.data = data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View view = inflator.inflate(R.layout.custom_menu_row, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {
            final MenuMaster current = data.get(position);
            viewHolder.txt.setText(current.getMenuName());
            //viewHolder.icon.setImageResource(current.getIconImage());


            //usk
            String icon_path = current.getNormalIcon();
            switch (current.getMenuId()) {

                case 1:
                    if(database.getWindowDefaultData(journeyPlan.getStoreTypeId(), journeyPlan.getStoreCategoryId(), journeyPlan.getStateId()).size()>0){
                        if (database.isWindowFilledData(journeyPlan.getStoreId())) {
                            icon_path = current.getTickIcon();
                        } else {
                            icon_path = current.getNormalIcon();
                        }
                    }
                    else {
                        icon_path = current.getGreyIcon();
                    }

                    break;

                case 2:

                    if(database.getCTUBrandData(journeyPlan.getStoreId()).size()>0){
                        if (database.isCTUFilledData(journeyPlan.getStoreId())) {
                            icon_path = current.getTickIcon();
                        } else {
                            icon_path = current.getNormalIcon();
                        }
                    }
                    else {
                        icon_path = current.getGreyIcon();
                    }
                    break;

                case 3:
                    listDataHeaderBackofStore = database.getHeaderBackofStoreData(journeyPlan);
                    if (listDataHeaderBackofStore.size() > 0) {
                        if (database.isBackofStoreFilled(journeyPlan.getStoreId())) {
                            icon_path = current.getTickIcon();
                        } else {
                            icon_path = current.getNormalIcon();
                        }
                    } else {
                        icon_path = current.getGreyIcon();
                    }
                    break;
                case 4:
                    if (database.isVisicoolerSunGrayIcone(journeyPlan.getStoreId())) {
                        if (database.isVisiCoolerFilledData(journeyPlan.getStoreId())) {
                            icon_path = current.getTickIcon();
                        } else {
                            icon_path = current.getNormalIcon();
                        }
                    } else {
                        icon_path = current.getGreyIcon();
                    }
                    break;
                case 5:
                    posmDeploymentData = database.getPOSMDeploymentData(journeyPlan);
                    if (posmDeploymentData.size()>0) {
                        if (database.isPosmFilledData(journeyPlan.getStoreId())) {
                            icon_path = current.getTickIcon();
                        } else {
                            icon_path = current.getNormalIcon();
                        }
                    }else {
                        icon_path = current.getGreyIcon();
                    }
                    break;
                case 6:
                    listDataHeader = database.getHeaderSalesData(journeyPlan);
                    if (listDataHeader.size() > 0) {
                        if (database.isFocusproductFilled(journeyPlan.getStoreId())) {
                            icon_path = current.getTickIcon();
                        } else {
                            icon_path = current.getNormalIcon();
                        }
                    } else {
                        icon_path = current.getGreyIcon();
                    }
                    break;

                case 7:

                    if (database.isFeedBackFilledData(journeyPlan.getStoreId())) {
                        icon_path = current.getTickIcon();
                    } else {
                        icon_path = current.getNormalIcon();
                    }
                    break;

                case 8:
                    if (database.isJarFilledData(journeyPlan.getStoreId())) {
                        icon_path = current.getTickIcon();
                    } else {
                        icon_path = current.getNormalIcon();
                    }
                    break;

                case 9:
                    List<CategoryMaster> listDataHeader = database.getSOSCategoryMasterData(journeyPlan);
                    if(listDataHeader.size() > 0) {
                        if (database.isSOSFilledData(journeyPlan.getStoreId())) {
                            icon_path = current.getTickIcon();
                        } else {
                            icon_path = current.getNormalIcon();
                        }
                    }else{
                        icon_path = current.getGreyIcon();
                    }
                    break;

                case 10:
                    if (database.isMonkeySunGrayIcone(journeyPlan.getStoreId())) {
                        if (database.isMonkeySunFilledData(journeyPlan.getStoreId())) {
                            icon_path = current.getTickIcon();
                        } else {
                            icon_path = current.getNormalIcon();
                        }
                    } else {
                        icon_path = current.getGreyIcon();
                    }
                    break;

                case 11:
                    if(database.getSecondaryVisibilityDisplayData(journeyPlan.getStoreTypeId(), journeyPlan.getStoreCategoryId(), journeyPlan.getStateId()).size()>0){
                        if (database.isSecondaryFilledData(journeyPlan.getStoreId())) {
                            icon_path = current.getTickIcon();
                        } else {
                            icon_path = current.getNormalIcon();
                        }
                    }
                    else {
                        icon_path = current.getGreyIcon();
                    }

                    break;

            }

            Glide.with(EntryMenuActivity.this)
                    .load(Uri.fromFile(new File(CommonString.FILE_PATH_Downloaded + icon_path)))
                    .apply(new RequestOptions())
                    .into(viewHolder.icon);


            viewHolder.lay_menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int menu_id = current.getMenuId();
                    switch (menu_id){

                        case 1:
                            if(database.getWindowDefaultData(journeyPlan.getStoreTypeId(), journeyPlan.getStoreCategoryId(), journeyPlan.getStateId()).size()>0){
                                startActivity(new Intent(context, WindowWithBrandActivity.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            }

                            break;

                        case 2:
                            if(database.getCTUBrandData(journeyPlan.getStoreId()).size()>0){
                                startActivity(new Intent(context, CTUActivity.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            }

                            break;

                        case 3:
                            listDataHeaderBackofStore = database.getHeaderBackofStoreData(journeyPlan);
                            if (listDataHeaderBackofStore.size() > 0) {
                                startActivity(new Intent(context, BackOfStoreActivity.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            }
                            break;

                        case 4:
                            if (database.isVisicoolerSunGrayIcone(journeyPlan.getStoreId())){
                                startActivity(new Intent(context, NewVisiCoolerActivty.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            }
                            break;

                        case 5:
                            posmDeploymentData = database.getPOSMDeploymentData(journeyPlan);
                            if (posmDeploymentData.size()>0) {
                                startActivity(new Intent(context, POSMDeploymentActivity.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            }
                            break;

                        case 6:
                            listDataHeader = database.getHeaderSalesData(journeyPlan);
                            if (listDataHeader.size() > 0) {
                                startActivity(new Intent(context, FocusProductActivity.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            }

                            break;

                        case 7:
                            startActivity(new Intent(context, FeedBackActivity.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                            overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            break;

                        case 8:
                            startActivity(new Intent(context, JarActivity.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                            overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            break;

                        case 9:
                            if(database.getSOSCategoryMasterData(journeyPlan).size()>0){
                                startActivity(new Intent(context, SOSActivity.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            }
                            break;

                        case 10:
                            if (database.isMonkeySunGrayIcone(journeyPlan.getStoreId())) {
                                startActivity(new Intent(context, MonkeysunActivity.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            }

                            break;

                        case 11:
                            if(database.getSecondaryVisibilityDisplayData(journeyPlan.getStoreTypeId(), journeyPlan.getStoreCategoryId(), journeyPlan.getStateId()).size()>0){
                                startActivity(new Intent(context, SecondaryVisibilityActivity.class).putExtra(CommonString.TAG_OBJECT, journeyPlan).putExtra(CommonString.KEY_MENU_ID, current));
                                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            }

                            break;

                        case 12:

                            break;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView txt;
            ImageView icon;
            LinearLayout lay_menu;

            public MyViewHolder(View itemView) {
                super(itemView);
                txt = (TextView) itemView.findViewById(R.id.list_txt);
                icon = (ImageView) itemView.findViewById(R.id.list_icon);
                lay_menu = (LinearLayout) itemView.findViewById(R.id.lay_menu);
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // NavUtils.navigateUpFromSameTask(this);
            finish();
            overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
        }

        return super.onOptionsItemSelected(item);
    }


    void declaration() {
        context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        visit_date = preferences.getString(CommonString.KEY_DATE, null);
        txt_label = (TextView) findViewById(R.id.txt_label);
        recyclerView = (RecyclerView) findViewById(R.id.rec_menu);
        database = new MondelezDatabase(context);
        database.open();
    }

    private boolean chekDataforCheckout(JourneyPlan journeyPlan) {
        boolean status = true;
        database.open();
        ArrayList<MenuMaster> menu_list = database.getMenuData(journeyPlan.getStoreTypeId(), journeyPlan.getStoreCategoryId());
        for (int i = 0; i < menu_list.size(); i++) {
            switch (menu_list.get(i).getMenuId()) {

                case 3:
                        if (!database.isBackofStoreFilled(journeyPlan.getStoreId())) {
                            status = false;
                        }
                    break;
                case 4:

                        if (!database.isVisiCoolerFilledData(journeyPlan.getStoreId())) {
                            status = false;
                        }
                    break;
                case 5:
                        if (!database.isPosmFilledData(journeyPlan.getStoreId())) {
                            status = false;
                        }
                    break;
                case 6:
                        if (!database.isFocusproductFilled(journeyPlan.getStoreId())) {
                            status = false;
                        }
                    break;
                case 8:
                    if (!database.isJarFilledData(journeyPlan.getStoreId())) {
                        status = false;
                    }
                    break;
                case 10:
                        if (!database.isMonkeySunFilledData(journeyPlan.getStoreId())) {
                            status = false;
                        }
                    break;

                case 1:
                    if (!database.isWindowFilledData(journeyPlan.getStoreId())) {
                        status = false;
                    }
                    break;

                case 11:
                    if (!database.isSecondaryFilledData(journeyPlan.getStoreId())) {
                        status = false;
                    }
                    break;

                case 2:
                    if (!database.isCTUFilledData(journeyPlan.getStoreId())) {
                        status = false;
                    }
                    break;

                case 7:
                    if (!database.isFeedBackFilledData(journeyPlan.getStoreId())) {
                        status = false;
                    }
                    break;
            }
        }

        return status;
    }
}
