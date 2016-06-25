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
public class SelectLanguageFragment extends Fragment {
    private ImageView imvChinese;
    private ImageView imvTaiwanese;
    private ImageView imvConfirm;
    private OnSelectLanguageListener OnSelectLanguageListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_language, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View v){
        imvChinese = (ImageView) v.findViewById(R.id.fragment_language_imv_chinese);
        imvTaiwanese = (ImageView) v.findViewById(R.id.fragment_language_imv_taiwanese);
        imvConfirm = (ImageView) v.findViewById(R.id.fragment_language_imv_confirm);
        initListener();
    }

    private void initListener(){
        imvChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imvChinese.setImageResource(R.drawable.lang1_clicked);
            }
        });
        imvTaiwanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imvTaiwanese.setImageResource(R.drawable.lang2_clicked);
            }
        });

        imvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSelectLanguageListener.onClickLanguage();
            }
        });
    }



    public interface OnSelectLanguageListener{
        void onClickLanguage();
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            OnSelectLanguageListener = (OnSelectLanguageListener) activity;
        } catch (ClassCastException exception){
            Log.e(getActivity().getPackageName(), exception.toString());
        }
    }
}
