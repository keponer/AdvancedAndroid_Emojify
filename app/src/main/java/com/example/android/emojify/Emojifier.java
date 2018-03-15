package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by arg-a on 15/03/2018.
 */

public class Emojifier {

    public static void detectFaces(Context context, Bitmap bitmap){

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<Face> faceSparseArray =  detector.detect(frame);

        Log.d("Faces", "number of faces: " + faceSparseArray.size());

        if(faceSparseArray.size() == 0){
            Toast.makeText(context, "no faces detected", Toast.LENGTH_LONG).show();
        }

        detector.release();
    }
}
