package com.example.a3zadanie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class TaskListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }
}