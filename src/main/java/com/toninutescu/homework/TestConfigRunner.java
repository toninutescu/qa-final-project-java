package com.toninutescu.homework;

public class TestConfigRunner {
    public static void main(String[] args) {
        BrowserConfig c1 = new BrowserConfig(BrowserType.EDGE, "129.0", true);
        BrowserConfig c2 = new BrowserConfig(BrowserType.FIREFOX, "128.0");
        BrowserConfig c3 = new BrowserConfig(BrowserType.CHROME);
        BrowserConfig c4 = BrowserConfig.createDefaultChromeConfig();

        c1.afiseazaConfig();
        c2.afiseazaConfig();
        c3.afiseazaConfig();
        c4.afiseazaConfig();
    }
}