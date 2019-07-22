package ru.geekbrains.socialnetwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SocSource sourceData = new SocSource(getResources());
        initRecyclerView(sourceData.build());
    }

    private void initRecyclerView(SocSource data)
    {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        SocialNetworkAdapter socnetAdapter = new SocialNetworkAdapter(data);
        recyclerView.setAdapter(socnetAdapter);

        socnetAdapter.SetOnItemClickListener(new SocialNetworkAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, String.format("%s - %d", ((TextView)view).getText(), position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
