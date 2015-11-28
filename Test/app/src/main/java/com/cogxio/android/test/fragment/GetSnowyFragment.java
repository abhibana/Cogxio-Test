package com.cogxio.android.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cogxio.android.test.R;
import com.cogxio.android.test.activity.MainActivity;
import com.cogxio.android.test.adapter.ResultsListAdapter;
import com.cogxio.android.test.network.ResponseTranslator;
import com.cogxio.android.test.network.response.SnowyResult;
import com.cogxio.android.test.utils.SharedPreferencesUtils;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * Created by Abhishek on 28/11/15.
 */
public class GetSnowyFragment extends Fragment implements View.OnClickListener{

    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View snowyFragmentView = inflater.inflate(R.layout.fragment_get_snowy, container, false);
        RecyclerView resultsRv = (RecyclerView) snowyFragmentView.findViewById(R.id.results_rv);
        FloatingActionButton createFabButton = (FloatingActionButton) snowyFragmentView.findViewById(R.id.create_fab);
        FloatingActionButton deleteFabButton = (FloatingActionButton) snowyFragmentView.findViewById(R.id.delete_fab);
        FloatingActionButton sendFabButton = (FloatingActionButton) snowyFragmentView.findViewById(R.id.send_fab);
        createFabButton.setOnClickListener(this);
        deleteFabButton.setOnClickListener(this);
        sendFabButton.setOnClickListener(this);
        mainActivity = (MainActivity)getActivity();
        setUpResults(resultsRv);

        return snowyFragmentView;
    }

    private void setUpResults(RecyclerView resultsRv){

        String results = SharedPreferencesUtils.getStoredResults(mainActivity);
        ArrayList<SnowyResult> snowyResults;
        if(!results.equals("")){
            snowyResults = ResponseTranslator.getSnowyResultList(new JsonParser().parse(results).getAsJsonObject());

        }else{
            snowyResults = new ArrayList<>();
            Toast.makeText(mainActivity,getString(R.string.no_data),Toast.LENGTH_SHORT).show();
        }

        resultsRv.setAdapter(new ResultsListAdapter(mainActivity, snowyResults));
        LinearLayoutManager layoutManager = new LinearLayoutManager(mainActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        resultsRv.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.create_fab :  Toast.makeText(mainActivity,"Clicked on Create Fab",Toast.LENGTH_SHORT).show();
                                    break;

            case R.id.delete_fab :  Toast.makeText(mainActivity,"Clicked on Delete Fab",Toast.LENGTH_SHORT).show();
                                    break;

            case R.id.send_fab  :   Toast.makeText(mainActivity,"Clicked on Send Fab",Toast.LENGTH_SHORT).show();
                                    break;
        }
    }
}
