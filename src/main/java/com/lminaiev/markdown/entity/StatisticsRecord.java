package com.lminaiev.markdown.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Statistics Record Entity
 */
@Document
public class StatisticsRecord {
    @Id
    private String id;
    private String username;
    private Date date;
    private String sourceText;
    private String html;

    public StatisticsRecord(String username, Date date, String sourceText, String html) {
        this.username = username;
        this.date = date;
        this.sourceText = sourceText;
        this.html = html;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatisticsRecord that = (StatisticsRecord) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (sourceText != null ? !sourceText.equals(that.sourceText) : that.sourceText != null) return false;
        return html != null ? html.equals(that.html) : that.html == null;

    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Date getDate() {
        return date;
    }

    public String getSourceText() {
        return sourceText;
    }

    public String getHtml() {
        return html;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (sourceText != null ? sourceText.hashCode() : 0);
        result = 31 * result + (html != null ? html.hashCode() : 0);
        return result;
    }
}
