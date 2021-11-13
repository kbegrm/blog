package com.kem.blog.model;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class CascadingComment extends Comment{

    @ManyToOne(fetch = FetchType.LAZY)
    private CascadingComment replyTo;
    @OneToMany(mappedBy = "replyTo")
    private List<CascadingComment> replies;

    public CascadingComment getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(CascadingComment replyTo) {
        this.replyTo = replyTo;
    }

    public List<CascadingComment> getReplies() {
        return replies;
    }

    public void setReplies(List<CascadingComment> replies) {
        this.replies = replies;
    }
}
