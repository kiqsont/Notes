package Flyweight.example;

import java.util.Hashtable;

public class WebSiteFactory {
    private Hashtable<String,WebSite> webSites = new Hashtable<>();

    public WebSite getWebSite(String key)
    {
        if(!webSites.containsKey(key))
        {
            webSites.put(key,new ConcreteWebSite(key));
        }
        return webSites.get(key);
    }

    public int getWebSiteCount()
    {
        return webSites.size();
    }
}
