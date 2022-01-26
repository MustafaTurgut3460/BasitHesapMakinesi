package com.example.hesapmakinesi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    @FXML
    private Button buttonArti, buttonBol, buttonCarp, buttonCikar, buttonMod, buttonSil, buttonTemizle, buttonNokta, buttonSonuc;
    @FXML
    private Label text;
    @FXML
    private Label previusText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button0.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + "0");
        });

        button1.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + "1");
        });

        button2.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + "2");
        });

        button3.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + "3");
        });

        button4.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + "4");
        });

        button5.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + "5");
        });

        button6.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + "6");
        });

        button7.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + "7");
        });

        button8.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + "8");
        });

        button9.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + "9");
        });

        buttonCarp.setOnMouseClicked(mouseEvent -> {
            previusText.setText(text.getText() + " x");
            text.setText("");
        });

        buttonCikar.setOnMouseClicked(mouseEvent -> {
            previusText.setText(text.getText() + " -");
            text.setText("");
        });

        buttonArti.setOnMouseClicked(mouseEvent -> {
            previusText.setText(text.getText() + " +");
            text.setText("");
        });

        buttonBol.setOnMouseClicked(mouseEvent -> {
            previusText.setText(text.getText() + " /");
            text.setText("");
        });

        buttonNokta.setOnMouseClicked(mouseEvent -> {
            text.setText(text.getText() + ".");
        });

        buttonMod.setOnMouseClicked(mouseEvent -> {
            previusText.setText(text.getText() + " %");
            text.setText("");
        });

        buttonSil.setOnMouseClicked(mouseEvent ->{
            char[] stringArray = text.getText().toCharArray();
            String newText = "";
            for(int i=0 ; i<stringArray.length-1 ; i++){
                newText += stringArray[i];
            }

            text.setText(newText);
        });

        buttonTemizle.setOnMouseClicked(mouseEvent -> {
            text.setText("");
            previusText.setText("");
        });

        buttonSonuc.setOnMouseClicked(mouseEvent -> {
            if(text.getText().isEmpty() || previusText.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Lütfen Geçerli Bir İşlem Giriniz!");
                alert.setHeaderText("Geçersiz İşlem!");
                alert.show();
            }
            else{
                String[] stringArray = previusText.getText().split(" ");
                //System.out.println(stringArray[1]);
                switch (stringArray[1]) {
                    case "x" -> {
                        String sonuc = String.valueOf(carp(Double.parseDouble(text.getText()), Double.parseDouble(stringArray[0])));
                        text.setText(sonuc);
                        previusText.setText("");
                        //System.out.println(sonuc);
                    }
                    case "+" -> {
                        String sonuc1 = String.valueOf(topla(Double.parseDouble(text.getText()), Double.parseDouble(stringArray[0])));
                        text.setText(sonuc1);
                        previusText.setText("");
                        //System.out.println(sonuc1);
                    }
                    case "-" -> {
                        String sonuc2 = String.valueOf(cikar(Double.parseDouble(text.getText()), Double.parseDouble(stringArray[0])));
                        text.setText(sonuc2);
                        previusText.setText("");
                        //System.out.println(sonuc2);
                    }
                    case "/" -> {
                        String sonuc3 = String.valueOf(bol(Double.parseDouble(text.getText()), Double.parseDouble(stringArray[0])));
                        text.setText(sonuc3);
                        previusText.setText("");
                        //System.out.println(sonuc3);
                    }
                    case "%" -> {
                        String sonuc3 = String.valueOf(modAl(Double.parseDouble(text.getText()), Double.parseDouble(stringArray[0])));
                        text.setText(sonuc3);
                        previusText.setText("");
                        //System.out.println(sonuc3);
                    }
                }
            }
        });
    }

    private double carp(double sayi1, double sayi2){
        return sayi2 * sayi1;
    }

    private double topla(double sayi1, double sayi2){
        return sayi2 + sayi1;
    }

    private double cikar(double sayi1, double sayi2){
        return sayi2 - sayi1;
    }

    private double bol(double sayi1, double sayi2){
        return sayi2 / sayi1;
    }

    private double modAl(double sayi1, double sayi2){
        return sayi1 % sayi2;
    }

}