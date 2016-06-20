package edu.bruno.applicationwithoutguideline;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 6/20/16.
 */
public class DrawerMenuActivity extends AppCompatActivity implements Drawer.OnDrawerListener, Drawer.OnDrawerItemClickListener {

    @BindView(R.id.activty_drawer_menu_toolbar)
    Toolbar mToolbar;

    private Drawer mDrawerMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_menu);
        ButterKnife.bind(this);

        setupToolbar();
        setupDrawerMenu();
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        mToolbar.setSubtitle("Drawer menu");
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        mToolbar.setSubtitleTextColor(ContextCompat.getColor(this, android.R.color.white));
    }

    private void setupDrawerMenu() {

        //create header
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
        View header = getLayoutInflater().inflate(R.layout.drawer_menu_header, viewGroup, false);
        Toolbar toolbarHeader = (Toolbar) header.findViewById(R.id.drawer_toolbar);
        toolbarHeader.setTitle("Título header");
        toolbarHeader.setSubtitle("Subtítulo header");
        toolbarHeader.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        toolbarHeader.setSubtitleTextColor(ContextCompat.getColor(this, android.R.color.white));

        //create footer
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView footerTextView = new TextView(this);
        footerTextView.setTextColor(ContextCompat.getColor(this, R.color.text_view_text_color));
        footerTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        footerTextView.setPadding(8, 8, 8, 8);
        footerTextView.setSingleLine(true);
        footerTextView.setMaxLines(1);
        footerTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        footerTextView.setText("Texto footer");
        linearLayout.addView(footerTextView);

        mDrawerMenu = new DrawerBuilder()
                .withActivity(this)
                .withHeader(header)
                .withOnDrawerItemClickListener(this)
                .withOnDrawerListener(this)
                .withSelectedItem(-1)
                .withActionBarDrawerToggle(false)
                .withDisplayBelowStatusBar(true)
                .withDrawerGravity(Gravity.END)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Item 1").withIcon(R.mipmap.ic_reply_black_36dp).withIdentifier(R.id.drawer_menu_item_1),
                        new PrimaryDrawerItem().withName("Item 2").withIcon(R.mipmap.ic_autorenew_black_36dp).withIdentifier(R.id.drawer_menu_item_2),
                        new PrimaryDrawerItem().withName("Item 3").withIcon(R.mipmap.ic_file_upload_black_36dp).withIdentifier(R.id.drawer_menu_item_3)
                                .withBadgeStyle(new BadgeStyle()
                                        .withTextColor(Color.WHITE)
                                        .withColorRes(R.color.primary)),
                        new PrimaryDrawerItem().withName("Item 4").withIcon(R.mipmap.ic_swap_horiz_black_36dp).withIdentifier(R.id.drawer_menu_item_4),
                        new PrimaryDrawerItem().withName("Item 5").withIcon(R.mipmap.ic_pin_36dp).withIdentifier(R.id.drawer_menu_item_5),
                        new PrimaryDrawerItem().withName("Item 6").withIcon(R.mipmap.ic_calendar_36dp).withIdentifier(R.id.drawer_menu_item_6),
                        new PrimaryDrawerItem().withName("Item 7").withIcon(R.mipmap.ic_group_36dp).withIdentifier(R.id.drawer_menu_item_7),
                        new PrimaryDrawerItem().withName("Item 8").withIcon(R.mipmap.ic_search_black_36dp).withIdentifier(R.id.drawer_menu_item_8)
                )
                .withStickyFooter(linearLayout)
                .build();

        mDrawerMenu.setStatusBarColor(ContextCompat.getColor(this, R.color.primary_dark));
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

        switch (drawerItem.getIdentifier()) {
            default:
                Toast.makeText(this, "Item " + position + " - Posição: " + position, Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        PrimaryDrawerItem item = (PrimaryDrawerItem) mDrawerMenu.getDrawerItem(R.id.drawer_menu_item_3);
        item.withBadge("1234");
        item.withEnabled(true);
        mDrawerMenu.updateItem(item);
    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_bar_menu_drawer:
                mDrawerMenu.openDrawer();
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
