package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import talad.co.taladv7.fragment.ConNotifyFragment;
import talad.co.taladv7.fragment.ConOngoingFragment;
import talad.co.taladv7.fragment.ConScheduleFragment;
import talad.co.taladv7.helper.BottomNavigationBehavior;

/**
 * Created by cvanderhaar on 2018/08/02.
 */

public class ConTabMainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.con_bottom_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Talad");
        toolbar.setTitleTextColor(getResources().getColor(R.color.blue));

        BottomNavigationView conmenu = (BottomNavigationView) findViewById(R.id.conmenu);
        conmenu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) conmenu.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        // load the store fragment by default
//        toolbar.setTitle("Ongoing");
        loadFragment(new ConOngoingFragment());

        //NAV DRAWER STARTS Account header for Nav drawer
        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.white)
                .addProfiles(
                        new ProfileDrawerItem().withName("Talad").withEmail("support@trclngroup.co.za").withIcon(getResources().getDrawable(R.drawable.new_logo))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home");//Hard coded string
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Edit Profile");
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Payment");
        SecondaryDrawerItem item4 = new SecondaryDrawerItem().withIdentifier(4).withName("Support");
        SecondaryDrawerItem item5 = new SecondaryDrawerItem().withIdentifier(5).withName("Feedback");
        SecondaryDrawerItem item6 = new SecondaryDrawerItem().withIdentifier(6).withName("Settings");
        SecondaryDrawerItem item7 = new SecondaryDrawerItem().withIdentifier(7).withName("Switch Mode");
        SecondaryDrawerItem item8 = new SecondaryDrawerItem().withIdentifier(8).withName("LogOut").withIcon(R.drawable.user);

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        item2,
                        new DividerDrawerItem(),//divides draws
                        item3,
                        item4,
                        item5,
                        item6,
                        item7,
                        new DividerDrawerItem(),
                        item8,
                        new SecondaryDrawerItem()

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch (position){
                            case 1 :
                                Intent i = new Intent(getApplicationContext(), GetStartedActivity.class);
                                startActivity(i);
                                break;
                            case 2 :
                                Intent intent = new Intent(getApplicationContext(), FarmerCreateAccActivity.class);
                                startActivity(intent);
                                break;
                            case 3 :
                                break;
                            case 4 :
                                Intent pay = new Intent(getApplicationContext(), FarmerPayActivity.class);
                                startActivity(pay);
                                break;
                            case 5 :
                                Intent support = new Intent(getApplicationContext(), FarmerSupportMenu.class);
                                startActivity(support);
                                break;
                            case 6 :
                                Intent feedback = new Intent(getApplicationContext(), FeedbackActivity.class);
                                startActivity(feedback);
                                break;
                            case 7 :
                                Intent settings = new Intent(getApplicationContext(), LanSelectActivity.class);
                                startActivity(settings);
                                break;
                            case 8 :
                                Intent mode = new Intent(getApplicationContext(), FarmerChooseServiceActivity.class);
                                startActivity(mode);
                                break;
                            case 9 :
                                Intent logout = new Intent(getApplicationContext(), FarmerPayActivity.class);
                                startActivity(logout);
                        }
                        return true;
                    }
                })
                .build();
        //End of Nav drawer

}

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.ongoing:
                    //toolbar.setTitle("Ongoing");
                    fragment = new ConOngoingFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.schdule:
                    //toolbar.setTitle("Schedule");
                    fragment = new ConScheduleFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.notify:
                    //toolbar.setTitle("Schedule");
                    fragment = new ConNotifyFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
