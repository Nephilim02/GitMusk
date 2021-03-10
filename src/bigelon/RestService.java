/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigelon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;
import sun.misc.IOUtils;

/**
 *
 * @author ricca
 */
public class RestService {
  URL server;
  HttpsURLConnection service;
  BufferedReader input;
  BufferedWriter output;

  public RestService() {
    }
  
  public String GET(String url)
  {
    try{
    server = new URL(url);
    service = (HttpsURLConnection)(HttpURLConnection)server.openConnection();
    //service.setRequestProperty("Host", "127.0.0.1"); // impostazione header richiesta:  host

    service.setRequestProperty("Accept", "text/plain"); // impostazione header richiesta:  formato risposta
    service.setRequestProperty("Accept-Charset", "UTF-8"); // impostazione header richiesta:  codifica risposta
    service.setRequestProperty("User-Agent", "lmaoooooooooooo"); 

    service.setRequestMethod("GET"); // impostazione metodo di richiesta GET
    service.setDoInput(true); // attivazione ricezione
    service.connect(); // connessione al servizio
    int status = service.getResponseCode(); // verifica stato risposta
    if (status != 200) {
        return Integer.toString(status);
    }
    // apertura stream di ricezione da risorsa web
    input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));

    String s = input.lines().collect(Collectors.joining());
    input.close();
    return s;
    }catch(IOException e)
    {return "error";}
  }
  
  public String POST(String url,String body) throws ProtocolException, IOException{
    try {
      server = new URL(url);
      service = (HttpsURLConnection) server.openConnection();
      service.setRequestMethod("POST"); // PUT is another valid option
      service.setDoOutput(true);
      service.setDoInput(true); // attivazione ricezione
      byte[] out = body.getBytes(StandardCharsets.UTF_8);
      int length = out.length;

      service.setFixedLengthStreamingMode(length);
      service.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      service.setRequestProperty("User-Agent", "lmaoooooooooooo"); 
      service.connect();
      OutputStream os = service.getOutputStream();
      os.write(out);
      int status = service.getResponseCode(); // verifica stato risposta
      if (status != 200) {
          return Integer.toString(status);
      }
      // apertura stream di ricezione da risorsa web
      input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));

      String s = input.lines().collect(Collectors.joining());
      return s;
    } catch (MalformedURLException ex) {
      Logger.getLogger(RestService.class.getName()).log(Level.SEVERE, null, ex);
      return "error";
    }
    
  }
  
  public String PUT(String url,String body) throws ProtocolException, IOException{
    try {
      server = new URL(url);
      service = (HttpsURLConnection) server.openConnection();
      service.setRequestMethod("PUT"); // PUT is another valid option
      service.setDoOutput(true);
      service.setDoInput(true); // attivazione ricezione
      byte[] out = body.getBytes(StandardCharsets.UTF_8);
      int length = out.length;

      service.setFixedLengthStreamingMode(length);
      service.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      service.setRequestProperty("User-Agent", "lmaoooooooooooo"); 
      service.connect();
      OutputStream os = service.getOutputStream();
      os.write(out);
      int status = service.getResponseCode(); // verifica stato risposta
      if (status != 200) {
          return Integer.toString(status);
      }
      // apertura stream di ricezione da risorsa web
      input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));

      String s = input.lines().collect(Collectors.joining());
      return s;
    } catch (MalformedURLException ex) {
      Logger.getLogger(RestService.class.getName()).log(Level.SEVERE, null, ex);
      return "error";
    }
    
  }
  
  public String DELETE(String url,String body) throws ProtocolException, IOException{
    try {
      server = new URL(url);
      service = (HttpsURLConnection) server.openConnection();
      service.setRequestMethod("DELETE"); // PUT is another valid option
      service.setDoOutput(true);
      service.setDoInput(true); // attivazione ricezione
      byte[] out = body.getBytes(StandardCharsets.UTF_8);
      int length = out.length;

      service.setFixedLengthStreamingMode(length);
      service.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      service.setRequestProperty("User-Agent", "lmaoooooooooooo"); 
      service.connect();
      OutputStream os = service.getOutputStream();
      os.write(out);
      int status = service.getResponseCode(); // verifica stato risposta
      if (status != 200) {
          return Integer.toString(status);
      }
      // apertura stream di ricezione da risorsa web
      input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));

      String s = input.lines().collect(Collectors.joining());
      return s;
    } catch (MalformedURLException ex) {
      Logger.getLogger(RestService.class.getName()).log(Level.SEVERE, null, ex);
      return "error";
    }
    
  }
}
