
    import java.util.Collection;
import java.util.Scanner;

public class clientManagement {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Swilry Script Studio|Calligraphy&Engraving|Pune");

        while(true){
            System.out.println("SELECT THE OPERATION TO PERFORM FROM THE FOLLOWING MENU:");
            System.out.println("1. DISPLAY ALL CLIENT DETAILS");
            System.out.println("2. ADD NEW CLIENT DETAILS");
            System.out.println("3. DISPLAY SINGLE CLIENT DETAILS");
            System.out.println("4. UPDATE CLIENT DETAILS");
            System.out.println("5. DELETE CLIENT DETAILS");
            System.out.println("0. EXIT MENU");

            System.out.print("ENTER YOUR CHOICE: ");
            int choice = s.nextInt();

            String name, email, course;
            int id;
            client cli;

            if(choice == 0)
                break;

            else{
                switch(choice){
                    case 1: Collection<client> clients = clientOperation.getAllClients();
                            System.out.println("ID\tNAME\tEMAIL\tCOURSE");
                            for(client c : clients){
                                System.out.println(c.getId() + "\t" 
                                                + c.getName() + "\t" 
                                                + c.getEmail() + "\t"
                                                + c.getCourse());
                            }
                            break;
                    case 2: System.out.print("client Name: ");
                            name = s.next();
                            System.out.print("client Email: ");
                            email = s.next();
                            System.out.print("client Course: ");
                            course = s.next();
                            cli = new client(name, email, course);
                            clientOperation.addClient(cli);
                            break;
                    case 3: System.out.print("Enter ID of the Client: ");
                            id = s.nextInt();
                            cli = clientOperation.getClientById(id);
                            if(cli == null){
                                System.out.println("CLIENT WITH THIS ID DOES NOT EXISTS");
                            }
                            else{
                                System.out.println("ID: " + cli.getId()
                                                +"\nNAME: " + cli.getName()
                                                +"\nEMAIL: " + cli.getEmail()
                                                +"\nCOURSE: " + cli.getCourse());
                            }
                            break;
                    case 4: System.out.print("Enter ID of the client: ");
                            id = s.nextInt();
                            cli = clientOperation.getClientById(id);
                            if(cli == null){
                                System.out.println("CLIENT WITH THIS ID DOES NOT EXISTS");
                            }
                            else{
                                System.out.println("CHOOSE THE FIELD TO UPDATE:");
                                System.out.println("1. NAME");
                                System.out.println("2. EMAIL");
                                System.out.println("3. COURSE");
                                System.out.print("ENTER YOUR CHOICE: ");
                                choice = s.nextInt();
                                switch(choice){
                                    case 1: System.out.print("Client Name: ");
                                            name = s.next();
                                            cli.setName(name);
                                            break;
                                    case 2: System.out.print("Client Email: ");
                                            email = s.next();
                                            cli.setEmail(email);
                                            break;
                                    case 3: System.out.print("Client Course: ");
                                            course = s.next();
                                            cli.setCourse(course);
                                            break;
                                }
                                clientOperation.updateClient(id, cli);
                            }
                            break;
                    case 5: System.out.print("Enter ID of the client: ");
                            id = s.nextInt();
                            cli = clientOperation.getClientById(id);
                            if(cli == null){
                                System.out.println("CLIENT WITH THIS ID DOES NOT EXISTS");
                            }
                            else{
                                clientOperation.deleteClient(id);
                            }
                            break;
                    default:System.out.println("INVALID CHOICE!");
                }
            }
        }

        s.close();
    }
}

