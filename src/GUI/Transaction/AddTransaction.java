
package GUI.Transaction;

import Entities.Transaction;
import Services.ServiceTransaction;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import java.util.Date;

public class AddTransaction extends Form{
    
            
    
    Form current;
    public AddTransaction(Resources res, Form previous ) {
        super("Ajout Transaction",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
                getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            previous.showBack();
            });
      
        current = this ;
    
        getTitleArea().setUIID("Container");
     
        getContentPane().setScrollVisible(false);
        
        
      
        Tabs swipe = new Tabs();
        
        Label s1 = new Label();
        Label s2 = new Label();
        
        addTab(swipe,s1, null,"","",res);
        
        //
        
         swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("Mes Transaction", barGroup);
        mesListes.setUIID("SelectBar");
       // RadioButton liste = RadioButton.createToggle("Autres", barGroup);
        //liste.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("Ajouter", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
            ListeTransaction a = new ListeTransaction(res,current);
            a.show();
            refreshTheme();
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(2, mesListes, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
       // bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

        
        //
        
            TextField agenceName = new TextField("", " nom d'agence !!");
            agenceName.setUIID("TextFieldBlack");
            addStringValue("agenceName",agenceName);

            TextField statue = new TextField("", " statue!!");
            statue.setUIID("TextFieldBlack");
            addStringValue("statue",statue);

            TextField requestTo = new TextField("", "request To!");
            requestTo.setUIID("TextFieldBlack");
            addStringValue("requestTo",requestTo);

            TextField requestFrom = new TextField("", "request From !");
            requestFrom.setUIID("TextFieldBlack");
            addStringValue("requestFrom",requestFrom);

            TextField montant = new TextField("", "montant!");
            montant.setUIID("TextFieldBlack");
            addStringValue("montant",montant);

                        
            TextField typeTransaction = new TextField("", "type Transaction!");
            typeTransaction.setUIID("TextFieldBlack");
            addStringValue("typeTransaction",typeTransaction);
            
            TextField compte = new TextField("", "compte!");
            compte.setUIID("TextFieldBlack");
            addStringValue("compte",compte);
            
            
            Button btnAjouter = new Button("Ajouter");
            addStringValue("", btnAjouter);

            //onclick button event 
            btnAjouter.addActionListener((e) -> {

                try {

                    if(agenceName.getText().equals("") || statue.getText().equals("")
                                                       || requestTo.getText().equals("")
                                                       || requestFrom.getText().equals("")
                                                       || montant.getText().equals("")
                                                       || typeTransaction.getText().equals("")
                                                       || compte.getText().equals("")) 
                    {
                        Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
                    }
                else {
                    InfiniteProgress ip = new InfiniteProgress();; //Loading  after insert data
                
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    
                    java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    
                    //njibo iduser men session (current user)
                      Transaction r = new Transaction(
                                                      String.valueOf(agenceName.getText()).toString(),
                                                      String.valueOf(statue.getText()).toString(), 
                                                      String.valueOf(requestTo.getText()).toString(),
                                                      String.valueOf(requestFrom.getText()).toString(),
                                                      String.valueOf(montant.getText()).toString(),
                                                      String.valueOf(typeTransaction.getText()).toString(),
                                                      String.valueOf(compte.getText()).toString()
                                                     );
                    
                    
                    System.out.println("data  Transaction == "+r);
                    
                    
                    //appelle methode ajouterReclamation mt3 service Reclamation bch nzido données ta3na fi base 
                        ServiceTransaction.getInstance().ajoutTransaction(r);
                    
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                    
                    //ba3d ajout net3adaw lel ListREclamationForm
                    new ListeTransaction(res,current).show();
                                        
                    refreshTheme();//Actualisation
                            
                }
                
            }catch(Exception ex ) {
                ex.printStackTrace();
            }
            
            
            
            
            
        });
        
        
    }

    private void addStringValue(String s, Component v) {
        
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
       // add(createLineSeparator(0xeeeeee));
    }

    private void addTab(Tabs swipe, Label spacer , Image image, String string, String text, Resources res) {
      //  int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        
       /* if(image.getHeight() < size) {
            image = image.scaledHeight(size);
        }
        
        
        
        if(image.getHeight() > Display.getInstance().getDisplayHeight() / 2 ) {
            image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
        
        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        Label overLay = new Label("","ImageOverlay");*/
        
        
        Container page1 = 
                LayeredLayout.encloseIn(
                
                        BorderLayout.south(
                        BoxLayout.encloseY(
                        new SpanLabel(text, "LargeWhiteText"),
                                        spacer
                        )
                    )
                );
        
        swipe.addTab("",null, page1);
        
        
        
        
    }
    
    
    
    public void bindButtonSelection(Button btn , Label l ) {
        
        btn.addActionListener(e-> {
        if(btn.isSelected()) {
            updateArrowPosition(btn,l);
        }
    });
    }

    private void updateArrowPosition(Button btn, Label l) {
        
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth()  / 2  - l.getWidth() / 2 );
        l.getParent().repaint();
    }

 
}


