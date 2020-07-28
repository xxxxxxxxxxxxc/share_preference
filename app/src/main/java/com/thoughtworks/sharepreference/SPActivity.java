package com.thoughtworks.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SPActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @BindView(R.id.sp_value)
    EditText editText;

    @OnClick(R.id.save)
    void save() {
        String editorValue = this.editText.getText().toString();

        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putString(getString(R.string.sp_value), editorValue);
        edit.apply();
        Log.d("share_preference", String.format("save value %s", editorValue));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        ButterKnife.bind(this);

        Context baseContext = getBaseContext();
        this.sharedPreferences = baseContext.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(getString(R.string.sp_value), "");
        editText.setText(value);
    }
}
