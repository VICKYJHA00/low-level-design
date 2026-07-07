interface Reports {
    String getJsonData(String data);
}

class XmlDataProvider {

    String getXmlData(String data) {
        int sep = data.indexOf(":");
        String name = data.substring(0, sep);
        String id = data.substring(sep + 1);

        return "<user>"
                + "<name>" + name + "</name>"
                + "<id>" + id + "</id>"
                + "</user>";
    }
}

class XmlDataProviderAdapter implements Reports {

    private XmlDataProvider xmlProvider;

    public XmlDataProviderAdapter(XmlDataProvider provider) {
        this.xmlProvider = provider;
    }

    @Override
    public String getJsonData(String data) {

        String xml = xmlProvider.getXmlData(data);

        int startName = xml.indexOf("<name>") + 6;
        int endName = xml.indexOf("</name>");
        String name = xml.substring(startName, endName);

        int startId = xml.indexOf("<id>") + 4;
        int endId = xml.indexOf("</id>");
        String id = xml.substring(startId, endId);

        return "{\"name\":\"" + name + "\",\"id\":\"" + id + "\"}";
    }
}

class Client {

    public void getReport(Reports report, String rawData) {
        System.out.println("Processed Json: " + report.getJsonData(rawData));
    }
}

public class AdapterPattern {

    public static void main(String[] args) {

        XmlDataProvider provider = new XmlDataProvider();

        Reports adapter = new XmlDataProviderAdapter(provider);

        Client client = new Client();

        client.getReport(adapter, "John:123");
    }
}