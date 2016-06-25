package angelhacktaipei.project.yen.lihao;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Yan on 6/11/16.
 */
public class SelectReceiverGenderFragment extends Fragment {
    private OnSelectReceiverGenderListener OnSelectReceiverGenderListener;
    private LinearLayout llUpper;
    private ImageView imvIgnore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_receiver_gender, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        llUpper = (LinearLayout) view.findViewById(R.id.fragment_select_receiver_ll_upper);
        imvIgnore = (ImageView) view.findViewById(R.id.fragment_select_receiver_imv_gender_ignore);
        initListener();
    }

    private void initListener(){
        llUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSelectReceiverGenderListener.onClickReceiverGender();
            }
        });

        imvIgnore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSelectReceiverGenderListener.onClickReceiverGender();
            }
        });
    }

    public interface OnSelectReceiverGenderListener{
        void onClickReceiverGender();
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            OnSelectReceiverGenderListener = (OnSelectReceiverGenderListener) activity;
        } catch (ClassCastException exception){
            Log.e(getActivity().getPackageName(), exception.toString());
        }
    }
}
