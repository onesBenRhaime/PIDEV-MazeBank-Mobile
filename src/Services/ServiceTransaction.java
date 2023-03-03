//
//    package Services;
//
//    import com.codename1.io.ConnectionRequest;
//    import com.codename1.io.NetworkManager;
//    import Entities.Transaction;
//    import Utils.Statics;
//    import com.codename1.io.CharArrayReader;
//    import com.codename1.io.JSONParser;
//    import com.codename1.io.NetworkEvent;
//    import com.codename1.ui.events.ActionListener;
//    import java.util.ArrayList;
//    import java.util.List;
//    import java.util.Map;
//
//
//    public class ServiceTransaction {
//
//        //singleton 
//        public static ServiceTransaction instance = null ;
//
//        public static boolean resultOk = true;
//
//        //initilisation connection request 
//        private ConnectionRequest req;
//
//
//        public static ServiceTransaction getInstance() {
//            if(instance == null )
//                instance = new ServiceTransaction();
//            return instance ;
//        }
//
//
//        public ServiceTransaction() {
//            req = new ConnectionRequest();
//
//        }
//  //ajout 
//        public void ajoutTransaction(Transaction transaction) {
//
//            String url =Statics.BASE_URL+"transactions/addTransactionsJson/new?id=" 
//                                         +transaction.getId()  
//                                         +"&compte="+transaction.getCompte()      
//                                         +"&typeTransaction="+transaction.getTypeTransaction()                                                                                                              
//                                         +"&requestTo="+transaction.getRequestTo()
//                                         +"&requestFrom="+transaction.getRequestFrom()
//                                         +"&montant="+transaction.getMontant();
//                                      
//            req.setUrl(url);
//            req.addResponseListener((e) -> {            
//                String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
//                System.out.println("data == "+str);
//            });
//
//            NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
//
//        }
//
//        //Aff Liste Transaction
//        public ArrayList<Transaction>affichageTransaction() {
//
//            ArrayList<Transaction> result = new ArrayList<>();
//            String url = "http://127.0.0.1:8000/webServices/AllTransactionsJson";
//            req.setUrl(url);
//            req.addResponseListener((NetworkEvent evt) -> {
//                JSONParser jsonp ;
//                jsonp = new JSONParser();
//
//                try {
//                     //renvoi une map avec clé = root et valeur le reste
//                    Map<String,Object> mapTransaction = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
//
//                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapTransaction.get("root");
//
//                    for(Map<String, Object> obj : listOfMaps) {
//                        Transaction re = new Transaction();
//                        //dima id fi codename one float 5outhouha
//                        float id = Float.parseFloat(obj.get("id").toString());
//                        String requestTo = obj.get("requestTo").toString();
//                        String requestFrom = obj.get("requestFrom").toString();
//                        String montant = obj.get("montant").toString();
//                        String typeTransaction = obj.get("typeTransaction").toString();
//
//                         re.setId((int)id);                       
//                         re.setRequestTo(requestTo);
//                         re.setRequestFrom(requestFrom);
//                         re.setMontant(montant); 
//                         re.setTypeTransaction(typeTransaction);
//
//                        //insert data into ArrayList result
//                        result.add(re);
//                        
//                    }
//
//                }catch(Exception ex) {
//
//                    ex.printStackTrace();
//                }
//            });
//
//          NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
//           System.out.println(" ones : "+result);
//            return result;
//
//
//        }
//
//
//      
//          //Delete 
//    public boolean deleteTransaction(float id ) {
//        String url = Statics.BASE_URL +"carte/bancaire/deleteDemandeCartesJSON/?id="+(int)id;
//
//        req.setUrl(url);
//
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//
//                    req.removeResponseCodeListener(this);
//            }
//        });
//
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return  resultOk;
//    }
//    }



package Services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import Entities.Transaction;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.events.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ServiceTransaction {
    
    //singleton 
    public static ServiceTransaction instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServiceTransaction getInstance() {
        if(instance == null )
            instance = new ServiceTransaction();
        return instance ;
    }
    
    
    
    public ServiceTransaction() {
        req = new ConnectionRequest();
        
    }
   
    //ajout 
    public void ajoutTransaction(Transaction transaction) {
        
        String url =Statics.BASE_URL+"addTransactionsJson/new?id=" 
                                         +transaction.getId()     
                                         +"&typeTransaction="+transaction.getTypeTransaction()                                                                                                              
                                         +"&requestTo="+transaction.getRequestTo()
                                         +"&requestFrom="+transaction.getRequestFrom()
                                         +"&montant="+transaction.getMontant(); 
        
        
        req.setUrl(url);
        req.addResponseListener((e) -> {            
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
     
    
     public ArrayList<Transaction>affichageTransaction()  {
        ArrayList<Transaction> result = new ArrayList<>();
        String  url = Statics.BASE_URL +"allTransactionsJson";
         req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;                
                jsonp = new JSONParser();
                 try {
                     //renvoi une map avec clé = root et valeur le reste
                    Map<String,Object> mapTransaction = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));

                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapTransaction.get("root");

                    for(Map<String, Object> obj : listOfMaps) {
                        Transaction re = new Transaction();
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
                        String requestTo = obj.get("requestTo").toString();
                        String requestFrom = obj.get("requestFrom").toString();
                        String montant = obj.get("montant").toString();
                        String typeTransaction = obj.get("typeTransaction").toString();

                         re.setId((int)id);                       
                         re.setRequestTo(requestTo);
                         re.setRequestFrom(requestFrom);
                         re.setMontant(montant); 
                         re.setTypeTransaction(typeTransaction);

                        //insert data into ArrayList result
                        result.add(re);
                      
                    }
                } 

       catch(Exception e ){
                       e.printStackTrace();
                   }
            }           
                });
        
         NetworkManager.getInstance().addToQueueAndWait(req);
                             
           return result;
    }

    
  //  {
//        
//        ArrayList<CarteBancaire> result = new ArrayList<>();
//        
//        String url = Statics.BASE_URL+"carte/bancaire/AllDemandeUser/CarteJson";
//        req.setUrl(url);
//        
//        req.addResponseListener((NetworkEvent evt) -> {
//            JSONParser jsonp ;
//            jsonp = new JSONParser();
//            
//            try {
//                Map<String,Object>mapCarteBancaire = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
//                
//                List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapCarteBancaire.get("root");
//                
//                for(Map<String, Object> obj : listOfMaps) {
//                    
//                    CarteBancaire re = new CarteBancaire();
//                    
//                    //dima id fi codename one float 5outhouha
//                    float id = Float.parseFloat(obj.get("id").toString());
//                    
//                    String email = obj.get("email").toString();
//                    
//                    String description = obj.get("description").toString();
//                    
//                    String identifier = obj.get("identifier").toString();
//                    
//                    String cinS1 = obj.get("cinS1").toString();
//                    
//                     String cinS2 = obj.get("cinS2").toString();
//                    
//                    re.setId((int)id);
//                    re.setEmail(email);
//                    re.setDescription(description);
//                    re.setIdentifier(identifier);
//                    re.setCinS1(cinS1);
//                    re.setCinS2(cinS2);
//                    
//                   
//                    
//                    //insert data into ArrayList result
//                    result.add(re);
//                    
//                    
//                }
//            
//            }catch(Exception ex) {
//                
//                ex.printStackTrace();
//            }
//        });
//        
//      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
//
//        return result;
//        
//        
//    }
     
    //Delete 
    public boolean deleteReclamation(float id ) {
        String url = Statics.BASE_URL +"deleteTransactionsJson/?id="+(int)id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
    
    
}
