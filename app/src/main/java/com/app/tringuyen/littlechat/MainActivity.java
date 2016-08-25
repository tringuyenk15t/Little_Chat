package com.app.tringuyen.littlechat;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.tringuyen.littlechat.fragments.LoginFragment;
import com.facebook.FacebookSdk;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    protected TextView tvEmail;
    protected ImageView imAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Crab chat");
        setSupportActionBar(toolbar);

        tvEmail = (TextView) findViewById(R.id.tv_email);
        imAvatar = (ImageView) findViewById(R.id.im_avatar);

        initNavigationDrawer();
        initFragment();

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
//        if (findViewById(R.id.fragment_container) != null) {
//            if (savedInstanceState != null) {
//                return;
//            }
//            LoginFragment loginFragment = new LoginFragment();
//            Bundle bundle = new Bundle();
//
//            //TODO: push data through fragments
//            bundle.putString("TextTrans", "Data has been transferred");
//            loginFragment.setArguments(bundle);
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragment_container, loginFragment)
//                    .addToBackStack("FRAGMENT1")
//                    .commit();
//        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    /**
     * Put the right fragment into container when starting app
     */
    private void initFragment() {
        LoginFragment loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, loginFragment)
                .addToBackStack("LOGIN")
                .commit();
    }

    /**
     * setup drawer navigation and click events on it
     */
    private void initNavigationDrawer() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                //TODO handle drawer navigation click
                switch(id)
                {
                    case R.id.friend_list:
                        Toast.makeText(getApplicationContext(),"Friend list has been clicked!",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logout:
                        Toast.makeText(getApplicationContext(),"Logout list has been clicked!",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        View header = navigationView.getHeaderView(0);
        TextView txtEmail = (TextView) header.findViewById(R.id.tv_email);
        txtEmail.setText("Tringuyenk15t@gmail.com");
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close)
        {
            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    /**
     * visible or disable drawer navigation bar
     * @param mode
     */
    public void enableDisableDrawer(int mode) {
        if (drawerLayout != null) {
            drawerLayout.setDrawerLockMode(mode);
        }
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    protected void onStop() {
//        EventBus.getDefault().unregister(this);
//        super.onStop();
//    }

}
