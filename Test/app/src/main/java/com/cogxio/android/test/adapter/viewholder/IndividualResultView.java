package com.cogxio.android.test.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cogxio.android.test.R;

/**
 * Created by Abhishek on 28/11/15.
 */
public class IndividualResultView extends RecyclerView.ViewHolder {

    public ImageView resultImageIv;
    public TextView nameTv,descriptionTv,priceTv,sizeTv,colourTv;
    public View holderView;

    public IndividualResultView(View itemView) {
        super(itemView);
        holderView = itemView;
        resultImageIv = (ImageView) itemView.findViewById(R.id.result_image_iv);
        nameTv = (TextView) itemView.findViewById(R.id.name_tv);
        descriptionTv = (TextView) itemView.findViewById(R.id.description_tv);
        priceTv = (TextView) itemView.findViewById(R.id.price_tv);
        sizeTv = (TextView) itemView.findViewById(R.id.size_tv);
        colourTv = (TextView) itemView.findViewById(R.id.colour_tv);
    }
}
