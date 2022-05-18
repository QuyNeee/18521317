package com.example.dictionaries_18521317_18520943.Models;

import java.util.List;

public class Definitions {
    String definition = "";
    String example = "";
    List<String> synomyms = null;
    List<String> antomyms = null;

    public List<String> getSynomyms() {
        return synomyms;
    }

    public void setSynomyms(List<String> synomyms) {
        this.synomyms = synomyms;
    }

    public List<String> getAntomyms() {
        return antomyms;
    }

    public void setAntomyms(List<String> antomyms) {
        this.antomyms = antomyms;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
