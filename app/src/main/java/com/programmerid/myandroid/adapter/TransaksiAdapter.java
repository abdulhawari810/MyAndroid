package com.programmerid.myandroid.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.programmerid.myandroid.data.model.Transaksi;
import com.programmerid.myandroid.databinding.ItemTransaksiBinding;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.ViewHolder> {
    private List<Transaksi> list = new ArrayList<>();

    public void setData(List<Transaksi> newList) {
        list = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTransaksiBinding binding = ItemTransaksiBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Transaksi t = list.get(position);
        holder.binding.tvKategori.setText(t.getKategori());
        holder.binding.tvTanggal.setText(t.getTanggal());
        holder.binding.tvCatatan.setText(t.getCatatan());

        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        String jumlah = format.format(t.getJumlah());
        if (t.getJenis().equals("Pengeluaran")) {
            jumlah = "- " + jumlah;
            holder.binding.tvJumlah.setTextColor(0xFFFF0000); // merah
        } else {
            jumlah = "+ " + jumlah;
            holder.binding.tvJumlah.setTextColor(0xFF00AA00); // hijau
        }
        holder.binding.tvJumlah.setText(jumlah);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemTransaksiBinding binding;
        public ViewHolder(ItemTransaksiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}