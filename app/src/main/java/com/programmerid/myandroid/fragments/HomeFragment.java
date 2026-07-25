package com.programmerid.myandroid.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.InputStream;

import androidx.fragment.app.Fragment;

import com.programmerid.myandroid.activities.MainActivity;
import com.programmerid.myandroid.data.db.AppDatabase;
import com.programmerid.myandroid.data.model.Transaksi;
import com.programmerid.myandroid.adapter.TransaksiAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.programmerid.myandroid.databinding.FragmentHomeBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private AppDatabase db;
    private TransaksiAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        db = AppDatabase.getInstance(requireContext());

        binding.btnSimpan.setOnClickListener(v -> simpanTransaksi());

        binding.btnKeLaporan.setOnClickListener(v -> {
            // nanti kita bikin LaporanFragment
            Toast.makeText(getContext(), "Buka Laporan", Toast.LENGTH_SHORT).show();
        });

        binding.aboutPage.setOnClickListener(s-> {
            ((MainActivity) requireActivity()).loadFragment(new AboutFragment());
        });

      binding.btnExport.setOnClickListener(v -> {
    try {
        File dbFile = requireContext().getDatabasePath("duit_aktivitas_db");
        File exportDir = new File(requireContext().getExternalFilesDir(null), "backup");
        if(!exportDir.exists()) exportDir.mkdirs();

        File exportFile = new File(exportDir, "duit_aktivitas_db");
        copyFile(dbFile, exportFile);
        Toast.makeText(getContext(), "DB diexport ke: " + exportFile.getPath(), Toast.LENGTH_LONG).show();
    } catch (Exception e) {
        e.printStackTrace();
    }
});

      // Setup RecyclerView
        adapter = new TransaksiAdapter();
        binding.rvTransaksi.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvTransaksi.setAdapter(adapter);

        // Ambil data dari DB
        loadData();

        binding.btnSimpan.setOnClickListener(v -> simpanTransaksi());
        // ... sisanya sama


        return binding.getRoot();
    }

  private void copyFile(File src, File dst) throws IOException {
    try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) out.write(buf, 0, len);
    }
}

  private void loadData() {
        db.transaksiDao().getAllTransaksi().observe(getViewLifecycleOwner(), transaksi -> {
            adapter.setData(transaksi);
        });
    }

    private void simpanTransaksi() {
        String jumlahStr = binding.etJumlah.getText().toString().trim();
        String kategori = binding.etKategori.getText().toString().trim();
        String catatan = binding.etCatatan.getText().toString().trim();

        int selectedId = binding.rgJenis.getCheckedRadioButtonId();
        if (selectedId == -1 || jumlahStr.isEmpty() || kategori.isEmpty()) {
            Toast.makeText(getContext(), "Lengkapi semua data!", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton rb = binding.rgJenis.findViewById(selectedId);
        String jenis = rb.getText().toString();

        double jumlah = Double.parseDouble(jumlahStr);
        String tanggal = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        Transaksi transaksi = new Transaksi(jenis, kategori, jumlah, tanggal, catatan);

        // Simpan di background thread
        new Thread(() -> {
            db.transaksiDao().insert(transaksi);
            requireActivity().runOnUiThread(() -> {
                Toast.makeText(getContext(), "Transaksi disimpan!", Toast.LENGTH_SHORT).show();
                binding.etJumlah.setText("");
                binding.etKategori.setText("");
                binding.etCatatan.setText("");
                binding.rgJenis.clearCheck();
            });
        }).start();
    }
  

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
