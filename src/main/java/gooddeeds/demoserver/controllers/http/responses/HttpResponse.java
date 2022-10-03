package gooddeeds.demoserver.controllers.http.responses;

public class HttpResponse {
    public boolean isSuccess;
    public Object data;
    public String errorMessage;

    public HttpResponse(Object data)
    {
        this.isSuccess = true;
        this.data = data;
    }

    public HttpResponse(String errorMessage)
    {
        this.isSuccess = false;
        this.errorMessage = errorMessage;
    }
}
