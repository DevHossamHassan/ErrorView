package com.letsgotoperfection.errorviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.letsgotoperfection.errorview.ErrorView;
import com.letsgotoperfection.errorviewsample.utils.Internet;

public class MainActivity extends AppCompatActivity {

    ErrorView errorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errorView = findViewById(R.id.errorView1);
        //If the device is not connected to the internet show the error view
        if (!Internet.haveNetworkConnection(this.getApplication())) {
            errorView.setVisibility(View.VISIBLE);
        }
    }
}
