/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.type;

/**
 * Defines directory type. In a future implementation those could be load from properties
 */
public enum DirectoryType {

    INPUT("files/input/"), OUTPUT("files/output/");

    private final String path;

    DirectoryType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
