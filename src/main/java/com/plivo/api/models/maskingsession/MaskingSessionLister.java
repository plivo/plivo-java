package com.plivo.api.models.maskingsession;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.VoiceLister;
import retrofit2.Call;

public class MaskingSessionLister extends VoiceLister<MaskingSession> {
  private String firstParty;
  private String secondParty;
  private String virtualNumber;
  private String status;
  private String createdTime;
  private String createdTimeLt;
  private String createdTimeGt;
  private String createdTimeLte;
  private String createdTimeGte;
  private String expiryTime;
  private String expiryTimeLt;
  private String expiryTimeGt;
  private String expiryTimeLte;
  private String expiryTimeGte;
  private String subaccount;
  private Integer duration;
  private Integer durationLt;
  private Integer durationGt;
  private Integer durationLte;
  private Integer durationGte;

  @Override
  protected Call<ListResponse<MaskingSession>> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().maskingSessionList(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListResponse<MaskingSession>> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().maskingSessionList(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListResponse<MaskingSession>> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().maskingSessionList(client().getAuthId(), toMap());
  }

  public String firstParty() {
    return this.firstParty;
  }
  public MaskingSessionLister firstParty(final String firstParty) {
    this.firstParty = firstParty;
    return this;
  }
  public String secondParty() {
    return this.secondParty;
  }
  public MaskingSessionLister secondParty(final String secondParty) {
    this.secondParty = secondParty;
    return this;
  }
  public String virtualNumber() {
    return this.virtualNumber;
  }
  public MaskingSessionLister virtualNumber(final String virtualNumber) {
    this.virtualNumber = virtualNumber;
    return this;
  }
  public String status() {
    return this.status;
  }
  public MaskingSessionLister status(final String status) {
    this.status = status;
    return this;
  }
  public String createdTime() {
    return this.createdTime;
  }
  public MaskingSessionLister createdTime(final String createdTime) {
    this.createdTime = createdTime;
    return this;
  }
  public String createdTimeLt() {
    return this.createdTimeLt;
  }
  public MaskingSessionLister createdTimeLt(final String createdTimeLt) {
    this.createdTimeLt = createdTimeLt;
    return this;
  }
  public String createdTimeGt() {
    return this.createdTimeGt;
  }
  public MaskingSessionLister createdTimeGt(final String createdTimeGt) {
    this.createdTimeGt = createdTimeGt;
    return this;
  }
  public String createdTimeLte() {
    return this.createdTimeLte;
  }
  public MaskingSessionLister createdTimeLte(final String createdTimeLte) {
    this.createdTimeLte = createdTimeLte;
    return this;
  }
  public String createdTimeGte() {
    return this.createdTimeGte;
  }
  public MaskingSessionLister createdTimeGte(final String createdTimeGte) {
    this.createdTimeGte = createdTimeGte;
    return this;
  }
  public String expiryTime() {
    return this.expiryTime;
  }
  public MaskingSessionLister expiryTime(final String expiryTime) {
    this.expiryTime = expiryTime;
    return this;
  }
  public String expiryTimeLt() {
    return this.expiryTimeLt;
  }
  public MaskingSessionLister expiryTimeLt(final String expiryTimeLt) {
    this.expiryTimeLt = expiryTimeLt;
    return this;
  }
  public String expiryTimeGt() {
    return this.expiryTimeGt;
  }
  public MaskingSessionLister expiryTimeGt(final String expiryTimeGt) {
    this.expiryTimeGt = expiryTimeGt;
    return this;
  }
  public String expiryTimeLte() {
    return this.expiryTimeLte;
  }
  public MaskingSessionLister expiryTimeLte(final String expiryTimeLte) {
    this.expiryTimeLte = expiryTimeLte;
    return this;
  }
  public String expiryTimeGte() {
    return this.expiryTimeGte;
  }
  public MaskingSessionLister expiryTimeGte(final String expiryTimeGte) {
    this.expiryTimeGte = expiryTimeGte;
    return this;
  }
  public String subaccount() {
    return this.subaccount;
  }
  public MaskingSessionLister subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }
  public int duration() {
    return this.duration;
  }
  public MaskingSessionLister duration(final int duration) {
    this.duration = duration;
    return this;
  }
  public int durationLt() {
    return this.durationLt;
  }
  public MaskingSessionLister durationLt(final int durationLt) {
    this.durationLt = durationLt;
    return this;
  }
  public int durationGt() {
    return this.durationGt;
  }
  public MaskingSessionLister durationGt(final int durationGt) {
    this.durationGt = durationGt;
    return this;
  }
  public int durationLte() {
    return this.durationLte;
  }
  public MaskingSessionLister durationLte(final int durationLte) {
    this.durationLte = durationLte;
    return this;
  }
  public int durationGte() {
    return this.durationGte;
  }
  public MaskingSessionLister durationGte(final int durationGte) {
    this.durationGte = durationGte;
    return this;
  }
}
