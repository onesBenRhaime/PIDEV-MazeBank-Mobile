
package Services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import Entities.Transaction;
import Utils.Statics;


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
        
        String url =Statics.BASE_URL+"/transactions/addTransactionsJson/new?id="+transaction.getId()
                                    +"&agenceName="+transaction.getAgenceName()
                                    +"&statue="+transaction.getStatue()
                                    +"&requestTo="+transaction.getRequestTo()
                                    +"&requestFrom="+transaction.getRequestFrom()
                                    +"&montant="+transaction.getMontant()
                                    +"&typeTransaction="+transaction.getTypeTransaction()
                                    +"&compte="+transaction.getCompte();
        req.setUrl(url);
        req.addResponseListener((e) -> {            
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
    
    
}
