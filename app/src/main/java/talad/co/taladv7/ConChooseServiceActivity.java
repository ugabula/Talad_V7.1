package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

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

/**
 * Created by cvanderhaar on 2018/07/09.
 */

public class ConChooseServiceActivity extends AppCompatActivity {

    Button btnBuy, btnProvide;
    Toolbar toolbarHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_mode);

        btnBuy = (Button) findViewById(R.id.buy);
        btnProvide = (Button) findViewById(R.id.provide);
        toolbarHome = (Toolbar) findViewById(R.id.toolBarHome);
        toolbarHome.setTitle("Talad");
        toolbarHome.setTitleTextColor(getResources().getColor(R.color.white));

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
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Your Services");
        SecondaryDrawerItem item4 = new SecondaryDrawerItem().withIdentifier(4).withName("Your Machinery");
        SecondaryDrawerItem item5 = new SecondaryDrawerItem().withIdentifier(5).withName("Your Availability");
        SecondaryDrawerItem item6 = new SecondaryDrawerItem().withIdentifier(6).withName("Payment");
        SecondaryDrawerItem item7 = new SecondaryDrawerItem().withIdentifier(7).withName("Support");
        SecondaryDrawerItem item8 = new SecondaryDrawerItem().withIdentifier(8).withName("Feedback");
        SecondaryDrawerItem item9 = new SecondaryDrawerItem().withIdentifier(9).withName("Settings");
        SecondaryDrawerItem item10 = new SecondaryDrawerItem().withIdentifier(10).withName("Switch Mode");
        SecondaryDrawerItem item11 = new SecondaryDrawerItem().withIdentifier(11).withName("LogOut").withIcon(R.drawable.user);

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbarHome)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item4,
                        item5,
                        new DividerDrawerItem(),//divides draws
                        item6,
                        item7,
                        item8,
                        item9,
                        item10,
                        new DividerDrawerItem(),
                        item11,
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
                                Intent intent = new Intent(getApplicationContext(), ContractorProfileActivity.class);
                                startActivity(intent);
                                break;
                            case 3 :
                                Intent service = new Intent(getApplicationContext(), ConServicesActivity.class);
                                startActivity(service);
                                break;
                            case 4 :
                                Intent pay = new Intent(getApplicationContext(), ConAddMachinery.class);
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

        btnProvide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choose = new Intent(ConChooseServiceActivity.this, ConTabMainActivity.class);
                startActivity(choose);
            }
        });
    }
}
