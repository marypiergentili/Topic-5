package mongodbfinal;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;


public class MongoDBConnection {
	
	private static MongoClient mongoClient=null;
	private static MongoDBConnection mongoConnection= null;
	
	private MongoDBConnection(String host, int port){
		mongoClient = new MongoClient(host, port);
	}
	
	public static MongoDBConnection getInstance(){
		if (mongoClient == null){
			try{
				mongoConnection= new MongoDBConnection("localhost",27017);
				System.out.println("Connection has been established");
			}
			//catch (UnknownHostException e) {
			//e.printStackTrace();
			//}
		    catch (MongoException e) {
			e.printStackTrace();
		    }
		}
		else{
			System.out.println("There is an other connection running");
		}
		return mongoConnection;
	}
	
	public void closeMongoDBConnection(){
		if (mongoClient != null){
			mongoConnection.closeMongoDBConnection();
			System.out.println("Closed.");
		}
	}
}
