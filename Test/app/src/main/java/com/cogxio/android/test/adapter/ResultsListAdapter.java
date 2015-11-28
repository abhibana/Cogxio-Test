package com.cogxio.android.test.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cogxio.android.test.R;
import com.cogxio.android.test.adapter.viewholder.IndividualResultView;
import com.cogxio.android.test.network.response.SnowyResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Abhishek on 28/11/15.
 */
public class ResultsListAdapter extends RecyclerView.Adapter<IndividualResultView> {

    private ArrayList<SnowyResult> snowyResultList;
    private Context context;

    public ResultsListAdapter(Context context, ArrayList<SnowyResult> snowyResultList){
        this.context = context;
        this.snowyResultList = snowyResultList;
    }

    @Override
    public IndividualResultView onCreateViewHolder(ViewGroup parent, int viewType) {

        View holderView = LayoutInflater.from(context).inflate(R.layout.layout_single_result_row,parent,false);
        return new IndividualResultView(holderView);
    }

    @Override
    public void onBindViewHolder(IndividualResultView holder, int position) {

        setValuesToHolderViews(holder,position);
    }

    @Override
    public int getItemCount() {
        return snowyResultList.size();
    }

    private void setValuesToHolderViews(IndividualResultView holder, int position){

        final SnowyResult snowyResult = snowyResultList.get(position);

        Picasso.with(context).load(snowyResult.getImageUrl()).fit().into(holder.resultImageIv);
        holder.nameTv.setText(snowyResult.getName());
        holder.descriptionTv.setText(snowyResult.getDescription());
        holder.priceTv.setText(snowyResult.getPrice());
        holder.sizeTv.setText(snowyResult.getSize());
        holder.colourTv.setText(snowyResult.getColour());
        holder.holderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent internetIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(snowyResult.getProductLink()));
                internetIntent.setComponent(new ComponentName("com.android.browser","com.android.browser.BrowserActivity"));
                internetIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(internetIntent);
            }
        });
    }
}
