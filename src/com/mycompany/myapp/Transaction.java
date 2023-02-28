
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class Transaction  extends Form {
    Form current;
    public Transaction(Form previous) {
        current=this; //Back 
        add(new Label("Transaction"));
        setTitle(" --Transaction-- ");
        setLayout(BoxLayout.y());
        
       Button BUTAdd = new Button("Add Transaction");
       Button BUTShow = new Button("Show Transaction");
       addAll(BUTAdd,BUTShow);
    
    getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, (evt) -> {
        previous.showBack();
        });
    }
  }
