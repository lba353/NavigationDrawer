package com.example.student.navigationdrawer;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {

    private TextView myTextVar;
    private Toolbar myToolbarVar;
    private DrawerLayout myDrawerVar;
    private NavigationView myNavVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextVar = (TextView) findViewById(R.id.myText);
        myToolbarVar = (Toolbar) findViewById(R.id.mytoolbar);
        myDrawerVar = (DrawerLayout) findViewById(R.id.myDrawer);
        myNavVar = (NavigationView) findViewById(R.id.mynav);

        setSupportActionBar(myToolbarVar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, myDrawerVar, myToolbarVar, R.string.app_name, R.string.app_name);
        toggle.syncState();

        myNavVar.setNavigationItemSelectedListener(this);
        myNavVar.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.myDrawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            myTextVar.setText("Chose Item 1");
        } else if (id == R.id.item2) {
            myTextVar.setText("Chose Item Button 2");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.myDrawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
