

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class clientOperation {
    private static Map<Integer, client> clients = new HashMap<>();
    private static AtomicInteger atomic = new AtomicInteger();

    public static Collection<client> getAllClients(){
        return clients.values();
    }

    public static client getClientById(Integer id){
        return clients.get(id);        
    }

    public static String addClient(client client){
        client.setId(atomic.incrementAndGet());
        clients.put(client.getId(), client);
        return "Client Added Successfully!";
    }

    public static String updateClient(Integer id, client client){
        clients.put(id,client);
        return "Client Updated Successfully!";
    }

    public static String deleteClient(Integer id){
        clients.remove(id);
        return "Client Deleted Successfully!";
    }
}

