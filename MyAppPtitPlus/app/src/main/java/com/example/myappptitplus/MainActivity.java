package com.example.myappptitplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adapter.NewsHomeAdapter;
import com.example.model.BanDo;
import com.example.model.DiemThi;
import com.example.model.GiaoVu;
import com.example.model.GioiThieu;
import com.example.model.HomeApp;
import com.example.model.LichThi;
import com.example.model.LienHe;
import com.example.model.SoTay;
import com.example.model.TimBus;
import com.example.model_item.NewsHome;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView txt_label ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // dua cac thuoc tinh vao chuong trinh
        addcontrols();
    }

    private void addcontrols() {
        // thiet lap trang chu vao dau ung dung
        //khoi tao trang bang fragment
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.main,new HomeApp()).commit();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.action_exit){
            // thoat chuong trinhf
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            //khoi tao trang bang fragment
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.main,new HomeApp()).commit();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Trang Chủ");
            // Handle the camera action
        } else if (id == R.id.nav_giaovu) {
            //khoi tao trang bang fragment
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.main,new GiaoVu()).commit();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Giáo Vụ");

        } else if (id == R.id.nav_diemthi) {
            //khoi tao trang bang fragment
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.main,new DiemThi()).commit();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Điểm Thi");

        } else if (id == R.id.nav_lichthi) {
            //khoi tao trang bang fragment
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.main,new LichThi()).commit();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Lịch Thi");

        } else if(id == R.id.nav_map){
            //khoi tao trang bang fragment
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.main,new BanDo()).commit();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Sổ Tay");;

        } else if(id == R.id.nav_bus){
            //khoi tao trang bang fragment
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.main,new TimBus()).commit();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Bus");

        } else if(id == R.id.nav_note){
            //khoi tao trang bang fragment
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.main,new SoTay()).commit();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Sổ Tay");

        } else if(id == R.id.nav_intro){
            //khoi tao trang bang fragment
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.main,new GioiThieu()).commit();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Giới Thiệu");

        } else if(id == R.id.nav_contact){
            //khoi tao trang bang fragment
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.main,new LienHe()).commit();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Liên Hệ");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
