package com.example.barrierfreetrip.touristfacility.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "touristFacility")
@Data
public class TouristFacility {

    @Id
    private String contentId;
	private String contentTypeId;
	private String title;
	private String addr1;
	private String addr2;
	private String overview;
	private String homepage;
	private String tel;
	private String checkInTime;
	private String checkOutTime;
	private String parking;
	private Long rating;
	private String areaCode;
	private String sigunguCode;
	private double mapx;
	private double mapy;

	private String firstimage;

	@OneToOne
	@JoinColumn(name = "contentId")
	private BarrierFreeFacility barrierFreeFacility;
}
