package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.appcompat.app.AppCompatActivity;
import id.zelory.compressor.Compressor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.fragments.CenterBlock;
import com.synth3sisgame.synth3sisgame.utils.FileUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddBlock extends AppCompatActivity {

    public File actualImage, compressedImage;
    String mImage = "image";
    private static final int PICK_IMAGE_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_block);
        CenterBlock frag = new CenterBlock();
        addFragment(frag);
//        getSupportActionBar().hide();
    }

    public void addFragment(Fragment f) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.blocks, f);
        fragmentTransaction.commit();
    }

    public void option1Clicked(View view) {
    }

    public void addImageClicked(View view) {
        getPermissions();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) {
            Toast.makeText(this, "Failed to open picture!", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            actualImage = FileUtil.from(this, data.getData());
            customCompressImage();
        } catch (IOException e) {
            Toast.makeText(this, "Failed to read picture data!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    public void customCompressImage() {
        if (actualImage == null) {
            Toast.makeText(this, "Please choose an image!", Toast.LENGTH_SHORT).show();
        } else {

            new Compressor(this)
                    .setMaxWidth(480)
                    .setMaxHeight(480)
                    .setQuality(75)
                    .setCompressFormat(Bitmap.CompressFormat.WEBP)
                    .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES).getAbsolutePath())
                    .compressToFileAsFlowable(actualImage)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<File>() {
                        @Override
                        public void accept(File file) {
                            compressedImage = file;
                            //Toast.makeText(getActivity(), ""+getReadableFileSize(compressedImage.length()), Toast.LENGTH_SHORT).show();
                            setCompressedImage();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) {
                            throwable.printStackTrace();
                            Toast.makeText(AddBlock.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private void setCompressedImage() {
        Bitmap btmap = BitmapFactory.decodeFile(compressedImage.getAbsolutePath());
        //compressedImageView.setImageBitmap(btmap);
        ImageView imageView = (ImageView) findViewById(R.id.imgName);
        imageView.setImageBitmap(btmap);
        mImage = imageToString(btmap);
        //Log.v("size", "  " + getReadableFileSize(compressedImage.length()) + "");
    }

    public String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgBytes, Base64.DEFAULT);
    }

    public void getPermissions() {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(i, PICK_IMAGE_REQUEST);
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(AddBlock.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_LONG)
                        .show();
            }

        };

        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setRationaleTitle("Permission required")
                .setDeniedTitle("Permission denied")
                .setDeniedMessage(
                        "If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setGotoSettingButtonText("Setting")
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
                        , Manifest.permission.INTERNET)
                .check();
    }

    public void saveClicked(View view) {
        TimeNameOfChainActivity.timeNameOfChainActivity.finish();
        finish();
    }
}
