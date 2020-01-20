package DesignPattern.filter_intercept_chain.domain;

import java.net.URL;

public class Request {
    public URL url;
    public String requestStr;

    public Request(String url) {
        try {
            this.url = new URL(url);
            requestStr = url;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("url is Illegal");
        }
    }

    public String getRequest() {
        return requestStr;
    }

    public void addParams(String paramKey, String paramValue) {
        requestStr = requestStr + "?" + paramKey + "=" + paramValue;
        try {
            this.url = new URL(requestStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("url is Illegal");
        }
    }


    @Override
    public String toString() {
        return "Request{" +
                "url='" + requestStr + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return requestStr.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return request.requestStr.equals(this.requestStr);
    }
}