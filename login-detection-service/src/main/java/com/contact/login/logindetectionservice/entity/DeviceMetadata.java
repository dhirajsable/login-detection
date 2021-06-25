package com.contact.login.logindetectionservice.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "devicemetadata", schema = "public")
public class DeviceMetadata {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  long id;

  @Column(name = "userid")
  private long userId;

  @Column(name = "devicedetails")
  private String deviceDetails;

  @Column(name = "location")
  private String location;

  @Column(name = "lastloggedin")
  private Date lastLoggedIn;

  @Column(name = "createddate", nullable = false, updatable = false)
  @CreationTimestamp
  private Date createdDate;

  @Column(name = "updatedate", nullable = false)
  @CreationTimestamp
  private Date updatedate;

  @Column(name = "isdeviceverified")
  private boolean isDeviceVerified;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getDeviceDetails() {
    return deviceDetails;
  }

  public void setDeviceDetails(String deviceDetails) {
    this.deviceDetails = deviceDetails;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Date getLastLoggedIn() {
    return lastLoggedIn;
  }

  public void setLastLoggedIn(Date lastLoggedIn) {
    this.lastLoggedIn = lastLoggedIn;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getUpdatedate() {
    return updatedate;
  }

  public void setUpdatedate(Date updatedat) {
    this.updatedate = updatedat;
  }

  public boolean isDeviceVerified() {
    return isDeviceVerified;
  }

  public void setDeviceVerified(boolean deviceVerified) {
    isDeviceVerified = deviceVerified;
  }
}
