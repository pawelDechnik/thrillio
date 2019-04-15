package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.constans.KidFriendlyStatus;

public abstract class Bookmark {
	private long id;
	private String title;
	private String profileUrl;
	private String kidFriendlyStatus=KidFriendlyStatus.UNKNOWN;
	private User UserkidFriendlyMarkedBy;
	private User SharedBy;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getKidFriendlyStatus() {
		return kidFriendlyStatus;
	}

	public void setKidFriendlyStatus(String kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
	}

	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", title=" + title + ", profileUrl=" + profileUrl + "]";
	}
	public abstract boolean isKidFriendlyEligible();

	public User getKidFriendlyMarkedBy() {
		return UserkidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(User userkidFriendlyMarkedBy) {
		UserkidFriendlyMarkedBy = userkidFriendlyMarkedBy;
	}

	public User getSharedBy() {
		return SharedBy;
	}

	public void setSharedBy(User sheredBy) {
		SharedBy = sheredBy;
	}
}
