package com.example.m1lesson39_navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m1lesson39_navigation.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }

    private String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("name");
        }
    }

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        binding.tv.setText(name);

        binding.floatBtn.setOnClickListener(view -> {
            // shu fragmentni close qiladi, stackdan ham o'chiradi
            Navigation.findNavController(binding.getRoot()).popBackStack();
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}