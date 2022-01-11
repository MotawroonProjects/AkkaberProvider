package com.apps.akkaber_provider.uis.activity_home.fragments_app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.Navigation;

import com.apps.akkaber_provider.R;
import com.apps.akkaber_provider.databinding.FragmentLanguageBinding;
import com.apps.akkaber_provider.uis.activity_base.BaseFragment;
import com.apps.akkaber_provider.uis.activity_home.HomeActivity;
import com.apps.akkaber_provider.uis.activity_login.LoginActivity;

import java.util.List;


public class FragmentLanguage extends BaseFragment {
    private static final String TAG = FragmentLanguage.class.getName();
    private HomeActivity activity;
    private FragmentLanguageBinding binding;
    private String lang = "";
    private String selectedLang;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (HomeActivity) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_language, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        Log.e(TAG, "onViewCreated: ");

    }

    private void initView() {


        lang = getLang();
        selectedLang = lang;
        if (lang.equals("ar")) {
            binding.flAr.setBackgroundResource(R.drawable.small_stroke_primary);
            binding.flEn.setBackgroundResource(0);

        } else {
            binding.flAr.setBackgroundResource(0);
            binding.flEn.setBackgroundResource(R.drawable.small_stroke_primary);

        }

        binding.cardAr.setOnClickListener(view -> {
            selectedLang = "ar";

            if (!selectedLang.equals(lang)) {
                binding.btnNext.setVisibility(View.VISIBLE);

            } else {
                binding.btnNext.setVisibility(View.INVISIBLE);

            }
            binding.flAr.setBackgroundResource(R.drawable.small_stroke_primary);
            binding.flEn.setBackgroundResource(0);

        });

        binding.cardEn.setOnClickListener(view -> {
            selectedLang = "en";
            if (!selectedLang.equals(lang)) {
                binding.btnNext.setVisibility(View.VISIBLE);

            } else {
                binding.btnNext.setVisibility(View.INVISIBLE);

            }
            binding.flAr.setBackgroundResource(0);
            binding.flEn.setBackgroundResource(R.drawable.small_stroke_primary);
        });

        binding.btnNext.setOnClickListener(view -> {
            activity.refreshActivity(selectedLang);
        });


    }



}