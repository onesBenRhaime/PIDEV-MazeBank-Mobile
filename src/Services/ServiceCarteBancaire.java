
package Services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import Entities.CarteBancaire;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceCarteBancaire {
    
    //singleton 
    public static ServiceCarteBancaire instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServiceCarteBancaire getInstance() {
        if(instance == null )
            instance = new ServiceCarteBancaire();
        return instance ;
    }
    
    
    
    public ServiceCarteBancaire() {
        req = new ConnectionRequest();
        
    }
   
    //ajout 
    public void ajoutCarteBancaire(CarteBancaire carteBancaire) {
        
        String url =Statics.BASE_URL+"/carte/bancaire/addDemandeCartes/JSON?id="+carteBancaire.getId()+"&email="+carteBancaire.getEmail()+"&identifier="+carteBancaire.getIdentifier()
                                                                                +"&description="+carteBancaire.getDescription()+"&cinS1="+carteBancaire.getCinS1()+"&cinS2="+carteBancaire.getCinS2();
        req.setUrl(url);
        req.addResponseListener((e) -> {            
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
     
    
     public ArrayList<CarteBancaire>affichageCarteBancaire() {
        
        ArrayList<CarteBancaire> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/carte/bancaire/AllDemandeUser/CarteJson";
        req.setUrl(url);
        
        req.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp ;
            jsonp = new JSONParser();
            
            try {
                Map<String,Object>mapReclamations = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                
                List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapReclamations.get("root");
                
                for(Map<String, Object> obj : listOfMaps) {
                    
                    CarteBancaire re = new CarteBancaire();
                    
                    //dima id fi codename one float 5outhouha
                    float id = Float.parseFloat(obj.get("id").toString());
                    
                    String email = obj.get("email").toString();
                    
                    String description = obj.get("description").toString();
                    
                    String identifier = obj.get("identifier").toString();
                    
                    re.setId((int)id);
                    re.setEmail(email);
                    re.setDescription(description);
                    re.setIdentifier(identifier);
                    
                   
                    
                    //insert data into ArrayList result
                    result.add(re);
                    
                    
                }
            
            }catch(Exception ex) {
                
                ex.printStackTrace();
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
        
    }
    
    
    
}
