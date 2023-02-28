
package com.mycompany.myapp;

import GUI.CarteBancaire.ListCarteBancaire;
import GUI.CarteBancaire.addCarteBancaire;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

public class HomeCarteBancaire extends Form{
Form current;
private Resources theme;
    public HomeCarteBancaire(Resources res) {
                current=this; //Back 
                
        add(new Label("Welcom Admin to Travel_Me"));
        setTitle("Welcom Admin to Travel_Me");
        setLayout(BoxLayout.y());   
        Button BUTcarteBancaire= new Button("Gestion Carte Bancaire");
   

        BUTcarteBancaire.addActionListener((evt) -> new ListCarteBancaire(res,current).show());

        addAll(BUTcarteBancaire);
    
        
    }
     
}

