package com.szunyix.mythesis.image;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.szunyix.mythesis.layout.ImageHelperActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.label.ImageLabel;
import com.google.mlkit.vision.label.ImageLabeler;
import com.google.mlkit.vision.label.ImageLabeling;
import com.google.mlkit.vision.label.custom.CustomImageLabelerOptions;

import java.util.List;

public class CustomModelActivity extends ImageHelperActivity {

    private ImageLabeler imageLabeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String keyName = getIntent().getStringExtra("keyName");

        LocalModel localModel = null;

        if (keyName.equals("latinPlant")) {
            localModel = new LocalModel.Builder().setAssetFilePath("LatinPlantModel.tflite").build();
        }
        if (keyName.equals("flower")) {
            localModel = new LocalModel.Builder().setAssetFilePath("flowerModel.tflite").build();
        }
        if (keyName.equals("plant")) {
            localModel = new LocalModel.Builder().setAssetFilePath("plantModel.tflite").build();
        }

        assert localModel != null;
        CustomImageLabelerOptions options = new CustomImageLabelerOptions.Builder(localModel)
                .setConfidenceThreshold(0.7f)
                .setMaxResultCount(5).build();

        imageLabeler = ImageLabeling.getClient(options);
    }

    @Override
    protected void runClassification(Bitmap bitmap) {
        InputImage inputImage = InputImage.fromBitmap(bitmap, 0);

        imageLabeler.process(inputImage).addOnSuccessListener(new OnSuccessListener<List<ImageLabel>>() {
            @Override
            public void onSuccess(List<ImageLabel> imageLabels) {
                if (imageLabels.size() > 0) {
                    StringBuilder builder = new StringBuilder();
                    for (ImageLabel label : imageLabels) {
                        builder.append(label.getText())
                                .append(" : ")
                                .append(label.getConfidence())
                                .append("\n");
                    }
                    getOutputTextView().setText(builder.toString());
                }else {
                    getOutputTextView().setText("Could not classify");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        });
    }
}
