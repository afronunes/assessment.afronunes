package com.enterprisealumni.assessment.afronunes.service.type;

public enum DirectoryType {

    INPUT("files/input/"), OUTPUT("files/output/");

    private String path;

    DirectoryType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
