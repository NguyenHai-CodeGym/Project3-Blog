package model;

import java.time.LocalDateTime;

public class Post {
    private int id;
    private String title;
    private String fullContent;
    private String shortContent;
    private LocalDateTime publishDate;
    private String image;
    private Category category;

    public Post(){}

    public Post(String title, String fullContent, String shortContent, String image, Category category) {
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.image = image;
        this.category = category;
    }

    public Post(int id, String title, String fullContent, String shortContent, LocalDateTime publishDate, String image, Category category) {
        this.id = id;
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.publishDate = publishDate;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", fullContent='" + fullContent + '\'' +
                ", shortContent='" + shortContent + '\'' +
                ", publishDate=" + publishDate +
                ", image='" + image + '\'' +
                ", category=" + category +
                '}';
    }
}

