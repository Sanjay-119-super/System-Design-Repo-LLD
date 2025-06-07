package D_dependency_inversion_dependency;

interface Database{
    void saveToDb();
}

class MySql implements Database{

    @Override
    public void saveToDb() {
        System.out.println("Data save in MySql DB");
    }
}

class MongoDb implements Database{

    @Override
    public void saveToDb() {
        System.out.println("Data save in Mongo db");
    }
}
class App{
    private Database database;

    public App(Database database){
        this.database=database;
    }

    public void save(){
        database.saveToDb();
    }


}
public class DIPFollow {
    public static void main(String[] args) {
        MySql mySql = new MySql();
        App app = new App(mySql);
        app.save();

    }
}
