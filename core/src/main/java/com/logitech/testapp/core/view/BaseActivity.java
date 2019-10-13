package com.logitech.testapp.core.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.logitech.testapp.core.R;

/**
 * Created by Vigneshwaran G on 14/10/19.
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initContentView();
        initDaggerComponents();
        initArguments();
        initView();
        initViewModel();
        initObservers();
        initLoad();
    }

    /**
     * Method to init Content view for the activity
     */
    protected abstract void initContentView();

    /**
     * Method to initDagger components
     */
    protected abstract void initDaggerComponents();

    /**
     * Method to initialize views
     */
    protected abstract void initView();

    /**
     * Method to init arguments that are sent from calling activity
     */
    protected abstract void initArguments();

    /**
     * Method to init ViewModel
     */
    protected abstract void initViewModel();

    /**
     * Method to observer the observers of viewModel for results
     */
    protected abstract void initObservers();

    /**
     * Method to load the data after view is created
     */
    protected abstract void initLoad();

    /**
     * Method to show error toast message
     *
     * @param errorMessage The Error message
     */
    protected void showErrorToast(String errorMessage) {
        Toast.makeText(this, !TextUtils.isEmpty(errorMessage) ? errorMessage : getString(R.string.generic_error), Toast.LENGTH_SHORT).show();
    }

}
