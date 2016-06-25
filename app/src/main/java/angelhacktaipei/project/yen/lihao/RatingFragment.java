package angelhacktaipei.project.yen.lihao;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Yan on 6/12/16.
 */
public class RatingFragment extends Fragment {
    private ImageView imvSatisfy;
    private ImageView imvUnSatify;
    private OnRateMemberListener OnRateMemberListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rating, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        imvSatisfy = (ImageView) view.findViewById(R.id.fragment_rating_imv_satisfy);
        imvUnSatify = (ImageView) view.findViewById(R.id.fragment_rating_imv_unsatisfy);
        initListener();
    }

    private void initListener(){
        imvSatisfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnRateMemberListener.onSatisfy();
            }
        });

        imvUnSatify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnRateMemberListener.onUnSatisfy();
            }
        });
    }

    public interface OnRateMemberListener{
        void onSatisfy();
        void onUnSatisfy();
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            OnRateMemberListener = (OnRateMemberListener) activity;
        } catch (ClassCastException exception){
            Log.e(getActivity().getPackageName(), exception.toString());
        }
    }
}
