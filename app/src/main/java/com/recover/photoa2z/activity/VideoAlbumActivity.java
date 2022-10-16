package com.recover.photoa2z.activity;

import static com.recover.photoa2z.utills.Utils.mAlbumVideos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.appbar.MaterialToolbar;
import com.recover.photoa2z.R;
import com.recover.photoa2z.adapter.AlbumsVideoAdapter;
import com.recover.photoa2z.ads.AdmobAdsModel;

public class VideoAlbumActivity extends AppCompatActivity implements AlbumsVideoAdapter.OnClickItemListener {

    RecyclerView recyclerView;
    AlbumsVideoAdapter adapter;

    MaterialToolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_album);

        new AdmobAdsModel(this).bannerAds(this, findViewById(R.id.adsView));
        intView();
        intData();
    
    }

    private void intData() {
        Log.e("01122", "intData: " + mAlbumVideos.size());
        adapter = new AlbumsVideoAdapter(VideoAlbumActivity.this, mAlbumVideos, VideoAlbumActivity.this);
        recyclerView.setAdapter(adapter);
    }

    private void intView() {
        recyclerView = (RecyclerView) findViewById(R.id.gv_folder);
        toolBar = findViewById(R.id.toolBar);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        toolBar.setNavigationOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onClickItem(int position) {
        Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
        intent.putExtra("value", position);
        startActivity(intent);
    }
}