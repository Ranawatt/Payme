package com.example.sugandhkumar.payme.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioButton;

import com.example.sugandhkumar.payme.Callback;
import com.example.sugandhkumar.payme.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by sugandh kumar on 31-08-2017.
 */

public class MobrechargeFragment extends Fragment {
    public static final String TAG = MobrechargeFragment.class.getSimpleName();
    private Context rContext;
    private RadioButton btnPrepaid, btnPostpaid;
    private EditText mobileNo,opearator, rechAmount;
    private Button btnRecharge, btnOffer, btnHelp;
    private ImageView ivContacts;
    private static final int REQUEST_CODE_PICK_CONTACTS = 1;
    private Uri uriContact;
    private String contactID;
    public MobrechargeFragment() {    }

    Callback iCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            iCallback = (Callback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(rContext.toString()+ "must implement onClickListener");
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_mob,container,false);
        initView(mView);
        return mView;
    }

    private void initView(View iView){
        btnPrepaid = (RadioButton) iView.findViewById(R.id.radioButton);
        btnPrepaid = (RadioButton) iView.findViewById(R.id.radioButton2);
        mobileNo = (EditText) iView.findViewById(R.id.etMob_no);
        opearator = (EditText) iView.findViewById(R.id.etOperator);
        rechAmount = (EditText) iView.findViewById(R.id.etAmount);
        btnRecharge = (Button) iView.findViewById(R.id.btn_recharge);
        btnOffer = (Button) iView.findViewById(R.id.bt_offer);
        btnHelp = (Button) iView.findViewById(R.id.bt_help);
        ivContacts = (ImageView) iView.findViewById(R.id.ivContacts);
        opearator.setInputType(InputType.TYPE_NULL);

        opearator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(getContext(),opearator);
                popupMenu.getMenuInflater().inflate(R.menu.menu_operator,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        opearator.setText(item.getTitle());
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        btnRecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (btnPrepaid.isChecked()){
//                    return;
//                }else if (btnPostpaid.isChecked()){
//                    return;
//                }
                String MobileNo = mobileNo.getText().toString().trim();
                String Operator = opearator.getText().toString().trim();
//                Intent rIntent =  new Intent(getActivity().getApplicationContext(),Main11Activity.class);
//                rIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(rIntent);
                iCallback.processToPayments();

            }
        });

        ivContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,   Uri.parse("content://contacts"));
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intent,REQUEST_CODE_PICK_CONTACTS);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PICK_CONTACTS && resultCode == RESULT_OK) {
            Log.d(TAG, "Response: " + data.toString());
            uriContact = data.getData();
            String[] projection = { ContactsContract.CommonDataKinds.Phone.NUMBER };
            Cursor cursor = getActivity().getContentResolver().query(uriContact, projection, null, null, null);
            cursor.moveToFirst();
            // Retrieve the phone number from the NUMBER column
            int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String number = cursor.getString(column);
            mobileNo.setText(number);

        }
    }

}
