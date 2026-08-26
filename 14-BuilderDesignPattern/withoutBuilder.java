import java.util.*;

class HttpRequest{
    private String method;                                          // Required
    private String url;                                             // required
    private Map<String,String> headers;
    private Map<String,String> params;
    private String body;
    private int timeout;                                           // required

    public HttpRequest(String url){
        this.url = url;
        this.method= "GET";
        this.timeout = 30;
        this.headers = new HashMap<>();
        this.params = new HashMap<>();  
    }

    public HttpRequest(String url,String method){
        this.url = url;
        this.method = method;
        this.timeout = 30;
        this.headers = new HashMap<>();
        this.params = new HashMap<>();  
    }

    public HttpRequest(String url,String method, int timeout){
        this.url = url;
        this.method= method;
        this.timeout = timeout;
        this.headers = new HashMap<>();
        this.params = new HashMap<>();  
    }

    public HttpRequest(String url,String method, int timeout,Map<String,String> headers){
        this.url = url;
        this.method= method;
        this.timeout = timeout;
        this.headers = headers;
        this.params = new HashMap<>(); 
    }


    public HttpRequest(String url,String method, int timeout,Map<String,String> headers, Map<String,String> params){
        this.url = url;
        this.method= method;
        this.timeout = timeout;
        this.headers = headers;
        this.params = params;  
    }

    public HttpRequest(String url,String method, int timeout,Map<String,String> headers, Map<String,String> params,String body){
        this.url = url;
        this.method= method;
        this.timeout = timeout;
        this.headers = headers;
        this.params = params;  
        this.body = body;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void setMethod(String method){
        this.method = method;
    }

    public void setTimeout(int timeout){
        this.timeout = timeout;
    }

    public void setHeaders(Map<String,String> headers){
        this.headers = headers;
    }
    public void setParams(Map<String,String> params){
        this.params = params;
    }

    public void setBody(String body){
        this.body = body;
    }

    public void execute(){
        System.out.println("Executing Http request with the following parameters:");
        System.out.println("URL: " + url);
        System.out.println("Method: " + method);
        System.out.println("Timeout: " + timeout);
        System.out.println("Headers: " + headers);
        System.out.println("Params: " + params);
        System.out.println("Body: " + body);
    }

}



public class withoutBuilder {
    public static void main(String[] args){
    HttpRequest request1 = new HttpRequest("https://example.com/api", "POST", 60);  
     request1.execute();
    }
}
