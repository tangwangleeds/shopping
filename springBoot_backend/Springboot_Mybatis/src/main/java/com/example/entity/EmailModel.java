package com.example.entity;

public class EmailModel {

    private  String    subject;
    // 设置邮件发送者，这个跟application.yml中设置的要一致
    private  String     from;
    // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
    // message.setTo("10*****16@qq.com","12****32*qq.com");
    private  String     to;
    // 设置邮件抄送人，可以有多个抄送人
    private  String     cc;
    // 设置隐秘抄送人，可以有多个
    private  String     bcc;
    // 设置邮件发送日期
    private  String     sentDate;
    // 设置邮件的正文
    private  String     text;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
