package GUI.Transaction;
       import Entities.Transaction;
   import GUI.Transaction.AddTransaction;
    import Services.ServiceTransaction;
    import Utils.Statics;
    import com.codename1.components.FloatingActionButton;
    import com.codename1.components.InfiniteProgress;
    import com.codename1.components.ScaleImageLabel;
    import com.codename1.components.SpanLabel;
    import com.codename1.ui.Button;
    import com.codename1.ui.ButtonGroup;
    import com.codename1.ui.Component;
    import static com.codename1.ui.Component.BOTTOM;
    import static com.codename1.ui.Component.CENTER;
    import static com.codename1.ui.Component.LEFT;
    import static com.codename1.ui.Component.RIGHT;
    import com.codename1.ui.Container;
    import com.codename1.ui.Dialog;
    import com.codename1.ui.Display;
    import com.codename1.ui.EncodedImage;
    import com.codename1.ui.FontImage;
    import com.codename1.ui.Form;
    import com.codename1.ui.Graphics;
    import com.codename1.ui.Image;
    import com.codename1.ui.Label;
    import com.codename1.ui.RadioButton;
    import com.codename1.ui.Tabs;
    import com.codename1.ui.TextArea;
    import com.codename1.ui.Toolbar;
    import com.codename1.ui.URLImage;
    import com.codename1.ui.events.ActionEvent;
    import com.codename1.ui.events.ActionListener;
    import com.codename1.ui.layouts.BorderLayout;
    import com.codename1.ui.layouts.BoxLayout;
    import com.codename1.ui.layouts.FlowLayout;
    import com.codename1.ui.layouts.GridLayout;
    import com.codename1.ui.layouts.LayeredLayout;
    import com.codename1.ui.plaf.Style;
    import com.codename1.ui.spinner.Picker;
    import com.codename1.ui.util.Resources;
    import java.util.ArrayList;
    import com.codename1.ui.util.Resources;
import com.mycompany.myapp.HomeTransaction;

//
//
//        import Entities.Transaction;
//        import Services.ServiceTransaction;
//            import Utils.Statics;
//            import com.codename1.components.FloatingActionButton;
//            import com.codename1.components.InfiniteProgress;
//            import com.codename1.components.ScaleImageLabel;
//            import com.codename1.components.SpanLabel;
//            import com.codename1.ui.Button;
//            import com.codename1.ui.ButtonGroup;
//            import com.codename1.ui.Component;
//            import static com.codename1.ui.Component.BOTTOM;
//            import static com.codename1.ui.Component.CENTER;
//            import static com.codename1.ui.Component.LEFT;
//            import static com.codename1.ui.Component.RIGHT;
//            import com.codename1.ui.Container;
//            import com.codename1.ui.Dialog;
//            import com.codename1.ui.Display;
//            import com.codename1.ui.EncodedImage;
//            import com.codename1.ui.FontImage;
//            import com.codename1.ui.Form;
//            import com.codename1.ui.Graphics;
//            import com.codename1.ui.Image;
//            import com.codename1.ui.Label;
//            import com.codename1.ui.RadioButton;
//            import com.codename1.ui.Tabs;
//            import com.codename1.ui.TextArea;
//            import com.codename1.ui.Toolbar;
//            import com.codename1.ui.URLImage;
//            import com.codename1.ui.events.ActionEvent;
//            import com.codename1.ui.events.ActionListener;
//            import com.codename1.ui.layouts.BorderLayout;
//            import com.codename1.ui.layouts.BoxLayout;
//            import com.codename1.ui.layouts.FlowLayout;
//            import com.codename1.ui.layouts.GridLayout;
//            import com.codename1.ui.layouts.LayeredLayout;
//            import com.codename1.ui.plaf.Style;
//            import com.codename1.ui.spinner.Picker;
//            import com.codename1.ui.util.Resources;
//        import com.mycompany.myapp.HomeTransaction; 
//        import java.util.ArrayList;
//            import com.codename1.ui.util.Resources;
//        /**
//         *
//         * @author BAZINFO
//         */
//        public class ListeTransaction extends Form{
//                Form f;
//                Form current;
//                private Resources theme;
//                public ListeTransaction(Resources res,Form previous ) {
//
//                     f=this;
//                    f.setTitle("Mes Demandes");
//                    f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
//                    f.setLayout(new BorderLayout());
//
//
//                     FloatingActionButton.setIconDefaultSize(5);
//                     FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
//                     fab.addActionListener(e -> new AddTransaction(res, previous).show());
//                     fab.bindFabToContainer(f.getContentPane());
//                     
//                     FloatingActionButton.setIconDefaultSize(5);
//                     FloatingActionButton fa = FloatingActionButton.createFAB(FontImage.MATERIAL_STORE);
//                     fa.addActionListener(e -> new HomeTransaction(res).show());
//                     fa.bindFabToContainer(f.getContentPane());
//
//                    Container list = new Container();
//                    list.setScrollableY(true);
//                    list.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
//                    Dialog progress = new InfiniteProgress().showInifiniteBlocking();
//                     ArrayList<Transaction> transaction = ServiceTransaction.getInstance().affichageTransaction();
//                    for (Transaction Transaction : transaction) {
//
//                          System.out.println(Transaction.getId());
//
//                          /**IMG**/
//            //      ****  
//                     EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(50,50, 0xffff0000), true);
//                          Image i = URLImage.createToStorage(placeholder,Transaction.getCinS1(),Statics.BASE_URL+"carte/bancaire/addDemandeCartes/JSON"+CarteBancaire.getCinS1()).fill(200,150);
//            //      **** 
//                        add container
//                          Container ex = new Container();
//                          ex.setUIID("Excursiondetail");
//                          ex.setLayout(new BoxLayout(BoxLayout.X_AXIS));
//
//                          Container d = new Container();
//                          d.setUIID("detail");
//                          d.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
//
//                          String compte =" Compte  : "+ Transaction.getCompte();
//                          String typeTransaction= " Type Transaction : "+Transaction.getTypeTransaction();
//                          String montant = "Montant : "+ Transaction.getMontant();
//                          String requestFrom= "Request From : "+Transaction.getRequestFrom();
//                          String requestTo= "Request To : "+Transaction.getRequestTo();
//                          Button b = new Button("Voir Plus");
//                          b.getAllStyles().setAlignment(RIGHT);
//
//                          d.add(new Label(compte));
//                          d.add(new Label(typeTransaction));
//                          d.add(new Label(montant));
//                          d.add(new Label(requestFrom));
//                          d.add(new Label(requestTo));
//                          d.add(b);
//                          ex.add(d);
//                          list.add(ex);
//                    }
//                     progress.dispose();
//
//                     f.add(CENTER,list); 
//                     f.show();
//                    f.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new ListeTransaction(res,previous).show());
//
//                }
//
//            private void addTab(Tabs swipe, Label spacer , Image image, String string, String text, Resources res) {
//
//
//
//                    Container page1 = 
//                            LayeredLayout.encloseIn(
//                                    BorderLayout.south(
//                                    BoxLayout.encloseY(
//                                    new SpanLabel(text, "LargeWhiteText"),
//                                                    spacer
//                                    )
//                                )
//                            );
//
//                    swipe.addTab("",null, page1);
//
//
//
//
//                }
//
//
//
//
//            public void bindButtonSelection(Button btn , Label l ) {
//
//                btn.addActionListener(e-> {
//                if(btn.isSelected()) {
//                    updateArrowPosition(btn,l);
//                }
//            });
//            }
//
//            private void updateArrowPosition(Button btn, Label l) {
//
//                l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth()  / 2  - l.getWidth() / 2 );
//                l.getParent().repaint();
//            }
//                private void addButton(Image img,Transaction rec , Resources res) {
//
//
//                    Container cnt = new Container();
//                    cnt.setLayout(new BorderLayout());
//                    kif nzidouh  ly3endo date mathbih fi codenamone y3adih string w y5alih f symfony dateTime w ytab3ni cha3mlt taw yjih
//
//                    Label requestTo = new Label("requestTo : "+rec.getRequestTo(),"NewsTopLine2" );
//                    Label requestFrom = new Label("requestFrom : "+rec.getRequestFrom(),"NewsTopLine2" );
//                    Label montant = new Label("montant : "+rec.getMontant(),"NewsTopLine2" );
//                    Label typeTransaction = new Label("typeTransaction : "+rec.getTypeTransaction(),"NewsTopLine2" );
//
//
//                    createLineSeparator();
//
//
//
//                    supprimer button
//                    Label lSupprimer = new Label(" ");
//                    lSupprimer.setUIID("NewsTopLine");
//                    Style supprmierStyle = new Style(lSupprimer.getUnselectedStyle());
//                    supprmierStyle.setFgColor(0xf21f1f);
//
//
//
//                    click delete icon
//                    lSupprimer.addPointerPressedListener(l -> {
//
//                        Dialog dig = new Dialog("Suppression");
//
//                        if(dig.show("Suppression","Vous voulez supprimer ce Transaction ?","Annuler","Oui")) {
//                            dig.dispose();
//                        }
//                        else {
//                            dig.dispose();
//                             }
//                            n3ayto l suuprimer men service Transaction
//                            if(ServiceTransaction.getInstance().deleteTransaction(rec.getId())) {
//                                new ListeTransaction(res,current).show();
//                            }
//
//                    });
//
//                    Update icon 
//                    Label lModifier = new Label(" ");
//                    lModifier.setUIID("NewsTopLine");
//                    Style modifierStyle = new Style(lModifier.getUnselectedStyle());
//                    modifierStyle.setFgColor(0xf7ad02);
//
//                    add(cnt);
//                }
//
//
//
//
//         }

    public class ListeTransaction extends Form{
        Form f;
        Form current;
        private Resources theme;
        public ListeTransaction(Resources res,Form previous ) {

               f=this;
               f.setTitle("Mes Demandes");
               f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
               f.setLayout(new BorderLayout());


             FloatingActionButton.setIconDefaultSize(5);
             FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
             fab.addActionListener(e -> new AddTransaction(res, previous).show());
             fab.bindFabToContainer(f.getContentPane());

             FloatingActionButton.setIconDefaultSize(5);
             FloatingActionButton fa = FloatingActionButton.createFAB(FontImage.MATERIAL_STORE);
             fa.addActionListener(e -> new HomeTransaction(res).show());
             fa.bindFabToContainer(f.getContentPane());

            Container list = new Container();
            list.setScrollableY(true);
            list.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            Dialog progress = new InfiniteProgress().showInifiniteBlocking();
             ArrayList<Transaction> carteBancaire = ServiceTransaction.getInstance().affichageTransaction();
            for (Transaction CarteBancaire : carteBancaire) {

                  System.out.println(CarteBancaire.getId());
                  EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(50,50, 0xffff0000), true);
//    //      ****  
//                  Image i = URLImage.createToStorage(placeholder,CarteBancaire.getCinS1(),Statics.BASE_URL+"carte/bancaire/addDemandeCartes/JSON"+CarteBancaire.getCinS1()).fill(200,150);
////    //      **** 
                Container ex = new Container();
                 ex.setUIID("Excursiondetail");
                 ex.setLayout(new BoxLayout(BoxLayout.X_AXIS));
              //   ex.add(i);

                  Container d = new Container();
                  d.setUIID("detail");
                  d.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

                       
                          String typeTransaction= " Type Transaction : "+CarteBancaire.getTypeTransaction();
                          String montant = "Montant : "+ CarteBancaire.getMontant();
                          String requestFrom= "Request From : "+CarteBancaire.getRequestFrom();
                          String requestTo= "Request To : "+CarteBancaire.getRequestTo();
                          Button b = new Button("Voir Plus");
                          b.getAllStyles().setAlignment(RIGHT);

                          d.add(new Label(typeTransaction));
                          d.add(new Label(montant));
                          d.add(new Label(requestFrom));
                          d.add(new Label(requestTo));
                          d.add(b);
                          ex.add(d);
                          list.add(ex);
                  
                  
            }
             progress.dispose();

             f.add(CENTER,list); 
             f.show();
            f.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new ListeTransaction(res,previous).show());

        }



        private void addTab(Tabs swipe, Label spacer , Image image, String string, String text, Resources res) {



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

        private void addButton(Image img,Transaction rec , Resources res) {


            Container cnt = new Container();
            cnt.setLayout(new BorderLayout());


            //kif nzidouh  ly3endo date mathbih fi codenamone y3adih string w y5alih f symfony dateTime w ytab3ni cha3mlt taw yjih
                    Label requestTo = new Label("requestTo : "+rec.getRequestTo(),"NewsTopLine2" );
                    Label requestFrom = new Label("requestFrom : "+rec.getRequestFrom(),"NewsTopLine2" );
                    Label montant = new Label("montant : "+rec.getMontant(),"NewsTopLine2" );
                    Label typeTransaction = new Label("typeTransaction : "+rec.getTypeTransaction(),"NewsTopLine2" );



          //  createLineSeparator();



            //supprimer button
            Label lSupprimer = new Label(" ");
            lSupprimer.setUIID("NewsTopLine");
            Style supprmierStyle = new Style(lSupprimer.getUnselectedStyle());
            supprmierStyle.setFgColor(0xf21f1f);

            FontImage suprrimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprmierStyle);
            lSupprimer.setIcon(suprrimerImage);
            lSupprimer.setTextPosition(RIGHT);

            //click delete icon
            lSupprimer.addPointerPressedListener(l -> {

                Dialog dig = new Dialog("Suppression");

                if(dig.show("Suppression","Vous voulez supprimer ce reclamation ?","Annuler","Oui")) {
                    dig.dispose();
                }
                else {
                    dig.dispose();
                     }
                    //n3ayto l suuprimer men service Reclamation
                    if(ServiceTransaction.getInstance().deleteReclamation(rec.getId())) {
                        new ListeTransaction(res,current).show();
                    }

            });

            //Update icon 
            Label lModifier = new Label(" ");
            lModifier.setUIID("NewsTopLine");
            Style modifierStyle = new Style(lModifier.getUnselectedStyle());
            modifierStyle.setFgColor(0xf7ad02);

            FontImage mFontImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
            lModifier.setIcon(mFontImage);
            lModifier.setTextPosition(LEFT);





            add(cnt);
        }




     }