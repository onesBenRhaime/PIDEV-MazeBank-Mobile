
    package Services;

    import com.codename1.io.ConnectionRequest;
    import com.codename1.io.NetworkManager;
    import Entities.Transaction;
    import Utils.Statics;
    import com.codename1.io.CharArrayReader;
    import com.codename1.io.JSONParser;
    import com.codename1.io.NetworkEvent;
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

     //Aff Liste Transaction
         public ArrayList<Transaction>affichageTransaction() {

            ArrayList<Transaction> result = new ArrayList<>();

            String url = Statics.BASE_URL+"/transactions/AllTransactionsJson";
            req.setUrl(url);

            req.addResponseListener((NetworkEvent evt) -> {
                JSONParser jsonp ;
                jsonp = new JSONParser();

                try {
                    Map<String,Object>mapReclamations = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));

                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapReclamations.get("root");

                    for(Map<String, Object> obj : listOfMaps) {

                        Transaction re = new Transaction();

                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());

                        String agenceName = obj.get("agenceName").toString();

                        String statue = obj.get("statue").toString();

                        String requestTo = obj.get("requestTo").toString();
                        String requestFrom = obj.get("requestFrom").toString();
                        String montant = obj.get("montant").toString();
                        String typeTransaction = obj.get("typeTransaction").toString();

                        re.setId((int)id);
                        re.setAgenceName(agenceName);
                        re.setStatue(statue);
                        re.setRequestTo(requestTo);
                         re.setRequestFrom(requestFrom);
                         re.setMontant(montant); 
                         re.setTypeTransaction(typeTransaction);

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
