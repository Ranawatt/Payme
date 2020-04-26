package com.example.sugandhkumar.payme.activity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sugandhkumar.payme.R;
import com.example.sugandhkumar.payme.activity.hotels.HotelsActivity;
import com.example.sugandhkumar.payme.model.Hotels;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class UploadActivity extends AppCompatActivity implements View.OnClickListener {
        //constant to track image chooser intent
        private static final int PICK_IMAGE_REQUEST = 234;
        private Button btnChoose;
        private Button btnUpload;
        private ImageView imageSelected;
        private EditText etName;
        private EditText etCost;
        private TextView tvBack;
        private EditText etRemarks;
        private EditText etDistance;
        private EditText etRatingPoint;
        // Uri to store file
        private Uri imgPath;
        // Firebase Objects
        private StorageReference storageReference;
        private DatabaseReference databaseReference;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upload);

            initViews();
            initListeners();
            storageReference = FirebaseStorage.getInstance().getReference();
            databaseReference = FirebaseDatabase.getInstance().getReference("hotel/hotel_info1");
        }

    private void initViews() {
        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnUpload = (Button) findViewById(R.id.btnUpload);
        imageSelected = (ImageView) findViewById(R.id.ivSelected);
        etName = (EditText) findViewById(R.id.etName);
        etCost = (EditText) findViewById(R.id.etCost);
        tvBack = (TextView) findViewById(R.id.tvShowUpload);
        etRemarks = (EditText) findViewById(R.id.etRemarks);
        etDistance = (EditText) findViewById(R.id.etDistance);
        etRatingPoint = (EditText) findViewById(R.id.etRatingPoint);
    }

    private void initListeners() {
        btnChoose.setOnClickListener(this);
        btnUpload.setOnClickListener(this);
        tvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnChoose){
            showFileCooser();
        }else if (view == btnUpload){
            uploadFile();
        }else{
            Intent in = new Intent(UploadActivity.this,HotelsActivity.class);
            startActivity(in);
        }
    }

    private  void showFileCooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imgPath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imgPath);
                imageSelected.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    private void uploadFile() {
        if (imgPath != null) {
            final ProgressDialog pDialog = new ProgressDialog(this);
            pDialog.setMessage("Uploading....");
            pDialog.show();

            StorageReference sRef = storageReference.child("hotel/hotel_info1/" + System.currentTimeMillis() + "." + getFileExtension(imgPath));
            sRef.putFile(imgPath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            pDialog.dismiss();

                            Toast.makeText(getApplicationContext(), "File Uploaded", Toast.LENGTH_LONG).show();

//                            Hotels hotels = new Hotels(etName.getText().toString().trim(),taskSnapshot.getDownloadUrl().toString(),etCost.getText().toString().trim(),
//                                    etRemarks.getText().toString().trim(),etDistance.getText().toString().trim(),etRatingPoint.getText().toString().trim());
                            Hotels hotels =  new Hotels(taskSnapshot.getUploadSessionUri().toString());
                            String hotelsId = databaseReference.push().getKey();
                            databaseReference.child(hotelsId).setValue(hotels);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            pDialog.dismiss();
                            Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                            pDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                        }
                    });
        } else {
            //Nothing to show
        }
    }
}
