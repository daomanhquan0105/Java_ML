package com.company;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Main {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String imgFile="Images/ronaldo-messi-1.png";
        Mat src= Imgcodecs.imread(imgFile);
        String xmlFile="xmls/lbpcascade_frontalface.xml";
        CascadeClassifier cc=new CascadeClassifier(xmlFile);

        MatOfRect faceDetection=new MatOfRect();
        cc.detectMultiScale(src, faceDetection);

        System.out.println(String.format("Detected faces: %d", faceDetection.toArray().length));

        for(Rect rect: faceDetection.toArray()) {
            Imgproc.rectangle(src, new Point(rect.x,rect.y),new Point(rect.x+rect.width,rect.y+rect.height), new Scalar(0,0,255),1);
        }

        Imgcodecs.imwrite("Images/ronaldo-messi-output.png", src);
        System.out.print("Image detection finished!");
    }
}
