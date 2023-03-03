
package com.mycompany.myapp;

import GUI.Transaction.AddTransaction;
import GUI.Transaction.ListeTransaction;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;


public class HomeTransaction extends Form{
Form current;
private Resources theme;
    public HomeTransaction(Resources res) {
                current=this; //Back 
                
        add(new Label("Transaction"));
        setTitle("Transaction");
        setLayout(BoxLayout.y());   
        Button BUTlistTransaction= new Button("Lister les transactions");   
        Button BUTaddTransaction= new Button("Ajouter une transaction");  

        BUTlistTransaction.addActionListener((evt) -> new ListeTransaction(res,current).show());
        BUTaddTransaction.addActionListener((evt) -> new AddTransaction(res, current).show());

        addAll(BUTlistTransaction,BUTaddTransaction);
    
        
    }
}
