import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class JavaServerHTTP {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);
	server.createContext("/", new HomeRouteHandler());
	server.setExecutor(null);
	server.start();
    }

    static class HomeRouteHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange t) throws IOException {
	    String res = "JavaServerHTTP CTF";
	    t.sendResponseHeaders(200, res.length());
	    OutputStream os = t.getResponseBody();
	    os.write(res.getBytes());
	    os.close();
	}
    }
}
