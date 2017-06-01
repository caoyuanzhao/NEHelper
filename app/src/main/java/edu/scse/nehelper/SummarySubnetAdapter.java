package edu.scse.nehelper;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
/**
 * Created by 曹远招 on 2017/5/31.
 */
public class SummarySubnetAdapter extends RecyclerView.Adapter<SummarySubnetAdapter.ViewHolder> {
    private List<SummarySubnet> mSubnetList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView subnetName;
        EditText subnetIp1;
        EditText subnetIp2;
        EditText subnetIp3;
        EditText subnetIp4;

        public ViewHolder(View view) {
            super(view);
            subnetName = (TextView) view.findViewById(R.id.summary_subnet_name);
            subnetIp1 = (EditText) view.findViewById(R.id.summary_edit_text1);
            subnetIp2 = (EditText) view.findViewById(R.id.summary_edit_text2);
            subnetIp3 = (EditText) view.findViewById(R.id.summary_edit_text3);
            subnetIp4 = (EditText) view.findViewById(R.id.summary_edit_text4);

        }
    }

    public SummarySubnetAdapter(List<SummarySubnet> subnetList) {
        mSubnetList = subnetList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subnet_item_edit, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        SummarySubnet subnet = mSubnetList.get(position);
        holder.subnetName.setText(subnet.getName());
        holder.subnetIp1.setText(subnet.getIp1());
        holder.subnetIp2.setText(subnet.getIp2());
        holder.subnetIp3.setText(subnet.getIp3());
        holder.subnetIp4.setText(subnet.getIp4());
        holder.subnetIp1.setTag(position);
        holder.subnetIp2.setTag(position);
        holder.subnetIp3.setTag(position);
        holder.subnetIp4.setTag(position);

        holder.subnetIp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mSubnetList.get(position).setIp1(s.toString());
            }
        });
        holder.subnetIp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mSubnetList.get(position).setIp2(s.toString());
            }
        });
        holder.subnetIp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mSubnetList.get(position).setIp3(s.toString());
            }
        });
        holder.subnetIp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mSubnetList.get(position).setIp4(s.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSubnetList.size();
    }
}
