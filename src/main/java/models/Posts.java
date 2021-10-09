package models;

public class Posts {
    private Long postId;
    private Long id;
    private String name;
    private String body;
    private String email;


    @Override
    public String toString() {
        return "models.Posts{" +
                "\npostId=" + postId +
                ",\nid=" + id +
                ",\nname='" + name + '\'' +
                ",\nbody='" + body + '\'' +
                ",\nemail='" + email + '\'' +
                "\n}";
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
