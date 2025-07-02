// Interface jo client ko chahiye hota hai report lene ke liye
// Yeh interface har us class ke liye contract hai jo JSON format me data provide karega
public interface IReport {

    /**
     * Input string ko JSON format me convert karta hai
     *
     * @param data Raw input string — jaise "name:id"
     * @return JSON string — jaise {"name":"Demo","id":119}
     *
     * Example:
     * Input  → "Demo:119"
     * Output → {"name":"Demo","id":119}
     */
    String getJsonData(String data);
}
// Purana ya third-party XML-based data provider
// Yeh class legacy hai (isse modify nahi kar sakte) aur XML format me data deti hai
class XmlDataProvider {

    /**
     * Raw input ko XML format me convert karta hai
     *
     * @param data Input string jaise "name:id"
     * @return XML format string jaise <user><name>Demo</name><id>119</id></user>
     */
    String getXmlData(String data) {
        int sep = data.indexOf(':');
        String name = data.substring(0, sep);
        String id = data.substring(sep + 1);

        return "<user>"
                + "<name>" + name + "</name>"
                + "<id>" + id + "</id>"
                + "</user>";
    }
}

// Adapter class jo XmlDataProvider ko IReport ke compatible banata hai
// Yeh bridge banata hai old XML system aur naye JSON interface ke beech
class XmlDataProviderAdapter implements IReport {

    private final XmlDataProvider xmlDataProvider;

    /**
     * Adapter class ko legacy XML provider object diya jata hai
     *
     * @param xmlDataProvider Purani XML wali class ka object
     */
    public XmlDataProviderAdapter(XmlDataProvider xmlDataProvider) {
        this.xmlDataProvider = xmlDataProvider;
    }

    /**
     * XML data ko JSON format me convert karta hai
     *
     * @param data Raw input jaise "Demo:119"
     * @return Converted JSON string jaise {"name":"Demo","id":119}
     */
    @Override
    public String getJsonData(String data) {
        // Step 1: Pehle XML data le lo from legacy class
        String xmlData = xmlDataProvider.getXmlData(data);

        // Step 2: XML string ko manually parse kar rahe (real projects me parser use hota hai)
        int startName = xmlData.indexOf("<name>") + 6;
        int endName = xmlData.indexOf("</name>");
        String name = xmlData.substring(startName, endName);

        int startId = xmlData.indexOf("<id>") + 4;
        int endId = xmlData.indexOf("</id>");
        String id = xmlData.substring(startId, endId);

        //Step 3: JSON string bana ke return karo
        return "{\"name\":\"" + name + "\",\"id\":" + id + "}";
    }
}
// Client class jo report data sirf JSON format me lena chahta hai
// Yeh class sirf IReport interface ko jaanti hai, andar ke adapter ya XML se koi lena dena nahi
class Client {

    /**
     * Report ko JSON format me print karta hai using IReport interface
     *
     * @param report IReport ka implementation — adapter ya koi aur class
     * @param rowData Raw input data string — jaise "Demo:119"
     */
    public void getReport(IReport report, String rowData) {
        System.out.println("Processing Report as JSON: " + report.getJsonData(rowData));
    }
}
//  Main class jahan Adapter Pattern implement ho raha hai
// Yeh flow dikhata hai kaise legacy system ko adapter se connect karke client ko JSON diya jata hai
class AdapterPattern {

    public static void main(String[] args) {

        // Step 1: Legacy XML data provider ka object
        XmlDataProvider xmlDataProvider = new XmlDataProvider();

        // Step 2: Adapter banaya jo XML data ko JSON me convert kare
        IReport adapter = new XmlDataProviderAdapter(xmlDataProvider);

        // Step 3: Raw input data string
        String rowData = "Demo:119";

        // Step 4: Client ko bas JSON chahiye, adapter uske liye bridge ban gaya
        Client client = new Client();
        client.getReport(adapter, rowData);

        // Output: Processing Report as JSON: {"name":"Demo","id":119}
    }
}
