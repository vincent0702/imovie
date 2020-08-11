package com.web.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Survey")
public class SurveyBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer surveySeq;
	private String orderNo;
	private String date;
	private Integer satisfaction;
	@Column(updatable = true,nullable = true, columnDefinition = "varchar(max)")
	private String comment;
	private String commentTime;
	
	public SurveyBean() {
	}

	public SurveyBean(Integer surveySeq, String orderNo, String date, Integer satisfaction, String comment,
			String commentTime) {
		super();
		this.surveySeq = surveySeq;
		this.orderNo = orderNo;
		this.date = date;
		this.satisfaction = satisfaction;
		this.comment = comment;
		this.commentTime = commentTime;
	}

	public Integer getSurveySeq() {
		return surveySeq;
	}

	public void setSurveySeq(Integer surveySeq) {
		this.surveySeq = surveySeq;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(Integer satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	
}
