package com.example;

import jakarta.xml.ws.Endpoint;

public class Publisher {

    public static void main(String[] args) {

        String url = "http://localhost:8089/ws/Calculator";

        Endpoint.publish(url, new CalculatorImpl());

        System.out.println("SOAP Calculator published at: " + url);
        System.out.println("WSDL: " + url + "?wsdl");
    }
}