package main.java;

import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMessage {
    private String from;
    private LinkedList<String> to;
    private String subject;
    private String content;
    private String mimeType;
    private LinkedList<String> cc;
    private LinkedList<String> bcc;

    public String getFrom() {
        return from;
    }

    public LinkedList<String> getTo() {
        return to;
    }

    public LinkedList<String> getBcc() {
        return bcc;
    }

    public LinkedList<String> getCc() {
        return cc;
    }

    public String getContent() {
        return content;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getSubject() {
        return subject;
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }


    protected EmailMessage(String from, LinkedList<String> to, String subject, String content, String mimeType, LinkedList<String> cc, LinkedList<String> bcc){
        this.from=from;
        this.to=to;
        this.subject=subject;
        this.content=content;
        this.mimeType=mimeType;
        this.cc=cc;
        this.bcc=bcc;

    }


    public static class Builder {
        private String fromb;
        private LinkedList<String> tob;
        private String subjectb;
        private String contentb;
        private String mimeTypeb;
        private LinkedList<String> ccb;
        private LinkedList<String> bccb; 

        public Builder addFrom(String nadawca) throws IOException {
            Pattern pattern = Pattern.compile("(\\w|\\.|\\|!|#|$|%|&|^|'|\\*|\\+|-|\\\\|=|\\?|\\{|\\|}|~|`|(\"\\ |(|)|,|:|;|<|>|@|\"))+@.+\\.([a-z]|\\.)+");
            Matcher matcher = pattern.matcher((CharSequence) nadawca);
            if (matcher.matches()) {
                fromb=nadawca;
                return this;
            } else {
                throw new IOException("no email or your email is invalid");
            }
        }

        public Builder addTo(LinkedList<String> adresat) throws IOException {
            Pattern pattern = Pattern.compile("(\\w|\\.|\\|!|#|$|%|&|^|'|\\*|\\+|-|\\\\|=|\\?|\\{|\\|}|~|`|(\"\\ |(|)|,|:|;|<|>|@|\"))+@.+\\.([a-z]|\\.)+");
            if(tob==null){
                tob=new LinkedList<String>();
            }
            for (String n : adresat) {
                Matcher matcher = pattern.matcher((CharSequence) n);
                if (matcher.matches()) {
                    tob.add(n);
                }
            }
            if (tob.size() == 0) {
                throw new IOException("no email or your email is invalid");
            } else {
                return this;
            }}

        public Builder addTo(String adresat) throws IOException {
            Pattern pattern = Pattern.compile("(\\w|\\.|\\|!|#|$|%|&|^|'|\\*|\\+|-|\\\\|=|\\?|\\{|\\|}|~|`|(\"\\ |(|)|,|:|;|<|>|@|\"))+@.+\\.([a-z]|\\.)+");
            Matcher matcher = pattern.matcher((CharSequence) adresat);
            if(tob==null){
                tob=new LinkedList<String>();}
            if (matcher.matches()) {
                tob.add(adresat);
            }
            if (tob.size() == 0) {
                throw new IOException("no email or your email is invalid");
            } else {
                return this;
            }}



        public Builder addSubject(String subject_){
            subjectb=subject_;
            return this;
        }

        public Builder addContent(String content_){
            contentb=content_;
            return this;
        }
        public Builder addMimeType(String mime_){
            mimeTypeb=mime_;
            return this;
        }

        public Builder addCc(LinkedList<String> cc_) {
            if(ccb==null){
                ccb=new LinkedList<String>();
            }
            ccb=cc_;
            return this;
        }

        public Builder addBcc(LinkedList<String> bcc_) {
            if(bccb==null){
                bccb=new LinkedList<String>();
            }
            bccb=bcc_;
            return this;
        }

        public EmailMessage build(){
            {   EmailMessage email = new EmailMessage(this.fromb, this.tob, this.subjectb, this.contentb, this.mimeTypeb, this.ccb, this.bccb);
                return email;
            }
        }


    }
}