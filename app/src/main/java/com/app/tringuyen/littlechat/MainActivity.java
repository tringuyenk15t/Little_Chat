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

import com.app.tringuyen.littlechat.fragments.ChatFragment;
import com.app.tringuyen.littlechat.fragments.FriendListFragment;
import com.app.tringuyen.littlechat.fragments.LoginFragment;
import com.bumptech.glide.Glide;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

import org.greenrobot.eventbus.EventBus;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private TextView tvName;
    private ImageView imAvatar;
//    private TextView tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Crab chat");
        setSupportActionBar(toolbar);

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

    public void setProfile (String name, String url)
    {
        tvName.setText(name);
//        tvEmail.setText(email);
        Glide
            .with(this)
            .load(url)
            .centerCrop()
            .into(imAvatar);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    /**
     * Put the right fragment into container when starting app
     */
    private void initFragment() {
//        enableDisableDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        ChatFragment loginFragment = new ChatFragment();
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
                switch(id)
                {
                    case R.id.friend_list:
                        Toast.makeText(getApplicationContext(),"Friend list has been clicked!",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logout:
                        Toast.makeText(getApplicationContext(),"Logout list has been clicked!",Toast.LENGTH_SHORT).show();
                        LoginManager.getInstance().logOut();
                        //TODO back to login fragment and lock drawrelayout
                        break;
                }
                return false;
            }
        });
        View header = navigationView.getHeaderView(0);
        tvName = (TextView) header.findViewById(R.id.tv_name);
//        tvEmail = (TextView) header.findViewById(R.id.tv_email);

        imAvatar = (ImageView) header.findViewById(R.id.im_avatar);

        tvName.setText("Tringuyenk15t@gmail.com");

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


    @Override
    protected void onRestart() {
        super.onRestart();
        LoginManager.getInstance().logOut();
    }

    @Override
    protected void onStop() {
        LoginManager.getInstance().logOut();
        super.onStop();
    }

}
