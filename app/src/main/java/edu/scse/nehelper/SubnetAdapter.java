package edu.scse.nehelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
/**
 * Created by 曹远招 on 2017/5/21.
 */
public class SubnetAdapter extends RecyclerView.Adapter<SubnetAdapter.ViewHolder> {
    private List<Subnet> mSubnetList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView subnetName;
        TextView subnetIp;
        public ViewHolder(View view){
            super(view);
            subnetName=(TextView)view.findViewById(R.id.subnet_name);
            subnetIp=(TextView)view.findViewById(R.id.subnet_ip);
        }
    }
    public SubnetAdapter(List<Subnet> subnetList){
        mSubnetList=subnetList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.subnet_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Subnet subnet=mSubnetList.get(position);
        holder.subnetName.setText(subnet.getName());
        holder.subnetIp.setText(subnet.getIp());
    }

    @Override
    public int getItemCount() {
        return mSubnetList.size();
    }
}
