
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class CarteBancaire extends Form{
Form current;
    public CarteBancaire(Form previous) {
        current=this; //Back 
        add(new Label("CarteBancaire"));
        setTitle(" --CarteBancaire-- ");
        setLayout(BoxLayout.y());
        
    Button BUTAdd = new Button("Add Carte Bancaire");
    Button BUTShow = new Button("Show Carte Bancaire");
    addAll(BUTAdd,BUTShow);    
    getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, (evt) -> {
        previous.showBack();
        });}
    }

