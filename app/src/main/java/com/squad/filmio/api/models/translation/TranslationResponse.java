package com.squad.filmio.api.models.translation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TranslationResponse implements Serializable {
    private int id;
    List<Translation> translations = new ArrayList<>();


    // Getter Methods

    public int getId() {
        return id;
    }

    public List<Translation> getTranslations() {
        return translations;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        return "TranslationResult{" +
                "id=" + id +
                ", translations=" + translations +
                '}';
    }
}