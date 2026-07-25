package com.programmerid.myandroid.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.programmerid.myandroid.MainActivity;
import com.programmerid.myandroid.databinding.FragmentHomeBinding;
import androidx.fragment.app.Fragment;
import android.widget.Button;
import android.widget.Toast;
import com.programmerid.myandroid.fragments.AboutFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
      

        binding = FragmentHomeBinding.inflate(inflater, container, false);

      binding.btnStart.setOnClickListener(v -> {
        String btnNotReady = "Belum Mulai";
        String btnReady = "Belajar Android Dimulai 🚀";
        String btnText = binding.tvStatus.getText().toString();
        Toast.makeText(getContext(), "Selamat Belajar Android Native", Toast.LENGTH_SHORT).show();
        binding.btnStart.setText("Selamat Belajar Android Native");

        if(btnText.equals(btnNotReady)){
          
      binding.tvStatus.setText(btnReady);
        }else{
          binding.tvStatus.setText(btnNotReady);
        }
      });
    binding.aboutPage.setOnClickListener(v -> {
    ((MainActivity) requireActivity()).loadFragment(new AboutFragment());
    });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}