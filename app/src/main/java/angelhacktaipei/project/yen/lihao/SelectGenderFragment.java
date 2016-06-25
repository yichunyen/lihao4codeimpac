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
 * Created by Yan on 6/11/16.
 */
public class SelectGenderFragment extends Fragment {
    private OnSelectGenderListener OnSelectGenderListener;
    private ImageView imvFemale;
    private ImageView imvMale;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_gender, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
//        imvFemale = (ImageView) view.findViewById(R.id.fragment_select_gender_imv_female);
        imvMale = (ImageView) view.findViewById(R.id.fragment_select_gender_imv_male);
        initListener();
    }

    private void initListener(){
//        imvFemale.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OnSelectGenderListener.click();
//            }
//        });

        imvMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSelectGenderListener.click();
            }
        });
    }

    public interface OnSelectGenderListener{
        void click();
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            OnSelectGenderListener = (OnSelectGenderListener) activity;
        } catch (ClassCastException exception){
            Log.e(getActivity().getPackageName(), exception.toString());
        }
    }
}
