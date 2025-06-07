package D_dependency_inversion_dependency;

class MYSQLDB{
    public void saveToDataSQL(){
        System.out.println("Data save in MySql DB");
    }
}
class MongoDB {
    public void saveToData(){
        System.out.println("Data save in Mongo DB");
    }
}

class Application{
    private MYSQLDB mysqldb;
    private MongoDB mongoDB;

    public Application(MYSQLDB mysqldb, MongoDB mongoDB){
        this.mysqldb=mysqldb;
        this.mongoDB=mongoDB;
    }

    public void saveToSQL(){
        mysqldb.saveToDataSQL();
    }
    public void saveToMongo(){
        mongoDB.saveToData();
    }
}

public class DIPViolated {
    public static void main(String[] args) {
        MYSQLDB mysqldb = new MYSQLDB();
        MongoDB mongoDB = new MongoDB();
        Application application = new Application(mysqldb,mongoDB);
        application.saveToMongo();
        application.saveToSQL();
    }
}
