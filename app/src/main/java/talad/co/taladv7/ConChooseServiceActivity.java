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
                .withHeaderBackground(R.drawable.header)
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
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("");

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbarHome)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),//divides draws
                        item2,
                        new SecondaryDrawerItem().withName("Payment"),
                        new SecondaryDrawerItem().withName("Support"),
                        new SecondaryDrawerItem().withName("Feedback"),
                        new SecondaryDrawerItem().withName("Settings"),
                        new SecondaryDrawerItem().withName("Switch Mode"),
                        new DividerDrawerItem(),
                        item3,
                        new SecondaryDrawerItem().withName("LogOut")

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
                                Intent intent = new Intent(getApplicationContext(), TabMainActivity.class);
                                startActivity(intent);
                                break;
                        }
                        return true;
                    }
                })
                .build();
        //End of Nav drawer
    }
}
